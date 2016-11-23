package com.tcs.controller;
import com.tcs.model.BTSS;


import com.tcs.model.ConnectionIssue;
import com.tcs.model.Tariff;
import com.tcs.DAO.BTSSDAO;
import com.tcs.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.lang.StringBuffer;


//class begins
public class ConnectionControllerD extends HttpServlet
{
	ArrayList <ConnectionIssue> connectionList =new ArrayList <ConnectionIssue>();
	ArrayList <Tariff> tariffList =new ArrayList <Tariff>();

	private static final long serialVersionUID = 1L;
       
  
    public ConnectionControllerD()   //constructor
    {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException     //do get method
	{
		
		try{
			doPost(request,response);
			}
			catch(Exception e)
			{
				
				StringBuffer msg=new StringBuffer();
				RequestDispatcher rd=null;
				msg.append("Server Encountered a problem <br></br> Please try again."); 
				request.setAttribute("message",msg);
				rd=this.getServletContext().getRequestDispatcher("/connectionerror.jsp"); //I am using connectionerror page
			    rd.forward(request, response);	
			}
				
		}

	
	//do post method begins
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			
		try
		{
			
		PrintWriter out=response.getWriter();	//for printing
		StringBuffer msg=new StringBuffer();
	
		
		/*String ch=null;
		ch=request.getParameter("option");
		
		////start page
		if(ch==null)
		{
			RequestDispatcher rd=null;
		    rd=this.getServletContext().getRequestDispatcher("/ConnectionUIStart.jsp");
		    rd.forward(request, response);		
		}
		*/
		
		
		
		//issue begin
		if(null!=request.getParameter("option")&& request.getParameter("option").equals("issuebegin"))
		{
			BTSS b=new BTSS();
			tariffList=b.issueBegin();
			if(tariffList.isEmpty())
			{
				RequestDispatcher rd=null;
				msg.append("No tariff details found to begin ISSUE <br></br>Please Add Tariff");
				request.setAttribute("message",msg);
				rd=this.getServletContext().getRequestDispatcher("/connectionerror.jsp");
			    rd.forward(request, response);	
			}
			else
			{
			RequestDispatcher rd=null;
		    request.setAttribute("tarList",tariffList);
		    rd=this.getServletContext().getRequestDispatcher("/ConnectionUIStart.jsp");
		    rd.forward(request, response);	
			}
		}
	
		
		//issue with plan
		if(null!=request.getParameter("option")&& request.getParameter("option").equals("issue"))
		{
			if(null!=request.getParameter("cid") && null!=request.getParameter("btype") && null != request.getParameter("bplan"))
		    {
				int cid=Integer.parseInt(request.getParameter("cid"));
				String btype=request.getParameter("btype");
				String bplan=request.getParameter("bplan");
				BTSS b=new BTSS();
			    msg=b.createConnectionIssue(cid, btype, bplan);
				RequestDispatcher rd=null;
				request.setAttribute("message",msg);
				rd=this.getServletContext().getRequestDispatcher("/connectionsuccess.jsp");
			    rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd=null;
			    msg.append("There are null values in issue"); 
				request.setAttribute("message",msg);
				rd=this.getServletContext().getRequestDispatcher("/connectionerror.jsp");
			    rd.forward(request, response);	
			
			}
					
		}// end of issue condition.
		
		
		//view all details by admin
		if(request.getParameter("option").equals("viewalladmin"))
		{
			BTSS b=new BTSS();
			connectionList=b.viewAllConnection();
			if(connectionList.isEmpty())
			{
				RequestDispatcher rd=null;
				msg.append("No details found for this Connection");
				request.setAttribute("message",msg);
				rd=this.getServletContext().getRequestDispatcher("/connectionerror.jsp");
			    rd.forward(request, response);	
			}
			else
			{
			RequestDispatcher rd=null;
			request.setAttribute("connList",connectionList);
			rd=this.getServletContext().getRequestDispatcher("/ConnectionViewByAdminUI.jsp");
		    rd.forward(request, response);
			}
		}//end of viewalladmin condtion
		
		
		//view by id 
		if(request.getParameter("option").equals("viewbyidadmin"))
		{
			RequestDispatcher rd=null;
			request.setAttribute("message",msg);
			rd=this.getServletContext().getRequestDispatcher("/ConnectionViewByCustomerUIStart.jsp");
		    rd.forward(request, response);
		}
		
		
		//single details view
		if(request.getParameter("option").equals("singleview"))
		{		
			
			if(null!=request.getParameter("connectionNumber"))
			{
				String no=request.getParameter("connectionNumber");
				long connNo=Long.parseLong(no);
				BTSS b=new BTSS();
				connectionList=b.viewSingleConnection(connNo);
				if(connectionList.isEmpty())
				{
					RequestDispatcher rd=null;
					msg.append("No details found<br></br> Invalid connection number : "+no);
					request.setAttribute("message",msg);
					rd=this.getServletContext().getRequestDispatcher("/connectionerror.jsp");
				    rd.forward(request, response);	
				}
				else
				{
				RequestDispatcher rd=null;
			    request.setAttribute("connList",connectionList);
				rd=this.getServletContext().getRequestDispatcher("/ConnectionViewBySingle.jsp");
			    rd.forward(request, response);	
				}
		
			}
			else
			{
				
				RequestDispatcher rd=null;
				msg.append("Null values"); 
				request.setAttribute("message",msg);
				rd=this.getServletContext().getRequestDispatcher("/connectionerror.jsp");
			    rd.forward(request, response);	
			
			}
		}//end of singleview condition
		
		
		
		//view by customer
		if(request.getParameter("option").equals("customerview"))
		{	
		
			if(null!=request.getParameter("id"))
			{
				
				BTSS b=new BTSS();
				String no=request.getParameter("id");
				int cusid=Integer.parseInt(no);
				System.out.println(cusid);
				
			    connectionList=null;
				connectionList=b.viewCustomerAllConnection(cusid);
				if(connectionList.isEmpty())
				{
					RequestDispatcher rd=null;
					msg.append("No details found.Invalid customer id"+no);
					request.setAttribute("message",msg);
					rd=this.getServletContext().getRequestDispatcher("/connectionerror.jsp");
				    rd.forward(request, response);	
				}
				else
				{
				RequestDispatcher rd=null;
				request.setAttribute("connList",connectionList);
				rd=this.getServletContext().getRequestDispatcher("/ConnectionViewByAdminUI.jsp");
			    rd.forward(request, response);
				}
				
			}
			else
			{
				RequestDispatcher rd=null;
				msg.append("Null  values"); 
				request.setAttribute("message",msg);
				rd=this.getServletContext().getRequestDispatcher("/connectionerror.jsp");
			    rd.forward(request, response);	
			}
		
		}//end of customerview condition
		
		
		//view my connection
		if(request.getParameter("option").equals("myconnectionview"))
		{	
		
			if(null!=request.getParameter("id"))
			{
				
				BTSS b=new BTSS();
				String no=request.getParameter("id");
				int cusid=Integer.parseInt(no);
				System.out.println(cusid);
				
			    connectionList=null;
				connectionList=b.viewCustomerAllConnection(cusid);
				if(connectionList.isEmpty())
				{
					RequestDispatcher rd=null;
					msg.append("No details found for Customer id"+no);
					request.setAttribute("message",msg);
					rd=this.getServletContext().getRequestDispatcher("/newerror.jsp");
				    rd.forward(request, response);	
				}
				else
				{
				RequestDispatcher rd=null;
				request.setAttribute("connList",connectionList);
				rd=this.getServletContext().getRequestDispatcher("/MyConnectionViewAll.jsp");
			    rd.forward(request, response);
				}
				
			}
			else
			{
				RequestDispatcher rd=null;
				msg.append("There are null values present"); 
				request.setAttribute("message",msg);
				rd=this.getServletContext().getRequestDispatcher("/connectionerror.jsp");
			    rd.forward(request, response);	
			}
		
		}//end of myconnectionview condition
		
		
		
		//view single view by admin
		if(request.getParameter("option").equals("mysingleview"))
		{		
			
			if(null!=request.getParameter("connectionNumber"))
			{
				String no=request.getParameter("connectionNumber");
				long connNo=Long.parseLong(no);
				BTSS b=new BTSS();
				connectionList=b.viewSingleConnection(connNo);
				if(connectionList.isEmpty())
				{
					RequestDispatcher rd=null;
					msg.append("No details found for connection Number "+no);
					request.setAttribute("message",msg);
					rd=this.getServletContext().getRequestDispatcher("/connectionerror.jsp");
				    rd.forward(request, response);	
				}
				else
				{
				RequestDispatcher rd=null;
			    request.setAttribute("connList",connectionList);
				rd=this.getServletContext().getRequestDispatcher("/MyConnectionViewSingle.jsp");
			    rd.forward(request, response);	
				}
		
			}
			else
			{
				
				RequestDispatcher rd=null;
				msg.append("There are null values present"); 
				request.setAttribute("message",msg);
				rd=this.getServletContext().getRequestDispatcher("/connectionerror.jsp");
			    rd.forward(request, response);	
			
			}
		}//end of mysingleview condition
	

		//update connection
		if(request.getParameter("option").equals("updateconnection"))
		{		
			if(null!=request.getParameter("connectionNumber"))
			{
		
				BTSS b=new BTSS();
				String no=request.getParameter("connectionNumber");
				long connNo=Long.parseLong(no);
				connectionList=b.updateConnectionIssue(connNo);
			
				if(connectionList.isEmpty())
				{
					RequestDispatcher rd=null;
					msg.append("No details found<br></br> Invalid connection number : "+no);
					request.setAttribute("message",msg);
					rd=this.getServletContext().getRequestDispatcher("/connectionerror.jsp");
				    rd.forward(request, response);	
			 
				}
				
				String status=connectionList.get(0).getStatus();
		     	if(status.equals("cancelled"))
				{

					RequestDispatcher rd=null;
					msg=new StringBuffer("Unable to update Connection : "+no+"<br> </br> The status is  already in cancelled state");
					request.setAttribute("message",msg);
				    rd=this.getServletContext().getRequestDispatcher("/connectionerror.jsp");
				    rd.forward(request,response);	
				}
			
				
				BTSS b1=new BTSS();
				tariffList=b1.issueBegin();
				if(tariffList.isEmpty())
				{
						RequestDispatcher rd=null;
						msg.append("No tariff details found");
						request.setAttribute("message",msg);
						rd=this.getServletContext().getRequestDispatcher("/connectionerror.jsp");
					    rd.forward(request, response);	
				}
				
				//If All done then go to the connection update JSP page
			
					RequestDispatcher rd=null;
				    request.setAttribute("tarList",tariffList);
				    request.setAttribute("connList",connectionList);
			        rd=this.getServletContext().getRequestDispatcher("/ConnectionUpdateUI.jsp");
			        rd.forward(request,response);
			 		
				
	
			}
			else
			{

				RequestDispatcher rd=null;
				msg.append("There are null values present"); 
				request.setAttribute("message",msg);
				rd=this.getServletContext().getRequestDispatcher("/connectionerror.jsp");
			    rd.forward(request, response);	
			}
		}//end of updateconnetion condtion
		
		
		
		//updated finally
	if(request.getParameter("option").equals("finalupdate"))
		{
			if(null!=request.getParameter("connectionNumber")&& null!=request.getParameter("btype") && null != request.getParameter("bplan"))
			{
				
				String no=request.getParameter("connectionNumber");
				String no1=no.substring(0, 10);				
				long connNo=Long.parseLong(no1);
				String btype=request.getParameter("btype");
				String bplan=request.getParameter("bplan");
						
												
				BTSS b1=new BTSS();
				msg=b1.updateFinalConnectionIssue(connNo,btype,bplan);
				
				if(!msg.equals("updatesuccess"))
				{
		     	RequestDispatcher rd=null;
				request.setAttribute("message","Connection Number:"+no1+"<br></br>Updated successfully ");
				rd=this.getServletContext().getRequestDispatcher("/connectionsuccess.jsp");
			    rd.forward(request, response);
				}
				else
				{
					RequestDispatcher rd=null;
					msg.append("Error updating connection number "+no);
					request.setAttribute("message",msg);
					rd=this.getServletContext().getRequestDispatcher("/connectionerror.jsp");
				    rd.forward(request, response);	
				}
				}
			
			else
			{
				
				

				RequestDispatcher rd=null;
				msg.append("There are null values present"); 
				request.setAttribute("message",msg);
				rd=this.getServletContext().getRequestDispatcher("/connectionerror.jsp");
			    rd.forward(request, response);	
		
			}
					
		}//end of finalupdate condtion




	//delete connection
		if(request.getParameter("option").equals("deleteconnection"))
		{		
			if(null!=request.getParameter("connectionNumber"))
			{
				
				BTSS b=new BTSS();
				String no=request.getParameter("connectionNumber");
				String no1=no.substring(0, 10);				
				long connNo=Long.parseLong(no1);
				connectionList=b.updateConnectionIssue(connNo);
			
		     	if(connectionList.isEmpty())
				{
					RequestDispatcher rd=null;
					msg.append("No details found<br></br> Invalid connection number : "+no);
					request.setAttribute("message",msg);
					rd=this.getServletContext().getRequestDispatcher("/connectionerror.jsp");
				    rd.forward(request,response);	
				}
		     	
		     	String status=connectionList.get(0).getStatus();
		     	if(status.equals("cancelled"))
				{

					RequestDispatcher rd=null;
					msg=new StringBuffer("Unable to delete connection number: "+no+"<br> </br>The status is already in  cancelled state");
					request.setAttribute("message",msg);
				    rd=this.getServletContext().getRequestDispatcher("/connectionerror.jsp");
				    rd.forward(request,response);	
				}
			
				else
				{
					
				RequestDispatcher rd=null;
				request.setAttribute("connList",connectionList);
			    rd=this.getServletContext().getRequestDispatcher("/ConnectionDeleteUI.jsp");
			    rd.forward(request,response);
				}
			
			}
			else
			{
				RequestDispatcher rd=null;
				msg.append("There are null values present"); 
				request.setAttribute("message",msg);
				rd=this.getServletContext().getRequestDispatcher("/connectionerror.jsp");
			    rd.forward(request, response);	
			}
		
		}//end of deleteconnetion condtion
		

		
		//deleted finally
		if(request.getParameter("option").equals("finaldelete"))
		{
			if(null!=request.getParameter("connectionNumber"))
			{
				
				BTSS b=new BTSS();
				String no=request.getParameter("connectionNumber");
				String r=request.getParameter("reason");
				String no1=no.substring(0, 10);				
				long connNo=Long.parseLong(no1);
			  	msg=b.deleteFinalConnectionIssue(connNo,r);
			  	
				if(!msg.equals("deletesuccess"))
				{
				//msg.append("Connection status Cancelled successfully "+connNo);
				RequestDispatcher rd=null;
				request.setAttribute("message","Connection Number: "+no1+"is cancelled successfully ");
				rd=this.getServletContext().getRequestDispatcher("/connectionsuccess.jsp");
			    rd.forward(request, response);
				}
			    else
				{
					RequestDispatcher rd=null;
					msg.append("Error deleting connection number "+connNo);
					request.setAttribute("message",msg);
					rd=this.getServletContext().getRequestDispatcher("/connectionerror.jsp");
				    rd.forward(request, response);	
				}
				
			
				
			}
			else
			{

				RequestDispatcher rd=null;
				msg.append("There are null values present"); 
				request.setAttribute("message",msg);
				rd=this.getServletContext().getRequestDispatcher("/connectionerror.jsp");
			    rd.forward(request, response);	
			}
			
		}//end of finaldelete condtion
		
		
		//for tariff plans
		if(request.getParameter("option").equals("tariff1"))
		{
			
			
			
			if(null!=request.getParameter("tcode")&& null!=request.getParameter("monthlyRental")&& null !=request.getParameter("local")&& null!=request.getParameter("std")&&null!=request.getParameter("isd"))
			{
				System.out.println("Hello here for tariffd");
				
				String tcode1=request.getParameter("tcode");
				
				String s=request.getParameter("monthlyRental");
				double monthlyRental1=Double.parseDouble(s);
				double local1=Double.parseDouble(request.getParameter("local"));
				double std1=Double.parseDouble(request.getParameter("std"));
				double isd1=Double.parseDouble(request.getParameter("isd"));
				
				BTSS b=new BTSS();
			    msg=b.createTariff(tcode1,monthlyRental1,local1,std1,isd1);
				RequestDispatcher rd=null;
				request.setAttribute("message",msg);
				rd=this.getServletContext().getRequestDispatcher("/connectionsuccess.jsp");
			    rd.forward(request, response);
			
			}
			else
			{
				System.out.println("Tariff d else");
				
				/*RequestDispatcher rd=null;
				msg.append("Null values in tariff"); 
				request.setAttribute("message",msg);
				rd=this.getServletContext().getRequestDispatcher("/connectionerror.jsp");
			    rd.forward(request, response);	*/
			
			}
		
		}//end of tariff condtion
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//for viewing tariff plans
		if(request.getParameter("option").equals("tariffview"))
		{
			BTSS b=new BTSS();
			tariffList=b.viewAllTariff();
			if(tariffList.isEmpty())
			{
				RequestDispatcher rd=null;
				msg.append("No Tariff details found"); 
				request.setAttribute("message",msg);
				rd=this.getServletContext().getRequestDispatcher("/connectionerror.jsp");
			    rd.forward(request, response);	
			}
			else
			{
			RequestDispatcher rd=null;
			request.setAttribute("tarList",tariffList);
			rd=this.getServletContext().getRequestDispatcher("/ConnectionViewTariff.jsp");
		    rd.forward(request, response);
			}
			
		}//end of tariffview condtion
	
		
		
		
		
		
		
		}//end of try for post method
		
		
		
		catch(Exception e)
		{
			StringBuffer msg=new StringBuffer();
			RequestDispatcher rd=null;
			msg.append("No details found"); 
			request.setAttribute("message",msg);
			rd=this.getServletContext().getRequestDispatcher("/connectionerror.jsp");
		    rd.forward(request, response);	
		}//end of catch for post method
		
	
		
		
		
		
		
		
			
					
		
}//end of doPost method
}//end of ConnectionControllerD Servlet.
