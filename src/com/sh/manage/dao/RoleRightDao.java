package com.sh.manage.dao;

import java.util.List;
import java.util.Map;

import com.sh.manage.entity.Right;
import com.sh.manage.entity.Role;
import com.sh.manage.entity.RoleRightObject;

public interface RoleRightDao {

	public void addRoleRight(int roleId, int[] rightIds);

	public void deleteRoleRight(int roleId);
	
	//getRoleRight()����Ϊ������еĽ�ɫȨ�޶���
	public List<RoleRightObject> getRoleRight();
	
	//getSimpleRoleRight()����Ϊ���ĳһ�Ľ�ɫȨ�޶���
	public List<RoleRightObject> getSimpleRoleRight(int roleId);
	
}
