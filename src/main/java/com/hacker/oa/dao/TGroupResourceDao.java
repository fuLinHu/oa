package com.hacker.oa.dao;

import com.hacker.oa.entity.TGroupResource;
import java.util.List;

public interface TGroupResourceDao  {

	Integer insert(TGroupResource tGroupResource);
	
    Integer updateById(TGroupResource tGroupResource);
	
	Integer deleteById(Integer id);

	TGroupResource getById(Integer id);
    
	List<TGroupResource> findByTGroupResourceWhere(TGroupResource tGroupResourceWhere);
	
	Long findTotalByTGroupResourceWhere(TGroupResource tGroupResourceWhere);
	
	
}