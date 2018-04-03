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
	public EmployeeEntity getEmployeeById(String employeeId) {
		// TODO Auto-generated method stub
		return iEmployeeEntityRepository.findOne(employeeId);
	}

	@Override
	public void addFollower(String friendId, String followerId) {
		
		EmployeeEntity friend = iEmployeeEntityRepository.findOne(friendId);
		EmployeeEntity follower = iEmployeeEntityRepository.findOne(followerId);
		System.out.println("friendId" + friendId);
		System.out.println("followerId" + followerId);
		
		friend.getFollowers().add(follower);
		iEmployeeEntityRepository.save(friend);
	}

	@Override
	public Set<EmployeeEntity> getFollowers(String friendId) {
		EmployeeEntity friend = iEmployeeEntityRepository.findOne(friendId);
		return friend.getFollowers();
	}

	@Override
	public Set<EmployeeEntity> getFriends(String followerId) {
		EmployeeEntity follower = iEmployeeEntityRepository.findOne(followerId);
		return follower.getFriends();
	}

	@Override
	public Set<PostEntity> getPostMessages(String userId) {
		EmployeeEntity employee = iEmployeeEntityRepository.findOne(userId);
		
		return employee.getPostMessages();
	}


	
	
	
	

}
