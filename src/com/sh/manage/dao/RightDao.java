package com.sh.manage.dao;

import java.util.List;

import com.sh.manage.entity.Right;

public interface RightDao {
	
	public void addRight(Right right);
	
	public void updateRight(int rightId,Right right);
	
	public void deleteRight(int rightId);
	
	public List<Right> getRight();
	
	// getSimpleRight()����Ϊ����rightId���Right����
	public Right getSimpleRight(int rightId);

}
