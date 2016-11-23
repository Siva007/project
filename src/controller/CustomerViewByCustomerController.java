package controller;
import model.BTSS;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;



public class CustomerViewByCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CustomerViewByCustomerController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		BTSS obj=new BTSS();
		int output=obj.checkCustomerId(Integer.valueOf("c.getCustomerId()"));
		out.println(output);
		/*RequestDispatcher rd=null;
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
		}*/
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		PrintWriter out=response.getWriter();
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
		
		
	}

}
