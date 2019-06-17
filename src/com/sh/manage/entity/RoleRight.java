package com.sh.manage.entity;

import java.io.Serializable;

public class RoleRight implements Serializable {
	
	private int roleRightId;
	private int roleId;
	private int rightId;
	
	public RoleRight() {
		super();
	}

	public int getRoleRightId() {
		return roleRightId;
	}

	public void setRoleRightId(int roleRightId) {
		this.roleRightId = roleRightId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getRightId() {
		return rightId;
	}

	public void setRightId(int rightId) {
		this.rightId = rightId;
	}

}
