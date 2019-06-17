package com.sh.manage.biz.impl;

import java.util.List;

import com.sh.manage.biz.RoleBiz;
import com.sh.manage.dao.RoleDao;
import com.sh.manage.entity.Role;

public class RoleBizImpl implements RoleBiz {
	
	RoleDao roleDao;

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public void addRole(Role role) {
		roleDao.addRole(role);

	}

	public void deleteRole(int roleId) {
		roleDao.deleteRole(roleId);

	}

	public List<Role> getRole() {
		
		return roleDao.getRole();
	}

	public void updateRole(int roleId, Role role) {
		roleDao.updateRole(roleId, role);

	}

	public Role getRoleSimpleByRoleName(String roleName) {
		
		return roleDao.getRoleSimpleByRoleName(roleName);
	}

	public Role getSimpleRole(int roleId) {
		
		return roleDao.getSimpleRole(roleId);
	}
	
}
