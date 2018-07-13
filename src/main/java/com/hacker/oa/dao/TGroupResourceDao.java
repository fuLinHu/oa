package com.hacker.oa.dao;

import com.hacker.oa.entity.TGroupResource;
import com.hacker.oa.entity.where.TGroupResourceWhere;
import java.util.List;

public interface TGroupResourceDao  {

	Integer insert(TGroupResource tGroupResource);
	
    Integer updateById(TGroupResource tGroupResource);
	
	Integer deleteById(Integer id);

	TGroupResource getById(Integer id);
    
	List<TGroupResource> findByTGroupResourceWhere(TGroupResourceWhere tGroupResourceWhere);
	
	Long findTotalByTGroupResourceWhere(TGroupResourceWhere tGroupResourceWhere);
	
	
}