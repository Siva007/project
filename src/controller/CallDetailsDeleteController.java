package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BTSS;


public class CallDetailsDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CallDetailsDeleteController() {
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
			
				rd=this.getServletContext().getRequestDispatcher("/CallDetailsDeleteUI.jsp");
				rd.forward(request, response);
			}
			else if(output==0)
			{
				out.println("error");
				rd=this.getServletContext().getRequestDispatcher("/error.html");
				rd.forward(request, response);
			}
			
		}
		
		if(str.equals("delete"))
		 {
			
			  
				BTSS b1=new BTSS();
				b1.deleteCallDetails(request);
		 }
		/*if(str.equals("delete"))
		{
		
		out.println("Welcome delete");
		
		
		String no=request.getParameter("callidhiddden");
		int cid=Integer.parseInt(no);
	
		BTSS b=new BTSS();
		b.deleteCallDetails();
		RequestDispatcher rd=null;
		
		rd=this.getServletContext().getRequestDispatcher("/CallDetailsSuccess.html");
	    rd.forward(request, response);
		
		

		
		}
		*/
		}
}


	