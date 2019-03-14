package com.project.spring.app.viewModel;

import java.util.ArrayList;
import java.util.List;

public class SkillModel {
	private int id;
	private String skillName;
	private String description;
	private List<EmployeeModel> employeeModel;
	
	public SkillModel() {
		this.employeeModel = new ArrayList<>();
	}
	
	public SkillModel(String skillName, String description) {
		this();
		this.skillName = skillName;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<EmployeeModel> getEmployeeModel() {
		return employeeModel;
	}

	public void setEmployeeModel(List<EmployeeModel> employeeModel) {
		this.employeeModel = employeeModel;
	}
}
