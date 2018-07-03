package com.service;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.beans.InventoryUpdateTable;
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
			StoreInfo userInfo = new StoreInfo();
			ProductTable product = new ProductTable();
			InventoryUpdateTable updateTable = new InventoryUpdateTable();
			Transaction tx = null;
			Session session = HibernateConfig.openSession();
			try {
				tx = session.getTransaction();
				tx.begin();
				//Getting the Product object
				List<ProductTable> q = session.createQuery("From ProductTable where productId="+productId).list();
				
				for(ProductTable product1 : q) {
					product = product1;
					System.out.println("Respective ProductId is "+product.getProductId());
				}
				
				System.out.println("Product Details for deleting: "+product);
				//Passing the data to InventoryUpdate Table
				updateTable.setStatus("Pending");
				updateTable.setOperationType("Delete");
				updateTable.setBatchDate(product.getBatchDate());
				updateTable.setBatchNum(product.getBatchNum());
				updateTable.setDeptInfo(product.getDeptInfo());
				updateTable.setMrp(product.getMrp());
				updateTable.setProductId(product.getProductId());
				updateTable.setProductName(product.getProductName());
				updateTable.setQuantity(product.getQuantity());
				updateTable.setStoreInfo(product.getStoreInfo());
				updateTable.setVendor(product.getVendor());
				System.out.println("Data Sent for Approval: "+updateTable);
				session.save(updateTable);
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
	}
	
	/*public static void main(String[] args) {
		DeleteService delete = new DeleteService();
		delete.deleteProduct("Kirti", 4);
	}*/
}
