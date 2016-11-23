package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BTSS;


public class CallDetailsViewByAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CallDetailsViewByAdminController() 
    {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		out.println("get");
		String callId=request.getParameter("id");
		int newid=Integer.parseInt(callId);
		RequestDispatcher rd=null;
		rd=this.getServletContext().getRequestDispatcher("/CallDetailsSingleViewByAdminUI.jsp");
	    rd.forward(request, response);
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		out.println("Welcome");
		RequestDispatcher rd=null;
		BTSS b=new BTSS();
		boolean b1=b.checkCallDetails();
		if(b1==true)
		{
			
			rd=this.getServletContext().getRequestDispatcher("/CallDetailsViewByAdminUI.jsp");
		    rd.forward(request, response);
			
		}	
		else
		{
			rd=this.getServletContext().getRequestDispatcher("/error.html");
		    rd.forward(request, response);
		}
	}

}
