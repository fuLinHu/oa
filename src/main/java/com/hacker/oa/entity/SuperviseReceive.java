package com.hacker.oa.entity;

import java.util.Date;


public class SuperviseReceive   {

	private Integer id;
	private Date createDate;
	private String feedbackCycle;
	private String feedbackLimit;
	private Date handleDate;
	private String number;
	private String status;
	private String title;
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getCreateDate() {
		return createDate;
	}
	
	public void setFeedbackCycle(String feedbackCycle) {
		this.feedbackCycle = feedbackCycle;
	}

	public String getFeedbackCycle() {
		return feedbackCycle;
	}
	
	public void setFeedbackLimit(String feedbackLimit) {
		this.feedbackLimit = feedbackLimit;
	}

	public String getFeedbackLimit() {
		return feedbackLimit;
	}
	
	public void setHandleDate(Date handleDate) {
		this.handleDate = handleDate;
	}

	public Date getHandleDate() {
		return handleDate;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
	
}

