package com.hacker.oa.service;

import com.hacker.oa.entity.TUser;
import com.hacker.oa.entity.where.TUserWhere;
import ldh.common.PageResult;

public interface TUserService  {
	
	TUser insert(TUser tUser);
	
	TUser updateByUserId(TUser tUser);
	
	void deleteByUserId(Integer userId);

	TUser getByUserId(Integer userId);
    
	PageResult<TUser> findByTUserWhere(TUserWhere tUserWhere);
	
	PageResult<TUser> findJoinByTUserWhere(TUserWhere tUserWhere);
}