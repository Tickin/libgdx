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

/** Encapsulates a 3D vector. Allows chaining operations by returning a reference to itself in all modification methods.
 * @author badlogicgames@gmail.com */
public class Vector3 implements Serializable, Vector<Vector3> {
	private static final long serialVersionUID = 3840054589595372522L;

	/** the x-component of this vector **/
	private float x;
	/** the y-component of this vector **/
	private float y;
	/** the z-component of this vector **/
	private float z;

	public final static Vector3 X = new Vector3(1, 0, 0);
	public final static Vector3 Y = new Vector3(0, 1, 0);
	public final static Vector3 Z = new Vector3(0, 0, 1);
	public final static Vector3 Zero = new Vector3(0, 0, 0);

	private final static Matrix4 tmpMat = new Matrix4();

	/** Constructs a vector at (0,0,0) */
	public Vector3 () {
	}

	/** Creates a vector with the given components
	 * @param x The x-component
	 * @param y The y-component
	 * @param z The z-component */
	public Vector3 (float x, float y, float z) {
		this.set(x, y, z);
	}

	/** Creates a vector from the given vector
	 * @param vector The vector */
	public Vector3 (final Vector3 vector) {
		this.set(vector);
	}

	/** Creates a vector from the given array. The array must have at least 3 elements.
	 *
	 * @param values The array */
	public Vector3 (final float[] values) {
		this.set(values[0], values[1], values[2]);
	}

	/** Creates a vector from the given vector and z-component
	 *
	 * @param vector The vector
	 * @param z The z-component */
	public Vector3 (final Vector2 vector, float z) {
		this.set(vector.getX(), vector.getY(), z);
	}

	/** Sets the vector to the given components
	 *
	 * @param x The x-component
	 * @param y The y-component
	 * @param z The z-component
	 * @return this vector for chaining */
	public Vector3 set (float x, float y, float z) {
		this.setX(x);
		this.setY(y);
		this.setZ(z);
		return this;
	}

	@Override
	public Vector3 set (final Vector3 vector) {
		return this.set(vector.getX(), vector.getY(), vector.getZ());
	}

	/** Sets the components from the array. The array must have at least 3 elements
	 *
	 * @param values The array
	 * @return this vector for chaining */
	public Vector3 set (final float[] values) {
		return this.set(values[0], values[1], values[2]);
	}

	/** Sets the components of the given vector and z-component
	 *
	 * @param vector The vector
	 * @param z The z-component
	 * @return This vector for chaining */
	public Vector3 set (final Vector2 vector, float z) {
		return this.set(vector.getX(), vector.getY(), z);
	}

	/** Sets the components from the given spherical coordinate
	 * @param azimuthalAngle The angle between x-axis in radians [0, 2pi]
	 * @param polarAngle The angle between z-axis in radians [0, pi]
	 * @return This vector for chaining */
	public Vector3 setFromSpherical (float azimuthalAngle, float polarAngle) {
		float cosPolar = MathUtils.cos(polarAngle);
		float sinPolar = MathUtils.sin(polarAngle);

		float cosAzim = MathUtils.cos(azimuthalAngle);
		float sinAzim = MathUtils.sin(azimuthalAngle);

		return this.set(cosAzim * sinPolar, sinAzim * sinPolar, cosPolar);
	}

	@Override
	public Vector3 setToRandomDirection () {
		float u = MathUtils.random();
		float v = MathUtils.random();

		float theta = MathUtils.PI2 * u; // azimuthal angle
		float phi = (float)Math.acos(2f * v - 1f); // polar angle

		return this.setFromSpherical(theta, phi);
	}

	@Override
	public Vector3 cpy () {
		return new Vector3(this);
	}

	@Override
	public Vector3 add (final Vector3 vector) {
		return this.add(vector.getX(), vector.getY(), vector.getZ());
	}

