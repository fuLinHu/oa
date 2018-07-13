package com.hacker.oa.service;

import com.hacker.oa.entity.TGroupResource;
import com.hacker.oa.entity.where.TGroupResourceWhere;
import ldh.common.PageResult;

public interface TGroupResourceService  {
	
	TGroupResource insert(TGroupResource tGroupResource);
	
	TGroupResource updateById(TGroupResource tGroupResource);
	
	void deleteById(Integer id);

	TGroupResource getById(Integer id);
    
	PageResult<TGroupResource> findByTGroupResourceWhere(TGroupResourceWhere tGroupResourceWhere);
	
}