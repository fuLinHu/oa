package com.hacker.oa.service.impl;

import com.hacker.oa.dao.TUserTaskDao;
import com.hacker.oa.entity.TUserTask;
import com.hacker.oa.entity.where.TUserTaskWhere;
import com.hacker.oa.service.TUserTaskService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import ldh.common.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("tUserTaskService")
public class TUserTaskServiceImpl implements TUserTaskService {

	@Resource
	private TUserTaskDao tUserTaskDao;
	
	@Override
	@Transactional
	public TUserTask insert(TUserTask tUserTask) {
		tUserTaskDao.insert(tUserTask);
		return tUserTask;
	}
	
	@Override
	@Transactional
	public TUserTask updateById(TUserTask tUserTask) {
		tUserTaskDao.updateById(tUserTask);
		return tUserTask;
	}
	
	@Override
	@Transactional
	public void deleteById(Integer id) {
	tUserTaskDao.deleteById(id);
	}

	public TUserTask getById(Integer id) {
		TUserTask tUserTask = tUserTaskDao.getById(id);
		return tUserTask;
    }
    
	
	@Override
	@Transactional(readOnly = true)
	public PageResult<TUserTask> findByTUserTaskWhere(TUserTaskWhere tUserTaskWhere) {
		long total = tUserTaskDao.findTotalByTUserTaskWhere(tUserTaskWhere);
		List<TUserTask> imageList = new ArrayList<TUserTask>();
		if (total > 0) {
			imageList  = tUserTaskDao.findByTUserTaskWhere(tUserTaskWhere);
		}
		
		return new PageResult<TUserTask>(tUserTaskWhere, total, imageList);
	}
	
	
}