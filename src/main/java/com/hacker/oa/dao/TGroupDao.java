package com.hacker.oa.dao;

import com.hacker.oa.entity.TGroup;
import java.util.List;

public interface TGroupDao  {

	Integer insert(TGroup tGroup);
	
    Integer updateByGroupId(TGroup tGroup);
	
	Integer deleteByGroupId(Integer groupId);

	TGroup getByGroupId(Integer groupId);
    
	TGroup getJoinTUserByGroupId(Integer groupId);

	List<TGroup> findByTGroupWhere(TGroup tGroupWhere);
	
	Long findTotalByTGroupWhere(TGroup tGroupWhere);
	
	
}