package com.hacker.oa.dao;

import com.hacker.oa.entity.TVacation;
import com.hacker.oa.entity.where.TVacationWhere;
import java.util.List;

public interface TVacationDao  {

	Integer insert(TVacation tVacation);
	
    Integer updateById(TVacation tVacation);
	
	Integer deleteById(Integer id);

	TVacation getById(Integer id);
    
	List<TVacation> findByTVacationWhere(TVacationWhere tVacationWhere);
	
	Long findTotalByTVacationWhere(TVacationWhere tVacationWhere);
	
	
}