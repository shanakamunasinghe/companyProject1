package com.project.spring.app.Mapper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.project.spring.app.Repo.EmployeeRepository;
import com.project.spring.app.Repo.SkillRepository;
import com.project.spring.app.model.Employee;
import com.project.spring.app.model.Skill;
import com.project.spring.app.viewModel.EmployeeModel;
import com.project.spring.app.viewModel.SkillModel;

public class MappingManager {
	private EmployeeRepository employeeRepository;
    private SkillRepository skillRepository;
    
	public MappingManager(EmployeeRepository employeeRepository, SkillRepository skillRepository) {
		super();
		this.employeeRepository = employeeRepository;
		this.skillRepository = skillRepository;
	}
	public EmployeeModel convertToEmployeeViewModel(Employee employee){

        EmployeeModel viewModel = new EmployeeModel();

        viewModel.setId(employee.getId());
        viewModel.setEmployeeName(employee.getEmployeeName());
        viewModel.setdOfBirth(employee.getdOfBirth());
        viewModel.setEmployeeEmail(employee.getEmployeeEmail());

        List<SkillModel> skills = employee.getSkills().stream()
                .map(skill ->{
                    SkillModel viewModel1 = new SkillModel();
                    viewModel1.setId(skill.getId());
                    viewModel1.setDescription(skill.getDescription());
                    return viewModel1;
                })
                .collect(Collectors.toList());
        viewModel.setSkillModel(skills);

        return viewModel;
    }
	public SkillModel convertToSkillViewModel(Skill skill){
        SkillModel viewModel = new SkillModel(skill.getSkillName(),skill.getDescription());
        viewModel.setId(skill.getId());

        Set<Employee> employees = skill.getEmployees();

        List<EmployeeModel> employeeModels = employees.stream()
                .map(employee -> {
                    EmployeeModel viewModel2 = new EmployeeModel();
                    viewModel2.setId(employee.getId());
                    viewModel2.setEmployeeName(employee.getEmployeeName());
                    viewModel2.setdOfBirth(employee.getdOfBirth());
                    viewModel2.setEmployeeEmail(employee.getEmployeeEmail());
                    return viewModel2;
                })
                .collect(Collectors.toList());

        viewModel.setEmployeeModel(employeeModels);

        return viewModel;
    }
	public Employee convertToEmployee(EmployeeModel viewModel){

        Employee employee;

        if(viewModel.getId() != 0){
            employee = employeeRepository.findById(viewModel.getId());
        }else{
            employee = new Employee();
        }

        employee.setEmployeeName(viewModel.getEmployeeName());
        employee.setdOfBirth(viewModel.getdOfBirth());
        employee.setEmployeeEmail(viewModel.getEmployeeEmail());

        Set<Skill> skills = viewModel.getSkillModel().stream()
                .map(viewModel1 -> {
                    Skill skill = skillRepository.findByskillName(viewModel1.getSkillName());
                    skill.getEmployees().add(employee);
                    return skill;
                }).collect(Collectors.toSet());

        employee.setSkills(skills);
        return employee;

    }
	public Skill convertToSkill(SkillModel viewModel){
        Skill skill;

        if(viewModel.getId() != 0){
            skill = skillRepository.findById(viewModel.getId());
            skill.setDescription(viewModel.getDescription());
        }else{
            skill = new Skill(viewModel.getSkillName(),viewModel.getDescription());
        }

        return skill;
    }
}
