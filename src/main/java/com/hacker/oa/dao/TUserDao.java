package com.hacker.oa.dao;

import com.hacker.oa.entity.TUser;
import com.hacker.oa.entity.where.TUserWhere;
import java.util.List;

public interface TUserDao  {

	Integer insert(TUser tUser);
	
    Integer updateByUserId(TUser tUser);
	
	Integer deleteByUserId(Integer userId);

	TUser getByUserId(Integer userId);
    
	List<TUser> findByTUserWhere(TUserWhere tUserWhere);
	
	Long findTotalByTUserWhere(TUserWhere tUserWhere);
	
	List<TUser> findJoinByTUserWhere(TUserWhere tUserWhere);
	
	Long findJoinTotalByTUserWhere(TUserWhere tUserWhere);
	
}