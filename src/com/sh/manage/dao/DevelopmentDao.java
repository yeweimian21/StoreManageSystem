package com.sh.manage.dao;

import java.util.List;
import java.util.Set;

import com.sh.manage.entity.Development;

public interface DevelopmentDao {
	
	public void addDevelopment(Development development);
	
	public void updateDevelopment(int developmentId,Development development);
	
	public void deleteDevelopment(int developmentId);
	
	public List<Development> getDevelopment();
	
	public Set<Development> getSimpleStoreDevelopment(int storeId);
	
	public Development getSimpleDevelopment(int developmentId);

}
