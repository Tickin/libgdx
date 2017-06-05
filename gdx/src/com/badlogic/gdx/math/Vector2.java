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

import java.io.Serializable;

import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.NumberUtils;

/** Encapsulates a 2D vector. Allows chaining methods by returning a reference to itself
 * @author badlogicgames@gmail.com */
public class Vector2 implements Serializable, Vector<Vector2> {
	private static final long serialVersionUID = 913902788239530931L;

	public final static Vector2 X = new Vector2(1, 0);
	public final static Vector2 Y = new Vector2(0, 1);
	public final static Vector2 Zero = new Vector2(0, 0);

	/** the x-component of this vector **/
	private float x;
	/** the y-component of this vector **/
	private float y;

	/** Constructs a new vector at (0,0) */
	public Vector2 () {
	}

	/** Constructs a vector with the given components
	 * @param x The x-component
	 * @param y The y-component */
	public Vector2 (float x, float y) {
		this.setX(x);
		this.setY(y);
	}

	/** Constructs a vector from the given vector
	 * @param v The vector */
	public Vector2 (Vector2 v) {
		set(v);
	}

	@Override
	public Vector2 cpy () {
		return new Vector2(this);
	}

	public static float len (float x, float y) {
		return (float)Math.sqrt(x * x + y * y);
	}

	@Override
	public float len () {
		return (float)Math.sqrt(getX() * getX() + getY() * getY());
	}

	public static float len2 (float x, float y) {
		return x * x + y * y;
	}

	@Override
	public float len2 () {
		return getX() * getX() + getY() * getY();
	}

	@Override
	public Vector2 set (Vector2 v) {
		setX(v.getX());
		setY(v.getY());
		return this;
	}

	/** Sets the components of this vector
	 * @param x The x-component
	 * @param y The y-component
	 * @return This vector for chaining */
	public Vector2 set (float x, float y) {
		this.setX(x);
		this.setY(y);
		return this;
	}

	@Override
	public Vector2 sub (Vector2 v) {
		setX(getX() - v.getX());
		setY(getY() - v.getY());
		return this;
	}

	/** Substracts the other vector from this vector.
	 * @param x The x-component of the other vector
	 * @param y The y-component of the other vector
	 * @return This vector for chaining */
	public Vector2 sub (float x, float y) {
		this.setX(this.getX() - x);
		this.setY(this.getY() - y);
		return this;
	}

	@Override
	public Vector2 nor () {
		float len = len();
		if (len != 0) {
			setX(getX() / len);
			setY(getY() / len);
		}
		return this;
	}

	@Override
	public Vector2 add (Vector2 v) {
		setX(getX() + v.getX());
		setY(getY() + v.getY());
		return this;
	}

	/** Adds the given components to this vector
	 * @param x The x-component
	 * @param y The y-component
	 * @return This vector for chaining */
	public Vector2 add (float x, float y) {
		this.setX(this.getX() + x);
		this.setY(this.getY() + y);
		return this;
	}

	public static float dot (float x1, float y1, float x2, float y2) {
		return x1 * x2 + y1 * y2;
	}

	@Override
	public float dot (Vector2 v) {
		return getX() * v.getX() + getY() * v.getY();
	}

	public float dot (float ox, float oy) {
		return getX() * ox + getY() * oy;
	}

	@Override
	public Vector2 scl (float scalar) {
		setX(getX() * scalar);
		setY(getY() * scalar);
		return this;
	}

	/** Multiplies this vector by a scalar
	 * @return This vector for chaining */
	public Vector2 scl (float x, float y) {
		this.setX(this.getX() * x);
		this.setY(this.getY() * y);
		return this;
	}

	@Override
	public Vector2 scl (Vector2 v) {
		this.setX(this.getX() * v.getX());
		this.setY(this.getY() * v.getY());
		return this;
	}

	@Override
	public Vector2 mulAdd (Vector2 vec, float scalar) {
		this.setX(this.getX() + vec.getX() * scalar);
		this.setY(this.getY() + vec.getY() * scalar);
		return this;
	}

	@Override
	public Vector2 mulAdd (Vector2 vec, Vector2 mulVec) {
		this.setX(this.getX() + vec.getX() * mulVec.getX());
		this.setY(this.getY() + vec.getY() * mulVec.getY());
		return this;
	}

	public static float dst (float x1, float y1, float x2, float y2) {
		final float x_d = x2 - x1;
		final float y_d = y2 - y1;
		return (float)Math.sqrt(x_d * x_d + y_d * y_d);
	}

	@Override
	public float dst (Vector2 v) {
		final float x_d = v.getX() - getX();
		final float y_d = v.getY() - getY();
		return (float)Math.sqrt(x_d * x_d + y_d * y_d);
	}

	/** @param x The x-component of the other vector
	 * @param y The y-component of the other vector
	 * @return the distance between this and the other vector */
	public float dst (float x, float y) {
		final float x_d = x - this.getX();
		final float y_d = y - this.getY();
		return (float)Math.sqrt(x_d * x_d + y_d * y_d);
	}

