package model;
import java.util.*;

import javax.servlet.http.HttpServletRequest;



public class BTSS {
ArrayList<Customer>customerList=new ArrayList<Customer>();
ArrayList <Connection> connectionList =new ArrayList <Connection>();
ArrayList <CallDetails> callDetailsList	=new ArrayList <CallDetails>();

public BTSS()
{
	
	Customer cu1=new Customer();
	cu1.setAcknowlegmentId(12345);
	cu1.setCustomerId(1001);
	cu1.setCustomerName("Shweta");
	cu1.setAddress("65,Sadar Bazar,Jhansi");
	cu1.setDateOfBirth("28/11/1990");
	cu1.setGender("Female");
	cu1.setPhoneNumber("1236547895");
	cu1.setEmailId("shweta.agrwl@gmail.com");

	Customer cu2=new Customer();
	cu2.setAcknowlegmentId(12346);
	cu2.setCustomerId(1002);
	cu2.setCustomerName("Sai");
	cu2.setAddress("Guntur abcdefghifssf");
	cu2.setDateOfBirth("19/02/1991");
	cu2.setGender("Male");
	cu2.setPhoneNumber("1234567890");
	cu2.setEmailId("hisai@gmail.com");


	customerList.add(cu1);
	customerList.add(cu2);
	
	
	
	Connection c=new Connection();
	c.setCustomerId(123);
	c.setConnectionNumber(99769192171L);
	c.setPulseRateForISD(12);
	c.setPulseRateForLocal(12);
	c.setPulseRateForSTD(12);
	c.setStatus("active");
	connectionList.add(c);
	
	
	Connection c1=new Connection();
	c1.setCustomerId(124);
	c1.setConnectionNumber(99769192172L);
	c1.setPulseRateForISD(12);
	c1.setPulseRateForLocal(12);
	c1.setPulseRateForSTD(12);
	c1.setStatus("active");
	connectionList.add(c1);
	
	Connection c2=new Connection();
	c2.setCustomerId(125);
	c2.setConnectionNumber(99769192173L);
	c2.setPulseRateForISD(12);
	c2.setPulseRateForLocal(12);
	c2.setPulseRateForSTD(12);
	c2.setStatus("active");
	connectionList.add(c2);
	
	
	CallDetails cd=new CallDetails();
	cd.setCallId(101);
	cd.setDateOfCall("12/12/2012");
	cd.setConnectionNumber(91234);
	cd.setNumberToWhichCallWasMade("9698713788");
	cd.setCallDuration(12.54);
	cd.setTypeOfCall("STD");
	callDetailsList.add(cd);
		
	CallDetails cd1=new CallDetails();
	cd1.setCallId(102);
	cd1.setDateOfCall("12/12/2012");
	cd1.setConnectionNumber(91235);
	cd1.setNumberToWhichCallWasMade("9698713788");
	cd1.setCallDuration(05.24);
	cd1.setTypeOfCall("STD");
	callDetailsList.add(cd1);
		
	CallDetails cd2=new CallDetails();
	cd2.setCallId(103);
	cd2.setConnectionNumber(91236);
	cd2.setDateOfCall("12/12/2012");
	cd2.setNumberToWhichCallWasMade("9698713799");
	cd2.setCallDuration(32.18);
	cd2.setTypeOfCall("LOCAL");
	callDetailsList.add(cd2);

	
}


public void createCustomer(String name,String address,String dob,String gender,String number,String emailid,String proof)
{
	Customer cust=new Customer();
	cust.setCustomerName(name);
	cust.setAddress(address);
	cust.setDateOfBirth(dob);
	cust.setGender(gender);
	cust.setPhoneNumber(number);
	cust.setEmailId(emailid);
	cust.setIdproof(proof);
		
}


public int checkCustomerId(int id)  
{
	  int check=0;
  for(int i=0;i<customerList.size();i++)
  {
	   if(id==customerList.get(i).getCustomerId())
	   {
		   check=1;
		   break;
	   }
	   else
	   {
		   check=0;
	   }
  }
  return check;
}
public Customer getCustomerObject(int id)
{
	 for(int i=0;i<customerList.size();i++)
	   {
		   if(id==customerList.get(i).getCustomerId())
		   {
			   Customer obj=customerList.get(i);
			   return obj;
			   
		   }
	   }
	
	return null;
}
public boolean checkCustomerDetails()
{

	if(connectionList.size()==0)
	{
	return false;
		}
	return true;
}

public ArrayList<Customer> customerViewByAdminDetails()
{
	return customerList;
}

public void updateCustomer(HttpServletRequest request)
{
	

	
	String id=request.getParameter("check");
	System.out.println("hello");
    int l=Integer.parseInt(id);
 
	
		
	
	String add=request.getParameter("address");
	String g=request.getParameter("sex");
	String num=request.getParameter("contact");
	String mail=request.getParameter("email");
	
	
	
	
	for(Customer c:customerList)
	{
		if(l == c.getCustomerId())
		{
			System.out.println("Updating");
			
			

			c.setAddress(add);
			c.setGender(g);
			c.setPhoneNumber(num);
			c.setEmailId(mail);	
			
			
			
			System.out.println("Update sucessfull");
		}
	
	}
}




public void deleteCustomer(HttpServletRequest request)
{
	

	
	String id=request.getParameter("idcheck");
	System.out.println("hello");
	int l=Integer.parseInt(id);
 
	
		
	
	
	
	
	for(Customer c:customerList)
	{
		if(l == c.getCustomerId())
		{
			System.out.println("Deleting");
			
			customerList.remove(c);
			System.out.println("Delete  sucessfull");
		}
	

}

}


public void createConnection(int cid,String btype,String bplan)
{
		Connection c=new Connection();
		System.out.println("Issue sucessful1235");
		
		if(connectionList.size()==0)
		{
			c.setConnectionNumber(9000000000L);
			System.out.println("Connection Number issued"+c.getConnectionNumber());
		}
				else
		{
		long i=c.getConnectionNumber();
		i=i+1;
		c.setConnectionNumber(i);
		System.out.println("Connection Number issued hello"+i);
		}
		c.setCustomerId(cid);
		c.setPulseRateForISD(12);
		c.setPulseRateForLocal(12);
		c.setPulseRateForSTD(12);
		c.setStatus("active");
		connectionList.add(c);
		
		
}
	
public boolean checkConnectionDetails()
{

	if(connectionList.size()==0)
	{
	return false;
		}
	return true;
}


public ArrayList<Connection> connectionViewByAdminDetails()
{
	return connectionList;
}

public int checkConnectionNumber(long num)  
{
	  int check=0;
	  System.out.println("Checking details");
  for(int i=0;i<connectionList.size();i++)
  {
	   if(num==connectionList.get(i).getConnectionNumber())
	   {
		   check=1;
		   break;
	   }
	   else
	   {
		   check=0;
	   }
  }
  return check;
}

public Connection getConnectionObject(long num)
{
	 for(int i=0;i<connectionList.size();i++)
	   {
		   if(num==connectionList.get(i).getConnectionNumber())
		   {
			   Connection obj=connectionList.get(i);
			   return obj;
			   
		   }
	   }
	
	return null;
}



public void updateConnection(HttpServletRequest request)
{
	String num=request.getParameter("connectionNumber");
	String isd=request.getParameter("pulseRateForISD");
	String local=request.getParameter("pulseRateForLocal");
	String std=request.getParameter("pulseRateForSTD");
	
	
	
	Long l=Long.parseLong(num);
	for(Connection c:connectionList)
	{
		if(l == c.getConnectionNumber())
		{
			System.out.println("Updating");
			c.setPulseRateForISD(Double.parseDouble(isd));
			c.setPulseRateForLocal(Double.parseDouble(local));
			c.setPulseRateForSTD(Double.parseDouble(std));
			System.out.println("Update sucessfull");
		}
	}
	
	
}
public void deleteConnection(String no)
{

	double d=Double.parseDouble(no);
	
	for(Connection c:connectionList)
	{
		if(d == c.getConnectionNumber())
		{
			System.out.println("Deleting");
			c.setStatus("inactive");			
			System.out.println("Delete sucessfull");
		}
	}
	
	
}






public void createCallDetails(int cid, String temp, double dur, String ncm, String type)
{
	   CallDetails cd= new CallDetails();
	   cd.setCallId(cid);
	   
	   cd.setDateOfCall(temp);
	   cd.setCallDuration(dur);
	   cd.setNumberToWhichCallWasMade(ncm);
	   cd.setTypeOfCall(type);
	   callDetailsList.add(cd);
	   System.out.println("asdd sucessfully");
} 

   
public boolean checkCallDetails()
{

	if(callDetailsList.size()==0)
	{
	return false;
		}
	return true;
}


public ArrayList<CallDetails> callDetailsViewByAdmin()
{
	return callDetailsList;
}

   


public CallDetails getCallIdObject(int id)
{
	 for(int i=0;i<callDetailsList.size();i++)
	   {
		   if(id==callDetailsList.get(i).getCallId())
		   {
			   CallDetails obj=callDetailsList.get(i);
			   return obj;
			   
		   }
	   }
	
	return null;
}

public int checkCallid(int id)  
{
	  int check=0;
	  System.out.println("Checking details");
  for(int i=0;i<callDetailsList.size();i++)
  {
	   if(id==callDetailsList.get(i).getCallId())
	   {
		   check=1;
		   break;
	   }
	   else
	   {
		   check=0;
	   }
  }
  return check;
}
 public void updateCallDetails(HttpServletRequest request)

 {
	 System.out.println("hi");
	 String cer=request.getParameter("check2");
	String doc=request.getParameter("dateofcall");
	 String cd=request.getParameter("callduration");
	 String ncm=request.getParameter("numberto");
	 String typ=request.getParameter("type");
	 
		
		int l=Integer.parseInt(cer);
		for(CallDetails c:callDetailsList)
		{
			 System.out.println("hi23");
			if(l == c.getCallId())
			{
				System.out.println("Updating");
				c.setCallId(l);
				c.setDateOfCall(doc);
				c.setCallDuration(Double.parseDouble(cd));
				c.setNumberToWhichCallWasMade(ncm);
				c.setTypeOfCall(typ);
				System.out.println("Update sucessfull");
				
			}
		}

 }

		public void deleteCallDetails(HttpServletRequest request)
		 {

		 System.out.println("hi");
		 
		
		 String cid=request.getParameter("check");
		 
		 int l=Integer.valueOf(cid);
		 
			for(int i=0;i<callDetailsList.size();i++) 
			{
				if(l == callDetailsList.get(i).getCallId())
				{
					System.out.println("Deleting");
					callDetailsList.remove(i);
					
				
				}
			}	
		}



 }
 
 






 
	
 
 
 
	
 
 














	

