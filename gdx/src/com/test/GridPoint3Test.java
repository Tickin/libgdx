/**
 * @author Kim SeungJu
 */

package com.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.badlogic.gdx.math.GridPoint3;
import com.badlogic.gdx.math.GridPoint2;

public class GridPoint3Test {

	/**
	 * Purpose: Check if the constructor using float works well
	 * Input: Float (1, 1, 1)
	 * Expected: GridPoint3 (1, 1, 1)
	 */
	@Test
	public void constructorTestFloat() {
		GridPoint3 grid3 = new GridPoint3();
		grid3.x = 1;
		grid3.y = 1;
		grid3.z = 1;
		GridPoint3 grid = new GridPoint3(1, 1, 1);
		assertEquals(grid, grid3);
	}
	
	/**
	 * Purpose: Check if the constructor using GridPoint3 works well
	 * Input: GridPoint3 (1, 1, 1)
	 * Expected: GridPoint3 (1, 1, 1)
	 */
	@Test
	public void constructorTestGrid() {
		GridPoint3 grid3 = new GridPoint3();
		grid3.x = 1;
		grid3.y = 1;
		grid3.z = 1;
		GridPoint3 grid2 = new GridPoint3(new GridPoint3(1, 1, 1));
		assertEquals(grid2, grid3);
	}
	
	/**
	 * Purpose: Check if the set function using GridPoint3 works well
	 * Input: GridPoint3 (1, 1, 1)
	 * Expected: GridPoint3 (1, 1, 1)
	 */
	@Test
	public void setTestGrid() {
		GridPoint3 grid = new GridPoint3();
		grid.set(new GridPoint3(1, 1, 1));
		assertEquals(grid, new GridPoint3(1, 1, 1));
	}

	/**
	 * Purpose: Check if the set function using float works well
	 * Input: Float (1, 1, 1)
	 * Expected: GridPoint3 (1, 1, 1)
	 */
	@Test
	public void setTestFloat() {
		GridPoint3 grid = new GridPoint3();
		grid.set(1, 1, 1);
		assertEquals(grid, new GridPoint3(1, 1, 1));
	}

	/**
	 * Purpose: Check if the dst2 function using GridPoint works well
	 * Input: GridPoint3 (1, 1, 1)
	 * Expected: Float (0)
	 */
	@Test
	public void dst2TestGrid() {
		GridPoint3 grid = new GridPoint3(1, 1, 1);
		assertEquals(0, Float.compare(0, grid.dst2(new GridPoint3(1, 1, 1))));
	}

	/**
	 * Purpose: Check if the dst2 function using float works well
	 * Input: Float (1, 1, 1)
	 * Expected: Float (0)
	 */
	@Test
	public void dst2TestFloat() {
		GridPoint3 grid = new GridPoint3(1, 1, 1);
		assertEquals(0, Float.compare(0, grid.dst2(1, 1, 1)));
	}

	/**
	 * Purpose: Check if the dst function using GridPoint works well
	 * Input: GridPoint3 (1, 1, 1)
	 * Expected: Float (0)
	 */
	@Test
	public void dstTestGrid() {
		GridPoint3 grid = new GridPoint3(1, 1, 1);
		assertEquals(0, Float.compare(0, grid.dst(new GridPoint3(1, 1, 1))));
	}

	/**
	 * Purpose: Check if the dst function using float works well
	 * Input: Float (1, 1, 1)
	 * Expected: Float (0)
	 */
	@Test
	public void dstTestFloat() {
		GridPoint3 grid = new GridPoint3(1, 1, 1);
		assertEquals(0, Float.compare(0, grid.dst(1, 1, 1)));
	}

	/**
	 * Purpose: Check if the add function using GridPoint works well
	 * Input: GridPoint3 (0, 0, 0)
	 * Expected: GridPoint3 (1, 1, 1)
	 */
	@Test
	public void addTestGrid() {
		GridPoint3 grid = new GridPoint3(1, 1, 1);
		assertEquals(grid, grid.add(new GridPoint3(0, 0, 0)));
	}

	/**
	 * Purpose: Check if the add function using float works well
	 * Input: Float (0, 0, 0)
	 * Expected: GridPoint3 (1, 1, 1)
	 */
	@Test
	public void addTestFloat() {
		GridPoint3 grid = new GridPoint3(1, 1, 1);
		assertEquals(grid, grid.add(0, 0, 0));
	}

