package com.hacker.oa.dao;


import com.hacker.oa.entity.User;

public interface UserDao {
	User findUserByName(String username);
	User findManager(String username);
	User findBoss();
}
