package com.project.spring.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.spring.app.Mapper.MappingManager;
import com.project.spring.app.Repo.SkillRepository;
import com.project.spring.app.model.Skill;
import com.project.spring.app.viewModel.SkillModel;

@Service
public class SkillService {
	
	@Autowired
	private SkillRepository skillRepository;
	private MappingManager mapper;
	
	public List<SkillModel> getAllSkills(){
		return skillRepository.findAll()
        .stream()
        .map(skill -> this.mapper.convertToSkillViewModel(skill))
        .collect(Collectors.toList());
	}
	
	public SkillModel getSkill(int id) {
		Skill skill = skillRepository.findById(id);
		return this.mapper.convertToSkillViewModel(skill);
	}

	public void addSkill(SkillModel skill) {
		Skill skillResult = this.mapper.convertToSkill(skill);
		skillRepository.save(skillResult);
		
	}

	public void updateSkill(int id, SkillModel skill) {
		Skill skillResult = this.mapper.convertToSkill(skill);
		skillRepository.save(skillResult);
	}

	public void deleteSkill(int id) {
		skillRepository.deleteById(id);;
	}
}