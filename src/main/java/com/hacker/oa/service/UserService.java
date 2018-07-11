package com.hacker.oa.service;


import com.hacker.oa.entity.User;

public interface UserService {
	User login(String name);
	User getManagerId(String userId);
}
