package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.badlogic.gdx.math.Plane;
import com.badlogic.gdx.math.Vector3;

public class PlaneTest {
	private static Plane plane; 
	
	@BeforeClass
	public static void setUpBeforeClass () throws Exception {
		plane = new Plane();
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

	@Test
	public void testPlane () {
	}

	/**
	 * 
	 * Effect : Constructs a new plane based on the normal and distance to the origin
	 * Parameter : Plane(Vector3, float)
	 * Input : (0, 0, 0), 0
	 * Expected Output : (0, 0, 0), 0
	 * Actual Output : (0, 0, 0), 0
	 * 
	 */
	@Test
	public void testPlaneVector3Float () {
		Vector3 v = new Vector3(0f,0f,0f);
		float d = 0;
		Plane testPlane = new Plane(v,d);

		assertEquals(0, testPlane.normal.x, 0.1);
		assertEquals(0, testPlane.normal.y, 0.1);
		assertEquals(0, testPlane.normal.z, 0.1);
		assertEquals(0, testPlane.d, 0.1);
		assertEquals(0, testPlane.d, 0.1);
	}

	/**
	 * 
	 * Effect : Constructs a new plane based on the normal and a point on the plane
	 * Parameter : Plane(Vector3, Vector3)
	 * Input : (0, 0, 0), (1,2,3)
	 * Expected Output : (0, 0, 0), 0
	 * Actual Output : (0, 0, 0), 0
	 * 
	 */
	@Test
	public void testPlaneVector3Vector3 () {
		Vector3 v1 = new Vector3(0f,0f,0f);
		Vector3 v2 = new Vector3(1f,2f,3f);
		
		Plane testPlane = new Plane(v1,v2);

		assertEquals(0, testPlane.normal.x, 0.1);
		assertEquals(0, testPlane.normal.y, 0.1);
		assertEquals(0, testPlane.normal.z, 0.1);
		assertEquals(0, testPlane.d, 0.1);
	}

	/**
	 * 
	 * Effect : Constructs a new plane out of the three given points that are considered to be on the plane. 
	 * 			The normal is calculated via a cross product between (point1-point2)x(point2-point3)
	 * Parameter : Plane(Vector3, Vector3, Vector3)
	 * Input : (0, 0, 0), (1,1,1), (2,2,2)
	 * Expected Output : (0, 0, 0), 0
	 * Actual Output : (0, 0, 0), 0
	 * 
	 */
	
	@Test
	public void testPlaneVector3Vector3Vector3 () {
		Vector3 v1 = new Vector3(1f,2f,3f);
		Vector3 v2 = new Vector3(1f,1f,1f);
		Vector3 v3 = new Vector3(2f,2f,2f);
		Vector3 result = new Vector3(0.4f,-0.8f,0.4f);
		
		Plane testPlane = new Plane(v1,v2,v3);

		assertEquals(0.4f, testPlane.normal.x, 0.1);
		assertEquals(-0.8f, testPlane.normal.y, 0.1);
		assertEquals(0.4f, testPlane.normal.z, 0.1);
		
		assertEquals(0, testPlane.d, 0.1);
	}

	/**
	 * 
	 * Effect : Sets the plane normal and distance to the origin based on the three given points which are considered to be on the plane.
	 * 			The normal is calculated via a cross product between (point1-point2)x(point2-point3)
	 * Parameter : set(float, float, float, float)
	 * Input : (0, 0, 0, 0)
	 * Expected Output : (0, 0, 0), 0
	 * Actual Output : (0, 0, 0), 0
	 * 
	 */
	@Test
	public void testSetFloatFloatFloatFloat () {
		Vector3 v1 = new Vector3(0f,0f,0f);		
		float f1=0 ,f2=0 ,f3=0 ,f4 = 0;
		Vector3 result = new Vector3(f1,f2,f3);
		
		plane.set(f1,f2,f3,f4);
		
		assertEquals(f1, plane.normal.x, 0.1);
		assertEquals(f2, plane.normal.y, 0.1);
		assertEquals(f3, plane.normal.z, 0.1);
		assertEquals(f4, plane.d, 0.1);
	}

	/**
	 * 
	 * Effect : Calculates the shortest signed distance between the plane and the given point
	 * Parameter : set(float,float,float,float), distance(Vector3)
	 * Input : (1, 2, 3, 3), (5, 2, 1)
	 * Expected Output : 15
	 * Actual Output : 15
	 * 
	 */
	@Test
	public void testDistance () {
		Vector3 v1 = new Vector3(5f,2f,1f);
		plane.set(1, 2, 3, 3);
		float f = plane.distance(v1);
		
		assertEquals(15, f, 0.1);
	}
	
	/**
	 * 
	 * Effect : Returns on which side the given point lies relative to the plane and its normal. PlaneSide.Front refers to the side the
	 * 			plane normal points to.
	 * Parameter : set(float,float,float,float), distance(Vector3), testPoint(Vector3)
	 * Input : (1, 2, 3, 3), (5, 2, 1)
	 * Expected Output : 15
	 * Actual Output : 15
	 * 
	 */
	@Test
	public void testTestPointVector3PlaneSidePositive () {
		Vector3 v1 = new Vector3(5f,2f,1f);
		plane.set(1, 2, 3, 3);
		
		com.badlogic.gdx.math.Plane.PlaneSide ps = plane.testPoint(v1);
		assertEquals(ps, ps.Front);
	}
	
	/**
	 * 
	 * Effect : Returns on which side the given point lies relative to the plane and its normal. PlaneSide.Front refers to the side the
	 * 			plane normal points to.
	 * Parameter : set(float,float,float,float), distance(Vector3), testPoint(Vector3)
	 * Input : (1, 2, 3, 3), (-5, 2, -1)
	 * Expected Output : 15
	 * Actual Output : 15
	 * 
	 */
	@Test
	public void testTestPointVector3PlaneSideNegative () {
		Vector3 v1 = new Vector3(-5f,2f,-1f);
		plane.set(1, 2, 3, 3);
		
		com.badlogic.gdx.math.Plane.PlaneSide ps = plane.testPoint(v1);
		assertEquals(ps, ps.Back);
	}
	
	/**
	 * 
	 * Effect : Returns on which side the given point lies relative to the plane and its normal. PlaneSide.Front refers to the side the
	 * 			plane normal points to.
	 * Parameter : set(float,float,float,float), distance(Vector3), testPoint(Vector3)
	 * Input : (1, 2, 3, 3), (1, 1, -2)
	 * Expected Output : 15
	 * Actual Output : 15
	 * 
	 */
	@Test
	public void testTestPointVector3PlaneSideZero () {
		Vector3 v1 = new Vector3(1f,1f,-2f);
		plane.set(1, 2, 3, 3);
		
		com.badlogic.gdx.math.Plane.PlaneSide ps = plane.testPoint(v1);
		assertEquals(ps, ps.OnPlane);
	}
	
	/**
	 * 
	 * Effect : Returns on which side the given point lies relative to the plane and its normal. PlaneSide.Front refers to the side the
	 * 			plane normal points to.
	 * Parameter : set(float,float,float,float), distance(Vector3), testPoint(float, float, float)
	 * Input : (1, 2, 3, 3), 5, 2, 1
	 * Expected Output : 15
	 * Actual Output : 15
	 * 
	 */
	
	@Test
	public void testTestPointFloatFloatFloatPlaneSidePositive () {
		float f1 = 5f, f2 = 2f, f3 = 1f;
		plane.set(1, 2, 3, 3);
		
		com.badlogic.gdx.math.Plane.PlaneSide ps = plane.testPoint(f1,f2,f3);
		assertEquals(ps, ps.Front);
	}
	
	/**
	 * 
	 * Effect : Returns on which side the given point lies relative to the plane and its normal. PlaneSide.Front refers to the side the
	 * 			plane normal points to.
	 * Parameter : set(float,float,float,float), distance(Vector3), testPoint(float, float, float)
	 * Input : (1, 2, 3, 3), -5, 2, -1
	 * Expected Output : 15
	 * Actual Output : 15
	 * 
	 */
	
	@Test
	public void testTestPointFloatFloatFloatPlaneSideNegative () {
		float f1 = -5f, f2 = 2f, f3 = -1f;
		plane.set(1, 2, 3, 3);
		
		com.badlogic.gdx.math.Plane.PlaneSide ps = plane.testPoint(f1,f2,f3);
		assertEquals(ps, ps.Back);
	}
	
	/**
	 * 
	 * Effect : Returns on which side the given point lies relative to the plane and its normal. PlaneSide.Front refers to the side the
	 * 			plane normal points to.
	 * Parameter : set(float,float,float,float), distance(Vector3), testPoint(float, float, float)
	 * Input : (1, 2, 3, 3), 1, 1, -2
	 * Expected Output : 15
	 * Actual Output : 15
	 * 
	 */
	
	@Test
	public void testTestPointFloatFloatFloatPlaneSideZero () {
		float f1 = 1f, f2 = 1f, f3 = -2f;
		plane.set(1, 2, 3, 3);
		
		com.badlogic.gdx.math.Plane.PlaneSide ps = plane.testPoint(f1,f2,f3);
		assertEquals(ps, ps.OnPlane);
	}
	
	/**
	 * 
	 * Effect : Returns whether the plane is facing the direction vector. Think of the direction vector as the direction a camera looks in.
	 * 			This method will return true if the front side of the plane determined by its normal faces the camera.
	 * Parameter : Vector3(float, float, float), set(float,float,float,float), isFrontFacing(Vector3)
	 * Input : (1, 2, 3), (1,2,3,0)
	 * Expected Output : false
	 * Actual Output : false
	 * 
	 */
	@Test
	public void testIsFrontFacingFalse () {
		Vector3 direction = new Vector3(1f,2f,3f);
		plane.set(1,2,3,0);
				
		boolean isFrontFacing = plane.isFrontFacing(direction);

		assertTrue(!isFrontFacing);
	}

	/**
	 * 
	 * Effect : Returns whether the plane is facing the direction vector. Think of the direction vector as the direction a camera looks in.
	 * 			This method will return true if the front side of the plane determined by its normal faces the camera.
	 * Parameter : Vector3(float, float, float), set(float,float,float,float), isFrontFacing(Vector3)
	 * Input : (1, 2, -3), (1,2,3,0), direction
	 * Expected Output : true
	 * Actual Output : true
	 * 
	 */
	@Test
	public void testIsFrontFacingTrue () {
		Vector3 direction = new Vector3(1f,2f,-3f);
		plane.set(1,2,3,0);
				
		boolean isFrontFacing = plane.isFrontFacing(direction);

		assertTrue(isFrontFacing);
	}
	
	/**
	 * 
	 * Effect : return The distance to the origin
	 * Parameter : getNormal()
	 * Input : 
	 * Expected Output : 1, 2, 3
	 * Actual Output : 1, 2, 3
	 * 
	 */
	
	@Test
	public void testGetNormal () {
		Vector3 normal = plane.getNormal();
		
		assertEquals(1, normal.x, 0.1);
		assertEquals(2, normal.y, 0.1);
		assertEquals(3, normal.z, 0.1);
	}

	/**
	 * 
	 * Effect : return The d
	 * Parameter : getD()
	 * Input : 
	 * Expected Output : 0
	 * Actual Output : 0
	 * 
	 */
	@Test
	public void testGetD () {
		float d = plane.getD();
		assertEquals(0, d, 0.1);
	}

	/**
	 * 
	 * Effect : Sets the plane to the given point and normal
	 * Parameter : Vector3(float,float,float), Vector3(float,float,float), set(Vector3, Vector3)
	 * Input : (1,2,3), (1,2,3)
	 * Expected Output : 1,2,3, -14
	 * Actual Output : 1,2,3, -14
	 * 
	 */
	
	@Test
	public void testSetVector3Vector3 () {
		Vector3 point = new Vector3(1f,2f,3f);
		Vector3 normal = new Vector3(1f,2f,3f);
		plane.set(point, normal);
		
		assertEquals(1, plane.normal.x, 0.1);
		assertEquals(2, plane.normal.y, 0.1);
		assertEquals(3, plane.normal.z, 0.1);
		assertEquals(-14, plane.d, 0.1);
		}

	/**
	 * 
	 * Effect : Sets the plane to the given point and normal
	 * Parameter :set(float, float, float, float, float, float)
	 * Input : (1,2,3,1,2,3)
	 * Expected Output : 1,2,3, -14
	 * Actual Output : 1,2,3, -14
	 * 
	 */
	
	@Test
	public void testSetFloatFloatFloatFloatFloatFloat () {
		float pointX = 1, pointY = 2, pointZ = 3, norX=1, norY=2, norZ=3;
		plane.set(pointX, pointY, pointZ, norX, norY, norZ);
		
		assertEquals(1, plane.normal.x, 0.1);
		assertEquals(2, plane.normal.y, 0.1);
		assertEquals(3, plane.normal.z, 0.1);
		assertEquals(-14, plane.d, 0.1);
		}

	/**
	 * 
	 * Effect : Sets this plane from the given plane
	 * Parameter :Vector3(float,float,float), Plane(Vector3, float), set(Plane)
	 * Input : (1,2,3), ((1,2,3),3), Plane
	 * Expected Output : 1,2,3, 3
	 * Actual Output : 1,2,3, 3
	 * 
	 */
	@Test
	public void testSetPlane () {
		Vector3 normal = new Vector3(1f,2f,3f);
		float d = 3f;
		Plane testPlane = new Plane(normal,d);
		testPlane.set(plane);
		
		assertEquals(1, testPlane.normal.x, 0.1);
		assertEquals(2, testPlane.normal.y, 0.1);
		assertEquals(3, testPlane.normal.z, 0.1);

		assertEquals(3, testPlane.d, 0.1);
	}

	/**
	 * 
	 * Effect : Give toString
	 * Parameter :toString()
	 * Input : 
	 * Expected Output :true
	 * Actual Output : true
	 * 
	 */
	
	@Test
	public void testToString () {
		String testString = plane.toString();
		String result = "(1.0,2.0,3.0), 0.0"; 
		
		assertTrue(testString.equals(result));
		}

}
