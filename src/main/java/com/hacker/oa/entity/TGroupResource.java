package com.hacker.oa.entity;


import com.hacker.oa.bean.BaseBean;

public class TGroupResource  extends BaseBean {

	private Integer id;
	private Integer groupId;
	private Integer resourceId;
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getGroupId() {
		return groupId;
	}
	
	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	public Integer getResourceId() {
		return resourceId;
	}
	
}

