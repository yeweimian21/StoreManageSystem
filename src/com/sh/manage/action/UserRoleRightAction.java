package com.sh.manage.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sh.manage.biz.UserRoleRightBiz;
import com.sh.manage.entity.Right;

public class UserRoleRightAction extends ActionSupport{
	
	private UserRoleRightBiz userRoleRightBiz;
	
	public void setUserRoleRightBiz(UserRoleRightBiz userRoleRightBiz) {
		this.userRoleRightBiz = userRoleRightBiz;
	}
	
	public String setCheckDisplay(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		int userId=(Integer)session.getAttribute("userId");
		List<Right> rights=userRoleRightBiz.getUserRight(userId);
				
		//操作店铺的权限标志
		String storeRightFlag="NoneStore";
		//操作用户的权限标志
		String userRightFlag="NoneUser";
		
		for(Right right:rights){
			if(right.getRightName().equals("manageAllStore")){
				storeRightFlag="AllStore";
			}else if(right.getRightName().equals("manageSelfStore")){
				storeRightFlag="SelfStore";
			}else if(right.getRightName().equals("manageAllUser")){
				userRightFlag="AllUser";
			}else if(right.getRightName().equals("manageSelfUser")){
				userRightFlag="SelfUser";
			}
		}
		
		session.setAttribute("storeRightFlag", storeRightFlag);
		session.setAttribute("userRightFlag", userRightFlag);
		
		return "success_login";
	}
	
	public String getCheckDisplay(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		String storeRightFlag=(String)session.getAttribute("storeRightFlag");
		String userRightFlag=(String)session.getAttribute("userRightFlag");
		Map<String, String> rightMap=new HashMap<String, String>();
		rightMap.put("storeRightFlag", storeRightFlag);
		rightMap.put("userRightFlag", userRightFlag);
		JSONObject jsonObject=JSONObject.fromObject(rightMap);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		// 清理浏览器缓存
		response.setHeader("Pragma", "No-cache");
		response.addHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		try {
			PrintWriter printWriter = response.getWriter();
			printWriter.println(jsonObject);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
