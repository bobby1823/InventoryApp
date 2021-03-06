package com.model.dao;

import java.util.ArrayList;
import java.util.List;

import com.beans.InventoryUpdateTable;
import com.beans.ProductTable;

public interface ShowInventoryDao {

	public void showInventoryData(String userName, String productId);
	
	public ArrayList<InventoryUpdateTable> showInventoryData();

	List<ProductTable> showProductData();
}
