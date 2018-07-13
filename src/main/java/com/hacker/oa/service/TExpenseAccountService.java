package com.hacker.oa.service;

import com.hacker.oa.entity.TExpenseAccount;
/*import com.hacker.oa.entity.where.TExpenseAccountWhere;
import ldh.common.PageResult;*/

public interface TExpenseAccountService  {
	
	TExpenseAccount insert(TExpenseAccount tExpenseAccount);
	
	TExpenseAccount updateById(TExpenseAccount tExpenseAccount);
	
	void deleteById(Integer id);

	TExpenseAccount getById(Integer id);
    
	//PageResult<TExpenseAccount> findByTExpenseAccountWhere(TExpenseAccountWhere tExpenseAccountWhere);
	
}