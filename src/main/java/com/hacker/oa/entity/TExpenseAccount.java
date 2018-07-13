package com.hacker.oa.entity;

import java.math.BigDecimal;
import java.util.Date;


public class TExpenseAccount   {

	private Integer id;
	private Date date;
	private BigDecimal money;
	private String procInstId;
	private String userId;
	private Date applyDate;
	private Date occurDate;
	private String remark;
	private String status;
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}
	
	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public BigDecimal getMoney() {
		return money;
	}
	
	public void setProcInstId(String procInstId) {
		this.procInstId = procInstId;
	}

	public String getProcInstId() {
		return procInstId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}
	
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public Date getApplyDate() {
		return applyDate;
	}
	
	public void setOccurDate(Date occurDate) {
		this.occurDate = occurDate;
	}

	public Date getOccurDate() {
		return occurDate;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
	
}

