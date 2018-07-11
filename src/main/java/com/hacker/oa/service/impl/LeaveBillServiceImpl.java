package com.hacker.oa.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.hacker.oa.constant.LeaveBillConstant;
import com.hacker.oa.dao.LeaveBillDao;
import com.hacker.oa.entity.LeaveBill;
import com.hacker.oa.service.LeaveBillService;
import com.hacker.oa.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LeaveBillServiceImpl implements LeaveBillService {

	@Autowired
	private LeaveBillDao leaveBillDao;
	@Override
	public List<LeaveBill> findLeaveBillList() {
		return leaveBillDao.findLeaveBillList();
	}

	@Override
	public void saveLeaveBill(LeaveBill leaveBill) {
		//获取请假单ID
				String id = leaveBill.getId();
				/**新增保存*/
				if(id == null){
					//1：从Session中获取当前用户对象，将LeaveBill对象中user与Session中获取的用户对象进行关联
					leaveBill.setUser(SessionUtil.get());//建立关联关系
					//2：保存请假单表，添加一条数据
					leaveBill.setId(UUID.randomUUID().toString());
					leaveBill.setUserId(SessionUtil.get().getId());
					leaveBill.setState(LeaveBillConstant.START_ENTRY);
					leaveBill.setLeaveDate(new Date());
					leaveBillDao.saveLeaveBill(leaveBill);
				}
				/**更新保存*/
				else{
					//1：执行update的操作，完成更新
					leaveBillDao.updateLeaveBill(leaveBill);
				}
	}

	@Override
	public LeaveBill findLeaveBillById(String id) {
		return null;
	}

	@Override
	public void deleteLeaveBillById(String id) {
		
	}

}
