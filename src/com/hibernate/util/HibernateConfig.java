package com.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
 
public class HibernateConfig {
 
    private static final SessionFactory sessionFactory;
    /*SessionFactory sessionFactory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(LoginUserTable.class)
			.buildSessionFactory();*/
    static {
        try {
            sessionFactory = new Configuration()
            					.configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static Session openSession() {
        return sessionFactory.openSession();
    }
}
