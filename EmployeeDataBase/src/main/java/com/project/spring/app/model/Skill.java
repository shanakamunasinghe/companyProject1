package com.project.spring.app.model;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

//import org.json.JSONArray;
//import org.json.JSONObject;

@Entity
@Table(name = "skill")
public class Skill {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	
	@Column(name = "skillName")
	private String skillName;
	@NotNull
	@Column(name = "description")
	private String description;

	@ManyToMany(mappedBy = "skills")
	private Set<Employee> employees;

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Skill() {
		
	}
	
	public Skill(String skillName, String description) {
		super();
		this.skillName = skillName;
		this.description = description;
		
	}
	
	public Skill(int id,String skillName, String description) {
		super();
		this.id = id;
		this.skillName = skillName;
		this.description = description;
		
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

	public int getId() {
		return id;
	}
//	@Override
//	 public String toString() {
//		String result = String.format("Skill[id=%d, skillName='%s', description='%s']", id, skillName, description);
//	 	return result;
//	 }
//	@Override
//	public String toString() {
//		String info = "";
//		JSONObject jsonInfo = new JSONObject();
//		jsonInfo.put("skillName",this.skillName);
//		jsonInfo.put("description",this.description);
//		 JSONArray empArray = new JSONArray();
//		 this.employees.forEach(emp->{
//		 JSONObject subJson = new JSONObject();
//		 subJson.put("employeeName", emp.getEmployeeName());
//		 subJson.put("employeeEmail", emp.getEmployeeEmail());
//		 subJson.put("dOfBirth", emp.getdOfBirth());
//		 empArray.put(subJson);
//		 });
//		 jsonInfo.put("employees", empArray);
//		 info = jsonInfo.toString();
//		return info;
//	}
}

