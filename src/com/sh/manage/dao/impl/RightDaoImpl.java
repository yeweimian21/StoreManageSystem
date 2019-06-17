package com.sh.manage.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sh.manage.dao.RightDao;
import com.sh.manage.entity.Right;
import com.sh.manage.entity.RoleRight;

public class RightDaoImpl implements RightDao {
	
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addRight(Right right) {
		Session session=sessionFactory.getCurrentSession();
		session.save(right);

	}

	public void deleteRight(int rightId) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Right where rightId=:rightId";
		Query query=session.createQuery(hql);
		query.setInteger("rightId", rightId);
		Right right=(Right)query.uniqueResult();
		session.delete(right);
		String hql1="from RoleRight where rightId=:rightId";
		query=session.createQuery(hql1);
		query.setInteger("rightId", rightId);
		List<RoleRight> roleRights=query.list();
		for(RoleRight roleRight:roleRights){
			session.delete(roleRight);
		}

	}

	public List<Right> getRight() {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Right";
		Query query=session.createQuery(hql);
		List<Right> rights=query.list();
		return rights;
	}

	public void updateRight(int rightId, Right right) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Right where rightId=:rightId";
		Query query=session.createQuery(hql);
		query.setInteger("rightId", rightId);
		Right right2=(Right)query.uniqueResult();
		right2.setRightName(right.getRightName());
		session.update(right2);

	}

	public Right getSimpleRight(int rightId) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Right where rightId=:rightId";
		Query query=session.createQuery(hql);
		query.setInteger("rightId", rightId);
		Right right=(Right)query.uniqueResult();
		return right;
	}

}
