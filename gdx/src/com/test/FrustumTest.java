/**
 * @author Kim SeungJu
 */

package testOracle;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import com.badlogic.gdx.math.Frustum;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Plane;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;

public class FrustumTest {
	
	/**
	 * Purpose: Check if the point is in the frustum (valid case)
	 * Input: point (1, 1, 1)
	 * Expected: true
	 */
	@Test
	public void pointInFrustumTest () {
		Frustum frustum = new Frustum();
		assertEquals(true, frustum.pointInFrustum(1, 1, 1));
	}

	/**
	 * Purpose: Check if the vector is in the frustum (valid case)
	 * Input: Vector3 (0, 0, 0)
	 * Expected: true
	 */
	@Test
	public void pointInFrustumTest2() {
		Frustum frustum = new Frustum();
		Vector3 v = new Vector3(0, 0, 0);
		assertEquals(true, frustum.pointInFrustum(v));
	}
	
	/**
	 * Purpose:  Check the codes in case of updating with matrix4 (valid case)
	 * Input: Matrix4 (0, 0, 0, 0)
	 * Expected: 
	 */
	@Test
	public void updateTest () {
		Frustum frustum = new Frustum();
		Matrix4 matrix4 = new Matrix4();
		frustum.update(matrix4);
		System.out.println(frustum.planes[0].d);
		assertEquals(0, Float.compare(1.0f, frustum.planes[0].d));
	}
	
	/**
	 * Purpose:  Check if the sphere is consist of vector is in the frustum (valid case)
	 * Input: Vector3 (0, 0, 0)
	 * Expected: true
	 */
	@Test
	public void sphereInFrustumTestWithVector() {
		Frustum frustum = new Frustum();
		Vector3 v = new Vector3(0, 0, 0);
		assertEquals(true, frustum.sphereInFrustum(v, 1));
	}
	
	/**
	 * Purpose:  Check if the sphere which is consist of floats is in the frustum (valid case)
	 * Input: Float (1, 1, 1, 1)
	 * Expected: true
	 */
	@Test
	public void sphereInFrustumTestWithFloat() {
		Frustum frustum = new Frustum();
		assertEquals(true, frustum.sphereInFrustum(1, 1, 1, 1));
	}
	
	/**
	 * Purpose:  Check if the sphere(vector) is in the frustum not checking whether it is behind the near and far clipping plane (valid case)
	 * Input: Vector3 (0, 0, 0)
	 * Expected: true
	 */
	@Test
	public void sphereInFrustumWithoutNearFarTestWithVector() {
		Frustum frustum = new Frustum();
		Vector3 v = new Vector3(0, 0, 0);
		assertEquals(true, frustum.sphereInFrustumWithoutNearFar(v, 1));
	}

	/**
	 * Purpose:  Check if the sphere(float) is in the frustum not checking whether it is behind the near and far clipping plane (valid case)
	 * Input: Float (0, 0, 0, 1)
	 * Expected: true 
	 */
	@Test
	public void sphereInFrustumWithoutNearFarTestWithFloat() {
		Frustum frustum = new Frustum();
		assertEquals(true, frustum.sphereInFrustumWithoutNearFar(0, 0, 0, 1));
	}
	
	/**
	 * Purpose: Check if the bounds(bounding box) are in the frustum. (valid case)
	 * Input: Bounding Box (0, 0, 0)
	 * Expected: true
	 */
	@Test
	public void boundsInFrustumTestWithBoundingBox() {
		Frustum frustum = new Frustum();
		BoundingBox bounds = new BoundingBox();
		assertEquals(true, frustum.	boundsInFrustum(bounds));
	}
	
	/**
	 * Purpose: Check if the bounds(vector) is in the frustum. (valid case)
	 * Input: Vector3 (0, 0, 0) (1, 1, 1)
	 * Expected: true 
	 */
	@Test
	public void boundsInFrustumTestWithVector() {
		Frustum frustum = new Frustum();
		Vector3 v1 = new Vector3(0, 0, 0);
		Vector3 v2 = new Vector3(1, 1, 1);
		assertEquals(true, frustum.boundsInFrustum(v1, v2));
	}

	/**
	 * Purpose: Check if the bounds(vector) is in the frustum. (valid case)
	 * Input: Float (0, 0, 0, 1, 1, 1)
	 * Expected: true 
	 */
	@Test
	public void boundsInFrustumTestWithFloat() {
		Frustum frustum = new Frustum();
		assertEquals(true, frustum.	boundsInFrustum(0, 0, 0, 1, 1, 1));
	}
}
