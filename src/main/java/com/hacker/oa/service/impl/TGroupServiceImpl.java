package com.hacker.oa.service.impl;

import com.hacker.oa.bean.PageResult;
import com.hacker.oa.dao.TGroupDao;
import com.hacker.oa.entity.TGroup;
import com.hacker.oa.service.TGroupService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("tGroupService")
public class TGroupServiceImpl implements TGroupService {

	@Resource
	private TGroupDao tGroupDao;
	
	@Override
	@Transactional
	public TGroup insert(TGroup tGroup) {
		tGroupDao.insert(tGroup);
		return tGroup;
	}
	
	@Override
	@Transactional
	public TGroup updateByGroupId(TGroup tGroup) {
		tGroupDao.updateByGroupId(tGroup);
		return tGroup;
	}
	
	@Override
	@Transactional
	public void deleteByGroupId(Integer groupId) {
	tGroupDao.deleteByGroupId(groupId);
	}

	public TGroup getByGroupId(Integer groupId) {
		TGroup tGroup = tGroupDao.getByGroupId(groupId);
		return tGroup;
    }
    
	
	@Override
	@Transactional(readOnly = true)
	public PageResult<TGroup> findByTGroupWhere(TGroup tGroupWhere) {
		long total = tGroupDao.findTotalByTGroupWhere(tGroupWhere);
		List<TGroup> imageList = new ArrayList<TGroup>();
		if (total > 0) {
			imageList  = tGroupDao.findByTGroupWhere(tGroupWhere);
		}
		
		return new PageResult<TGroup>(tGroupWhere, total, imageList);
	}
	
	
}