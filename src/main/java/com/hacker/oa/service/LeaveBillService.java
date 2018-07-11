package com.hacker.oa.service;

import com.hacker.oa.entity.LeaveBill;

import java.util.List;


public interface LeaveBillService {
	
	List<LeaveBill> findLeaveBillList();

	void saveLeaveBill(LeaveBill leaveBill);

	LeaveBill findLeaveBillById(String id);

	void deleteLeaveBillById(String id);

}
