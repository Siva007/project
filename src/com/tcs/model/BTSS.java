package com.tcs.model;

import java.util.ArrayList;
import java.sql.SQLException;

import org.apache.commons.fileupload.FileItem;


import com.tcs.util.DBUtil;
import com.tcs.DAO.BTSSDAO;
import com.tcs.DAO.CallDAO;
import com.tcs.DAO.CustomerDao;
import com.tcs.DAO.LoginDAO;


//class begins 
public class BTSS {
	
 ArrayList <ConnectionIssue> connectionList =new ArrayList <ConnectionIssue>();
ArrayList <Tariff> tariffList =new ArrayList <Tariff>();


//--------------------------------------Connection part Starts--------------------------/////////////	

//issue the tariff
public ArrayList<Tariff>issueBegin() 
{

	StringBuffer msg=new StringBuffer();
	try
	{
	BTSSDAO b=new BTSSDAO();
	tariffList=b.issueBegin();
	return 	tariffList;
	}
	finally
	{
		return 	tariffList;
	}
	
	}//ends



//function to issue the connection begins
public StringBuffer createConnectionIssue(int cid, String btype, String bplan) {
	
	StringBuffer msg=new StringBuffer();
	try
	{
	BTSSDAO b=new BTSSDAO();
	msg=b.createConnectionIssue(cid, btype, bplan);
	System.out.println(msg);
	return msg;
	}
	finally
	{
		return msg;
	}
} //ends
	

//view single connection
public ArrayList<ConnectionIssue> viewSingleConnection(long connNo) {
	
	StringBuffer msg=new StringBuffer();
	try
	{
	BTSSDAO b=new BTSSDAO();
	connectionList=b.viewSingleConnection(connNo);
	System.out.println(connectionList.get(0).getCustomerId());
	return connectionList;
	}
	finally
	{
		return connectionList;
	}
}//ends


//view all connection details
public ArrayList<ConnectionIssue> viewAllConnection() {
	
StringBuffer msg=new StringBuffer();
	try
	{
	BTSSDAO b=new BTSSDAO();
	connectionList=b.viewAllConnection();

	return connectionList;
	}
	finally
	{
		return connectionList;
	}
}//ends



//update connection issue
public ArrayList<ConnectionIssue>updateConnectionIssue(long connNo) {

StringBuffer msg=new StringBuffer();
try
{
BTSSDAO b=new BTSSDAO();
connectionList=b.viewSingleConnection(connNo);
System.out.println(connectionList.get(0).getCustomerId());
return connectionList;
}
finally
{
	return connectionList;
}
}//ends


//update final connection
public StringBuffer updateFinalConnectionIssue(long connNo, String btype, String bplan) {

StringBuffer msg=new StringBuffer();
try
{
BTSSDAO b=new BTSSDAO();
msg=b.updateFinalConnectionIssue(connNo,btype, bplan);
System.out.println(msg);
return msg;
}
finally
{
	return msg;
}
}//ends


//delete connection
public ArrayList<ConnectionIssue>deleteConnectionIssue(long connNo) {

StringBuffer msg=new StringBuffer();
try
{
BTSSDAO b=new BTSSDAO();
connectionList=b.viewSingleConnection(connNo);
System.out.println(connectionList.get(0).getCustomerId());
return connectionList;
}
finally
{
	return connectionList;
}
}//ends


//delete final issued connection
public StringBuffer deleteFinalConnectionIssue(long connNo,String r) {

StringBuffer msg=new StringBuffer();
try
{
BTSSDAO b=new BTSSDAO();
msg=b.deleteFinalConnectionIssue(connNo,r);
System.out.println(msg);
return msg;
}
finally
{
	return msg;
}

}//ends



//view all customer connections
public ArrayList<ConnectionIssue> viewCustomerAllConnection(int cusid) {

StringBuffer msg=new StringBuffer();
try
{
BTSSDAO b=new BTSSDAO();
connectionList=b.viewCustomerAllConnection(cusid);

return connectionList;
}
finally
{
	return connectionList;
}

}//ends



//creating the tariff plan
public StringBuffer createTariff(String tcode1,double monthlyRental,double local,double std,double isd) {

StringBuffer msg=new StringBuffer();
try
{
BTSSDAO b=new BTSSDAO();
msg=b.createTariff(tcode1,monthlyRental,local,std,isd);
System.out.println(msg);
return msg;
}
finally
{
	return msg;
}
}//ends



//view all tariff
public ArrayList<Tariff> viewAllTariff() {

StringBuffer msg=new StringBuffer();
try
{
BTSSDAO b=new BTSSDAO();
tariffList=b.viewAllTariff();
return  tariffList;
}
finally
{
	return  tariffList;
}
}//ends



	
	//--------------------------------------Call details Starts--------------------------/////////////	
		CallDAO da = new CallDAO();
		//Call details methods
			    CallDetails ucd =new CallDetails ();	
				

		public void filecalc(String filecsv){	
							String filecsvn = filecsv;
							da.filecal(filecsvn);
							
						}
		public boolean checkcl(int Callid){
			 boolean s = da.checkcl(Callid);
			return s;
		}

		public CallDetails viewCall(CallDetails c) {
				ucd=da.viewCall(c);
				return ucd;
					} 

		public ArrayList<CallDetails> viewallCl() {
					ArrayList<CallDetails> list1=new ArrayList<CallDetails>();
					list1=da.viewallCl();
					return list1;
				
						
			}

