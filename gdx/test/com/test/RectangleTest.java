package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class RectangleTest {

	Rectangle rec1;
	Rectangle rec2;
	
	float x,y;
	float wid,h;
	
	
	@Before
	public void setUp () throws Exception {
		x=3f;
		y=3f;
		wid=4f;
		h=3f;
		rec1=new Rectangle(x,y,wid,h);
	}

	@After
	public void tearDown () throws Exception {
	}

	@Test
	public void testConstructor () {
		rec2=new Rectangle(rec1);
		
		assertEquals(rec1,rec2);
	}

	@Test
	public void testGet(){
		
		assertEquals(x, rec1.getX(),0.00001f);
		assertEquals(y, rec1.getY(),0.00001f);
		assertEquals(wid, rec1.getWidth(),0.00001f);
		assertEquals(h, rec1.getHeight(),0.00001f);
		Vector2 vec2=new Vector2(x,y);
		assertEquals(vec2, rec1.getPosition(vec2));
	}
	
	@Test
	public void testContains(){
		float tmpX=4.5f;
		float tmpY=5.5f;
		assertTrue(rec1.contains(x, y));
	}
}


