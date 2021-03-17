package com.nagarro.java.AdvanceJava.Assignment5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.java.AdvanceJava.Assignment5.entity.HrRecord;
import com.nagarro.java.AdvanceJava.Assignment5.model.Employee;
import com.nagarro.java.AdvanceJava.Assignment5.servicesInterface.EmployeeManagementInterface;
import com.nagarro.java.AdvanceJava.Assignment5.servicesInterface.HrServiceInterface;

@Controller
public class RegisterAndLoginController {

	@Autowired
	private HrServiceInterface hrService;

	@Autowired
	private EmployeeManagementInterface ems;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView viewRegistration(ModelAndView theModel) {
		HrRecord theHrRecord = new HrRecord();
		theModel.addObject("HrUsername", theHrRecord.getUsername());
		theModel.setViewName("index");
		return theModel;
	}

	@RequestMapping(value = "/processLogin", method = RequestMethod.POST)
	public ModelAndView processLogin(@ModelAttribute("HrRecord") HrRecord hrRecord) {
		ModelAndView mv = new ModelAndView();
		String HrRecordname = hrRecord.getUsername();
		String password = hrRecord.getPassword();
		if (!hrService.authenticateHr(HrRecordname, password)) {
			mv.setViewName("index");
			System.out.println("Incorrect Credentials");
			mv.addObject("authorized", "false");

		} else {
			mv.addObject("HrUsername", HrRecordname);
			mv.addObject("authorized", "true");
			mv.setViewName("home");
			Iterable<Employee> employees = ems.getEmployees();
			mv.addObject("employees", employees);
		}
		return mv;
	}

	@RequestMapping(value = "/processRegisteration", method = RequestMethod.POST)
	public ModelAndView processRegisteration(@ModelAttribute("HrRecord") HrRecord theHrRecord) {
		ModelAndView mv = new ModelAndView();
		String HrRecordname = theHrRecord.getUsername();
		String password = theHrRecord.getPassword();
		mv.addObject("HrRecordname", HrRecordname);
		hrService.saveHr(HrRecordname, password);
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping(value = "/processRegisteration", method = RequestMethod.GET)
	public ModelAndView processRequest() {
		ModelAndView mv = new ModelAndView();
		HrRecord theHrRecord = new HrRecord();
		mv.addObject("HrUsername", theHrRecord.getUsername());
		mv.setViewName("Registration");
		return mv;
	}

	@RequestMapping(value = "/SignOut")
	public ModelAndView signOut() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("HrUsername", null);
		mv.setViewName("index");
		return mv;
	}

}
