package com.hacker.oa.dao;

import com.hacker.oa.entity.TSalary;
import java.util.List;

public interface TSalaryDao  {

	Integer insert(TSalary tSalary);
	
    Integer updateById(TSalary tSalary);
	
	Integer deleteById(Integer id);

	TSalary getById(Integer id);
    
	List<TSalary> findByTSalaryWhere(TSalary tSalaryWhere);
	
	Long findTotalByTSalaryWhere(TSalary tSalaryWhere);
	
	
}