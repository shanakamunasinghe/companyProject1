package com.project.spring.app.Repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.project.spring.app.model.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer>{
	public Skill findByskillName(String skillName);
	public Skill findById(int id)
;}
