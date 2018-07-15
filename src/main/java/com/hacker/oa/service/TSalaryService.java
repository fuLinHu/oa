package com.hacker.oa.service;

import com.hacker.oa.bean.PageResult;
import com.hacker.oa.entity.TSalary;

public interface TSalaryService  {
	
	TSalary insert(TSalary tSalary);
	
	TSalary updateById(TSalary tSalary);
	
	void deleteById(Integer id);

	TSalary getById(Integer id);
    
	PageResult<TSalary> findByTSalaryWhere(TSalary tSalaryWhere);
	
}