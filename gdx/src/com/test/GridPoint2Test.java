/**
 * @author Kim SeungJu
 */

package testOracle;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.math.GridPoint3;

public class GridPoint2Test {

	/**
	 * Purpose: Check if the constructor using float works well
	 * Input: Float (1, 1)
	 * Expected: GridPoint2 (1, 1)
	 */
	@Test
	public void constructorTestFloat() {
		GridPoint2 grid3 = new GridPoint2();
		grid3.x = 1;
		grid3.y = 1;
		GridPoint2 grid = new GridPoint2(1, 1);
		assertEquals(grid, grid3);
	}
	
	/**
	 * Purpose: Check if the constructor using GridPoint2 works well
	 * Input: GridPoint2 (1, 1)
	 * Expected: GridPoint2 (1, 1)
	 */
	@Test
	public void constructorTestGrid() {
		GridPoint2 grid3 = new GridPoint2();
		grid3.x = 1;
		grid3.y = 1;
		GridPoint2 grid2 = new GridPoint2(new GridPoint2(1, 1));
		assertEquals(grid2, grid3);
	}
	
	/**
	 * Purpose: Check if the set function using GridPoint2 works well
	 * Input: GridPoint2 (1, 1)
	 * Expected: GridPoint2 (1, 1)
	 */
	@Test
	public void setTestGrid() {
		GridPoint2 grid = new GridPoint2();
		grid.set(new GridPoint2(1, 1));
		assertEquals(grid, new GridPoint2(1, 1));
	}

	/**
	 * Purpose: Check if the set function using float works well
	 * Input: Float (1, 1)
	 * Expected: GridPoint2 (1, 1)
	 */
	@Test
	public void setTestFloat() {
		GridPoint2 grid = new GridPoint2();
		grid.set(1, 1);
		assertEquals(grid, new GridPoint2(1, 1));
	}

	/**
	 * Purpose: Check if the dst2 function using GridPoint works well
	 * Input: GridPoint2 (1, 1)
	 * Expected: Float (0)
	 */
	@Test
	public void dst2TestGrid() {
		GridPoint2 grid = new GridPoint2(1, 1);
		assertEquals(0, Float.compare(0, grid.dst2(new GridPoint2(1, 1))));
	}

	/**
	 * Purpose: Check if the dst2 function using float works well
	 * Input: Float (1, 1)
	 * Expected: Float (0)
	 */
	@Test
	public void dst2TestFloat() {
		GridPoint2 grid = new GridPoint2(1, 1);
		assertEquals(0, Float.compare(0, grid.dst2(1, 1)));
	}

	/**
	 * Purpose: Check if the dst function using GridPoint works well
	 * Input: GridPoint2 (1, 1)
	 * Expected: Float (0)
	 */
	@Test
	public void dstTestGrid() {
		GridPoint2 grid = new GridPoint2(1, 1);
		assertEquals(0, Float.compare(0, grid.dst(new GridPoint2(1, 1))));
	}

	/**
	 * Purpose: Check if the dst function using float works well
	 * Input: Float (1, 1)
	 * Expected: Float (0)
	 */
	@Test
	public void dstTestFloat() {
		GridPoint2 grid = new GridPoint2(1, 1);
		assertEquals(0, Float.compare(0, grid.dst(1, 1)));
	}

	/**
	 * Purpose: Check if the add function using GridPoint works well
	 * Input: GridPoint2 (0, 0)
	 * Expected: GridPoint2 (1, 1)
	 */
	@Test
	public void addTestGrid() {
		GridPoint2 grid = new GridPoint2(1, 1);
		assertEquals(grid, grid.add(new GridPoint2(0, 0)));
	}

	/**
	 * Purpose: Check if the add function using float works well
	 * Input: Float (0, 0)
	 * Expected: GridPoint2 (1, 1)
	 */
	@Test
	public void addTestFloat() {
		GridPoint2 grid = new GridPoint2(1, 1);
		assertEquals(grid, grid.add(0, 0));
	}

	/**
	 * Purpose: Check if the sub function using GridPoint works well
	 * Input: GridPoint2 (0, 0)
	 * Expected: GridPoint2 (1, 1)
	 */
	@Test
	public void subTestGrid() {
		GridPoint2 grid = new GridPoint2(1, 1);
		assertEquals(grid, grid.sub(new GridPoint2(0, 0)));
	}

	/**
	 * Purpose: Check if the sub function using float works well
	 * Input: Float (0, 0)
	 * Expected: GridPoint2 (1, 1)
	 */
	@Test
	public void subTestFloat() {
		GridPoint2 grid = new GridPoint2(1, 1);
		assertEquals(grid, grid.sub(0, 0));
	}
	
	/**
	 * Purpose: Check if the cpy function works well
	 * Input: GridPoint2 (1, 1)
	 * Expected: GridPoint2 (1, 1)
	 */
	@Test
	public void cpyTest() {
		GridPoint2 grid = new GridPoint2(1, 1);
		GridPoint2 grid2 = grid.cpy();
		assertEquals(grid2, grid);
	}

	/**
	 * Purpose: Check if the equals function works well
	 * Input: GridPoint2 (1, 1), GridPoint2 (0, 0) 
	 * Expected: false
	 */
	@Test
	public void equalsTestDifferentXY() {
		GridPoint2 grid = new GridPoint2(1, 1);
		GridPoint2 grid2 = new GridPoint2();
		
		assertEquals(false, grid.equals(grid2));
	}

	/**
	 * Purpose: Check if the equals function works well
	 * Input: GridPoint2 (1, 1), GridPoint3 (0, 0, 0) 
	 * Expected: false
	 */
	@Test
	public void equalsTestDifferentType() {
		GridPoint2 grid = new GridPoint2(1, 1);
		GridPoint3 grid2 = new GridPoint3();
		
		assertEquals(false, grid.equals(grid2));
	}

	/**
	 * Purpose: Check if the equals function works well
	 * Input: GridPoint2 (1, 1), Uninitialized GridPoint3
	 * Expected: false
	 */
	@Test
	public void equalsTestUninitialized() {
		GridPoint2 grid = new GridPoint2(1, 1);
		GridPoint3 grid2 = null;
		
		assertEquals(false, grid.equals(grid2));
	}

	/**
	 * Purpose: Check if the equals function works well
	 * Input: GridPoint2 (1, 1), GridPoint2 (1, 0) 
	 * Expected: false
	 */
	@Test
	public void equalsTestDifferentY() {
		GridPoint2 grid = new GridPoint2(1, 1);
		GridPoint2 grid2 = new GridPoint2(1, 0);
		boolean equals = grid.equals(grid);
		
		assertEquals(false, grid.equals(grid2));
	}

	/**
	 * Purpose: Check if the hashCode function works well
	 * Input: GridPoint2 (1, 1)
	 * Expected: Int (2863)
	 */
	@Test
	public void hashCodeTest() {
		GridPoint2 grid = new GridPoint2(1, 1);
		assertEquals(2863, grid.hashCode());
	}
	
	/**
	 * Purpose: Check if the toString function works well
	 * Input: GridPoint2 (1, 1)
	 * Expected: String "(1, 1)"
	 */
	@Test
	public void toStringTest() {
		GridPoint2 grid = new GridPoint2(1, 1);
		assertEquals("(1, 1)", grid.toString());
	}
	

}
