package com.sh.manage.dao;

import java.util.List;

import com.sh.manage.entity.Role;

public interface RoleDao {

	public void addRole(Role role);

	public void updateRole(int roleId, Role role);

	public void deleteRole(int roleId);

	public List<Role> getRole();
	
	// getSimpleRole()����Ϊ����roleId���Role����
	public Role getSimpleRole(int roleId);

	// getRoleSimpleByRoleName()����Ϊ����roleName���Role����
	public Role getRoleSimpleByRoleName(String roleName);
	
}
