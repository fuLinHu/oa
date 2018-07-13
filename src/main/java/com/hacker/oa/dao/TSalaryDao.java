package com.hacker.oa.dao;

import com.hacker.oa.entity.TSalary;
import com.hacker.oa.entity.where.TSalaryWhere;
import java.util.List;

public interface TSalaryDao  {

	Integer insert(TSalary tSalary);
	
    Integer updateById(TSalary tSalary);
	
	Integer deleteById(Integer id);

	TSalary getById(Integer id);
    
	List<TSalary> findByTSalaryWhere(TSalaryWhere tSalaryWhere);
	
	Long findTotalByTSalaryWhere(TSalaryWhere tSalaryWhere);
	
	
}