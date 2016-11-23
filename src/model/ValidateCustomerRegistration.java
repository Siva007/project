 package model;

import javax.servlet.http.HttpServletRequest;

public class ValidateCustomerRegistration {


public int checkDetails(String name,String address,String dob,String gender,String number,String emailid,String proof)
{	
	if((name==null)||(name=="")||(address==null)||(address=="")||(dob==null)||(dob=="")||(gender==null)||(gender=="")||(number==null)||(number=="")||(emailid==null)||(emailid=="")||(proof==null)||(proof==""))
	{
		
		return 0;
	}
	else
		return 1;
}


public int checkUpdateDetails(HttpServletRequest request)
{
	String address=request.getParameter("address");
	String num=(request.getParameter("contact"));
	String mail=request.getParameter("email");
	
	if((address==null)||(address=="")||(num==null)||(num=="")||(mail==null)||(mail==""))
	{
		
		return 0;
	}
	else
		return 1;
	
}

}
