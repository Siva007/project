package com.tcs.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tcs.DAO.LoginDAO;

//class begins
public class Login2Controller extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    
    public Login2Controller()	//constructor
    {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		try{
		doPost(request,response);
		}
		catch(Exception e)
		{
			
			RequestDispatcher rd=null;
			String msg1;
			msg1="Server encoutered some problem <br> </br> Please try again";
			request.setAttribute("message",msg1);
			rd=this.getServletContext().getRequestDispatcher("/message.jsp");
			rd.forward(request, response);	
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			
			String l=request.getParameter("operation");
			
			if(l.compareTo("logout")==0)
			{
				RequestDispatcher rd=null;
				javax.servlet.http.HttpSession session = request.getSession(); 
				//session.setAttribute("SessionUser",null);
				session.invalidate();

  			rd=this.getServletContext().getRequestDispatcher("/home.jsp");
				 rd.forward(request,response);
			}
				
			
			if(l.compareTo("home")==0)
			{
				RequestDispatcher rd=null;
				
				rd=this.getServletContext().getRequestDispatcher("/home.jsp");
				 rd.forward(request,response);
			}
			
			
			
			
			
			if(l.compareTo("Corporate")==0)
			{
				RequestDispatcher rd=null;
				
				rd=this.getServletContext().getRequestDispatcher("/Corporate.jsp");
				 rd.forward(request,response);
			}
			
			
			if(l.compareTo("Services")==0)
			{
				RequestDispatcher rd=null;
				
				rd=this.getServletContext().getRequestDispatcher("/Services.jsp");
				 rd.forward(request,response);
			}
			
			
			
			if(l.compareTo("About")==0)
			{
				RequestDispatcher rd=null;
				
				rd=this.getServletContext().getRequestDispatcher("/AboutUs.jsp");
				 rd.forward(request,response);
			}
			
			
			
			if(l.compareTo("Admin")==0)
			{
				RequestDispatcher rd=null;
				
				rd=this.getServletContext().getRequestDispatcher("/sample-admin.jsp");
				 rd.forward(request,response);
			}
			
			
			
			
			
			if(l.compareTo("Customer")==0)
			{
				RequestDispatcher rd=null;
				
				rd=this.getServletContext().getRequestDispatcher("/sample-cus.jsp");
				 rd.forward(request,response);
			}
			
			
			
			
			
			if(l.compareTo("login")==0)
			{
				RequestDispatcher rd=null;
				rd=this.getServletContext().getRequestDispatcher("/login.jsp");
				 rd.forward(request,response);
			}
			
			
			if(l.compareTo("contact")==0)
			{
				RequestDispatcher rd=null;
				
				rd=this.getServletContext().getRequestDispatcher("/ContactUs.jsp");
				 rd.forward(request,response);
			}
			
			
			
			if(l.compareTo("Internet")==0)
			{
				RequestDispatcher rd=null;
				
				rd=this.getServletContext().getRequestDispatcher("/IntNet.jsp");
				 rd.forward(request,response);
			}
			
			if(l.compareTo("Vision")==0)
			{
				RequestDispatcher rd=null;
				
				rd=this.getServletContext().getRequestDispatcher("/MiVi.jsp");
				 rd.forward(request,response);
			}
			
			
			
			
			
			if(l.compareTo("Global")==0)
			{
				RequestDispatcher rd=null;
			
				rd=this.getServletContext().getRequestDispatcher("/GloPre.jsp");
				 rd.forward(request,response);
			}
			
			
			
		//global variables for reuse
		String log=request.getParameter("logname");
		String pw=request.getParameter("pwd");
		String op=request.getParameter("oldp");
		String np=request.getParameter("newp");
		String cp=request.getParameter("confirmp");
		String opt=request.getParameter("operation");
		String id=request.getParameter("custid");
		RequestDispatcher rd=null;
		
		ArrayList<String> arr=new ArrayList<String>();;
		//for checking the login credentials
		if((null!=opt)&&(opt.compareTo("logincheck")==0))
		{
		LoginDAO ld=new LoginDAO();
		
		arr=ld.checkCredentials(log,pw);
		String val=(String)arr.get(0);
		System.out.println("val is"+val);
		int output=Integer.parseInt(val);
		System.out.println("output is"+output);
		String name=arr.get(1);
		System.out.println("name is "+name);
		if(output==1)	//admin credentials
		{
			String cust="Welcome"+log;
		request.setAttribute("result",cust);
		javax.servlet.http.HttpSession session = request.getSession(); 
		session.setAttribute("SessionUser","admin");
		System.out.println("checking"+(String)session.getAttribute("SessionUser"));	
		 rd=this.getServletContext().getRequestDispatcher("/sample-admin.jsp");
		rd.forward(request,response);
		System.out.println("Request 1");
		}
		
		if(output==2)			//first time customer login goes to change password
		{
		
			javax.servlet.http.HttpSession session = request.getSession(); 
			session.setAttribute("SessionUser",null);
			request.setAttribute("id",log);
			session.setAttribute("SessionUserName", name);
			rd=this.getServletContext().getRequestDispatcher("/ChangePassword.jsp");
			rd.forward(request,response);
			System.out.println("Request 2");
		}
		
		if(output==3)		//customer credentials with changed password
		{
			String cust="Welcome  "+log;
			request.setAttribute("result",cust);
			String custid=log;
			
			request.setAttribute("customerid",custid);
			javax.servlet.http.HttpSession session = request.getSession(); 
			session.setAttribute("SessionUser", custid);
			session.setAttribute("SessionUserName", name);
			
			System.out.println("checking"+(String)session.getAttribute("SessionUser"));
			rd=this.getServletContext().getRequestDispatcher("/sample-cus.jsp");
			rd.forward(request,response);
			System.out.println("Request 2");
		}
		
		
		if(output==0)		//invalid credentials
		{
			String msg="INVALID LOGIN CREDENTIALS";
			javax.servlet.http.HttpSession session = request.getSession(); 
			session.setAttribute("SessionUser",null);
			request.setAttribute("failed",msg);
			 rd=this.getServletContext().getRequestDispatcher("/error2.jsp");
			 rd.forward(request,response);
			 System.out.println("Request 0");
		}
		}
		
		
		//change password
		
		else if((null!=opt)&&(opt.compareTo("changepwd")==0))
		{
			System.out.println("change pwd"+op+""+np+""+cp);
			System.out.println(id);
			try
			{
			LoginDAO ld=new LoginDAO();
			if(!(np.equals(cp)))
			{
			rd=this.getServletContext().getRequestDispatcher("/passworderror.jsp");
			 rd.forward(request,response);
			}
			else
			{
			int output=ld.checkLogin(op,np,cp,id);
			
			if(output==1)		//change password sucessful moves to login page
			{
				javax.servlet.http.HttpSession session = request.getSession(); 
				session.setAttribute("SessionUser",null);
				rd=this.getServletContext().getRequestDispatcher("/login.jsp");
				rd.forward(request,response);
				System.out.println("Request 1");
			}
			
			else if(output==2)		//invalid
			{
				javax.servlet.http.HttpSession session = request.getSession(); 
				session.setAttribute("SessionUser",null);
				String msg="Password is already changed.Login please";
				request.setAttribute("failed",msg);
				 rd=this.getServletContext().getRequestDispatcher("/error2.jsp");
				 rd.forward(request,response);
				 System.out.println("Request 2");
			}
			else if(output==0)		//invalid
			{
				javax.servlet.http.HttpSession session = request.getSession(); 
				session.setAttribute("SessionUser",null);
				String msg="INVALID LOGIN CREDENTIALS";
				request.setAttribute("failed",msg);
				 rd=this.getServletContext().getRequestDispatcher("/error2.jsp");
				 rd.forward(request,response);
				 System.out.println("Request 0");
			}
			}
			}
			
			catch(Exception e)
			{
				System.out.println(e);
			}
			
			
			
			
			
			
		}
		}
		catch(Exception e)
		{
		
			RequestDispatcher rd=null;
			String msg1;
			msg1="Server encoutered some problem <br> </br> Please try again";
			request.setAttribute("message",msg1);
			rd=this.getServletContext().getRequestDispatcher("/message.jsp");
			rd.forward(request, response);		
		}
		
		
	}//end of do post

}//end of class
