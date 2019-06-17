package com.sh.manage.biz;

import java.util.List;

import com.sh.manage.entity.User;

public interface UserBiz {

	public void addUser(User user);

	public void updateUser(int userId, User user);

	public void deleteUser(int userId);

	public List<User> getUser();

	public boolean loginUser(User user);
	
	public User getSimpleUser(int userId);
	
	//getUserId()方法为根据userName和password获得该用户的userId
	public int getUserId(String userName,String password);
	
}