	/** Adds the given vector to this component
	 * @param x The x-component of the other vector
	 * @param y The y-component of the other vector
	 * @param z The z-component of the other vector
	 * @return This vector for chaining. */
	public Vector3 add (float x, float y, float z) {
		return this.set(this.getX() + x, this.getY() + y, this.getZ() + z);
	}

	/** Adds the given value to all three components of the vector.
	 *
	 * @param values The value
	 * @return This vector for chaining */
	public Vector3 add (float values) {
		return this.set(this.getX() + values, this.getY() + values, this.getZ() + values);
	}

	@Override
	public Vector3 sub (final Vector3 a_vec) {
		return this.sub(a_vec.getX(), a_vec.getY(), a_vec.getZ());
	}

	/** Subtracts the other vector from this vector.
	 *
	 * @param x The x-component of the other vector
	 * @param y The y-component of the other vector
	 * @param z The z-component of the other vector
	 * @return This vector for chaining */
	public Vector3 sub (float x, float y, float z) {
		return this.set(this.getX() - x, this.getY() - y, this.getZ() - z);
	}

	/** Subtracts the given value from all components of this vector
	 *
	 * @param value The value
	 * @return This vector for chaining */
	public Vector3 sub (float value) {
		return this.set(this.getX() - value, this.getY() - value, this.getZ() - value);
	}

	@Override
	public Vector3 scl (float scalar) {
		return this.set(this.getX() * scalar, this.getY() * scalar, this.getZ() * scalar);
	}

	@Override
	public Vector3 scl (final Vector3 other) {
		return this.set(getX() * other.getX(), getY() * other.getY(), getZ() * other.getZ());
	}

	/** Scales this vector by the given values
	 * @param vx X value
	 * @param vy Y value
	 * @param vz Z value
	 * @return This vector for chaining */
	public Vector3 scl (float vx, float vy, float vz) {
		return this.set(this.getX() * vx, this.getY() * vy, this.getZ() * vz);
	}

	@Override
	public Vector3 mulAdd (Vector3 vec, float scalar) {
		return this.add(vec.scl(scalar));
	}

	@Override
	public Vector3 mulAdd (Vector3 vec, Vector3 mulVec) {
		return this.add(vec.scl(mulVec));
	}

	/** @return The euclidean length */
	public static float len (final float x, final float y, final float z) {
		return (float)Math.sqrt(squareSum(x, y, z));
	}

	@Override
	public float len () {
		return (float)Math.sqrt(getX() * getX() + getY() * getY() + getZ() * getZ());
	}

	/** @return The squared euclidean length */
	public static float len2 (final float x, final float y, final float z) {
		return squareSum(x, y, z);
	}

	@Override
	public float len2 () {
		return getX() * getX() + getY() * getY() + getZ() * getZ();
	}

	/** @param vector The other vector
	 * @return Whether this and the other vector are equal */
	public boolean idt (final Vector3 vector) {
		return getX() == vector.getX() && getY() == vector.getY() && getZ() == vector.getZ();
	}

	/** @return Squared sum of params */ 
	private static float squareSum (final float a, final float b, final float c) {
		return a * a + b * b + c * c;
	}

	/** @return The euclidean distance between the two specified vectors */
	public static float dst (final float x1, final float y1, final float z1, final float x2, final float y2, final float z2) {
		final float a = x2 - x1;
		final float b = y2 - y1;
		final float c = z2 - z1;
		return (float)Math.sqrt(squareSum(a, b, c));
	}

	@Override
	public float dst (final Vector3 vector) {
		final float a = vector.getX() - getX();
		final float b = vector.getY() - getY();
		final float c = vector.getZ() - getZ();
		return (float)Math.sqrt(squareSum(a, b, c));
	}

	/** @return the distance between this point and the given point */
	public float dst (float x, float y, float z) {
		final float a = x - this.getX();
		final float b = y - this.getY();
		final float c = z - this.getZ();
		return (float)Math.sqrt(squareSum(a, b, c));
	}

