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
 * Servlet implementation class CallDetailsSingleController
 */
public class CallDetailsSingleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CallDetailsSingleController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out=response.getWriter();
		BTSS obj=new BTSS();
		int output=obj.checkCallid(Integer.valueOf("c.getCallId()"));
		out.println(output);
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		BTSS obj=new BTSS();
		String id=request.getParameter("Callid");
		out.println(id);
		int output=obj.checkCallid(Integer.parseInt(id));
		
		RequestDispatcher rd=null;
		if(output==1)
		{
			out.println("hello");
		
			rd=this.getServletContext().getRequestDispatcher("/CallDetailsViewById.jsp");
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
