package com.hacker.oa.dao;

import com.hacker.oa.entity.TVacation;
import java.util.List;

public interface TVacationDao  {

	Integer insert(TVacation tVacation);
	
    Integer updateById(TVacation tVacation);
	
	Integer deleteById(Integer id);

	TVacation getById(Integer id);
    
	List<TVacation> findByTVacationWhere(TVacation tVacationWhere);
	
	Long findTotalByTVacationWhere(TVacation tVacationWhere);
	
	
}