package com.hacker.oa.service;

import com.hacker.oa.entity.TGroup;
import com.hacker.oa.entity.where.TGroupWhere;
import ldh.common.PageResult;

public interface TGroupService  {
	
	TGroup insert(TGroup tGroup);
	
	TGroup updateByGroupId(TGroup tGroup);
	
	void deleteByGroupId(Integer groupId);

	TGroup getByGroupId(Integer groupId);
    
	PageResult<TGroup> findByTGroupWhere(TGroupWhere tGroupWhere);
	
}