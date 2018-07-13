package com.hacker.oa.dao;

import com.hacker.oa.entity.TUserTask;
import com.hacker.oa.entity.where.TUserTaskWhere;
import java.util.List;

public interface TUserTaskDao  {

	Integer insert(TUserTask tUserTask);
	
    Integer updateById(TUserTask tUserTask);
	
	Integer deleteById(Integer id);

	TUserTask getById(Integer id);
    
	List<TUserTask> findByTUserTaskWhere(TUserTaskWhere tUserTaskWhere);
	
	Long findTotalByTUserTaskWhere(TUserTaskWhere tUserTaskWhere);
	
	
}