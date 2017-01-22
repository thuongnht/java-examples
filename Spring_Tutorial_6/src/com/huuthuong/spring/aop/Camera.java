package com.huuthuong.spring.aop;

import org.springframework.stereotype.Component;

@Component("camera")
public class Camera implements PhotoSnapper, CameraInterface {

	public Camera() {
		System.out.println("Camera Constructor");
	}
	
	/* (non-Javadoc)
	 * @see com.huuthuong.spring.aop.CameraInterface#snap()
	 */
	@Deprecated
	public void snap() throws Exception {
		System.out.println("SNAP");
		
//		throw new Exception("Error in Camera.snap ...");
	}
	
	/* (non-Javadoc)
	 * @see com.huuthuong.spring.aop.CameraInterface#snapISO(double)
	 */
	public void snapISO(int d) throws Exception {
		System.out.println("SNAP " + d);
	}
	
	/* (non-Javadoc)
	 * @see com.huuthuong.spring.aop.CameraInterface#snap()
	 */
	public void snapFX(double fx) throws Exception {
		System.out.println("SNAP " + fx);
	}
	
	/* (non-Javadoc)
	 * @see com.huuthuong.spring.aop.CameraInterface#snap()
	 */
	public void snapISOFX(int d, double fx) throws Exception {
		System.out.println("SNAP " + d + ", " + fx);		
	}
	
	/* (non-Javadoc)
	 * @see com.huuthuong.spring.aop.CameraInterface#snap()
	 */
	public void snapCar(Car car) {
		System.out.println("New Car ...");
	}
	
}
