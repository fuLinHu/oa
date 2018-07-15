package com.hacker.oa.dao;

import com.hacker.oa.entity.TUser;
import java.util.List;

public interface TUserDao  {

	Integer insert(TUser tUser);
	
    Integer updateByUserId(TUser tUser);
	
	Integer deleteByUserId(Integer userId);

	TUser getByUserId(Integer userId);
    
	List<TUser> findByTUserWhere(TUser tUserWhere);
	
	Long findTotalByTUserWhere(TUser tUserWhere);
	
	List<TUser> findJoinByTUserWhere(TUser tUserWhere);
	
	Long findJoinTotalByTUserWhere(TUser tUserWhere);
	
}