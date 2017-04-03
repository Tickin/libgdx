package com.test;

import static org.junit.Assert.*;

import org.junit.*;

import com.badlogic.gdx.math.*;

public class Affine2Test {
	Matrix3 matrix3;
	Matrix4 matrix4;
	Vector2 vector2_1;
	Vector2 vector2_2;
	
	boolean EqualsAffine2(Affine2 l, Affine2 r){
		return l.m00 == r.m00 &&
			l.m01 == r.m01 &&
			l.m02 == r.m02 &&
			l.m10 == r.m10 &&
			l.m11 == r.m11 &&
			l.m12 == r.m12;
	}
	
	@Before
	public void setUp() throws Exception{
		matrix3 = new Matrix3(new float[]{1,0,0,0,1,0,0,0,1});
		matrix4 = new Matrix4(new float[]{1,0,0,2,0,1,0,2,0,0,1,2,0,0,0,2});
		vector2_1 = new Vector2(2,3);
		vector2_2 = new Vector2(5,7);
	}
	
	/*
	 * Purpose: Instantiate the instance of class
	 * Input: Affine2 void
	 * 		 Affine2 affine2(affine2_1):Affine2
	 * Expected:
	 * 		return not null
	 */
	@Test
	public void TestConstructor(){
		Affine2 affine2_1 = new Affine2();
		Affine2 affine2_2 = new Affine2(affine2_1);
		
		assertNotNull(affine2_1);
		assertNotNull(affine2_2);
		assertNotSame(affine2_1, affine2_2);
	}
	
	/*
	 * Purpose: assign value to affine2
	 * Input: set affine2(affine2_1):Affine2
	 * 		 set matrix3(matrix3):Matrix3
	 * 		 set matrix4(matrix4):Matrix4
	 * Expected:
	 * 		its elements equals parameter corresponding elements
	 */
	@Test
	public void TestAssignment(){
		Affine2 affine2_1 = new Affine2();
		Affine2 affine2_2 = new Affine2();
		
		affine2_2.set(affine2_1);
		
		assertEquals(affine2_1.m00, affine2_2.m00, 0.01f);
		assertEquals(affine2_1.m01, affine2_2.m01, 0.01f);
		assertEquals(affine2_1.m02, affine2_2.m02, 0.01f);
		assertEquals(affine2_1.m10, affine2_2.m10, 0.01f);
		assertEquals(affine2_1.m11, affine2_2.m11, 0.01f);
		assertEquals(affine2_1.m12, affine2_2.m12, 0.01f);
		
		assertNotSame(affine2_1, affine2_2);
		
		affine2_1.set(matrix3);

		assertEquals(affine2_1.m00, matrix3.val[Matrix3.M00], 0.01f);
		assertEquals(affine2_1.m01, matrix3.val[Matrix3.M01], 0.01f);
		assertEquals(affine2_1.m02, matrix3.val[Matrix3.M02], 0.01f);
		assertEquals(affine2_1.m10, matrix3.val[Matrix3.M10], 0.01f);
		assertEquals(affine2_1.m11, matrix3.val[Matrix3.M11], 0.01f);
		assertEquals(affine2_1.m12, matrix3.val[Matrix3.M12], 0.01f);
		
		affine2_1.set(matrix4);
		
		assertEquals(affine2_1.m00, matrix4.val[Matrix4.M00], 0.01f);
		assertEquals(affine2_1.m01, matrix4.val[Matrix4.M01], 0.01f);
		assertEquals(affine2_1.m02, matrix4.val[Matrix4.M02], 0.01f);
		assertEquals(affine2_1.m10, matrix4.val[Matrix4.M10], 0.01f);
		assertEquals(affine2_1.m11, matrix4.val[Matrix4.M11], 0.01f);
		assertEquals(affine2_1.m12, matrix4.val[Matrix4.M12], 0.01f);
	}
	
