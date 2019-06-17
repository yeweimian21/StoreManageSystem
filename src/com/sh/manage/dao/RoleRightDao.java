package com.sh.manage.dao;

import java.util.List;
import java.util.Map;

import com.sh.manage.entity.Right;
import com.sh.manage.entity.Role;
import com.sh.manage.entity.RoleRightObject;

public interface RoleRightDao {

	public void addRoleRight(int roleId, int[] rightIds);

	public void deleteRoleRight(int roleId);
	
	//getRoleRight()方法为获得所有的角色权限对象
	public List<RoleRightObject> getRoleRight();
	
	//getSimpleRoleRight()方法为获得某一的角色权限对象
	public List<RoleRightObject> getSimpleRoleRight(int roleId);
	
}
