package com.comp.intuitter.controller;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.comp.intuitter.model.CreateFollowerRequest;
import com.comp.intuitter.model.FeedRequest;
import com.comp.intuitter.service.IEmployeeService;
import com.comp.intuitter.service.IPostService;
import com.comp.intuitter.springdata.entity.EmployeeEntity;
import com.comp.intuitter.springdata.entity.PostEntity;

@RestController
public class IntController {
	
	private IEmployeeService iEmployeeService;
	
	private IPostService iPostService;
	
	@Resource
	public void setiPostService(IPostService iPostService) {
		this.iPostService = iPostService;
	}


	@Resource
	public void setiEmployeeService(IEmployeeService iEmployeeService) {
		this.iEmployeeService = iEmployeeService;
	}


	@RequestMapping("/")
	public String index() {
		
		return "Demo is on";
	}
	
	@RequestMapping(value="/getEmployee/{id}")
	public EmployeeEntity getEmployee(@PathVariable String id) {
		
		return iEmployeeService.getEmployeeById(id);
	}
	
	@RequestMapping(value="/createEmployee", method = RequestMethod.POST, produces = 
            "application/json", consumes= "application/json")
	public void employeeStore(@RequestBody EmployeeEntity employee) {
		 iEmployeeService.createEmployee(employee);
	}
	
	@RequestMapping(value="/createFollower", method = RequestMethod.POST, produces = 
            "application/json" )
	public void followerStore(@RequestBody CreateFollowerRequest request) {
		String friendId =request.getFriendId();
		String followerId =request.getFollowerId();
		iEmployeeService.addFollower(friendId, followerId);
	}
	
	@RequestMapping(value="/getFriends", method = RequestMethod.POST, produces = 
            "application/json" )
	public Set<EmployeeEntity> getFriends(@RequestParam("followerId") String followerId) {
		 return iEmployeeService.getFriends(followerId);
	}
	
	@RequestMapping(value="/getFollowers", method = RequestMethod.POST, produces = 
            "application/json")
	public Set<EmployeeEntity> getFollowers(@RequestParam("friendId") String friendId) {
		 return iEmployeeService.getFollowers(friendId);
	}
	
	@RequestMapping(value="/createPost", method = RequestMethod.POST, produces = 
            "application/json", consumes= "application/json")
	public void createPost(@RequestBody PostEntity postEntity) {
		iPostService.createPost(postEntity);
	}
	
	
	@RequestMapping(value="/getPosts", method = RequestMethod.POST, produces = 
            "application/json")
	public Set<PostEntity> getPosts(@RequestParam("userId") String userId) {
		 return iEmployeeService.getPostMessages(userId);
	}
	
	@RequestMapping(value="/getFeed", method = RequestMethod.POST, produces = 
            "application/json")
	public List<PostEntity> getFeed(@RequestBody FeedRequest  request) {
		
		String userId = request.getUserId();
		int queryLimit = request.getQueryLimit();
		 return iPostService.getFeed(userId,queryLimit );
	}
	


}
