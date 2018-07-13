package com.hacker.oa.service.impl;

import com.hacker.oa.dao.SuperviseReceiveDao;
import com.hacker.oa.entity.SuperviseReceive;
import com.hacker.oa.entity.where.SuperviseReceiveWhere;
import com.hacker.oa.service.SuperviseReceiveService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import ldh.common.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("superviseReceiveService")
public class SuperviseReceiveServiceImpl implements SuperviseReceiveService {

	@Resource
	private SuperviseReceiveDao superviseReceiveDao;
	
	@Override
	@Transactional
	public SuperviseReceive insert(SuperviseReceive superviseReceive) {
		superviseReceiveDao.insert(superviseReceive);
		return superviseReceive;
	}
	
	@Override
	@Transactional
	public SuperviseReceive updateById(SuperviseReceive superviseReceive) {
		superviseReceiveDao.updateById(superviseReceive);
		return superviseReceive;
	}
	
	@Override
	@Transactional
	public void deleteById(Integer id) {
	superviseReceiveDao.deleteById(id);
	}

	public SuperviseReceive getById(Integer id) {
		SuperviseReceive superviseReceive = superviseReceiveDao.getById(id);
		return superviseReceive;
    }
    
	
	@Override
	@Transactional(readOnly = true)
	/*public PageResult<SuperviseReceive> findBySuperviseReceiveWhere(SuperviseReceiveWhere superviseReceiveWhere) {
		long total = superviseReceiveDao.findTotalBySuperviseReceiveWhere(superviseReceiveWhere);
		List<SuperviseReceive> imageList = new ArrayList<SuperviseReceive>();
		if (total > 0) {
			imageList  = superviseReceiveDao.findBySuperviseReceiveWhere(superviseReceiveWhere);
		}
		
		return new PageResult<SuperviseReceive>(superviseReceiveWhere, total, imageList);
	}*/
	
	
}