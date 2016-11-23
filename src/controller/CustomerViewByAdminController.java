package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BTSS;

/**
 * Servlet implementation class CustomerViewByAdminController
 */
public class CustomerViewByAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerViewByAdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String id=request.getParameter("id");
		int newid=Integer.parseInt(id);
		RequestDispatcher rd=null;
		rd=this.getServletContext().getRequestDispatcher("/CustomerViewByCustomerUI.jsp");
	    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		out.println("Welcome");
		if(request.getParameter("customerviewbyadmin")=="View All Customer Details");
		{
		
		RequestDispatcher rd=null;
		BTSS b=new BTSS();
		boolean b1=b.checkCustomerDetails();
		if(b1==true)
		{
			
			rd=this.getServletContext().getRequestDispatcher("/CustomerViewByAdminUI.jsp");
		    rd.forward(request, response);
			
		}	
		else
		{
			rd=this.getServletContext().getRequestDispatcher("/error.html");
		    rd.forward(request, response);
		}
	}
		/* if(request.getParameter("customerviewbyadmin1")=="View Single Customer Details")
		{
			String id=request.getParameter("id");
			int customerId=Integer.valueOf(id);
		
			BTSS obj=new BTSS();
			int output=obj.checkCustomerId(customerId);
			RequestDispatcher rd=null;
			if(output==1)
			{
			
				rd=this.getServletContext().getRequestDispatcher("/CustomerViewByCustomerUI.jsp");
				rd.forward(request, response);
			}
			else if(output==0)
			{
				out.println("error");
				//rd=this.getServletContext().getRequestDispatcher("/incorrect.html");
				//rd.forward(request, response);
			}
			
		}*/
	}
	}


