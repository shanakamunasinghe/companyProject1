package com.project.spring.app.Repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.spring.app.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	public Employee findById(int id);
}