	/*
	 * Purpose: set instance to translation affine matrix
	 * Input: setToTranslation x(5):float y(7):float
	 * 		 setToTranslation translate(2,3):Vector2
	 * Expected:
	 * 		(m02, m12) = (5,7)
	 * 		(m02, m12) = (2,3)
	 */
	@Test
	public void TestSetTranslation(){
		Affine2 affine2_1 = new Affine2();
		
		affine2_1.setToTranslation(5,7);
		
		assertEquals(affine2_1.m00, 1, 0.01f);
		assertEquals(affine2_1.m01, 0, 0.01f);
		assertEquals(affine2_1.m02, 5, 0.01f);
		assertEquals(affine2_1.m10, 0, 0.01f);
		assertEquals(affine2_1.m11, 1, 0.01f);
		assertEquals(affine2_1.m12, 7, 0.01f);
		
		affine2_1.setToTranslation(vector2_1);
		
		assertEquals(affine2_1.m00, 1, 0.01f);
		assertEquals(affine2_1.m01, 0, 0.01f);
		assertEquals(affine2_1.m02, 2, 0.01f);
		assertEquals(affine2_1.m10, 0, 0.01f);
		assertEquals(affine2_1.m11, 1, 0.01f);
		assertEquals(affine2_1.m12, 3, 0.01f);
	}
	
	/*
	 * Purpose: set instance to scaling affine matrix
	 * Input: setToScaling x(3):float y(3):float
	 * 		 setToScaling scale(2,3):Vector2
	 * Expected:
	 * 		(m00, m11) = (3,3)
	 * 		(m00, m11) = (2,3)
	 */
	@Test
	public void TestSetScaling(){
		Affine2 affine2_1 = new Affine2();
		
		affine2_1.setToScaling(3,3);
		
		assertEquals(affine2_1.m00, 3, 0.01f);
		assertEquals(affine2_1.m01, 0, 0.01f);
		assertEquals(affine2_1.m02, 0, 0.01f);
		assertEquals(affine2_1.m10, 0, 0.01f);
		assertEquals(affine2_1.m11, 3, 0.01f);
		assertEquals(affine2_1.m12, 0, 0.01f);
		
		affine2_1.setToScaling(vector2_1);
		
		assertEquals(affine2_1.m00, 2, 0.01f);
		assertEquals(affine2_1.m01, 0, 0.01f);
		assertEquals(affine2_1.m02, 0, 0.01f);
		assertEquals(affine2_1.m10, 0, 0.01f);
		assertEquals(affine2_1.m11, 3, 0.01f);
		assertEquals(affine2_1.m12, 0, 0.01f);
	}
	
	/*
	 * Purpose: set instance to rotation affine matrix
	 * Input: setToRotation degrees(60f):float
	 * 		 setToRotation cos(Math.cos((1/2 - 1/3) * PI)):float sin(Math.sin((1/2 - 1/3) * PI)):float
	 * 		 setToRotationRad radians(1/3 * PI):float
	 * Expected:
	 * 		(m00, m01) = (cos_degree(60f), -sin_degree(60f))
	 * 		(m10, m11) = (sin_degree(60f), sin_degree(60f))
	 * 
	 * 		(m00, m01) = (cos_degree(30f), -sin_degree(30f))
	 * 		(m10, m11) = (sin_degree(30f), sin_degree(30f))
	 * 
	 * 		(m00, m01) = (cos_rad(1/3 * PI), -sin_rad(1/3 * PI))
	 * 		(m10, m11) = (sin_rad(1/3 * PI), sin_rad(1/3 * PI))
	 */
	@Test
	public void TestSetRotation(){
		Affine2 affine2_1 = new Affine2();
		
		float degree = 60f;
		float radians = (float)Math.toRadians(degree);
		
		affine2_1.setToRotation(degree);
		
		assertEquals(affine2_1.m00, (float)Math.cos(radians), 0.01f);
		assertEquals(affine2_1.m01, -(float)Math.sin(radians), 0.01f);
		assertEquals(affine2_1.m02, 0, 0.01f);
		assertEquals(affine2_1.m10, Math.sin(radians), 0.01f);
		assertEquals(affine2_1.m11, Math.cos(radians), 0.01f);
		assertEquals(affine2_1.m12, 0, 0.01f);
		
		affine2_1.setToRotation((float)Math.cos(1/2f - radians), (float)Math.sin(1/2f - radians));
		
		assertEquals(affine2_1.m00, Math.cos(1/2f - radians), 0.01f);
		assertEquals(affine2_1.m01, -Math.sin(1/2f - radians), 0.01f);
		assertEquals(affine2_1.m02, 0, 0.01f);
		assertEquals(affine2_1.m10, Math.sin(1/2f - radians), 0.01f);
		assertEquals(affine2_1.m11, Math.cos(1/2f - radians), 0.01f);
		assertEquals(affine2_1.m12, 0, 0.01f);
		
		affine2_1.setToRotationRad(radians);
		
		assertEquals(affine2_1.m00, Math.cos(radians), 0.01f);
		assertEquals(affine2_1.m01, -Math.sin(radians), 0.01f);
		assertEquals(affine2_1.m02, 0, 0.01f);
		assertEquals(affine2_1.m10, Math.sin(radians), 0.01f);
		assertEquals(affine2_1.m11, Math.cos(radians), 0.01f);
		assertEquals(affine2_1.m12, 0, 0.01f);
	}
	
