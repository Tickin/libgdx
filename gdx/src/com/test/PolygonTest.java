package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class PolygonTest {
	private static Polygon polygon;
	@BeforeClass
	public static void setUpBeforeClass () throws Exception {
		polygon = new Polygon();
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
	public void testPolygon () {
		polygon = new Polygon();
		
		float[] resultVertices = polygon.getVertices();
	}

	/**
	 * 
	 * Effect : Get Polygon Vertices
	 * Parameter : getVertices()
	 * Input : (0,0, 1,1, 2,2), (0,0, 1,1, 2)
	 * Expected Output : (0,0, 1,1, 2,2,), Error
	 * Actual Output : (0,0, 1,1, 2,2,), Error
	 * 
	 */
	
	@Test
	public void testPolygonFloatArray () {
		float[] vertices = {0f,0f, 1f,1f, 2f,2f};
		float[] fakeVertices = {0f,0f, 1f,1f, 2f};

		polygon = new Polygon(vertices);
		float[] resultVertices = polygon.getVertices();
		
		assertEquals(0f, resultVertices[0], 0.01f);
		assertEquals(0f, resultVertices[1], 0.01f);
		assertEquals(1f, resultVertices[2], 0.01f);
		assertEquals(1f, resultVertices[3], 0.01f);
		assertEquals(2f, resultVertices[4], 0.01f);
		assertEquals(2f, resultVertices[5], 0.01f);
		
		polygon = new Polygon(fakeVertices);
	}

	/**
	 * 
	 * Effect : Get Polygon Transformed Vertices
	 * Parameter : getTransformedVertices
	 * Input : (1,1, 2,2, 3,1), orginX=0 ,orginY=0, rotation=180, scaleX=0.5,scaleY=0.5 
	 * Expected Output : (-0.5,-0.5, -1,-1, -1.5,-0.5), 
	 * Actual Output : (0,0, 1,1, 2,2,), Error
	 * 
	 */
	@Test
	public void testGetTransformedVertices () {
		float[] vertices = {1f,1f, 2f,2f, 3f,1f};
		float orginX = 0, orginY = 0;
		float rotation = 180f;
		float scaleX = 0.5f, scaleY = 0.5f;
		
		polygon.setVertices(vertices);
		polygon.setOrigin(orginX, orginY);
		polygon.setRotation(rotation);
		polygon.setScale(scaleX, scaleY);
		
		float[] result = polygon.getTransformedVertices();
		
		assertEquals(-0.5, result[0], 0.001);
		assertEquals(-0.5, result[1], 0.001);
		assertEquals(-1, result[2], 0.001);
		assertEquals(-1, result[3], 0.001);
		assertEquals(-1.5, result[4], 0.001);
		assertEquals(-0.5, result[5], 0.001);
		
		float[] result1 = polygon.getTransformedVertices();
		assertEquals(-0.5, result1[0], 0.001);
		assertEquals(-0.5, result1[1], 0.001);
		assertEquals(-1, result1[2], 0.001);
		assertEquals(-1, result1[3], 0.001);
		assertEquals(-1.5, result1[4], 0.001);
		assertEquals(-0.5, result1[5], 0.001);
	}

	/**
	 * 
	 * Effect : Get Polygon Transformed Vertices
	 * Parameter : getTransformedVertices()
	 * Input : (1,1, 2,2, 3,1), orginX=0 ,orginY=0, rotation=180, scaleX=0.5,scaleY=0.5 
	 * Expected Output : (-0.5,-0.5, -1,-1, -1.5,-0.5), 
	 * Actual Output : (0,0, 1,1, 2,2,), Error
	 * 
	 */
	@Test
	public void testGetTransformedVerticesWithScaleOneRotationZero() {
		float[] vertices = {1f,1f, 2f,2f, 3f,1f};
		float orginX = 0, orginY = 0;
		float rotation = 0f;
		float scaleX = 1f, scaleY = 1f;
		
		polygon.setVertices(vertices);
		polygon.setOrigin(orginX, orginY);
		polygon.setRotation(rotation);
		polygon.setScale(scaleX, scaleY);

		float[] result2 = polygon.getTransformedVertices();
		
		assertEquals(1, result2[0], 0.001);
		assertEquals(1, result2[1], 0.001);
		assertEquals(2, result2[2], 0.001);
		assertEquals(2, result2[3], 0.001);
		assertEquals(3, result2[4], 0.001);
		assertEquals(1, result2[5], 0.001);
	}
	
	/**
	 * 
	 * Effect : Set Origin Values
	 * Parameter : setOrigin(float, float)
	 * Input : 5.2f, 8.9f 
	 * Expected Output : 5.2f, 8.9f 
	 * Actual Output : 5.2f, 8.9f 
	 * 
	 */
	
	@Test
	public void testSetOrigin () {
		float originX = 5.2f, originY = 8.9f;
		polygon.setOrigin(originX, originY);
	
		assertEquals(originX, polygon.getOriginX(), 0.01f);
		assertEquals(originY, polygon.getOriginY(), 0.01f);
	}

	/**
	 * 
	 * Effect : Set Origin Values
	 * Parameter : setPosition(float, float)
	 * Input : 3.2f, 2.9f 
	 * Expected Output : 3.2f, 2.9f 
	 * Actual Output : 3.2f, 2.9f 
	 * 
	 */
	
	@Test
	public void testSetPosition () {
		float x = 3.2f, y = 2.9f;
		polygon.setPosition(x, y);
	
		assertEquals(x, polygon.getX(), 0.01f);
		assertEquals(y, polygon.getY(), 0.01f);
	}

	/**
	 * 
	 * Effect : Set Vertices
	 * Parameter : setVertices(float[])
	 * Input : (0,0, 1,1, 2,2), (0,0, 1,1, 2)
	 * Expected Output : (0,0, 1,1, 2,2), Error
	 * Actual Output : (0,0, 1,1, 2,2), Error
	 * 
	 */
	
	@Test
	public void testSetVertices () {
		float[] vertices = {0f,0f, 1f,1f, 2f,2f};
		float[] fakeVertices = {0f,0f, 1f,1f, 2f};

		polygon.setVertices(vertices);
		float[] resultVertices = polygon.getVertices();
		
		assertEquals(0f, resultVertices[0], 0.01f);
		assertEquals(0f, resultVertices[1], 0.01f);
		assertEquals(1f, resultVertices[2], 0.01f);
		assertEquals(1f, resultVertices[3], 0.01f);
		assertEquals(2f, resultVertices[4], 0.01f);
		assertEquals(2f, resultVertices[5], 0.01f);
		
		polygon.setVertices(fakeVertices);
	}

	/**
	 * 
	 * Effect : Set Vertices
	 * Parameter : setPosition(float,float), translate(float, float)
	 * Input : (3.2f, 2.9f), (6.8f, 7.1f)
	 * Expected Output : (10, 10)
	 * Actual Output : (10, 10)
	 * 
	 */
	
	@Test
	public void testTranslate () {
		float x = 3.2f, y = 2.9f;
		float translateX = 6.8f, translateY = 7.1f;
			
		polygon.setPosition(x, y);
		polygon.translate(translateX, translateY);

		assertEquals(10f, polygon.getX(), 0.01f);
		assertEquals(10f, polygon.getY(), 0.01f);
	}
	
	/**
	 * 
	 * Effect : Set Rotation Value
	 * Parameter : setRotation(float)
	 * Input : 90f
	 * Expected Output : 90f
	 * Actual Output : 90f
	 * 
	 */
	
	@Test
	public void testSetRotation () {
		float degree = 90;
		polygon.setRotation(degree);
		
		assertEquals(90, polygon.getRotation(), 0.1f);
	}

	/**
	 * 
	 * Effect : Set Rotation Value
	 * Parameter : setRotation(float), rotate(float)
	 * Input : 90f, 30f
	 * Expected Output : 120f
	 * Actual Output : 120f
	 * 
	 */
	
	@Test
	public void testRotate () {
		float degree = 90, rotateDegree = 30;
		polygon.setRotation(degree);
		polygon.rotate(rotateDegree);
		
		assertEquals(120, polygon.getRotation(), 0.1f);
	}

	/**
	 * 
	 * Effect : Set Scale Value
	 * Parameter : scale(float)
	 * Input : 9.5f
	 * Expected Output : 10.5f(scaleX), 10.5f(scaleY)
	 * Actual Output : 10.5f(scaleX), 10.5f(scaleY)
	 * 
	 */
	
	@Test
	public void testScale () {
		float amount = 9.5f;
		
		polygon.scale(amount);
		
		assertEquals(10.5, polygon.getScaleX(), 0.01f);
		assertEquals(10.5, polygon.getScaleY(), 0.01f);
	}
	
	
	/**
	 * 
	 * Effect : Set Scale Value
	 * Parameter : setScale(float,float)
	 * Input : 3.8f, 8.3f
	 * Expected Output : 3.8f(scaleX), 8.3f(scaleY)
	 * Actual Output : 3.8f(scaleX), 8.3f(scaleY)
	 * 
	 */
	
	@Test
	public void testSetScale () {
		float scaleX = 3.8f, scaleY = 8.3f;
		
		polygon.setScale(scaleX, scaleY);
		
		assertEquals(3.8, polygon.getScaleX(), 0.01f);
		assertEquals(8.3, polygon.getScaleY(), 0.01f);
	}
	
	/**
	 * 
	 * Effect : Test Polygon Area Value
	 * Parameter : setVertices, setOrigin, setRotation, setScale(float,float), area
	 * Input : (1,1, 2,2, 3,1), 0, 0, 0.5f, 0.5f
	 * Expected Output : 0.25
	 * Actual Output : -0.25
	 * 
	 */
	
	@Test
	public void testArea () {		
		float[] vertices = {1f,1f, 2f,2f, 3f,1f};

		float orginX = 0, orginY = 0;
		float rotation = 180f;
		float scaleX = 0.5f, scaleY = 0.5f;
		
		polygon.setVertices(vertices);
		polygon.setOrigin(orginX, orginY);
		polygon.setRotation(rotation);
		polygon.setScale(scaleX, scaleY);
		float area = polygon.area();
		
		assertEquals(0.25, area, 0.01);
	}
	
	/**
	 * 
	 * Effect : Test Bounding Rectangle Value
	 * Parameter : setVertices, setOrigin, setRotation, setScale(float,float), getBoundingRectangle()
	 * Input : (1,1, 2,2, 3,1), 1, 1, 0, 2f, 2f
	 * Expected Output : 1(bounding.x),1(bounding.y),4(bounding.width),2(bounding.height)
	 * Actual Output : 1(bounding.x),1(bounding.y),4(bounding.width),2(bounding.height)
	 * 
	 */
	
	@Test
	public void testGetBoundingRectangle () {
		float[] vertices = {1f,1f, 2f,2f, 3f,1f};
		float[] vertices1 = {2f,2f, 1f,1f, 3f,1f};
		float orginX = 1, orginY = 1;
		float rotation = 0;
		float scaleX = 2f, scaleY = 2f;
	
		polygon.setVertices(vertices);
		polygon.setOrigin(orginX, orginY);
		polygon.setRotation(rotation);
		polygon.setScale(scaleX, scaleY);
		
		Rectangle bounding = polygon.getBoundingRectangle();
		
		assertEquals(1, bounding.x, 0.01);
		assertEquals(1, bounding.y, 0.01);
		assertEquals(4, bounding.width, 0.01);
		assertEquals(2, bounding.height, 0.01);
	
	}

	/**
	 * 
	 * Effect : Test Bounding Rectangle Value
	 * Parameter : setVertices, setOrigin, setRotation, setScale(float,float), getBoundingRectangle()
	 * Input : (2,2, 1,1, 3,1), 1, 1, 0, 2f, 2f
	 * Expected Output : 1(bounding.x),1(bounding.y),4(bounding.width),2(bounding.height)
	 * Actual Output : 1(bounding.x),1(bounding.y),4(bounding.width),2(bounding.height)
	 * 
	 */
	
	@Test
	public void testGetBoundingRectangleChangeValue () {
		float[] vertices = {2f,2f, 1f,1f, 3f,1f};
		float orginX = 1, orginY = 1;
		float rotation = 0;
		float scaleX = 2f, scaleY = 2f;
	
		polygon.setVertices(vertices);
		polygon.setOrigin(orginX, orginY);
		polygon.setRotation(rotation);
		polygon.setScale(scaleX, scaleY);
		
		Rectangle bounding = polygon.getBoundingRectangle();

		bounding = polygon.getBoundingRectangle();
		
		assertEquals(1, bounding.x, 0.01);
		assertEquals(1, bounding.y, 0.01);
		assertEquals(4, bounding.width, 0.01);
		assertEquals(2, bounding.height, 0.01);
	}
	
	/**
	 * 
	 * Effect : Returns whether an x, y pair is contained within the polygon
	 * Parameter : setVertices, setOrigin, setRotation, setScale(float,float), contains(float,float), contains(float,float)
	 * Input : (0,0, 1,1, 3,1), 1, 1, 0, 2f, 2f, 1, 1, -1, -1
	 * Expected Output : true, false
	 * Actual Output : true, false
	 * 
	 */
	
	@Test
	public void testContainsFloatFloat () {
		float[] vertices = {0f,0f, 2f,2f, 3f,1f};
		float x = 1, y = 1, notConatinX = -1, notContainY = -1;
		float orginX = 1, orginY = 1;
		float rotation = 0;
		float scaleX = 2f, scaleY = 2f;

		polygon.setVertices(vertices);
		polygon.setOrigin(orginX, orginY);
		polygon.setRotation(rotation);
		polygon.setScale(scaleX, scaleY);
		
		boolean contain = polygon.contains(x, y);
		boolean contain1 = polygon.contains(notConatinX, notContainY);
		assertTrue(contain);
		assertFalse(contain1);
		}

	/**
	 * 
	 * Effect : Returns whether an x, y pair is contained within the polygon
	 * Parameter : setVertices, setOrigin, setRotation, setScale(float,float), contains(Vector2), contains(Vector2)
	 * Input : (0,0, 1,1, 3,1), 1, 1, 0, 2f, 2f, (1,1), (-1,-1)
	 * Expected Output : true, false
	 * Actual Output : true, false
	 * 
	 */
	
	@Test
	public void testContainsVector2 () {
		float[] vertices = {0f,0f, 2f,2f, 3f,1f};
		float x = 1, y = 1, notConatinX = -1, notContainY = -1;
		Vector2 containVector = new Vector2(x,y);
		Vector2 notContainVector = new Vector2(notConatinX,notContainY);

		float orginX = 1, orginY = 1;
		float rotation = 0;
		float scaleX = 2f, scaleY = 2f;

		polygon.setVertices(vertices);
		polygon.setOrigin(orginX, orginY);
		polygon.setRotation(rotation);
		polygon.setScale(scaleX, scaleY);
		
		boolean contain = polygon.contains(containVector);
		boolean contain1 = polygon.contains(notContainVector);
		assertTrue(contain);
		assertFalse(contain1);
	}

}
