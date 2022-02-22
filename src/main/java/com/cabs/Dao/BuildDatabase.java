package com.cabs.Dao;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cabs.model.ModelCab;
import com.cabs.model.ModelEmp;
import com.cabs.util.HibernateCon;;



public class BuildDatabase {

	public static void main(String[] args) {
		
		Session session = HibernateCon.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		tx.commit();
		session.close();

	}
}

		