	/*
	 * Purpose: set instance to scaling shearing matrix
	 * Input: setToShearing x(3):float y(3):float
	 * 		 setToShearing shear(2,3):Vector2
	 * Expected:
	 * 		(m01, m10) = (5,7)
	 * 		(m01, m10) = (2,3)
	 */
	@Test
	public void TestSetShearing(){
		Affine2 affine2_1 = new Affine2();
		
		affine2_1.setToShearing(5,7);
		
		assertEquals(affine2_1.m00, 1, 0.01f);
		assertEquals(affine2_1.m01, 5, 0.01f);
		assertEquals(affine2_1.m02, 0, 0.01f);
		assertEquals(affine2_1.m10, 7, 0.01f);
		assertEquals(affine2_1.m11, 1, 0.01f);
		assertEquals(affine2_1.m12, 0, 0.01f);
		
		affine2_1.setToShearing(vector2_1);
		
		assertEquals(affine2_1.m00, 1, 0.01f);
		assertEquals(affine2_1.m01, 2, 0.01f);
		assertEquals(affine2_1.m02, 0, 0.01f);
		assertEquals(affine2_1.m10, 3, 0.01f);
		assertEquals(affine2_1.m11, 1, 0.01f);
		assertEquals(affine2_1.m12, 0, 0.01f);
	}
	
