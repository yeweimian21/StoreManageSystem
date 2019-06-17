package com.sh.manage.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sh.manage.biz.ServiceBiz;
import com.sh.manage.biz.StoreBiz;
import com.sh.manage.entity.Service;
import com.sh.manage.entity.Store;

public class ServiceAction extends ActionSupport {

	private int serviceId;
	private String serviceName;
	private int serviceStoreId;
	private String serviceCheap;
	private int beforePrice;
	private int afterPrice;
	private int costTime;

	private ServiceBiz serviceBiz;

	private StoreBiz storeBiz;

	public void setStoreBiz(StoreBiz storeBiz) {
		this.storeBiz = storeBiz;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public int getServiceStoreId() {
		return serviceStoreId;
	}

	public void setServiceStoreId(int serviceStoreId) {
		this.serviceStoreId = serviceStoreId;
	}

	public String getServiceCheap() {
		return serviceCheap;
	}

	public void setServiceCheap(String serviceCheap) {
		this.serviceCheap = serviceCheap;
	}

	public int getBeforePrice() {
		return beforePrice;
	}

	public void setBeforePrice(int beforePrice) {
		this.beforePrice = beforePrice;
	}

	public int getAfterPrice() {
		return afterPrice;
	}

	public void setAfterPrice(int afterPrice) {
		this.afterPrice = afterPrice;
	}

	public int getCostTime() {
		return costTime;
	}

	public void setCostTime(int costTime) {
		this.costTime = costTime;
	}

	public void setServiceBiz(ServiceBiz serviceBiz) {
		this.serviceBiz = serviceBiz;
	}

	public String addService() {
		// 获得serviceStoreId
		HttpServletRequest request = ServletActionContext.getRequest();
		String storeIdParamString = request
				.getParameter("storeIdParam");
		int storeIdParamInteger = Integer
				.parseInt(storeIdParamString);
		// 获得serviceCheap
		String radioServiceCheapString = request.getParameter("cheapParam");

		// 处理storeName的乱码
		String serviceNameFilter = "";
		try {
			serviceNameFilter = new String(serviceName.getBytes("iso-8859-1"),
					"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Service service = new Service();
		service.setServiceName(serviceNameFilter);
		service.setServiceCheap(radioServiceCheapString);
		service.setBeforePrice(beforePrice);
		service.setAfterPrice(afterPrice);
		service.setCostTime(costTime);

		Store store = storeBiz.getSimpleStore(storeIdParamInteger);
		service.setStore(store);
		service.setStoreIdSelf(store.getStoreId());

		serviceBiz.addService(service);
		HttpSession session = request.getSession();
		session.setAttribute("operateState", "addSuccessfully");
		return "success_add";
	}

	public String updateService() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String serviceIdParamString = request.getParameter("serviceIdParam");
		int serviceIdParamInteger = Integer.parseInt(serviceIdParamString);

		String storeIdParamString = request.getParameter("storeIdParam");
		int storeIdParamInteger = Integer.parseInt(storeIdParamString);
		Store store = storeBiz.getSimpleStore(storeIdParamInteger);

		try {
			String serviceNameParam = new String(serviceName
					.getBytes("iso-8859-1"), "UTF-8");
			String serviceCheapParam = new String(request.getParameter(
					"serviceCheapParam").getBytes("iso-8859-1"), "UTF-8");
			Service service = new Service();
			service.setServiceName(serviceNameParam);
			
			service.setStore(store);
			service.setStoreIdSelf(store.getStoreId());
			
			service.setServiceCheap(serviceCheapParam);
			service.setBeforePrice(beforePrice);
			service.setAfterPrice(afterPrice);
			service.setCostTime(costTime);
			serviceBiz.updateService(serviceIdParamInteger, service);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		session.setAttribute("operateState", "updateSuccessfully");
		return "success_update";
	}

	public String deleteService() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String serviceIdParamString = request.getParameter("serviceIdParam");
		int serviceIdParamInteger = Integer.parseInt(serviceIdParamString);
		serviceBiz.deleteService(serviceIdParamInteger);
		HttpSession session = request.getSession();
		session.setAttribute("operateState", "deleteSuccessfully");
		return "success_delete";
	}

	//Ajax
	public String getService() {
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
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String storeIdParamAjaxString=request.getParameter("storeIdParamAjax");
		int storeIdParamAjaxInteger=Integer.parseInt(storeIdParamAjaxString);
		
		HttpSession session=request.getSession();
		String storeRightFlag=(String)session.getAttribute("storeRightFlag");
		
		JSONArray jsonArray;
		if(storeRightFlag.equals("AllStore")){
			if(storeIdParamAjaxInteger==0){
				List<Service> services=serviceBiz.getService();
				jsonArray=JSONArray.fromObject(services, jsonConfig);
			}else{
				Set<Service> services=serviceBiz.getSimpleStoreService(storeIdParamAjaxInteger);
				jsonArray=JSONArray.fromObject(services, jsonConfig);
			}
		}else if(storeRightFlag.equals("SelfStore")){
			if(storeIdParamAjaxInteger==0){
				int userId=(Integer)session.getAttribute("userId");
				Store store=storeBiz.getSimpleStoreByManageId(userId);
				int storeId=store.getStoreId();
				Set<Service> services=serviceBiz.getSimpleStoreService(storeId);
				jsonArray=JSONArray.fromObject(services, jsonConfig);
			}else{
				Set<Service> services=serviceBiz.getSimpleStoreService(storeIdParamAjaxInteger);
				jsonArray=JSONArray.fromObject(services, jsonConfig);
			}
			
		}else{
			Set<Service> services=new HashSet<Service>();
			jsonArray=JSONArray.fromObject(services);
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
	public String getSimpleService() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String serviceIdParamAjaxString = request
				.getParameter("serviceIdParamAjax");
		int serviceIdParamAjaxInteger = Integer
				.parseInt(serviceIdParamAjaxString);
		Service service = serviceBiz
				.getSimpleService(serviceIdParamAjaxInteger);
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
		JSONObject jsonObject = JSONObject.fromObject(service, jsonConfig);

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
