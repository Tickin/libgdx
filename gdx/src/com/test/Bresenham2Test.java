package com.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.badlogic.gdx.math.*;
import com.badlogic.gdx.utils.*;

public class Bresenham2Test {
	
	/*
	 * Purpose: Instantiate the Class
	 * Input: Bresenham2
	 * Expected:
	 * 		return Instantiated instance of Bresenham2 class
	 */
	@Test
	public void TestConstructor(){
		Bresenham2 bresenham2_1 = new Bresenham2();
		
		assertNotNull(bresenham2_1);
	}
	
	/*
	 * Purpose: Check result of same y, different x line
	 * Input: line point1(5,8):GridPoint2 point2(10,8):GridPoint2
	 * 		 line point1(10,8):GridPoint2 point2(5,8):GridPoint2
	 * Expected:
	 * 		[(5,8),(6,8),(7,8),(8,8),(9,8),(10,9)]
	 * 		[(10,8),(9,8),(8,8),(7,8),(6,8),(5,8)]
	 */
	
	@Test
	public void TestLine_ChangeX(){
		Bresenham2 bresenham2_1 = new Bresenham2();
		
		Array<GridPoint2> points1 = new Array<GridPoint2>();
		Array<GridPoint2> points2 = new Array<GridPoint2>();
		
		GridPoint2 gridPoint2_1 = new GridPoint2(5,8);
		GridPoint2 gridPoint2_2 = new GridPoint2(10,8);
		
		for(int i=5;i<=10;i++)
			points1.add(new GridPoint2(i,8));
		
		points2 = bresenham2_1.line(gridPoint2_1, gridPoint2_2);
		
		assertEquals(points1, points2);
		
		gridPoint2_1.set(10,8);
		gridPoint2_2.set(5,8);
		
		points1.clear();
		
		for(int i=10;i>=5;i--)
			points1.add(new GridPoint2(i,8));
		
		points2 = bresenham2_1.line(gridPoint2_1, gridPoint2_2);
		
		assertEquals(points1, points2);
	}
	
	/*
	 * Purpose: Check result of same x, different y line
	 * Input: line point1(8,5):GridPoint2 point2(8,10):GridPoint2
	 * 		 line point1(8,10):GridPoint2 point2(8,5):GridPoint2
	 * Expected:
	 * 		[(8,5),(8,6),(8,7),(8,8),(8,9),(8,10)]
	 * 		[(8,10),(8,9),(8,8),(8,7),(8,6),(8,5)]
	 */
	
	@Test
	public void TestLine_ChangeY(){
		Bresenham2 bresenham2_1 = new Bresenham2();
		
		Array<GridPoint2> points1 = new Array<GridPoint2>();
		Array<GridPoint2> points2 = new Array<GridPoint2>();
		
		GridPoint2 gridPoint2_1 = new GridPoint2(8,5);
		GridPoint2 gridPoint2_2 = new GridPoint2(8,10);
		
		for(int i=5;i<=10;i++)
			points1.add(new GridPoint2(8,i));
		
		points2 = bresenham2_1.line(gridPoint2_1, gridPoint2_2);
		
		assertEquals(points1, points2);
		
		gridPoint2_1.set(8,10);
		gridPoint2_2.set(8,5);
		
		points1.clear();
		
		for(int i=10;i>=5;i--)
			points1.add(new GridPoint2(8,i));
		
		points2 = bresenham2_1.line(gridPoint2_1, gridPoint2_2);
		
		assertEquals(points1, points2);
	}
	
	/*
	 * Purpose: Check result of different x, different y line
	 * Input: line point1(5,5):GridPoint2 point2(10,10):GridPoint2
	 * 		 line point1(5,10):GridPoint2 point2(10,20):GridPoint2
	 * Expected:
	 * 		[(8,5),(8,6),(8,7),(8,8),(8,9),(8,10)]
	 * 		[(8,10),(8,9),(8,8),(8,7),(8,6),(8,5)]
	 */
	
	@Test
	public void TestLine_ChangeXY(){
		Bresenham2 bresenham2_1 = new Bresenham2();
		
		Array<GridPoint2> points1 = new Array<GridPoint2>();
		Array<GridPoint2> points2 = new Array<GridPoint2>();
		
		GridPoint2 gridPoint2_1 = new GridPoint2(5,5);
		GridPoint2 gridPoint2_2 = new GridPoint2(10,10);
		
		for(int i=5;i<=10;i++)
			points1.add(new GridPoint2(i,i));
		
		points2 = bresenham2_1.line(gridPoint2_1, gridPoint2_2);
		
		assertEquals(points1, points2);
		
		gridPoint2_1.set(5,10);
		gridPoint2_2.set(10,20);
		
		points1.clear();
		
		for(int i=10;i<=20;i++)
			points1.add(new GridPoint2(i/2,i));
		
		points2 = bresenham2_1.line(gridPoint2_1, gridPoint2_2);
		
		assertEquals(points1, points2);
	}
}
