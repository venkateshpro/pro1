package com.cabs.Dao;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cabs.util.HibernateCon;
import com.cabs.model.ModelBookingStatus;
import com.cabs.model.Request;
import java.util.logging.Logger;

public class AcceptRequestDao implements AcceptRequest {
	private static final Logger logger = Logger.getLogger("AcceptRequest class");

	@Override
	public boolean acept(Integer id) {
		Session session = HibernateCon.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Request r = (Request) session.get(Request.class, id);
			ModelBookingStatus cs = new ModelBookingStatus(2,"Accepted");
			//session.save(cs);
			r.setbId(cs);
			session.update(r);
			session.flush();
			tx.commit();
			logger.info(" Booking Status is Accepted");
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