package com.hacker.oa.entity;

import com.hacker.oa.bean.BaseBean;

import java.math.BigDecimal;
import java.util.Date;


public class TSalaryAdjust   extends BaseBean {

	private Integer id;
	private BigDecimal adjustMoney;
	private Date applyDate;
	private String dscp;
	private String procInstId;
	private String userId;
	private String status;
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	
	public void setAdjustMoney(BigDecimal adjustMoney) {
		this.adjustMoney = adjustMoney;
	}

	public BigDecimal getAdjustMoney() {
		return adjustMoney;
	}
	
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public Date getApplyDate() {
		return applyDate;
	}
	
	public void setDscp(String dscp) {
		this.dscp = dscp;
	}

	public String getDscp() {
		return dscp;
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
	
	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
	
}

