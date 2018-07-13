package com.hacker.oa.entity;

import java.util.List;


public class TGroup   {

	private Integer groupId;
	private String name;
	private String type;
	
	public List<TUser> TUsers;

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getGroupId() {
		return groupId;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
	
	public void setTUsers(List<TUser> TUsers) {
		this.TUsers = TUsers;
	}

	public List<TUser> getTUsers() {
		return this.TUsers;
	}

}

