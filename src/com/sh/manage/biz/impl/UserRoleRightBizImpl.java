package com.sh.manage.biz.impl;

import java.util.List;

import com.sh.manage.biz.UserRoleRightBiz;
import com.sh.manage.dao.UserRoleRightDao;
import com.sh.manage.entity.Right;

public class UserRoleRightBizImpl implements UserRoleRightBiz {

	UserRoleRightDao userRoleRightDao;
	
	public void setUserRoleRightDao(UserRoleRightDao userRoleRightDao) {
		this.userRoleRightDao = userRoleRightDao;
	}

	public List<Right> getUserRight(int userId) {
		
		return userRoleRightDao.getUserRight(userId);
	}

}
