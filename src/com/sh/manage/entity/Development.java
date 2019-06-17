package com.sh.manage.entity;

import java.io.Serializable;

public class Development implements Serializable {
	
	private int developmentId;
	private String developmentType;
	
	//动态是哪一个店铺的
	private Store store;
	
	private String storeName;
	
	private int storeIdSelf;
	
	private String developmentTitle;
	private String developmentContent;
	
	public Development() {
		super();
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
		this.setStoreName(store.getStoreName());
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
