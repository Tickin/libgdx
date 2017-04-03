/**
 * @author Kim SeungJu
 */

package com.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Interpolation.Bounce;
import com.badlogic.gdx.math.Interpolation.BounceIn;
import com.badlogic.gdx.math.Interpolation.BounceOut;
import com.badlogic.gdx.math.Interpolation.Elastic;
import com.badlogic.gdx.math.Interpolation.ElasticIn;
import com.badlogic.gdx.math.Interpolation.ElasticOut;
import com.badlogic.gdx.math.Interpolation.Exp;
import com.badlogic.gdx.math.Interpolation.ExpIn;
import com.badlogic.gdx.math.Interpolation.ExpOut;
import com.badlogic.gdx.math.Interpolation.Pow;
import com.badlogic.gdx.math.Interpolation.PowIn;
import com.badlogic.gdx.math.Interpolation.PowOut;
import com.badlogic.gdx.math.Interpolation.Swing;
import com.badlogic.gdx.math.Interpolation.SwingIn;
import com.badlogic.gdx.math.Interpolation.SwingOut;

public class InterpolationTest {
	
	/**
	 * Purpose: Check if apply function of linear works well
	 * Input: Float (1)
	 * Expected: Float (1)
	 */
	@Test
	public void linearApplyTest() {
		float a = 1;
		Interpolation.linear.apply(a);
		assertEquals(0, Float.compare(a, Interpolation.linear.apply(a)));
	}
	
	/**
	 * Purpose: Check if apply function of smooth works well
	 * Input: Float (1)
	 * Expected: Float (1)
	 */
	@Test
	public void smoothApplyTest() {
		float a = 1;
		Interpolation.smooth.apply(a);
		assertEquals(0, Float.compare(a, Interpolation.smooth.apply(a)));
	}

	/**
	 * Purpose: Check if apply function of smooth2 works well
	 * Input: Float (1)
	 * Expected: Float (1)
	 */
	@Test
	public void smooth2ApplyTest() {
		float a = 1;
		Interpolation.smooth2.apply(a);
		assertEquals(0, Float.compare(a, Interpolation.smooth2.apply(a)));
	}

	/**
	 * Purpose: Check if apply function of smoother works well
	 * Input: Float (1)
	 * Expected: Float (1)
	 */
	@Test
	public void smootherApplyTest() {
		float a = 1;
		Interpolation.smoother.apply(a);
		assertEquals(0, Float.compare(a, Interpolation.smoother.apply(a)));
	}

	/**
	 * Purpose: Check if apply function of pow2InInverse works well
	 * Input: Float (1)
	 * Expected: Float (1)
	 */
	@Test
	public void pow2InInverseApplyTest() {
		float a = 1;
		Interpolation.pow2InInverse.apply(a);
		assertEquals(0, Float.compare(a, Interpolation.pow2InInverse.apply(a)));
	}

	/**
	 * Purpose: Check if apply function of pow2OutInverse works well
	 * Input: Float (1)
	 * Expected: Float (1)
	 */
	@Test
	public void pow2OutInverseApplyTest() {
		float a = 1;
		Interpolation.pow2OutInverse.apply(a);
		assertEquals(0, Float.compare(a, Interpolation.pow2OutInverse.apply(a)));
	}

	/**
	 * Purpose: Check if apply function of pow3InInverse works well
	 * Input: Float (1)
	 * Expected: Float (1)
	 */
	@Test
	public void pow3InInverseApplyTest() {
		float a = 1;
		Interpolation.pow3InInverse.apply(a);
		assertEquals(0, Float.compare(a, Interpolation.pow3InInverse.apply(a)));
	}

	/**
	 * Purpose: Check if apply function of pow3OutInverse works well
	 * Input: Float (1)
	 * Expected: Float (1)
	 */
	@Test
	public void pow3OutInverseApplyTest() {
		float a = 1;
		Interpolation.pow3OutInverse.apply(a);
		assertEquals(0, Float.compare(a, Interpolation.pow3OutInverse.apply(a)));
	}
	
	/**
	 * Purpose: Check if apply function of Bounce works well
	 * Input: Float (1)
	 * Expected: Float (1)
	 */
	@Test
	public void bounceApplyTest() {
		float a = 1;
		Interpolation.bounce.apply(a);
		assertEquals(0, Float.compare(a, Interpolation.bounce.apply(a)));
	}
	
