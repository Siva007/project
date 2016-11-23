function master()
{
 if(chk_name()==false)
  {
    return false;
  }
else if(chk_add()==false)
 {
   return false;
 }
else if(chk_date()==false)
{
  return false;
}

else if(chk_gender()==false)
{
  return false;
}

else if(check_no()==false)
  {
   return false;
  }
else if(chk_email()==false)
 {
   return false;
 }



else if(chk_status()==false)
{
  return false;
}
else
{
  return true;
}
}


//smaller functions

function chk_name()
{
  var n=document.regform.custname.value;
  var iChars = "!@#$%^&*()+=-[]\\\';,./{}|\":<>?1234567890"; 
  var a,b,c,i;
  for(i=0;i<n.length;i++)
  {
    var ch=n.charAt(i);
    if((iChars.indexOf(ch)!= -1))      
     {
    alert("Customer name should have only alphabets");
    return false;
     }
  }
    if(n.length==0)
   {
     alert("Customer name should not be empty");
	return false;
   }
  else if(n.length>20)
   {
     alert("Customer name should not be greater than 20 characters");
return false;
   }
else if(!isNaN(n))
{
  alert("Customer name should not have digits");
 return false;
}
 return true;
}



function chk_add()
{
  var a=document.regform.address.value;
  if(a.length==0)
   {
     alert("Address field should not be empty");
     return false;
   }
  else if(a.length<20)
  {
    alert("Address should contain minimum 20 characters");
	return false;
  }
  else if(a.charAt(0)==" ")
  {
	  alert("Address should not start with space");
		return false;
  }
  
return true;
}



function check_no()
{
   var con=document.regform.contact.value;
  var a,b,i;
  
  for(i=0;i<con.length;i++)
  {
    var ch=con.charAt(i);
    if(isNaN(ch)==true)
     {
       a=1;
     }
    else
     {
       b=1;
     }
   }
 if((a==1)&&(b==1))
  {
    alert("Contact number should have only digits");
    return false;
  }

  else if(con.length==0)
   {
     alert("Please fill the Contact number");
	return false;
   }
  else if(con.length!=10)
    {
      alert("Contact Number should be of exactly 10 digits");
return false;
    }
else if(isNaN(con))
{
alert("Contact Number should not have any character");
  return false;
}
else if(con.charAt(0)==0)
{
	    alert("Contact number should not start with a zero");
	    return false;
 }
else
return true;
}


function chk_email()
{
var x=document.regform.email.value;
var atpos=x.indexOf("@");
var dotpos=x.lastIndexOf(".");
var afterdot=x.substring(x.lastIndexOf('.') + 1);
var iChars = " !@#$%^&*()+=-[]\\\';,./{}|\":<>?1234567890"; 
var a,b,c,i;

if(x.length==0)
   {
     alert("Email id should not be empty");
	return false;
   }
else if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length)
  {
  alert("Please enter a valid e-mail address");
return false;
  }
for(i=0;i<afterdot.length;i++)
{
  var ch=afterdot.charAt(i);
  if((iChars.indexOf(ch)!= -1))      
   {
  alert("Email should contain only alphabets after the last dot");
  return false;
   }
}
return true;
}



function chk_gender()
{

if((document.regform.sex[0].checked==false)&&(document.regform.sex[1].checked==false))
{
alert(" Please select gender");
return false;
}
else
return true;
}


