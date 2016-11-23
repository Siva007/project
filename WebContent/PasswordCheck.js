

 function checkPassword(str)
  {
    var re = /^[0-9a-zA-Z]+$/;
    return re.test(str);
  }



function check()
{
	
	var nep=document.changepwd.newp.value;
	var op=document.changepwd.confirmp.value;
	
	 
	var oldpp=document.changepwd.oldp.value;
	if(oldpp.length==0)
	{
		alert("Please fill the old password field");
		return false;
	}
	else if(nep.length==0)
	{
		alert("Please fill the new password field");
		return false;
	}
	else if((nep.length<8)||(nep.length>15))
	{
		alert("The password should be 8-15 characters in length only");
		return false;
	}
	else if(!checkPassword(nep))
		{
	        alert("The password you have entered is not valid!");
	        return false;
	      }
		
		
	
	else if(op.length==0)
	{
		alert("Please fill the confirm password field");
		return false;
	}
	else if((op.length<8)||(op.length>15))
	{
		alert("The password should be 8-15 characters in length only");
		return false;
	}
	else if(!checkPassword(op))
		{
	        alert("The password you have entered is not valid!");
	        return false;
	      }
		

	
	else if(!nep.equals(op))
	{
		
		alert("New password and confirm password does not match");
		return false;
	}
	else
	{
		alert("Password changed successfully.");
		return true;
	}
	}