package com.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.beans.ProductTable;
import com.beans.StoreInfo;
import com.hibernate.util.HibernateConfig;
import com.model.dao.CheckUserType;

public class AddProductService {

	public AddProductService() {
		
	}

	
	public static void addProduct(int productId, int storeId, int deptId, String productName, String vendor, 
															double mrp, String batchNum, Date batchDate, int quantity) {
		if(CheckUserType.checkUserType(storeId).equalsIgnoreCase("Store Manager")) {
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
		else {
			//Logic for getting data from Inventory update table
		}
			
	}
	/*public static void main(String args[]) throws ParseException {
		//System.out.println("User is "+AddProductService.checkUserType(1));
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse("06/09/2019");
		AddProductService.addProduct(5, 2, 1, "Mach 3 Turbo", "Gillette", 40, "5312", date, 100);
		System.out.println("User Type: "+AddProductService.checkUserType(10));
	}*/
}
