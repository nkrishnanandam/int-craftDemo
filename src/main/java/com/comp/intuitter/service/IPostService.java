package com.comp.intuitter.service;

import java.util.List;

import com.comp.intuitter.springdata.entity.PostEntity;

public interface IPostService {
	
	public void createPost(PostEntity postEntity);
	
	public List<PostEntity>  getFeed(String userId, int queryLimit);

}
