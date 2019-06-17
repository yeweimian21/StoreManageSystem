package com.sh.manage.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sh.manage.dao.RoleDao;
import com.sh.manage.entity.Role;
import com.sh.manage.entity.RoleRight;
import com.sh.manage.entity.UserRole;

public class RoleDaoImpl implements RoleDao {
	
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addRole(Role role) {
		Session session=sessionFactory.getCurrentSession();
		session.save(role);

	}

	public void deleteRole(int roleId) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Role where roleId=:roleId";
		Query query=session.createQuery(hql);
		query.setInteger("roleId", roleId);
		Role role=(Role)query.uniqueResult();
		session.delete(role);
		String hql1="from UserRole where roleId=:roleId";
		query=session.createQuery(hql1);
		query.setInteger("roleId", roleId);
		List<UserRole> userRoles=query.list();
		for(UserRole userRole:userRoles){
			session.delete(userRole);
		}
		String hql2="from RoleRight where roleId=:roleId";
		query=session.createQuery(hql2);
		query.setInteger("roleId", roleId);
		List<RoleRight> roleRights=query.list();
		for(RoleRight roleRight:roleRights)
			session.delete(roleRight);
	}

	public List<Role> getRole() {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Role";
		Query query=session.createQuery(hql);
		List<Role> roles=query.list();
		return roles;
	}

	public void updateRole(int roleId, Role role) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Role where roleId=:roleId";
		Query query=session.createQuery(hql);
		query.setInteger("roleId", roleId);
		Role role2=(Role)query.uniqueResult();
		role2.setRoleName(role.getRoleName());
		session.update(role2);

	}

	public Role getRoleSimpleByRoleName(String roleName) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Role where roleName=:roleName";
		Query query=session.createQuery(hql);
		query.setString("roleName", roleName);
		Role role=(Role)query.uniqueResult();
		return role;
	}

	public Role getSimpleRole(int roleId) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Role where roleId=:roleId";
		Query query=session.createQuery(hql);
		query.setInteger("roleId", roleId);
		Role role=(Role)query.uniqueResult();
		return role;
	}

}
