package com.hacker.oa.dao;

import com.hacker.oa.entity.TResource;
//import com.hacker.oa.entity.where.TResourceWhere;
import java.util.List;

public interface TResourceDao  {

	Integer insert(TResource tResource);
	
    Integer updateById(TResource tResource);
	
	Integer deleteById(Integer id);

	TResource getById(Integer id);
    
	//List<TResource> findByTResourceWhere(TResourceWhere tResourceWhere);
	
	//Long findTotalByTResourceWhere(TResourceWhere tResourceWhere);
	
	
}