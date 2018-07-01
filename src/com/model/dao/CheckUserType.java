package com.model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.beans.LoginUserTable;
import com.beans.StoreInfo;
import com.hibernate.util.HibernateConfig;


public class CheckUserType {
	
	public static String checkUserType(int userType) {
		 
		Session session = HibernateConfig.openSession();
		StoreInfo userInfo = new StoreInfo();
		Transaction tx = null;
		try {
	            tx = session.getTransaction();
	            tx.begin();
	            userInfo = session.get(StoreInfo.class, userType);	     
	           // System.out.println("UserName from DB: "+userInfo.getStoreId());
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
		if((userInfo!=(null))) {
			return "Store Manager";
		}
		else {
			return "Department Manager";
		}
	}
}
