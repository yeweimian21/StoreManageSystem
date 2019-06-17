package com.sh.manage.biz.impl;

import java.util.List;

import com.sh.manage.biz.RightBiz;
import com.sh.manage.dao.RightDao;
import com.sh.manage.entity.Right;

public class RightBizImpl implements RightBiz {
	
	RightDao rightDao;

	public void setRightDao(RightDao rightDao) {
		this.rightDao = rightDao;
	}

	public void addRight(Right right) {
		rightDao.addRight(right);

	}

	public void deleteRight(int rightId) {
		rightDao.deleteRight(rightId);

	}

	public List<Right> getRight() {
		
		return rightDao.getRight();
	}

	public void updateRight(int rightId, Right right) {
		rightDao.updateRight(rightId, right);

	}

	public Right getSimpleRight(int rightId) {
		
		return rightDao.getSimpleRight(rightId);
	}

}
