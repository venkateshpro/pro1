package com.cabs.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cabs.Dao.ValidateUser;

public class Login extends HttpServlet {
	private static final Logger logger = Logger.getLogger("login.class");
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String email=request.getParameter("id");
		String pwd=request.getParameter("ipass");
		Integer dropdown = Integer.parseInt(request.getParameter("dropdown"));
		//out.println(dropdown + " "+ id + " " + pwd);
		
		switch(dropdown) {
		case 1:{
			//Employee
			if(ValidateUser.check(email, pwd)) {
				logger.info("Logged in as Employee");
				HttpSession s=request.getSession(true);
				s.setMaxInactiveInterval(10000);
				s.setAttribute("email",email);
				s.setAttribute("pass", pwd);
				out.println("<!DOCTYPE html>\r\n"
						+ "<html>\r\n"
						+ "\r\n"
						+ "<head>\r\n"
						+ "<style>\r\n"
						+ ".btns {\r\n"
						+ "    color: #ff8000;\r\n"
						+ "    background-color: transparent;\r\n"
						+ "    border-width: 0px;\r\n"
						+ "    margin-right: 20px;\r\n"
						+ "    margin-top: 20px;\r\n"
						+ "    font-weight: 700;\r\n"
						+ "    font-size: 20px;\r\n"
						+ "  \r\n"
						+ "}\r\n"
						+ "</style>\r\n"
						+ "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\" />\r\n"
						+ "    <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>\r\n"
						+ "    <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\" integrity=\"sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN\" crossorigin=\"anonymous\"></script>\r\n"
						+ "    <script src=\"https://kit.fontawesome.com/d1c2ea8b80.js\" crossorigin=\"anonymous\"></script>\r\n"
						+ "    <meta name='viewport' content='width=device-width, initial-scale=1'>\r\n"
						+ "    <link rel=\"stylesheet\" href=\"Cabbooking.Home.css\">\r\n"
						+ "    <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>\r\n"
						+ "    <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\" integrity=\"sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN\" crossorigin=\"anonymous\"></script>\r\n"
						+ "\r\n"
						+ "    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\" integrity=\"sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV\" crossorigin=\"anonymous\"></script>\r\n"
						+ "</head>\r\n"
						+ "\r\n"
						+ "<body>\r\n"
						+ "    <div class=\"d-flex justify-content-between\">\r\n"
						+ "        <div>\r\n"
						+ "            <img src=\"https://res.cloudinary.com/dkzionr3v/image/upload/v1643985271/v_logo_png_ezwvk6.png\" style=\"margin: 10px\" class=\"navbar-image \"  alt=\"\"/>\r\n"
						+ "        </div>\r\n"
						+ "        <div style=\"margin-top: 20px\">\r\n"
						+ "            <a href=\"index.login.html\"><buuton class=\"btns\" >Logout</buuton></a>\r\n"
						+ "        </div>\r\n"
						+ "    </div>\r\n"
						+ " \r\n"
						+ "    <div class=\" bg-color-home\" id=\"Homesection\" style=\"margin-top: 10px\">\r\n"
						+ "        <h1 class=\"vr-home-heading\">Welcome To <span class=\"span-1\">Cab Booking</span></h1>\r\n"
						+ "\r\n"
						+ "    </div>\r\n"
						+ "    <div class=\"section_b-home\">\r\n"
						+ "        <div id=\"holder\">\r\n"
						+ "\r\n"
						+ "            <div class=\"button\">\r\n"
						+ "                <!--p class=\"btnText\">REQUEST CAB</p-->\r\n"
						+ "                <form method=\"post\" action=\"CabBooking\">\r\n"
						+ "                    <button class=\"btnText\" type=\"submit\" id=\"login-button\">REQUEST CAB</button>\r\n"
						+ "                </form>\r\n"
						+ "                <div class=\"btnTwo\">\r\n"
						+ "                    <p class=\"btnText2\">GO!</p>\r\n"
						+ "                </div>\r\n"
						+ "            </div>\r\n"
						+ "\r\n"
						+ "            <div class=\"button\">\r\n"
						+ "                <form method=\"post\" action=\"BookingHistory\">\r\n"
						+ "                    <button class=\"btnText\" type=\"submit\" id=\"login-button\">HISTORY</button>\r\n"
						+ "                </form>\r\n"
						+ "                <div class=\"btnTwo\">\r\n"
						+ "                    <p class=\"btnText2\"><i class='fas fa-arrow-circle-right'></i></p>\r\n"
						+ "                </div>\r\n"
						+ "            </div>\r\n"
						+ "\r\n"
						+ "        </div>\r\n"
						+ "    </div>\r\n"
						+ "    <div class=\"pt-5 pb-5 text-center bg-color-footer-section\" id=\"footer-section\">\r\n"
						+ "        <div class=\"container\">\r\n"
						+ "            <div class=\"row\">\r\n"
						+ "                <div class=\"col-12 col-md-4\">\r\n"
						+ "                    <div class=\"text-md-left\">\r\n"
						+ "\r\n"
						+ "                    </div>\r\n"
						+ "                    <div class=\"col-12\">\r\n"
						+ "                        <div class=\"d-flex flex-row justify-content-center\">\r\n"
						+ "                            <div class=\"follow-us-icon-container\">\r\n"
						+ "                                <a href=\"https://nagaportfolio.ccbp.tech/\"><i class=\"fab fa-google icon\"></i></a>\r\n"
						+ "                            </div>\r\n"
						+ "                            <div class=\"follow-us-icon-container\">\r\n"
						+ "                                <a href=\"https://twitter.com/?lang=en-in\"><i class=\"fab fa-twitter icon\"></i></a>\r\n"
						+ "                            </div>\r\n"
						+ "                            <div class=\"follow-us-icon-container\">\r\n"
						+ "                                <a href=\"https://www.instagram.com/venkatesh__venkii\"><i class=\"fab fa-instagram icon\"></i></a>\r\n"
						+ "                            </div>\r\n"
						+ "                            <div class=\"follow-us-icon-container\">\r\n"
						+ "                                <a href=\"https://www.linkedin.com/in/naga-venkatesh-787446211/\"><i class=\"fab fa-linkedin-in icon\"></i></a>\r\n"
						+ "                            </div>\r\n"
						+ "                        </div>\r\n"
						+ "                        <p class=\"address-footter-section\">\r\n"
						+ "                            Teynampet 12th floor,Anna Salai,Chennai,Tamil Nadu,India.\r\n"
						+ "                        </p>\r\n"
						+ "                    </div>\r\n"
						+ "                </div>\r\n"
						+ "                <div class=\"col-6 col-md-4\">\r\n"
						+ "                    <div class=\" text-left \">\r\n"
						+ "                        <h1 class=\"contact-us-heading \">Contact Us</h1>\r\n"
						+ "                        <ul class=\"vr-fotter-section-list\">\r\n"
						+ "                            <li class=\"mb-4\">\r\n"
						+ "                                <i class=\"fas fa-envelope icon-1 m-2\"></i>\r\n"
						+ "                                <span class=\"icon-text\">vv@gmail.com</span>\r\n"
						+ "                            </li>\r\n"
						+ "                            <li class=\"mb-4\">\r\n"
						+ "                                <i class=\"fas fa-phone-alt icon-1 m-2\"></i>\r\n"
						+ "                                <span class=\"icon-text\">7288842873</span>\r\n"
						+ "                            </li>\r\n"
						+ "                            <li class=\"mb-4\">\r\n"
						+ "                                <i class=\"fab fa-skype icon-1 m-2\"></i>\r\n"
						+ "                                <span class=\"icon-text\">Venkatesh</span>\r\n"
						+ "                            </li>\r\n"
						+ "                        </ul>\r\n"
						+ "                    </div>\r\n"
						+ "                </div>\r\n"
						+ "                <div class=\"col-6 col-md-4\">\r\n"
						+ "                    <div class=\" text-left \">\r\n"
						+ "                        <h1 class=\"contact-us-heading \">Let Us Help You</h1>\r\n"
						+ "                        <ul class=\"vr-fotter-section-list\">\r\n"
						+ "                            <li class=\"mb-4 icon-text\">Costumer feedback </li>\r\n"
						+ "                            <li class=\"mb-4 icon-text \">Your Account</li>\r\n"
						+ "                            <li class=\"mb-4 icon-text\">Return Center Help</li>\r\n"
						+ "                        </ul>\r\n"
						+ "                    </div>\r\n"
						+ "                </div>\r\n"
						+ "            </div>\r\n"
						+ "            <hr class=\"hr-line\" />\r\n"
						+ "            <div>\r\n"
						+ "                <i class=\"far fa-copyright icon\"></i>\r\n"
						+ "                <span class=\"icon-text\">2022 by Venkatesh.For Project Presentation.</span>\r\n"
						+ "            </div>\r\n"
						+ "        </div>\r\n"
						+ "    </div>\r\n"
						+ "</body>\r\n"
						+ "\r\n"
						+ "</html>");
				//RequestDispatcher rd=request.getRequestDispatcher("Employee.java");
				//rd.include(request, response);
			}
			else {
					logger.info("Wrong Employee Credentials!");
					
					RequestDispatcher rd=request.getRequestDispatcher("alert.html");
					rd.include(request, response);
				}
				
			break;
		}
		case 2:{
			//Manager
			if(ValidateUser.checkMan(email, pwd)) {
				HttpSession s=request.getSession(true);
				s.setMaxInactiveInterval(10000);
				s.setAttribute("id",email);
				s.setAttribute("pass", pwd);
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
						+ "            <form method=\"post\" action=\"PendingRequest\" >\r\n"
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
			else {
				logger.info("Wrong Credentials of Manager");
				RequestDispatcher rd=request.getRequestDispatcher("alert.html");
				rd.include(request, response);
			}
			break;
		}
		case 3:{
			//Admin
			if(email.equalsIgnoreCase("admin") && pwd.equalsIgnoreCase("123")) {
				HttpSession s=request.getSession(true);
				s.setMaxInactiveInterval(10000);
				s.setAttribute("id",email);
				s.setAttribute("pass", pwd);
				//RequestDispatcher rd=request.getRequestDispatcher("AdminPage.html");
				//rd.include(request, response);
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
						+ "        <h1 class=\"a_form-name\"> Welcome To Admin Page </h1>\r\n"
						+ "        <div class=\"select-container\">\r\n"
						+ "            <a href=\"./EmployeeRegistration.html\"><button class=\"Button-admin\">Add Employee</button></a>\r\n"
						+ "            <a href=\"./CabRegistration.html\"><button class=\"Button-admin\">Add Cab</button></a>\r\n"
						+ "            \r\n"
						+ "            <form method=\"post\" action=\"AssignCab\">\r\n"
						+ "            	<button class=\"Button-admin\">Assign Cab</button>\r\n"
						+ "            </form>\r\n"
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
		
		else {
			logger.info("Wrong Admin Credentials");
			RequestDispatcher rd=request.getRequestDispatcher("alert.html");
			rd.include(request, response);
		}
		break;
		
		}
			
		}
	}

}