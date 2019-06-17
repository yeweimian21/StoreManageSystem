package com.sh.manage.biz.impl;

import java.util.List;
import java.util.Map;

import com.sh.manage.biz.UserRoleBiz;
import com.sh.manage.dao.UserRoleDao;
import com.sh.manage.entity.Role;
import com.sh.manage.entity.User;
import com.sh.manage.entity.UserRole;
import com.sh.manage.entity.UserRoleObject;

public class UserRoleBizImpl implements UserRoleBiz {

	UserRoleDao userRoleDao;

	public void setUserRoleDao(UserRoleDao userRoleDao) {
		this.userRoleDao = userRoleDao;
	}

	public void addUserRole(int userId, int[] roleIds) {
		userRoleDao.addUserRole(userId, roleIds);

	}

	public void deleteUserRole(int userId) {
		userRoleDao.deleteUserRole(userId);

	}

	public List<User> getSimpleRoleUser(String roleName) {

		return userRoleDao.getSimpleRoleUser(roleName);
	}

	public List<UserRoleObject> getUserRole() {

		return userRoleDao.getUserRole();
	}

	public List<UserRoleObject> getSimpleUserRole(int userId) {

		return userRoleDao.getSimpleUserRole(userId);
	}

}