	/*
	 * Purpose: set instance to affine matrix that apply translation, rotation and scaling
	 * Input: setToTrnRotScl x(5):float y(7):float degrees(60f):float scaleX(3):float scaleY(2):float
	 * 		 setToTrnRotRadScl x(5):float y(7):float radians(1/3 * PI):float scaleX(3):float scaleY(2):float
	 * 		 setToTrnRotScl translation(2,3):Vector2 degrees(60f):float scaling(5,7):Vector2
	 * 		 setToTrnRotRadScl translation(2,3):Vector2 radians(1/3 * PI):float scaling(5,7):Vector2
	 * Expected:
	 * 		(m00, m01, m02) = (3 * cos_degree(60f), 2 * -sin_degree(60f), 5)
	 * 		(m10, m11, m12) = (3 * sin_degree(60f), 2 * cos_degree(60f), 7)
	 * 
	 * 		(m00, m01, m02) = (3 * cos_radians(1/3 * PI), 2 * -sin_radians(1/3 * PI), 5)
	 * 		(m10, m11, m12) = (3 * sin_radians(1/3 * PI), 2 * cos_radians(1/3 * PI), 7)
	 * 
	 * 		(m00, m01, m02) = (5 * cos_degree(60f), 7 * -sin_degree(60f), 2)
	 * 		(m10, m11, m12) = (5 * sin_degree(60f), 7 * cos_degree(60f), 3)
	 * 
	 * 		(m00, m01, m02) = (5 * cos_degree(60f), 7 * -sin_degree(60f), 2)
	 * 		(m10, m11, m12) = (5 * sin_degree(60f), 7 * cos_degree(60f), 3)		
	 */
	@Test
	public void TestSetTranslateRotationScaling(){
		Affine2 affine2_1 = new Affine2();
		Affine2 affine2_2 = new Affine2();
		
		float degree = 60f;
		float radians = (float)Math.toRadians(degree);
		
		affine2_1.setToTrnRotScl(5, 7, degree, 3, 2);

		assertEquals(affine2_1.m00, 3 * Math.cos(radians), 0.01f);
		assertEquals(affine2_1.m01, 2 * -Math.sin(radians), 0.01f);
		assertEquals(affine2_1.m02, 5, 0.01f);
		assertEquals(affine2_1.m10, 3 * Math.sin(radians), 0.01f);
		assertEquals(affine2_1.m11, 2 * Math.cos(radians), 0.01f);
		assertEquals(affine2_1.m12, 7, 0.01f);
		
		affine2_2.setToTrnRotRadScl(5, 7, radians, 3, 2);

		assertEquals(affine2_1.m00, 3 * Math.cos(radians), 0.01f);
		assertEquals(affine2_1.m01, 2 * -Math.sin(radians), 0.01f);
		assertEquals(affine2_1.m02, 5, 0.01f);
		assertEquals(affine2_1.m10, 3 * Math.sin(radians), 0.01f);
		assertEquals(affine2_1.m11, 2 * Math.cos(radians), 0.01f);
		assertEquals(affine2_1.m12, 7, 0.01f);
		
		assertTrue(EqualsAffine2(affine2_1, affine2_2));

		affine2_1.setToTrnRotScl(vector2_1, degree, vector2_2);

		assertEquals(affine2_1.m00, 5 * Math.cos(radians), 0.01f);
		assertEquals(affine2_1.m01, 7 * -Math.sin(radians), 0.01f);
		assertEquals(affine2_1.m02, 2, 0.01f);
		assertEquals(affine2_1.m10, 5 * Math.sin(radians), 0.01f);
		assertEquals(affine2_1.m11, 7 * Math.cos(radians), 0.01f);
		assertEquals(affine2_1.m12, 3, 0.01f);
		
		affine2_2.setToTrnRotRadScl(vector2_1, radians, vector2_2);

		assertEquals(affine2_1.m00, 5 * Math.cos(radians), 0.01f);
		assertEquals(affine2_1.m01, 7 * -Math.sin(radians), 0.01f);
		assertEquals(affine2_1.m02, 2, 0.01f);
		assertEquals(affine2_1.m10, 5 * Math.sin(radians), 0.01f);
		assertEquals(affine2_1.m11, 7 * Math.cos(radians), 0.01f);
		assertEquals(affine2_1.m12, 3, 0.01f);
		
		assertTrue(EqualsAffine2(affine2_1, affine2_2));
	}
	