	/** @return the squared distance between the given points */
	public static float dst2 (final float x1, final float y1, final float z1, final float x2, final float y2, final float z2) {
		final float a = x2 - x1;
		final float b = y2 - y1;
		final float c = z2 - z1;
		return squareSum(a, b, c);
	}

	@Override
	public float dst2 (Vector3 point) {
		final float a = point.getX() - getX();
		final float b = point.getY() - getY();
		final float c = point.getZ() - getZ();
		return squareSum(a, b, c);
	}

	/** Returns the squared distance between this point and the given point
	 * @param x The x-component of the other point
	 * @param y The y-component of the other point
	 * @param z The z-component of the other point
	 * @return The squared distance */
	public float dst2 (float x, float y, float z) {
		final float a = x - this.getX();
		final float b = y - this.getY();
		final float c = z - this.getZ();
		return squareSum(a, b, c);
	}

	@Override
	public Vector3 nor () {
		final float len2 = this.len2();
		if (len2 == 0f || len2 == 1f) return this;
		return this.scl(1f / (float)Math.sqrt(len2));
	}

	/** @return The dot product between the two vectors */
	public static float dot (float x1, float y1, float z1, float x2, float y2, float z2) {
		return x1 * x2 + y1 * y2 + z1 * z2;
	}

	@Override
	public float dot (final Vector3 vector) {
		return getX() * vector.getX() + getY() * vector.getY() + getZ() * vector.getZ();
	}

	/** Returns the dot product between this and the given vector.
	 * @param x The x-component of the other vector
	 * @param y The y-component of the other vector
	 * @param z The z-component of the other vector
	 * @return The dot product */
	public float dot (float x, float y, float z) {
		return this.getX() * x + this.getY() * y + this.getZ() * z;
	}

	/** Sets this vector to the cross product between it and the other vector.
	 * @param vector The other vector
	 * @return This vector for chaining */
	public Vector3 crs (final Vector3 vector) {
		return this.set(getY() * vector.getZ() - getZ() * vector.getY(), getZ() * vector.getX() - getX() * vector.getZ(), getX() * vector.getY() - getY() * vector.getX());
	}

	/** Sets this vector to the cross product between it and the other vector.
	 * @param x The x-component of the other vector
	 * @param y The y-component of the other vector
	 * @param z The z-component of the other vector
	 * @return This vector for chaining */
	public Vector3 crs (float x, float y, float z) {
		return this.set(this.getY() * z - this.getZ() * y, this.getZ() * x - this.getX() * z, this.getX() * y - this.getY() * x);
	}

	/** Left-multiplies the vector by the given 4x3 column major matrix. The matrix should be composed by a 3x3 matrix representing
	 * rotation and scale plus a 1x3 matrix representing the translation.
	 * @param matrix The matrix
	 * @return This vector for chaining */
	public Vector3 mul4x3 (float[] matrix) {
		return set(getX() * matrix[0] + getY() * matrix[3] + getZ() * matrix[6] + matrix[9], getX() * matrix[1] + getY() * matrix[4] + getZ() * matrix[7]
			+ matrix[10], getX() * matrix[2] + getY() * matrix[5] + getZ() * matrix[8] + matrix[11]);
	}

	/** Left-multiplies the vector by the given matrix, assuming the fourth (w) component of the vector is 1.
	 * @param matrix The matrix
	 * @return This vector for chaining */
	public Vector3 mul (final Matrix4 matrix) {
		final float l_mat[] = matrix.val;
		return this.set(getX() * l_mat[Matrix4.M00] + getY() * l_mat[Matrix4.M01] + getZ() * l_mat[Matrix4.M02] + l_mat[Matrix4.M03], getX()
			* l_mat[Matrix4.M10] + getY() * l_mat[Matrix4.M11] + getZ() * l_mat[Matrix4.M12] + l_mat[Matrix4.M13], getX() * l_mat[Matrix4.M20] + getY()
			* l_mat[Matrix4.M21] + getZ() * l_mat[Matrix4.M22] + l_mat[Matrix4.M23]);
	}

