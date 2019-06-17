package com.sh.manage.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sh.manage.biz.RoleRightBiz;
import com.sh.manage.entity.RoleRightObject;

public class RoleRightAction extends ActionSupport {

	private int roleRightId;
	private int roleId;
	private int rightId;

	private RoleRightBiz roleRightBiz;

	private int optionRoleId;
	private int[] checkboxRightIds;

	public int getRoleRightId() {
		return roleRightId;
	}

	public void setRoleRightId(int roleRightId) {
		this.roleRightId = roleRightId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getRightId() {
		return rightId;
	}

	public void setRightId(int rightId) {
		this.rightId = rightId;
	}

	public int getOptionRoleId() {
		return optionRoleId;
	}

	public void setOptionRoleId(int optionRoleId) {
		this.optionRoleId = optionRoleId;
	}

	public int[] getCheckboxRightIds() {
		return checkboxRightIds;
	}

	public void setCheckboxRightIds(int[] checkboxRightIds) {
		this.checkboxRightIds = checkboxRightIds;
	}

	public void setRoleRightBiz(RoleRightBiz roleRightBiz) {
		this.roleRightBiz = roleRightBiz;
	}

	public String deleteRoleRightManage() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String optionRoleIdString = request.getParameter("roleIdParam");
		int optionRoleIdInteger = Integer.parseInt(optionRoleIdString);
		this.setOptionRoleId(optionRoleIdInteger);

		// 在delete方法中获得RightId数组
		String[] checkboxRightIdsString = request
				.getParameterValues("rightIdParam");

		if (checkboxRightIdsString==null) {
			int[] IntegerNullArray = {};
			this.setCheckboxRightIds(IntegerNullArray);
		} else {
			int[] checkboxRightIdsInteger = new int[checkboxRightIdsString.length];
			for (int i = 0; i < checkboxRightIdsString.length; i++) {
				checkboxRightIdsInteger[i] = Integer
						.parseInt(checkboxRightIdsString[i]);
			}
			this.setCheckboxRightIds(checkboxRightIdsInteger);
		}

		roleRightBiz.deleteRoleRight(optionRoleId);
		return "success_delete";
	}

	public String addRoleRightManage() {
		roleRightBiz.addRoleRight(this.optionRoleId, this.checkboxRightIds);
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		session.setAttribute("operateState", "manageSuccessfully");
		return "success_add";
	}
	
	//Ajax
	public String getRoleRightMix(){
		List<RoleRightObject> roleRightObjects=roleRightBiz.getRoleRight();
		
		JSONArray jsonArray = JSONArray.fromObject(roleRightObjects);
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
	public String getSimpleRoleRightMix(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String roleIdParamAjaxString=request.getParameter("roleIdParamAjax");
		int roleIdParamAjaxInteger=Integer.parseInt(roleIdParamAjaxString);
		
		List<RoleRightObject> roleRightObjects=roleRightBiz.getSimpleRoleRight(roleIdParamAjaxInteger);
		
		JSONArray jsonArray = JSONArray.fromObject(roleRightObjects);
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
	
}
