package com.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beans.InventoryUpdateTable;
import com.beans.ProductTable;
import com.hibernate.util.HibernateConfig;
import com.model.dao.ShowInventoryDao;

@Repository
public class ShowInventoryDaoImpl implements ShowInventoryDao{

	@Override
	public void showInventoryData(String userName, String productId) {		
	}

	@Override
	@Transactional
	public List<ProductTable> showProductData() {
		Session session = HibernateConfig.openSession();
		//Session session = sessionFactory.getCurrentSession();
		List<ProductTable> products =  session.createQuery("from ProductTable").list();
		return products;
	}
	
	@Override
	@Transactional
	public ArrayList<InventoryUpdateTable> showInventoryData(){
		Session session = HibernateConfig.openSession();
		List<InventoryUpdateTable> inventoryData = null;
		inventoryData = session.createQuery("from InventoryUpdateTable").list();
		return (ArrayList<InventoryUpdateTable>) inventoryData;
	}


	/*public static void main(String args[]) {
		//ApplicationContext ctx = new FileSystemXmlApplicationContext("/WebContent/WEB-INF/spring-mvc-servlet.xml");
		ShowInventoryDao dao = new ShowInventoryDaoImpl();
		System.out.println("Size of Product Table is "+dao.showProductData().size());

	}*/
}