	/** Multiplies the vector by the transpose of the given matrix, assuming the fourth (w) component of the vector is 1.
	 * @param matrix The matrix
	 * @return This vector for chaining */
	public Vector3 traMul (final Matrix4 matrix) {
		final float l_mat[] = matrix.val;
		return this.set(getX() * l_mat[Matrix4.M00] + getY() * l_mat[Matrix4.M10] + getZ() * l_mat[Matrix4.M20] + l_mat[Matrix4.M30], getX()
			* l_mat[Matrix4.M01] + getY() * l_mat[Matrix4.M11] + getZ() * l_mat[Matrix4.M21] + l_mat[Matrix4.M31], getX() * l_mat[Matrix4.M02] + getY()
			* l_mat[Matrix4.M12] + getZ() * l_mat[Matrix4.M22] + l_mat[Matrix4.M32]);
	}

	/** Left-multiplies the vector by the given matrix.
	 * @param matrix The matrix
	 * @return This vector for chaining */
	public Vector3 mul (Matrix3 matrix) {
		final float l_mat[] = matrix.val;
		return set(getX() * l_mat[Matrix3.M00] + getY() * l_mat[Matrix3.M01] + getZ() * l_mat[Matrix3.M02], getX() * l_mat[Matrix3.M10] + getY()
			* l_mat[Matrix3.M11] + getZ() * l_mat[Matrix3.M12], getX() * l_mat[Matrix3.M20] + getY() * l_mat[Matrix3.M21] + getZ() * l_mat[Matrix3.M22]);
	}

	/** Multiplies the vector by the transpose of the given matrix.
	 * @param matrix The matrix
	 * @return This vector for chaining */
	public Vector3 traMul (Matrix3 matrix) {
		final float l_mat[] = matrix.val;
		return set(getX() * l_mat[Matrix3.M00] + getY() * l_mat[Matrix3.M10] + getZ() * l_mat[Matrix3.M20], getX() * l_mat[Matrix3.M01] + getY()
			* l_mat[Matrix3.M11] + getZ() * l_mat[Matrix3.M21], getX() * l_mat[Matrix3.M02] + getY() * l_mat[Matrix3.M12] + getZ() * l_mat[Matrix3.M22]);
	}

	/** Multiplies the vector by the given {@link Quaternion}.
	 * @return This vector for chaining */
	public Vector3 mul (final Quaternion quat) {
		return quat.transform(this);
	}

	/** Multiplies this vector by the given matrix dividing by w, assuming the fourth (w) component of the vector is 1. This is
	 * mostly used to project/unproject vectors via a perspective projection matrix.
	 *
	 * @param matrix The matrix.
	 * @return This vector for chaining */
	public Vector3 prj (final Matrix4 matrix) {
		final float l_mat[] = matrix.val;
		final float l_w = 1f / (getX() * l_mat[Matrix4.M30] + getY() * l_mat[Matrix4.M31] + getZ() * l_mat[Matrix4.M32] + l_mat[Matrix4.M33]);
		return this.set((getX() * l_mat[Matrix4.M00] + getY() * l_mat[Matrix4.M01] + getZ() * l_mat[Matrix4.M02] + l_mat[Matrix4.M03]) * l_w, (getX()
			* l_mat[Matrix4.M10] + getY() * l_mat[Matrix4.M11] + getZ() * l_mat[Matrix4.M12] + l_mat[Matrix4.M13])
			* l_w, (getX() * l_mat[Matrix4.M20] + getY() * l_mat[Matrix4.M21] + getZ() * l_mat[Matrix4.M22] + l_mat[Matrix4.M23]) * l_w);
	}

