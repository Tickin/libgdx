package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.badlogic.gdx.math.*;

public class CircleTest {
	Vector2 vector2_1;
	Vector2 vector2_2;

	@Before
	public void setUp() throws Exception{
		vector2_1 = new Vector2(2,5);
		vector2_2 = new Vector2(5,5);
	}
	
	/*
	 * Purpose: Instantiate Circle Class
	 * Input: Circle void
	 * 		 Circle x(2f):float, y(2f):float, radius(2f):float
	 * 		 Circle x(2):float, y:(2):float, radius(2):float
	 * 		 Circle center(2,5):Vector2, radius(5):float
	 * 		 Circle center(2,5):Vector2, edge(5,5):Vector2
	 * 		 Circle other(0,0,0):Circle
	 * Expected:
	 * 		return NotNull For all case
	 * 		(0f,0f,0f)
	 * 		(2f,2f,2f)
	 * 		(2f,2f,2f)
	 * 		(2f,5f,5f)
	 * 		(2f,5f,3f)
	 * 		(0f,0f,0f)
	 */
	@Test
	public void TestValidConstructor(){
		Circle circle1 = new Circle();
		assertNotNull(circle1);
		
		Circle circle2 = new Circle(2f,2f,2f);
		assertNotNull(circle2);
		
		Circle circle3 = new Circle(2, 2, 2);
		assertNotNull(circle3);
		
		Circle circle4 = new Circle(vector2_1, 5);
		assertNotNull(circle4);
		
		Circle circle5 = new Circle(vector2_1, vector2_2);
		assertNotNull(circle5);
		
		Circle circle6 = new Circle(circle1);
		assertNotNull(circle6);
	}
	
	/*
	 * Purpose: Instantiate Circle class with NegativeRadius
	 * Input: Circle x(2):float, y(2):float, radius(-2):float
	 * 		 Circle x(2f):float, y(2f):float, radius(-5f):float
	 * 		 Circle center(2,5):Vector2, radius(-3):float
	 * Expected:
	 * 		return Null
	 * 		null
	 * 		null
	 * 		null
	 */
	@Test
	public void TestInvalidConstructor_NegativeRadiusIsNull(){
		Circle circle1 = new Circle(2,2,-2);
		
		Circle circle2 = new Circle(2f,2f,-5f);
		
		Circle circle3 = new Circle(vector2_1, -3);
		
		assertNull(circle2);
		assertNull(circle1);
		assertNull(circle3);
	}
	
	/*
	 * Purpose: Instantiate Circle class with NegativeRadius
	 * Input: Circle x(2):float, y(2):float, radius(-2):float
	 * 		 Circle x(2f):float, y(2f):float, radius(-5f):float
	 * 		 Circle center(2,5):Vector2, radius(-3):float
	 * Expected:
	 * 		return Circle with the absolute value of radius
	 * 		(2f,2f,2f)
	 * 		(2f,2f,5f)
	 * 		(2f,5f,3f)
	 */
	@Test
	public void TestInvalidConstructor_NegativeRadiusIsAbs(){
		Circle circle1 = new Circle(2,2,-2);
		
		Circle circle2 = new Circle(2f,2f,-5f);
		
		Circle circle3 = new Circle(vector2_1, -3);
		
		assertEquals(circle2.radius, 2, 0.01f);
		assertEquals(circle1.radius, 5, 0.01f);
		assertEquals(circle3.radius, 3, 0.01f);
	}
	
	/*
	 * Purpose: Set the value of instances
	 * Input: set x(2):float, y(2):float, radius(2):float
	 * 		 set center(2,5):Vector2, radius(5):float
	 * 		 set center(2,5):Vector2, edge(5,5):Vector2
	 * 		 set other(4,5,6):Circle
	 * 		 setX x(5):float
	 * 		 setY y(8):float
	 * 		 setRadius radius(2):float
	 * 		 setPosition x(8):float, y(10):float
	 * 		 setPosition center(2,5):Vector2
	 * Expected:
	 * 		(2f,2f,2f)
	 * 		(2f,5f,5f)
	 * 		(2f,5f,3f)
	 * 		(4f,5f,6f)
	 * 		(5f,5f,6f)
	 * 		(5f,8f,6f)
	 * 		(5f,8f,2f)
	 * 		(8f,10f,2f)
	 * 		(2f,5f,2f)
	 */
	