	/**
	 * Purpose: Check if the constructor of Bounce works well where a > 0.5
	 * Input: Float (1)
	 * Expected: Float (1)
	 */
	@Test
	public void bounceTestGreater() {
		float a = 2;
		float b[] = {1, 1, 1};
		float c[] = {1, 1, 1};
		Bounce bounce = new Bounce(b, c);
		assertEquals(0, Float.compare(1, bounce.apply(a)));
	}
	
	/**
	 * Purpose: Check if the constructor of Bounce works well where a <= 0.5
	 * Input: Float (1)
	 * Expected: Float (0.44444442)
	 */
	@Test
	public void bounceTestLess() {
		float a = 0.25f;
		float b[] = {9, 9, 9};
		float c[] = {9, 9, 9};
		Bounce bounce = new Bounce(b, c);
		assertEquals(0, Float.compare(0.44444442f, bounce.apply(a)));
	}
	
	/**
	 * Purpose: Check if the constructor of BounceIn works well
	 * Input: Float (1)
	 * Expected: Float (-3)
	 */
	@Test
	public void bounceInTest() {
		float a = 2;
		float b[] = {1, 1, 1};
		float c[] = {1, 1, 1};
		BounceIn bouncein = new BounceIn(b, c);
		assertEquals(0, Float.compare(-3, bouncein.apply(a)));
	}
	
	/**
	 * Purpose: Check if the constructor of BounceOut works well
	 * Input: Float (1)
	 * Expected: Float (0)
	 */
	@Test
	public void bounceOutTest() {
		float a = 2;
		float b[] = {1, 1, 1};
		float c[] = {1, 1, 1};
		BounceOut bounceout = new BounceOut(b, c);
		assertEquals(0, Float.compare(0, bounceout.apply(a)));
	}
	
	/**
	 * Purpose: Check if the constructor of BounceOut works well where bounces = 2
	 * Input: Float (1)
	 * Expected: Float (1)
	 */
	@Test
	public void bounceOutTestTwo() {
		float a = 3;
		BounceOut bounceout = new BounceOut(2);
		assertEquals(0, Float.compare(1, bounceout.apply(a)));
	}
	
	/**
	 * Purpose: Check if the constructor of BounceOut works well where bounces = 3
	 * Input: Float (1)
	 * Expected: Float (1)
	 */
	@Test
	public void bounceOutTestThree() {
		float a = 3;
		BounceOut bounceout = new BounceOut(3);
		assertEquals(0, Float.compare(1, bounceout.apply(a)));
	}
	
	/**
	 * Purpose: Check if the constructor of BounceOut works well where bounces = 4
	 * Input: Float (1)
	 * Expected: Float (1)
	 */
	@Test
	public void bounceOutTestFour() {
		float a = 3;
		BounceOut bounceout = new BounceOut(4);
		assertEquals(0, Float.compare(1, bounceout.apply(a)));
	}
	
	/**
	 * Purpose: Check if the constructor of BounceOut works well where bounces = 5
	 * Input: Float (1)
	 * Expected: Float (1)
	 */
	@Test
	public void bounceOutTestFive() {
		float a = 3;
		BounceOut bounceout = new BounceOut(5);
		assertEquals(0, Float.compare(1, bounceout.apply(a)));
	}
	
	/**
	 * Purpose: Check if the constructor of Pow works well where a > 0.5
	 * Input: Float (1)
	 * Expected: Float (1)
	 */
	@Test
	public void powApplyTestGreater() {
		float a = 1;
		Pow pow = new Pow(1);
		assertEquals(0, Float.compare(a, pow.apply(a)));
	}

	/**
	 * Purpose: Check if the constructor of Pow works well where a <= 0.5
	 * Input: Float (1)
	 * Expected: Float (1)
	 */
	@Test
	public void powApplyTestLess() {
		float a = 0.5f;
		Pow pow = new Pow(1);
		assertEquals(0, Float.compare(a, pow.apply(a)));
	}

	/**
	 * Purpose: Check if the constructor of Pow works well where power is even
	 * Input: Float (1)
	 * Expected: Float (1)
	 */
	@Test
	public void powApplyTestEven() {
		float a = 1;
		Pow pow = new Pow(2);
		assertEquals(0, Float.compare(a, pow.apply(a)));
	}

