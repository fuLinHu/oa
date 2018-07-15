package com.hacker.oa.entity;

import com.hacker.oa.bean.BaseBean;

import java.math.BigDecimal;


public class TSalary   extends BaseBean {

	private Integer id;
	private BigDecimal baseMoney;
	private String userId;
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	
	public void setBaseMoney(BigDecimal baseMoney) {
		this.baseMoney = baseMoney;
	}

	public BigDecimal getBaseMoney() {
		return baseMoney;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}
	
}

