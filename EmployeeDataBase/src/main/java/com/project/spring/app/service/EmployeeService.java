package com.project.spring.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.spring.app.Mapper.MappingManager;
import com.project.spring.app.Repo.EmployeeRepository;
import com.project.spring.app.model.Employee;
import com.project.spring.app.viewModel.EmployeeModel;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	private MappingManager mapper;
	

	public List<EmployeeModel> getAllEmployee(){
		return employeeRepository.findAll()
                .stream()
                .map(employee -> this.mapper.convertToEmployeeViewModel(employee))
                .collect(Collectors.toList());
	}
	
	public EmployeeModel getEmployee(int employeeId) {
		Employee employee = employeeRepository.findById(employeeId);
		return this.mapper.convertToEmployeeViewModel(employee);
	}

	public void addEmployee(EmployeeModel employee) {
		Employee empResult = this.mapper.convertToEmployee(employee);
		employeeRepository.save(empResult);
		
	}
	
	public void updateEmployee(int employeeId, EmployeeModel employee) {
		Employee empResult = this.mapper.convertToEmployee(employee);
		employeeRepository.save(empResult);
	}

	public void deleteEmployee(int employeeId) {
		employeeRepository.deleteById(employeeId);
	}
}