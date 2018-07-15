package com.hacker.oa.service;

import com.hacker.oa.bean.PageResult;
import com.hacker.oa.entity.SuperviseReceive;


public interface SuperviseReceiveService  {
	
	SuperviseReceive insert(SuperviseReceive superviseReceive);
	
	SuperviseReceive updateById(SuperviseReceive superviseReceive);
	
	void deleteById(Integer id);

	SuperviseReceive getById(Integer id);
    
	PageResult<SuperviseReceive> findBySuperviseReceiveWhere(SuperviseReceive superviseReceiveWhere);
	
}