	public static float dst2 (float x1, float y1, float x2, float y2) {
		final float x_d = x2 - x1;
		final float y_d = y2 - y1;
		return x_d * x_d + y_d * y_d;
	}

	@Override
	public float dst2 (Vector2 v) {
		final float x_d = v.getX() - getX();
		final float y_d = v.getY() - getY();
		return x_d * x_d + y_d * y_d;
	}

	/** @param x The x-component of the other vector
	 * @param y The y-component of the other vector
	 * @return the squared distance between this and the other vector */
	public float dst2 (float x, float y) {
		final float x_d = x - this.getX();
		final float y_d = y - this.getY();
		return x_d * x_d + y_d * y_d;
	}

	@Override
	public Vector2 limit (float limit) {
		return limit2(limit * limit);
	}

	@Override
	public Vector2 limit2 (float limit2) {
		float len2 = len2();
		if (len2 > limit2) {
			return scl((float)Math.sqrt(limit2 / len2));
		}
		return this;
	}

	@Override
	public Vector2 clamp (float min, float max) {
		final float len2 = len2();
		if (len2 == 0f) return this;
		float max2 = max * max;
		if (len2 > max2) return scl((float)Math.sqrt(max2 / len2));
		float min2 = min * min;
		if (len2 < min2) return scl((float)Math.sqrt(min2 / len2));
		return this;
	}

	@Override
	public Vector2 setLength (float len) {
		return setLength2(len * len);
	}

	@Override
	public Vector2 setLength2 (float len2) {
		float oldLen2 = len2();
		return (oldLen2 == 0 || oldLen2 == len2) ? this : scl((float)Math.sqrt(len2 / oldLen2));
	}

	/** Converts this {@code Vector2} to a string in the format {@code (x,y)}.
	 * @return a string representation of this object. */
	@Override
	public String toString () {
		return "(" + getX() + "," + getY() + ")";
	}

	/** Sets this {@code Vector2} to the value represented by the specified string according to the format of {@link #toString()}.
	 * @param v the string.
	 * @return this vector for chaining */
	public Vector2 fromString (String v) {
		int s = v.indexOf(',', 1);
		if (s != -1 && v.charAt(0) == '(' && v.charAt(v.length() - 1) == ')') {
			try {
				float x = Float.parseFloat(v.substring(1, s));
				float y = Float.parseFloat(v.substring(s + 1, v.length() - 1));
				return this.set(x, y);
			} catch (NumberFormatException ex) {
				// Throw a GdxRuntimeException
			}
		}
		throw new GdxRuntimeException("Malformed Vector2: " + v);
	}

	/** Left-multiplies this vector by the given matrix
	 * @param mat the matrix
	 * @return this vector */
	public Vector2 mul (Matrix3 mat) {
		float x = this.getX() * mat.val[0] + this.getY() * mat.val[3] + mat.val[6];
		float y = this.getX() * mat.val[1] + this.getY() * mat.val[4] + mat.val[7];
		this.setX(x);
		this.setY(y);
		return this;
	}

	/** Calculates the 2D cross product between this and the given vector.
	 * @param v the other vector
	 * @return the cross product */
	public float crs (Vector2 v) {
		return this.getX() * v.getY() - this.getY() * v.getX();
	}

	/** Calculates the 2D cross product between this and the given vector.
	 * @param x the x-coordinate of the other vector
	 * @param y the y-coordinate of the other vector
	 * @return the cross product */
	public float crs (float x, float y) {
		return this.getX() * y - this.getY() * x;
	}

	/** @return the angle in degrees of this vector (point) relative to the x-axis. Angles are towards the positive y-axis (typically
	 *         counter-clockwise) and between 0 and 360. */
	public float angle () {
		float angle = (float)Math.atan2(getY(), getX()) * MathUtils.radiansToDegrees;
		if (angle < 0) angle += 360;
		return angle;
	}

	/** @return the angle in degrees of this vector (point) relative to the given vector. Angles are towards the positive y-axis
	 *         (typically counter-clockwise.) between -180 and +180 */
	public float angle (Vector2 reference) {
		return (float)Math.atan2(crs(reference), dot(reference)) * MathUtils.radiansToDegrees;
	}

	/** @return the angle in radians of this vector (point) relative to the x-axis. Angles are towards the positive y-axis.
	 *         (typically counter-clockwise) */
	public float angleRad () {
		return (float)Math.atan2(getY(), getX());
	}

	/** @return the angle in radians of this vector (point) relative to the given vector. Angles are towards the positive y-axis.
	 *         (typically counter-clockwise.) */
	public float angleRad (Vector2 reference) {
		return (float)Math.atan2(crs(reference), dot(reference));
	}

	/** Sets the angle of the vector in degrees relative to the x-axis, towards the positive y-axis (typically counter-clockwise).
	 * @param degrees The angle in degrees to set. */
	public Vector2 setAngle (float degrees) {
		return setAngleRad(degrees * MathUtils.degreesToRadians);
	}

	/** Sets the angle of the vector in radians relative to the x-axis, towards the positive y-axis (typically counter-clockwise).
	 * @param radians The angle in radians to set. */
	public Vector2 setAngleRad (float radians) {
		this.set(len(), 0f);
		this.rotateRad(radians);

		return this;
	}

