package com.sh.manage.dao;

import java.util.List;

import com.sh.manage.entity.Right;

public interface RightDao {
	
	public void addRight(Right right);
	
	public void updateRight(int rightId,Right right);
	
	public void deleteRight(int rightId);
	
	public List<Right> getRight();
	
	// getSimpleRight()方法为根据rightId获得Right对象
	public Right getSimpleRight(int rightId);

}
