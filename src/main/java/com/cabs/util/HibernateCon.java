package com.cabs.util;





import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateCon {
	
	
	
	public static SessionFactory getSessionFactory() {
	SessionFactory sessionFactory =new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	
	return sessionFactory;
	}

}

