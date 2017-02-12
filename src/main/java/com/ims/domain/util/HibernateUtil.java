package com.ims.domain.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").setProperty("hibernate.connection.url", System.getenv("IMS_URL")).setProperty("hibernate.connection.username", System.getenv("IMS_USER")).setProperty("hibernate.connection.password", System.getenv("IMS_PASS")).buildSessionFactory();
	
	public static Session getSession(){
		
		return sessionFactory.openSession();
	}
	
}
