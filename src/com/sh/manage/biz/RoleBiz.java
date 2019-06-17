package com.sh.manage.biz;

import java.util.List;

import com.sh.manage.entity.Role;

public interface RoleBiz {

	public void addRole(Role role);

	public void updateRole(int roleId, Role role);

	public void deleteRole(int roleId);

	public List<Role> getRole();
	
	// getSimpleRole()方法为根据roleId获得Role对象
	public Role getSimpleRole(int roleId);

	// getRoleSimpleByRoleName()方法为根据roleName获得Role对象
	public Role getRoleSimpleByRoleName(String roleName);
	
}
