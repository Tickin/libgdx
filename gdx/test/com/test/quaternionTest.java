
package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;

public class quaternionTest {

	Quaternion quaternion;
	Quaternion quaternion2;

	float x, y, z, w;
	Vector3 vec3;

	@Before
	public void setUp () throws Exception {
		x = 1f;
		y = 1f;
		z = 1f;
		w = 4f;
		vec3 = new Vector3(x, y, z);
		quaternion = new Quaternion(x, y, z, w);
		quaternion2 = new Quaternion();
	}

	@After
	public void tearDown () throws Exception {
	}

	@Test
	public void testCpy () {
		quaternion2 = quaternion.cpy();

		assertEquals(quaternion2, quaternion);
	}

	@Test
	public void testToString () {
		String expected = "[" + x + "|" + y + "|" + z + "|" + w + "]";
		String actual = quaternion.toString();

		assertEquals(expected, actual);

	}

	@Test
	public void testLen () {
		float actual = quaternion.len();
		float expected = (float)Math.sqrt(x * x + y * y + z * z + w * w);
		assertEquals(expected, actual, 0.0001f);
	}

	@Test
	public void testSetEulerAnglesRad () {
		quaternion = new Quaternion();
		float a = (float)Math.PI / 3;
		float b = (float)Math.PI / 3;
		float c = (float)Math.PI / 3;
		quaternion.setEulerAnglesRad(a, b, c);
		float hr = c * 0.5f;
		float shr = (float)Math.sin(hr);
		float chr = (float)Math.cos(hr);
		float hp = b * 0.5f;
		float shp = (float)Math.sin(hp);
		float chp = (float)Math.cos(hp);
		float hy = a * 0.5f;
		float shy = (float)Math.sin(hy);
		float chy = (float)Math.cos(hy);
		float chy_shp = chy * shp;
		float shy_chp = shy * chp;
		float chy_chp = chy * chp;
		float shy_shp = shy * shp;

		x = (chy_shp * chr) + (shy_chp * shr);
		y = (shy_chp * chr) - (chy_shp * shr);
		z = (chy_chp * shr) - (shy_shp * chr);
		w = (chy_chp * chr) + (shy_shp * shr);
		quaternion2 = new Quaternion(x, y, z, w);

		assertEquals(quaternion, quaternion2);
	}

	@Test
	public void testGetGimbalPole () {
		quaternion = new Quaternion(1, 1, -2, 2);
		assertEquals(-1, quaternion.getGimbalPole());
		quaternion = quaternion.set(1, 1, 2, 2);
		assertEquals(1, quaternion.getGimbalPole());
		quaternion = quaternion.set(1, 1, -0.5f, 2);
		assertEquals(0, quaternion.getGimbalPole());
	}

	@Test
	public void testGetRollRad () {
		x = 2;
		y = 2;
		z = -1.9f;
		w = 2;
		quaternion = quaternion.set(x, y, z, w);
		float expected = (float)Math.atan2(2f * (w * z + y * x), 1f - 2f * (x * x + z * z));
		assertEquals(expected, quaternion.getRollRad(), 0.0001f);
		z = -3f;
		quaternion = quaternion.set(x, y, z, w);
		expected = (float)quaternion.getGimbalPole() * 2f * (float)Math.atan2(y, w);
		assertEquals(expected, quaternion.getRollRad(), 0.01f);
	}

	@Test
	public void testGetRoll () {
		x = 2;
		y = 2;
		z = -1.9f;
		w = 2;
		quaternion = quaternion.set(x, y, z, w);
		float actual = quaternion.getRoll();
		float expected = (float)Math.atan2(2f * (w * z + y * x), 1f - 2f * (x * x + z * z)) / (float)Math.PI * 180f;
		assertEquals(expected, actual, 0.001f);
	}

	@Test
	public void testGetPitchRad () {
		x = 2;
		y = 2;
		z = -1.9f;
		w = 2;
		float value = 2f * (w * x - z * y);
		quaternion = quaternion.set(x, y, z, w);
		float expected = (float)Math.asin(MathUtils.clamp(2f * (w * x - z * y), -1f, 1f));
		assertEquals(expected, quaternion.getPitchRad(), 0.0001f);
		z = -3f;
		quaternion = quaternion.set(x, y, z, w);
		expected = -1 * (float)Math.PI * 0.5f;
		assertEquals(expected, quaternion.getPitchRad(), 0.01f);
	}