function chk_date()
{
	var obj=new Date();
	var datea=obj.getDate();
	var montha=obj.getMonth() + 1;
	var yeara=obj.getFullYear();

	var dateform=document.regform.dob.value;
	var date=dateform.charAt(0)+dateform.charAt(1);
	var month=dateform.charAt(3)+dateform.charAt(4)
	var year=dateform.charAt(6)+dateform.charAt(7)+dateform.charAt(8)+dateform.charAt(9); 
	  

	if(dateform.length==0)
		{
	  alert("Date field should not be empty");
	return false;
		}

	else if((dateform.charAt(2)!="/")&&(dateform.charAt(5)!="/"))
		{
	 alert("Please enter the date in sample format");
	return false;
		}
else 
	{
	if(date==0||month==0||year==0)
		{
	alert("Please enter the date");
	return false;
		}
	else if(date==""||month==""||year=="")
		{
		alert("Please enter the date");
		return false;

	}
	else if(isNaN(date)||isNaN(month)||isNaN(year))
		{
		alert("Date should have only digits");
		return false;
		}
	else if(date>31||month>12||year>yeara)
		{
		alert("Please enter the valid date");
		return false;
		}
	else if((month==4)||(month==6)||(month==9)||(month==11))
		{
		
		if(date>30)
			{
		alert("Please enter the valid date.It cannot be greater than 30 for this month");
		return false;
		}
		else
		{
	if((yeara-year)>18)
	{
	return true;
	}
	else if((yeara-year)==18)
	{

	if((montha-month)>0)
		{
	    return true;
		}
	else if((montha-month)==0)
	{
	 if((datea-date)>0)
		{
	 return true;
	 }
	else if((datea-date)==0)
		{
	return true;
	}
	else
		{
		alert("Sorry.You are underaged,not elligible for registration ");
		return false;
		}
	}
	else
	{
		alert("Sorry.You are underaged, not elligible for registration" );
	return false;
	}
	}
	else
	{
		alert("Sorry.You are underaged, not elligible for registration" );
	return false;
	}
	}

	}



	else if(month==2)
	{
		var comp=year%4;
		if(comp==0)
	{
	if(date>29)
		{
	alert("Please enter the valid date.Its a leap year.Feb has only 29 days");
	return false;
	}
	else
	{
	if((yeara-year)>18)
	{
	return true;
	}
	else if((yeara-year)==18)
	{

	if((montha-month)>0)
	{
	return true;
	}
	else if((montha-month)==0)
	{
	if((datea-date)>0)
	{
	return true;
	}
	else if((datea-date)==0)
	{
	return true;
	}
	else
	{
	alert("Sorry.You are underaged, not elligible for registration");
	return false;
	}
	}
	else
	{
	alert("Sorry.You are underaged, not elligible for registration");
	return false;
	}
	}
	else
	{
	alert("Sorry.You are underaged, not elligible for registration");
	return false;
	}
	}

	}
		
		else
		{
		if(date>28)
			{
		alert("Please enter the valid date.February has only 28 days.");
		}
		else
		{
		if((yeara-year)>18)
		{
		return true;
		}
		else if((yeara-year)==18)
		{

		if((montha-month)>0)
		{
		return true;
		}
		else if((montha-month)==0)
		{
		if((datea-date)>0)
		{
		return true;
		}
		else if((datea-date)==0)
		{
		return true;
		}
		else
		{
		alert("Sorry.You are underaged, not elligible for registration");
		return false;
		}
		}
		else
		{
		alert("Sorry.You are underaged, not elligible for registration");
		return false;
		}
		}
		else
		{
		alert("Sorry.You are underaged, not elligible for registration");
		return false;
		}
		}

		}
		}



	else
	{
	if(date>31)
		{
	alert("Please enter the valid date.date cannot be greater than 31 for any month");
	}
	else
	{
	if((yeara-year)>18)
	{
	return true;
	}
	else if((yeara-year)==18)
	{

	if((montha-month)>0)
	{
	return true;
	}
	else if((montha-month)==0)
	{
	if((datea-date)>0)
	{
	return true;
	}
	else if((datea-date)==0)
	{
	return true;
	}
	else
	{
	alert("Sorry.You are underaged, not elligible for registration");
	return false;
	}
	}
	else
	{
	alert("Sorry.You are underaged, not elligible for registration");
	return false;
	}
	}
	else
	{
	alert("Sorry.You are underaged, not elligible for registration");
	return false;
	}
	}

	}
	}
	//return true;
}


function chk_status()
{

	if((document.regform.fillp[0].checked==false)&&(document.regform.fillp[1].checked==false))
	{
	alert(" Please select an option for the proofs");
	return false;
	}
	else
	return true;
}


/*
function chk_image()
{
	var p=document.regform.idproof.value;
	var addp=document.regform.AddressProof.value;
	var img=document.regform.image.value;
	var addimg=document.regform.AddressImage.value;
	var ipos=img.lastIndexOf(".");
	var apos=addimg.lastIndexOf(".");
	var i=ipos+1;
	var j=ipos+2;
	var k=ipos+3;
	var l=ipos+4;
	var a=img.charAt(i);
	var b=img.charAt(j);
	var c=img.charAt(k);
	var d=img.charAt(l);
	var format1=a+b+c+d;

	var ii=apos+1;
	var jj=apos+2;
	var kk=apos+3;
	var ll=apos+4;
	var aa=addimg.charAt(ii);
	var bb=addimg.charAt(jj);
	var cc=addimg.charAt(kk);
	var dd=addimg.charAt(ll);
	var format=aa+bb+cc+dd;
	
	
	if((p.length!=0)&&(p!="Id Skip")&&(img.length==0))
	{
		alert("Please upload the image for the id proof");
		return false;
	}
	
	else if((img.length!=0)&&(format1!="jpeg")&&(format1!="jpg")&&(format1!="bmp")&&(format1!="png"))
	{
		alert("Please upload the ID PROOF image with format like .jpeg,.jpg,.bmp,or .png only ");
		return false;
	}
	else if((addp.length!=0)&&(addp!="Address Skip")&&(addimg.length==0))
	{
		alert("Please upload the image for the address proof");
		return false;
	}
	else if((addimg.length!=0)&&(format!="jpeg")&&(format!="jpg")&&(format!="bmp")&&(format!="png"))
	{
		alert("Please upload the ADDRESS PROOF image with format like .jpeg,.jpg,.bmp,or .png only ");
		return false;
	}
	else if((p.length!=0)&&(p=="Id Skip")&&(img.length!=0))
			{
		alert("Please select an idproof for the idproof image");
		return false;
			}
	else if((addp.length!=0)&&(addp=="Address Skip")&&(addimg.length!=0))
	{
alert("Please select an address proof for the address proof image");
return false;
	}
	else if((p.length!=0)&&(p=="Id Skip")&&(addp!="Address Skip"))
	{
		alert("Please fill both the proofs together.");
		return false;
	}
	
	else if((addp.length!=0)&&(p!="Id Skip")&&(addp=="Address Skip"))
	{
		alert("Please fill both the proofs together.");
		return false;
	}
	
	else
	{
		return true;
	}
}*/


