package com.comp.intuitter.springdata.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "employee")
public class EmployeeEntity implements Serializable{
	
	public EmployeeEntity() {
	
	}

	private static final long serialVersionUID = 1L;

	@Id
	@Column
	private String id;
	
	@Column(nullable = false, length = 256)
	private String firstName;
	
	@Column(nullable = false, length = 256)
	private String LastName;
	
	@Column(nullable = false, length = 256)
	private String title;
	
	@ManyToMany
    @JoinTable(name="friends_followers",
           joinColumns = { @JoinColumn(name ="friendId", referencedColumnName ="id", nullable = false) },
           inverseJoinColumns = { @JoinColumn(name ="followerId", referencedColumnName ="id", nullable = false) },
           indexes = {
        	        @Index(name = "idx_friends_followers_friendId", columnList = "friendId"),
        	        @Index(name = "idx_friends_followers_followerId", columnList = "followerId")
        	    })
    private Set<EmployeeEntity> followers = new HashSet<>();

	@ManyToMany(mappedBy="followers")
    private Set<EmployeeEntity> friends = new HashSet<>();
	
	@OneToMany(mappedBy="employee")
	private Set<PostEntity> postMessages;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@JsonIgnore
	public Set<EmployeeEntity> getFollowers() {
		return followers;
	}

	public void setFollowers(Set<EmployeeEntity> followers) {
		this.followers = followers;
	}

	@JsonIgnore
	public Set<EmployeeEntity> getFriends() {
		return friends;
	}

	public void setFriends(Set<EmployeeEntity> friends) {
		this.friends = friends;
	}

	@JsonIgnore
	public Set<PostEntity> getPostMessages() {
		return postMessages;
	}

	public void setPostMessages(Set<PostEntity> postMessages) {
		this.postMessages = postMessages;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", " + "firstName=" + firstName + "," + " LastName=" + LastName + "," + " title="
				+ title + "]";
	}



}
