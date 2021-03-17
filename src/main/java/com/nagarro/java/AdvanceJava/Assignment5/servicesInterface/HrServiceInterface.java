package com.nagarro.java.AdvanceJava.Assignment5.servicesInterface;

public interface HrServiceInterface {

	public boolean authenticateHr(String username, String password);

	public void saveHr(String username, String password);
}
