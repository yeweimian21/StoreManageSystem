package com.sh.manage.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sh.manage.biz.UserRoleBiz;
import com.sh.manage.entity.User;
import com.sh.manage.entity.UserRoleObject;

public class UserRoleAction extends ActionSupport {

	private int userRoleId;
	private int userId;
	private int roleId;

	private UserRoleBiz userRoleBiz;

	private int optionUserId;
	private int[] checkboxRoleIds;

	public int[] getCheckboxRoleIds() {
		return checkboxRoleIds;
	}

	public void setCheckboxRoleIds(int[] checkboxRoleIds) {
		this.checkboxRoleIds = checkboxRoleIds;
	}

	public int getOptionUserId() {
		return optionUserId;
	}

	public void setOptionUserId(int optionUserId) {
		this.optionUserId = optionUserId;
	}

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public void setUserRoleBiz(UserRoleBiz userRoleBiz) {
		this.userRoleBiz = userRoleBiz;
	}

	public String deleteUserRoleManage() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String optionUserIdString = request.getParameter("userIdParam");
		int optionUserIdInteger = Integer.parseInt(optionUserIdString);
		this.setOptionUserId(optionUserIdInteger);

		// 在delete方法中获得RoleId的数组
		String[] checkboxRoleIdsString = request
				.getParameterValues("roleIdParam");
		if (checkboxRoleIdsString==null) {
			int[] IntegerNullArray = {};
			this.setCheckboxRoleIds(IntegerNullArray);
		} else {
			int[] checkboxRoleIdsInteger = new int[checkboxRoleIdsString.length];
			for (int i = 0; i < checkboxRoleIdsString.length; i++) {
				checkboxRoleIdsInteger[i] = Integer
						.parseInt(checkboxRoleIdsString[i]);
			}
			this.setCheckboxRoleIds(checkboxRoleIdsInteger);
		}

		userRoleBiz.deleteUserRole(optionUserId);
		return "success_delete";
	}

	public String addUserRoleManage() {
		userRoleBiz.addUserRole(optionUserId, checkboxRoleIds);
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("operateState", "manageSuccessfully");
		return "success_add";

	}

	// Ajax
	public String getUserRoleMix() {
		List<UserRoleObject> userRoleObjects=new ArrayList<UserRoleObject>();
		
		JSONArray jsonArray;
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		HttpSession session=request.getSession();
		String userRightFlag=(String)session.getAttribute("userRightFlag");
		
		String userIdParamAjaxString=(String)request.getParameter("userIdParamAjax");
		int userIdParamAjaxInteger=Integer.parseInt(userIdParamAjaxString);
		
		if(userRightFlag.equals("AllUser")){
			if(userIdParamAjaxInteger==0){
				userRoleObjects=userRoleBiz.getUserRole();
			}else{
				userRoleObjects=userRoleBiz.getSimpleUserRole(userIdParamAjaxInteger);
			}
		}else if(userRightFlag.equals("SelfUser")){
			if(userIdParamAjaxInteger==0){
				int userId=(Integer)session.getAttribute("userId");
				userRoleObjects=userRoleBiz.getSimpleUserRole(userId);
			}else{
				userRoleObjects=userRoleBiz.getSimpleUserRole(userIdParamAjaxInteger);
			}
		}else{
			
		}
		jsonArray=JSONArray.fromObject(userRoleObjects);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		// 清理浏览器缓存
		response.setHeader("Pragma", "No-cache");
		response.addHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		try {
			PrintWriter printWriter = response.getWriter();
			printWriter.println(jsonArray);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	//Ajax
	public String getSimpleUserRoleMix(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String userIdParamAjaxString = request.getParameter("userIdParamAjax");
		int userIdParamAjaxInteger = Integer.parseInt(userIdParamAjaxString);
		
		List<UserRoleObject> userRoleObjects=userRoleBiz.getSimpleUserRole(userIdParamAjaxInteger);
		
		JSONArray jsonArray=JSONArray.fromObject(userRoleObjects);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		// 清理浏览器缓存
		response.setHeader("Pragma", "No-cache");
		response.addHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		try {
			PrintWriter printWriter = response.getWriter();
			printWriter.println(jsonArray);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//Ajax
	public String getSimpleRoleUserMix(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String roleNameParamAjaxString=request.getParameter("roleNameParamAjax");
		
		List<User> managers=userRoleBiz.getSimpleRoleUser(roleNameParamAjaxString);
		
		JSONArray jsonArray=JSONArray.fromObject(managers);
		
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

}
