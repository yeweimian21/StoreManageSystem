package com.sh.manage.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sh.manage.dao.UserRoleDao;
import com.sh.manage.entity.Role;
import com.sh.manage.entity.User;
import com.sh.manage.entity.UserRole;
import com.sh.manage.entity.UserRoleObject;

public class UserRoleDaoImpl implements UserRoleDao {

	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void deleteUserRole(int userId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from UserRole where userId=:userId";
		Query query = session.createQuery(hql);
		query.setInteger("userId", userId);
		List<UserRole> userRoles = (List<UserRole>) query.list();
		for (UserRole userRole : userRoles) {
			session.delete(userRole);
		}

	}

	// 因为一次只添加一个用户的角色，所以不需要用Map<Integer,int[]>
	public void addUserRole(int userId, int[] roleIds) {
		Session session = sessionFactory.getCurrentSession();
		for (int i = 0; i < roleIds.length; i++) {
			UserRole userRole = new UserRole();
			userRole.setUserId(userId);
			userRole.setRoleId(roleIds[i]);
			session.save(userRole);
		}

	}

	public List<User> getSimpleRoleUser(String roleName) {
		List<User> users = new ArrayList<User>();
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Role where roleName=:roleName";
		String hql1 = "from UserRole where roleId=:roleId";
		String hql2 = "from User where userId=:userId";
		Query query = session.createQuery(hql);
		Query query1 = session.createQuery(hql1);
		Query query2 = session.createQuery(hql2);
		query.setString("roleName", roleName);
		Role role=(Role)query.uniqueResult();
		query1.setInteger("roleId", role.getRoleId());
		List<UserRole> userRoles=query1.list();
		for (UserRole userRole : userRoles) {
			query2.setInteger("userId", userRole.getUserId());
			User user=(User)query2.uniqueResult();
			users.add(user);
		}
		return users;
	}

	public List<UserRoleObject> getUserRole() {
		List<UserRoleObject> userRoleObjects = new ArrayList<UserRoleObject>();
		Session session = sessionFactory.getCurrentSession();
		String hql = "from UserRole";
		String hql1 = "from User where userId=:userId";
		String hql2 = "from Role where roleId=:roleId";
		Query query = session.createQuery(hql);
		Query query1 = session.createQuery(hql1);
		Query query2 = session.createQuery(hql2);
		List<UserRole> userRoles = query.list();
		for (UserRole userRole : userRoles) {
			query1.setInteger("userId", userRole.getUserId());
			User user = (User) query1.uniqueResult();
			query2.setInteger("roleId", userRole.getRoleId());
			Role role = (Role) query2.uniqueResult();
			UserRoleObject userRoleObject = new UserRoleObject();
			userRoleObject.setUser(user);
			userRoleObject.setRole(role);
			userRoleObjects.add(userRoleObject);
		}
		return userRoleObjects;
	}

	public List<UserRoleObject> getSimpleUserRole(int userId) {
		List<UserRoleObject> userRoleObjects = new ArrayList<UserRoleObject>();
		Session session = sessionFactory.getCurrentSession();
		String hql = "from UserRole where userId=:userId";
		String hql1 = "from User where userId=:userId";
		String hql2 = "from Role where roleId=:roleId";
		Query query = session.createQuery(hql);
		Query query1 = session.createQuery(hql1);
		Query query2 = session.createQuery(hql2);
		query.setInteger("userId", userId);
		List<UserRole> userRoles = query.list();
		for (UserRole userRole : userRoles) {
			query1.setInteger("userId", userRole.getUserId());
			User user = (User) query1.uniqueResult();
			query2.setInteger("roleId", userRole.getRoleId());
			Role role = (Role) query2.uniqueResult();
			UserRoleObject userRoleObject = new UserRoleObject();
			userRoleObject.setUser(user);
			userRoleObject.setRole(role);
			userRoleObjects.add(userRoleObject);
		}
		return userRoleObjects;
	}

}
