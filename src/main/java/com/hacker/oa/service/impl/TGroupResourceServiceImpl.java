package com.hacker.oa.service.impl;

import com.hacker.oa.bean.PageResult;
import com.hacker.oa.dao.TGroupResourceDao;
import com.hacker.oa.entity.TGroupResource;
import com.hacker.oa.service.TGroupResourceService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("tGroupResourceService")
public class TGroupResourceServiceImpl implements TGroupResourceService {

	@Resource
	private TGroupResourceDao tGroupResourceDao;
	
	@Override
	@Transactional
	public TGroupResource insert(TGroupResource tGroupResource) {
		tGroupResourceDao.insert(tGroupResource);
		return tGroupResource;
	}
	
	@Override
	@Transactional
	public TGroupResource updateById(TGroupResource tGroupResource) {
		tGroupResourceDao.updateById(tGroupResource);
		return tGroupResource;
	}
	
	@Override
	@Transactional
	public void deleteById(Integer id) {
	tGroupResourceDao.deleteById(id);
	}

	public TGroupResource getById(Integer id) {
		TGroupResource tGroupResource = tGroupResourceDao.getById(id);
		return tGroupResource;
    }
    
	
	@Override
	@Transactional(readOnly = true)
	public PageResult<TGroupResource> findByTGroupResourceWhere(TGroupResource tGroupResourceWhere) {
		long total = tGroupResourceDao.findTotalByTGroupResourceWhere(tGroupResourceWhere);
		List<TGroupResource> imageList = new ArrayList<TGroupResource>();
		if (total > 0) {
			imageList  = tGroupResourceDao.findByTGroupResourceWhere(tGroupResourceWhere);
		}
		
		return new PageResult<TGroupResource>(tGroupResourceWhere, total, imageList);
	}
	
	
}