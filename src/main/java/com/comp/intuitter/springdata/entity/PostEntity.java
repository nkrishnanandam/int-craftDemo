package com.comp.intuitter.springdata.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "post",
indexes = {
        @Index(name = "idx_post_employee_id", columnList = "employee_id")})
public class PostEntity implements Serializable {


	private static final long serialVersionUID = 1L;
	
	public PostEntity() {
	
	}

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	
	@Column
	private String postMessage;
	
	@ManyToOne
	@JoinColumn(name="employee_id")
	private EmployeeEntity employee;
	
	
    @Column (name = "createDate", nullable=false, updatable=false, columnDefinition="DATETIME default CURRENT_TIMESTAMP")
    private Date createDate = null;
    
    @PrePersist
    protected void onCreate() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("UTC"));
         
    	createDate = cal.getTime();
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPostMessage() {
		return postMessage;
	}

	public void setPostMessage(String postMessage) {
		this.postMessage = postMessage;
	}

	public EmployeeEntity getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


}
