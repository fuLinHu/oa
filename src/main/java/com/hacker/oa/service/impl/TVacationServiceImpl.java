package com.hacker.oa.service.impl;

import com.hacker.oa.bean.PageResult;
import com.hacker.oa.dao.TVacationDao;
import com.hacker.oa.entity.TVacation;
import com.hacker.oa.service.TVacationService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("tVacationService")
public class TVacationServiceImpl implements TVacationService {

	@Resource
	private TVacationDao tVacationDao;
	
	@Override
	@Transactional
	public TVacation insert(TVacation tVacation) {
		tVacationDao.insert(tVacation);
		return tVacation;
	}
	
	@Override
	@Transactional
	public TVacation updateById(TVacation tVacation) {
		tVacationDao.updateById(tVacation);
		return tVacation;
	}
	
	@Override
	@Transactional
	public void deleteById(Integer id) {
	tVacationDao.deleteById(id);
	}

	public TVacation getById(Integer id) {
		TVacation tVacation = tVacationDao.getById(id);
		return tVacation;
    }
    
	
	@Override
	@Transactional(readOnly = true)
	public PageResult<TVacation> findByTVacationWhere(TVacation tVacationWhere) {
		long total = tVacationDao.findTotalByTVacationWhere(tVacationWhere);
		List<TVacation> imageList = new ArrayList<TVacation>();
		if (total > 0) {
			imageList  = tVacationDao.findByTVacationWhere(tVacationWhere);
		}
		
		return new PageResult<TVacation>(tVacationWhere, total, imageList);
	}
	
	
}