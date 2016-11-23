function master()
{
	var user=document.login.logname.value;
	var paswrd=document.login.pwd.value;
	
	if(user.length==0)
	{
		alert("Please enter the username");
		return false;
	}
	else if(isNaN(user)==true)
	{
		alert("Username contains only digits");
		return false;
	}
	
	else if(user.length>6)
	{
		alert("Username contains only of 6 digits");
		return false;
	}
	
	else if(paswrd.length==0)
	{
		alert("Please enter the password");
		return false;
	}
	else
	{
		return true;
	}
	
}