	/** Rotates the Vector2 by the given angle, counter-clockwise assuming the y-axis points up.
	 * @param degrees the angle in degrees */
	public Vector2 rotate (float degrees) {
		return rotateRad(degrees * MathUtils.degreesToRadians);
	}

	/** Rotates the Vector2 by the given angle, counter-clockwise assuming the y-axis points up.
	 * @param radians the angle in radians */
	public Vector2 rotateRad (float radians) {
		float cos = (float)Math.cos(radians);
		float sin = (float)Math.sin(radians);

		float newX = this.getX() * cos - this.getY() * sin;
		float newY = this.getX() * sin + this.getY() * cos;

		this.setX(newX);
		this.setY(newY);

		return this;
	}

	/** Rotates the Vector2 by 90 degrees in the specified direction, where >= 0 is counter-clockwise and < 0 is clockwise. */
	public Vector2 rotate90 (int dir) {
		float x = this.getX();
		if (dir >= 0) {
			this.setX(-getY());
			setY(x);
		} else {
			this.setX(getY());
			setY(-x);
		}
		return this;
	}

	@Override
	public Vector2 lerp (Vector2 target, float alpha) {
		final float invAlpha = 1.0f - alpha;
		this.setX((getX() * invAlpha) + (target.getX() * alpha));
		this.setY((getY() * invAlpha) + (target.getY() * alpha));
		return this;
	}

	@Override
	public Vector2 interpolate (Vector2 target, float alpha, Interpolation interpolation) {
		return lerp(target, interpolation.apply(alpha));
	}

	@Override
	public Vector2 setToRandomDirection () {
		float theta = MathUtils.random(0f, MathUtils.PI2);
		return this.set(MathUtils.cos(theta), MathUtils.sin(theta));
	}

	@Override
	public int hashCode () {
		final int prime = 31;
		int result = 1;
		result = prime * result + NumberUtils.floatToIntBits(getX());
		result = prime * result + NumberUtils.floatToIntBits(getY());
		return result;
	}

	@Override
	public boolean equals (Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Vector2 other = (Vector2)obj;
		if (NumberUtils.floatToIntBits(getX()) != NumberUtils.floatToIntBits(other.getX())) return false;
		if (NumberUtils.floatToIntBits(getY()) != NumberUtils.floatToIntBits(other.getY())) return false;
		return true;
	}

	@Override
	public boolean epsilonEquals (Vector2 other, float epsilon) {
		if (other == null) return false;
		if (Math.abs(other.getX() - getX()) > epsilon) return false;
		if (Math.abs(other.getY() - getY()) > epsilon) return false;
		return true;
	}

	/** Compares this vector with the other vector, using the supplied epsilon for fuzzy equality testing.
	 * @return whether the vectors are the same. */
	public boolean epsilonEquals (float x, float y, float epsilon) {
		if (Math.abs(x - this.getX()) > epsilon) return false;
		if (Math.abs(y - this.getY()) > epsilon) return false;
		return true;
	}

	@Override
	public boolean isUnit () {
		return isUnit(0.000000001f);
	}

	@Override
	public boolean isUnit (final float margin) {
		return Math.abs(len2() - 1f) < margin;
	}

	@Override
	public boolean isZero () {
		return getX() == 0 && getY() == 0;
	}

	@Override
	public boolean isZero (final float margin) {
		return len2() < margin;
	}

	@Override
	public boolean isOnLine (Vector2 other) {
		return MathUtils.isZero(getX() * other.getY() - getY() * other.getX());
	}

	@Override
	public boolean isOnLine (Vector2 other, float epsilon) {
		return MathUtils.isZero(getX() * other.getY() - getY() * other.getX(), epsilon);
	}

	@Override
	public boolean isCollinear (Vector2 other, float epsilon) {
		return isOnLine(other, epsilon) && dot(other) > 0f;
	}

	@Override
	public boolean isCollinear (Vector2 other) {
		return isOnLine(other) && dot(other) > 0f;
	}

	@Override
	public boolean isCollinearOpposite (Vector2 other, float epsilon) {
		return isOnLine(other, epsilon) && dot(other) < 0f;
	}

	@Override
	public boolean isCollinearOpposite (Vector2 other) {
		return isOnLine(other) && dot(other) < 0f;
	}

	@Override
	public boolean isPerpendicular (Vector2 vector) {
		return MathUtils.isZero(dot(vector));
	}

	@Override
	public boolean isPerpendicular (Vector2 vector, float epsilon) {
		return MathUtils.isZero(dot(vector), epsilon);
	}

	@Override
	public boolean hasSameDirection (Vector2 vector) {
		return dot(vector) > 0;
	}

	@Override
	public boolean hasOppositeDirection (Vector2 vector) {
		return dot(vector) < 0;
	}

	@Override
	public Vector2 setZero () {
		this.setX(0);
		this.setY(0);
		return this;
	}

	public float getX () {
		return x;
	}

	public void setX (float x) {
		this.x = x;
	}

	public float getY () {
		return y;
	}

	public void setY (float y) {
		this.y = y;
	}
}
