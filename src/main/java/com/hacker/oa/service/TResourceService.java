package com.hacker.oa.service;

import com.hacker.oa.bean.PageResult;
import com.hacker.oa.entity.TResource;


public interface TResourceService  {
	
	TResource insert(TResource tResource);
	
	TResource updateById(TResource tResource);
	
	void deleteById(Integer id);

	TResource getById(Integer id);
    
	PageResult<TResource> findByTResourceWhere(TResource tResourceWhere);
	
}