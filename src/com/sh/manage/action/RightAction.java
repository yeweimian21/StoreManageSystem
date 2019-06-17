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

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sh.manage.biz.RightBiz;
import com.sh.manage.entity.Right;

public class RightAction extends ActionSupport {

	private int rightId;
	private String rightName;

	private RightBiz rightBiz;

	public int getRightId() {
		return rightId;
	}

	public void setRightId(int rightId) {
		this.rightId = rightId;
	}

	public String getRightName() {
		return rightName;
	}

	public void setRightName(String rightName) {
		this.rightName = rightName;
	}

	public void setRightBiz(RightBiz rightBiz) {
		this.rightBiz = rightBiz;
	}

	public String addRight() {
		String rightNameFilter = "";
		try {
			rightNameFilter = new String(rightName.getBytes("iso-8859-1"),
					"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if(rightNameFilter.equals("管理所有店铺")){
			rightNameFilter="manageAllStore";
		}else if(rightNameFilter.equals("管理自己店铺")){
			rightNameFilter="manageSelfStore";
		}else if(rightNameFilter.equals("管理所有用户")){
			rightNameFilter="manageAllUser";
		}else if(rightNameFilter.equals("管理自己用户")){
			rightNameFilter="manageSelfUser";
		}
		Right right = new Right();
		right.setRightName(rightNameFilter);
		rightBiz.addRight(right);
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		session.setAttribute("operateState", "addSuccessfully");
		return "success_add";
	}

	public String updateRight() {
		HttpServletRequest request=ServletActionContext.getRequest();
		String optionRightIdString=request.getParameter("rightIdParam");
		int optionRightIdInteger=Integer.parseInt(optionRightIdString);
		String rightNameFilter = "";
		try {
			rightNameFilter = new String(rightName.getBytes("iso-8859-1"),
					"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Right right = new Right();
		right.setRightName(rightNameFilter);
		rightBiz.updateRight(optionRightIdInteger, right);
		HttpSession session=request.getSession();
		session.setAttribute("operateState", "updateSuccessfully");
		return "success_update";
	}

	public String deleteRight() {
		HttpServletRequest request=ServletActionContext.getRequest();
		String rightIdParamString=request.getParameter("rightIdParam");
		int rightIdParamInteger=Integer.parseInt(rightIdParamString);
		rightBiz.deleteRight(rightIdParamInteger);
		HttpSession session=request.getSession();
		session.setAttribute("operateState", "deleteSuccessfully");
		return "success_delete";
	}
	
	//Ajax
	public String getRight(){
		List<Right> rights=rightBiz.getRight();
		JSONArray jsonArray=JSONArray.fromObject(rights);
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
	public String getSimpleRight(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String rightIdParamAjaxString=request.getParameter("rightIdParamAjax");
		int rightIdParamAjaxInteger=Integer.parseInt(rightIdParamAjaxString);
		Right right=rightBiz.getSimpleRight(rightIdParamAjaxInteger);
		JSONObject jsonObject=JSONObject.fromObject(right);
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
