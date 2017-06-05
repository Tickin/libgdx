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

package com.badlogic.gdx.math.collision;

import java.io.Serializable;
import java.util.List;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;

/** Encapsulates an axis aligned bounding box represented by a minimum and a maximum Vector. Additionally you can query for the
 * bounding box's center, dimensions and corner points.
 *
 * @author badlogicgames@gmail.com, Xoppa */
public class BoundingBox implements Serializable {
	private static final long serialVersionUID = -1286036817192127343L;

	private final static Vector3 tmpVector = new Vector3();

	public final Vector3 min = new Vector3();
	public final Vector3 max = new Vector3();

	private final Vector3 cnt = new Vector3();
	private final Vector3 dim = new Vector3();

	public final static int CORNER000 = 0;
	public final static int CORNER001 = 1;
	public final static int CORNER010 = 2;
	public final static int CORNER011 = 3;
	public final static int CORNER100 = 4;
	public final static int CORNER101 = 5;
	public final static int CORNER110 = 6;
	public final static int CORNER111 = 7;
	
	public final static int CORNERX = 1;
	public final static int CORNERY = 2;
	public final static int CORNERZ = 4;
	
	/** @param out The {@link Vector3} to receive the center of the bounding box.
	 * @return The vector specified with the out argument. */
	public Vector3 getCenter (Vector3 out) {
		return out.set(cnt);
	}

	public float getCenterX () {
		return cnt.getX();
	}

	public float getCenterY () {
		return cnt.getY();
	}

	public float getCenterZ () {
		return cnt.getZ();
	}
	
	public Vector3 getCorner(final int corner, final Vector3 out){
		out.setX(((corner & BoundingBox.CORNERX) != 0)?max.getX():min.getX());
		out.setY(((corner & BoundingBox.CORNERY) != 0)?max.getY():min.getY());
		out.setZ(((corner & BoundingBox.CORNERZ) != 0)?max.getZ():min.getZ());
		return out;
	}

	public Vector3 getCorner000 (final Vector3 out) {
		return out.set(min.getX(), min.getY(), min.getZ());
	}

	public Vector3 getCorner001 (final Vector3 out) {
		return out.set(min.getX(), min.getY(), max.getZ());
	}

	public Vector3 getCorner010 (final Vector3 out) {
		return out.set(min.getX(), max.getY(), min.getZ());
	}

	public Vector3 getCorner011 (final Vector3 out) {
		return out.set(min.getX(), max.getY(), max.getZ());
	}

	public Vector3 getCorner100 (final Vector3 out) {
		return out.set(max.getX(), min.getY(), min.getZ());
	}

	public Vector3 getCorner101 (final Vector3 out) {
		return out.set(max.getX(), min.getY(), max.getZ());
	}

	public Vector3 getCorner110 (final Vector3 out) {
		return out.set(max.getX(), max.getY(), min.getZ());
	}

	public Vector3 getCorner111 (final Vector3 out) {
		return out.set(max.getX(), max.getY(), max.getZ());
	}

	/** @param out The {@link Vector3} to receive the dimensions of this bounding box on all three axis.
	 * @return The vector specified with the out argument */
	public Vector3 getDimensions (final Vector3 out) {
		return out.set(dim);
	}

	public float getWidth () {
		return dim.getX();
	}

	public float getHeight () {
		return dim.getY();
	}

	public float getDepth () {
		return dim.getZ();
	}

	/** @param out The {@link Vector3} to receive the minimum values.
	 * @return The vector specified with the out argument */
	public Vector3 getMin (final Vector3 out) {
		return out.set(min);
	}

	/** @param out The {@link Vector3} to receive the maximum values.
	 * @return The vector specified with the out argument */
	public Vector3 getMax (final Vector3 out) {
		return out.set(max);
	}

	/** Constructs a new bounding box with the minimum and maximum vector set to zeros. */
	public BoundingBox () {
		clr();
	}

	/** Constructs a new bounding box from the given bounding box.
	 *
	 * @param bounds The bounding box to copy */
	public BoundingBox (BoundingBox bounds) {
		this.set(bounds);
	}

	/** Constructs the new bounding box using the given minimum and maximum vector.
	 *
	 * @param minimum The minimum vector
	 * @param maximum The maximum vector */
	public BoundingBox (Vector3 minimum, Vector3 maximum) {
		this.set(minimum, maximum);
	}

