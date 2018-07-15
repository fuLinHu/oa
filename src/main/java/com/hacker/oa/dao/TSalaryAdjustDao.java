package com.hacker.oa.dao;

import com.hacker.oa.entity.TSalaryAdjust;
import java.util.List;

public interface TSalaryAdjustDao  {

	Integer insert(TSalaryAdjust tSalaryAdjust);
	
    Integer updateById(TSalaryAdjust tSalaryAdjust);
	
	Integer deleteById(Integer id);

	TSalaryAdjust getById(Integer id);
    
	List<TSalaryAdjust> findByTSalaryAdjustWhere(TSalaryAdjust tSalaryAdjustWhere);
	
	Long findTotalByTSalaryAdjustWhere(TSalaryAdjust tSalaryAdjustWhere);
	
	
}