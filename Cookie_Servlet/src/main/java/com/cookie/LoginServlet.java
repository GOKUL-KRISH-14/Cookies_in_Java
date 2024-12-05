package com.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet 
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		res.setContentType("text/html");  
        PrintWriter out=res.getWriter();  
          
        req.getRequestDispatcher("link.html").include(req, res);  
          
        String nameCheck="admin";
        String passCheck="admin";
        
        String name=req.getParameter("name");  
        String password=req.getParameter("password");  
          
        if(name.equals(nameCheck)&&password.equals(passCheck))
        {  
        	out.print("<center>");
            out.print("You are successfully logged in!");  
            out.print("<br>Welcome, "+name);  
            out.print("<br>");
            out.print("</center>");
            Cookie ck=new Cookie("name",name);  
            res.addCookie(ck);  
        }
        else
        {  
        	
            out.print("sorry, username or password error!");  
            req.getRequestDispatcher("login.html").include(req, res);  

        }  
          
        out.close();  
    }  
}

