package com.sh.manage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sh.manage.dao.UserRoleRightDao;
import com.sh.manage.entity.Right;
import com.sh.manage.entity.RoleRight;
import com.sh.manage.entity.UserRole;

public class UserRoleRightDaoImpl implements UserRoleRightDao {

	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Right> getUserRight(int userId) {
		List<Right> rights=new ArrayList<Right>();
		Session session=sessionFactory.getCurrentSession();
		String hql="from UserRole where userId=:userId";
		String hql1="from RoleRight where roleId=:roleId";
		String hql2="from Right where rightId=:rightId";
		Query query=session.createQuery(hql);
		Query query1=session.createQuery(hql1);
		Query query2=session.createQuery(hql2);
		query.setInteger("userId", userId);
		List<UserRole> userRoles=query.list();
		for(UserRole userRole:userRoles){
			query1.setInteger("roleId", userRole.getRoleId());
			List<RoleRight> roleRights=query1.list();
			for(RoleRight roleRight:roleRights){
				query2.setInteger("rightId", roleRight.getRightId());
				Right right=(Right)query2.uniqueResult();
				rights.add(right);
			}
		}
		return rights;
	}

}
