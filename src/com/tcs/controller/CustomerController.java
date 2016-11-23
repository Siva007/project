package com.tcs.controller;
import com.tcs.model.BTSS




;        //import the relevant files
import com.tcs.model.Customer;
import com.tcs.model.ValidateCustomerRegistration;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


//class begins
public class CustomerController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
   
    public CustomerController() //constructor
    {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException //do get method
	{
		
		//view single customer on click begins
		doPost(request,response);
		
		
	}//end of do get method

	
	//do post method begins
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		try
		{
		PrintWriter out=response.getWriter();   //to print variables
		RequestDispatcher rd=null;               //for navigation
		
		//global variables for reuse purpose
		String msg=null;
		String name=request.getParameter("custname");
		String address=request.getParameter("address");
		String dateOfB=request.getParameter("dob");
		String gender=request.getParameter("sex");
		String regis=request.getParameter("fillp");
		String num=(request.getParameter("contact"));
		String mail=request.getParameter("email");
		String idp=request.getParameter("idproof");
		String Img=request.getParameter("image");
		String ack=request.getParameter("ackid");
		String custid=request.getParameter("customerId");
		System.out.println(name);
		
		String opt=request.getParameter("operation");
		System.out.println("operation is"+opt);
		
        String checkAdd=null;
		
		
	
		
		
		//adding a customer begins
		
		if((null!=opt)&&(opt.compareTo("addcust")==0))
		{
			//String AddressProof=request.getParameter("AddressProof");
			//String AddressImage=request.getParameter("AddressImage");
		ValidateCustomerRegistration v=new ValidateCustomerRegistration();
		int output=v.checkDetails(name,address,dateOfB,gender,num,mail,regis);
		

		ArrayList <Customer> arr=new ArrayList<Customer>();
	
		if(output==1)
		{
			
		    
		
			try
			{
				BTSS obj=new BTSS();
				
				
				/*
				
				
				
				ArrayList<File> al=new ArrayList<File>();
				
				int cid = 0;
				
				
				boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			
				if (!isMultipart) 
				{
				} 
				else 
				{
					DiskFileItemFactory factory = new DiskFileItemFactory();
			 		factory.setSizeThreshold(1000000);
			 		ServletFileUpload upload = new ServletFileUpload(factory);
					List items = null;
					try 
					{
						items = upload.parseRequest(request);
					} 
					catch (FileUploadException e) 
					{
						e.printStackTrace();
					}
					
					Iterator itr = items.iterator();
					while (itr.hasNext()) 
					{
						FileItem item = (FileItem) itr.next();
						
						if (item.isFormField()) 
						{
						
							
							try 
							{
								String itemName = item.getName();
								File savedFile = new File(getServletContext().getRealPath("/image")+"/"+new Date().getTime()+".jpg");
								item.write(savedFile); 
								al.add(savedFile);						
							} 
				
				
				
				
							catch(Exception e)
							{
								msg="Invalid!! Some error took place "+e.getMessage();
								request.setAttribute("message",msg);
								rd=this.getServletContext().getRequestDispatcher("/message.jsp");
								rd.forward(request, response);
							}
				
				
				
				
				
				
						}
				
				
					}
				
				}
				

				File addimg=al.get(0);
				File idimg=al.get(1);
				
				
				
				*/
			 arr=obj.createCustomer(name,address,dateOfB,gender,num,mail);
			 
			 int id=0;
			 String p=null;
			 int acid=0;
			for(Customer c: arr)
			{
				 id=c.getCustomerId();
				 p=c.getPassword();
				 acid=c.getAcknowlegmentId();
				 System.out.println(id);
				 System.out.println(p);
				 System.out.println(acid);
				 
				 
			}
			if(acid==0)
			{
				msg="Invalid!! customer is not saved";
				request.setAttribute("message",msg);
				rd=this.getServletContext().getRequestDispatcher("/message.jsp");
				rd.forward(request, response);
			}
			else
			{
				
				if(acid!=0)
				{
					if(regis.equals("Skip"))
					{
					System.out.println("ack id is"+acid);
			msg="Success!! Welcome -- "+name;
			request.setAttribute("name",name);
			request.setAttribute("ackid",acid);
			request.setAttribute("message",msg);
			rd=this.getServletContext().getRequestDispatcher("/AcknowRegistration.jsp");
			rd.forward(request, response);
					}
					else if(regis.equals("Fill"))
					{
						System.out.println("welcome user");
						HttpSession session=request.getSession();
						session.setAttribute("acid", acid);
						System.out.println("attr is"+session.getAttribute("acid"));
						rd=this.getServletContext().getRequestDispatcher("/CompleteYourRegistration.jsp");
						rd.forward(request, response);
					}
				}
				/*else
				{
					System.out.println("customer id is"+id);
					System.out.println("paswrd is"+p);
					request.setAttribute("name",name);
					request.setAttribute("customerid",id);
					request.setAttribute("password",p);
					msg="Success!! Welcome -- "+name;
					request.setAttribute("message",msg);
					rd=this.getServletContext().getRequestDispatcher("/SuccessfulCustomer.jsp");
					rd.forward(request, response);
				}*/
			}
			
			}
		
			catch(Exception e)
			{
				msg="Invalid!! Some error took place "+e.getMessage();
				request.setAttribute("message",msg);
				rd=this.getServletContext().getRequestDispatcher("/message.jsp");
				rd.forward(request, response);
			}
		}
		else if(output==0)
		{
			
			msg="Invalid!! Fields cannot be blank";
			request.setAttribute("message",msg);
			rd=this.getServletContext().getRequestDispatcher("/message.jsp");
			rd.forward(request, response);
		}
		
		
		}//add customer ends
		
		// view form before updating registration begins
		
		else if(opt.compareTo("viewupdateregis")==0)
		{
			
			int acid=Integer.valueOf(ack);
			
			
		
			System.out.println("hello update ");
			try
			{
				ArrayList <Customer> arr=new ArrayList<Customer>();
				BTSS obj=new BTSS();
			arr=obj.checkAckId(acid);
			Customer c=new Customer();
			System.out.println("came back");
			String nam=null;
			String add=null;
			String dob=null;
			String gen=null;
			String number=null;
			String emailid=null;
			String da=null;
			int le=arr.size();
			System.out.println("size of arraylist is"+le);
			
			
			
//Date Check Begins
		
			Date yesterday = null;
			//Convert database String to date
			String dbdate=arr.get(0).getRegDate();
			System.out.println("DBDATE:" + dbdate);
			DateFormat df = new SimpleDateFormat("dd.MMM.yyyy"); 
			
			try {  
				System.out.println("With in try");
		       	 yesterday = (Date)df.parse(dbdate);  
		         System.out.println("Yesterday = " + df.format(yesterday));  
		    	} 
		    catch (java.text.ParseException e) 
		    	{
					System.out.println(e);
				}  
		    
		  //Get Current Date
		    DateFormat dateFormat = new SimpleDateFormat("dd.MMM.yyyy");
			Date date = new Date();
			String d2=dateFormat.format(date).toString();
			System.out.println("today:"+ d2);
			
			//get day1
			SimpleDateFormat sdf = new SimpleDateFormat("dd"); 
			int day1 = Integer.parseInt(sdf.format(date)); 
			System.out.println("Date: today" + day1);
			
			//get day2
			int day2 = Integer.parseInt(sdf.format(yesterday)); 
			System.out.println("Date: yesterday" + day2);
			
			//Find Difference
			int results = day2-day1;
			System.out.println("Diff:" + results);
			
//Date check ends
			
			if((le==1)&&(results<=10))
			{
			
			for(int i=0;i<arr.size();i++)
			{
				nam=arr.get(i).getCustomerName();
				add=arr.get(i).getAddress();
				dob=arr.get(i).getDateOfBirth();
				gen=arr.get(i).getGender();
				emailid=arr.get(i).getEmailId();
				number=arr.get(i).getPhoneNumber();
				
			}
		
		
		    request.setAttribute("ackid", acid);
			request.setAttribute("name",nam);
			request.setAttribute("add",add);
			request.setAttribute("dob",dob);
			request.setAttribute("gen",gen);
			request.setAttribute("num",number);
			request.setAttribute("mail",emailid);
			rd=this.getServletContext().getRequestDispatcher("/UpdateRegistration.jsp");
			rd.forward(request, response);
			}
			
			
			else if(le!=1)
			{
				System.out.println("oops");
				msg="Invalid!! No customer exists ";
				request.setAttribute("message",msg);
				
				rd=this.getServletContext().getRequestDispatcher("/message.jsp");
				rd.forward(request, response);
			}
			
			else 
			{
				msg="Your Registration has been Cancelled, Please begin it from first";
				request.setAttribute("message", msg);
				rd=this.getServletContext().getRequestDispatcher("/message.jsp");
		    	rd.forward(request, response);	
			}
			
			}
			catch(Exception e)
			{
				msg="You have already completed your registration. ";
				request.setAttribute("message",msg);
				rd=this.getServletContext().getRequestDispatcher("/message.jsp");
				rd.forward(request, response);
			}
		}  //view ends
		
		
		

		// form for updating registration begins
		
		else if((null!=opt)&&(opt.compareTo("updateforreg")==0))
		{
			try
			{
			int acid=Integer.valueOf(request.getParameter("ack"));
			if(acid!=0)
			{
				System.out.println("welcome user");
				HttpSession session=request.getSession();
				session.setAttribute("acid", acid);
				System.out.println("attr is"+session.getAttribute("acid"));
				rd=this.getServletContext().getRequestDispatcher("/CompleteYourRegistration.jsp");
				rd.forward(request, response);
			}
			else
			{
				msg="Invalid!! Some error took place ";
				request.setAttribute("message",msg);
				rd=this.getServletContext().getRequestDispatcher("/message.jsp");
				rd.forward(request, response);
			}
		}//try ends
			
			catch(Exception e)
			{
				msg="Invalid!! Some error took place ";
				request.setAttribute("message",msg);
				rd=this.getServletContext().getRequestDispatcher("/message.jsp");
				rd.forward(request, response);
			}
			//new part in updation
			//String AddressProof=request.getParameter("AddressProof");
			//String AddressImage=request.getParameter("AddressImage");
			
			//end of new part in updation 
			
			//System.out.println("updateregis begin");
			//System.out.println("ack id is"+ack);
			//ValidateCustomerRegistration v=new ValidateCustomerRegistration();
			//int output=v.checkimage(idp,Img,AddressProof,AddressImage);
			/*ArrayList <Customer> arr=new ArrayList<Customer>();
			if(output==1)
			{
			
			    System.out.println("updateregis");
				BTSS obj=new BTSS();
				try
				{
				 arr=obj.createCustomerUpdate(name,address,dateOfB,gender,num,mail,idp,Img,acid,AddressProof,AddressImage);
				
				 int id=0;
				 String p=null;
				
				for(Customer c: arr)
				{
					id=c.getCustomerId();
					 p=c.getPassword();
					
					 System.out.println(id);
					 System.out.println(p);
				
					 
					 
				}
				if(id==0)
				{
					msg="Invalid!! customer is not saved";
					request.setAttribute("message",msg);
					rd=this.getServletContext().getRequestDispatcher("/InvalidAckId.jsp");
					rd.forward(request, response);
				}
				else
				{
						System.out.println("customer id is"+id);
						System.out.println("paswrd is"+p);
						request.setAttribute("name",name);
						request.setAttribute("customerid",id);
						request.setAttribute("password",p);
						msg="Success!! Welcome -- "+name;
						request.setAttribute("message",msg);
						rd=this.getServletContext().getRequestDispatcher("/SuccessfulCustomer.jsp");
						rd.forward(request, response);
					}
				}
				
				
			
				catch(Exception e)
				{
					msg="Invalid!! Some error took place "+e.getMessage();
					request.setAttribute("message",msg);
					rd=this.getServletContext().getRequestDispatcher("/message.jsp");
					rd.forward(request, response);
				}
			}
				else if(output==0)
				{
					System.out.println("fill the feild");
					msg="Invalid!! proofs cannot be left blank for completing the registration";
					request.setAttribute("message",msg);
					rd=this.getServletContext().getRequestDispatcher("/message.jsp");
					rd.forward(request, response);
				}
			*/
			}//ends
			
		
		
			// view customer details for update begins
		
		else if((null!=opt)&&(opt.compareTo("viewforupdate")==0))
		{
			
			int cid=Integer.valueOf(custid);
			
			
			try
			{
				
				BTSS obj=new BTSS();
				
				ArrayList <Customer> arr=new ArrayList<Customer>();
			arr=obj.checkcustId(cid);
			Customer c=new Customer();
			
			String nam=null;
			String add=null;
			String dob=null;
			String gen=null;
			String number=null;
			String emailid=null;
			String proof=null;
			String addressProof=null;
			int le=arr.size();
			System.out.println("size of arraylist is"+le);
			
			if(le==1)
			{
			for(int i=0;i<arr.size();i++)
			{
				nam=arr.get(i).getCustomerName();
				add=arr.get(i).getAddress();
				dob=arr.get(i).getDateOfBirth();
				gen=arr.get(i).getGender();
				emailid=arr.get(i).getEmailId();
				number=arr.get(i).getPhoneNumber();
				proof=arr.get(i).getIdproof();
				addressProof=arr.get(i).getAddressProof();
				
			}
		
		
		    request.setAttribute("cid", cid);
			request.setAttribute("name",nam);
			request.setAttribute("add",add);
			request.setAttribute("dob",dob);
			request.setAttribute("gen",gen);
			request.setAttribute("num",number);
			request.setAttribute("mail",emailid);
			request.setAttribute("proof",proof);
			request.setAttribute("addressProof",addressProof);
			
			checkAdd=add;
			rd=this.getServletContext().getRequestDispatcher("/CustomerUpdateUI.jsp");
			rd.forward(request, response);
			}
				
			
			else
			{
				
				msg="Invalid!! No customer exists ";
				request.setAttribute("message",msg);
				
				rd=this.getServletContext().getRequestDispatcher("/message.jsp");
				rd.forward(request, response);
			}
			
			}
			catch(Exception e)
			{
				msg="Invalid!! Some error took place ";
				request.setAttribute("message",msg);
				rd=this.getServletContext().getRequestDispatcher("/message.jsp");
				rd.forward(request, response);
			}
		} //ends

		
		//update customer personal details begins
		/*
		else if((null!=opt)&&(opt.compareTo("updateCustomer")==0))
		{
			int cid=Integer.valueOf(request.getParameter("customerId"));
			
			System.out.println(address);
			System.out.println(name);
			System.out.println(gender);
			System.out.println(dateOfB);
			System.out.println(num);
			System.out.println(mail);
			System.out.println(idp);
			String addressProof=request.getParameter("addressProof");
			String addressImage=request.getParameter("addressImage");
			System.out.println("update customer begin");
			System.out.println("cid is"+cid);
			ValidateCustomerRegistration v=new ValidateCustomerRegistration();
			
			int output=1;
			ArrayList <Customer> arr=new ArrayList<Customer>();
			if(output==1)
			{
			    
			    System.out.println("update customer details");
				BTSS obj=new BTSS();
				try
				{
				 arr=obj.createCustomerUpdateAdmin(name,address,dateOfB,gender,num,mail,cid,addressProof,addressImage);
				 
				 int id=0;
				 String p=null;
				
				for(Customer c: arr)
				{
					id=c.getCustomerId();
					  
				}
				if(id==0)
				{
					msg="Invalid!! customer is not saved";
					request.setAttribute("message",msg);
					rd=this.getServletContext().getRequestDispatcher("/message.jsp");
					rd.forward(request, response);
				}
				else
				{
					System.out.println("Details are updated successfully");
					msg="Details are updated successfully";
					request.setAttribute("message",msg);
					rd=this.getServletContext().getRequestDispatcher("/message.jsp");
					rd.forward(request, response);
				  
					}
				}
				
				
			
				catch(Exception e)
				{
					msg="Invalid!! Some error took place "+e.getMessage();
					request.setAttribute("message",msg);
					rd=this.getServletContext().getRequestDispatcher("/message.jsp");
					rd.forward(request, response);
				}
			}
				else if(output==0)
				{
					System.out.println("fill teh feild");
					msg="Invalid!! proofs cannot be left blank";
					request.setAttribute("message",msg);
					rd=this.getServletContext().getRequestDispatcher("/message.jsp");
					rd.forward(request, response);
				}
			
			} //ends
		
		*/
		
		
		
		
		
	
		
		
		//view single customer details by admin begins
		else if((null!=opt)&&(opt.compareTo("viewSingleCustomerPage")==0))
		{
			RequestDispatcher dispatcher=request.getRequestDispatcher("/viewSingleCustomerPage.jsp");
			dispatcher.forward(request, response);	
			
		}
		
		
		
		
		
		else if(opt.compareTo("viewSingleCustomer")==0)
		{
			int cId=Integer.valueOf(custid);
			
			System.out.println("hello view customer");
			try
			{
				
				BTSS obj=new BTSS();
				ArrayList <Customer> arr=new ArrayList<Customer>();
			arr=obj.checkcustId(cId);
			Customer c=new Customer();
			
			String nam=null;
			String add=null;
			String dob=null;
			String gen=null;
			String number=null;
			String emailid=null;
			String proof=null;
			String addressProof=null;
			int le=arr.size();
			System.out.println("size of arraylist is"+le);
			
			if(le==1)
			{
			for(int i=0;i<arr.size();i++)
			{
				nam=arr.get(i).getCustomerName();
				add=arr.get(i).getAddress();
				dob=arr.get(i).getDateOfBirth();
				gen=arr.get(i).getGender();
				emailid=arr.get(i).getEmailId();
				number=arr.get(i).getPhoneNumber();
				proof=arr.get(i).getIdproof();
				addressProof=arr.get(i).getAddressProof();
			}
		
		
		request.setAttribute("custid", cId);
			request.setAttribute("name",nam);
			request.setAttribute("add",add);
			request.setAttribute("dob",dob);
			request.setAttribute("gen",gen);
			request.setAttribute("num",number);
			request.setAttribute("mail",emailid);
			request.setAttribute("proof",proof);
			request.setAttribute("AddressProof",addressProof);
			
			rd=this.getServletContext().getRequestDispatcher("/singleCustomerDetailsDisplayAdmin.jsp");
			rd.forward(request, response);
			}
			
			
			else
			{
				
				msg="Invalid!! No customer exists ";
				request.setAttribute("message",msg);
				
				rd=this.getServletContext().getRequestDispatcher("/message.jsp");
				rd.forward(request, response);
			}
			
			}
			catch(Exception e)
			{
				msg="Invalid!! Some error took place "+e.getMessage();
				request.setAttribute("message",msg);
				rd=this.getServletContext().getRequestDispatcher("/message.jsp");
				rd.forward(request, response);
			}
		}
		
		
		
		//end of view single customer details by admin
		
		
		//view all the customers by administrator begins
		
		else if((null!=opt)&&(opt.compareTo("viewAllCustomer")==0))
		{
			
			
			
			try {
				
				BTSS obj=new BTSS();
				   ArrayList<Customer> objlist=obj.viewAllCustomer();
				   request.setAttribute("obj",objlist );	
				
					RequestDispatcher dispatcher=request.getRequestDispatcher("/viewAllCustomersDisplay.jsp");
					dispatcher.forward(request, response);	
				}
			  
	  
			catch(Exception e)
			{
				
				msg="Invalid!! Some error took place "+e.getMessage();
				request.setAttribute("message",msg);
				RequestDispatcher dispatcher=request.getRequestDispatcher("/message.jsp");
				dispatcher.forward(request, response);
				
				
			}
		
		}
		
		//end of view all the customers by administrator	
		
		
		//image download begins
		//id image
		else if((null!=opt)&&(opt.compareTo("imageDownload")==0))
		{
			
					 
			String cus=request.getParameter("id");
			System.out.println(cus);
			int cid=Integer.parseInt(cus);
			
			 try {
				 BTSS obj=new BTSS();
			request.setAttribute("image", obj.getIdProof(cid));
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("/image.jsp");
			dispatcher.forward(request, response);
		
		  

	  }
		catch(Exception e)
		{
			msg="Invalid!! Some error took place "+e.getMessage();
			request.setAttribute("message",msg);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/message.jsp");
			dispatcher.forward(request, response);
		}
		
		
		
		}
		//end of id image
		
		//address image
		else if((null!=opt)&&(opt.compareTo("addressImageDownload")==0))
		{
			
					 
			String cus=request.getParameter("id");
			System.out.println(cus);
			int cid=Integer.parseInt(cus);
			
			 try {
				 BTSS obj=new BTSS();
			request.setAttribute("image1", obj.getAddressProofImage(cid));
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("/addressimage.jsp");
			dispatcher.forward(request, response);
		
		  

	  }
		catch(Exception e)
		{
			msg="Invalid!! Some error took place "+e.getMessage();
			request.setAttribute("message",msg);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/message.jsp");
			dispatcher.forward(request, response);
		}
		
		
		
		}
		
		//end of address image
		
		//image download ends
		
		
//delete view begins
		
		else if((null!=opt)&&(opt.compareTo("viewForDelete")==0))
		{
			
			int cId=Integer.valueOf(custid);
			
			
			try
			{
				
				BTSS obj=new BTSS();
				ArrayList <Customer> arr=new ArrayList<Customer>();
			arr=obj.checkcustId(cId);
			Customer c=new Customer();
		
			String nam=null;
			String add=null;
			String dob=null;
			String gen=null;
			String number=null;
			String emailid=null;
			String proof=null;
			String addressProof=null;
			int le=arr.size();
			System.out.println("size of arraylist is"+le);
		
			if(le==1)
			{
			for(int i=0;i<arr.size();i++)
			{
				nam=arr.get(i).getCustomerName();
				add=arr.get(i).getAddress();
				dob=arr.get(i).getDateOfBirth();
				gen=arr.get(i).getGender();
				emailid=arr.get(i).getEmailId();
				number=arr.get(i).getPhoneNumber();
				proof=arr.get(i).getIdproof();
				addressProof=arr.get(i).getAddressProof();
				
			}
		
		
		request.setAttribute("custid", cId);
			request.setAttribute("name",nam);
			request.setAttribute("add",add);
			request.setAttribute("dob",dob);
			request.setAttribute("gen",gen);
			request.setAttribute("num",number);
			request.setAttribute("mail",emailid);
			request.setAttribute("proof",proof);
			request.setAttribute("AddressProof",addressProof );
			
			rd=this.getServletContext().getRequestDispatcher("/CustomerDeleteUI.jsp");
			rd.forward(request, response);
			}
			
			
			else
			{
				
				msg="Invalid!! No customer exists ";
				request.setAttribute("message",msg);
				
				rd=this.getServletContext().getRequestDispatcher("/message.jsp");
				rd.forward(request, response);
			}
			
			}
			catch(Exception e)
			{
				msg="Invalid!! Some error took place "+e.getMessage();
				request.setAttribute("message",msg);
				rd=this.getServletContext().getRequestDispatcher("/message.jsp");
				rd.forward(request, response);
			}
		}
		
		
		//end of delete view
		
		
		
		
		//delete customer begins
		else if((null!=opt)&&(opt.compareTo("deleteCustomer")==0))
		{
				 
			String cus=request.getParameter("id");
			System.out.println(cus);
			int cid=Integer.parseInt(cus);


		
		
		try {
			
			BTSS obj=new BTSS();	
			int check=obj.deleteCustomer(cid);
			
			if(check==1)
			{
			RequestDispatcher dispatcher=request.getRequestDispatcher("/deleteSuccess.jsp");
			dispatcher.forward(request, response);
			}
			else if(check==2)
			{
				RequestDispatcher dispatcher=request.getRequestDispatcher("/deleteFailure.jsp");
				dispatcher.forward(request, response);
			}
			else
			{
				msg="Invalid!! Some error took place ";
				request.setAttribute("message",msg);
				RequestDispatcher dispatcher=request.getRequestDispatcher("/message.jsp");
				dispatcher.forward(request, response);	
			}
		  

	  }
		catch(Exception e)
		{
			
			msg="Invalid!! Some error took place "+e.getMessage();
			request.setAttribute("message",msg);
			rd=this.getServletContext().getRequestDispatcher("/message.jsp");
			rd.forward(request, response);
			
		}}
		//end of delete customer
		
		

		//view single customer on click begins by customer
		else if((null!=opt)&&(opt.compareTo("viewSingleCustmoerDetails")==0))
		{
			
				int cId=Integer.valueOf(request.getParameter("customerId"));
	
				try
				{
					
					BTSS obj=new BTSS();
					ArrayList <Customer> arr=new ArrayList<Customer>();
				arr=obj.checkcustId(cId);
				Customer c=new Customer();
				
				String nam=null;
				String add=null;
				String dob=null;
				String gen=null;
				String number=null;
				String emailid=null;
				String proof=null;
				String addressProof=null;
				if(c.getAcknowlegmentId()!=cId)
				{
				for(int i=0;i<arr.size();i++)
				{
					nam=arr.get(i).getCustomerName();
					add=arr.get(i).getAddress();
					dob=arr.get(i).getDateOfBirth();
					gen=arr.get(i).getGender();
					emailid=arr.get(i).getEmailId();
					number=arr.get(i).getPhoneNumber();
					proof=arr.get(i).getIdproof();
					addressProof=arr.get(i).getAddressProof();
				}
			
			
			    request.setAttribute("custid", cId);
				request.setAttribute("name",nam);
				request.setAttribute("add",add);
				request.setAttribute("dob",dob);
				request.setAttribute("gen",gen);
				request.setAttribute("num",number);
				request.setAttribute("mail",emailid);
				request.setAttribute("proof",proof);
			    request.setAttribute("AddressProof",addressProof);
			    
				
				rd=this.getServletContext().getRequestDispatcher("/singleCustomerDetailsDisplay.jsp");
				rd.forward(request, response);
				}
				
				
				else
				{
					
					
					msg="Invalid!! No customer exists ";
					request.setAttribute("message",msg);
					
					rd=this.getServletContext().getRequestDispatcher("/message.jsp");
					rd.forward(request, response);
				}
				
				}
				catch(Exception e)
				{
					msg="Invalid!! Some error took place "+e.getMessage();
					request.setAttribute("message",msg);
					rd=this.getServletContext().getRequestDispatcher("/message.jsp");
					rd.forward(request, response);
				}
			
			
		} //ends
	
		
		
		//view single customer on click begins by adminstrator
		else if((null!=opt)&&(opt.compareTo("viewSingleCustmoerDetailsByAdmin")==0))
		{
		
				int cId=Integer.valueOf(request.getParameter("customerId"));
			
				try
				{
					
					BTSS obj=new BTSS();
					ArrayList <Customer> arr=new ArrayList<Customer>();
				
				arr=obj.checkcustId(cId);
				Customer c=new Customer();
				
				String nam=null;
				String add=null;
				String dob=null;
				String gen=null;
				String number=null;
				String emailid=null;
				String proof=null;
				String addressProof=null;
				if(c.getAcknowlegmentId()!=cId)
				{
				for(int i=0;i<arr.size();i++)
				{
					nam=arr.get(i).getCustomerName();
					add=arr.get(i).getAddress();
					dob=arr.get(i).getDateOfBirth();
					gen=arr.get(i).getGender();
					emailid=arr.get(i).getEmailId();
					number=arr.get(i).getPhoneNumber();
					proof=arr.get(i).getIdproof();
					addressProof=arr.get(i).getAddressProof();
					
				}
				System.out.println("++++++++++++++++++++ "+addressProof);
			
			    request.setAttribute("custid", cId);
				request.setAttribute("name",nam);
				request.setAttribute("add",add);
				request.setAttribute("dob",dob);
				request.setAttribute("gen",gen);
				request.setAttribute("num",number);
				request.setAttribute("mail",emailid);
				request.setAttribute("proof",proof);
				 request.setAttribute("AddressProof",addressProof);
				
				rd=this.getServletContext().getRequestDispatcher("/singleCustomerDetailsDisplayAdmin.jsp");
				rd.forward(request, response);
				}
				
				
				else
				{
					msg="Invalid!! No customer exists ";
					request.setAttribute("message",msg);
					
					rd=this.getServletContext().getRequestDispatcher("/message.jsp");
					rd.forward(request, response);
				}
				
				}
				catch(Exception e)
				{
					msg="Invalid!! Some error took place "+e.getMessage();
					request.setAttribute("message",msg);
					rd=this.getServletContext().getRequestDispatcher("/message.jsp");
					rd.forward(request, response);
				}
			
			
		} //ends
		
		//if no option matches
		else
		{
			System.out.println("no option");
		}
		}
		
		catch(Exception e)
		{ 
			RequestDispatcher rd=null;
			String msg1;
			msg1="Server encoutered some problem <br> </br> Please try again";
			request.setAttribute("message",msg1);
			rd=this.getServletContext().getRequestDispatcher("/message.jsp");
			rd.forward(request, response);	
		}
	}//do post ends

}//end of class
