package com.huuthuong.spring.aop;

public interface CameraInterface {

	public abstract void snap() throws Exception;

	public abstract void snapISO(int d) throws Exception;

	public abstract void snapFX(double fx) throws Exception;

	public abstract void snapISOFX(int d, double fx) throws Exception;
	
	public void snapCar(Car car);

}