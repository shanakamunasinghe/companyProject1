package com.project.spring.app.viewModel;

import java.util.List;
import java.util.ArrayList;


public class EmployeeModel {
	private int id;
	private String employeeName;
	private String employeeEmail;
	private String dOfBirth;
	
	private List<SkillModel> skillModel;
	
	public EmployeeModel() {
		this.skillModel = new ArrayList<>();
	}
	
	public EmployeeModel(int id,String employeeName, String employeeEmail, String dOfBirth) {
		this();
		this.id = id;
		this.employeeName = employeeName;
		this.employeeEmail = employeeEmail;
		this.dOfBirth = dOfBirth;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getdOfBirth() {
		return dOfBirth;
	}

	public void setdOfBirth(String dOfBirth) {
		this.dOfBirth = dOfBirth;
	}

	public List<SkillModel> getSkillModel() {
		return skillModel;
	}

	public void setSkillModel(List<SkillModel> skillModel) {
		this.skillModel = skillModel;
	}

	
	
	
}
