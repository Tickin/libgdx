/**
 * @author Kim SeungJu
 */

package testOracle;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.badlogic.gdx.math.GeometryUtils;
import com.badlogic.gdx.math.Vector2;

public class GeometryUtilsTest {
	
	/**
	 * Purpose: Check the constructor works well
	 * Input: none
	 * Expected: not null
	 */
	@Test
	public void constructorTest() {
		GeometryUtils geo = new GeometryUtils();
		assertNotEquals(null, geo);
	}

	/**
	 * Purpose: Check if x >= 0 and y < 0
	 * Input: Vector2 (999, -999)
	 * Expected: false
	 */
	@Test
	public void barycoordInsideTriangleTestPosNeg() {
		Vector2 v1 = new Vector2(999, -999);
		assertEquals(false, GeometryUtils.barycoordInsideTriangle(v1));
	}
	
	/**
	 * Purpose: Check if x < 0 and y >= 0
	 * Input: Vector2 (-999, 999)
	 * Expected: false
	 */
	@Test
	public void barycoordInsideTriangleTestNegPos() {
		Vector2 v1 = new Vector2(-999, 999);
		assertEquals(false, GeometryUtils.barycoordInsideTriangle(v1));
	}

	/**
	 * Purpose: Check if x >= 0 and y >= 0 and x + y <= 1
	 * Input: Vector2 (0, 0)
	 * Expected: true
	 */
	@Test
	public void barycoordInsideTriangleTestBothPos() {
		Vector2 v1 = new Vector2(0, 0);
		assertEquals(true, GeometryUtils.barycoordInsideTriangle(v1));
	}

	/**
	 * Purpose: Check if x >= 0 and y >= 0 and x + y > 1
	 * Input: Vector2 (1, 1)
	 * Expected: false
	 */
	@Test
	public void barycoordInsideTriangleTest6() {
		Vector2 v1 = new Vector2(1, 1);
		assertEquals(false, GeometryUtils.barycoordInsideTriangle(v1));
	}

	/**
	 * Purpose: Check if the two 3D dots are on the same line 
	 * Input: Float (1, 1, 1), Float (1, 1, 1)
	 * Expected: true
	 */
	@Test
	public void colinearTestColinear() {
		assertEquals(true, GeometryUtils.colinear(1, 1, 1, 1, 1, 1));
	}
	
	/**
	 * Purpose: Check if the two 3D dots are on the same line 
	 * Input: Float (1, 2, 4), Float (8, 6, 2)
	 * Expected: false
	 */
	@Test
	public void colinearTestNotColinear() {
		assertEquals(false, GeometryUtils.colinear(1, 2, 4, 8, 6, 2));
	}
	
	/**
	 * Purpose: Check if the two 3D dots are on the same line 
	 * Input: Float (1, 2, 4), Float (8, 6, 2)
	 * Expected: false
	 */
	@Test
	public void areVerticesClockwiseTest () {
		float v[] = {1, 2, 3, 4, 5, 6}; 
		GeometryUtils.ensureCCW(v);
	}

	/**
	 * Purpose: Check if the computed area is correct 
	 * Input: Float Array (1, 1, 1, 1, 1, 1), offset (0), count (6)
	 * Expected: 0
	 */
	@Test
	public void polygonAreaTest () {
		float v[] = {1, 1, 1, 1, 1, 1};
		assertEquals(0, Float.compare(0, GeometryUtils.polygonArea(v, 0, 6)));
	}

	/**
	 * Purpose: Check if the computed centroid is correct when signed area = 0
	 * Input: Float Array (1, 1, 1, 1, 1, 1), offset (0), count (6), Vector2 (1, 1)
	 * Expected: Vector2 (0, 0)
	 */
	@Test
	public void polygonCentroidTest () {
		float v[] = {1, 1, 1, 1, 1, 1}; 
		Vector2 v2 = new Vector2(1, 1);
		Vector2 v3 = new Vector2(0, 0);
		assertEquals(v3, GeometryUtils.polygonCentroid(v, 0, 6, v2));
	}
	
