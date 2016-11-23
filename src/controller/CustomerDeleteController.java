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
 * Servlet implementation class CustomerDeleteController
 */
public class CustomerDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerDeleteController() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			
				rd=this.getServletContext().getRequestDispatcher("/CustomerDeleteUI.jsp");
				rd.forward(request, response);
			}
			else if(output==0)
			{
				out.println("error");
				//rd=this.getServletContext().getRequestDispatcher("/incorrect.html");
				//rd.forward(request, response);
			}
			
			
		}

		 if(str.equals("delete"))
		 {
			 PrintWriter out=response.getWriter();
			    
			 
				BTSS b1=new BTSS();
				b1.deleteCustomer(request);
		 }
		}
	}