	/*
	 * Purpose: set instance to affine matrix that apply translation, rotation(but zero) and scaling
	 * Input: setToTrnRotScl x(5):float y(7):float degrees(0f):float scaleX(3):float scaleY(2):float
	 * 		 setToTrnRotRadScl x(5):float y(7):float radians(0 * PI):float scaleX(3):float scaleY(2):float
	 * 		 setToTrnRotScl translation(2,3):Vector2 degrees(0f):float scaling(5,7):Vector2
	 * 		 setToTrnRotRadScl translation(2,3):Vector2 radians(0 * PI):float scaling(5,7):Vector2
	 * Expected:
	 * 		(m00, m01, m02) = (3, 2, 5)
	 * 		(m10, m11, m12) = (3, 2, 7)
	 * 
	 * 		(m00, m01, m02) = (3, 2, 5)
	 * 		(m10, m11, m12) = (3, 2, 7)
	 * 
	 * 		(m00, m01, m02) = (5, 7, 2)
	 * 		(m10, m11, m12) = (5, 7, 3)
	 * 
	 * 		(m00, m01, m02) = (5, 7, 2)
	 * 		(m10, m11, m12) = (5, 7, 3)		
	 */
	@Test
	public void TestSetTranslateRotationScaling_ZeroDegree(){
		Affine2 affine2_1 = new Affine2();
		Affine2 affine2_2 = new Affine2();
		
		float degree = 0f;
		float radians = (float)Math.toRadians(degree);
		
		affine2_1.setToTrnRotScl(5, 7, degree, 3, 2);

		assertEquals(affine2_1.m00, 3 * Math.cos(radians), 0.01f);
		assertEquals(affine2_1.m01, 2 * -Math.sin(radians), 0.01f);
		assertEquals(affine2_1.m02, 5, 0.01f);
		assertEquals(affine2_1.m10, 3 * Math.sin(radians), 0.01f);
		assertEquals(affine2_1.m11, 2 * Math.cos(radians), 0.01f);
		assertEquals(affine2_1.m12, 7, 0.01f);
		
		affine2_2.setToTrnRotRadScl(5, 7, radians, 3, 2);

		assertEquals(affine2_1.m00, 3 * Math.cos(radians), 0.01f);
		assertEquals(affine2_1.m01, 2 * -Math.sin(radians), 0.01f);
		assertEquals(affine2_1.m02, 5, 0.01f);
		assertEquals(affine2_1.m10, 3 * Math.sin(radians), 0.01f);
		assertEquals(affine2_1.m11, 2 * Math.cos(radians), 0.01f);
		assertEquals(affine2_1.m12, 7, 0.01f);
		
		assertTrue(EqualsAffine2(affine2_1, affine2_2));

		affine2_1.setToTrnRotScl(vector2_1, degree, vector2_2);

		assertEquals(affine2_1.m00, 5 * Math.cos(radians), 0.01f);
		assertEquals(affine2_1.m01, 7 * -Math.sin(radians), 0.01f);
		assertEquals(affine2_1.m02, 2, 0.01f);
		assertEquals(affine2_1.m10, 5 * Math.sin(radians), 0.01f);
		assertEquals(affine2_1.m11, 7 * Math.cos(radians), 0.01f);
		assertEquals(affine2_1.m12, 3, 0.01f);
		
		affine2_2.setToTrnRotRadScl(vector2_1, radians, vector2_2);

		assertEquals(affine2_1.m00, 5 * Math.cos(radians), 0.01f);
		assertEquals(affine2_1.m01, 7 * -Math.sin(radians), 0.01f);
		assertEquals(affine2_1.m02, 2, 0.01f);
		assertEquals(affine2_1.m10, 5 * Math.sin(radians), 0.01f);
		assertEquals(affine2_1.m11, 7 * Math.cos(radians), 0.01f);
		assertEquals(affine2_1.m12, 3, 0.01f);
		
		assertTrue(EqualsAffine2(affine2_1, affine2_2));
	}
	
	/*
	 * Purpose: Product affine matrix to other affine matrix
	 * Input: setToProduct l(affine2_2):Affine2 r(affine2_3):Affine2
	 * Expected:
	 * 		set the instance to result of matrix multiply
	 * 		result = (Translation Matrix1(2,3) * Translation Matrix2(5,7))
	 * 		result = Translation Matrix(2+5, 3+7)
	 */
	@Test
	public void TestSetProduct(){
		Affine2 affine2_1 = new Affine2();
		Affine2 affine2_2 = new Affine2();
		Affine2 affine2_3 = new Affine2();
		Affine2 affine2_4 = new Affine2();
		
		affine2_2.setToTranslation(vector2_1);
		affine2_3.setToTranslation(vector2_2);
		
		affine2_1.setToProduct(affine2_2, affine2_3);
		
		affine2_4.setToTranslation(vector2_1.add(vector2_2));
		
		assertTrue(EqualsAffine2(affine2_1, affine2_4));
	}
	
	/*
	 * Purpose: set instance to affine matrix that apply translation and scaling
	 * Input: setToTrnScl trnX(5):float trnY(7):float sclX(3):float sclY(2):float
	 * 		 setToTrnScl translation(2,3):Vector2 scaling(5,7):float
	 * Expected:
	 * 		(m00, m01, m02) = (3,0,5)
	 * 		(m10, m11, m12) = (0,2,7)
	 * 
	 * 		(m00, m01, m02) = (5,0,2)
	 * 		(m10, m11, m12) = (0,7,3)
	 */
	@Test
	public void TestSetTranslateScaling(){
		Affine2 affine2_1 = new Affine2();
		
		affine2_1.setToTrnScl(5, 7, 3, 2);

		assertEquals(affine2_1.m00, 3, 0.01f);
		assertEquals(affine2_1.m01, 0, 0.01f);
		assertEquals(affine2_1.m02, 5, 0.01f);
		assertEquals(affine2_1.m10, 0, 0.01f);
		assertEquals(affine2_1.m11, 2, 0.01f);
		assertEquals(affine2_1.m12, 7, 0.01f);
		
		affine2_1.setToTrnScl(vector2_1, vector2_2);

		assertEquals(affine2_1.m00, 5, 0.01f);
		assertEquals(affine2_1.m01, 0, 0.01f);
		assertEquals(affine2_1.m02, 2, 0.01f);
		assertEquals(affine2_1.m10, 0, 0.01f);
		assertEquals(affine2_1.m11, 7, 0.01f);
		assertEquals(affine2_1.m12, 3, 0.01f);
	}
	
