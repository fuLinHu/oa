package com.hacker.oa.service;

import com.hacker.oa.entity.TSalary;
import com.hacker.oa.entity.where.TSalaryWhere;
import ldh.common.PageResult;

public interface TSalaryService  {
	
	TSalary insert(TSalary tSalary);
	
	TSalary updateById(TSalary tSalary);
	
	void deleteById(Integer id);

	TSalary getById(Integer id);
    
	PageResult<TSalary> findByTSalaryWhere(TSalaryWhere tSalaryWhere);
	
}