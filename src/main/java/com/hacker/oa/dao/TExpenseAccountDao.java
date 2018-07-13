package com.hacker.oa.dao;

import com.hacker.oa.entity.TExpenseAccount;
import com.hacker.oa.entity.where.TExpenseAccountWhere;
import java.util.List;

public interface TExpenseAccountDao  {

	Integer insert(TExpenseAccount tExpenseAccount);
	
    Integer updateById(TExpenseAccount tExpenseAccount);
	
	Integer deleteById(Integer id);

	TExpenseAccount getById(Integer id);
    
	List<TExpenseAccount> findByTExpenseAccountWhere(TExpenseAccountWhere tExpenseAccountWhere);
	
	Long findTotalByTExpenseAccountWhere(TExpenseAccountWhere tExpenseAccountWhere);
	
	
}