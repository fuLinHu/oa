package com.hacker.oa.service.impl;

import com.hacker.oa.dao.UserDao;
import com.hacker.oa.entity.User;
import com.hacker.oa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;


	@Override
	public User login(String name) {
		return userDao.findUserByName(name);
		
	}
	@Override
	public User getManagerId(String userId) {
		return userDao.findManager(userId);
	}

}