	@Test
	public void testGetPitch () {
		x = 2;
		y = 2;
		z = -1.9f;
		w = 2;
		float value = 2f * (w * x - z * y);
		quaternion = quaternion.set(x, y, z, w);
		float expected = (float)Math.asin(MathUtils.clamp(2f * (w * x - z * y), -1f, 1f)) / (float)Math.PI * 180f;
		assertEquals(expected, quaternion.getPitch(), 0.0001f);

	}

	@Test
	public void testGetYawRad () {
		x = 2;
		y = 2;
		z = -1.9f;
		w = 2;
		float value = 2f * (w * x - z * y);
		quaternion = quaternion.set(x, y, z, w);
		float expected = (float)Math.atan2(2f * (y * w + x * z), 1f - 2f * (y * y + x * x));
		assertEquals(expected, quaternion.getYawRad(), 0.0001f);

		z = -3f;
		quaternion = quaternion.set(x, y, z, w);
		assertEquals(0, quaternion.getYawRad(), 0.01f);

	}

	@Test
	public void testGetYaw () {
		x = 2;
		y = 2;
		z = -1.9f;
		w = 2;
		float value = 2f * (w * x - z * y);
		quaternion = quaternion.set(x, y, z, w);
		float expected = (float)Math.atan2(2f * (y * w + x * z), 1f - 2f * (y * y + x * x)) / (float)Math.PI * 180f;
		assertEquals(expected, quaternion.getYaw(), 0.0001f);
	}

	@Test
	public void testLen2 () {
		float length = x * x + y * y + z * z + w * w;
		assertEquals(length, quaternion.len2(), 0.0001f);
	}

	@Test
	public void testNor () {
		float length = (float)Math.sqrt(x * x + y * y + z * z + w * w);
		x /= length;
		y /= length;
		z /= length;
		w /= length;

		quaternion2.set(x, y, z, w);
		assertEquals(quaternion2, quaternion.nor());

	}

	@Test
	public void testNorLen2Zero () {
		x = 0;
		y = 0;
		z = 0;
		w = 0;
		quaternion.set(x, y, z, w);
		quaternion2.set(0, 0, 0, 0);
		assertEquals(quaternion2, quaternion.nor());
	}

	@Test
	public void testConjugate () {
		quaternion2.set(-x, -y, -z, w);

		assertEquals(quaternion2, quaternion.conjugate());
	}

	@Test
	public void testMulforQuaternion () {
		float mulX = 1.5f;
		float mulY = -2f;
		float mulZ = 2f;
		float mulW = 3f;
		Quaternion mul = new Quaternion(mulX, mulY, mulZ, mulW);
		float X = w * mulX + x * mulW + y * mulZ - z * mulY;
		float Y = w * mulY + y * mulW + z * mulX - x * mulZ;
		float Z = w * mulZ + z * mulW + x * mulY - y * mulX;
		float W = w * mulW - x * mulX - y * mulY - z * mulZ;
		assertEquals(quaternion2.set(X, Y, Z, W), quaternion.mul(mul));
	}

	@Test
	public void testMulforFourParam () {
		float mulX = 1.5f;
		float mulY = -2f;
		float mulZ = 2f;
		float mulW = 3f;
		float X = w * mulX + x * mulW + y * mulZ - z * mulY;
		float Y = w * mulY + y * mulW + z * mulX - x * mulZ;
		float Z = w * mulZ + z * mulW + x * mulY - y * mulX;
		float W = w * mulW - x * mulX - y * mulY - z * mulZ;
		assertEquals(quaternion2.set(X, Y, Z, W), quaternion.mul(mulX, mulY, mulZ, mulW));

	}

