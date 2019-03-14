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
import com.project.spring.app.service.SkillService;
import com.project.spring.app.viewModel.SkillModel;



@RestController
@CrossOrigin
public class SkillController {
	@Autowired 
	private SkillService skillService;
	private List<SkillModel> data = new ArrayList<>(); 
	private SkillModel value = new SkillModel();
	
	public SkillController(SkillService skillService) {
		super();
		this.skillService = skillService;
	}
	
	
	
	@RequestMapping("/skills")
	public List<SkillModel> getAllSkills() {
		data = skillService.getAllSkills();
		if(data == null) {
			throw new ValidationException("The dataBase has a problem");
		}
		return data;
	}
	
	@RequestMapping("/skills/{foo}")
	public SkillModel getSkill(@PathVariable("foo") int id) {
		value = skillService.getSkill(id);
		if(value == null) {
			throw new ValidationException("The dataBase has a problem");
		}
		return value;
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "/skills")
	public void addSkill(@RequestBody SkillModel skill, BindingResult bindingResults) {
		if(bindingResults.hasErrors()) {
			throw new ValidationException("Puting Skills has error");
		}
		skillService.addSkill(skill);

	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/skills/{id}")
	public void updateSkill(@RequestBody SkillModel skill,@PathVariable int id, BindingResult bindingResults) {
		if(bindingResults.hasErrors()) {
			throw new ValidationException("Puting Skills has error");
		}
		skillService.updateSkill(id,skill);
	}
	@RequestMapping(method = RequestMethod.DELETE, value = "/skills/{id}")
	public void deleteSkill(@PathVariable int id) {
		skillService.deleteSkill(id);
	}
}