	/** Sets the given bounding box.
	 *
	 * @param bounds The bounds.
	 * @return This bounding box for chaining. */
	public BoundingBox set (BoundingBox bounds) {
		return this.set(bounds.min, bounds.max);
	}

	/** Sets the given minimum and maximum vector.
	 *
	 * @param minimum The minimum vector
	 * @param maximum The maximum vector
	 * @return This bounding box for chaining. */
	public BoundingBox set (Vector3 minimum, Vector3 maximum) {
		min.set(minimum.getX() < maximum.getX() ? minimum.getX() : maximum.getX(), minimum.getY() < maximum.getY() ? minimum.getY() : maximum.getY(),
			minimum.getZ() < maximum.getZ() ? minimum.getZ() : maximum.getZ());
		max.set(minimum.getX() > maximum.getX() ? minimum.getX() : maximum.getX(), minimum.getY() > maximum.getY() ? minimum.getY() : maximum.getY(),
			minimum.getZ() > maximum.getZ() ? minimum.getZ() : maximum.getZ());
		cnt.set(min).add(max).scl(0.5f);
		dim.set(max).sub(min);
		return this;
	}

	/** Sets the bounding box minimum and maximum vector from the given points.
	 *
	 * @param points The points.
	 * @return This bounding box for chaining. */
	public BoundingBox set (Vector3[] points) {
		this.inf();
		for (Vector3 l_point : points)
			this.ext(l_point);
		return this;
	}

	/** Sets the bounding box minimum and maximum vector from the given points.
	 *
	 * @param points The points.
	 * @return This bounding box for chaining. */
	public BoundingBox set (List<Vector3> points) {
		this.inf();
		for (Vector3 l_point : points)
			this.ext(l_point);
		return this;
	}