	/**
	 * Purpose: Check if the constructor of PowIn works well
	 * Input: Float (1)
	 * Expected: Float (1)
	 */
	@Test
	public void powInApplyTest() {
		float a = 1;
		PowIn powin = new PowIn(1);
		assertEquals(0, Float.compare(a, powin.apply(a)));
	}

	/**
	 * Purpose: Check if the constructor of PowOut works well where power is odd
	 * Input: Float (1)
	 * Expected: Float (1)
	 */
	@Test
	public void powOutApplyTestOdd() {
		float a = 1;
		PowOut powout = new PowOut(1);
		assertEquals(0, Float.compare(a, powout.apply(a)));
	}

	/**
	 * Purpose: Check if the constructor of PowOut works well where power is even
	 * Input: Float (1)
	 * Expected: Float (1)
	 */
	@Test
	public void powOutApplyTestEven() {
		float a = 1;
		PowOut powout = new PowOut(2);
		assertEquals(0, Float.compare(a, powout.apply(a)));
	}

	/**
	 * Purpose: Check if apply function of Swing works well where a > 0.5
	 * Input: Float (1)
	 * Expected: Float (1)
	 */
	@Test
	public void swingApplyTest() {
		float a = 1;
		Swing swing = new Swing(1);
		assertEquals(0, Float.compare(a, swing.apply(a)));
	}

	/**
	 * Purpose: Check if apply function of Swing works well where a <= 0.5
	 * Input: Float (1)
	 * Expected: Float (1)
	 */
	@Test
	public void swingApplyTest2() {
		float a = 0.5f;
		Swing swing = new Swing(1);
		assertEquals(0, Float.compare(a, swing.apply(a)));
	}

	/**
	 * Purpose: Check if apply function of SwingIn works well 
	 * Input: Float (1)
	 * Expected: Float (1)
	 */
	@Test
	public void swingInApplyTest() {
		float a = 1;
		SwingIn swingin = new SwingIn(1);
		assertEquals(0, Float.compare(a, swingin.apply(a)));
	}

	/**
	 * Purpose: Check if apply function of SwingOut works well 
	 * Input: Float (1)
	 * Expected: Float (1)
	 */
	@Test
	public void swingOutApplyTest() {
		float a = 1;
		SwingOut swingout = new SwingOut(1);
		assertEquals(0, Float.compare(a, swingout.apply(a)));
	}

	/**
	 * Purpose: Check if apply function of Exp works well where a > 0.5
	 * Input: Float (1)
	 * Expected: Float (1)
	 */
	@Test
	public void expApplyTestGreater() {
		float a = 1;
		Exp exp = new Exp(5, 11);
		assertEquals(0, Float.compare(a, exp.apply(a)));
	}

	/**
	 * Purpose: Check if apply function of Exp works well where a <= 0.5
	 * Input: Float (1)
	 * Expected: Float (1)
	 */
	@Test
	public void expApplyTestLess() {
		float a = 0.5f;
		Exp exp = new Exp(5, 11);
		assertEquals(0, Float.compare(a, exp.apply(a)));
	}

	/**
	 * Purpose: Check if apply function of ExpIn works well
	 * Input: Float (1)
	 * Expected: Float (1)
	 */
	@Test
	public void expInApplyTest() {
		float a = 1;
		ExpIn expin = new ExpIn(5, 11);
		assertEquals(0, Float.compare(1, expin.apply(a)));
	}

	/**
	 * Purpose: Check if apply function of ExpOut works well
	 * Input: Float (1)
	 * Expected: Float (1)
	 */
	@Test
	public void expOutApplyTest() {
		float a = 1;
		ExpOut expout = new ExpOut(5, 11);
		assertEquals(0, Float.compare(1, expout.apply(a)));
	}

	/**
	 * Purpose: Check if apply function of Sine works well
	 * Input: Float (1)
	 * Expected: Float (1)
	 */
	@Test
	public void sineApplyTest() {
		float a = 1;
		Interpolation.sine.apply(a);
		assertEquals(0, Float.compare(a, Interpolation.sine.apply(a)));
	}

	/**
	 * Purpose: Check if apply function of SineIn works well
	 * Input: Float (1)
	 * Expected: Float (1)
	 */
	@Test
	public void sineInApplyTest() {
		float a = 1;
		Interpolation.sineIn.apply(a);
		assertEquals(0, Float.compare(1.0000001f, Interpolation.sineIn.apply(a)));
	}

