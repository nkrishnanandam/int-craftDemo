package com.comp.intuitter.service;

import java.util.Set;

import com.comp.intuitter.springdata.entity.EmployeeEntity;
import com.comp.intuitter.springdata.entity.PostEntity;


public interface IEmployeeService {
	
	public String createEmployee(EmployeeEntity employee);
	
	public EmployeeEntity getEmployeeById(String employeeId) throws Exception;
	
	public void addFollower(String friendId, String followerId) throws Exception;
	
	public Set<EmployeeEntity> getFollowers(String friendId) throws Exception;
	
	public Set<EmployeeEntity> getFriends(String followerId) throws Exception;
	
	public Set<PostEntity> getPostMessages(String userId) throws Exception;
	
	

}