	/** Multiplies this vector by the first three columns of the matrix, essentially only applying rotation and scaling.
	 *
	 * @param matrix The matrix
	 * @return This vector for chaining */
	public Vector3 rot (final Matrix4 matrix) {
		final float l_mat[] = matrix.val;
		return this.set(getX() * l_mat[Matrix4.M00] + getY() * l_mat[Matrix4.M01] + getZ() * l_mat[Matrix4.M02], getX() * l_mat[Matrix4.M10] + getY()
			* l_mat[Matrix4.M11] + getZ() * l_mat[Matrix4.M12], getX() * l_mat[Matrix4.M20] + getY() * l_mat[Matrix4.M21] + getZ() * l_mat[Matrix4.M22]);
	}

	/** Multiplies this vector by the transpose of the first three columns of the matrix. Note: only works for translation and
	 * rotation, does not work for scaling. For those, use {@link #rot(Matrix4)} with {@link Matrix4#inv()}.
	 * @param matrix The transformation matrix
	 * @return The vector for chaining */
	public Vector3 unrotate (final Matrix4 matrix) {
		final float l_mat[] = matrix.val;
		return this.set(getX() * l_mat[Matrix4.M00] + getY() * l_mat[Matrix4.M10] + getZ() * l_mat[Matrix4.M20], getX() * l_mat[Matrix4.M01] + getY()
			* l_mat[Matrix4.M11] + getZ() * l_mat[Matrix4.M21], getX() * l_mat[Matrix4.M02] + getY() * l_mat[Matrix4.M12] + getZ() * l_mat[Matrix4.M22]);
	}

	/** Translates this vector in the direction opposite to the translation of the matrix and the multiplies this vector by the
	 * transpose of the first three columns of the matrix. Note: only works for translation and rotation, does not work for
	 * scaling. For those, use {@link #mul(Matrix4)} with {@link Matrix4#inv()}.
	 * @param matrix The transformation matrix
	 * @return The vector for chaining */
	public Vector3 untransform (final Matrix4 matrix) {
		final float l_mat[] = matrix.val;
		setX(getX() - l_mat[Matrix4.M03]);
		setY(getY() - l_mat[Matrix4.M03]);
		setZ(getZ() - l_mat[Matrix4.M03]);
		return this.set(getX() * l_mat[Matrix4.M00] + getY() * l_mat[Matrix4.M10] + getZ() * l_mat[Matrix4.M20], getX() * l_mat[Matrix4.M01] + getY()
			* l_mat[Matrix4.M11] + getZ() * l_mat[Matrix4.M21], getX() * l_mat[Matrix4.M02] + getY() * l_mat[Matrix4.M12] + getZ() * l_mat[Matrix4.M22]);
	}

	/** Rotates this vector by the given angle in degrees around the given axis.
	 *
	 * @param degrees the angle in degrees
	 * @param axisX the x-component of the axis
	 * @param axisY the y-component of the axis
	 * @param axisZ the z-component of the axis
	 * @return This vector for chaining */
	public Vector3 rotate (float degrees, float axisX, float axisY, float axisZ) {
		return this.mul(tmpMat.setToRotation(axisX, axisY, axisZ, degrees));
	}

	/** Rotates this vector by the given angle in radians around the given axis.
	 *
	 * @param radians the angle in radians
	 * @param axisX the x-component of the axis
	 * @param axisY the y-component of the axis
	 * @param axisZ the z-component of the axis
	 * @return This vector for chaining */
	public Vector3 rotateRad (float radians, float axisX, float axisY, float axisZ) {
		return this.mul(tmpMat.setToRotationRad(axisX, axisY, axisZ, radians));
	}

	/** Rotates this vector by the given angle in degrees around the given axis.
	 *
	 * @param axis the axis
	 * @param degrees the angle in degrees
	 * @return This vector for chaining */
	public Vector3 rotate (final Vector3 axis, float degrees) {
		tmpMat.setToRotation(axis, degrees);
		return this.mul(tmpMat);
	}

