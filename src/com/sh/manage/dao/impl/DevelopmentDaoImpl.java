package com.sh.manage.dao.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sh.manage.dao.DevelopmentDao;
import com.sh.manage.entity.Development;
import com.sh.manage.entity.Store;

public class DevelopmentDaoImpl implements DevelopmentDao {

	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addDevelopment(Development development) {
		Session session = sessionFactory.getCurrentSession();
		session.save(development);

	}

	public void deleteDevelopment(int developmentId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Development where developmentId=:developmentId";
		Query query = session.createQuery(hql);
		query.setInteger("developmentId", developmentId);
		Development development = (Development) query.uniqueResult();
		session.delete(development);

	}

	public List<Development> getDevelopment() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Development";
		Query query = session.createQuery(hql);
		List<Development> developments = query.list();
		return developments;
	}

	public void updateDevelopment(int developmentId, Development development) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Development where developmentId=:developmentId";
		Query query = session.createQuery(hql);
		query.setInteger("developmentId", developmentId);
		Development development2 = (Development) query.uniqueResult();
		development2.setDevelopmentType(development.getDevelopmentType());
		
		development2.setStore(development.getStore());
		development2.setStoreIdSelf(development.getStoreIdSelf());
		
		development2.setDevelopmentTitle(development.getDevelopmentTitle());
		development2.setDevelopmentContent(development.getDevelopmentContent());
		session.update(development2);
	}

	public Development getSimpleDevelopment(int developmentId) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Development where developmentId=:developmentId";
		Query query=session.createQuery(hql);
		query.setInteger("developmentId", developmentId);
		Development development=(Development)query.uniqueResult();
		return development;
	}

	public Set<Development> getSimpleStoreDevelopment(int storeId) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Store where storeId=:storeId";
		Query query=session.createQuery(hql);
		query.setInteger("storeId", storeId);
		Store store=(Store)query.uniqueResult();
		Set<Development> developments=store.getDevelopments();
		return developments;
	}

}
