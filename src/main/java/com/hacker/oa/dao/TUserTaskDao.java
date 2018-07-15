package com.hacker.oa.dao;

import com.hacker.oa.entity.TUserTask;
import java.util.List;

public interface TUserTaskDao  {

	Integer insert(TUserTask tUserTask);
	
    Integer updateById(TUserTask tUserTask);
	
	Integer deleteById(Integer id);

	TUserTask getById(Integer id);
    
	List<TUserTask> findByTUserTaskWhere(TUserTask tUserTaskWhere);
	
	Long findTotalByTUserTaskWhere(TUserTask tUserTaskWhere);
	
	
}