	/**
	 * Purpose: Check if the computed centroid is correct when signed area != 0
	 * Input: Float Array (1, 2, 4, 8, 6, 2), offset (0), count (6), Vector2 (1, 1)
	 * Expected: Vector2 (3.6666667, 4.0)
	 */
	@Test
	public void polygonCentroidTest2() {
		float v[] = {1, 2, 4, 8, 6, 2}; 
		Vector2 v2 = new Vector2(1, 1);
		assertEquals(new Vector2(3.6666667f, 4.0f), GeometryUtils.polygonCentroid(v, 0, 6, v2));
	}
	
	/**
	 * Purpose: Check if the quadrilateral centroid is correct
	 * Input: Float (1, 1, 1, 1, 1, 1, 1, 1), Vector2 (0.5, 0.5)
	 * Expected: Vector2 (1, 1)
	 */
	@Test
	public void quadrilateralCentroidTest() {
		Vector2 v2 = new Vector2(0.5f, 0.5f);
		float f = 1;
		assertEquals(new Vector2(1, 1), GeometryUtils.quadrilateralCentroid(1, 1, 1, 1, 1, 1, f, f, v2));
	}
	
	/**
	 * Purpose: Check if the circumcenter of the triangle is correct 
	 * Input: Float (31, 2, 4, 8, 16, 32), Vector2 (1, 1)
	 * Expected: Vector2 (19.75, 15.125)
	 */
	@Test
	public void triangleCircumcenterTest() {
		Vector2 v1 = new Vector2(1, 1);
		assertEquals(new Vector2(19.75f, 15.125f), GeometryUtils.triangleCircumcenter(31, 2, 4, 8, 16, 32, v1));
	}

	/**
	 * Purpose: Check if the circumradius of the triangle is correct where y2 != y1 and y3 != y2
	 * Input: Float (4, 6, 9, 13, 8, 4)
	 * Expected: Float (4.583784)
	 */
	@Test
	public void triangleCircumradiusTestFirst() {
		assertEquals(0, Float.compare(4.583784f, GeometryUtils.triangleCircumradius(4, 6, 9, 13, 8, 4)));
	}

	/**
	 * Purpose: Check if the circumradius of the triangle is correct where y2 = y1
	 * Input: Float (4, 6, 9, 6, 8, 4)
	 * Expected: Float (2.5)
	 */
	@Test
	public void triangleCircumradiusTestSecond() {
		assertEquals(0, Float.compare(2.5f, GeometryUtils.triangleCircumradius(4, 6, 9, 6, 8, 4)));
	}

	/**
	 * Purpose: Check if the circumradius of the triangle is correct where y3 = y2
	 * Input: Float (4, 6, 9, 13, 8, 13)
	 * Expected: Float (4.953869)
	 */
	@Test
	public void triangleCircumradiusTestThird() {
		assertEquals(0, Float.compare(4.953869f, GeometryUtils.triangleCircumradius(4, 6, 9, 13, 8, 13)));
	}

	/**
	 * Purpose: Check if the lowest positive root is correct where r1 > 0 
	 * Input: Float (1, -2, 1)
	 * Expected: Float (1)
	 */
	@Test
	public void lowestPositiveRootTest() {
		assertEquals(0, Float.compare(1.0f, GeometryUtils.lowestPositiveRoot(1, -2, 1)));
	}

	/**
	 * Purpose: Check if the lowest positive root is correct where det < 0
	 * Input: Float (1, 2, 3)
	 * Expected: NaN
	 */
	@Test
	public void lowestPositiveRootTestDetNeg() {
		assertEquals(0, Float.compare(Float.NaN, GeometryUtils.lowestPositiveRoot(1, 2, 3)));
	}

	/**
	 * Purpose: Check if the lowest positive root is correct where r1 <= 0 and r2 <= 0 
	 * Input: Float (1, 3, 2) 
	 * Expected: NaN
	 */
	@Test
	public void lowestPositiveRootTestBothNeg() {
		assertEquals(0, Float.compare(Float.NaN, GeometryUtils.lowestPositiveRoot(1, 3, 2)));
	}

	/**
	 * Purpose: Check if the lowest positive root is correct where r1 > 0
	 * Input: 
	 * Expected: 
	 */
	@Test
	public void lowestPositiveRootTestR1Pos() {
		assertEquals(0, Float.compare(2.0f, GeometryUtils.lowestPositiveRoot(1, 0, -4)));
	}

