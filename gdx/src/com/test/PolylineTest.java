
package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.badlogic.gdx.math.Polyline;

public class PolylineTest {

	private Polyline polyline;
	private float[] vertices = {1, 2, 4, 6};

	@Before
	public void setUp () throws Exception {

	}

	@After
	public void tearDown () throws Exception {
	}

	@Test
	public void testGetVertices () {
		polyline = new Polyline(vertices);
		float[] actual = polyline.getVertices();
		assertEquals(vertices, actual);
	}

	@Test
	public void testSetLength () {
		polyline = new Polyline(vertices);
		float actual = polyline.getLength();
		assertEquals(5f, actual, 0.01);
		
		
		polyline = new Polyline();
		polyline.setVertices(vertices);
		actual = polyline.getLength();
		assertEquals(5f, actual, 0.01);
	}

	@Test
	public void testGetScaledLength () {
		polyline = new Polyline(vertices);
		float actual = polyline.getScaledLength();
		assertEquals(5f, actual, 0.01);
	}
	
	@Test
	public void testSetOrigin(){
		polyline = new Polyline();
		polyline.setOrigin(2f, 3f);
		assertEquals(2f, polyline.getOriginX(),0.001f);
		assertEquals(3f, polyline.getOriginY(),0.001f);
	}
	
	@Test
	public void testSetPosition(){
		polyline = new Polyline();
		polyline.setPosition(2f, 3f);
		assertEquals(2f, polyline.getPoint().getX(),0.001f);
		assertEquals(3f, polyline.getPoint().getY(),0.001f);
	}
	
	@Test
	public void testTranslate(){
		polyline = new Polyline();
		polyline.setPosition(2f, 3f);
		polyline.translate(1.5f, 2.3f);
		assertEquals(3.5f, polyline.getPoint().getX(),0.001f);
		assertEquals(5.3f, polyline.getPoint().getY(),0.001f);
	}
	
	
	@Test
	public void testSetRotation(){
		polyline = new Polyline();
		polyline.setRotation(90f);
		assertEquals(90f, polyline.getRotation(),0.001f);
	}
	
	
	@Test
	public void testRotation(){
		polyline = new Polyline();
		polyline.setRotation(90f);
		polyline.rotate(60f);
		assertEquals(150f, polyline.getRotation(),0.001f);
	}	
	
	@Test
	public void testSetScale(){
		polyline = new Polyline();
		polyline.setScale(2f, 3f);
		assertEquals(2f, polyline.getScaleX(),0.001f);
		assertEquals(3f, polyline.getScaleY(),0.001f);
	}	
	
	@Test
	public void testScale(){
		polyline = new Polyline();
		polyline.setScale(2f, 3f);
		polyline.scale(4f);
		assertEquals(6f, polyline.getScaleX(),0.001f);
		assertEquals(7f, polyline.getScaleY(),0.001f);
	}	
	
	//1,2,4,6
	@Test
	public void testGetTransformedVertices(){
		polyline = new Polyline(vertices);
		polyline.setPosition(2f, 3f);
		polyline.setOrigin(1f, 1f);
		polyline.setScale(2f,3f);
		polyline.setRotation(90f);
		//assertEquals(2f, polyline.getX(),0.001f);
		//assertEquals(3f, polyline.getY(),0.001f);
		
		//float[] actual=polyline.getTransformedVertices();
		float[] expected={0f,4f,-12f,10f};
	}
}