	@Test
	public void TestValidSetter(){
		Circle circle1 = new Circle();
		circle1.set(2,2,2);
		
		assertEquals(circle1.x, 2, 0.01f);
		assertEquals(circle1.y, 2, 0.01f);
		assertEquals(circle1.radius, 2, 0.01f);
		
		circle1.set(vector2_1,5);
		
		assertEquals(circle1.x, 2, 0.01f);
		assertEquals(circle1.y, 5, 0.01f);
		assertEquals(circle1.radius, 5, 0.01f);
		
		circle1.set(vector2_1, vector2_2);
		
		assertEquals(circle1.x, 2, 0.01f);
		assertEquals(circle1.y, 5, 0.01f);
		assertEquals(circle1.radius, 3, 0.01f);
		
		Circle circle2 = new Circle(4,5,6);
		circle1.set(circle2);
		
		assertEquals(circle1.x, 4, 0.01f);
		assertEquals(circle1.y, 5, 0.01f);
		assertEquals(circle1.radius, 6, 0.01f);
		
		circle1.setX(5);
		
		assertEquals(circle1.x, 5, 0.01f);
		
		circle1.setY(8);
		
		assertEquals(circle1.y, 8, 0.01f);
		
		circle1.setRadius(2);
		
		assertEquals(circle1.radius, 2, 0.01f);
		
		circle1.setPosition(8,10);
		
		assertEquals(circle1.x, 8, 0.01f);
		assertEquals(circle1.y, 10, 0.01f);
		
		circle1.setPosition(vector2_1);
		
		assertEquals(circle1.x, 2, 0.01f);
		assertEquals(circle1.y, 5, 0.01f);
	}
	
	/*
	 * Purpose: set radius to negative value
	 * Input: set x(2):float, y(2):float, radius(-2):float
	 * 		 set center(2,5):Vector2, radius(-5):float
	 * Expected:
	 * 		set the radius to absolute value
	 * 		(2f,2f,2f)
	 * 		(2f,5f,5f)
	 */
	
	@Test
	public void TestInvalidSetter_NegativeRadiusIsAbs(){
		Circle circle1 = new Circle();
		circle1.set(2,2,-2);
		
		assertEquals(circle1.x, 2, 0.01f);
		assertEquals(circle1.y, 2, 0.01f);
		assertEquals(circle1.radius, 2, 0.01f);
		
		circle1.set(vector2_1, -5);
		
		assertEquals(circle1.x, 2, 0.01f);
		assertEquals(circle1.y, 5, 0.01f);
		assertEquals(circle1.radius, 5, 0.01f);
	}
	
	/*
	 * Purpose: set radius to negative value
	 * Input: set x(2):float, y(2):float, radius(-2):float
	 * 		 set center(2,5):Vector2, radius(-5):float
	 * Expected:
	 * 		set the radius to zero
	 * 		(2f,2f,0f)
	 * 		(2f,5f,0f)
	 */
	
	@Test
	public void TestInvalidSetter_NegativeRadiusIsZero(){
		Circle circle1 = new Circle();
		circle1.set(2,2,-2);
		
		assertEquals(circle1.x, 2, 0.01f);
		assertEquals(circle1.y, 2, 0.01f);
		assertEquals(circle1.radius, 0, 0.01f);
		
		circle1.set(vector2_1, -5);
		
		assertEquals(circle1.x, 2, 0.01f);
		assertEquals(circle1.y, 5, 0.01f);
		assertEquals(circle1.radius, 0, 0.01f);
	}
	
	/*
	 * Purpose: Check the circle contains the position or circle
	 * Input: circle1(2,5,2):Circle - 
	 * 			contains x(3):float, y(4):float
	 * 			contains point(2,5):Vector2
	 * 			contains other(2,5,2):Circle
	 * 			contains other(2,5,1):Circle
	 * 			contains other(2,5,2):Circle
	 * 			contains x(5):float, y(5):float
	 * 			contains point(5,5):Vector2
	 * 			contains other(3,5,2):Circle
	 * 			contains other(10,10,3):Circle
	 * 
	 * 		 circle2(2,5,1):Circle - 
	 * 			contains other(2,5,2):Circle
	 * Expected:
	 * 		true
	 * 		true
	 * 		true
	 * 		true
	 * 		true
	 * 		false
	 * 		false
	 * 		false
	 * 		false
	 * 
	 * 		false
	 */
	
	@Test
	public void TestValidContains(){
		Circle circle1 = new Circle(2,5,2);
		Circle circle2 = new Circle(2,5,1);
		Circle circle3 = new Circle(circle1);
		Circle circle4 = new Circle(10,10,3);
		Circle circle5 = new Circle(3,5,2);
		
		assertTrue(circle1.contains(3,4));
		assertTrue(circle1.contains(vector2_1));
		assertTrue(circle1.contains(circle1));
		assertTrue(circle1.contains(circle2));
		assertTrue(circle1.contains(circle3));
		assertFalse(circle1.contains(5,5));
		assertFalse(circle1.contains(vector2_2));
		assertFalse(circle1.contains(circle5));
		assertFalse(circle2.contains(circle1));
		assertFalse(circle1.contains(circle4));
	}
	
