package com.hacker.oa.entity;



public class TUserTask   {

	private Integer id;
	private String procDefKey;
	private String procDefName;
	private String taskDefKey;
	private String taskName;
	private String taskType;
	private String candidateName;
	private String candidateIds;
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	
	public void setProcDefKey(String procDefKey) {
		this.procDefKey = procDefKey;
	}

	public String getProcDefKey() {
		return procDefKey;
	}
	
	public void setProcDefName(String procDefName) {
		this.procDefName = procDefName;
	}

	public String getProcDefName() {
		return procDefName;
	}
	
	public void setTaskDefKey(String taskDefKey) {
		this.taskDefKey = taskDefKey;
	}

	public String getTaskDefKey() {
		return taskDefKey;
	}
	
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskName() {
		return taskName;
	}
	
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public String getTaskType() {
		return taskType;
	}
	
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getCandidateName() {
		return candidateName;
	}
	
	public void setCandidateIds(String candidateIds) {
		this.candidateIds = candidateIds;
	}

	public String getCandidateIds() {
		return candidateIds;
	}
	
}

