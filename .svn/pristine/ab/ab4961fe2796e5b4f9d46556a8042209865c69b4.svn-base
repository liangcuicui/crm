package com.crm.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.crm.dao.UserDao;
import com.crm.domain.User;
import com.crm.service.UserService;
import com.crm.utils.MD5Util;
@Transactional
public class UserServiceImpl implements UserService{

	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void regist(User user) {
		//对密码进行加密
		user.setUser_password(MD5Util.md5(user.getUser_password()));
		user.setUser_state("1");
		userDao.regist(user);
		
	}

	@Override
	public User login(User user) {
		user.setUser_password(MD5Util.md5(user.getUser_password()));
		
		return userDao.login(user);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}
	
}
