package com.hacker.oa.service.impl;

import com.hacker.oa.dao.TResourceDao;
import com.hacker.oa.entity.TResource;
import com.hacker.oa.entity.where.TResourceWhere;
import com.hacker.oa.service.TResourceService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import ldh.common.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("tResourceService")
public class TResourceServiceImpl implements TResourceService {

	@Resource
	private TResourceDao tResourceDao;
	
	@Override
	@Transactional
	public TResource insert(TResource tResource) {
		tResourceDao.insert(tResource);
		return tResource;
	}
	
	@Override
	@Transactional
	public TResource updateById(TResource tResource) {
		tResourceDao.updateById(tResource);
		return tResource;
	}
	
	@Override
	@Transactional
	public void deleteById(Integer id) {
	tResourceDao.deleteById(id);
	}

	public TResource getById(Integer id) {
		TResource tResource = tResourceDao.getById(id);
		return tResource;
    }
    
	
	@Override
	@Transactional(readOnly = true)
	public PageResult<TResource> findByTResourceWhere(TResourceWhere tResourceWhere) {
		long total = tResourceDao.findTotalByTResourceWhere(tResourceWhere);
		List<TResource> imageList = new ArrayList<TResource>();
		if (total > 0) {
			imageList  = tResourceDao.findByTResourceWhere(tResourceWhere);
		}
		
		return new PageResult<TResource>(tResourceWhere, total, imageList);
	}
	
	
}