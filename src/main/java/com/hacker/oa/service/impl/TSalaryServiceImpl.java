package com.hacker.oa.service.impl;

import com.hacker.oa.bean.PageResult;
import com.hacker.oa.dao.TSalaryDao;
import com.hacker.oa.entity.TSalary;
import com.hacker.oa.service.TSalaryService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("tSalaryService")
public class TSalaryServiceImpl implements TSalaryService {

	@Resource
	private TSalaryDao tSalaryDao;
	
	@Override
	@Transactional
	public TSalary insert(TSalary tSalary) {
		tSalaryDao.insert(tSalary);
		return tSalary;
	}
	
	@Override
	@Transactional
	public TSalary updateById(TSalary tSalary) {
		tSalaryDao.updateById(tSalary);
		return tSalary;
	}
	
	@Override
	@Transactional
	public void deleteById(Integer id) {
	tSalaryDao.deleteById(id);
	}

	public TSalary getById(Integer id) {
		TSalary tSalary = tSalaryDao.getById(id);
		return tSalary;
    }
    
	
	@Override
	@Transactional(readOnly = true)
	public PageResult<TSalary> findByTSalaryWhere(TSalary tSalaryWhere) {
		long total = tSalaryDao.findTotalByTSalaryWhere(tSalaryWhere);
		List<TSalary> imageList = new ArrayList<TSalary>();
		if (total > 0) {
			imageList  = tSalaryDao.findByTSalaryWhere(tSalaryWhere);
		}
		
		return new PageResult<TSalary>(tSalaryWhere, total, imageList);
	}
	
	
}