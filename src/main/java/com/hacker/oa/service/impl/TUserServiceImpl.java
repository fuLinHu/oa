package com.hacker.oa.service.impl;

import com.hacker.oa.bean.PageResult;
import com.hacker.oa.dao.TUserDao;
import com.hacker.oa.entity.TUser;
import com.hacker.oa.service.TUserService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("tUserService")
public class TUserServiceImpl implements TUserService {

	@Resource
	private TUserDao tUserDao;
	
	@Override
	@Transactional
	public TUser insert(TUser tUser) {
		tUserDao.insert(tUser);
		return tUser;
	}
	
	@Override
	@Transactional
	public TUser updateByUserId(TUser tUser) {
		tUserDao.updateByUserId(tUser);
		return tUser;
	}
	
	@Override
	@Transactional
	public void deleteByUserId(Integer userId) {
	tUserDao.deleteByUserId(userId);
	}

	public TUser getByUserId(Integer userId) {
		TUser tUser = tUserDao.getByUserId(userId);
		return tUser;
    }
    
	
	@Override
	@Transactional(readOnly = true)
	public PageResult<TUser> findByTUserWhere(TUser tUserWhere) {
		long total = tUserDao.findTotalByTUserWhere(tUserWhere);
		List<TUser> imageList = new ArrayList<TUser>();
		if (total > 0) {
			imageList  = tUserDao.findByTUserWhere(tUserWhere);
		}
		
		return new PageResult<TUser>(tUserWhere, total, imageList);
	}
	
	@Override
	@Transactional(readOnly = true)
	public PageResult<TUser> findJoinByTUserWhere(TUser tUserWhere) {
		long total = tUserDao.findJoinTotalByTUserWhere(tUserWhere);
		List<TUser> imageList = new ArrayList<TUser>();
		if (total > 0) {
			imageList  = tUserDao.findJoinByTUserWhere(tUserWhere);
		}
		
		return new PageResult<TUser>(tUserWhere, total, imageList);
	}
	
}