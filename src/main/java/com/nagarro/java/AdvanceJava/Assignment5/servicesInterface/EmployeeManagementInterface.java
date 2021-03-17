package com.nagarro.java.AdvanceJava.Assignment5.servicesInterface;

import java.util.List;

import com.nagarro.java.AdvanceJava.Assignment5.model.Employee;

public interface EmployeeManagementInterface {

	public List<Employee> getEmployees();

	public Employee getEmployee(int empId);

	public void addEmployee(Employee employee);

	public void updateEmployee(Employee emp);

	public void deleteEmployee(int empId);
}
