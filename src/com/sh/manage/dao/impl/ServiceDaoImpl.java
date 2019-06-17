package com.sh.manage.dao.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sh.manage.dao.ServiceDao;
import com.sh.manage.entity.Service;
import com.sh.manage.entity.Store;

public class ServiceDaoImpl implements ServiceDao {

	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addService(Service service) {
		Session session = sessionFactory.getCurrentSession();
		session.save(service);

	}

	public void deleteService(int serviceId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Service where serviceId=:serviceId";
		Query query = session.createQuery(hql);
		query.setInteger("serviceId", serviceId);
		Service service = (Service) query.uniqueResult();
		session.delete(service);

	}

	public List<Service> getService() {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Service";
		Query query=session.createQuery(hql);
		List<Service> services=query.list();
		return services;
	}

	public void updateService(int serviceId, Service service) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Service where serviceId=:serviceId";
		Query query = session.createQuery(hql);
		query.setInteger("serviceId", serviceId);
		Service service2 = (Service) query.uniqueResult();
		service2.setServiceName(service.getServiceName());
		
		service2.setStore(service.getStore());
		service2.setStoreIdSelf(service.getStoreIdSelf());
		
		service2.setServiceCheap(service.getServiceCheap());
		service2.setBeforePrice(service.getBeforePrice());
		service2.setAfterPrice(service.getAfterPrice());
		service2.setCostTime(service.getCostTime());
		session.update(service2);

	}

	public Service getSimpleService(int serviceId) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Service where serviceId=:serviceId";
		Query query=session.createQuery(hql);
		query.setInteger("serviceId", serviceId);
		Service service=(Service)query.uniqueResult();
		return service;
	}

	public Set<Service> getSimpleStoreService(int storeId) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Store where storeId=:storeId";
		Query query=session.createQuery(hql);
		query.setInteger("storeId", storeId);
		Store store=(Store)query.uniqueResult();
		Set<Service> services=store.getServices();
		return services;
	}


}
