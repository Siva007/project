 package com.tcs.model;

import javax.servlet.http.HttpServletRequest;

public class ValidateCustomerRegistration {


public int checkDetails(String name,String address,String dob,String gender,String number,String emailid,String s)
{	
	if((name==null)||(name=="")||(address==null)||(address=="")||(dob==null)||(dob=="")||(gender==null)||(gender=="")||(number==null)||(number=="")||(emailid==null)||(emailid=="")||(s==null)||(s==""))
	{
		
		return 0;
	}
	else
		return 1;
}


public int checkUpdateDetails(String name,String address,String dob,String gender,String number,String emailid,String proof,String image)
{
	
	
	if((address==null)||(address=="")||(number==null)||(number=="")||(emailid==null)||(emailid==""))
	{
		
		return 0;
	}
	else
		return 1;
	
}


public int checkimage(String idp,String img,String AddressProof,String AddressImage)
{
	if((img==null)||(img=="")||(idp==null)||(idp==""))
{
		
		return 0;
	}
	else if((AddressImage==null)||(AddressImage=="")||(AddressProof==null)||(AddressProof==""))
{
		
		return 0;
	}
	else
		return 1;
}
}
