package com.sh.manage.biz.impl;

import java.util.List;
import java.util.Map;

import com.sh.manage.biz.RoleRightBiz;
import com.sh.manage.dao.RoleRightDao;
import com.sh.manage.entity.Right;
import com.sh.manage.entity.Role;
import com.sh.manage.entity.RoleRightObject;

public class RoleRightBizImpl implements RoleRightBiz {
	
	RoleRightDao roleRightDao;

	public void setRoleRightDao(RoleRightDao roleRightDao) {
		this.roleRightDao = roleRightDao;
	}

	public void addRoleRight(int roleId, int[] rightIds) {
		roleRightDao.addRoleRight(roleId, rightIds);

	}

	public void deleteRoleRight(int roleId) {
		roleRightDao.deleteRoleRight(roleId);

	}

	public List<RoleRightObject> getRoleRight() {
		
		return roleRightDao.getRoleRight();
	}

	public List<RoleRightObject> getSimpleRoleRight(int roleId) {
		
		return roleRightDao.getSimpleRoleRight(roleId);
	}

}