	@Test
	public void testMulLeftforQuaternion () {
		float mulX = 1.5f;
		float mulY = -2f;
		float mulZ = 2f;
		float mulW = 3f;
		Quaternion mul = new Quaternion(mulX, mulY, mulZ, mulW);
		float X = mulW * x + mulX * w + mulY * z - mulZ * y;
		float Y = mulW * y + mulY * w + mulZ * x - mulX * z;
		float Z = mulW * z + mulZ * w + mulX * y - mulY * x;
		float W = mulW * w - mulX * x - mulY * y - mulZ * z;

		assertEquals(quaternion2.set(X, Y, Z, W), quaternion.mulLeft(mul));
	}

	@Test
	public void testMulLeftforFourParam () {
		float mulX = 1.5f;
		float mulY = -2f;
		float mulZ = 2f;
		float mulW = 3f;
		float X = mulW * x + mulX * w + mulY * z - mulZ * y;
		float Y = mulW * y + mulY * w + mulZ * x - mulX * z;
		float Z = mulW * z + mulZ * w + mulX * y - mulY * x;
		float W = mulW * w - mulX * x - mulY * y - mulZ * z;

		assertEquals(quaternion2.set(X, Y, Z, W), quaternion.mulLeft(mulX, mulY, mulZ, mulW));
	}

	@Test
	public void testTransform () {
		float mulX = 3f;
		float mulY = 4f;
		float mulZ = 5f;

		Vector3 vec3 = new Vector3(mulX, mulY, mulZ);
		Vector3 expected = new Vector3(71, 60, 97);
		Quaternion qua3 = new Quaternion(x, y, z, w);

		quaternion2.set(x, y, z, w);
		quaternion2.conjugate();
		quaternion2.mulLeft(quaternion.set(mulX, mulY, mulZ, 0)).mulLeft(new Quaternion(x, y, z, w));

		assertEquals(expected, qua3.transform(vec3));
	}

	@Test
	public void testAddforQuaternion () {
		quaternion2.set(2 * x, 2 * y, 2 * z, 2 * w);
		assertEquals(quaternion2, quaternion.add(quaternion));
	}

	@Test
	public void testAddforFourParam () {
		quaternion2.set(2 * x, 2 * y, 2 * z, 2 * w);
		assertEquals(quaternion2, quaternion.add(x, y, z, w));
	}

	@Test
	public void testToMatrix () {
		float[] actuals = new float[16];
		float[] expecteds = new float[16];

		expecteds[0] = 1 - 2 * (y * y + z * z);
		expecteds[1] = 2 * (x * y + z * w);
		expecteds[2] = 2 * (x * z - y * w);
		expecteds[3] = 0;
		expecteds[4] = 2 * (x * y - z * w);
		expecteds[5] = 1 - 2 * (x * x + z * z);
		expecteds[6] = 2 * (y * z + x * w);
		expecteds[7] = 0;
		expecteds[8] = 2 * (x * z + y * w);
		expecteds[9] = 2 * (y * z - x * w);
		expecteds[10] = 1 - 2 * (x * x + y * y);
		expecteds[11] = 0;
		expecteds[12] = 0;
		expecteds[13] = 0;
		expecteds[14] = 0;
		expecteds[15] = 1;

		quaternion.toMatrix(actuals);
		assertArrayEquals(expecteds, actuals,0.001f);

	}
	
	@Test
	public void testIdt(){
		quaternion.set(0,0,0,1);
		quaternion2.idt();
		
		
		assertEquals(quaternion, quaternion2);
	}
	
	@Test
	public void testIsIdentity(){
		x=0; y=0; z=0; w=1f;
		quaternion.set(x,y,z,w);
		assertTrue(quaternion.isIdentity());
		quaternion.setX(1);		
		assertFalse(quaternion.isIdentity());
		quaternion.setX(0); quaternion.setY(1);
		assertFalse(quaternion.isIdentity());
		quaternion.setY(0); quaternion.setZ(1);
		assertFalse(quaternion.isIdentity());
		quaternion.setZ(0); quaternion.setW(2);
		assertFalse(quaternion.isIdentity());

	}
	
	@Test
	public void testSetFromAxisRadZero(){
		x=0; y=0; z=0;
		float rad= (float)Math.PI;
		quaternion.setFromAxisRad(x, y, z, rad);
		quaternion2.set(x,y,z,w);
		quaternion2.setW(1f);
		assertEquals(quaternion, quaternion2);
		
	}
	

}