	/**
	 * Purpose: Check if apply function of SineOut works well
	 * Input: Float (1)
	 * Expected: Float (1)
	 */
	@Test
	public void sineOutApplyTest() {
		float a = 1;
		Interpolation.sineOut.apply(a);
		assertEquals(0, Float.compare(a, Interpolation.sineOut.apply(a)));
	}

	/**
	 * Purpose: Check if apply function of Circle works well where a > 0.5
	 * Input: Float (1)
	 * Expected: Float (1)
	 */
	@Test
	public void circleApplyTest() {
		float a = 1;
		Interpolation.circle.apply(a);
		assertEquals(0, Float.compare(a, Interpolation.circle.apply(a)));
	}

	/**
	 * Purpose: Check if apply function of Circle works well where a <= 0.5
	 * Input: Float (1)
	 * Expected: Float (0.5)
	 */
	@Test
	public void circleApplyTest2() {
		float a = 0.5f;
		Interpolation.circle.apply(a);
		assertEquals(0, Float.compare(a, Interpolation.circle.apply(a)));
	}

	/**
	 * Purpose: Check if apply function of CircleIn works well
	 * Input: Float (1)
	 * Expected: Float (1)
	 */
	@Test
	public void circleInApplyTest() {
		float a = 1;
		Interpolation.circleIn.apply(a);
		assertEquals(0, Float.compare(a, Interpolation.circleIn.apply(a)));
	}

	/**
	 * Purpose: Check if apply function of CircleOut works well
	 * Input: Float (1)
	 * Expected: Float (1)
	 */
	@Test
	public void circleOutApplyTest() {
		float a = 1;
		Interpolation.circleOut.apply(a);
		assertEquals(0, Float.compare(a, Interpolation.circleOut.apply(a)));
	}

	/**
	 * Purpose: Check if apply function of Elastic works well where a > 0.5
	 * Input: Float (1)
	 * Expected: Float (1)
	 */
	@Test
	public void elasticApplyTestGreater() {
		float a = 1;
		Elastic elastic = new Elastic(5, 7, 11, 19);
		assertEquals(0, Float.compare(1, elastic.apply(a)));
	}

	/**
	 * Purpose: Check if apply function of Elastic works well where a <= 0.5
	 * Input: Float (1)
	 * Expected: Float (0)
	 */
	@Test
	public void elasticApplyTestLess() {
		float a = 0.5f;
		Elastic elastic = new Elastic(4, 3, 2, 1);
		assertEquals(0, Float.compare(0, elastic.apply(a)));
	}

	/**
	 * Purpose: Check if apply function of ElasticIn works well where a > 0.5
	 * Input: Float (1)
	 * Expected: Float (1)
	 */
	@Test
	public void elasticInApplyTestGreater() {
		float a = 1;
		ElasticIn elasticin = new ElasticIn(5, 7, 11, 19);
		assertEquals(0, Float.compare(1, elasticin.apply(a)));
	}

	/**
	 * Purpose: Check if apply function of ElasticIn works well where a <= 0.5
	 * Input: Float (1)
	 * Expected: Float (0.06797647)
	 */
	@Test
	public void elasticInApplyTestLess() {
		float a = 0.5f;
		ElasticIn elasticin = new ElasticIn(5, 7, 11, 19);
		assertEquals(0, Float.compare(0.06797647f, elasticin.apply(a)));
	}

	/**
	 * Purpose: Check if apply function of ElasticOut works well where a != 0
	 * Input: Float (1)
	 * Expected: Float (1)
	 */
	@Test
	public void elasticOutApplyTestGreater() {
		float a = 1;
		ElasticOut elasticout = new ElasticOut(5, 7, 11, 19);
		assertEquals(0, Float.compare(1, elasticout.apply(a)));
	}

	/**
	 * Purpose: Check if apply function of ElasticOut works well where a = 0
	 * Input: Float (0)
	 * Expected: Float (0)
	 */
	@Test
	public void elasticOutApplyTest2() {
		float a = 0;
		ElasticOut elasticout = new ElasticOut(5, 7, 11, 19);
		assertEquals(0, Float.compare(0, elasticout.apply(a)));
	}
}
