package com.sh.manage.biz.impl;

import java.util.List;

import com.sh.manage.biz.UserBiz;
import com.sh.manage.dao.UserDao;
import com.sh.manage.entity.User;

public class UserBizImpl implements UserBiz {
	
	UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public boolean loginUser(User user) {
		
		return userDao.loginUser(user);
	}

	public void addUser(User user) {
		userDao.addUser(user);
		
	}

	public void deleteUser(int userId) {
		userDao.deleteUser(userId);
		
	}

	public List<User> getUser() {
		
		return userDao.getUser();
	}

	public void updateUser(int userId, User user) {
		userDao.updateUser(userId, user);
		
	}

	public User getSimpleUser(int userId) {
		
		return userDao.getSimpleUser(userId);
	}

	public int getUserId(String userName, String password) {
		
		return userDao.getUserId(userName, password);
	}

}
