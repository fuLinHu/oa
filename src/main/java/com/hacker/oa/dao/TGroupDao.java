package com.hacker.oa.dao;

import com.hacker.oa.entity.TGroup;
import com.hacker.oa.entity.where.TGroupWhere;
import java.util.List;

public interface TGroupDao  {

	Integer insert(TGroup tGroup);
	
    Integer updateByGroupId(TGroup tGroup);
	
	Integer deleteByGroupId(Integer groupId);

	TGroup getByGroupId(Integer groupId);
    
	TGroup getJoinTUserByGroupId(Integer groupId);

	List<TGroup> findByTGroupWhere(TGroupWhere tGroupWhere);
	
	Long findTotalByTGroupWhere(TGroupWhere tGroupWhere);
	
	
}