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
			localVerticesArray[2 * i] = localVertices[i].x;
			localVerticesArray[2 * i + 1] = localVertices[i].y;
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
		final boolean scale = scaleX != 1 || scaleY != 1;
		final float rotation = this.rotation;
		final float cos = MathUtils.cosDeg(rotation);
		final float sin = MathUtils.sinDeg(rotation);

		for (int i = 0, n = localVertices.length; i < n; i += 2) {
			float x = localVertices[i].x - origin.x;
			float y = localVertices[i].y - origin.y;

			// scale if needed
			if (scale) {
				x *= scaleX;
				y *= scaleY;
			}

			// rotate if needed
			if (rotation != 0) {
				float oldX = x;
				x = cos * x - sin * y;
				y = sin * oldX + cos * y;
			}

			worldVertices[i].x = position.x + x + origin.x;
			worldVertices[i].y = position.y + y + origin.y;
		}
		return worldVertices;
	}

	/** Returns the euclidean length of the polyline without scaling */
	public float getLength () {
		if (!calculateLength) return length;
		calculateLength = false;

		length = 0;
		for (int i = 0, n = localVertices.length - 2; i < n; i += 2) {
			float x = localVertices[i + 1].x - localVertices[i].x;
			float y = localVertices[i + 1].y - localVertices[i].y;
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
			float x = (localVertices[i + 1].x - localVertices[i].x) * scaleX;
			float y = (localVertices[i + 1].y - localVertices[i].y) * scaleY;
			scaledLength += (float)Math.hypot(x,y);
		}

		return scaledLength;
	}

	public float getX () {
		return point.x;
	}

	public float getY () {
		return point.y;
	}

	public float getOriginX () {
		return origin.x;
	}

	public float getOriginY () {
		return origin.y;
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
