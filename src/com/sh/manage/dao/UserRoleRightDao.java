package com.sh.manage.dao;

import java.util.List;

import com.sh.manage.entity.Right;

public interface UserRoleRightDao {

	public List<Right> getUserRight(int userId);
	
}
