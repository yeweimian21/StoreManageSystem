package com.sh.manage.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Store implements Serializable {

	private int storeId;
	private String storeName;
	private String storeAddress;
	private String storePhone;
	
	private String managerName;
	private int managerId;
	
	private Set<Service> services=new HashSet<Service>();
	
	private Set<Development> developments=new HashSet<Development>();
	
	public Store() {
		super();
	}

	public Set<Development> getDevelopments() {
		return developments;
	}

	public void setDevelopments(Set<Development> developments) {
		this.developments = developments;
	}

	public Set<Service> getServices() {
		return services;
	}

	public void setServices(Set<Service> services) {
		this.services = services;
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

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

}
