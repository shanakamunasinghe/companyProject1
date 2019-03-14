package com.project.spring.app.model;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


//import org.json.JSONArray;
//import org.json.JSONObject;



@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	
	@Column(name = "employeeName")
	private String employeeName;
	@NotNull

	@Column(name = "employeeEmail")
	private String employeeEmail;
	@NotNull
	@Column(name = "dOfBirth")
	private String dOfBirth;
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "employee_skills",
            joinColumns = {@JoinColumn(name = "employee_id")},
            inverseJoinColumns = {@JoinColumn(name = "skill_id")})
	private Set<Skill> skills;
	

	public Set<Skill> getSkills() {
		return skills;
	}

	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}

	public Employee() {
		
	}
	
	public Employee(String employeeName, String employeeEmail, String dOfBirth) {
		super();
		this.employeeName = employeeName;
		this.employeeEmail = employeeEmail;
		this.dOfBirth = dOfBirth;
	}
	
	public Employee(int id,String employeeName, String employeeEmail, String dOfBirth) {
		super();
		this.id = id;
		this.employeeName = employeeName;
		this.employeeEmail = employeeEmail;
		this.dOfBirth = dOfBirth;
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

	public int getId() {
		return id;
	}
	
//	@Override
//	 public String toString() {
//	 return String.format("Employee[id=%d, employeeName='%s', employeeEmail='%s',dOfBirth='%s']", id, employeeName, employeeEmail,dOfBirth);
//	 }
//	@Override
//	public String toString() {
//		String info = "";
//		JSONObject jsonInfo = new JSONObject();
//		jsonInfo.put("employeeName",this.employeeName);
//		jsonInfo.put("employeeEmail",this.employeeEmail);
//		jsonInfo.put("dOfBirth",this.dOfBirth);
//		
//		JSONArray skillArray = new JSONArray();
//		 if(this.skills != null && skills.size() > 0){
//			 this.skills.forEach(skill->{
//			 JSONObject subJson = new JSONObject();
//			 subJson.put("skillName", skill.getSkillName());
//			 subJson.put("description", skill.getDescription());
//			 skillArray.put(subJson);
//			 });
//		 }
//		 jsonInfo.put("skills", skillArray);
//		 info = jsonInfo.toString();
//		return info;
//	}
	
}

