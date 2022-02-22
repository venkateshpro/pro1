package com.cabs.Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cabs.model.ModelCab;
import com.cabs.util.HibernateCon;

public class CabRegistrationImpl implements CabRegister {
	
	public boolean register(ModelCab c) {
		Transaction tx=null;
		Session session = HibernateCon.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			session.save(c);
			tx.commit();	
		} 
		catch (Exception e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
			return false;
		}
		finally {
			session.close();
		}
		return true;
	}

}


