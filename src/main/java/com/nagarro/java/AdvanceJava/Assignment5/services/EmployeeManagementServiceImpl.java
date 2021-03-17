package com.nagarro.java.AdvanceJava.Assignment5.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.java.AdvanceJava.Assignment5.constant.ApiConstants;
import com.nagarro.java.AdvanceJava.Assignment5.model.Employee;
import com.nagarro.java.AdvanceJava.Assignment5.servicesInterface.EmployeeManagementInterface;

@Service
public class EmployeeManagementServiceImpl implements EmployeeManagementInterface {
	RestTemplate restTemplate;

	public List<Employee> getEmployees() {
		String url = ApiConstants.GET_ALL_EMPLOYEE;
		RestTemplate restTemplate = new RestTemplate();
		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		mappingJackson2HttpMessageConverter
				.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
		ResponseEntity<Employee[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Employee[].class);
		Employee[] employees = response.getBody();
		return Arrays.asList(employees);
	}

	public Employee getEmployee(int empId) {
		String url = ApiConstants.GET_SINGLE_EMPLOYEE + empId;
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(url, Employee.class);
	}

	public void addEmployee(Employee employee) {
		String url = ApiConstants.ADD_EMPLOYEE;
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Employee> request = new HttpEntity<Employee>(employee);
		restTemplate.postForObject(url, request, Employee.class);
	}

	public void updateEmployee(Employee emp) {
		String url = ApiConstants.UPDATE_EMPLOYEE;
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Employee> request = new HttpEntity<Employee>(emp);
		restTemplate.put(url, request);
	}

	public void deleteEmployee(int empId) {
		String url = ApiConstants.DELETE_EMPLOYEE + empId;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(url);
	}
}
