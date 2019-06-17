package com.sh.manage.dao;

import java.util.List;

import com.sh.manage.entity.User;
import com.sh.manage.entity.UserRoleObject;

public interface UserRoleDao {

	public void addUserRole(int userId, int[] roleIds);

	public void deleteUserRole(int userId);

	// getUserRole()����Ϊ������е��û���ɫ����
	public List<UserRoleObject> getUserRole();

	// getSimpleUserRole()����Ϊ���ĳһ���û���ɫ����
	public List<UserRoleObject> getSimpleUserRole(int userId);

	// getSimpleRoleUser()����Ϊ���ĳһ��ɫ�������û�
	public List<User> getSimpleRoleUser(String roleName);

}