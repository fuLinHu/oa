package com.hacker.oa.service;

import com.hacker.oa.entity.SuperviseReceive;
import com.hacker.oa.entity.where.SuperviseReceiveWhere;
import ldh.common.PageResult;

public interface SuperviseReceiveService  {
	
	SuperviseReceive insert(SuperviseReceive superviseReceive);
	
	SuperviseReceive updateById(SuperviseReceive superviseReceive);
	
	void deleteById(Integer id);

	SuperviseReceive getById(Integer id);
    
	PageResult<SuperviseReceive> findBySuperviseReceiveWhere(SuperviseReceiveWhere superviseReceiveWhere);
	
}