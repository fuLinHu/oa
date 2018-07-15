package com.hacker.oa.service;

import com.hacker.oa.bean.PageResult;
import com.hacker.oa.entity.TExpenseAccount;

public interface TExpenseAccountService  {
	
	TExpenseAccount insert(TExpenseAccount tExpenseAccount);
	
	TExpenseAccount updateById(TExpenseAccount tExpenseAccount);
	
	void deleteById(Integer id);

	TExpenseAccount getById(Integer id);
    
	PageResult<TExpenseAccount> findByTExpenseAccountWhere(TExpenseAccount tExpenseAccountWhere);
	
}