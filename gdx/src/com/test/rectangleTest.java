package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class rectangleTest {

	Rectangle rec1;
	Rectangle rec2;
	
	float x,y;
	float wid,h;
	
	Vector2 vec2;
	
	@Before
	public void setUp () throws Exception {
		x=3f;	y=3f; wid=4f; 	h=3f;
		rec1=new Rectangle(x,y,wid,h);
		rec2=new Rectangle(0,0,0,0);
		vec2=new Vector2(x,y);
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
	public void testContainsforTwoParam(){
		float tmpX=4.5f;
		float tmpY=5.5f;
		assertTrue(rec1.contains(tmpX, tmpY));
	}
	
	@Test
	public void testContainsforVector2(){
		float tmpX=4.5f;
		float tmpY=5.5f;
		vec2.set(tmpX, tmpY);
		assertTrue(rec1.contains(vec2));
	}
	
	@Test
	public void testContainsforCircleTrue(){
		float tmpX=4f;
		float tmpY=5f;
		float rad=0.5f;
		Circle cir1=new Circle(tmpX, tmpY, rad);
		
		assertTrue(rec1.contains(cir1));
	}
	
	@Test
	public void testContainsforCircleFalse(){
		float tmpX=4f;
		float tmpY=5f;
		float rad=2f;
		Circle cir1=new Circle(tmpX, tmpY, rad);
		
		assertFalse(rec1.contains(cir1));
	}
	
	@Test
	public void testContainsforRectangleFalse(){
		rec2.x=6f; rec2.y=5f; rec2.width=3f; rec2.height=2f;
		assertFalse(rec1.contains(rec2));
	}
	
	
	@Test
	public void testContainsforRectangleTrue(){
		rec2.x=4f; rec2.y=4f; rec2.width=1.2f; rec2.height=0.8f;
		assertTrue(rec1.contains(rec2));
	}	
	

	@Test
	public void testSetForFourParam(){
		rec1.set(x, y, wid, h);
		assertEquals(x, rec1.getX(), 0.001f);
		assertEquals(y, rec1.getY(), 0.001f);
		assertEquals(wid, rec1.getWidth(), 0.001f);
		assertEquals(h, rec1.getHeight(), 0.001f);
	}
	
	@Test
	public void testSetX(){
		rec1.setX(5f);
		assertEquals(5f, rec1.getX(), 0.001f);
	}
	
	@Test
	public void testSetY(){
		rec1.setY(5f);
		assertEquals(5f, rec1.getY(), 0.001f);
	}
	
	
	@Test
	public void testSetWidth(){
		rec1.setWidth(5f);
		assertEquals(5f, rec1.getWidth(), 0.001f);
	}
	
	@Test
	public void testSetHeight(){
		rec1.setHeight(5f);
		assertEquals(5f, rec1.getHeight(), 0.001f);
	}
	
	@Test
	public void testSsetPositionforVector2(){
		rec2.setPosition(vec2);
		rec1=new Rectangle(x,y,0,0);
		
		assertEquals(rec1, rec2);
	}
	
	@Test
	public void testSetPositionforTwoParam(){
		rec2.setPosition(x,y);
		rec1=new Rectangle(x,y,0,0);
		
		assertEquals(rec1, rec2);
	}
	
	
	@Test
	public void testsetSizeforTwoParam(){
		rec2.setSize(wid,h);
		rec1=new Rectangle(0,0,wid,h);
		
		assertEquals(rec1, rec2);
	}
	@Test
	public void testsetSizeforOneParam(){
		rec2.setSize(wid);
		rec1=new Rectangle(0,0,wid,wid);
		
		assertEquals(rec1, rec2);
	}
	@Test
	public void testGetSize(){
		vec2=rec1.getSize(vec2);
		Vector2 vec_2=new Vector2(wid,h);
		assertEquals(vec_2, vec2);
	}
	
	
	@Test
	public void testOverlap(){
		rec2.x=4f; rec2.y=4f; rec2.width=1.4f; rec2.height=2f;
		assertTrue(rec1.overlaps(rec2));
	}	
	

	@Test
	public void testMergeForRectangle(){
		rec2.x=5f; rec2.y=1f; rec2.width=3f; rec2.height=2f;
		rec1.merge(rec2);
		Rectangle rec3=new Rectangle(3f,1f,5f,5f);
		
		assertEquals(rec3, rec1);
	}
	

	@Test
	public void testMergeForTwoParam(){
		rec1.merge(2f, 3f);
		rec2.set(2, 3, 5, 3);
		assertEquals(rec2, rec1);
	}
	
	@Test
	public void testMergeForVector2(){
		vec2.set(2f,3f);
		rec2.set(2, 3, 5, 3);
		assertEquals(rec2, rec1.merge(vec2));
	}
	

	@Test
	public void testMergeForListOfVector2(){
		Vector2[] vec2s=new Vector2[3];
		vec2s[0]=new Vector2(2f,3f);
		vec2s[1]=new Vector2(10f,1f);
		vec2s[2]=new Vector2(-2f,7f);
		
		
		rec2.set(-2, 1, 12, 6);
		assertEquals(rec2, rec1.merge(vec2s));
	}
	
	@Test
	public void testGetAspectRatio(){
		assertEquals(4f/3f, rec1.getAspectRatio(),0.001f);
	}
	
	@Test
	public void testGetAspectRatioInfinity(){
		rec1.height=0;
		assertEquals(Float.NaN, rec1.getAspectRatio(),0.001f);
	}
	
	

	@Test
	public void testGetCenter(){
		vec2.set(5f,4.5f);
		Vector2 vec2_2=new Vector2();
		rec1.getCenter(vec2_2);
		assertEquals(vec2,vec2_2);
	}
	
	@Test
	public void testSetCenterForVector2(){
		vec2.set(6f,4.5f);
		rec1.setCenter(vec2);
		rec2.set(4f,3f,4f,3f);
		assertEquals(rec2, rec1);
		
	}
	@Test
	public void testSetCenterForTwoParam(){
		rec1.setCenter(6f,4.5f);
		rec2.set(4f,3f,4f,3f);
		assertEquals(rec2, rec1);
		
	}
	@Test
	public void testFitOutside(){
		rec2.set(2f,2f,2f,2f);
		rec1.fitOutside(rec2);
		Rectangle rec3=new Rectangle(5/3f,2f,8/3f,2f);
		assertEquals(rec3, rec1);
		
		rec2.set(3f,3f,2f,1f);
		rec1.set(x,y,wid,h);
		rec1.fitOutside(rec2);
		rec3.set(3f,11/4f,2f,3/2f);
		assertEquals(rec3, rec1);
		
	}
	
	@Test
	public void testFitInside(){
		rec2.set(2f,2f,2f,2f);
		rec1.fitInside(rec2);
		Rectangle rec3=new Rectangle(2f,9/4f,2f,3/2f);
		assertEquals(rec3, rec1);
		
		rec2.set(3f,3f,2f,1f);
		rec1.set(x,y,wid,h);
		rec1.fitInside(rec2);
		rec3.set(10/3f,3f,4/3f,1f);
		assertEquals(rec3, rec1);
	}
	
	
	@Test
	public void testToString(){
		String str="[" + x + "," + y + "," + wid + "," + h+ "]";
		assertEquals(str, rec1.toString());
		
		
	}
	
	
	
	//x=3f;	y=3f; wid=4f; 	h=3f;

	@Test
	public void testFromString(){
		String str="[3.0,3.0,4.0,3.0]";
		rec2.fromString(str);
		
		assertEquals(rec1, rec2);
	}
	

	@Test
	public void testArea(){
		float s=wid*h;
		assertEquals(s, rec1.area(),0.001f);
	}
	
		
	@Test
	public void testPerimeter(){
		float s=(wid+h)*2;
		assertEquals(s, rec1.perimeter(),0.001f);
	}
	
}


