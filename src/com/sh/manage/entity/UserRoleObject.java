package com.sh.manage.entity;

import java.io.Serializable;

public class UserRoleObject implements Serializable {

	private User user;
	private Role role;
	
	public UserRoleObject() {
		super();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
}
