package com.cabs.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cabs.Dao.AssignCabDao;
import com.cabs.Dao.AssignCabDaoImpl;

public class Assign extends HttpServlet {

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		HttpSession s=request.getSession(false);
		String email = (String) s.getAttribute("email");
		String pass = (String) s.getAttribute("pass");
		Integer requestId = (Integer) s.getAttribute("requestId");
		
		
		AssignCabDao ac = new AssignCabDaoImpl();
		ac.assign(requestId);
		
		RequestDispatcher rd=request.getRequestDispatcher("AssignCab");
		rd.include(request, response);
	}

}