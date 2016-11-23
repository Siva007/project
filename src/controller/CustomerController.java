package controller;
import model.BTSS;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ValidateCustomerRegistration;


public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CustomerController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("custname");
		String address=request.getParameter("address");
		String dateOfB=request.getParameter("dob");
		String gender=request.getParameter("sex");
		String num=(request.getParameter("contact"));
		String mail=request.getParameter("email");
		String idp=request.getParameter("idproof");
		ValidateCustomerRegistration v=new ValidateCustomerRegistration();
		int output=v.checkDetails(name,address,dateOfB,gender,num,mail,idp);
		BTSS obj=new BTSS();
		String msg=null;
		obj.createCustomer(name,address,dateOfB,gender,num,mail,idp);
		if(output==1)
		{
			
			out.println("Welcome "+ name);
		}
		else if(output==0)
		{
			msg="Invalid!! Employeeid cannot be blank";
			request.setAttribute("message",msg);
			//rd=this.getServletContext().getRequestDispatcher("/error.jsp");
			//rd.forward(request, response);
		}
		
		
		
	}

}