	/**
	 * Purpose: Check if the sub function using GridPoint works well
	 * Input: GridPoint3 (0, 0, 0)
	 * Expected: GridPoint3 (1, 1, 1)
	 */
	@Test
	public void subTestGrid() {
		GridPoint3 grid = new GridPoint3(1, 1, 1);
		assertEquals(grid, grid.sub(new GridPoint3(0, 0, 0)));
	}

	/**
	 * Purpose: Check if the sub function using float works well
	 * Input: Float (0, 0, 0)
	 * Expected: GridPoint3 (1, 1, 1)
	 */
	@Test
	public void subTestFloat() {
		GridPoint3 grid = new GridPoint3(1, 1, 1);
		assertEquals(grid, grid.sub(0, 0, 0));
	}
	
	/**
	 * Purpose: Check if the cpy function works well
	 * Input: GridPoint3 (1, 1, 1)
	 * Expected: GridPoint3 (1, 1, 1)
	 */
	@Test
	public void cpyTest() {
		GridPoint3 grid = new GridPoint3(1, 1, 1);
		GridPoint3 grid2 = grid.cpy();
		assertEquals(grid2, grid);
	}

	/**
	 * Purpose: Check if the equals function works well
	 * Input: GridPoint3 (1, 1, 1), GridPoint3 (0, 0, 0) 
	 * Expected: false
	 */
	@Test
	public void equalsTestDifferentXYZ() {
		GridPoint3 grid = new GridPoint3(1, 1, 1);
		GridPoint3 grid2 = new GridPoint3();
		
		assertEquals(false, grid.equals(grid2));
	}

	/**
	 * Purpose: Check if the equals function works well
	 * Input: GridPoint3 (1, 1, 1), GridPoint2 (0, 0) 
	 * Expected: false
	 */
	@Test
	public void equalsTestDifferentType() {
		GridPoint3 grid = new GridPoint3(1, 1, 1);
		GridPoint2 grid2 = new GridPoint2();
		
		assertEquals(false, grid.equals(grid2));
	}

	/**
	 * Purpose: Check if the equals function works well
	 * Input: GridPoint3 (1, 1, 1), Uninitialized GridPoint2
	 * Expected: false
	 */
	@Test
	public void equalsTestUninitialized() {
		GridPoint3 grid = new GridPoint3(1, 1, 1);
		GridPoint2 grid2 = null;
		
		assertEquals(false, grid.equals(grid2));
	}

	/**
	 * Purpose: Check if the equals function works well
	 * Input: GridPoint3 (1, 1, 1), GridPoint3 (1, 0, 0) 
	 * Expected: false
	 */
	@Test
	public void equalsTestDifferentYZ() {
		GridPoint3 grid = new GridPoint3(1, 1, 1);
		GridPoint3 grid2 = new GridPoint3(1, 0, 0);
		boolean equals = grid.equals(grid);
		
		assertEquals(false, grid.equals(grid2));
	}

	/**
	 * Purpose: Check if the hashCode function works well
	 * Input: GridPoint3 (1, 1, 1), GridPoint3 (1, 1, 0)
	 * Expected: Int (2863)
	 */
	@Test
	public void equalsTestDifferentZ() {
		GridPoint3 grid = new GridPoint3(1, 1, 1);
		GridPoint3 grid2 = new GridPoint3(1, 1, 0);
		boolean equals = grid.equals(grid);
		
		assertEquals(false, grid.equals(grid2));
	}

	/**
	 * Purpose: Check if the hashCode function works well
	 * Input: GridPoint3 (1, 1, 1)
	 * Expected: Int (5220)
	 */
	@Test
	public void hashCodeTest() {
		GridPoint3 grid = new GridPoint3(1, 1, 1);
		assertEquals(5220, grid.hashCode());
	}
	
	/**
	 * Purpose: Check if the toString function works well
	 * Input: GridPoint3 (1, 1, 1)
	 * Expected: String "(1, 1, 1)"
	 */
	@Test
	public void toStringTest() {
		GridPoint3 grid = new GridPoint3(1, 1, 1);
		assertEquals("(1, 1, 1)", grid.toString());
	}
}
