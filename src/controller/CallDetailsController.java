package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BTSS;


public class CallDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CallDetailsController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int cid=Integer.parseInt(request.getParameter("callid"));
		String bmonth=request.getParameter("month");
		String bdate=request.getParameter("date");
		String byear=request.getParameter("year");
		String temp=bmonth+"/"+bdate+"/"+byear;
		double dur=Double.parseDouble(request.getParameter("duration"));
		String ncm=request.getParameter("number");
		String type=request.getParameter("type");
		PrintWriter out=response.getWriter();
		out.print(cid);
		
		BTSS b=new BTSS();
		b.createCallDetails(cid, temp, dur, ncm,type);
		RequestDispatcher rd=null;
		
		rd=this.getServletContext().getRequestDispatcher("/CallDetailsUI.html");
	rd.forward(request, response);

		
	}

}
