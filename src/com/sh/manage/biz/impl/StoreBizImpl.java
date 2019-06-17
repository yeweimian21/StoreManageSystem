package com.sh.manage.biz.impl;

import java.util.List;

import com.sh.manage.biz.StoreBiz;
import com.sh.manage.dao.StoreDao;
import com.sh.manage.entity.Store;

public class StoreBizImpl implements StoreBiz {
	
	StoreDao storeDao;

	public void setStoreDao(StoreDao storeDao) {
		this.storeDao = storeDao;
	}

	public void addStore(Store store) {
		storeDao.addStore(store);

	}

	public void deleteStore(int storeId) {
		storeDao.deleteStore(storeId);

	}

	public List<Store> getStore() {
		
		return storeDao.getStore();
	}

	public void updateStore(int storeId, Store store) {
		storeDao.updateStore(storeId, store);

	}

	public Store getSimpleStore(int storeId) {
		
		return storeDao.getSimpleStore(storeId);
	}

	public Store getSimpleStoreByManageId(int managerId) {
		
		return storeDao.getSimpleStoreByManageId(managerId);
	}

}
