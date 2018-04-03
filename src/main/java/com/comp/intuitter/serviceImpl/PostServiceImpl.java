package com.comp.intuitter.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.comp.intuitter.service.IPostService;
import com.comp.intuitter.springdata.dao.EmployeeEntityRepository;
import com.comp.intuitter.springdata.dao.PostEntityRepository;
import com.comp.intuitter.springdata.entity.EmployeeEntity;
import com.comp.intuitter.springdata.entity.PostEntity;

@Service
public class PostServiceImpl implements IPostService {
	
	@Autowired
	private PostEntityRepository postEntityRepository;
	
	@Autowired
	private EmployeeEntityRepository iEmployeeEntityRepository;

	public void setPostEntityRepository(PostEntityRepository postEntityRepository) {
		this.postEntityRepository = postEntityRepository;
	}

	@Override
	public void createPost(PostEntity postEntity) {
		
		postEntityRepository.save(postEntity);
	}
	
	public List<PostEntity>  getFeed(String userId, int queryLimit){
		EmployeeEntity employee = iEmployeeEntityRepository.findOne(userId);

		
		return postEntityRepository.findByEmployeeId(userId, new PageRequest(0, queryLimit));
		
	}

}
