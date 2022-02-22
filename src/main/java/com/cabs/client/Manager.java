package com.cabs.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Manager extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession s=request.getSession(false);
		String email = (String) s.getAttribute("email");
		String pass = (String) s.getAttribute("pass");
		
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "\r\n"
				+ "<head>\r\n"
				+ "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\" />\r\n"
				+ "    <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>\r\n"
				+ "    <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\" integrity=\"sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN\" crossorigin=\"anonymous\"></script>\r\n"
				+ "    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\" integrity=\"sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV\" crossorigin=\"anonymous\"></script>\r\n"
				+ "    <script src=\"https://kit.fontawesome.com/d1c2ea8b80.js\" crossorigin=\"anonymous\"></script>\r\n"
				+ "    <link rel=\"stylesheet\" href=\"Registation.css\">\r\n"
				+ "</head>\r\n"
				+ "\r\n"
				+ "<body>\r\n"
				+ "    <img src=\"https://res.cloudinary.com/dkzionr3v/image/upload/v1643985271/v_logo_png_ezwvk6.png\" class=\"navbar-image \" alt=\"\" />\r\n"
				+ "    <div class=\"sec-container\">\r\n"
				+ "        <h1 class=\"a_form-name\"> Welcome To Manager Page </h1>\r\n"
				+ "        <div class=\"select-container\">\r\n"
				+ "            <form method=\"post\" action=\"accept\" >\r\n"
				+ "                <button type=\"submit\"  class=\"Button-admin\">PendingRequest</button></a>\r\n"
				+ "               \r\n"
				+ "            </form>\r\n"
				+ "            \r\n"
				+ "\r\n"
				+ "            \r\n"
				+ "        </div>\r\n"
				+ "        \r\n"
				+ "    \r\n"
				+ "\r\n"
				+ "    </div>\r\n"
				+ "\r\n"
				+ "</body>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "</html>");
		
		
	}

}