	/*
	 * Purpose: multiply two affine matrix
	 * Input: affine2_2(1,0,2)
	 * 					 (0,1,3):Affine2
	 * 		 mul other(5,0,0)
	 * 					 (0,7,0):Affine2
	 * 
	 * 		 affine2_3(5,0,0)
	 * 					 (0,7,0):Affine2
	 * 		 mul other(1,0,2)
	 * 					 (0,1,3):Affine2
	 * Expected:
	 * 		(m00, m01, m02) = (5,0,2)
	 * 		(m10, m11, m12) = (0,7,3)
	 * 
	 * 		(m00, m01, m02) = (5,0,2)
	 * 		(m10, m11, m12) = (0,7,3)
	 */
	@Test
	public void TestMultiply(){
		Affine2 affine2_1 = new Affine2();
		Affine2 affine2_2 = new Affine2();
		Affine2 affine2_3 = new Affine2();
		
		affine2_1.setToTrnScl(vector2_1, vector2_2);
		affine2_2.setToTranslation(vector2_1);
		affine2_3.setToScaling(vector2_2);
		
		affine2_2.mul(affine2_3);
		
		assertTrue(EqualsAffine2(affine2_1, affine2_2));
		
		affine2_2.setToTranslation(vector2_1);
		
		affine2_3.preMul(affine2_2);
		
		assertTrue(EqualsAffine2(affine2_1, affine2_3));
	}
	
	/*
	 * Purpose: translate the affine matrix
	 * Input: translate x(8):float y(8):float
	 * 		 translate translation(2,3):Vector2
	 * 		 preTranslate x(5):float y(7):float
	 * 		 preTranslate translation(5,7):Vector2
	 * Expected:
	 * 		(m02, m12) = (8,8)
	 * 		(m02, m12) = (m02' + 2, m12' + 3) = (10, 11)
	 * 		(m02, m12) = (m02' + 5, m12' + 7) = (15, 18)
	 * 		(m02, m12) = (m02' + 5, m12' + 7) = (20, 25)
	 */
	@Test
	public void TestTranslate(){
		Affine2 affine2_1 = new Affine2();
		
		affine2_1.translate(8,8);
		
		assertEquals(affine2_1.m02, 8, 0.01f);
		assertEquals(affine2_1.m12, 8, 0.01f);
		
		affine2_1.translate(vector2_1);
		
		assertEquals(affine2_1.m02, 10, 0.01f);
		assertEquals(affine2_1.m12, 11, 0.01f);
		
		affine2_1.preTranslate(5,7);
		
		assertEquals(affine2_1.m02, 15, 0.01f);
		assertEquals(affine2_1.m12, 18, 0.01f);
		
		affine2_1.preTranslate(vector2_2);
		
		assertEquals(affine2_1.m02, 20, 0.01f);
		assertEquals(affine2_1.m12, 25, 0.01f);
	}
	
