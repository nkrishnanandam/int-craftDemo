package com.comp.intuitter.serviceImpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comp.intuitter.service.IEmployeeService;
import com.comp.intuitter.springdata.dao.EmployeeEntityRepository;
import com.comp.intuitter.springdata.entity.EmployeeEntity;
import com.comp.intuitter.springdata.entity.PostEntity;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
	
	@Autowired
	private EmployeeEntityRepository iEmployeeEntityRepository;

	
	public void setiEmployeeDao(EmployeeEntityRepository iEmployeeEntityDao) {
		this.iEmployeeEntityRepository = iEmployeeEntityDao;
	}

	@Override
	public String createEmployee(EmployeeEntity employee) {
		iEmployeeEntityRepository.save(employee);
		return "Success";
	}

	@Override
	public EmployeeEntity getEmployeeById(String employeeId) throws Exception {
		// TODO Auto-generated method stub
		EmployeeEntity employee= iEmployeeEntityRepository.findOne(employeeId);
		if(employee==null) {
			throw new Exception("Employee not found");
		}
		return employee;
	}

	@Override
	public void addFollower(String friendId, String followerId) throws Exception {
		
		EmployeeEntity friend = iEmployeeEntityRepository.findOne(friendId);
		EmployeeEntity follower = iEmployeeEntityRepository.findOne(followerId);
		System.out.println("friendId" + friendId);
		System.out.println("followerId" + followerId);
		if(friend==null) {
			throw new Exception("Employee not found");
		}
		if(follower==null) {
			throw new Exception("Employee not found");
		}
		
		
		friend.getFollowers().add(follower);
		iEmployeeEntityRepository.save(friend);
	}

	@Override
	public Set<EmployeeEntity> getFollowers(String friendId) throws Exception {
		EmployeeEntity friend = iEmployeeEntityRepository.findOne(friendId);
		if(friend==null) {
			throw new Exception("Employee not found");
		}
		return friend.getFollowers();
	}

	@Override
	public Set<EmployeeEntity> getFriends(String followerId) throws Exception {
		EmployeeEntity follower = iEmployeeEntityRepository.findOne(followerId);
		if(follower==null) {
			throw new Exception("Employee not found");
		}
		return follower.getFriends();
	}

	@Override
	public Set<PostEntity> getPostMessages(String userId) throws Exception {
		EmployeeEntity employee = iEmployeeEntityRepository.findOne(userId);
		if(employee==null) {
			throw new Exception("Employee not found");
		}
		
		return employee.getPostMessages();
	}


	
	
	
	

}
