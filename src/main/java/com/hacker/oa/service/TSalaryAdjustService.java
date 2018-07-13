package com.hacker.oa.service;

import com.hacker.oa.entity.TSalaryAdjust;
import com.hacker.oa.entity.where.TSalaryAdjustWhere;
import ldh.common.PageResult;

public interface TSalaryAdjustService  {
	
	TSalaryAdjust insert(TSalaryAdjust tSalaryAdjust);
	
	TSalaryAdjust updateById(TSalaryAdjust tSalaryAdjust);
	
	void deleteById(Integer id);

	TSalaryAdjust getById(Integer id);
    
	PageResult<TSalaryAdjust> findByTSalaryAdjustWhere(TSalaryAdjustWhere tSalaryAdjustWhere);
	
}