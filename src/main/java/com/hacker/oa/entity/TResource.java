package com.hacker.oa.entity;



public class TResource   {

	private Integer id;
	private String name;
	private String type;
	private String url;
	private Integer parentId;
	private String parentIds;
	private String permission;
	private Integer available;
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
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
	
	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}
	
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getParentId() {
		return parentId;
	}
	
	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	public String getParentIds() {
		return parentIds;
	}
	
	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getPermission() {
		return permission;
	}
	
	public void setAvailable(Integer available) {
		this.available = available;
	}

	public Integer getAvailable() {
		return available;
	}
	
}

