package com.hacker.oa.dao;

import com.hacker.oa.entity.SuperviseReceive;
/*import com.hacker.oa.entity.where.SuperviseReceiveWhere;*/
import java.util.List;

public interface SuperviseReceiveDao  {

	Integer insert(SuperviseReceive superviseReceive);
	
    Integer updateById(SuperviseReceive superviseReceive);
	
	Integer deleteById(Integer id);

	SuperviseReceive getById(Integer id);
    
	/*List<SuperviseReceive> findBySuperviseReceiveWhere(SuperviseReceiveWhere superviseReceiveWhere);
	
	Long findTotalBySuperviseReceiveWhere(SuperviseReceiveWhere superviseReceiveWhere);*/
	
	
}