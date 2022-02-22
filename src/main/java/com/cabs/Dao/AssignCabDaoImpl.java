package com.cabs.Dao;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cabs.model.ModelBookingDetails;
import com.cabs.model.ModelBookingStatus;
import com.cabs.model.ModelCab;
import com.cabs.model.Request;
import com.cabs.util.HibernateCon;

public class AssignCabDaoImpl implements AssignCabDao {

	private static final Logger logger = Logger.getLogger("AssignCabDaoImpl.class");

	@Override
	public boolean assign(Integer id) {
		Session session = HibernateCon.getSessionFactory().openSession();
		List clist = null;
		List rlist = null;
		Transaction tx=null;
		
		logger.info("With in Assign Cab Dao Implementation");

		try {
			tx=session.getTransaction();
			tx.begin();
			SQLQuery c=session.createSQLQuery("select * from cab as c where c.status= 1"); //HQL
			c.addEntity(ModelCab.class);
			clist = c.list();
			
			logger.info("Cab got selected");
			
			SQLQuery r=session.createSQLQuery("select * from request as r where r.requestId= :rqst"); //HQL
			r.addEntity(Request.class);
			r.setParameter("rqst", id);
			rlist = r.list();
			
			logger.info("Particular Request got selected");
			
			Iterator it = clist.iterator();
			Iterator ite = rlist.iterator();
			if(it.hasNext() && ite.hasNext()) {
				ModelCab c1 = (ModelCab) it.next();
				Request r1 = (Request) ite.next();
				
				ModelBookingDetails bd = new ModelBookingDetails(c1,r1.getEmp());
				ModelBookingStatus bs = new ModelBookingStatus(4,"Booked");
				logger.info("Objects got created");
				session.save(bd);
				logger.info("Saved into booking details ");
				c1.setStatus(0);
				r1.setBookingId(bd);
				r1.setbId(bs);
				session.update(c1);
				logger.info("updated cab's booking status");
				session.update(r1);
				logger.info("updated request table with booking id");
				session.flush();
			}
			else {
				return false;
			}
			tx.commit();
		} 
		catch (HibernateException e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
			return false;
		}
		finally {
			session.close();
		}
		return true;
	}

}