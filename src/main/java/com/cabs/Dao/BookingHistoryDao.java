package com.cabs.Dao;



import java.util.List;

import com.cabs.model.ModelBookingDetails;


public interface BookingHistoryDao {
	List<ModelBookingDetails> bookingHistory(String email,String pass);

}