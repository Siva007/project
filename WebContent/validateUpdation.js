function master()
{
 if(chk_add()==false)
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
 
 else if(checker()==false)
 {
   return false;
 }
else
{
  return true;
}
}


//smaller functions



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
  alert("Not a valid e-mail address");
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






function chk_image()
{
	
	var addp=document.regform.addressproof.value;
	
	var addimg=document.regform.addressImage.value;
	
	var apos=addimg.lastIndexOf(".");
	var ii=apos+1;
	var jj=apos+2;
	var kk=apos+3;
	var ll=apos+4;
	var aa=addimg.charAt(ii);
	var bb=addimg.charAt(jj);
	var cc=addimg.charAt(kk);
	var dd=addimg.charAt(ll);
	var format=aa+bb+cc+dd;

	if((addp.length!=0)&&(addp=="Address Skip")&&(addimg.length!=0))
	{
alert("Please select an address proof for the address proof image");
return false;
	}
	else if((addimg.length!=0)&&(format!="jpeg")&&(format!="jpg")&&(format!="bmp")&&(format!="png"))
	{
		alert("Please upload the ADDRESS PROOF image with format like .jpeg,.jpg,.bmp,or .png only ");
		return false;
	}
	else
	{
		return true;
	}
} 
function checker()
{
	
var check=confirm("Press OK to update the customer");
if (check==true)
  {
return true;
  }
else
  {
return false;
  }

}
