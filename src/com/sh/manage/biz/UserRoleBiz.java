package com.sh.manage.biz;

import java.util.List;
import java.util.Map;

import com.sh.manage.entity.Role;
import com.sh.manage.entity.User;
import com.sh.manage.entity.UserRole;
import com.sh.manage.entity.UserRoleObject;

public interface UserRoleBiz {

	public void addUserRole(int userId, int[] roleIds);

	public void deleteUserRole(int userId);

	//getUserRole()方法为获得所有的用户角色对象
	public List<UserRoleObject> getUserRole();
	
	// getSimpleUserRole()方法为获得某一的用户角色对象
	public List<UserRoleObject> getSimpleUserRole(int userId);

	// getSimpleRoleUser()方法为获得某一角色的所有用户
	public List<User> getSimpleRoleUser(String roleName);

}
