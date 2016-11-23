package controller;
import model.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConnectionController
 */
public class ConnectionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnectionController() {
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
         
		
		int cid=Integer.parseInt(request.getParameter("cid"));
		String btype=request.getParameter("btype");
		String bplan=request.getParameter("bplan");
		PrintWriter out=response.getWriter();
		out.print(bplan);
		
		
		
		BTSS b=new BTSS();
		b.createConnection(cid, btype, bplan);
		RequestDispatcher rd=null;
		String msg;
		msg="issue";
		request.setAttribute("message",msg);
		rd=this.getServletContext().getRequestDispatcher("/success.jsp");
	    rd.forward(request, response);
		
		
		
		
		
	}

}
