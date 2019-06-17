package com.sh.manage.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sh.manage.biz.RoleBiz;
import com.sh.manage.entity.Role;

public class RoleAction extends ActionSupport {

	private int roleId;
	private String roleName;

	private RoleBiz roleBiz;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public void setRoleBiz(RoleBiz roleBiz) {
		this.roleBiz = roleBiz;
	}

	public String addRole() {
		String roleNameFilter = "";
		try {
			roleNameFilter = new String(roleName.getBytes("iso-8859-1"),
					"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if(roleNameFilter.equals("超级管理员")){
			roleNameFilter="SuperAdmin";
		}else if(roleNameFilter.equals("管理员")){
			roleNameFilter="Admin";
		}else if(roleNameFilter.equals("店长")){
			roleNameFilter="Manager";
		}
		Role role = new Role();
		role.setRoleName(roleNameFilter);
		roleBiz.addRole(role);
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		session.setAttribute("operateState", "addSuccessfully");
		return "success_add";
	}

	public String updateRole() {
		HttpServletRequest request=ServletActionContext.getRequest();
		String optionRoleIdString=request.getParameter("roleIdParam");
		int optionRoleIdInteger=Integer.parseInt(optionRoleIdString);
		String roleNameFilter = "";
		try {
			roleNameFilter = new String(roleName.getBytes("iso-8859-1"),
					"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Role role = new Role();
		role.setRoleName(roleNameFilter);
		roleBiz.updateRole(optionRoleIdInteger, role);
		HttpSession session=request.getSession();
		session.setAttribute("operateState", "updateSuccessfully");
		return "success_update";
	}

	public String deleteRole() {
		HttpServletRequest request=ServletActionContext.getRequest();
		String roleIdParamString=request.getParameter("roleIdParam");
		int roleIdParamInteger=Integer.parseInt(roleIdParamString);
		roleBiz.deleteRole(roleIdParamInteger);
		HttpSession session=request.getSession();
		session.setAttribute("operateState", "deleteSuccessfully");
		return "success_delete";
	}
	
	//Ajax
	public String getRole(){
		List<Role> roles=roleBiz.getRole();

		// 转化为Json对象
		JSONArray jsonArray=JSONArray.fromObject(roles);
		
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		//清理浏览器缓存
		response.setHeader("Pragma", "No-cache");     
        response.addHeader("Cache-Control", "no-cache");     
        response.setDateHeader("Expires", 0);
        PrintWriter printWriter;
		try {
			printWriter = response.getWriter();
			printWriter.println(jsonArray);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//Ajax
	public String getSimpleRole(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String roleIdParamAjaxString=request.getParameter("roleIdParamAjax");
		int roleIdParamAjaxInteger=Integer.parseInt(roleIdParamAjaxString);
		Role role=roleBiz.getSimpleRole(roleIdParamAjaxInteger);

		// 转化为Json对象
		JSONObject jsonObject=JSONObject.fromObject(role);

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
