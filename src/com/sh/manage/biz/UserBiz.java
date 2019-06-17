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
	
	//getUserId()����Ϊ����userName��password��ø��û���userId
	public int getUserId(String userName,String password);
	
}
