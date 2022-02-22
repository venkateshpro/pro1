package com.cabs.Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cabs.model.ModelEmp;
import com.cabs.util.HibernateCon;

public class RegisterEmployeeImpl implements RegisterEmployee{
	
	public Boolean register1(ModelEmp emp) {
		
		try {
			Session session = HibernateCon.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			
			session.save(emp);
			
			tx.commit();
			session.close();
			
		} 
		catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		
		
		return true;
	}

}
