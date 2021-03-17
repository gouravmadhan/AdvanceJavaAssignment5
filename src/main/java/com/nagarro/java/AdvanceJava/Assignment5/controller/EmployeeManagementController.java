package com.nagarro.java.AdvanceJava.Assignment5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.java.AdvanceJava.Assignment5.model.Employee;
import com.nagarro.java.AdvanceJava.Assignment5.servicesInterface.EmployeeManagementInterface;

@Controller
public class EmployeeManagementController {

	@Autowired
	private EmployeeManagementInterface ems;

	@RequestMapping("EditEmployee")
	public ModelAndView EditEmployee(@RequestParam("empId") int empId, @RequestParam("HrUsername") String username) {
		ModelAndView mv = new ModelAndView();
		Employee emp = ems.getEmployee(empId);
		mv.addObject("employee", emp);
		mv.addObject("HrUsername", username);
		mv.setViewName("edit");
		return mv;
	}

	@RequestMapping("Upload")
	public ModelAndView uploadEmployee(@RequestParam("empName") String empName,
			@RequestParam("location") String location, @RequestParam("email") String email,
			@RequestParam("dateOfBirth") String dateOfBirth, @RequestParam("HrUsername") String username) {
		ModelAndView mv = new ModelAndView();
		Employee emp = new Employee();
		emp.setEmpName(empName);
		emp.setLocation(location);
		emp.setEmail(email);
		emp.setDateOfBirth(dateOfBirth);
		ems.addEmployee(emp);
		List<Employee> employees = ems.getEmployees();
		mv.addObject("employees", employees);
		mv.addObject("HrUsername", username);
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping("Update")
	public ModelAndView updateEmployee(@RequestParam("empId") int empId, @RequestParam("empName") String empName,
			@RequestParam("location") String location, @RequestParam("email") String email,
			@RequestParam("dateOfBirth") String dateOfBirth, @RequestParam("HrUsername") String username) {
		ModelAndView mv = new ModelAndView();
		Employee emp = new Employee();
		emp.setEmpId(empId);
		emp.setEmpName(empName);
		emp.setLocation(location);
		emp.setEmail(email);
		emp.setDateOfBirth(dateOfBirth);
		ems.updateEmployee(emp);
		List<Employee> employees = ems.getEmployees();
		mv.addObject("employees", employees);
		mv.addObject("HrUsername", username);
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping("DeleteEmployee")
	public ModelAndView deleteEmployee(@RequestParam("empId") int empId, @RequestParam("HrUsername") String username) {
		ModelAndView mv = new ModelAndView();
		ems.deleteEmployee(empId);
		List<Employee> employees = ems.getEmployees();
		mv.addObject("employees", employees);
		mv.addObject("HrUsername", username);
		mv.setViewName("home");
		return mv;
	}

}
