package com.hacker.oa.service;

import com.hacker.oa.entity.TVacation;
/*import com.hacker.oa.entity.where.TVacationWhere;
import ldh.common.PageResult;*/

public interface TVacationService  {
	
	TVacation insert(TVacation tVacation);
	
	TVacation updateById(TVacation tVacation);
	
	void deleteById(Integer id);

	TVacation getById(Integer id);
    
	//PageResult<TVacation> findByTVacationWhere(TVacationWhere tVacationWhere);
	
}