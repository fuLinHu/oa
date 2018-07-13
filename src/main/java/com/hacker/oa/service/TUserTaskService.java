package com.hacker.oa.service;

import com.hacker.oa.entity.TUserTask;
import com.hacker.oa.entity.where.TUserTaskWhere;
import ldh.common.PageResult;

public interface TUserTaskService  {
	
	TUserTask insert(TUserTask tUserTask);
	
	TUserTask updateById(TUserTask tUserTask);
	
	void deleteById(Integer id);

	TUserTask getById(Integer id);
    
	PageResult<TUserTask> findByTUserTaskWhere(TUserTaskWhere tUserTaskWhere);
	
}