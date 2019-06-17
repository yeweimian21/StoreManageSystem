package com.sh.manage.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sh.manage.biz.DevelopmentBiz;
import com.sh.manage.biz.StoreBiz;
import com.sh.manage.entity.Development;
import com.sh.manage.entity.Service;
import com.sh.manage.entity.Store;

public class DevelopmentAction extends ActionSupport {

	private int developmentId;
	private String developmentType;
	private int developmentStoreId;
	private String developmentTitle;
	private String developmentContent;

	private DevelopmentBiz developmentBiz;

	private StoreBiz storeBiz;

	public void setStoreBiz(StoreBiz storeBiz) {
		this.storeBiz = storeBiz;
	}

	public int getDevelopmentId() {
		return developmentId;
	}

	public void setDevelopmentId(int developmentId) {
		this.developmentId = developmentId;
	}

	public String getDevelopmentType() {
		return developmentType;
	}

	public void setDevelopmentType(String developmentType) {
		this.developmentType = developmentType;
	}

	public int getDevelopmentStoreId() {
		return developmentStoreId;
	}

	public void setDevelopmentStoreId(int developmentStoreId) {
		this.developmentStoreId = developmentStoreId;
	}

	public String getDevelopmentTitle() {
		return developmentTitle;
	}

	public void setDevelopmentTitle(String developmentTitle) {
		this.developmentTitle = developmentTitle;
	}

	public String getDevelopmentContent() {
		return developmentContent;
	}

	public void setDevelopmentContent(String developmentContent) {
		this.developmentContent = developmentContent;
	}

	public void setDevelopmentBiz(DevelopmentBiz developmentBiz) {
		this.developmentBiz = developmentBiz;
	}

	public String addDevelopment() {
		// 获得动态所属店铺的developmentStoreId
		HttpServletRequest request = ServletActionContext.getRequest();
		String optionDevelopmentStoreIdString = request
				.getParameter("developmentStoreIdParam");
		int optionDevelopmentStoreIdInteger = Integer
				.parseInt(optionDevelopmentStoreIdString);
		// 处理乱码
		String developmentTypeFilter = "";
		String developmentTitleFilter = "";
		String developmentContentFilter = "";
		try {
			developmentTypeFilter = new String(developmentType
					.getBytes("iso-8859-1"), "UTF-8");
			developmentTitleFilter = new String(developmentTitle
					.getBytes("iso-8859-1"), "UTF-8");
			developmentContentFilter = new String(developmentContent
					.getBytes("iso-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Development development = new Development();
		development.setDevelopmentType(developmentTypeFilter);
		development.setDevelopmentTitle(developmentTitleFilter);
		development.setDevelopmentContent(developmentContentFilter);

		Store store = storeBiz.getSimpleStore(optionDevelopmentStoreIdInteger);
		development.setStore(store);
		development.setStoreIdSelf(store.getStoreId());

		developmentBiz.addDevelopment(development);
		HttpSession session = request.getSession();
		session.setAttribute("operateState", "addSuccessfully");
		return "success_add";
	}

	public String updateDevelopment() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String developmentIdParamString = request
				.getParameter("developmentIdParam");
		int developmentIdParamInteger = Integer
				.parseInt(developmentIdParamString);

		String storeIdParamString = request.getParameter("storeIdParam");
		int storeIdParamInteger = Integer.parseInt(storeIdParamString);
		Store store = storeBiz.getSimpleStore(storeIdParamInteger);

		try {
			String developmentType = new String(this.developmentType
					.getBytes("iso-8859-1"), "UTF-8");
			String developmentTitle = new String(this.developmentTitle
					.getBytes("iso-8859-1"), "UTF-8");
			String developmentContent = new String(this.developmentContent
					.getBytes("iso-8859-1"), "UTF-8");
			Development development = new Development();
			development.setDevelopmentType(developmentType);
			development.setDevelopmentTitle(developmentTitle);
			development.setDevelopmentContent(developmentContent);
			
			development.setStore(store);
			development.setStoreIdSelf(store.getStoreId());
			
			developmentBiz.updateDevelopment(developmentIdParamInteger,
					development);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		session.setAttribute("operateState", "updateSuccessfully");
		return "success_update";
	}

	public String deleteDevelopment() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String developmentIdParamString = request
				.getParameter("developmentIdParam");
		int developmentIdParamInteger = Integer
				.parseInt(developmentIdParamString);
		developmentBiz.deleteDevelopment(developmentIdParamInteger);
		HttpSession session = request.getSession();
		session.setAttribute("operateState", "deleteSuccessfully");
		return "success_delete";
	}

	//Ajax
	public String getDevelopment() {
		// 创建jsonConfig
		JsonConfig jsonConfig = new JsonConfig();

		// 配置属性过滤器propertyFilter
		PropertyFilter propertyFilter = new PropertyFilter() {

			public boolean apply(Object source, String name, Object value) {
				if (name.equals("store")) {
					return true;
				}
				return false;
			}
		};

		// 配置jsonConfig
		jsonConfig.setJsonPropertyFilter(propertyFilter);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String storeIdParamAjaxString = request
				.getParameter("storeIdParamAjax");
		int storeIdParamAjaxInteger = Integer.parseInt(storeIdParamAjaxString);
		
		HttpSession session=request.getSession();
		String storeRightFlag=(String)session.getAttribute("storeRightFlag");
		
		JSONArray jsonArray;
		if(storeRightFlag.equals("AllStore")){
			if(storeIdParamAjaxInteger==0){
				List<Development> developments=developmentBiz.getDevelopment();
				jsonArray=JSONArray.fromObject(developments, jsonConfig);
			}else{
				Set<Development> developments=developmentBiz.getSimpleStoreDevelopment(storeIdParamAjaxInteger);
				jsonArray=JSONArray.fromObject(developments, jsonConfig);
			}
		}else if(storeRightFlag.equals("SelfStore")){
			if(storeIdParamAjaxInteger==0){
				int userId=(Integer)session.getAttribute("userId");
				Store store=storeBiz.getSimpleStoreByManageId(userId);
				int storeId=store.getStoreId();
				Set<Development> developments=developmentBiz.getSimpleStoreDevelopment(storeId);
				jsonArray=JSONArray.fromObject(developments, jsonConfig);
			}else{
				Set<Development> developments=developmentBiz.getSimpleStoreDevelopment(storeIdParamAjaxInteger);
				jsonArray=JSONArray.fromObject(developments, jsonConfig);
			}
		}else{
			Set<Development> developments=new HashSet<Development>();
			jsonArray=JSONArray.fromObject(developments);
		}

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

	// Ajax
	public String getSimpleDevelopment() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String developmentIdParamAjaxString = request
				.getParameter("developmentIdParamAjax");
		int developmentIdParamAjaxInteger = Integer
				.parseInt(developmentIdParamAjaxString);
		Development development = developmentBiz
				.getSimpleDevelopment(developmentIdParamAjaxInteger);
		// 创建jsonConfig
		JsonConfig jsonConfig = new JsonConfig();

		// 配置属性过滤器propertyFilter
		PropertyFilter propertyFilter = new PropertyFilter() {

			public boolean apply(Object source, String name, Object value) {
				if (name.equals("store")) {
					return true;
				}
				return false;
			}
		};

		// 配置jsonConfig
		jsonConfig.setJsonPropertyFilter(propertyFilter);

		// 转化为Json对象
		JSONObject jsonObject = JSONObject.fromObject(development, jsonConfig);

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
