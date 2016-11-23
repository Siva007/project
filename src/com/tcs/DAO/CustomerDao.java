package com.tcs.DAO;
import com.tcs.model.Customer;
import com.tcs.model.Image;
import com.tcs.model.PasswordGenerator;


import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;


import java.sql.SQLException;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.commons.fileupload.FileItem;




import com.tcs.util.DBUtil;

//Dao class begins

public class CustomerDao 
{
     ArrayList list=new ArrayList();
     
     //function to add a customer
	public  ArrayList<Customer>  getCustomerId(Customer c,String name,String address,String dob,String gender,String number,String emailid) throws Exception
	{
		try{
				//System.out.println(AddressImage);		
		Connection con=DBUtil.getConnection();
		
		Statement st=con.createStatement();
		PasswordGenerator p=new PasswordGenerator();
		Customer cu=new Customer();
		//System.out.println("proof in dao is"+proof);
		//String idProof="Id Skip";
		//String adressProof="Address Skip";
		
		//if((proof.compareTo(idProof)==0)&&(AddressProof.compareTo(adressProof)==0))   //for incomplete registration
		//{
			int ackid=0;
			String query="select acknowledgmentid from idgenerationd";
			ResultSet rsa=st.executeQuery(query);
			
			
			while(rsa.next())
			{
			ackid=rsa.getInt(1);	
			}
			
			
			System.out.println(ackid);
			
			
			//adding registration date
			 DateFormat dateFormat = new SimpleDateFormat("dd.MMM.yyyy");
				Date date = new Date();
				String d=dateFormat.format(date).toString();
			
			System.out.println("date of reg is "+d);
			
			
			
			String query1="insert into AcknowledgeD(AcknowledgmentId,CustomerName,Address,DateOfBirth,Gender,Contact,Emailid,RegisterDate) values('"+ ackid + "','"+ c.getCustomerName() + "','" +c.getAddress()+ "','"+ c.getDateOfBirth() + "','"+ c.getGender() + "','"+ c.getPhoneNumber() + "','"+ c.getEmailId() + "','"+d+"')";
			int rsb=st.executeUpdate(query1);
			
			System.out.println("insert into Ack");
			int newid=ackid+1;
			System.out.println(newid);
			String query2="update idgenerationd set acknowledgmentid="+newid;
			int rsc=st.executeUpdate(query2);
			System.out.println("update ack");
			
			cu.setAcknowlegmentId(ackid);
			list.add(cu);
			return list;
		}
		
		
		//if id proof is filled begins
		
		
		/*else              //for complete registration
		{
			
		
		String query="select customerid from idgenerationd";
		int custid=0;
		ResultSet rs=st.executeQuery(query);
		
		
		while(rs.next())
		{
		custid=rs.getInt(1);	
		}
		String passwrd=null;
		if(custid!=0)
		{
			passwrd=p.getAlphaNumeric(8);
		}
		c.setPassword(passwrd);
		
		 //File image=new File(img);
		 FileInputStream idImageStream= new FileInputStream(img);
		 //File AddressImage1=new File(AddressImage);
		 FileInputStream  AddressImageStream= new FileInputStream(AddressImage);
		
		  PreparedStatement pre = con.prepareStatement("INSERT INTO CustomerD(CustomerId,Password,CustomerName,Address,DateOfBirth,Gender,Contact,EmailId,Idproof,Image,pwdstatus,addressProof,addressImage) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
	
		  
		
		     System.out.println("insertion begins");
		 
		    pre.setInt(1,custid);
		    pre.setString(2,c.getPassword());
		    pre.setString(3,c.getCustomerName());
		    pre.setString(4,c.getAddress());
		    pre.setString(5,c.getDateOfBirth());
		    pre.setString(6,c.getGender());
		    pre.setString(7,c.getPhoneNumber());
		    pre.setString(8,c.getEmailId());
		    pre.setString(9,c.getIdproof());
		    long idLength=img.length();
			   
		    pre.setBinaryStream(10,idImageStream,(int)idLength);
		    pre.setInt(11,0);
		    pre.setString(12,c.getAddressProof());
		   
		    System.out.println();
		    System.out.println("**** size "+img.length());
		    System.out.println("*****");
		   
		    //new image insertion
		    
		    long addressLength=AddressImage.length();
		    System.out.println("**** size "+AddressImage.length());
		    
		    pre.setBinaryStream(13,AddressImageStream,(int)addressLength);
		    System.out.println("print");
		    
		  //end of new image insertion
		
		    int i=pre.executeUpdate();
		 
		
		
		  if(i>0)
		  {
		  System.out.println("Inserting Successfully!");
		  }
		
		
		int newid=custid+1;
		System.out.println(newid);
		String query2="update idgenerationd set customerid="+newid;
		int rs2=st.executeUpdate(query2);
		System.out.println("updating idgeneration table");
		
		
		cu.setCustomerId(custid);
		cu.setPassword(c.getPassword());
		
		list.add(cu);
		return list;
		}
		
	
		}*/
		
		finally
		{
			DBUtil.closeConnection();
		}
		
		}//add customer ends
	
	
	
