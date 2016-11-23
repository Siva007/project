package com.tcs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.model.BTSS;
import com.tcs.model.CallDetails;




//class begins
public class CallDetailsControllerD extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    public CallDetailsControllerD() //constructor
    {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException //do get method
	{
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  //do post method
	{
		
		try
		{

		PrintWriter pw = response.getWriter();    //used for printing
		CallDetails c =new CallDetails ();
		BTSS ABC=new BTSS();
		String page = null;
		page=request.getParameter("checkpage");
		System.out.println(page);
		
	//for uploading a file
		if(null!=request.getParameter("checkpage")&&request.getParameter("checkpage").equals("upload"))
		{
			String filecsv = request.getParameter("upfile");
		    ABC.filecalc(filecsv);
		    RequestDispatcher dispatcher = request.getRequestDispatcher("UploadCl1.jsp");
		    dispatcher.forward(request, response);
		 }
	
		
		//for viewing details by id
		if(null!=request.getParameter("checkpage")&&request.getParameter("checkpage").equals("viewall"))
		{System.out.println("entered first controller");
			ArrayList<CallDetails> sb=ABC.viewallCl();
			request.setAttribute("viewall",sb);
			if(sb.size()!=0){
			RequestDispatcher dispatcher = request.getRequestDispatcher("ViewId.jsp");
		    dispatcher.forward(request, response);
			}
			else response.sendRedirect("ViewId.jsp?msg1=No List Found");
		}
		
		
		//for viewing all the details
		if(null!=request.getParameter("checkpage")&&request.getParameter("checkpage").equals("viewall1"))
		{
			System.out.println("entered controller");
		String val1=request.getParameter("callId");
		System.out.println(val1);
		c.setCallid(Integer.parseInt(val1));
		int x=c.getCallid();
		System.out.println("value of x is"+x);
	
	
		c=ABC.viewCall(c);
		    request.setAttribute("con", c);
		    RequestDispatcher rd=request.getRequestDispatcher("ViewOut.jsp");
			rd.forward(request,response);
		}
				
	
		if(null!=request.getParameter("checkpage")&&request.getParameter("checkpage").equals("update"))	
		{
			System.out.println("entered controller");
			String val1=request.getParameter("callId");
			System.out.println(val1);
			c.setCallid(Integer.parseInt(val1));
			int x=c.getCallid();
			System.out.println("value of x is"+x);
		
			c=ABC.viewCall(c); 
		    request.setAttribute("Call Details",c);
			RequestDispatcher rd=request.getRequestDispatcher("UpdateCl1.jsp");
			rd.forward(request,response);
			}
		if(null!=request.getParameter("checkpage")&&request.getParameter("checkpage").equals("Delete"))
			{
			int result=0;
			String val1=request.getParameter("callId");
			System.out.println(val1);
			c.setCallid(Integer.parseInt(val1));
			int x=c.getCallid();
			System.out.println("entered controller");
			result=ABC.deletefile(c);
			if(result!=0)
			{
				System.out.println("result is"+result);
				System.out.println("recieved result");
			request.getSession().setAttribute("con1",c);
		    RequestDispatcher rd1=request.getRequestDispatcher("DeleteCl1.jsp");
			rd1.forward(request,response);
			}
			else
			{
				System.out.println("recieved failed result is"+result);
				response.sendRedirect("DeleteFail.jsp?msg=Past 30 days Call Details cannot be deleted");	
			}
		}
		
			
		//viewing
		if(null!=request.getParameter("checkpage")&&request.getParameter("checkpage").equals("viewall2"))
		{
			System.out.println("hi");
			ArrayList<CallDetails> sb=ABC.viewallCl();
			request.setAttribute("viewall",sb);
			if(sb.size()!=0)
			{
				System.out.println("size is not zero");
				RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateCl.jsp");
			    dispatcher.include(request, response);
				}else response.sendRedirect("UpdateCl.jsp?msg1=No List Found");

		}
		
		
		//viewing
		if(null!=request.getParameter("checkpage")&&request.getParameter("checkpage").equals("viewall3"))
		{
			System.out.println("entered controller viewall3");
			ArrayList<CallDetails> sb=ABC.viewallCl();
			request.setAttribute("viewall",sb);
			if(sb.size()!=0){
			RequestDispatcher dispatcher = request.getRequestDispatcher("DeleteCl.jsp");
		    dispatcher.include(request, response);
			}else response.sendRedirect("DeleteCl.jsp?msg1=No List Found");
		}
		
		
		
	//	
	if(null!=request.getParameter("checkpage")&&request.getParameter("checkpage").equals("id"))
	{
	String a=request.getParameter("ID");
		c.setCallid(Integer.parseInt(a));
		
		if(ABC.checkcl((Integer.parseInt(a))))
		{
			c=ABC.viewCall(c);
		    request.setAttribute("con", c);
		    RequestDispatcher rd=request.getRequestDispatcher("ViewOut.jsp");
			rd.forward(request,response);
		}
		else 
			response.sendRedirect("ViewId.jsp?msg=Invalid Call ID");
	  
		}
	
	
	//
	if(null!=request.getParameter("checkpage")&&request.getParameter("checkpage").equals("id1"))
	{
		String a=request.getParameter("ID");
			c.setCallid(Integer.parseInt(a));
			
			if(ABC.checkcl((Integer.parseInt(a))))
			{
				c=ABC.viewCall(c);
			    request.setAttribute("Call Details", c);
			    RequestDispatcher rd=request.getRequestDispatcher("UpdateCl1.jsp");
				rd.forward(request,response);
			}
			else 
				response.sendRedirect("UpdateCl.jsp?msg=Invalid Call ID");
			}
	
	
	
	//delete call detail
	if(null!=request.getParameter("checkpage")&&request.getParameter("checkpage").equals("id2"))
	{
		String a=request.getParameter("ID");
			c.setCallid(Integer.parseInt(a));
			
			if(ABC.checkcl((Integer.parseInt(a))))
			{
				int res=0;
			    res=ABC.deletefile(c);
				if(res!=0)
				{
				request.getSession().setAttribute("con1",c);
		 	    RequestDispatcher rd=request.getRequestDispatcher("DeleteCl1.jsp");
				rd.forward(request,response);
				}
				else 
				{
					response.sendRedirect("DeleteFail.jsp?msg=Past 30 days Call Details cannot be deleted");
				}
				
			}
			else 
			{
				response.sendRedirect("DeleteCl.jsp?msg=Invalid Call ID");
			}
	}
	//
	if(null!=request.getParameter("checkpage")&&request.getParameter("checkpage").equals("CallDetails"))
	{
	
		int a=Integer.parseInt(request.getParameter("radio"));
		int b=Integer.parseInt(request.getParameter("c"));
		String f=request.getParameter("f");
		long g=Long.parseLong(request.getParameter("g"));
		c.setCallid(a);
		c.setDuration(b);
		c.setCalltype(f);
		c.setDialno(g);
	    ABC.viewCall1(c); 
	    c=ABC.viewCall(c);
	    request.setAttribute("con", c);
	    RequestDispatcher rd=request.getRequestDispatcher("ViewOut.jsp");
		rd.forward(request,response);
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
		
	}//end of do post method
	
	}//end of class


	
