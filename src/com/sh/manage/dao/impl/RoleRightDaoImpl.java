package com.sh.manage.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sh.manage.dao.RoleRightDao;
import com.sh.manage.entity.Right;
import com.sh.manage.entity.Role;
import com.sh.manage.entity.RoleRight;
import com.sh.manage.entity.RoleRightObject;
import com.sh.manage.entity.UserRole;

public class RoleRightDaoImpl implements RoleRightDao {

	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addRoleRight(int roleId, int[] rightIds) {
		Session session = sessionFactory.getCurrentSession();
		for (int i = 0; i < rightIds.length; i++) {
			RoleRight roleRight = new RoleRight();
			roleRight.setRoleId(roleId);
			roleRight.setRightId(rightIds[i]);
			session.save(roleRight);
		}

	}

	public void deleteRoleRight(int roleId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from RoleRight where roleId=:roleId";
		Query query = session.createQuery(hql);
		query.setInteger("roleId", roleId);
		List<RoleRight> roleRights = (List<RoleRight>) query.list();
		for (RoleRight roleRight : roleRights) {
			session.delete(roleRight);
		}

	}

	public List<RoleRightObject> getRoleRight() {
		List<RoleRightObject> roleRightObjects=new ArrayList<RoleRightObject>();
		Session session=sessionFactory.getCurrentSession();
		String hql="from RoleRight";
		String hql1="from Role where roleId=:roleId";
		String hql2="from Right where rightId=:rightId";
		Query query=session.createQuery(hql);
		Query query1=session.createQuery(hql1);
		Query query2=session.createQuery(hql2);
		List<RoleRight> roleRights=query.list();
		for(RoleRight roleRight:roleRights){
			query1.setInteger("roleId", roleRight.getRoleId());
			Role role=(Role)query1.uniqueResult();
			query2.setInteger("rightId", roleRight.getRightId());
			Right right=(Right)query2.uniqueResult();
			RoleRightObject roleRightObject=new RoleRightObject();
			roleRightObject.setRole(role);
			roleRightObject.setRight(right);
			roleRightObjects.add(roleRightObject);
		}
		return roleRightObjects;
	}

	public List<RoleRightObject> getSimpleRoleRight(int roleId) {
		List<RoleRightObject> roleRightObjects=new ArrayList<RoleRightObject>();
		Session session=sessionFactory.getCurrentSession();
		String hql="from RoleRight where roleId=:roleId";
		String hql1="from Role where roleId=:roleId";
		String hql2="from Right where rightId=:rightId";
		Query query=session.createQuery(hql);
		Query query1=session.createQuery(hql1);
		Query query2=session.createQuery(hql2);
		query.setInteger("roleId", roleId);
		List<RoleRight> roleRights=query.list();
		for(RoleRight roleRight:roleRights){
			query1.setInteger("roleId", roleRight.getRoleId());
			Role role=(Role)query1.uniqueResult();
			query2.setInteger("rightId", roleRight.getRightId());
			Right right=(Right)query2.uniqueResult();
			RoleRightObject roleRightObject=new RoleRightObject();
			roleRightObject.setRole(role);
			roleRightObject.setRight(right);
			roleRightObjects.add(roleRightObject);
		}
		return roleRightObjects;
	}
	
}
