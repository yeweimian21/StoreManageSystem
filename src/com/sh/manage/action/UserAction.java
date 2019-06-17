package com.sh.manage.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sh.manage.biz.UserBiz;
import com.sh.manage.entity.User;

public class UserAction extends ActionSupport{

	private int userId;
	private String userName;
	private String password;
	private String sex;
	private int age;
	private String phone;
	private String email;
	
	private UserBiz userBiz;

	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String loginUser(){
		User user=new User();
		user.setUserName(userName);
		user.setPassword(password);
		if(userBiz.loginUser(user)){
			int userId=userBiz.getUserId(user.getUserName(), user.getPassword());
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpSession session=request.getSession();
			session.setAttribute("userId", userId);
			return "success_get_userId";
		}else{
			this.addFieldError("error", "用户名或者密码错误");
			return "not_right";
		}
	}
	
	public String exitUser(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		session.invalidate();
		return "success_exit";
	}
	
	//addUser()为注册用户
	
	public String addUser(){
		String usernameFilter="";
		try {
			usernameFilter=new String(userName.getBytes("iso-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		User user=new User();
		user.setUserName(usernameFilter);
		user.setPassword(password);
		user.setSex(sex);
		user.setAge(age);
		user.setPhone(phone);
		user.setEmail(email);
		userBiz.addUser(user);
		return "success_add";
	}
	
	public String updateUser(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String userIdParamString=request.getParameter("userIdParam");
		int userIdParamInteger=Integer.parseInt(userIdParamString);
		String userSexParam=request.getParameter("userSexParam");
		try {
			String userNameParam=new String(userName.getBytes("iso-8859-1"),"UTF-8");
			User user=new User();
			user.setUserName(userNameParam);
			user.setPassword(password);
			user.setSex(userSexParam);
			user.setAge(age);
			user.setPhone(phone);
			user.setEmail(email);
			userBiz.updateUser(userIdParamInteger, user);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		session.setAttribute("operateState", "updateSuccessfully");
		return "success_update";
	}
	
	public String deleteUser(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String userIdParamString=request.getParameter("userIdParam");
		int userIdParamInteger=Integer.parseInt(userIdParamString);
		userBiz.deleteUser(userIdParamInteger);
		HttpSession session=request.getSession();
		session.setAttribute("operateState", "deleteSuccessfully");
		return "success_delete";
	}
	
	//Ajax
	public String getUser(){
		List<User> users=new ArrayList<User>();
		
		//创建jsonArray
		JSONArray jsonArray;
		
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		String userRightFlag=(String)session.getAttribute("userRightFlag");
		if(userRightFlag.equals("AllUser")){
			users=userBiz.getUser();
			// 转化为Json对象
			jsonArray=JSONArray.fromObject(users);
		}else if(userRightFlag.equals("SelfUser")){
			int userId=(Integer)session.getAttribute("userId");
			User user=userBiz.getSimpleUser(userId);
			if(user==null){
				
			}else{
				users.add(user);
			}
			// 转化为Json对象
			jsonArray=JSONArray.fromObject(users);
		}else{
			jsonArray=JSONArray.fromObject(users);
		}
		
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		//清理浏览器缓存
		response.setHeader("Pragma", "No-cache");     
        response.addHeader("Cache-Control", "no-cache");     
        response.setDateHeader("Expires", 0);
        try {
			PrintWriter printWriter=response.getWriter();
			printWriter.println(jsonArray);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//Ajax
	public String getSimpleUser(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String userIdParamAjaxString=request.getParameter("userIdParamAjax");
		int userIdParamAjaxInteger=Integer.parseInt(userIdParamAjaxString);
		User user=userBiz.getSimpleUser(userIdParamAjaxInteger);

		// 转化为Json对象
		JSONObject jsonObject=JSONObject.fromObject(user);
		
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		//清理浏览器缓存
		response.setHeader("Pragma", "No-cache");     
        response.addHeader("Cache-Control", "no-cache");     
        response.setDateHeader("Expires", 0);
        try {
			PrintWriter printWriter=response.getWriter();
			printWriter.println(jsonObject);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//Ajax
	public String getTipSimpleUser(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		int userId=(Integer)session.getAttribute("userId");
		User user=userBiz.getSimpleUser(userId);
		JSONObject jsonObject=JSONObject.fromObject(user);
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		//清理浏览器缓存
		response.setHeader("Pragma", "No-cache");     
        response.addHeader("Cache-Control", "no-cache");     
        response.setDateHeader("Expires", 0);
        try {
			PrintWriter printWriter=response.getWriter();
			printWriter.println(jsonObject);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
