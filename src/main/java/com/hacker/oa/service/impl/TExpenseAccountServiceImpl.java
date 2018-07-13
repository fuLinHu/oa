package com.hacker.oa.service.impl;

import com.hacker.oa.dao.TExpenseAccountDao;
import com.hacker.oa.entity.TExpenseAccount;
//import com.hacker.oa.entity.where.TExpenseAccountWhere;
import com.hacker.oa.service.TExpenseAccountService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
//import ldh.common.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("tExpenseAccountService")
public class TExpenseAccountServiceImpl implements TExpenseAccountService {

	@Resource
	private TExpenseAccountDao tExpenseAccountDao;
	
	@Override
	@Transactional
	public TExpenseAccount insert(TExpenseAccount tExpenseAccount) {
		tExpenseAccountDao.insert(tExpenseAccount);
		return tExpenseAccount;
	}
	
	@Override
	@Transactional
	public TExpenseAccount updateById(TExpenseAccount tExpenseAccount) {
		tExpenseAccountDao.updateById(tExpenseAccount);
		return tExpenseAccount;
	}
	
	@Override
	@Transactional
	public void deleteById(Integer id) {
	tExpenseAccountDao.deleteById(id);
	}

	public TExpenseAccount getById(Integer id) {
		TExpenseAccount tExpenseAccount = tExpenseAccountDao.getById(id);
		return tExpenseAccount;
    }
    
	
	/*@Override
	@Transactional(readOnly = true)
	public PageResult<TExpenseAccount> findByTExpenseAccountWhere(TExpenseAccountWhere tExpenseAccountWhere) {
		long total = tExpenseAccountDao.findTotalByTExpenseAccountWhere(tExpenseAccountWhere);
		List<TExpenseAccount> imageList = new ArrayList<TExpenseAccount>();
		if (total > 0) {
			imageList  = tExpenseAccountDao.findByTExpenseAccountWhere(tExpenseAccountWhere);
		}
		
		return new PageResult<TExpenseAccount>(tExpenseAccountWhere, total, imageList);
	}*/
	
	
}