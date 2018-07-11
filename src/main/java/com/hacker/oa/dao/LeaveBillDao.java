package com.hacker.oa.dao;

import com.hacker.oa.entity.LeaveBill;

import java.util.List;



public interface LeaveBillDao {

	List<LeaveBill> findLeaveBillList();

	void saveLeaveBill(LeaveBill leaveBill);

	LeaveBill findLeaveBillById(String id);

	void updateLeaveBill(LeaveBill leaveBill);

	void deleteLeaveBillById(String id);
}
