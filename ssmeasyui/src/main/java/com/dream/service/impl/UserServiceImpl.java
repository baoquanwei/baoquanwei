package com.dream.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.dream.dao.UserMapper;
import com.dream.model.User;
import com.dream.service.UserService;
import com.pageModel.DataGrid;
import com.pageModel.PageHelper;

public class UserServiceImpl implements UserService {
	
	
	@Autowired
	private UserMapper userMapper;
	

	public int addUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	public DataGrid getAllUser(PageHelper pg) {
		// TODO Auto-generated method stub
		return null;
	}

	public User checkUsername(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public int deleteUser(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public User getUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateUser(User u) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
