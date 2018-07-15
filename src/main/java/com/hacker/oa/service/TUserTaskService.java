package com.hacker.oa.service;

import com.hacker.oa.bean.PageResult;
import com.hacker.oa.entity.TUserTask;


public interface TUserTaskService  {
	
	TUserTask insert(TUserTask tUserTask);
	
	TUserTask updateById(TUserTask tUserTask);
	
	void deleteById(Integer id);

	TUserTask getById(Integer id);
    
	PageResult<TUserTask> findByTUserTaskWhere(TUserTask tUserTaskWhere);
	
}