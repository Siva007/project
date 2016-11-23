package com.tcs.controller;

import java.awt.image.BufferedImage
;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.tcs.DAO.CustomerDao;
import com.tcs.DAO.Imagedao;
import com.tcs.model.BTSS;
import com.tcs.model.Customer;

/**
 * Servlet implementation class UploadImageController
 */
public class UploadImageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadImageController() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		PrintWriter out=response.getWriter();   //to print variables
		RequestDispatcher rd=null;               //for navigation
		String msg=null;
		
		
		try
		{
			BTSS obj=new BTSS();
			DiskFileItemFactory factory = new DiskFileItemFactory();
String inputName=null;
String idN=null;
String adN=null;
String customerId=null;
String custname=null;
String address=null;
String contact=null;
String gender=null;
String email=null;
String dob=null;

			 //Customer c=new Customer();
			ServletFileUpload upload = new ServletFileUpload(factory);
		    if (! ServletFileUpload.isMultipartContent(request))
		    {
	            System.out.println("sorry. No file uploaded");
	           
	        }
			List items=null;
				items = upload.parseRequest(request);
				Iterator iter1 = items.iterator();
				Iterator iter = items.iterator();
				  String check=null;
				int i=0;
				  while (iter.hasNext()) 
				{
				    FileItem item = (FileItem) iter.next();
				  
				    if (item.isFormField())
				    {
				    	i=i+1;
				    	System.out.println("........................:"+i);
				    	
				    	String opt=item.getString();
				    	
				    	String opt1=(String)item.getFieldName();
				    	System.out.println("form name is :"+opt1);
				    	if(opt.equals("regis"))
				    	{ 
				    		
				    	check = opt;
				    	System.out.println("-----OPERATION TYPE:"+opt);
				    	}
				    	if(opt.equals("updateCustomer"))
				    	{ 
				    		
				    	check = opt;
				    	System.out.println("------OPERATION TYPE:"+opt);
				    	}
				    	
				    	inputName = (String)item.getFieldName(); 
	    		    	
				    	if(inputName.equalsIgnoreCase("customerId"))
				    	{ 
				    		customerId= (String)item.getString(); 
				    	System.out.println("OPERATION TYPE:"+customerId);
				    	}
				    	if(inputName.equalsIgnoreCase("custname"))
				    	{ 
				    		custname= (String)item.getString(); 
				    	System.out.println("OPERATION TYPE:"+custname);
				    	}
				    	if(inputName.equalsIgnoreCase("dob"))
				    	{ 
				    		dob= (String)item.getString(); 
				    	System.out.println("OPERATION TYPE:"+dob);
				    	}
				    	
				    	if(inputName.equalsIgnoreCase("address"))
				    	{ 
				    	address= (String)item.getString(); 
				    	System.out.println("OPERATION TYPE:"+address);
				    	}
				    	if(inputName.equalsIgnoreCase("contact"))
				    	{ 
				    		contact= (String)item.getString(); 
				    	System.out.println("OPERATION TYPE:"+contact);
				    	}
				    	if(inputName.equalsIgnoreCase("email"))
				    	{ 
				    		email= (String)item.getString(); 
				    	System.out.println("OPERATION TYPE:"+email);
				    	}
				    	if(inputName.equalsIgnoreCase("sex"))
				    	{ 
				    		gender= (String)item.getString(); 
				    	System.out.println("OPERATION TYPE:"+gender);
				    	}
				    	
				    	
				    	if(inputName.equalsIgnoreCase("addressProof"))
				    	{ 
					    	adN = (String)item.getString(); 
					    	System.out.println("OPERATION TYPE:"+adN);
				    	}

				    	if(inputName.equalsIgnoreCase("idproof"))
				    	{ 
				    	idN = (String)item.getString(); 
				    	System.out.println("OPERATION TYPE:"+idN);
				    	}
				    	}
				    }
				
				  
				  //for registering a customer
				if(check.equals("regis"))
				{
			
			System.out.println("finished the parsing");
			FileItem  idProof1 = (FileItem) items.get(1);
	        
	        
	        FileItem addressProof1 = (FileItem) items.get(3);
	                System.out.println("****size***"+idProof1.getSize());	
	                System.out.println("****size***"+addressProof1.getSize());	
			ArrayList<Customer> a=new ArrayList<Customer>();
	
	        HttpSession session=request.getSession();
		CustomerDao d=new CustomerDao();
		int acd=(Integer)session.getAttribute("acid");
		a=d.completeRegis(acd,idN,idProof1,adN,addressProof1);
		System.out.println("size of array is"+a.size());
		
		 int id=0;
		 String p=null;
		 String name=null;
		for(Customer c: a)
		{
			 id=c.getCustomerId();
			 p=c.getPassword();
			name=c.getCustomerName();
			 System.out.println(id);
			 System.out.println(p);
			
			 
			 
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
				
				
		//update personal details begins
				
		if(check.equals("updateCustomer"))
		{
			System.out.println("hello update");
		System.out.println("finished the parsing");
		//FileItem  idProof = (FileItem) items.get(8);
        
        
        FileItem addressProof1 = (FileItem) items.get(10);
               // System.out.println("****size***"+idProof.getSize());	
                System.out.println("****size***"+addressProof1.getSize());	
		ArrayList<Customer> a=new ArrayList<Customer>();
		int cid=Integer.parseInt(customerId);
		a=obj.createCustomerUpdateAdmin(custname,address,dob,gender,contact,email,cid,adN,addressProof1);

        HttpSession session=request.getSession();
	CustomerDao d=new CustomerDao();
	//int acd=(Integer)session.getAttribute("acid");
	//a=d.completeRegis(acd,idN,idProof,adN,addressProof);
	System.out.println("size of array is"+a.size());
	
	
	 int id=0;
	 String p=null;
	
	for(Customer c: a)
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
		//end of update personal details
		
		}//end of try
		
		catch(Exception e)
		{
			msg="Invalid!! Some error took place ";
			request.setAttribute("message",msg);
			rd=this.getServletContext().getRequestDispatcher("/message.jsp");
			rd.forward(request, response);
		}
		
	
		
	
	
		
	}//do post ends	
	}//class ends


