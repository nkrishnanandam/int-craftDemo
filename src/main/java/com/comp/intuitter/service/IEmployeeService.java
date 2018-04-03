package com.comp.intuitter.service;

import java.util.Set;

import com.comp.intuitter.springdata.entity.EmployeeEntity;
import com.comp.intuitter.springdata.entity.PostEntity;


public interface IEmployeeService {
	
	public String createEmployee(EmployeeEntity employee);
	
	public EmployeeEntity getEmployeeById(String employeeId);
	
	public void addFollower(String friendId, String followerId);
	
	public Set<EmployeeEntity> getFollowers(String friendId);
	
	public Set<EmployeeEntity> getFriends(String followerId);
	
	public Set<PostEntity> getPostMessages(String userId);
	
	

}
