package com.cabs.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cabs.Dao.CabRegister;
import com.cabs.Dao.CabRegistrationImpl;
import com.cabs.model.ModelCab;




public class CabRegistration extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		Integer cabNo = Integer.parseInt(request.getParameter("cabNo"));
		String driverName = request.getParameter("driverName");
		String driverMobile = request.getParameter("driverMobile");
		
		ModelCab cab = new ModelCab(cabNo,1,driverName,driverMobile);
		
		
		CabRegister cReg = new CabRegistrationImpl();
		boolean confirm = cReg.register(cab);
		
		if(confirm)
			out.println("<!DOCTYPE html>\r\n"
					+ "<html lang=\"en\">\r\n"
					+ "\r\n"
					+ "<head>\r\n"
					+ "    <meta charset=\"utf-8\">\r\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n"
					+ "    <title>Bootstrap Simple Success Confirmation Popup</title>\r\n"
					+ "    <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Roboto|Varela+Round\">\r\n"
					+ "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\">\r\n"
					+ "    <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/icon?family=Material+Icons\">\r\n"
					+ "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n"
					+ "    <script src=\"https://code.jquery.com/jquery-3.5.1.min.js\"></script>\r\n"
					+ "    <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\"></script>\r\n"
					+ "    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js\"></script>\r\n"
					+ "    <style>\r\n"
					+ "        body {\r\n"
					+ "            font-family: 'Varela Round', sans-serif;\r\n"
					+ "        }\r\n"
					+ "\r\n"
					+ "        .modal-confirm {\r\n"
					+ "            color: #636363;\r\n"
					+ "            width: 325px;\r\n"
					+ "            font-size: 14px;\r\n"
					+ "        }\r\n"
					+ "\r\n"
					+ "        .modal-confirm .modal-content {\r\n"
					+ "            padding: 20px;\r\n"
					+ "            border-radius: 5px;\r\n"
					+ "            border: none;\r\n"
					+ "        }\r\n"
					+ "\r\n"
					+ "        .modal-confirm .modal-header {\r\n"
					+ "            border-bottom: none;\r\n"
					+ "            position: relative;\r\n"
					+ "        }\r\n"
					+ "\r\n"
					+ "        .modal-confirm h4 {\r\n"
					+ "            text-align: center;\r\n"
					+ "            font-size: 26px;\r\n"
					+ "            margin: 30px 0 -15px;\r\n"
					+ "        }\r\n"
					+ "\r\n"
					+ "        .modal-confirm .form-control,\r\n"
					+ "        .modal-confirm .btn {\r\n"
					+ "            min-height: 40px;\r\n"
					+ "            border-radius: 3px;\r\n"
					+ "        }\r\n"
					+ "\r\n"
					+ "        .modal-confirm .close {\r\n"
					+ "            position: absolute;\r\n"
					+ "            top: -5px;\r\n"
					+ "            right: -5px;\r\n"
					+ "        }\r\n"
					+ "\r\n"
					+ "        .modal-confirm .modal-footer {\r\n"
					+ "            border: none;\r\n"
					+ "            text-align: center;\r\n"
					+ "            border-radius: 5px;\r\n"
					+ "            font-size: 13px;\r\n"
					+ "        }\r\n"
					+ "\r\n"
					+ "        .modal-confirm .icon-box {\r\n"
					+ "            color: #fff;\r\n"
					+ "            position: absolute;\r\n"
					+ "            margin: 0 auto;\r\n"
					+ "            left: 0;\r\n"
					+ "            right: 0;\r\n"
					+ "            top: -70px;\r\n"
					+ "            width: 95px;\r\n"
					+ "            height: 95px;\r\n"
					+ "            border-radius: 50%;\r\n"
					+ "            z-index: 9;\r\n"
					+ "            background: #82ce34;\r\n"
					+ "            padding: 15px;\r\n"
					+ "            text-align: center;\r\n"
					+ "            box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.1);\r\n"
					+ "        }\r\n"
					+ "\r\n"
					+ "        .modal-confirm .icon-box i {\r\n"
					+ "            font-size: 58px;\r\n"
					+ "            position: relative;\r\n"
					+ "            top: 3px;\r\n"
					+ "        }\r\n"
					+ "\r\n"
					+ "        .modal-confirm.modal-dialog {\r\n"
					+ "            margin-top: 80px;\r\n"
					+ "        }\r\n"
					+ "\r\n"
					+ "        .modal-confirm .btn {\r\n"
					+ "            color: #fff;\r\n"
					+ "            border-radius: 4px;\r\n"
					+ "            background: #82ce34;\r\n"
					+ "            text-decoration: none;\r\n"
					+ "            transition: all 0.4s;\r\n"
					+ "            line-height: normal;\r\n"
					+ "            border: none;\r\n"
					+ "        }\r\n"
					+ "\r\n"
					+ "        .modal-confirm .btn:hover,\r\n"
					+ "        .modal-confirm .btn:focus {\r\n"
					+ "            background: #6fb32b;\r\n"
					+ "            outline: none;\r\n"
					+ "        }\r\n"
					+ "\r\n"
					+ "        .trigger-btn {\r\n"
					+ "            display: inline-block;\r\n"
					+ "            margin: 100px auto;\r\n"
					+ "        }\r\n"
					+ "        .ok_btn{\r\n"
					+ "	        width: 250px;\r\n"
					+ "        }\r\n"
					+ "    </style>\r\n"
					+ "</head>\r\n"
					+ "\r\n"
					+ "<body>\r\n"
					+ "    <div id=\"myModal\">\r\n"
					+ "        <div class=\"modal-dialog modal-confirm\">\r\n"
					+ "            <div class=\"modal-content\">\r\n"
					+ "                <div class=\"modal-header\">\r\n"
					+ "                    <div class=\"icon-box\">\r\n"
					+ "                        <i class=\"material-icons\">&#xE876;</i>\r\n"
					+ "                    </div>\r\n"
					+ "                    <h4 class=\"modal-title w-100\">Awesome!</h4>\r\n"
					+ "                </div>\r\n"
					+ "                <div class=\"modal-body\">\r\n"
					+ "                    <p class=\"text-center\">Your Registration has been Successfull..</p>\r\n"
					+ "                </div>\r\n"
					+ "                <div class=\"modal-footer\">\r\n"
					+ "                   <a href=\"Admin.java\"><button class=\"btn btn-success btn-block ok_btn\" data-dismiss=\"modal\">OK</button></a> \r\n"
					+ "                </div>\r\n"
					+ "            </div>\r\n"
					+ "        </div>\r\n"
					+ "    </div>\r\n"
					+ "\r\n"
					+ "    <!-- Modal HTML -->\r\n"
					+ "\r\n"
					+ "</body>\r\n"
					+ "\r\n"
					+ "</html>");
		else
			out.println("Error Occoured");
	}

}
