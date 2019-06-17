package com.sh.manage.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sh.manage.dao.UserDao;
import com.sh.manage.entity.User;
import com.sh.manage.entity.UserRole;

public class UserDaoImpl implements UserDao {
	
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean loginUser(User user) {
		boolean flag=false;
		Session session=sessionFactory.getCurrentSession();
		String hql="from User where username=:username and password=:password";
		Query query=session.createQuery(hql);
		query.setString("username", user.getUserName());
		query.setString("password", user.getPassword());
		List<User> list=query.list();
		if(list!=null&&list.size()>0){
			flag=true;
		}else{
			flag=false;
		}
		return flag;
	}

	public void addUser(User user) {
		Session session=sessionFactory.getCurrentSession();
		session.save(user);
		
	}

	public void deleteUser(int userId) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from User where userId=:userId";
		Query query=session.createQuery(hql);
		query.setInteger("userId", userId);
		User user=(User)query.uniqueResult();
		session.delete(user);
		String hql1="from UserRole where userId=:userId";
		query=session.createQuery(hql1);
		query.setInteger("userId", userId);
		List<UserRole> userRoles=query.list();
		for(UserRole userRole:userRoles){
			session.delete(userRole);
		}
		
	}

	public List<User> getUser() {
		Session session=sessionFactory.getCurrentSession();
		String hql="from User";
		Query query=session.createQuery(hql);
		List<User> users=query.list();
		return users;
	}

	public void updateUser(int userId, User user) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from User where userId=:userId";
		Query query=session.createQuery(hql);
		query.setInteger("userId", userId);
		User user2=(User)query.uniqueResult();
		user2.setUserName(user.getUserName());
		user2.setPassword(user.getPassword());
		user2.setSex(user.getSex());
		user2.setAge(user.getAge());
		user2.setPhone(user.getPhone());
		user2.setEmail(user.getEmail());
		session.update(user2);
		
	}

	public User getSimpleUser(int userId) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from User where userId=:userId";
		Query query=session.createQuery(hql);
		query.setInteger("userId", userId);
		User user=(User)query.uniqueResult();
		return user;
	}

	public int getUserId(String userName, String password) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from User where username=:userName and password=:password";
		Query query=session.createQuery(hql);
		query.setString("userName", userName);
		query.setString("password", password);
		User user=(User)query.uniqueResult();
		return user.getUserId();
	}

}
