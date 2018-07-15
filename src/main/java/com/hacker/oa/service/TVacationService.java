package com.hacker.oa.service;

import com.hacker.oa.bean.PageResult;
import com.hacker.oa.entity.TVacation;

public interface TVacationService  {
	
	TVacation insert(TVacation tVacation);
	
	TVacation updateById(TVacation tVacation);
	
	void deleteById(Integer id);

	TVacation getById(Integer id);
    
	PageResult<TVacation> findByTVacationWhere(TVacation tVacationWhere);
	
}