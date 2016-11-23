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
 * Servlet implementation class ConnectionViewByAdminController
 */
public class ConnectionViewByAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnectionViewByAdminController() {
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
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		out.println("Welcome");
		RequestDispatcher rd=null;
		BTSS b=new BTSS();
		boolean b1=b.checkConnectionDetails();
		if(b1==true)
		{
			
			rd=this.getServletContext().getRequestDispatcher("/ConnectionViewByAdminUI.jsp");
		    rd.forward(request, response);
			
		}	
		else
		{
			rd=this.getServletContext().getRequestDispatcher("/error.html");
		    rd.forward(request, response);
		}
		
	}

}
