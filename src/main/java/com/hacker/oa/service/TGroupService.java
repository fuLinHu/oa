package com.hacker.oa.service;

import com.hacker.oa.bean.PageResult;
import com.hacker.oa.entity.TGroup;

public interface TGroupService  {
	
	TGroup insert(TGroup tGroup);
	
	TGroup updateByGroupId(TGroup tGroup);
	
	void deleteByGroupId(Integer groupId);

	TGroup getByGroupId(Integer groupId);
    
	PageResult<TGroup> findByTGroupWhere(TGroup tGroupWhere);
	
}