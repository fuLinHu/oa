package com.hacker.oa.service.impl;

import com.hacker.oa.bean.PageResult;
import com.hacker.oa.dao.TSalaryAdjustDao;
import com.hacker.oa.entity.TSalaryAdjust;
import com.hacker.oa.service.TSalaryAdjustService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("tSalaryAdjustService")
public class TSalaryAdjustServiceImpl implements TSalaryAdjustService {

	@Resource
	private TSalaryAdjustDao tSalaryAdjustDao;
	
	@Override
	@Transactional
	public TSalaryAdjust insert(TSalaryAdjust tSalaryAdjust) {
		tSalaryAdjustDao.insert(tSalaryAdjust);
		return tSalaryAdjust;
	}
	
	@Override
	@Transactional
	public TSalaryAdjust updateById(TSalaryAdjust tSalaryAdjust) {
		tSalaryAdjustDao.updateById(tSalaryAdjust);
		return tSalaryAdjust;
	}
	
	@Override
	@Transactional
	public void deleteById(Integer id) {
	tSalaryAdjustDao.deleteById(id);
	}

	public TSalaryAdjust getById(Integer id) {
		TSalaryAdjust tSalaryAdjust = tSalaryAdjustDao.getById(id);
		return tSalaryAdjust;
    }
    
	
	@Override
	@Transactional(readOnly = true)
	public PageResult<TSalaryAdjust> findByTSalaryAdjustWhere(TSalaryAdjust tSalaryAdjustWhere) {
		long total = tSalaryAdjustDao.findTotalByTSalaryAdjustWhere(tSalaryAdjustWhere);
		List<TSalaryAdjust> imageList = new ArrayList<TSalaryAdjust>();
		if (total > 0) {
			imageList  = tSalaryAdjustDao.findByTSalaryAdjustWhere(tSalaryAdjustWhere);
		}
		
		return new PageResult<TSalaryAdjust>(tSalaryAdjustWhere, total, imageList);
	}
	
	
}