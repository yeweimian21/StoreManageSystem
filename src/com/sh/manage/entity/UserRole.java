package com.sh.manage.entity;

import java.io.Serializable;

public class UserRole implements Serializable {
	
	private int userRoleId;
	private int userId;
	private int roleId;
	
	public UserRole() {
		super();
	}

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
}