		public void viewCall1(CallDetails ucd) {
				
				da.viewCall1(ucd);
				
			}

			
			
			
		public int deletefile(CallDetails ucd)
			
		{
			int ucd1=0;
			ucd1=da.deletefile(ucd);
			System.out.println("the result in BTSS is"+ucd1);
			return ucd1;
						
	   }

		//--------------------------------------Call details Ends--------------------------/////////////	

		
		
		//---------------------------------------Customer Functions Starts------------------------//////////
		
	
		//adding a customer
		public ArrayList<Customer> createCustomer(String name,String address,String dob,String gender,String number,String emailid)
		{
			Customer cust=new Customer();
			cust.setCustomerName(name);
			cust.setAddress(address);
			cust.setDateOfBirth(dob);
			cust.setGender(gender);
			cust.setPhoneNumber(number);
			cust.setEmailId(emailid);
			//cust.setIdproof(proof);
			//cust.setImage(image);
			//cust.setAddressProof(AddressProof);
			//cust.setAddressImage(AddressImage);
			CustomerDao cdao=new CustomerDao();
			int id=0;
			ArrayList a=null;
			try
			{
				 a=cdao.getCustomerId(cust,name,address,dob,gender,number,emailid);
				
				return a;
			}
			catch(Exception e)
			{
				 System.out.println(e);
				
			}
			return a;
		}//ends


		


		//check acknowledgment id
		public ArrayList<Customer> checkAckId(int id)  
		{
			int check=0;
			ArrayList a=null;
			CustomerDao cdao=new CustomerDao();
			try
			{
			a=cdao.checkCustomer(id);
			return a;
			}
			catch(Exception e)
			{
				System.out.println(e);
		    }
		  return a;
		}//ends 
		
		
		
		//check customer id
		public ArrayList<Customer> checkcustId(int id)  
		{
			int check=0;
			ArrayList a=null;
			CustomerDao cdao=new CustomerDao();
			try
			{
				
			a=cdao.checkCustomerId(id);
			  return a;
			}
			catch(Exception e)
			{
				System.out.println(e);
		    }
		  return a;
		}//ends




		//update customer registration
		public ArrayList<Customer> createCustomerUpdate(String name,String address,String dob,String gender,String number,String emailid,String proof,String image,int ack,String AddressProof,String AddressImage)
		{
			Customer cust=new Customer();
			cust.setCustomerName(name);
			cust.setAddress(address);
			cust.setDateOfBirth(dob);
			cust.setGender(gender);
			cust.setPhoneNumber(number);
			cust.setEmailId(emailid);
			cust.setIdproof(proof);
			cust.setImage(image);
			cust.setAddressProof(AddressProof);
			cust.setAddressImage(AddressImage);
			CustomerDao cdao=new CustomerDao();
			int id=0;
			ArrayList a=null;
			try
			{
				 a=cdao.updateCustomerRegis(cust,name,address,dob,gender,number,emailid,proof,image,ack,AddressProof,AddressImage);
				
				return a;
			}
			catch(Exception e)
			{
				 System.out.println(e);
				
			}	
			return a;

		}//ends




		//update personal details
		public ArrayList<Customer> createCustomerUpdateAdmin(String name,String address,String dob,String gender,String number,String emailid,int cid,String addressProof,FileItem addressImage)
		{
			Customer cust=new Customer();
			cust.setCustomerName(name);
			cust.setAddress(address);
			cust.setDateOfBirth(dob);
			cust.setGender(gender);
			cust.setPhoneNumber(number);
			cust.setEmailId(emailid);
			
			cust.setAddressProof(addressProof);
			//cust.setAddressImage(addressImage);
			CustomerDao cdao=new CustomerDao();
			int id=0;
			ArrayList a=null;
			try
			{
				 a=cdao.updateCustomerDetails(cust,name,address,dob,gender,number,emailid,cid,addressProof,addressImage);
				 System.out.println("hello btss");
				return a;
			}
			catch(Exception e)
			{
				 System.out.println("hello btss final"+e);
				
			}	
			return a;
		}//ends



		//start of view all customers by administrator

		public ArrayList<Customer> viewAllCustomer()
		{

			CustomerDao cdao=new CustomerDao();	
			
			try
			{
				ArrayList<Customer> objList=cdao.viewAllCustomers();
			  return objList;
			}
			catch(Exception e)
			{
				System.out.println(e);
		    }
		  return null;
		}

		//end of view all customers by administrator




		//image retrieving
		//id image
		
		public Image getIdProof(int id) throws SQLException
		{
			CustomerDao obj=new CustomerDao();
			try
			{
			return obj.getIdProof(id);
			}
			catch(Exception e)
			{
				System.out.println(e);
				return null;
			}
		}
		//end of id image
		
		
		

		//address image
			public Image getAddressProofImage(int id) throws SQLException
		{
			CustomerDao obj=new CustomerDao();
			try
			{
			return obj.getAddressProofImage(id);
			}
			catch(Exception e)
			{
				System.out.println(e);
				return null;
			}
		}
		
		//end of address image
		//end of image retrieving



	
			//delete customer
		public int deleteCustomer(int cid)
		{
			int a=0;
			CustomerDao cdao=new CustomerDao();
			try
			{
			a=cdao.deleteCustomer(cid);
			  return a;
			}
			catch(Exception e)
			{
				System.out.println(e);
				 return a;
			}
		 
		}

		//end of delete part
		//---------------------------------------Customer Functions ends------------------------//////////	

}//end of class
