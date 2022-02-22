package com.cabs.Dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.cabs.model.Request;
import com.cabs.util.HibernateCon;

public class RequestPendingDaoImpl implements RequestPendingDao {

	@Override
	public List cabRequest() {
		Session session = HibernateCon.getSessionFactory().openSession();
		List alist = null;
		try {
			SQLQuery q=session.createSQLQuery("select * from request as r where r.bId= 1"); //HQL
			q.addEntity(Request.class);
			alist = q.list();
		} 
		catch (HibernateException e) {
			
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return alist;
	}

	@Override
	public List pendingRequest() {
		Session session = HibernateCon.getSessionFactory().openSession();
		List alist = null;
		try {
			SQLQuery q=session.createSQLQuery("select * from request as r where r.bId= 2"); //HQL
			q.addEntity(Request.class);
			alist = q.list();
		} 
		catch (HibernateException e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return alist;
	}

	
}