package com.comp.intuitter.springdata.dao;

import org.springframework.data.repository.CrudRepository;

import com.comp.intuitter.springdata.entity.EmployeeEntity;


public interface EmployeeEntityRepository extends CrudRepository<EmployeeEntity, String>{
	EmployeeEntity findById(String Id);
	
	

}
