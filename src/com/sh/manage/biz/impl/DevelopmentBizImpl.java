package com.sh.manage.biz.impl;

import java.util.List;
import java.util.Set;

import com.sh.manage.biz.DevelopmentBiz;
import com.sh.manage.dao.DevelopmentDao;
import com.sh.manage.entity.Development;

public class DevelopmentBizImpl implements DevelopmentBiz {
	
	DevelopmentDao developmentDao;

	public void setDevelopmentDao(DevelopmentDao developmentDao) {
		this.developmentDao = developmentDao;
	}

	public void addDevelopment(Development development) {
		developmentDao.addDevelopment(development);

	}

	public void deleteDevelopment(int developmentId) {
		developmentDao.deleteDevelopment(developmentId);

	}

	public List<Development> getDevelopment() {
		
		return developmentDao.getDevelopment();
	}

	public void updateDevelopment(int developmentId, Development development) {
		developmentDao.updateDevelopment(developmentId, development);

	}

	public Development getSimpleDevelopment(int developmentId) {
		
		return developmentDao.getSimpleDevelopment(developmentId);
	}

	public Set<Development> getSimpleStoreDevelopment(int storeId) {
		
		return developmentDao.getSimpleStoreDevelopment(storeId);
	}

}
