package com.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.beans.ProductTable;
import com.beans.StoreDept;
import com.beans.StoreInfo;
import com.hibernate.util.HibernateConfig;
import com.model.dao.CheckUserType;

public class ModifyProductService {

	public ModifyProductService() {
		
	}
	
	public void modifyProduct(String userName, int productId, int storeId, int deptId, String productName, String vendor, 
			double mrp, String batchNum, Date batchDate, int quantity) {
		if(CheckUserType.checkUserType(userName).equalsIgnoreCase("Store Manager")) {
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
		
				/*String hql = "UPDATE ProductTable set productName = :productName, "
						+ " vendor=:vendor , mrp=:mrp , batchNum=:batchNum , batchDate=:batchDate , "
						+ " quantity=:quantity WHERE productId = :productId and storeInfo = :storeId";
				Query query =(Query) session.createQuery(hql).uniqueResult();*/
//				query.setParameter("productId", productId);
//				query.setParameter("storeInfo", storeId);
//				query.setParameter("deptId", product.getDeptInfo());
//				query.setParameter("productName", productName);
//				query.setParameter("vendor", vendor);
//				query.setParameter("mrp", mrp);
//				query.setParameter("batchNum", batchNum);
//				query.setParameter("batchDate", batchDate);
//				query.setParameter("quantity", quantity);
//				int result = query.executeUpdate();
//				System.out.println("Rows affected: " + result);
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
		else {
			//Logic for getting data from Inventory update table
		}

	}
	
	/*public static void main(String args[]) throws ParseException {
		ModifyProductService modify = new ModifyProductService();
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse("06/09/2019");
		modify.modifyProduct("Sayanta", 7, 2, 2, "Cricket Gloves", "Willow and Jones", 80.87, "541", date, 12);
	}*/
}
