package com.hacker.oa.entity;

import com.hacker.oa.bean.BaseBean;

import java.util.Date;


public class TUser   extends BaseBean {

	private Integer userId;
	private String userName;
	private String userPwd;
	private Date regDate;
	private Integer locked;
	private String userSalt;
	
	private TGroup group;
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserId() {
		return userId;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}
	
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserPwd() {
		return userPwd;
	}
	
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getRegDate() {
		return regDate;
	}
	
	public void setLocked(Integer locked) {
		this.locked = locked;
	}

	public Integer getLocked() {
		return locked;
	}
	
	public void setUserSalt(String userSalt) {
		this.userSalt = userSalt;
	}

	public String getUserSalt() {
		return userSalt;
	}
	
	public void setGroup(TGroup group) {
		this.group = group;
	}
	
	public TGroup getGroup() {
		return group;
	}
	
}

