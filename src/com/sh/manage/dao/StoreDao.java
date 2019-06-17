package com.sh.manage.dao;

import java.util.List;

import com.sh.manage.entity.Store;

public interface StoreDao {

	public void addStore(Store store);
	
	public List<Store> getStore();
	
	public void updateStore(int storeId,Store store);
	
	public void deleteStore(int storeId);
	
	public Store getSimpleStore(int storeId);
	
	public Store getSimpleStoreByManageId(int managerId);
	
}
