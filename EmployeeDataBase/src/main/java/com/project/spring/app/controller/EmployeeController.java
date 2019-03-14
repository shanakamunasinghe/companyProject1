package com.project.spring.app.controller;


import java.util.ArrayList;
import java.util.List;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.spring.app.service.EmployeeService;
import com.project.spring.app.viewModel.EmployeeModel;




@RestController
@CrossOrigin
public class EmployeeController {
	
	@Autowired 
	private EmployeeService employeeService;
	private List<EmployeeModel> data = new ArrayList<>(); 
	private EmployeeModel value = new EmployeeModel();
	
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	@RequestMapping("/employees")
	public List<EmployeeModel> getAllEmployees() {
		data = employeeService.getAllEmployee();
		if(data == null) {
			throw new ValidationException("The dataBase has a problem");
		}
		return data;
	}
	
	@RequestMapping("/employees/{foo}")
	public EmployeeModel getEmployee(@PathVariable("foo") int employeeId) {
		value = employeeService.getEmployee(employeeId);
		if(value == null) {
			throw new ValidationException("The dataBase has a problem");
		}
		return value;
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "/employees")
	public void addEmployee(@RequestBody EmployeeModel employee, BindingResult bindingResults) {
		if(bindingResults.hasErrors()) {
			throw new ValidationException("Puting Skills has error");
		}
		employeeService.addEmployee(employee);

	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/employees/{employeeId}")
	public void updateEmployee(@RequestBody EmployeeModel employee,@PathVariable int employeeId, BindingResult bindingResults) {
		if(bindingResults.hasErrors()) {
			throw new ValidationException("Puting Skills has error");
		}
		
		employeeService.updateEmployee(employeeId,employee);
	}
	@RequestMapping(method = RequestMethod.DELETE, value = "/employees/{employeeId}")
	public void deleteEmployee(@PathVariable int employeeId) {
		employeeService.deleteEmployee(employeeId);
	}
}