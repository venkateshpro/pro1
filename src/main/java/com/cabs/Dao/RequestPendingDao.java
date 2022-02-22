package com.cabs.Dao;



import java.util.List;

import com.cabs.model.Request;


public interface RequestPendingDao {
	
	List cabRequest();

	List pendingRequest();

}