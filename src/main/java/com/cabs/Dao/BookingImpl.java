package com.cabs.Dao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cabs.util.HibernateCon;
import com.cabs.model.ModelBookingStatus;
import com.cabs.model.ModelEmp;
import com.cabs.model.Request;

public class BookingImpl implements Booking {
	
	public boolean requestCab() {
		Session session = HibernateCon.getSessionFactory().openSession();
		
		Transaction tx=null;
		try {
			//Session session = HibernateCon.getSessionFactory().openSession();
			tx = session.beginTransaction();
			ModelBookingStatus b = new ModelBookingStatus(1,"Requested");
			//session.save(b);
			for(ModelEmp e : ValidateUser.elist) {
			Request rq = new Request(e,b);
			session.save(rq);
			
			}

			
			tx.commit();
			
			//session.close();
			return true;
		} catch (HibernateException e) {
			if (tx != null) {
                tx.rollback();
            }
			e.printStackTrace();
		}
		
		finally {
			
			session.close();
		}
		return false;
	}

}