	/**
	 * Purpose: Check if the area of the triangle is correct
	 * Input: Float (1, 3, 6, 10, 15, 21) 
	 * Expected: Float (4)
	 */
	@Test
	public void triangleAreaTest() {
		float f = 4.0f;
		assertEquals(0, Float.compare(f, GeometryUtils.triangleArea(1, 3, 6, 10, 15, 21)));
	}

	/**
	 * Purpose: Check if triangle quality is correctly measured 
	 * Input: Float (4, 6, 5, 7, 8, 4)
	 * Expected: Float (3.224903)
	 */
	@Test
	public void triangleQualityTest() {
		assertEquals(0, Float.compare(3.224903f, GeometryUtils.triangleQuality(4, 6, 5, 7, 8, 4)));
	}

	/**
	 * Purpose: Check if the centroid of the triangle is correctly measured
	 * Input: Float (1, 1, 1, 1, 1, 1), Vector2 (1, 1)
	 * Expected: Vector2 (1, 1)
	 */
	@Test
	public void triangleCentroidTest() {
		Vector2 cent = new Vector2(1, 1);
		assertEquals(new Vector2(1, 1), GeometryUtils.triangleCentroid(1, 1, 1, 1, 1, 1, cent));
	}

	/**
	 * Purpose: Check if the interpolated value is correct where given five zero vectors 
	 * Input: 5 Vector2 (0, 0)
	 * Expected: Vector2 (0, 0)
	 */
	@Test
	public void fromBarycoordTestVector() {
		Vector2 v1 = new Vector2(0, 0);
		Vector2 v2 = new Vector2(0, 0);
		Vector2 v3 = new Vector2(0, 0);
		Vector2 v4 = new Vector2(0, 0);
		Vector2 v5 = new Vector2(0, 0);
		Vector2 result = new Vector2(0, 0);
		assertEquals(result, GeometryUtils.fromBarycoord(v1, v2, v3, v4, v5));
	}

	/**
	 * Purpose: Check if the interpolated value is correct where given a vector and floats 
	 * Input: Vector2 (1, 1), Float (1, 1, 1)
	 * Expected: 
	 */
	@Test
	public void fromBarycoordTestFloat() {
		Vector2 v1 = new Vector2(0, 0);
		float f = 1;
		assertEquals(0, Float.compare(f, GeometryUtils.fromBarycoord(v1, 1, 1, 1)));
	}

	/**
	 * Purpose: Check if the computed barycentric coordinates are correct
	 * Input: 5 Vector2
	 * Expected: Vector2 (-3, -1) 
	 */
	@Test
	public void toBarycoordTest() {
		Vector2 v1 = new Vector2(1, 3);
		Vector2 v2 = new Vector2(6, 10);
		Vector2 v3 = new Vector2(15, 21);
		Vector2 v4 = new Vector2(28, 36);
		Vector2 v5 = new Vector2(0, 0);
		assertEquals(new Vector2(-3.0f, 1.0f), GeometryUtils.toBarycoord(v1, v2, v3, v4, v5));
	}
	
	/**
	 * Purpose: Check where count of verticesClockwise > 2
	 * Input: Float Array (1, 1, 1, 1, 1, 1)
	 * Expected: Done
	 */
	@Test
	public void ensureCCWTestCountG2() {
		float f[] = {1, 1, 1, 1, 1 ,1};
		GeometryUtils.ensureCCW(f);
	}

	/**
	 * Purpose: Check where count of verticesClockwise <= 2
	 * Input: Float Array (1, 1)
	 * Expected: Done
	 */
	@Test
	public void ensureCCWTestCountLE2() {
		float f[] = {1, 1};
		GeometryUtils.ensureCCW(f);
	}

	/**
	 * Purpose: Check where area + p1x * p2y - p2x * p1y < 0;
	 * Input: Float (-6, 1, 1, 6, 1 ,1)
	 * Expected: Done
	 */
	@Test
	public void ensureCCWTest3() {
		float f[] = {-6, 1, 1, 6, 1 ,1};
		GeometryUtils.ensureCCW(f);
	}

}