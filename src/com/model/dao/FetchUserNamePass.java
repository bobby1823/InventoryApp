package com.model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.beans.LoginUserTable;


public class FetchUserNamePass {
	
	public LoginUserTable loginUser;
	
	public FetchUserNamePass(LoginUserTable loginBean) {
		this.loginUser= loginBean;
		 
	}

	/*
	 * Returns the UserName from DB
	 */
	public String userName(LoginUserTable loginUser) {
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(LoginUserTable.class)
				.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		LoginUserTable loginUser1 = new LoginUserTable();
		try{
			System.out.println("");
			//New transaction and session starts, get new session
			session = sessionFactory.getCurrentSession();
			//Begin transaction
			session.beginTransaction();
			loginUser1 = (LoginUserTable) session.get(LoginUserTable.class, loginUser.getUsername());
			return loginUser1.getUsername();

		}
		catch(Exception e) {
			System.out.println(e.toString());
			return null;
		}
		finally {
			session.close();
			System.out.println("Session closed");
		}

	}
	
	/*
	 * Returns the Password from DB based on Password
	 */
	public String userPass(LoginUserTable loginUser) {
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(LoginUserTable.class)
				.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		LoginUserTable loginUser1 = new LoginUserTable();
		try{
			System.out.println("");
			//New transaction and session starts, get new session
			session = sessionFactory.getCurrentSession();
			//Begin transaction
			session.beginTransaction();
			loginUser1 = (LoginUserTable) session.get(LoginUserTable.class, loginUser.getPassword());
			
			return loginUser1.getPassword();

		}
		catch(Exception e) {
			System.out.println(e.toString());
			return null;
		}
		finally {
			session.close();
			System.out.println("Session closed");
		}
	}
	
	public boolean authenticate(LoginUserTable loginUser) {
		if(!(userName(loginUser).equals(null)) && !(userPass(loginUser).equals(null))) {
			return true;
		}
		else {
			return false;
		}
		
	}
	/*public static void main(String args[]) {
		FetchUserNamePass fb = new FetchUserNamePass();
		fb.userName("sayanta");
	}*/
}
