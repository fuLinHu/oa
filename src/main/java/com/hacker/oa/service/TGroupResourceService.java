package com.hacker.oa.service;

import com.hacker.oa.bean.PageResult;
import com.hacker.oa.entity.TGroupResource;


public interface TGroupResourceService  {
	
	TGroupResource insert(TGroupResource tGroupResource);
	
	TGroupResource updateById(TGroupResource tGroupResource);
	
	void deleteById(Integer id);

	TGroupResource getById(Integer id);
    
	PageResult<TGroupResource> findByTGroupResourceWhere(TGroupResource tGroupResourceWhere);
	
}