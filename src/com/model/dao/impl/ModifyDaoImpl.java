package com.model.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.beans.ProductTable;
import com.beans.StoreInfo;
import com.hibernate.util.HibernateConfig;
import com.model.dao.ModifyDao;

public class ModifyDaoImpl implements ModifyDao{

	@Override
	public void modifyProduct(String userName, int productId, int storeId, int deptId, String productName,
			String vendor, double mrp, String batchNum, Date batchDate, int quantity) {
		StoreInfo storeInfo = new StoreInfo();
		//StoreDept storeDeptInfo = new StoreDept();
		ProductTable product = new ProductTable();

		Transaction tx = null;
		Session session = HibernateConfig.openSession();
		try {
			tx = session.getTransaction();
			tx.begin();
			List<StoreInfo> storeInfoList = session.createQuery(" from StoreInfo where storeId='"+storeId+"'").list();
			for(StoreInfo storeInfo1 : storeInfoList) {
				storeInfo = storeInfo1;
				System.out.println("Respective StoreId is "+storeInfo.getStoreId());
			}
			List<ProductTable> userInfoList = session.createQuery(" from ProductTable where storeId='"+storeId+"' and productId='"+productId+"'").list();
			for(ProductTable userInfo1 : userInfoList) {
				product = userInfo1;
				System.out.println("Respective DeptID is "+product.getDeptInfo());
			}
		
			System.out.println("Product Details from DB: "+product);
			product.setBatchDate(batchDate);
			product.setBatchNum(batchNum);
			product.setDeptInfo(product.getDeptInfo());
			product.setMrp(mrp);
			product.setProductId(productId);
			product.setProductName(productName);
			product.setQuantity(quantity);
			product.setVendor(vendor);
			product.setStoreInfo(storeInfo);
			session.save(product);
			tx.commit();

		} 
		catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}

	@Override
	public void modifyInventory(String userName, int productId, int storeId, int deptId, String productName,
			String vendor, double mrp, String batchNum, Date batchDate, int quantity) {
		
		
	}

	
}
