package com.service;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.beans.ProductTable;
import com.beans.StoreInfo;
import com.hibernate.util.HibernateConfig;
import com.model.dao.CheckUserType;

public class DeleteService {

	
	public void deleteProduct(String userName, int productId/*, int storeId, int deptId, String productName, String vendor, 
			double mrp, String batchNum, Date batchDate, int quantity*/) {
		if(CheckUserType.checkUserType(userName).equalsIgnoreCase("Store Manager")) {
			StoreInfo userInfo = new StoreInfo();
			ProductTable product = new ProductTable();

			Transaction tx = null;
			Session session = HibernateConfig.openSession();
			try {
				tx = session.getTransaction();
				tx.begin();
				//Getting the Product object
				product = session.get(ProductTable.class, productId);
				System.out.println("Product Details for deleting: "+product);
				//Deleting the Fetched object
				session.delete(product);
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
	
	/*public static void main(String[] args) {
		DeleteService.deleteProduct("Sayanta", 2);
	}*/
}
