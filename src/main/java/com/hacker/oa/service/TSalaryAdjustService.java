package com.hacker.oa.service;

import com.hacker.oa.bean.PageResult;
import com.hacker.oa.entity.TSalaryAdjust;

public interface TSalaryAdjustService  {
	
	TSalaryAdjust insert(TSalaryAdjust tSalaryAdjust);
	
	TSalaryAdjust updateById(TSalaryAdjust tSalaryAdjust);
	
	void deleteById(Integer id);

	TSalaryAdjust getById(Integer id);
    
	PageResult<TSalaryAdjust> findByTSalaryAdjustWhere(TSalaryAdjust tSalaryAdjustWhere);
	
}