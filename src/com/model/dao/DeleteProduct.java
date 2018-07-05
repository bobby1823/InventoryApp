package com.model.dao;

import com.exception.InventoryAppException;

public interface DeleteProduct {

	public void deleteProduct(String userName, int productId) throws InventoryAppException;
	
	public void deleteInventory(String userName, int productId) throws InventoryAppException;
}
