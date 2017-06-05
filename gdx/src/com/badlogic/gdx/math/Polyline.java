/*******************************************************************************
 * Copyright 2011 See AUTHORS file.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.badlogic.gdx.math;

public class Polyline implements Shape2D {

	private Vector2[] localVertices;
	private Vector2[] worldVertices;
	private Vector2 point;

	private Vector2 origin;
	private float rotation;
	private float scaleX = 1, scaleY = 1;
	private float length;
	private float scaledLength;
	private boolean calculateScaledLength = true;
	private boolean calculateLength = true;
	private boolean dirty = true;
	
	
	public Vector2 getPoint () {
		return point;
	}

	public void setPoint (Vector2 point) {
		this.point = point;
	}

	public Polyline () {
		localVertices = new Vector2[0];
	}

	public Polyline (Vector2[] vertices) {
		if (vertices.length < 2) throw new IllegalArgumentException("polylines must contain at least 2 points.");
		this.localVertices = vertices;
	}

	public Polyline (float[] vertices) {
		if (vertices.length < 4) throw new IllegalArgumentException("polylines must contain at least 2 points.");
		localVertices = new Vector2[vertices.length / 2];
		for (int i = 0; i < localVertices.length; i++) {
			localVertices[i].add(vertices[2 * i], vertices[2 * i + 1]);
		}
	}

	/** Returns vertices without scaling or rotation and without being offset by the polyline position. */
	public float[] getVertices () {
		float[] localVerticesArray = new float[localVertices.length * 2];
		for (int i = 0; i < localVertices.length; i++) {
			localVerticesArray[2 * i] = localVertices[i].getX();
			localVerticesArray[2 * i + 1] = localVertices[i].getY();
		}
		return localVerticesArray;
	}

	/** Returns vertices scaled, rotated, and offset by the polygon position. */
	public Vector2[] getTransformedVertices () {
		if (!dirty) return worldVertices;
		dirty = false;

		final Vector2[] localVertices = this.localVertices;
		if (worldVertices == null || worldVertices.length < localVertices.length) worldVertices = new Vector2[localVertices.length];

		final Vector2[] worldVertices = this.worldVertices;
		final Vector2 position = this.point;
		final Vector2 origin = this.origin;
		final float scaleX = this.scaleX;
		final float scaleY = this.scaleY;
		final float rotation = this.rotation;

		for (int i = 0, n = localVertices.length; i < n; i += 2) {
			Vector2 point = localVertices[i];
			point.sub(origin);
			point.scl(scaleX, scaleY);
			point.rotate(rotation);
			point.add(position);
			point.add(origin);
			worldVertices[i].set(point);
		}
		return worldVertices;
	}


	public float[] getTransfromedVertices(){
		if (dirty){
			this.getTransformedVertices();

		} 
	
		float[] Vertices=new float[worldVertices.length*2];
		for(int i=0;i<worldVertices.length;i++){
			Vertices[2*i]=worldVertices[i].getX();
			Vertices[2*i+1]=worldVertices[i].getY();
		}
		return Vertices;
		
	}
	/** Returns the euclidean length of the polyline without scaling */
	public float getLength () {
		if (!calculateLength) return length;
		calculateLength = false;

		length = 0;
		for (int i = 0, n = localVertices.length - 2; i < n; i += 2) {
			float x = localVertices[i + 1].getX() - localVertices[i].getX();
			float y = localVertices[i + 1].getY() - localVertices[i].getY();
			length += (float)Math.hypot(x, y);
		}

		return length;
	}

	/** Returns the euclidean length of the polyline */
	public float getScaledLength () {
		if (!calculateScaledLength) return scaledLength;
		calculateScaledLength = false;

		scaledLength = 0;
		for (int i = 0, n = localVertices.length - 2; i < n; i += 2) {
			float x = (localVertices[i + 1].getX() - localVertices[i].getX()) * scaleX;
			float y = (localVertices[i + 1].getY() - localVertices[i].getY()) * scaleY;
			scaledLength += (float)Math.hypot(x,y);
		}

		return scaledLength;
	}


	public float getOriginX () {
		return origin.getX();
	}

	public float getOriginY () {
		return origin.getY();
	}

	public float getRotation () {
		return rotation;
	}

	public float getScaleX () {
		return scaleX;
	}

	public float getScaleY () {
		return scaleY;
	}

	public void setOrigin (float originX, float originY) {
		origin.set(originX, originY);
		dirty = true;
	}

	public void setPosition (float x, float y) {
		point.set(x, y);
		dirty = true;
	}

	public void setVertices (float[] vertices) {
		if (vertices.length < 4) throw new IllegalArgumentException("polylines must contain at least 2 points.");
		localVertices = new Vector2[vertices.length / 2];
		for (int i = 0; i < localVertices.length; i++) {
			localVertices[i].add(vertices[2 * i], vertices[2 * i + 1]);
		}
		dirty = true;
	}

	public void setRotation (float degrees) {
		this.rotation = degrees;
		dirty = true;
	}

	public void rotate (float degrees) {
		rotation += degrees;
		dirty = true;
	}

	public void setScale (float scaleX, float scaleY) {
		this.scaleX = scaleX;
		this.scaleY = scaleY;
		dirty = true;
		calculateScaledLength = true;
	}

	public void scale (float amount) {
		this.scaleX += amount;
		this.scaleY += amount;
		dirty = true;
		calculateScaledLength = true;
	}

	public void calculateLength () {
		calculateLength = true;
	}

	public void calculateScaledLength () {
		calculateScaledLength = true;
	}

	public void dirty () {
		dirty = true;
	}

	public void translate (float x, float y) {
		point.add(x,y);
		dirty = true;
	}

	@Override
	public boolean contains (Vector2 point) {
		return false;
	}

	@Override
	public boolean contains (float x, float y) {
		return false;
	}
}
