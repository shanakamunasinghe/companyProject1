package com.project.spring.app.employeeSkill;


import java.util.HashSet;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.project.spring.app.Repo.EmployeeRepository;
import com.project.spring.app.Repo.SkillRepository;
import com.project.spring.app.model.Employee;
import com.project.spring.app.model.Skill;




@Component
public class EmployeeSkillDatabaseSeeder implements CommandLineRunner{
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private SkillRepository skillRepository;
	
	@Autowired
	public EmployeeSkillDatabaseSeeder(EmployeeRepository employeeRepository,SkillRepository skillRepository){
		this.employeeRepository = employeeRepository;
		this.skillRepository = skillRepository;
	}
	@Transactional
	@Override
	public void run(String... args) throws Exception {
//		List<Employee> empbookings = new ArrayList<>();
//		empbookings.add(new Employee("Marriot","Marriot@gmail.com","1995"));
//		empbookings.add(new Employee("Ibis","Ibis@gmail.com","1995"));
//		empbookings.add(new Employee("Novotel","Novotel@gmail.com","1995"));
//		
//		employeeRepository.save(empbookings);
//		
//		List<Skill> skillbookings = new ArrayList<>();
//		skillbookings.add(new Skill("run","run description"));
//		skillbookings.add(new Skill("fly","fly description"));
//		skillbookings.add(new Skill("jump","jump description"));
//		
//		skillRepository.save(skillbookings);
		
		Employee Marriot = new Employee("Marriot","Marriot@gmail.com","1995");
		Employee Ibis = new Employee("Ibis","Ibis@gmail.com","1995");
		Employee Novotel = new Employee("Novotel","Novotel@gmail.com","1995");
		
		Skill run = new Skill("run","run description");
		Skill fly = new Skill("fly","fly description");
		Skill jump = new Skill("jump","jump description");
		
		Set<Skill> skills1 = new HashSet<Skill>();
		skills1.add(run);
		skills1.add(fly);
		skills1.add(jump);
		
		Set<Skill> skills2 = new HashSet<Skill>();
		skills2.add(run);
		skills2.add(jump);
		
		Set<Skill> skills3 = new HashSet<Skill>();
		skills3.add(run);
		
		Marriot.setSkills(skills1);
		Ibis.setSkills(skills2);
		Novotel.setSkills(skills3);
		
		employeeRepository.save(Marriot);
		employeeRepository.save(Ibis);
		employeeRepository.save(Novotel);
		
		Set<Employee> emp1 = new HashSet<Employee>();
		emp1.add(Marriot);
		emp1.add(Ibis);
		emp1.add(Novotel);
		
		Set<Employee> emp2 = new HashSet<Employee>();
		emp2.add(Marriot);
		emp2.add(Ibis);
		
		Set<Employee> emp3 = new HashSet<Employee>();
		emp2.add(Marriot);
		
		run.setEmployees(emp1);
		fly.setEmployees(emp3);
		jump.setEmployees(emp2);
		
		skillRepository.save(run);
		skillRepository.save(fly);
		skillRepository.save(jump);
	}
	
}