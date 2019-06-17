package com.sh.manage.biz;

import java.util.List;

import com.sh.manage.entity.Right;

public interface UserRoleRightBiz {

	public List<Right> getUserRight(int userId);
	
}