	/*
	 * Purpose: Check the negative radius circle contains zero radius circle
	 * Input circle1(2,2,-2):Circle - 
	 * 			contains other(2,2,0):Circle
	 * Expected:
	 * 		true
	 */
	
	@Test
	public void TestInvalidContains_CircleWithNegativeRadius(){
		Circle circle1 = new Circle(2,2,-2);
		Circle circle2 = new Circle(2,2,0);
		
		assertTrue(circle1.contains(circle2));
	}
	
	/*
	 * Purpose: Check the circle overlaps the other circle
	 * Input: circle1(2,2,3):Circle - 
	 * 			overlaps other(2,3,6):Circle
	 * 			overlaps other(2,2,5):Circle
	 * 			overlaps other(10,10,2):Circle
	 * 
	 * 		 circle2(2,2,5):Circle - 
	 * 			overlaps other(2,3,6):Circle
	 * Expected:
	 * 		true
	 * 		true
	 * 		false
	 * 		
	 * 		true
	 */
	
	@Test
	public void TestValidOverlaps(){
		Circle circle1 = new Circle(2,2,3);
		Circle circle2 = new Circle(2,2,5);
		Circle circle3 = new Circle(2,3,6);
		Circle circle4 = new Circle(10,10,2);
		
		assertTrue(circle1.overlaps(circle3));
		assertTrue(circle1.overlaps(circle2));
		assertTrue(circle2.overlaps(circle3));
		assertFalse(circle1.overlaps(circle4));
	}
	
	/*
	 * Purpose: Check the negative radius circle overlaps the other negative radius circle
	 * Input: circle1(2,2,-2):Circle - 
	 * 			overlaps other(2,2,-5):Circle
	 * 			overlaps other(10,10,-5):Circle
	 * 
	 * 		 circle2(2,2,-5):Circle - 
	 * 			overlaps other(10,10,-5):Circle
	 */
	
	@Test
	public void TestInvalidOverlaps_NegativeRadiusCircles(){
		Circle circle1 = new Circle(2,2,-2);
		Circle circle2 = new Circle(2,2,-5);
		Circle circle3 = new Circle(10,10,-5);
		
		assertTrue(circle1.overlaps(circle2));
		assertFalse(circle1.overlaps(circle3));
		assertTrue(circle2.overlaps(circle3));
	}
	
	/*
	 * Purpose: calculate the circumference of the circle
	 * Input: circle1(2,2,5):Circle - 
	 * 			circumference
	 * Expected:
	 * 		return circumference of the circle
	 * 		2 * 5 * PI(3.141592...)
	 */
	
	@Test
	public void TestCircumference(){
		Circle circle1 = new Circle(2,2,5);
		
		assertEquals(circle1.circumference(), 2 * 5 * Math.PI, 0.01f);
	}
	
	/*
	 * Purpose: calculate the area of the circle
	 * Input: circle1(2,2,5):Circle - 
	 * 			area
	 * Expected:
	 * 		return the area of the circle
	 * 		5^2 * PI(3.141592...)
	 */
	
	@Test
	public void TestArea(){
		Circle circle1 = new Circle(2,2,5);
		
		assertEquals(circle1.area(), 5 * 5 * Math.PI, 0.01f);
	}
	
	/*
	 * Purpose: Check two object is equal
	 * Input:
	 * 		equals circle1(2,2,2):Circle circle1(2,2,2):Circle
	 * 		equals circle1(2,2,2):Circle circle2(2,2,2):Circle
	 * 		equals circle1(2,2,2):Circle circle3(2,2,3):Circle
	 * 		equals circle1(2,2,2):Circle circle4(2,3,3):Circle
	 * 		equals circle1(2,2,2):Circle circle5(3,3,3):Circle
	 * 		equals circle1(2,2,2):Circle null
	 * 		equals circle1(2,2,2):Circle vector2_1(2,5):Vector2
	 * Expected:
	 * 		true
	 * 		true
	 * 		false
	 * 		false
	 * 		false
	 * 		false
	 * 		false
	 */
	
	@Test
	public void TestEquals(){
		Circle circle1 = new Circle(2,2,2);
		Circle circle2 = new Circle(2,2,2);
		Circle circle3 = new Circle(2,2,3);
		Circle circle4 = new Circle(2,3,3);
		Circle circle5 = new Circle(3,3,3);
		
		assertEquals(circle1, circle1);
		assertEquals(circle1, circle2);
		assertNotEquals(circle1, circle3);
		assertNotEquals(circle1, circle4);
		assertNotEquals(circle1, circle5);
		assertNotEquals(circle1, null);
		assertNotEquals(circle1, vector2_1);
	}
}
