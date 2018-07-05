package com.model.dao.impl;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.beans.ProductTable;
import com.beans.StoreInfo;
import com.hibernate.util.HibernateConfig;
import com.model.dao.AddProductDao;

public class AddProductDaoImpl implements AddProductDao{

	@Override
	public void addProduct(String userName, int productId, int storeId, int deptId, String productName, String vendor,
			double mrp, String batchNum, Date batchDate, int quantity) {
		StoreInfo userInfo = new StoreInfo();

		ProductTable product = new ProductTable();
		Transaction tx = null;
		Session session = HibernateConfig.openSession();
		try {
	            tx = session.getTransaction();
	            tx.begin();
	            //Getting the StoreId object
	            userInfo = session.get(StoreInfo.class, storeId);
	            //Setting all the data into ProductTable Bean. And place passing it to product object 
	            product.setProductId(productId);
	            product.setStoreInfo(userInfo);
	            product.setDeptInfo(deptId);
	            product.setProductName(productName);
	            product.setVendor(vendor);
	            product.setMrp(mrp);
	            product.setBatchNum(batchNum);
	            product.setBatchDate(batchDate);				
				product.setQuantity(quantity);
				
	            session.save(product);
	            tx.commit();
	            System.out.println("Product Details from DB: "+product);
	          
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
	public void addInventory(String userName, int productId, int storeId, int deptId, String productName, String vendor,
			double mrp, String batchNum, Date batchDate, int quantity) {
		
		
	}

}
