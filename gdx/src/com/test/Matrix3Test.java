package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.badlogic.gdx.math.Affine2;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class Matrix3Test {
	private static Matrix3 matrix;
	@BeforeClass
	public static void setUpBeforeClass () throws Exception {
		matrix = new Matrix3();
	}

	@AfterClass
	public static void tearDownAfterClass () throws Exception {
	}

	@Before
	public void setUp () throws Exception {
	}

	@After
	public void tearDown () throws Exception {
	}
	
	/**
	 * 
	 * Parameter : Matrix3(), set(Matrix3)
	 * Input : 0.1f, 0.2f, 0.3f, 1.0f, 1.1f, 1.2f, 2.0f, 2.1f, 2.2f
	 * Expected Output : 0.1f, 0.2f, 0.3f, 1.0f, 1.1f, 1.2f, 2.0f, 2.1f, 2.2f
	 * Actual Output : 0.1f, 0.2f, 0.3f, 1.0f, 1.1f, 1.2f, 2.0f, 2.1f, 2.2f
	 * 
	 */
	@Test
	public void testMatrix3 () {
		float[] values = {0.1f, 0.2f, 0.3f, 1.0f, 1.1f, 1.2f, 2.0f, 2.1f, 2.2f};
		matrix.set(values);
		
		Matrix3 mat = new Matrix3(values);
		Matrix3 matt = new Matrix3(matrix);
		
		assertEquals(0.1f, mat.val[0], 0.1);
		assertEquals(0.2f, mat.val[1], 0.1);
		assertEquals(0.3f, mat.val[2], 0.1);
		assertEquals(1.0f, mat.val[3], 0.1);
		assertEquals(1.1f, mat.val[4], 0.1);
		assertEquals(1.2f, mat.val[5], 0.1);
		assertEquals(2.0f, mat.val[6], 0.1);
		assertEquals(2.1f, mat.val[7], 0.1);
		assertEquals(2.2f, mat.val[8], 0.1);
		
		assertEquals(0.1f, matt.val[0], 0.1);
		assertEquals(0.2f, matt.val[1], 0.1);
		assertEquals(0.3f, matt.val[2], 0.1);
		assertEquals(1.0f, matt.val[3], 0.1);
		assertEquals(1.1f, matt.val[4], 0.1);
		assertEquals(1.2f, matt.val[5], 0.1);
		assertEquals(2.0f, matt.val[6], 0.1);
		assertEquals(2.1f, matt.val[7], 0.1);
		assertEquals(2.2f, matt.val[8], 0.1);
	}

	/**
	 * 
	 * Effect : Matrix3 Initial Setting with Float Array
	 * Parameter : set(float)
	 * Input : 0.1f, 0.2f, 0.3f, 1.0f, 1.1f, 1.2f, 2.0f, 2.1f, 2.2f
	 * Expected Output : 0.1f, 0.2f, 0.3f, 1.0f, 1.1f, 1.2f, 2.0f, 2.1f, 2.2f
	 * Actual Output : 0.1f, 0.2f, 0.3f, 1.0f, 1.1f, 1.2f, 2.0f, 2.1f, 2.2f
	 * 
	 */
	@Test
	public void testSetFloatArray () {
		float[] values = {0.1f, 0.2f, 0.3f, 1.0f, 1.1f, 1.2f, 2.0f, 2.1f, 2.2f};
		matrix.set(values);
		
		assertEquals(0.1f, matrix.val[0], 0.1);
		assertEquals(0.2f, matrix.val[1], 0.1);
		assertEquals(0.3f, matrix.val[2], 0.1);
		assertEquals(1.0f, matrix.val[3], 0.1);
		assertEquals(1.1f, matrix.val[4], 0.1);
		assertEquals(1.2f, matrix.val[5], 0.1);
		assertEquals(2.0f, matrix.val[6], 0.1);
		assertEquals(2.1f, matrix.val[7], 0.1);
		assertEquals(2.2f, matrix.val[8], 0.1);
	}

	/**
	 * 
	 * Effect : Matrix3 Initial Setting with Matrix3 Class
	 * Parameter : set(Matrix3)
	 * Input : 0.1f, 0.2f, 0.3f, 1.0f, 1.1f, 1.2f, 2.0f, 2.1f, 2.2f
	 * Expected Output : 0.1f, 0.2f, 0.3f, 1.0f, 1.1f, 1.2f, 2.0f, 2.1f, 2.2f
	 * Actual Output : 0.1f, 0.2f, 0.3f, 1.0f, 1.1f, 1.2f, 2.0f, 2.1f, 2.2f
	 * 
	 */
	@Test
	public void testSetMatrix3 () {
		Matrix3 testMatrix = new Matrix3();
		float[] values1 = {0.1f, 0.2f, 0.3f, 1.0f, 1.1f, 1.2f, 2.0f, 2.1f, 2.2f};
		float[] values2 = {1.1f, 2.2f, 3.3f, 4.0f, 5.1f, 6.2f, 7.2f, 8.2f, 9.2f};
		
		matrix.set(values2);
		testMatrix.set(values1);
		matrix.set(testMatrix);
		
		assertEquals(0.1f, matrix.val[0], 0.1);
		assertEquals(0.2f, matrix.val[1], 0.1);
		assertEquals(0.3f, matrix.val[2], 0.1);
		assertEquals(1.0f, matrix.val[3], 0.1);
		assertEquals(1.1f, matrix.val[4], 0.1);
		assertEquals(1.2f, matrix.val[5], 0.1);
		assertEquals(2.0f, matrix.val[6], 0.1);
		assertEquals(2.1f, matrix.val[7], 0.1);
		assertEquals(2.2f, matrix.val[8], 0.1);
	}
	
	/**
	 * 
	 * Effect : Matrix3 Initial Setting with Affine2 Function
	 * Parameter : set(Affine2)
	 * Input : Affine2()
	 * Expected Output : affine2
	 * Actual Output : 1, 0, 0, 0, 1, 0, 0, 0, 1
	 * 
	 */
	@Test
	public void testSetAffine2 () {
		Affine2 affine2 = new Affine2();
		matrix.set(affine2);
		
		assertEquals(1, matrix.val[0], 0.1);
		assertEquals(0, matrix.val[1], 0.1);
		assertEquals(0, matrix.val[2], 0.1);
		assertEquals(0, matrix.val[3], 0.1);
		assertEquals(1, matrix.val[4], 0.1);
		assertEquals(0, matrix.val[5], 0.1);
		assertEquals(0, matrix.val[6], 0.1);
		assertEquals(0, matrix.val[7], 0.1);
		assertEquals(1, matrix.val[8], 0.1);
	}

	/**
	 * 
	 * Effect : Matrix3 Initial Setting with Matrix4 Class
	 * Parameter : set(Matrix4)
	 * Input : Affine2()
	 * Expected Output : 0.1f, 0.2f, 0.3f, 1.0f, 1.1f, 1.2f, 0.2f, 1.2f, 2.2f, 1.5f, 1.3f, 2.5f, 6.5f, 7.6f, 9.0f, 1.3f
	 * Actual Output : 1.1f, 2.2f, 3.3f, 4.0f, 5.1f, 6.2f, 7.2f, 8.2f, 9.2f
	 * 
	 */
	@Test
	public void testSetMatrix4 () {
		Matrix4 testMatrix = new Matrix4();
		float[] values1 = {0.1f, 0.2f, 0.3f, 1.0f, 1.1f, 1.2f, 0.2f, 1.2f, 2.2f, 1.5f, 1.3f, 2.5f, 6.5f, 7.6f, 9.0f, 1.3f};
		float[] values2 = {1.1f, 2.2f, 3.3f, 4.0f, 5.1f, 6.2f, 7.2f, 8.2f, 9.2f};
		
		matrix.set(values2);
		testMatrix.set(values1);
		matrix.set(testMatrix);
		
		assertEquals(0.1f, matrix.val[0], 0.1);
		assertEquals(0.2f, matrix.val[1], 0.1);
		assertEquals(0.3f, matrix.val[2], 0.1);
		assertEquals(1.1f, matrix.val[3], 0.1);
		assertEquals(1.2f, matrix.val[4], 0.1);
		assertEquals(0.2f, matrix.val[5], 0.1);
		assertEquals(2.2f, matrix.val[6], 0.1);
		assertEquals(1.5f, matrix.val[7], 0.1);
		assertEquals(1.3f, matrix.val[8], 0.1);
	}

	/**
	 * 
	 * Effect : Two Matrix3 Multiplication
	 * Parameter : mul(Matrix3)
	 * Input : (1,2,3, 4,5,6, 7,8,9) * (1,4,7, 2,5,8, 3,6,9)
	 * Expected Output : (66,78,90, 78,93,108, 90,108,126)
 	 * Actual Output : (66,78,90, 78,93,108, 90,108,126)
	 * 
	 */
	
	@Test
	public void testMul () {
		Matrix3 testMatrix = new Matrix3();
		float[] values1 = {1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f, 9f};
		float[] values2 = {1f, 4f, 7f, 2f, 5f, 8f, 3f, 6f, 9f};

		matrix.set(values1);
		testMatrix.set(values2);
		
		matrix.mul(testMatrix);

		assertEquals(66, matrix.val[0], 0.1);
		assertEquals(78, matrix.val[1], 0.1);
		assertEquals(90, matrix.val[2], 0.1);
		assertEquals(78, matrix.val[3], 0.1);
		assertEquals(93, matrix.val[4], 0.1);
		assertEquals(108, matrix.val[5], 0.1);
		assertEquals(90, matrix.val[6], 0.1);
		assertEquals(108, matrix.val[7], 0.1);
		assertEquals(126, matrix.val[8], 0.1);
	}
	
	/**
	 * 
	 * Effect : Two Matrix3 Multiplication 
	 * Parameter : mulLeft(Matrix3)
	 * Input : (1,4,7, 2,5,8, 3,6,9) * (1,2,3, 4,5,6, 7,8,9) 
	 * Expected Output : (14,32,50, 32,77,122, 50,122,194)
 	 * Actual Output : (14,32,50, 32,77,122, 50,122,194)
	 * 
	 */
	
	@Test
	public void testMulLeft () {
		Matrix3 testMatrix = new Matrix3();
		float[] values1 = {1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f, 9f};
		float[] values2 = {1f, 4f, 7f, 2f, 5f, 8f, 3f, 6f, 9f};

		matrix.set(values1);
		testMatrix.set(values2);
		
		matrix.mulLeft(testMatrix);
		
		assertEquals(14f, matrix.val[0], 0.1);
		assertEquals(32f, matrix.val[1], 0.1);
		assertEquals(50f, matrix.val[2], 0.1);
		assertEquals(32f, matrix.val[3], 0.1);
		assertEquals(77f, matrix.val[4], 0.1);
		assertEquals(122f, matrix.val[5], 0.1);
		assertEquals(50f, matrix.val[6], 0.1);
		assertEquals(122f, matrix.val[7], 0.1);
		assertEquals(194f, matrix.val[8], 0.1);
	}

	/**
	 * 
	 * Effect : Set Rotation with Radian
	 * Parameter : setToRotationRad(float)
	 * Input : 2/pi 
	 * Expected Output : (0,1,0 -1,0,0, 0,0,1)
 	 * Actual Output : (0,1,0 -1,0,0, 0,0,1)
	 * 
	 */
	
	@Test
	public void testSetToRotationRad () {
		float radians = (float) Math.PI/2;
		float cos = (float)Math.cos(radians);
		float sin = (float)Math.sin(radians);

		matrix.setToRotationRad(radians);
		
		assertEquals(0, matrix.val[0], 0.1);
		assertEquals(1, matrix.val[1], 0.1);
		assertEquals(0, matrix.val[2], 0.1);
		assertEquals(-1, matrix.val[3], 0.1);
		assertEquals(0, matrix.val[4], 0.1);
		assertEquals(0, matrix.val[5], 0.1);
		assertEquals(0, matrix.val[6], 0.1);
		assertEquals(0, matrix.val[7], 0.1);
		assertEquals(1, matrix.val[8], 0.1);
	}
	
	/**
	 * 
	 * Effect : Set Rotation with Degree
	 * Parameter : setToRotationRad(float)
	 * Input : 90f
	 * Expected Output : (0,1,0 -1,0,0, 0,0,1)
 	 * Actual Output : (0,1,0 -1,0,0, 0,0,1)
	 * 
	 */
	
	@Test
	public void testSetToRotation () {
		float degree = (float) 90f;
		float cos = (float)Math.cos(degree);
		float sin = (float)Math.sin(degree);

		matrix.setToRotation(degree);
		
		assertEquals(0, matrix.val[0], 0.1);
		assertEquals(1, matrix.val[1], 0.1);
		assertEquals(0, matrix.val[2], 0.1);
		assertEquals(-1, matrix.val[3], 0.1);
		assertEquals(0, matrix.val[4], 0.1);
		assertEquals(0, matrix.val[5], 0.1);
		assertEquals(0, matrix.val[6], 0.1);
		assertEquals(0, matrix.val[7], 0.1);
		assertEquals(1, matrix.val[8], 0.1);
	}

	/**
	 * 
	 * Effect : Set Rotation with Vector3, sin, cos
	 * Parameter : setToRotationRad(float)
	 * Input : (0.1, 0.2, 0.3), cos(90), sin(90)
	 * Expected Output : (0,1,0 -1,0,0, 0,0,1)
 	 * Actual Output : (0,1,0 -1,0,0, 0,0,1)
	 * 
	 */
	
	@Test
	public void testSetToRotationVector3FloatFloat () {
		Vector3 axis = new Vector3(0.1f, 0.2f, 0.3f);
		float degrees = 90f;
		
		Matrix3 testMatrix = matrix.setToRotation(axis, degrees);
		
		assertEquals(0, testMatrix.val[0], 0.01);
		assertEquals(-0.3, testMatrix.val[1], 0.1);
		assertEquals(0.2, testMatrix.val[2], 0.1);
		assertEquals(0.3, testMatrix.val[3], 0.1);
		assertEquals(0, testMatrix.val[4], 0.1);
		assertEquals(-0.1, testMatrix.val[5], 0.1);
		assertEquals(-0.2, testMatrix.val[6], 0.1);
		assertEquals(0.1, testMatrix.val[7], 0.1);
		assertEquals(0, testMatrix.val[8], 0.1);
		
	}

	/**
	 * 
	 * Effect : Set Translation with Vector2
	 * Parameter : setToTranslation(Vector2)
	 * Input : (3,4)
	 * Expected Output : (1,0,0 0,1,0, 3,4,1)
 	 * Actual Output : (1,0,0 0,1,0, 3,4,1)
	 * 
	 */
	
	@Test
	public void testSetToTranslationVector2 () {
		float x = 3f, y = 4f;

		Vector2 vector2 = new Vector2(x,y);
		matrix.setToTranslation(vector2);
		
		assertEquals(1, matrix.val[0], 0.1);
		assertEquals(0, matrix.val[1], 0.1);
		assertEquals(0, matrix.val[2], 0.1);
		assertEquals(0, matrix.val[3], 0.1);
		assertEquals(1, matrix.val[4], 0.1);
		assertEquals(0, matrix.val[5], 0.1);
		assertEquals(3, matrix.val[6], 0.1);
		assertEquals(4, matrix.val[7], 0.1);
		assertEquals(1, matrix.val[8], 0.1);
	}

	/**
	 * 
	 * Effect : Set Translation with Two Float 
	 * Parameter : setToTranslation(Vector2)
	 * Input : (3,4)
	 * Expected Output : (1,0,0 0,1,0, 3,4,1)
 	 * Actual Output : (1,0,0 0,1,0, 3,4,1)
	 * 
	 */
	
	@Test
	public void testSetToTranslationFloatFloat () {
		float x = 3f, y = 4f;
		
		matrix.setToTranslation(x,y);
		
		assertEquals(1, matrix.val[0], 0.1);
		assertEquals(0, matrix.val[1], 0.1);
		assertEquals(0, matrix.val[2], 0.1);
		assertEquals(0, matrix.val[3], 0.1);
		assertEquals(1, matrix.val[4], 0.1);
		assertEquals(0, matrix.val[5], 0.1);
		assertEquals(3, matrix.val[6], 0.1);
		assertEquals(4, matrix.val[7], 0.1);
		assertEquals(1, matrix.val[8], 0.1);
	}
	
	/**
	 * 
	 * Effect : Set Scaling with Two Float
	 * Parameter : setToScaling(float)
	 * Input : (3,4)
	 * Expected Output : (3,0,0 0,4,0, 0,0,1)
 	 * Actual Output : (3,0,0 0,4,0, 0,0,1)
	 * 
	 */
	
	@Test
	public void testSetToScalingFloatFloat () {
		float x = 3f, y = 4f;

		matrix.setToScaling(x, y);
		
		assertEquals(x, matrix.val[0], 0.1);
		assertEquals(0, matrix.val[1], 0.1);
		assertEquals(0, matrix.val[2], 0.1);
		assertEquals(0, matrix.val[3], 0.1);
		assertEquals(y, matrix.val[4], 0.1);
		assertEquals(0, matrix.val[5], 0.1);
		assertEquals(0, matrix.val[6], 0.1);
		assertEquals(0, matrix.val[7], 0.1);
		assertEquals(1, matrix.val[8], 0.1);
	}
	
	/**
	 * 
	 * Effect : Set Scaling with Vector2
	 * Parameter : setToScaling(Vector2)
	 * Input : (3,4)
	 * Expected Output : (3,0,0 0,4,0, 0,0,1)
 	 * Actual Output : (3,0,0 0,4,0, 0,0,1)
	 * 
	 */
	
	@Test
	public void testSetToScalingVector2 () {
		float x = 3f, y = 4f;

		Vector2 vector2 = new Vector2(x,y);
		matrix.setToScaling(vector2);
		
		assertEquals(x, matrix.val[0], 0.1);
		assertEquals(0, matrix.val[1], 0.1);
		assertEquals(0, matrix.val[2], 0.1);
		assertEquals(0, matrix.val[3], 0.1);
		assertEquals(y, matrix.val[4], 0.1);
		assertEquals(0, matrix.val[5], 0.1);
		assertEquals(0, matrix.val[6], 0.1);
		assertEquals(0, matrix.val[7], 0.1);
		assertEquals(1, matrix.val[8], 0.1);
	}

	/**
	 * 
	 * Effect : Print Matrix3
	 * Parameter : toString()
	 * Input : 
	 * Expected Output : [1|0|0]\n[0|1|0]\n[0|0|1]
 	 * Actual Output : [1|0|0]\n[0|1|0]\n[0|0|1]
	 * 
	 */
	
	@Test
	public void testToString () {
		String string = "[" + matrix.val[matrix.M00] + "|" + matrix.val[matrix.M01] + "|" + matrix.val[matrix.M02] + "]\n" //
			+ "[" + matrix.val[matrix.M10] + "|" + matrix.val[matrix.M11] + "|" + matrix.val[matrix.M12] + "]\n" //
			+ "[" + matrix.val[matrix.M20] + "|" + matrix.val[matrix.M21] + "|" + matrix.val[matrix.M22] + "]";
		
		String temp = matrix.toString();
		
		assertEquals(string, temp);
	}

	/**
	 * 
	 * Effect : Return Matrix Determinant
	 * Parameter : det()
	 * Input : (1,2,3, 4,5,6, 7,8,9)
	 * Expected Output : 0
 	 * Actual Output : 0
	 * 
	 */
	@Test
	public void testDet () {
		float[] values1 = {1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f, 9f};

		matrix.set(values1);
		float det = matrix.det();

		assertEquals(0, det, 0.1);
	}

	/**
	 * 
	 * Effect : Return Inverse Matrix
	 * Parameter : inv()
	 * Input : (-1,1,2, 3,-1,1, -1,3,4), (1,1,1, 1,1,1, 1,1,1) 
	 * Expected Output : (-0.7,0.2,0.3, -1.3,-0.2,0.7, 0.8,0.2,-0.2), Error
 	 * Actual Output : (-0.7,0.2,0.3, -1.3,-0.2,0.7, 0.8,0.2,-0.2), Error
	 * 
	 */
	@Test
	public void testInv () {
		float[] values1 = {-1f, 1f, 2f, 3f, -1f, 1f, -1f, 3f, 4f};
		float[] values2 = {1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f};
		matrix.set(values1);
		matrix.inv();
		
		assertEquals(-0.7, matrix.val[0], 0.01);
		assertEquals(0.2, matrix.val[1], 0.01);
		assertEquals(0.3, matrix.val[2], 0.01);
		assertEquals(-1.3, matrix.val[3], 0.01);
		assertEquals(-0.2, matrix.val[4], 0.01);
		assertEquals(0.7, matrix.val[5], 0.01);
		assertEquals(0.8, matrix.val[6], 0.01);
		assertEquals(0.2, matrix.val[7], 0.01);
		assertEquals(-0.2, matrix.val[8], 0.01);
		
		matrix.set(values2);
		matrix.inv();
	}

	/**
	 * 
	 * Effect : Adds a translational component(Using float,float) to the matrix in the 3rd column. The other columns are untouched.
	 * Parameter : trn()
	 * Input : (1,2,3, 4,5,6, 7,8,9) 
	 * Expected Output : 10(val[6]), 12(val[7])
 	 * Actual Output : 10(val[6]), 12(val[7])
	 * 
	 */
	
	@Test
	public void testTrnFloatFloat () {
		float x = 3f, y = 4f;
		float[] values1 = {1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f, 9f};

		matrix.set(values1);
		matrix.trn(x,y);
		
		assertEquals(10, matrix.val[6], 0.1);
		assertEquals(12, matrix.val[7], 0.1);
	}

	/**
	 * 
	 * Effect : Adds a translational component(Using Vector2) to the matrix in the 3rd column. The other columns are untouched.
	 * Parameter : trn()
	 * Input : (1,2,3, 4,5,6, 7,8,9) 
	 * Expected Output : 10(val[6]), 12(val[7])
 	 * Actual Output : 10(val[6]), 12(val[7])
	 * 
	 */
	
	@Test
	public void testTrnVector2 () {
		float x = 3f, y = 4f;

		Vector2 vector2 = new Vector2(x,y);
		float[] values1 = {1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f, 9f};

		matrix.set(values1);
		matrix.trn(vector2);
		
		assertEquals(10, matrix.val[6], 0.1);
		assertEquals(12, matrix.val[7], 0.1);
	}

	/**
	 * 
	 * Effect : Adds a translational component(Using Vector3) to the matrix in the 3rd column. The other columns are untouched.
	 * Parameter : trn()
	 * Input : (1,2,3, 4,5,6, 7,8,9) 
	 * Expected Output : 10(val[6]), 12(val[7])
 	 * Actual Output : 10(val[6]), 12(val[7])
	 * 
	 */
	
	
	@Test
	public void testTrnVector3 () {
		float x = 3f, y = 4f, z = 5f;

		Vector3 vector3 = new Vector3(x,y,z);
		float[] values1 = {1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f, 9f};

		matrix.set(values1);
		matrix.trn(vector3);
		
		assertEquals(10, matrix.val[6], 0.1);
		assertEquals(12, matrix.val[7], 0.1);
	}

	/**
	 * 
	 * Effect : Postmultiplies this matrix by a translation matrix.
	 * Parameter : translate(float, float)
	 * Input : (1,0,0, 0,1,0, 0,0,1), (3,4)
	 * Expected Output : (1,0,0, 0,1,0, 3,4,1)
 	 * Actual Output : (1,0,0, 0,1,0, 3,4,1)
	 * 
	 */
	
	
	@Test
	public void testTranslateFloatFloat () {
		float x = 3f, y = 4f;
		float[] values1 = {1f, 0f, 0f, 0f, 1f, 0f, 0f, 0f, 1f};

		matrix.set(values1);
		matrix.translate(x,y);
		
		assertEquals(1, matrix.val[0], 0.1);
		assertEquals(0, matrix.val[1], 0.1);
		assertEquals(0, matrix.val[2], 0.1);
		assertEquals(0, matrix.val[3], 0.1);
		assertEquals(1, matrix.val[4], 0.1);
		assertEquals(0, matrix.val[5], 0.1);
		assertEquals(x, matrix.val[6], 0.1);
		assertEquals(y, matrix.val[7], 0.1);
		assertEquals(1, matrix.val[8], 0.1);
	}
	
	/**
	 * 
	 * Effect : Postmultiplies this matrix by a translation matrix.
	 * Parameter : translate(Vector2)
	 * Input : (1,0,0, 0,1,0, 0,0,1), (3,4)
	 * Expected Output : (1,0,0, 0,1,0, 3,4,1)
 	 * Actual Output : (1,0,0, 0,1,0, 3,4,1)
	 * 
	 */
	
	@Test
	public void testTranslateVector2 () {
		float x = 3f, y = 4f;

		Vector2 vector2 = new Vector2(x,y);
		float[] values1 = {1f, 0f, 0f, 0f, 1f, 0f, 0f, 0f, 1f};

		matrix.set(values1);
		matrix.translate(vector2);
		
		assertEquals(1, matrix.val[0], 0.1);
		assertEquals(0, matrix.val[1], 0.1);
		assertEquals(0, matrix.val[2], 0.1);
		assertEquals(0, matrix.val[3], 0.1);
		assertEquals(1, matrix.val[4], 0.1);
		assertEquals(0, matrix.val[5], 0.1);
		assertEquals(x, matrix.val[6], 0.1);
		assertEquals(y, matrix.val[7], 0.1);
		assertEquals(1, matrix.val[8], 0.1);
	}

	/**
	 * 
	 * Effect : Postmultiplies this matrix with a (counter-clockwise) rotation matrix
	 * Parameter : rotate(degree)
	 * Input : (1,0,0, 0,1,0, 0,0,1), 90, (1,0,0, 0,,0, 0,0,1), 0
	 * Expected Output : (cos(90),sin(90),0, -sin(90),cos(90),0, 0,0,1), true
 	 * Actual Output : (cos(90),sin(90),0, -sin(90),cos(90),0, 0,0,1), true
	 * 
	 */
	
	@Test
	public void testRotate () {
		float degree = 90;
		float cos = (float)Math.cos(Math.toRadians(degree));
		float sin = (float)Math.sin(Math.toRadians(degree));
		float[] values1 = {1f, 0f, 0f, 0f, 1f, 0f, 0f, 0f, 1f};

		matrix.set(values1);
		Matrix3 testMatrix = matrix.rotate(degree);
		
		assertEquals(cos, testMatrix.val[0], 0.1);
		assertEquals(sin, testMatrix.val[1], 0.1);
		assertEquals(0, testMatrix.val[2], 0.1);
		assertEquals(-sin, testMatrix.val[3], 0.1);
		assertEquals(cos, testMatrix.val[4], 0.1);
		assertEquals(0, testMatrix.val[5], 0.1);
		assertEquals(0, testMatrix.val[6], 0.1);
		assertEquals(0, testMatrix.val[7], 0.1);
		assertEquals(1, testMatrix.val[8], 0.1);
		
		Matrix3 testMatrixZero = matrix.rotate(0);
		boolean zero = (testMatrixZero == matrix);
		assertTrue(zero);
	}

	/**
	 * 
	 * Effect : Postmultiplies this matrix with a scale matrix
	 * Parameter : scale(float, float)
	 * Input : (1,0,0, 0,1,0, 0,0,1)
	 * Expected Output : (3,0,0, 0,4,0, 0,0,1)
 	 * Actual Output : (3,0,0, 0,4,0, 0,0,1)
	 * 
	 */
	
	@Test
	public void testScaleFloatFloat () {
		float x = 3f, y = 4f;

		float[] values1 = {1f, 0f, 0f, 0f, 1f, 0f, 0f, 0f, 1f};

		matrix.set(values1);
		Matrix3 testMatrix = matrix.scale(x,y);

		assertEquals(x, testMatrix.val[0], 0.1);
		assertEquals(0, testMatrix.val[1], 0.1);
		assertEquals(0, testMatrix.val[2], 0.1);
		assertEquals(0, testMatrix.val[3], 0.1);
		assertEquals(y, testMatrix.val[4], 0.1);
		assertEquals(0, testMatrix.val[5], 0.1);
		assertEquals(0, testMatrix.val[6], 0.1);
		assertEquals(0, testMatrix.val[7], 0.1);
		assertEquals(1, testMatrix.val[8], 0.1);
	}
	
	/**
	 * 
	 * Effect : Postmultiplies this matrix with a scale matrix
	 * Parameter : scale(Vector2)
	 * Input : (1,0,0, 0,1,0, 0,0,1)
	 * Expected Output : (3,0,0, 0,4,0, 0,0,1)
 	 * Actual Output : (3,0,0, 0,4,0, 0,0,1)
	 * 
	 */
	
	@Test
	public void testScaleVector2 () {
		float x = 3f, y = 4f;

		Vector2 vector2 = new Vector2(x,y);
		float[] values1 = {1f, 0f, 0f, 0f, 1f, 0f, 0f, 0f, 1f};

		matrix.set(values1);
		Matrix3 testMatrix = matrix.scale(vector2);

		assertEquals(x, testMatrix.val[0], 0.1);
		assertEquals(0, testMatrix.val[1], 0.1);
		assertEquals(0, testMatrix.val[2], 0.1);
		assertEquals(0, testMatrix.val[3], 0.1);
		assertEquals(y, testMatrix.val[4], 0.1);
		assertEquals(0, testMatrix.val[5], 0.1);
		assertEquals(0, testMatrix.val[6], 0.1);
		assertEquals(0, testMatrix.val[7], 0.1);
		assertEquals(1, testMatrix.val[8], 0.1);
	}

	/**
	 * 
	 * Effect : Get the values in this matrix
	 * Parameter : getValues()
	 * Input : (1,0,0, 0,1,0, 0,0,1)
	 * Expected Output : (1,0,0, 0,1,0, 0,0,1)
 	 * Actual Output : (1,0,0, 0,1,0, 0,0,1)
	 * 
	 */
	
	@Test
	public void testGetValues () {
		float[] values1 = {1f, 0f, 0f, 0f, 1f, 0f, 0f, 0f, 1f};
		
		matrix.set(values1);
		float[] values2 = matrix.getValues();

		boolean result = values1.equals(values2);
		
		assertEquals(1, values2[0], 0.1);
		assertEquals(0, values2[1], 0.1);
		assertEquals(0, values2[2], 0.1);
		assertEquals(0, values2[3], 0.1);
		assertEquals(1, values2[4], 0.1);
		assertEquals(0, values2[5], 0.1);
		assertEquals(0, values2[6], 0.1);
		assertEquals(0, values2[7], 0.1);
		assertEquals(1, values2[8], 0.1);
	}

	/**
	 * 
	 * Effect : Get the translation in this matrix
	 * Parameter : getTranslation(vector2)
	 * Input : (1,0,0, 0,1,0, 3,4,1)
	 * Expected Output : (3,4)
 	 * Actual Output : (3,4)
	 * 
	 */
	
	@Test
	public void testGetTranslation () {
		float x = 3f, y = 4f;

		Vector2 vector2 = new Vector2(x,y);
		float[] values1 = {1f, 0f, 0f, 0f, 1f, 0f, 3f, 4f, 1f};
		
		matrix.set(values1);
		Vector2 testVector2 = matrix.getTranslation(vector2);
		
		assertEquals(vector2.x, testVector2.x, 0.1);
		assertEquals(vector2.y, testVector2.y, 0.1);
	}

	/**
	 * 
	 * Effect : Get the scales in this matrix
	 * Parameter : getScale(float, float)
	 * Input : (3,5,0, 4,12,0, 0,0,1)
	 * Expected Output : (1,0,0, 0,1,0, 0,0,1)
 	 * Actual Output : (1,0,0, 0,1,0, 0,0,1)
	 * 
	 */
	
	@Test
	public void testGetScale () {
		float[] values1 = {3f, 5f, 0f, 4f, 12f, 0f, 0f, 0f, 1f};
		float x = 0, y = 0f;

		Vector2 vector2 = new Vector2(x,y);
		matrix.set(values1);
		Vector2 testVector = matrix.getScale(vector2);
		
		assertEquals(5f, testVector.x, 0.1);
		assertEquals(13f, testVector.y, 0.1);
	}

	/**
	 * 
	 * Effect : Get the rotations in this matrix
	 * Parameter : getRotation(float, float)
	 * Input : (3,3,0, 4,12,0, 0,0,1)
	 * Expected Output : 45f
 	 * Actual Output : 45f
	 * 
	 */
	
	@Test
	public void testGetRotation () {
		float degree = 45f;		
		float[] values1 = {3f, 3f, 0f, 4f, 12f, 0f, 0f, 0f, 1f};

		matrix.set(values1);
		float cmpDegree= matrix.getRotation();
		assertEquals(degree, cmpDegree, 0.1);
	}

	/**
	 * 
	 * Effect : Get the Radian rotations in this matrix
	 * Parameter : getRotationRad(float, float)
	 * Input : (3,3,0, 4,12,0, 0,0,1)
	 * Expected Output : 1/(4/pi)
 	 * Actual Output : 1/(4/pi)
	 * 
	 */
	
	@Test
	public void testGetRotationRad () {
		float radian = 1/(4/(float)Math.PI);		
		float[] values1 = {3f, 3f, 0f, 4f, 12f, 0f, 0f, 0f, 1f};

		matrix.set(values1);
		float cmpRadian= matrix.getRotationRad();
		assertEquals(radian, cmpRadian, 0.1);
	}

	/**
	 * 
	 * Effect : Scale the matrix in the both the x and y components by the scalar value
	 * Parameter : scl(float)
	 * Input : (1,0,0, 0,1,0, 3,4,1), 3f
	 * Expected Output : 3(val[0]), 3(val[4])
 	 * Actual Output : 3(val[0]), 3(val[4])
	 * 
	 */
	
	@Test
	public void testSclFloat () {
		float x = 3f;
		float[] values1 = {1f, 0f, 0f, 0f, 1f, 0f, 3f, 4f, 1f};
		
		matrix.set(values1);
		Matrix3 testMatrix = matrix.scl(x);
		assertEquals(x, testMatrix.val[0], 0.1);
		assertEquals(x, testMatrix.val[4], 0.1);
		
	}

	/**
	 * 
	 * Effect : Scale the matrix in the both the x and y components by the scalar value
	 * Parameter : scl(Vector2)
	 * Input : (1,0,0, 0,1,0, 3,4,1), (3f,4f)
	 * Expected Output : 3(val[0]), 4(val[4])
 	 * Actual Output : 3(val[0]), 4(val[4])
	 * 
	 */
	
	@Test
	public void testSclVector2 () {
		float x = 3f, y = 4f;
		float[] values1 = {1f, 0f, 0f, 0f, 1f, 0f, 3f, 4f, 1f};
		Vector2 vector2 = new Vector2(x,y);
		
		matrix.set(values1);
		Matrix3 testMatrix = matrix.scl(vector2);
		
		assertEquals(x, testMatrix.val[0], 0.1);
		assertEquals(y, testMatrix.val[4], 0.1);
	}

	/**
	 * 
	 * Effect : Scale the matrix in the both the x and y components by the scalar value
	 * Parameter : scl(Vector3)
	 * Input : (1,0,0, 0,1,0, 3,4,1), (3f,4f,5f)
	 * Expected Output : 3(val[0]), 4(val[4])
 	 * Actual Output : 3(val[0]), 4(val[4])
	 * 
	 */
	@Test
	public void testSclVector3 () {
		float x = 3f, y = 4f, z = 5f;
		float[] values1 = {1f, 0f, 0f, 0f, 1f, 0f, 3f, 4f, 1f};
		Vector3 vector3 = new Vector3(x,y,z);
		
		matrix.set(values1);
		Matrix3 testMatrix = matrix.scl(vector3);
		
		assertEquals(x, testMatrix.val[0], 0.1);
		assertEquals(y, testMatrix.val[4], 0.1);
	}
	
	/**
	 * 
	 * Effect : Transposes the current matrix
	 * Parameter : transpose()
	 * Input : (1,2,3, 4,5,6, 7,8,9)
	 * Expected Output : (1,4,7, 2,5,8, 3,6,9)
 	 * Actual Output : (1,4,7, 2,5,8, 3,6,9)
	 * 
	 */

	@Test
	public void testTranspose () {
		float[] values1 = {1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f, 9f};

		matrix.set(values1);
		
		Matrix3 testMatrix = matrix.transpose();
		
		assertEquals(1, matrix.val[0], 0.1);
		assertEquals(4, matrix.val[1], 0.1);
		assertEquals(7, matrix.val[2], 0.1);
		assertEquals(2, matrix.val[3], 0.1);
		assertEquals(5, matrix.val[4], 0.1);
		assertEquals(8, matrix.val[5], 0.1);
		assertEquals(3, matrix.val[6], 0.1);
		assertEquals(6, matrix.val[7], 0.1);
		assertEquals(9, matrix.val[8], 0.1);
	}

}