	/*
	 * Purpose: scaling the affine matrix
	 * Input: scale x(5):float y(2):float
	 * 		 scale scaling(2,3):Vector2
	 * 		 preScale x(1/5):float y(1/3):float
	 * 		 preScale translation(5,7):Vector2
	 * Expected:
	 * 		(m00, m11) = (5,2)
	 * 		(m00, m11) = (m00' * 2, m11' * 3) = (10, 6)
	 * 		(m00, m11) = (m00' * 1/5, m11' * 1/3) = (2, 2)
	 * 		(m00, m11) = (m00' * 5, m11' * 7) = (10, 14)
	 */
	@Test
	public void TestScaling(){
		Affine2 affine2_1 = new Affine2();
		
		affine2_1.scale(5,2);
		
		assertEquals(affine2_1.m00, 5, 0.01f);
		assertEquals(affine2_1.m11, 2, 0.01f);
		
		affine2_1.scale(vector2_1);
		
		assertEquals(affine2_1.m00, 10, 0.01f);
		assertEquals(affine2_1.m11, 6, 0.01f);
		
		affine2_1.preScale(1/5f, 1/3f);
		
		assertEquals(affine2_1.m00, 2, 0.01f);
		assertEquals(affine2_1.m11, 2, 0.01f);
		
		affine2_1.preScale(vector2_2);
		
		assertEquals(affine2_1.m00, 10, 0.01f);
		assertEquals(affine2_1.m11, 14, 0.01f);
	}
	
	/*
	 * Purpose: rotate the affine matrix
	 * Input: rotate degrees(45f):float
	 * 		 rotateRad radians(1/4):float
	 * 		 preRotate degrees(45f):float
	 * 		 rotateRad radians(1/4):float
	 * Expected:
	 * 		(m00, m01) = (cos_degree(45f), -sin_degree(45f))
	 * 		(m10, m11) = (sin_degree(45f), sin_degree(45f))
	 * 
	 * 		(m00, m01) = (cos_radian(1/2), -sin_radian(1/2))
	 * 		(m10, m11) = (sin_radian(1/2), sin_radian(1/2))
	 * 
	 * 		(m00, m01) = (cos_degree(135f), -sin_degree(135f))
	 * 		(m10, m11) = (sin_degree(135f), sin_degree(135f))
	 * 
	 * 		(m00, m01) = (cos_radian(1/2), -sin_radian(1/2))
	 * 		(m10, m11) = (sin_radian(1/2), sin_radian(1/2))
	 */
	@Test
	public void TestRotate(){
		Affine2 affine2_1 = new Affine2();
		
		float degree = 45f;
		float radians = (float)Math.toRadians(degree);
		
		affine2_1.rotate(degree);
		
		assertEquals(affine2_1.m00, Math.cos(radians), 0.01f);
		assertEquals(affine2_1.m01, -Math.sin(radians), 0.01f);
		assertEquals(affine2_1.m10, Math.sin(radians), 0.01f);
		assertEquals(affine2_1.m11, Math.cos(radians), 0.01f);
		
		affine2_1.rotateRad(radians);
		
		assertEquals(affine2_1.m00, Math.cos(radians + radians), 0.01f);
		assertEquals(affine2_1.m01, -Math.sin(radians + radians), 0.01f);
		assertEquals(affine2_1.m10, Math.sin(radians + radians), 0.01f);
		assertEquals(affine2_1.m11, Math.cos(radians + radians), 0.01f);

		affine2_1.preRotate(degree);
		
		assertEquals(affine2_1.m00, Math.cos(radians * 3), 0.01f);
		assertEquals(affine2_1.m01, -Math.sin(radians * 3), 0.01f);
		assertEquals(affine2_1.m10, Math.sin(radians * 3), 0.01f);
		assertEquals(affine2_1.m11, Math.cos(radians * 3), 0.01f);
		
		affine2_1.preRotateRad(-radians);
		
		assertEquals(affine2_1.m00, Math.cos(radians + radians), 0.01f);
		assertEquals(affine2_1.m01, -Math.sin(radians + radians), 0.01f);
		assertEquals(affine2_1.m10, Math.sin(radians + radians), 0.01f);
		assertEquals(affine2_1.m11, Math.cos(radians + radians), 0.01f);
	}
	