	//function to check for the valid id
	public  ArrayList<Customer> checkCustomer(int id)throws Exception
	{
		try{
			System.out.println("checking ack");
			Connection con=DBUtil.getConnection();
			
			Statement st=con.createStatement();
			Customer c=new Customer();
			int aid=0;
			String name=null;
			String address=null;
		String dob=null;
		String gender=null;
		String number=null;
		String emailid=null;
		String d=null;
			
			String query="select acknowledgmentid from acknowledged where acknowledgmentid="+id;
			ResultSet rs=st.executeQuery(query);
			
			while(rs.next())
			{
			aid=rs.getInt(1);	
			}
			if(aid!=0)
			{
			String query1="select * from acknowledged where acknowledgmentid="+id;
			ResultSet rs1=st.executeQuery(query1);
			while(rs1.next())
			{
			aid=rs1.getInt(1);
			name=rs1.getString(2);
			address=rs1.getString(3);
			dob=rs1.getString(4);
			gender=rs1.getString(5);
			number=rs1.getString(6);
			emailid=rs1.getString(7);
			d=rs1.getString(8);
			}
			c.setAcknowlegmentId(aid);
			c.setAddress(address);
			c.setCustomerName(name);
			c.setDateOfBirth(dob);
			c.setEmailId(emailid);
			c.setGender(gender);
			c.setPhoneNumber(number);
			c.setRegDate(d);
			System.out.println("Reg date from Dao"+c.getRegDate());
			list.add(c);
			return list;
		}
			else
			{
				return list;
			}
		}
		finally
		{
			DBUtil.closeConnection();
		}
			
	}//ends
	
	
	//function to complete the registration process
	public  ArrayList<Customer>  updateCustomerRegis(Customer c,String name,String address,String dob,String gender,String number,String emailid,String proof,String img,int ack,String AddressProof,String AddressImage) throws Exception
	{
		try{
						
		Connection con=DBUtil.getConnection();
		
		Statement st=con.createStatement();
		PasswordGenerator p=new PasswordGenerator();
		Customer cu=new Customer();
		
		
			
		String query="select customerid from idgenerationd";
		int custid=0;
		ResultSet rs=st.executeQuery(query);
		
	
		while(rs.next())
		{
		custid=rs.getInt(1);	
		}
		String passwrd=null;
		if(custid!=0)
		{
			passwrd=p.getAlphaNumeric(8);
		}
		c.setPassword(passwrd);
		//String AddressProof,String AddressImage
		
		 File image=new File(img);
		 FileInputStream fin = new FileInputStream(image);
		 File addressImageFile=new File(AddressImage);
		 FileInputStream AddressImageStream = new FileInputStream(addressImageFile);
		
		  PreparedStatement pre = con.prepareStatement("INSERT INTO CustomerD(CustomerId,Password,CustomerName,Address,DateOfBirth,Gender,Contact,EmailId,Idproof,Image,addressProof,addressImage) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
		
		 
		System.out.println("updating");
		 
		    pre.setInt(1,custid);							//inserting values in the table
		    pre.setString(2,c.getPassword());
		    pre.setString(3,c.getCustomerName());
		    pre.setString(4,c.getAddress());
		    pre.setString(5,c.getDateOfBirth());
		    pre.setString(6,c.getGender());
		    pre.setString(7,c.getPhoneNumber());
		    pre.setString(8,c.getEmailId());
		    pre.setString(9,c.getIdproof());
		    System.out.println();
		    System.out.println("**** size "+image.length());
		
		  long le=image.length();
		
		  pre.setBinaryStream(10,fin,(int)le);
		  pre.setString(11,c.getAddressProof());
		  long addressImageLength=addressImageFile.length();
			
		  pre.setBinaryStream(12,AddressImageStream,(int)addressImageLength);
		
		  
		  int i=pre.executeUpdate();
		
		
		 			
		 
		  if(i>0)    //only when query is executed
		  {
			  System.out.println("entere Deleted ");
			  System.out.println(ack);
			
		 
		 String query1="delete from acknowledged where acknowledgmentid="+ack;
		 st.executeUpdate(query1);
		 System.out.println("Deleted successfully");
		  
		
		
		int newid=custid+1;
		System.out.println(newid);
		String query2="update idgenerationd set customerid="+newid;
		int rs2=st.executeUpdate(query2);
		System.out.println("update");
		
		
		cu.setCustomerId(custid);
		cu.setPassword(c.getPassword());
		
		list.add(cu);
	
		return list;
		}
		  return list;
		}
		
		
		
		
		finally
		{
			DBUtil.closeConnection();
		}
		}//ends
	
		
	
	
	//check for valid customer and return entire details
	public  ArrayList<Customer> checkCustomerId(int id)throws Exception
	{
		try{
			System.out.println("checking cust");
			Connection con=DBUtil.getConnection();
		
			Statement st=con.createStatement();
			Customer c=new Customer();
			int cid=0;
			String name=null;
			String address=null;
		String dob=null;
		String gender=null;
		String number=null;
		String emailid=null;
		String proof=null;
		String addressProof=null;
		
		
		
			String query="select customerid from customerd where customerid="+id;
			ResultSet rs=st.executeQuery(query);
			if(rs.next()==true)
			{
			String query1="select * from customerd where CUSTOMERID="+id;
			ResultSet rs1=st.executeQuery(query1);
			while(rs1.next())
			{
			cid=rs1.getInt(1);
			name=rs1.getString(3);
			address=rs1.getString(4);
			dob=rs1.getString(5);
			gender=rs1.getString(6);
			number=rs1.getString(7);
			emailid=rs1.getString(8);
			proof=rs1.getString(9);
			addressProof=rs1.getString(12);
	
			}
			c.setCustomerId(cid);
			c.setAddress(address);
			c.setCustomerName(name);
			c.setDateOfBirth(dob);
			c.setEmailId(emailid);
			c.setGender(gender);
			c.setPhoneNumber(number);
			c.setIdproof(proof);
			c.setAddressProof(addressProof);
			
		
			list.add(c);
			return list;
			}
			else
			{
				return list;
			}
		}
		
		finally
		{
			DBUtil.closeConnection();
		}
			
	}//ends
	
	
	
	
	
	//for update personal details
	 public  ArrayList<Customer>  updateCustomerDetails(Customer c,String name,String address,String dob,String gender,String number,String emailid,int cid,String addressProof,FileItem addressImage) throws Exception
	{
		 try{
				
				Connection con=DBUtil.getConnection();
				System.out.println("Hello customer update");
				Statement st=con.createStatement();
				Customer cu=new Customer();
				int cd=0;
				String n=null;
				String add=null;
			String db=null;
			String gen=null;
			String num=null;
			String email=null;
			String pf=null;
			System.out.println("****");
			
			
			// addressProof,String addressImage
			if((addressImage.getSize()!=0))  //if customer changes the address proof
			
			{
				
				System.out.println();
				System.out.println("addressImage size is "+addressImage.getSize());
				
				 PreparedStatement pre = con.prepareStatement("Update CustomerD set Address=?,Contact=?,EmailId=?,ADDRESSPROOF=?,ADDRESSIMAGE=? where customerid="+cid);
				  
				 System.out.println("updating");
				 
				  
				    pre.setString(1,c.getAddress());
				 
				    pre.setString(2,c.getPhoneNumber());
				    pre.setString(3,c.getEmailId());
				    pre.setString(4,c.getAddressProof());
					pre.setBinaryStream(5, addressImage.getInputStream(), (int) addressImage.getSize());
					
					 int i=pre.executeUpdate();
					 
					  if(i>0)
					  {
					  System.out.println("Updating Successfully!");
					  }
					  
					  
					  String query1="select * from customerd where CUSTOMERID="+cid;
						ResultSet rs1=st.executeQuery(query1);
						while(rs1.next())
						{
						cd=rs1.getInt(1);
						name=rs1.getString(3);
						address=rs1.getString(4);
						dob=rs1.getString(5);
						gender=rs1.getString(6);
						number=rs1.getString(7);
						emailid=rs1.getString(8);
						//proof=rs1.getString(9);
						}
						
						c.setCustomerId(cid);
					
						System.out.println("customer id is"+c.getCustomerId());
						c.setAddress(address);
						c.setCustomerName(name);
						c.setDateOfBirth(dob);
						c.setEmailId(emailid);
						c.setGender(gender);
						c.setPhoneNumber(number);
						//c.setIdproof(proof);
						
						list.add(c);
						return list;		
					  
					  
				/*
				
				 File addressImageFile=new File(addressImage);
				 FileInputStream addressImageStream = new FileInputStream(addressImageFile);
				 
				 
				 
				 System.out.println(address);
				 System.out.println(number);
				  PreparedStatement pre = con.prepareStatement("Update CustomerD set Address=?,Contact=?,EmailId=?,ADDRESSPROOF=?,ADDRESSIMAGE=? where customerid="+cid);
				  
				 //PreparedStatement pre = con.prepareStatement("Update CustomerD set Address=?,Contact=?,EmailId=?,Idproof=?,Image=?,ADDRESSPROOF=? where customerid="+cid);
				 //PreparedStatement pre1 = con.prepareStatement("Update CustomerD set ADDRESSIMAGE=? where customerid="+cid); 		
				System.out.println("updating");
				 
				  
				    pre.setString(1,c.getAddress());
				 
				    pre.setString(2,c.getPhoneNumber());
				    pre.setString(3,c.getEmailId());
				    //pre.setString(4,c.getIdproof());
				    
				    System.out.println();
				    //System.out.println("**** size "+image.length());
				
				  //long le=image.length();
				 
				  //pre.setBinaryStream(5,fin,(int)le);
				  pre.setString(4,c.getAddressProof());
				  long addresslength=addressImageFile.length();
				  System.out.println("***  "+addresslength);
				  pre.setBinaryStream(5,addressImageStream,(int)addresslength);
				  
				 int i=pre.executeUpdate();
				//int j=pre1.executeUpdate();
			
				  if(i>0)
				  {
				  System.out.println("Updating Successfully!");
				  }
				
			String query1="select * from customerd where CUSTOMERID="+cid;
			ResultSet rs1=st.executeQuery(query1);
			while(rs1.next())
			{
			cd=rs1.getInt(1);
			name=rs1.getString(3);
			address=rs1.getString(4);
			dob=rs1.getString(5);
			gender=rs1.getString(6);
			number=rs1.getString(7);
			emailid=rs1.getString(8);
			//proof=rs1.getString(9);
			}
			
			c.setCustomerId(cid);
			c.setAddress(address);
			c.setCustomerName(name);
			c.setDateOfBirth(dob);
			c.setEmailId(emailid);
			c.setGender(gender);
			c.setPhoneNumber(number);
			//c.setIdproof(proof);
			
			list.add(c);
			return list;			*/
		 }
			//end of if image fill
			
			
			else                         //customer does not change the proof
			{
			
			
				 PreparedStatement pre = con.prepareStatement("Update CustomerD set Address=?,Contact=?,EmailId=?,ADDRESSPROOF=? where customerid="+cid);
					
					System.out.println("updating");
					 
					   
					    pre.setString(1,c.getAddress());
					    
					
					    pre.setString(2,c.getPhoneNumber());
					    pre.setString(3,c.getEmailId());
					    //pre.setString(4,c.getIdproof());
					    pre.setString(4,c.getAddressProof());
					    System.out.println();
					   
					  
					  
					 int i=pre.executeUpdate();
					
					
					  if(i>0)
					  {
					  System.out.println("Updated Successfully!");
					  }
					
				String query1="select * from customerd where CUSTOMERID="+cid;
				ResultSet rs1=st.executeQuery(query1);
				while(rs1.next())
				{
				cd=rs1.getInt(1);
				name=rs1.getString(3);
				address=rs1.getString(4);
				dob=rs1.getString(5);
				gender=rs1.getString(6);
				number=rs1.getString(7);
				emailid=rs1.getString(8);
				//proof=rs1.getString(9);
				}
				
				c.setCustomerId(cid);
				c.setAddress(address);
				c.setCustomerName(name);
				c.setDateOfBirth(dob);
				c.setEmailId(emailid);
				c.setGender(gender);
				c.setPhoneNumber(number);
				//c.setIdproof(proof);
				System.out.println("customer id is"+c.getCustomerId());
				list.add(c);
				return list;
			 }
			
			
		 
		
		 }
		 
		 catch(Exception e)
		 {
			 System.out.println(e);
			 return list;
		 }
			finally
			{
				DBUtil.closeConnection();
			}
	
	}//ends
	 
	

	//view all customer details by administrator		
		public ArrayList<Customer> viewAllCustomers()throws Exception
	{
	
	try
	{
		ArrayList<Customer> objList=new ArrayList<Customer>();
		Connection con=DBUtil.getConnection();
		System.out.println("Hello view all customer dao");
		Statement st=con.createStatement();

		int aid=0;
		String name=null;
		String address=null;
	String dob=null;
	String gender=null;
	String number=null;
	String emailid=null;
	String proof=null;
		
		
		String query1="select * from customerd order by customerid";
		ResultSet rs1=st.executeQuery(query1);
		
		while(rs1.next())
		{
			Customer c=new Customer();
		aid=rs1.getInt(1);
		name=rs1.getString(3);
		address=rs1.getString(4);
		dob=rs1.getString(5);
		gender=rs1.getString(6);
		number=rs1.getString(7);
		emailid=rs1.getString(8);
		proof=rs1.getString(9);
		
		c.setCustomerId(aid);
		c.setAddress(address);
		c.setCustomerName(name);
		c.setDateOfBirth(dob);
		c.setEmailId(emailid);
		c.setGender(gender);
		c.setPhoneNumber(number);
		c.setIdproof(proof);
		objList.add(c);
		}	
		
		
	return	objList;
	}
	catch(Exception ex)
	{
		System.out.println(ex);
	}
	finally
	{
		DBUtil.closeConnection();	
	}
	return null;
	}
		
		
	//end of view all customer details by administrator
		
		
		
		

		//image retrieving
		//start of id image
		
		public Image getIdProof(int id) throws SQLException
		{
	 
			try{
				Connection con=DBUtil.getConnection();
			 
			String strQuery = "select dbms_lob.getlength(image),image from CUSTOMERD where customerid="+id;
			PreparedStatement ps=con.prepareStatement(strQuery); 
			ResultSet res = ps.executeQuery(strQuery);
			Image imgObj=new Image();
			if(res.next())
			{  
			
				imgObj.setImage(res.getBlob(2));
				
				 

				imgObj.setLength(Integer.parseInt(res.getString(1)));
				
			}
			return imgObj;
		
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			return null;
			}
			
			}
			
		//end of id image
		
		//start of address image
		
		public Image getAddressProofImage(int id) throws SQLException
		{
	 
			try{
				Connection con=DBUtil.getConnection();
			 
			String strQuery = "select dbms_lob.getlength(addressImage),addressImage from CUSTOMERD where customerid="+id;
			PreparedStatement ps=con.prepareStatement(strQuery); 
			ResultSet res = ps.executeQuery(strQuery);
			Image imgObj=new Image();
			if(res.next())
			{  
			
				imgObj.setImage(res.getBlob(2));
				
				 

				imgObj.setLength(Integer.parseInt(res.getString(1)));
				
			}
			return imgObj;
		
			}
			catch(Exception ex)
			{
			
			return null;
			}
			
			}
			
		//end of address image
		
		//end of image retriving
		
		
	 
		
		
		

		//delete customer begins
		public int deleteCustomer(int cid)throws Exception
		{
			int reply;
			try{
				System.out.println("checking ack");
				Connection con=DBUtil.getConnection();
				
				Statement st=con.createStatement();
				Customer c=new Customer();
			
			String status=null;
			
				
				String query="select status from connectiond where customerid="+cid;
				ResultSet rs=st.executeQuery(query);
			
				while(rs.next())
				{
			
				status=rs.getString(1);
				if(status.compareTo("active")==0)
				{
					reply=2;
				return reply;
					
			}
				}
				
				String query1="delete from customerd where customerid="+cid;
				int check=st.executeUpdate(query1);
			
				if(check>0)
				{
					reply=1;
				return reply;
				}
				else
				{
					reply=0;
					return reply;
				}
			
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			
			}
			
			finally
			{
				DBUtil.closeConnection();
			}
			return 0;	
			
		}
		
		
		//begin of new insert part **********************
		
		public ArrayList<Customer> completeRegis(int ack,String idN,FileItem idimg,String adN,FileItem addimg) throws SQLException
		{
			try
			{
	Connection con=DBUtil.getConnection();
				
				Statement st=con.createStatement();	
				
      ArrayList<Customer> list=new  ArrayList<Customer>();
      Customer c=new Customer();
   
		String name=null;
		String address=null;
	String dob=null;
	String gender=null;
	String number=null;
	String emailid=null;
	String registerDate=null;
	
		
      String query1="select * from acknowledged where acknowledgmentid="+ack;
		ResultSet rs1=st.executeQuery(query1);
		while(rs1.next())
		{
		
		name=rs1.getString(2);
		address=rs1.getString(3);
		dob=rs1.getString(4);
		gender=rs1.getString(5);
		number=rs1.getString(6);
		emailid=rs1.getString(7);
		registerDate=rs1.getString(8);
	

		}
		
		c.setAddress(address);
		c.setCustomerName(name);
		c.setDateOfBirth(dob);
		c.setEmailId(emailid);
		c.setGender(gender);
		c.setPhoneNumber(number);
		c.setRegDate(registerDate);
	  
		       	        
		        //new
		        String query="select customerid from idgenerationd";
				int custid=0;
				ResultSet rs=st.executeQuery(query);
				
				PasswordGenerator p=new PasswordGenerator();
				while(rs.next())
				{
				custid=rs.getInt(1);	
				}
				String passwrd=null;
				if(custid!=0)
				{
					passwrd=p.getAlphaNumeric(8);
				}
				c.setPassword(passwrd);
				
		        PreparedStatement pre = con.prepareStatement("INSERT INTO CustomerD(CustomerId,Password,CustomerName,Address,DateOfBirth,Gender,Contact,EmailId,Idproof,Image,pwdstatus,addressProof,addressImage) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
				
		    	
				  c.setAddressProof(adN);
				  c.setIdproof(idN);
				
			     System.out.println("insertion begins");
			 
			    pre.setInt(1,custid);
			    pre.setString(2,c.getPassword());
			    pre.setString(3,c.getCustomerName());
			    pre.setString(4,c.getAddress());
			    pre.setString(5,c.getDateOfBirth());
			    pre.setString(6,c.getGender());
			    pre.setString(7,c.getPhoneNumber());
			    pre.setString(8,c.getEmailId());
			    pre.setString(9,c.getIdproof());
			   
				pre.setBinaryStream(10, idimg.getInputStream(), (int) idimg.getSize());
				pre.setInt(11,0);
			    pre.setString(12,c.getAddressProof());
				pre.setBinaryStream(13, addimg.getInputStream(), (int) addimg.getSize());
				 
			    
			   
			    int i=pre.executeUpdate();
			    
			
			  if(i>0)
			  {
			  System.out.println("Inserting Successfully!");
			  PreparedStatement pre1 = con.prepareStatement("delete from acknowledged where acknowledgmentid="+ack);
			    int j=pre1.executeUpdate();
			    if(j>0)
			    {
			    	System.out.println("deleted from ack");
			    }
			  }
			
			
			int newid=custid+1;
			System.out.println(newid);
			String query2="update idgenerationd set customerid="+newid;
			int rs2=st.executeUpdate(query2);
			System.out.println("updating idgeneration table");
			
			
			c.setCustomerId(custid);
			
			System.out.println("***customerid is***"+c.getCustomerId());
			System.out.println("***password is***"+c.getPassword());
			list.add(c);
			System.out.println("size of array is"+list.size());
			
			int id=0;
			String p1=null;
			for(Customer cu: list)
			{
				 id=cu.getCustomerId();
				 p1=cu.getPassword();
				//name=cu.getCustomerName();
				 System.out.println(id);
				 System.out.println(p1);
				
				 
				 
			}
			return list;
			}//end of try
			catch(Exception e)
			{
				System.out.println(e);
				return list;      
			        
			        
			}
			}
		
}//end of class

	
	

	
	


