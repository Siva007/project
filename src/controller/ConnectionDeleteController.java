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
 * Servlet implementation class ConnectionDeleteController
 */
public class ConnectionDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnectionDeleteController() {
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
		PrintWriter out=response.getWriter();
		String str=request.getParameter("operation");
		
			if(str.equals("view"))
			{
				
				String no=request.getParameter("connectionNumber");
				long connectionNumber=Long.parseLong(no);
			
				BTSS obj=new BTSS();
				int output=obj.checkConnectionNumber(connectionNumber);
				RequestDispatcher rd=null;
				if(output==1)
				{
				
					rd=this.getServletContext().getRequestDispatcher("/ConnectionDeleteUI.jsp");
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
	
		
			String no=request.getParameter("connectionNumberHidden");
			
			
			
			BTSS b=new BTSS();
			
			b.deleteConnection(no);
			RequestDispatcher rd=null;
			
			rd=this.getServletContext().getRequestDispatcher("/check.html");
		    rd.forward(request, response);
			
		
			
			
			}
			
			}
	}


