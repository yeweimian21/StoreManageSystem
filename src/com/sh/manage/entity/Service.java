package com.sh.manage.entity;

import java.io.Serializable;

public class Service implements Serializable {
	
	private int serviceId;
	private String serviceName;
	
	//服务是哪一个店铺的
	private Store store;
	
	private String storeName;
	
	private int storeIdSelf;
	
	private String serviceCheap;
	private int beforePrice;
	private int afterPrice;
	private int costTime;
	
	public Service() {
		super();
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

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
		this.setStoreName(store.getStoreName());
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

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public int getStoreIdSelf() {
		return storeIdSelf;
	}

	public void setStoreIdSelf(int storeIdSelf) {
		this.storeIdSelf = storeIdSelf;
	}

}
