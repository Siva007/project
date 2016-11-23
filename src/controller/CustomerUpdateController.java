package controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BTSS;
import model.ValidateCustomerRegistration;

/**
 * Servlet implementation class CustomerUpdateController
 */
public class CustomerUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String str=request.getParameter("operation");

		if(str.equals("view"))
		{
			PrintWriter out=response.getWriter();
			String id=request.getParameter("customerId");
			int customerId=Integer.valueOf(id);
		
			BTSS obj=new BTSS();
			int output=obj.checkCustomerId(customerId);
			RequestDispatcher rd=null;
			if(output==1)
			{
			
				rd=this.getServletContext().getRequestDispatcher("/CustomerUpdateUI.jsp");
				rd.forward(request, response);
			}
			else if(output==0)
			{
				out.println("error");
				//rd=this.getServletContext().getRequestDispatcher("/incorrect.html");
				//rd.forward(request, response);
			}
			
			
		}

		 if(str.equals("update"))
		 {
			 PrintWriter out=response.getWriter();
			    out.println("welcome");
				ValidateCustomerRegistration v=new ValidateCustomerRegistration();
				int output=v.checkUpdateDetails(request);
				
				if(output==1)
				{
					
					out.println("Successful Updations");
					
				}
				
				else if(output==0)
				{
					out.println("Sorry.Please fill the feilds.");
				}
				BTSS b1=new BTSS();
				b1.updateCustomer(request);
		 }
		}
}


