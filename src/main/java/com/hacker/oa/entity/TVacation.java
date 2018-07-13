package com.hacker.oa.entity;

import java.util.Date;


public class TVacation   {

	private Integer id;
	private Date applyDate;
	private Date beginDate;
	private Integer workDays;
	private Date endDate;
	private String procInstId;
	private String reason;
	private String status;
	private Integer userId;
	private Integer vacType;
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public Date getApplyDate() {
		return applyDate;
	}
	
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getBeginDate() {
		return beginDate;
	}
	
	public void setWorkDays(Integer workDays) {
		this.workDays = workDays;
	}

	public Integer getWorkDays() {
		return workDays;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getEndDate() {
		return endDate;
	}
	
	public void setProcInstId(String procInstId) {
		this.procInstId = procInstId;
	}

	public String getProcInstId() {
		return procInstId;
	}
	
	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getReason() {
		return reason;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserId() {
		return userId;
	}
	
	public void setVacType(Integer vacType) {
		this.vacType = vacType;
	}

	public Integer getVacType() {
		return vacType;
	}
	
}

