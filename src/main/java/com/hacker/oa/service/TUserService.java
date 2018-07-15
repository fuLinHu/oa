package com.hacker.oa.service;

import com.hacker.oa.bean.PageResult;
import com.hacker.oa.entity.TUser;

public interface TUserService  {
	
	TUser insert(TUser tUser);
	
	TUser updateByUserId(TUser tUser);
	
	void deleteByUserId(Integer userId);

	TUser getByUserId(Integer userId);
    
	PageResult<TUser> findByTUserWhere(TUser tUserWhere);
	
	PageResult<TUser> findJoinByTUserWhere(TUser tUserWhere);
}