	/** Rotates this vector by the given angle in radians around the given axis.
	 *
	 * @param axis the axis
	 * @param radians the angle in radians
	 * @return This vector for chaining */
	public Vector3 rotateRad (final Vector3 axis, float radians) {
		tmpMat.setToRotationRad(axis, radians);
		return this.mul(tmpMat);
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
		return getX() == 0 && getY() == 0 && getZ() == 0;
	}

	@Override
	public boolean isZero (final float margin) {
		return len2() < margin;
	}

	@Override
	public boolean isOnLine (Vector3 other, float epsilon) {
		return len2(getY() * other.getZ() - getZ() * other.getY(), getZ() * other.getX() - getX() * other.getZ(), getX() * other.getY() - getY() * other.getX()) <= epsilon;
	}

	@Override
	public boolean isOnLine (Vector3 other) {
		return len2(getY() * other.getZ() - getZ() * other.getY(), getZ() * other.getX() - getX() * other.getZ(), getX() * other.getY() - getY() * other.getX()) <= MathUtils.FLOAT_ROUNDING_ERROR;
	}

	@Override
	public boolean isCollinear (Vector3 other, float epsilon) {
		return isOnLine(other, epsilon) && hasSameDirection(other);
	}

	@Override
	public boolean isCollinear (Vector3 other) {
		return isOnLine(other) && hasSameDirection(other);
	}

	@Override
	public boolean isCollinearOpposite (Vector3 other, float epsilon) {
		return isOnLine(other, epsilon) && hasOppositeDirection(other);
	}

	@Override
	public boolean isCollinearOpposite (Vector3 other) {
		return isOnLine(other) && hasOppositeDirection(other);
	}

	@Override
	public boolean isPerpendicular (Vector3 vector) {
		return MathUtils.isZero(dot(vector));
	}

	@Override
	public boolean isPerpendicular (Vector3 vector, float epsilon) {
		return MathUtils.isZero(dot(vector), epsilon);
	}

	@Override
	public boolean hasSameDirection (Vector3 vector) {
		return dot(vector) > 0;
	}

	@Override
	public boolean hasOppositeDirection (Vector3 vector) {
		return dot(vector) < 0;
	}

	@Override
	public Vector3 lerp (final Vector3 target, float alpha) {
		setX(getX() + alpha * (target.getX() - getX()));
		setY(getY() + alpha * (target.getY() - getY()));
		setZ(getZ() + alpha * (target.getZ() - getZ()));
		return this;
	}

	@Override
	public Vector3 interpolate (Vector3 target, float alpha, Interpolation interpolator) {
		return lerp(target, interpolator.apply(0f, 1f, alpha));
	}

	/** Spherically interpolates between this vector and the target vector by alpha which is in the range [0,1]. The result is
	 * stored in this vector.
	 *
	 * @param target The target vector
	 * @param alpha The interpolation coefficient
	 * @return This vector for chaining. */
	public Vector3 slerp (final Vector3 target, float alpha) {
		final float dot = dot(target);
		// If the inputs are too close for comfort, simply linearly interpolate.
		if (dot > 0.9995 || dot < -0.9995) return lerp(target, alpha);

		// theta0 = angle between input vectors
		final float theta0 = (float)Math.acos(dot);
		// theta = angle between this vector and result
		final float theta = theta0 * alpha;

		final float st = (float)Math.sin(theta);
		final float tx = target.getX() - getX() * dot;
		final float ty = target.getY() - getY() * dot;
		final float tz = target.getZ() - getZ() * dot;
		final float l2 = squareSum(tx, ty, tz);
		final float dl = st * ((l2 < 0.0001f) ? 1f : 1f / (float)Math.sqrt(l2));

		return scl((float)Math.cos(theta)).add(tx * dl, ty * dl, tz * dl).nor();
	}

