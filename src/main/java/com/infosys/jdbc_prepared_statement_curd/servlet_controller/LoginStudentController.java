package com.infosys.jdbc_prepared_statement_curd.servlet_controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.infosys.jdbc_prepared_statement_curd.dao.UserDao;
import com.infosys.jdbc_prepared_statement_curd.dto.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginStudentController extends HttpServlet{;;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		   //create session
		 
		   HttpSession  httpSession =  req.getSession();
		   String email = req.getParameter("useremail");
  	       String password = req.getParameter("userpassword");
  	                   
  	       User user = new UserDao().getUserByEmail(email);
  	       
  	       PrintWriter printWriter = resp.getWriter();
  	       
  	       
  	       if(user!=null) {
  	    	   
  	    	   if(password.equals(user.getPassword())) {
  	    		   
  	    		 httpSession.setAttribute("userSession", email);
  	    		 httpSession.setMaxInactiveInterval(160);//  SET THE TIME FOR SESSION OUT IN 1440 SECOND
  	    		 
  	    		   req.getRequestDispatcher("user_display.jsp").forward(req, resp);
  	    		   
  	    	   }
  	    	   else {
  	    		   
  	    	        req.setAttribute("message", "⚠️ Password is incorrect");
  	    		   
  	    		   req.getRequestDispatcher("user_login.jsp").forward(req, resp);
  	    		   
  	    	   }
		
	        }
  	       else {
  	    	 req.setAttribute("message", "⚠️ Email does not exist");
  	  	         req.getRequestDispatcher("user_login.jsp").include(req, resp);
	        }
	}
}