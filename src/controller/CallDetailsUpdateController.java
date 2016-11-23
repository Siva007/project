package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BTSS;


public class CallDetailsUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CallDetailsUpdateController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		
	}
			


	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		String str=request.getParameter("operation");
		if(str.equals("view"))
		{
			
		String no=request.getParameter("callid");
			int callid=Integer.parseInt(no);
		
			BTSS obj=new BTSS();
			int output=obj.checkCallid(callid);
			RequestDispatcher rd=null;
			if(output==1)
			{
			
				rd=this.getServletContext().getRequestDispatcher("/CallDetailsUpdateUI.jsp");
				rd.forward(request, response);
			}
			else if(output==0)
			{
				out.println("error");
				rd=this.getServletContext().getRequestDispatcher("/error.html");
				rd.forward(request, response);
			}
			
		}
		
		if(str.equals("update"))
		{
		
		out.println("Welcome update");
		
		
		
		
		BTSS b=new BTSS();
		b.updateCallDetails(request);
		RequestDispatcher rd=null;
		
		rd=this.getServletContext().getRequestDispatcher("/sample-template.html");
	    rd.forward(request, response);
		
		
		
		
		}
		
		}
}


	