package com.cabs.Dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cabs.util.HibernateCon;
import com.cabs.model.ModelBookingStatus;
import com.cabs.model.Request;


public class RejectRequestDao implements RejectRequest {

	@Override
	public boolean reject(Integer id) {
		Session session = HibernateCon.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Request r = (Request) session.get(Request.class, id);
			ModelBookingStatus cs = new ModelBookingStatus(3,"Rejected");
			//session.save(cs);
			r.setbId(cs);
			session.update(r);
			session.flush();
			tx.commit();
		} catch (HibernateException e) {
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