	/*
	 * Purpose: shearing the affine matrix
	 * Input: shear x(3):float y(5):float
	 * 		 shear shearing(2,3):Vector2
	 * 		 preShear x(-3):float y(-5):float
	 * 		 preShear translation(5,7):Vector2
	 * Expected:
	 * 		(m01, m10) = (3,5)
	 * 		(m01, m10) = (m01' + m11' * 2, m10' + m00' * 3) = (5, 8)
	 * 		(m01, m10) = (m01' + m11' * -3, m10' + m00' * -5) = (2, 3)
	 * 		(m01, m10) = (m01' + m11' * 5, m10' + m00' * 7) = (7, 10)
	 */
	@Test
	public void TestShearing(){
		Affine2 affine2_1 = new Affine2();
		
		affine2_1.shear(3,5);
		
		assertEquals(affine2_1.m01, 3, 0.01f);
		assertEquals(affine2_1.m10, 5, 0.01f);
		
		affine2_1.shear(vector2_1);
		
		assertEquals(affine2_1.m01, 5, 0.01f);
		assertEquals(affine2_1.m10, 8, 0.01f);
		
		Affine2 affine2_2 = new Affine2(affine2_1);
		
		affine2_1.preShear(-3,-5);
		
		assertEquals(affine2_1.m01, affine2_2.m01 + -3 * affine2_2.m11, 0.01f);
		assertEquals(affine2_1.m10, affine2_2.m10 + -5 * affine2_2.m00, 0.01f);
		
		affine2_2.set(affine2_1);
		
		affine2_1.preShear(vector2_2);
		
		assertEquals(affine2_1.m01, affine2_2.m01 + 5 * affine2_2.m11, 0.01f);
		assertEquals(affine2_1.m10, affine2_2.m10 + 7 * affine2_2.m00, 0.01f);
	}
	
	/*
	 * Purpose: test determinant
	 * Input: det void
	 * Expected:
	 * 		return m00 * m11 - m01 * m10 = 1
	 */
	@Test
	public void TestDeterminant(){
		Affine2 affine2_1 = new Affine2();
		
		assertEquals(affine2_1.det(), 1 * 1 - 0 * 0, 0.01f);
	}
	
	/*
	 * Purpose: get translation vector
	 * Input: affine2_1(1,0,5)
	 * 					 (0,1,7):Affine2
	 * 		 getTranslation output(tempVector2):Vector2
	 * Expected:
	 * 		 set the parameter vector to translation vector
	 * 		(x,y) = (5,7)
	 */
	@Test
	public void TestGetTranslation(){
		Affine2 affine2_1 = new Affine2();
		
		affine2_1.setToTranslation(5,7);
		Vector2 tempVector2 = new Vector2();
		
		assertEquals(affine2_1.getTranslation(tempVector2), vector2_2);
	}
	
	/*
	 * Purpose: test isTranslation
	 * Input: isTranslation void
	 * Expected:
	 * 		 return true when its m01, m10 are 0 and m00, m11 are 1
	 */
	@Test
	public void TestIsTranslation(){
		Affine2 affine2_1 = new Affine2();
		
		affine2_1.setToTranslation(vector2_1);
		
		assertTrue(affine2_1.isTranslation());
		
		affine2_1.shear(vector2_2);
		
		assertFalse(affine2_1.isTranslation());
	}
	
	/*
	 * Purpose: test isIdt
	 * Input: idt
	 * Expected:
	 * 		return true when its m00, m11 are 1 and others are 0 
	 */
	@Test
	public void TestIsIdentity(){
		Affine2 affine2_1 = new Affine2();
		
		affine2_1.idt();
		
		assertTrue(affine2_1.isIdt());
		
		affine2_1.setToTranslation(vector2_1);
		
		assertFalse(affine2_1.isIdt());
	}
	
	/*
	 * Purpose: apply affine matrix to vector
	 * Input: affine2_1(5,0,2)
	 * 					 (0,7,3):Affine2 
	 * 		 applyTo vector(4,4):Vector2
	 * Expected:
	 * 		scaling vector to (5,7) = (4 * 5, 4 * 7) = (20, 28)
	 * 		and translate to (2,3) = (20 + 2, 20 + 3) = (22, 23) 
	 */
	@Test
	public void TestApplyToVector(){
		Affine2 affine2_1 = new Affine2();
		
		Vector2 tempVector2 = new Vector2(4,4);
		
		affine2_1.setToTrnScl(vector2_1, vector2_2);
		
		affine2_1.applyTo(tempVector2);
		
		assertEquals(tempVector2.x, 4 * 5 + 2, 0.01f);
		assertEquals(tempVector2.y, 4 * 7 + 3, 0.01f);
	}
}
