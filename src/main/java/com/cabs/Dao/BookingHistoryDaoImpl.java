package com.cabs.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import com.cabs.model.ModelBookingDetails;
import com.cabs.util.HibernateCon;


public class BookingHistoryDaoImpl implements BookingHistoryDao{

	public List bookingHistory(String email, String pass) {
		Session session = HibernateCon.getSessionFactory().openSession();
		List alist=null;
		try {
			String sql = "Select b.bookingId,b.cabNo,e.id from bdetails as b, employee as e where e.email= :email and b.id=e.id";
			SQLQuery q = session.createSQLQuery(sql);
			q.setParameter("email", email);
			q.addEntity(ModelBookingDetails.class);
			alist = q.list();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		
		return alist;
	}

}