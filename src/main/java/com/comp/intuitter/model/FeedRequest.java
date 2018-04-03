package com.comp.intuitter.model;

public class FeedRequest {
	
	private int queryLimit;
	private String userId;
	public int getQueryLimit() {
		return queryLimit;
	}
	public void setQueryLimit(int queryLimit) {
		this.queryLimit = queryLimit;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
