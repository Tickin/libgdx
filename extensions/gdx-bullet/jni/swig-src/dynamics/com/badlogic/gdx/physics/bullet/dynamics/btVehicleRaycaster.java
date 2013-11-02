/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.badlogic.gdx.physics.bullet.dynamics;

import com.badlogic.gdx.physics.bullet.BulletBase;
import com.badlogic.gdx.physics.bullet.linearmath.*;
import com.badlogic.gdx.physics.bullet.collision.*;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;

public class btVehicleRaycaster extends BulletBase {
	private long swigCPtr;
	
	protected btVehicleRaycaster(final String className, long cPtr, boolean cMemoryOwn) {
		super(className, cPtr, cMemoryOwn);
		swigCPtr = cPtr;
	}
	
	/** Construct a new btVehicleRaycaster, normally you should not need this constructor it's intended for low-level usage. */ 
	public btVehicleRaycaster(long cPtr, boolean cMemoryOwn) {
		this("btVehicleRaycaster", cPtr, cMemoryOwn);
		construct();
	}
	
	@Override
	protected void reset(long cPtr, boolean cMemoryOwn) {
		if (!destroyed)
			destroy();
		super.reset(swigCPtr = cPtr, cMemoryOwn);
	}
	
	public static long getCPtr(btVehicleRaycaster obj) {
		return (obj == null) ? 0 : obj.swigCPtr;
	}

	@Override
	protected void finalize() throws Throwable {
		if (!destroyed)
			destroy();
		super.finalize();
	}

  @Override protected synchronized void delete() {
		if (swigCPtr != 0) {
			if (swigCMemOwn) {
				swigCMemOwn = false;
				DynamicsJNI.delete_btVehicleRaycaster(swigCPtr);
			}
			swigCPtr = 0;
		}
		super.delete();
	}

  public long castRay(Vector3 from, Vector3 to, SWIGTYPE_p_btVehicleRaycaster__btVehicleRaycasterResult result) {
    return DynamicsJNI.btVehicleRaycaster_castRay(swigCPtr, this, from, to, SWIGTYPE_p_btVehicleRaycaster__btVehicleRaycasterResult.getCPtr(result));
  }

}
