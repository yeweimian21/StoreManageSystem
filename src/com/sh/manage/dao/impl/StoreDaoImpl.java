package com.sh.manage.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sh.manage.dao.StoreDao;
import com.sh.manage.entity.Store;

public class StoreDaoImpl implements StoreDao {

	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void deleteStore(int storeId) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Store where storeId=:storeId";
		Query query=session.createQuery(hql);
		query.setInteger("storeId", storeId);
		Store store=(Store) query.uniqueResult();
		session.delete(store);

	}

	public List<Store> getStore() {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Store";
		Query query=session.createQuery(hql);
		List<Store> stores=query.list();
		return stores;
	}

	public void updateStore(int storeId, Store store) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Store where storeId=:storeId";
		Query query=session.createQuery(hql);
		query.setInteger("storeId", storeId);
		Store store2=(Store) query.uniqueResult();
		store2.setStoreName(store.getStoreName());
		
		store2.setManagerName(store.getManagerName());
		store2.setManagerId(store.getManagerId());
		
		store2.setStoreAddress(store.getStoreAddress());
		store2.setStorePhone(store.getStorePhone());
		session.update(store2);

	}

	public void addStore(Store store) {
		Session session=sessionFactory.getCurrentSession();
		session.save(store);
		
	}

	public Store getSimpleStore(int storeId) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Store where storeId=:storeId";
		Query query=session.createQuery(hql);
		query.setInteger("storeId", storeId);
		Store store=(Store)query.uniqueResult();
		return store;
	}

	public Store getSimpleStoreByManageId(int managerId) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Store where managerId=:managerId";
		Query query=session.createQuery(hql);
		query.setInteger("managerId", managerId);
		Store store=(Store)query.uniqueResult();
		return store;
	}

}
