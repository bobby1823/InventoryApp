package com.service;

import java.util.Date;
import com.model.dao.AddProductDao;
import com.model.dao.CheckUserType;
import com.model.dao.impl.AddProductDaoImpl;

public class AddProductService {

	public AddProductService() {
		
	}
	AddProductDao productDao = new  AddProductDaoImpl();
	
	public void addProduct(String userName, int productId, int storeId, int deptId, String productName, String vendor, 
															double mrp, String batchNum, Date batchDate, int quantity) {
		if(CheckUserType.checkUserType(userName).equalsIgnoreCase("Store Manager")) {
			
			productDao.addProduct(userName, productId, storeId, deptId, productName, vendor, mrp, batchNum, batchDate, quantity);
		}
		else {
			productDao.addInventory(userName, productId, storeId, deptId, productName, vendor, mrp, batchNum, batchDate, quantity);
		}
			
	}
	
	/*
	 * Returns the status whether product can be added or not based on the storeId, productId, deptId passed in UI
	 */
	public boolean checkStatusAddingProduct(int productId,int storeId, int deptId) {
		return (productDao.addStatus(productId, storeId, deptId));
	}
	
	/*public static void main(String args[]) throws ParseException {
		//System.out.println("User is "+AddProductService.checkUserType(1));
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse("06/09/2019");
		AddProductService.addProduct(5, 2, 1, "Mach 3 Turbo", "Gillette", 40, "5312", date, 100);
		System.out.println("User Type: "+AddProductService.checkUserType(10));
	}*/
}