	/** Sets the minimum and maximum vector to positive and negative infinity.
	 *
	 * @return This bounding box for chaining. */
	public BoundingBox inf () {
		min.set(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
		max.set(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
		cnt.set(0, 0, 0);
		dim.set(0, 0, 0);
		return this;
	}

	/** Extends the bounding box to incorporate the given {@link Vector3}.
	 * @param point The vector
	 * @return This bounding box for chaining. */
	public BoundingBox ext (Vector3 point) {
		return this.set(min.set(min(min.getX(), point.getX()), min(min.getY(), point.getY()), min(min.getZ(), point.getZ())),
			max.set(Math.max(max.getX(), point.getX()), Math.max(max.getY(), point.getY()), Math.max(max.getZ(), point.getZ())));
	}

	/** Sets the minimum and maximum vector to zeros.
	 * @return This bounding box for chaining. */
	public BoundingBox clr () {
		return this.set(min.set(0, 0, 0), max.set(0, 0, 0));
	}

	/** Returns whether this bounding box is valid. This means that {@link #max} is greater than or equal to {@link #min}.
	 * @return True in case the bounding box is valid, false otherwise */
	public boolean isValid () {
		return min.getX() <= max.getX() && min.getY() <= max.getY() && min.getZ() <= max.getZ();
	}

	/** Extends this bounding box by the given bounding box.
	 *
	 * @param a_bounds The bounding box
	 * @return This bounding box for chaining. */
	public BoundingBox ext (BoundingBox a_bounds) {
		return this.set(min.set(min(min.getX(), a_bounds.min.getX()), min(min.getY(), a_bounds.min.getY()), min(min.getZ(), a_bounds.min.getZ())),
			max.set(max(max.getX(), a_bounds.max.getX()), max(max.getY(), a_bounds.max.getY()), max(max.getZ(), a_bounds.max.getZ())));
	}

	/** Extends this bounding box by the given sphere.
	 *
	 * @param center Sphere center
	 * @param radius Sphere radius
	 * @return This bounding box for chaining. */
	public BoundingBox ext (Vector3 center, float radius) {
		return this.set(min.set(min(min.getX(), center.getX() - radius), min(min.getY(), center.getY() - radius), min(min.getZ(), center.getZ() - radius)),
			max.set(max(max.getX(), center.getX() + radius), max(max.getY(), center.getY() + radius), max(max.getZ(), center.getZ() + radius)));
	}

	/** Extends this bounding box by the given transformed bounding box.
	 *
	 * @param bounds The bounding box
	 * @param transform The transformation matrix to apply to bounds, before using it to extend this bounding box.
	 * @return This bounding box for chaining. */
	public BoundingBox ext (BoundingBox bounds, Matrix4 transform) {
		ext(tmpVector.set(bounds.min.getX(), bounds.min.getY(), bounds.min.getZ()).mul(transform));
		ext(tmpVector.set(bounds.min.getX(), bounds.min.getY(), bounds.max.getZ()).mul(transform));
		ext(tmpVector.set(bounds.min.getX(), bounds.max.getY(), bounds.min.getZ()).mul(transform));
		ext(tmpVector.set(bounds.min.getX(), bounds.max.getY(), bounds.max.getZ()).mul(transform));
		ext(tmpVector.set(bounds.max.getX(), bounds.min.getY(), bounds.min.getZ()).mul(transform));
		ext(tmpVector.set(bounds.max.getX(), bounds.min.getY(), bounds.max.getZ()).mul(transform));
		ext(tmpVector.set(bounds.max.getX(), bounds.max.getY(), bounds.min.getZ()).mul(transform));
		ext(tmpVector.set(bounds.max.getX(), bounds.max.getY(), bounds.max.getZ()).mul(transform));
		return this;
	}

	/** Multiplies the bounding box by the given matrix. This is achieved by multiplying the 8 corner points and then calculating
	 * the minimum and maximum vectors from the transformed points.
	 *
	 * @param transform The matrix
	 * @return This bounding box for chaining. */
	public BoundingBox mul (Matrix4 transform) {
		final float x0 = min.getX(), y0 = min.getY(), z0 = min.getZ(), x1 = max.getX(), y1 = max.getY(), z1 = max.getZ();
		inf();
		ext(tmpVector.set(x0, y0, z0).mul(transform));
		ext(tmpVector.set(x0, y0, z1).mul(transform));
		ext(tmpVector.set(x0, y1, z0).mul(transform));
		ext(tmpVector.set(x0, y1, z1).mul(transform));
		ext(tmpVector.set(x1, y0, z0).mul(transform));
		ext(tmpVector.set(x1, y0, z1).mul(transform));
		ext(tmpVector.set(x1, y1, z0).mul(transform));
		ext(tmpVector.set(x1, y1, z1).mul(transform));
		return this;
	}

	/** Returns whether the given bounding box is contained in this bounding box.
	 * @param b The bounding box
	 * @return Whether the given bounding box is contained */
	public boolean contains (BoundingBox b) {
		return !isValid()
			|| (min.getX() <= b.min.getX() && min.getY() <= b.min.getY() && min.getZ() <= b.min.getZ() && max.getX() >= b.max.getX() && max.getY() >= b.max.getY() && max.getZ() >= b.max.getZ());
	}

	/** Returns whether the given bounding box is intersecting this bounding box (at least one point in).
	 * @param b The bounding box
	 * @return Whether the given bounding box is intersected */
	public boolean intersects (BoundingBox b) {
		if (!isValid()) return false;

		// test using SAT (separating axis theorem)

		float lx = Math.abs(this.cnt.getX() - b.cnt.getX());
		float sumx = (this.dim.getX() / 2.0f) + (b.dim.getX() / 2.0f);

		float ly = Math.abs(this.cnt.getY() - b.cnt.getY());
		float sumy = (this.dim.getY() / 2.0f) + (b.dim.getY() / 2.0f);

		float lz = Math.abs(this.cnt.getZ() - b.cnt.getZ());
		float sumz = (this.dim.getZ() / 2.0f) + (b.dim.getZ() / 2.0f);

		return (lx <= sumx && ly <= sumy && lz <= sumz);

	}

	/** Returns whether the given vector is contained in this bounding box.
	 * @param v The vector
	 * @return Whether the vector is contained or not. */
	public boolean contains (Vector3 v) {
		return min.getX() <= v.getX() && max.getX() >= v.getX() && min.getY() <= v.getY() && max.getY() >= v.getY() && min.getZ() <= v.getZ() && max.getZ() >= v.getZ();
	}

	@Override
	public String toString () {
		return "[" + min + "|" + max + "]";
	}

	/** Extends the bounding box by the given vector.
	 *
	 * @param x The x-coordinate
	 * @param y The y-coordinate
	 * @param z The z-coordinate
	 * @return This bounding box for chaining. */
	public BoundingBox ext (float x, float y, float z) {
		return this.set(min.set(min(min.getX(), x), min(min.getY(), y), min(min.getZ(), z)), max.set(max(max.getX(), x), max(max.getY(), y), max(max.getZ(), z)));
	}

	static final float min (final float a, final float b) {
		return a > b ? b : a;
	}

	static final float max (final float a, final float b) {
		return a > b ? a : b;
	}
}