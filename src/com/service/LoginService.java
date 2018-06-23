package com.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.beans.LoginUserTable;
import com.hibernate.util.HibernateConfig;

public class LoginService {

	public LoginService() {
		
	}
	
	public boolean authentication(String userName, String passWord) {
		boolean status = !(userId(userName).equals(null)) && !(userPassword(passWord).equals(null)) 
				&& !(userId(userName).equals("")) && !(userPassword(passWord).equals(""));
		if(status) {
			System.out.println("Value: "+status);
			return true;
		}
		return false;
	}
	
	public String userId(String userID) {
		String data = "";
		Session session = HibernateConfig.openSession();
        Transaction tx = null;
//        User user = null;
        LoginUserTable loginUserDB = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            //Query query = session.createQuery("from userTable where username='"+userID+"'");
            //loginUserDB = (LoginUserTable)query.uniqueResult();
            loginUserDB = session.get(LoginUserTable.class, userID);
            data = loginUserDB.getUsername();
            System.out.println("UserName from DB: "+data);
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
        return data;
	}
	
	public String userPassword(String userID) {
		String data = "";
		Session session = HibernateConfig.openSession();
        Transaction tx = null;
//        User user = null;
        LoginUserTable loginUserDB = null;
        try {
            tx = session.getTransaction();
            tx.begin();
//            Query query = session.createQuery("from userTable where password='"+password+"'");
//            loginUserDB = (LoginUserTable)query.uniqueResult();
            loginUserDB = session.get(LoginUserTable.class, userID);
            data = loginUserDB.getPassword();
            System.out.println("UserName from DB: "+data);
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
        return data;
	}
}
