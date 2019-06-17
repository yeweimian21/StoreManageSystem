package com.sh.manage.biz.impl;

import java.util.List;
import java.util.Set;

import com.sh.manage.biz.ServiceBiz;
import com.sh.manage.dao.ServiceDao;
import com.sh.manage.entity.Service;

public class ServiceBizImpl implements ServiceBiz {
	
	ServiceDao serviceDao;

	public void setServiceDao(ServiceDao serviceDao) {
		this.serviceDao = serviceDao;
	}

	public void addService(Service service) {
		serviceDao.addService(service);

	}

	public void deleteService(int serviceId) {
		serviceDao.deleteService(serviceId);

	}

	public List<Service> getService() {
		
		return serviceDao.getService();
	}

	public void updateService(int serviceId, Service service) {
		serviceDao.updateService(serviceId, service);

	}

	public Service getSimpleService(int serviceId) {
		
		return serviceDao.getSimpleService(serviceId);
	}

	public Set<Service> getSimpleStoreService(int storeId) {
		
		return serviceDao.getSimpleStoreService(storeId);
	}

}
