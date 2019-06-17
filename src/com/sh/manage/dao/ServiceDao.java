package com.sh.manage.dao;

import java.util.List;
import java.util.Set;

import com.sh.manage.entity.Service;

public interface ServiceDao {
	
	public void addService(Service service);
	
	public void updateService(int serviceId,Service service);
	
	public void deleteService(int serviceId);
	
	public List<Service> getService();
	
	public Set<Service> getSimpleStoreService(int storeId);
	
	public Service getSimpleService(int serviceId);

}