	/** Converts this {@code Vector3} to a string in the format {@code (x,y,z)}.
	 * @return a string representation of this object. */
	@Override
	public String toString () {
		return "(" + getX() + "," + getY() + "," + getZ() + ")";
	}

	/** Sets this {@code Vector3} to the value represented by the specified string according to the format of {@link #toString()}.
	 * @param v the string.
	 * @return this vector for chaining */
	public Vector3 fromString (String v) {
		int s0 = v.indexOf(',', 1);
		int s1 = v.indexOf(',', s0 + 1);
		if (s0 != -1 && s1 != -1 && v.charAt(0) == '(' && v.charAt(v.length() - 1) == ')') {
			try {
				float x = Float.parseFloat(v.substring(1, s0));
				float y = Float.parseFloat(v.substring(s0 + 1, s1));
				float z = Float.parseFloat(v.substring(s1 + 1, v.length() - 1));
				return this.set(x, y, z);
			} catch (NumberFormatException ex) {
				// Throw a GdxRuntimeException
			}
		}
		throw new GdxRuntimeException("Malformed Vector3: " + v);
	}

	@Override
	public Vector3 limit (float limit) {
		return limit2(limit * limit);
	}

	@Override
	public Vector3 limit2 (float limit2) {
		float len2 = len2();
		if (len2 > limit2) {
			scl((float)Math.sqrt(limit2 / len2));
		}
		return this;
	}

	@Override
	public Vector3 setLength (float len) {
		return setLength2(len * len);
	}

	@Override
	public Vector3 setLength2 (float len2) {
		float oldLen2 = len2();
		return (oldLen2 == 0 || oldLen2 == len2) ? this : scl((float)Math.sqrt(len2 / oldLen2));
	}

	@Override
	public Vector3 clamp (float min, float max) {
		final float len2 = len2();
		if (len2 == 0f) return this;
		float max2 = max * max;
		if (len2 > max2) return scl((float)Math.sqrt(max2 / len2));
		float min2 = min * min;
		if (len2 < min2) return scl((float)Math.sqrt(min2 / len2));
		return this;
	}

	@Override
	public int hashCode () {
		final int prime = 31;
		int result = 1;
		result = prime * result + NumberUtils.floatToIntBits(getX());
		result = prime * result + NumberUtils.floatToIntBits(getY());
		result = prime * result + NumberUtils.floatToIntBits(getZ());
		return result;
	}

	@Override
	public boolean equals (Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Vector3 other = (Vector3)obj;
		if (NumberUtils.floatToIntBits(getX()) != NumberUtils.floatToIntBits(other.getX())) return false;
		if (NumberUtils.floatToIntBits(getY()) != NumberUtils.floatToIntBits(other.getY())) return false;
		if (NumberUtils.floatToIntBits(getZ()) != NumberUtils.floatToIntBits(other.getZ())) return false;
		return true;
	}

	@Override
	public boolean epsilonEquals (final Vector3 other, float epsilon) {
		if (other == null) return false;
		if (Math.abs(other.getX() - getX()) > epsilon) return false;
		if (Math.abs(other.getY() - getY()) > epsilon) return false;
		if (Math.abs(other.getZ() - getZ()) > epsilon) return false;
		return true;
	}

	/** Compares this vector with the other vector, using the supplied epsilon for fuzzy equality testing.
	 * @return whether the vectors are the same. */
	public boolean epsilonEquals (float x, float y, float z, float epsilon) {
		if (Math.abs(x - this.getX()) > epsilon) return false;
		if (Math.abs(y - this.getY()) > epsilon) return false;
		if (Math.abs(z - this.getZ()) > epsilon) return false;
		return true;
	}

	@Override
	public Vector3 setZero () {
		this.setX(0);
		this.setY(0);
		this.setZ(0);
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

	public float getZ () {
		return z;
	}

	public void setZ (float z) {
		this.z = z;
	}
}
