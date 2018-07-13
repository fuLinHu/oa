package com.hacker.oa.service;

import com.hacker.oa.entity.TResource;
import com.hacker.oa.entity.where.TResourceWhere;
import ldh.common.PageResult;

public interface TResourceService  {
	
	TResource insert(TResource tResource);
	
	TResource updateById(TResource tResource);
	
	void deleteById(Integer id);

	TResource getById(Integer id);
    
	PageResult<TResource> findByTResourceWhere(TResourceWhere tResourceWhere);
	
}