package com.sh.manage.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sh.manage.biz.StoreBiz;
import com.sh.manage.biz.UserBiz;
import com.sh.manage.entity.Store;

public class StoreAction extends ActionSupport {

	private int storeId;
	private String storeName;
	private int managerId;
	private String storeAddress;
	private String storePhone;

	private StoreBiz storeBiz;

	private UserBiz userBiz;

	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public String getStorePhone() {
		return storePhone;
	}

	public void setStorePhone(String storePhone) {
		this.storePhone = storePhone;
	}

	public void setStoreBiz(StoreBiz storeBiz) {
		this.storeBiz = storeBiz;
	}

	public String addStore() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String optionManageIdString = request.getParameter("managerIdParam");
		int optionManageIdInteger = Integer.parseInt(optionManageIdString);
		String storeNameFilter = "";
		String storeAddressFilter = "";
		try {
			storeNameFilter = new String(storeName.getBytes("iso-8859-1"),
					"UTF-8");
			storeAddressFilter = new String(
					storeAddress.getBytes("iso-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Store store = new Store();
		store.setStoreName(storeNameFilter);
		store.setManagerName(userBiz.getSimpleUser(optionManageIdInteger).getUserName());
		store.setManagerId(optionManageIdInteger);
		store.setStoreAddress(storeAddressFilter);
		store.setStorePhone(storePhone);
		storeBiz.addStore(store);
		HttpSession session = request.getSession();
		session.setAttribute("operateState", "addSuccessfully");
		return "success_add";
	}

	public String updateStore() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String optionStoreIdString = request.getParameter("storeIdParam");
		int optionStoreIdInteger = Integer.parseInt(optionStoreIdString);
		String optionManageIdString = request.getParameter("managerIdParam");
		int optionManageIdInteger = Integer.parseInt(optionManageIdString);
		String storeNameFilter = "";
		String storeAddressFilter = "";
		try {
			storeNameFilter = new String(storeName.getBytes("iso-8859-1"),
					"UTF-8");
			storeAddressFilter = new String(
					storeAddress.getBytes("iso-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Store store = new Store();
		store.setStoreName(storeNameFilter);
		store.setManagerName(userBiz.getSimpleUser(optionManageIdInteger).getUserName());
		store.setManagerId(optionManageIdInteger);
		store.setStoreAddress(storeAddressFilter);
		store.setStorePhone(storePhone);
		storeBiz.updateStore(optionStoreIdInteger, store);
		HttpSession session = request.getSession();
		session.setAttribute("operateState", "updateSuccessfully");
		return "success_update";
	}

	public String deleteStore() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String optionStoreIdString = request.getParameter("storeIdParam");
		int optionStoreIdInteger = Integer.parseInt(optionStoreIdString);
		storeBiz.deleteStore(optionStoreIdInteger);
		HttpSession session = request.getSession();
		session.setAttribute("operateState", "deleteSuccessfully");
		return "success_delete";
	}

	// Ajax
	public String getStore() {
		List<Store> stores=new ArrayList<Store>();
		
		// 创建jsonConfig
		JsonConfig jsonConfig = new JsonConfig();

		// 配置属性过滤器propertyFilter
		PropertyFilter propertyFilter = new PropertyFilter() {

			public boolean apply(Object source, String name, Object value) {
				if (name.equals("services") || name.equals("developments")) {
					return true;
				}
				return false;
			}
		};

		// 配置jsonConfig
		jsonConfig.setJsonPropertyFilter(propertyFilter);
		//创建json对象
		JSONArray jsonArray;
		
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		String storeRightFlag=(String)session.getAttribute("storeRightFlag");
		if(storeRightFlag.equals("AllStore")){
			stores = storeBiz.getStore();
			jsonArray=JSONArray.fromObject(stores, jsonConfig);
		}else if(storeRightFlag.equals("SelfStore")){
			int userId=(Integer)session.getAttribute("userId");
			Store store=storeBiz.getSimpleStoreByManageId(userId);
			if(store==null){
				
			}else{
				stores.add(store);
			}
			jsonArray=JSONArray.fromObject(stores, jsonConfig);
		}else{
			jsonArray=JSONArray.fromObject(stores);
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

	//Ajax
	public String getSimpleStore() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String storeIdParamAjaxString = request
				.getParameter("storeIdParamAjax");
		int storeIdParamAjaxInteger = Integer.parseInt(storeIdParamAjaxString);
		Store store = storeBiz.getSimpleStore(storeIdParamAjaxInteger);
		// 创建jsonConfig
		JsonConfig jsonConfig = new JsonConfig();

		// 配置属性过滤器propertyFilter
		PropertyFilter propertyFilter = new PropertyFilter() {

			public boolean apply(Object source, String name, Object value) {
				if (name.equals("services") || name.equals("developments")) {
					return true;
				}
				return false;
			}
		};

		// 配置jsonConfig
		jsonConfig.setJsonPropertyFilter(propertyFilter);
		// 转化为Json对象
		JSONObject jsonObject=JSONObject.fromObject(store, jsonConfig);
		
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
	
	// Ajax
	public String getManagerIdStore() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String storeIdParamAjaxString = request
				.getParameter("storeIdParamAjax");
		int storeIdParamAjaxInteger = Integer.parseInt(storeIdParamAjaxString);
		Store store = storeBiz.getSimpleStore(storeIdParamAjaxInteger);
		int managerId = store.getManagerId();
		Map<String, Integer> managerIdMap = new HashMap<String, Integer>();
		managerIdMap.put("managerId", managerId);

		JSONObject jsonObject = JSONObject.fromObject(managerIdMap);

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
