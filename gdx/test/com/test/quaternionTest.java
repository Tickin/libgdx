package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;

public class quaternionTest {

	
	Quaternion quaternion;
	Quaternion quaternion2;

	float x,y,z,w;
	Vector3 vec3;
	
	@Before
	public void setUp () throws Exception {
		x=1f; y=1f; z=1f; w=90f;
		vec3=new Vector3(x,y,z);
		quaternion=new Quaternion(x,y,z,w);
		quaternion2=new Quaternion();
	}

	@After
	public void tearDown () throws Exception {
	}


	@Test
	public void testCpy(){
		quaternion2=quaternion.cpy();
		
		assertEquals(quaternion2, quaternion);
	}
	@Test
	public void testToString(){
		String expected= "[" + x + "|" + y + "|" + z + "|" + w + "]";
		String actual = quaternion.toString();
		
		assertEquals(expected, actual);


	}
	@Test
	public void testLen(){
		float actual=quaternion.len();
		float expected = (float)Math.sqrt(x * x + y * y + z * z + w * w);
		assertEquals(expected, actual,0.0001f);
	}

	
	@Test
	public void testSetEulerAnglesRad(){
		x=1f;
		y=1f;
		z=1f;
		quaternion2.setEulerAnglesRad(x, y, z);
		
		
	}
}
