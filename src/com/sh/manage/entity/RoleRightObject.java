package com.sh.manage.entity;

import java.io.Serializable;

public class RoleRightObject implements Serializable {
	
	private Role role;
	private Right right;
	
	public RoleRightObject() {
		super();
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Right getRight() {
		return right;
	}

	public void setRight(Right right) {
		this.right = right;
	}

}
