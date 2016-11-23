function master()
{
var id=document.deletecustomer.customerId.value;
if(id.length==0)
{
	alert("Please enter the customer id.");
	return false;
}
else if(id.length!=6)
{
	alert("Customer id contains only 6 digits.");
	return false;
}
else if(isNaN(id)==true)
{
	alert("Customer id contains only digits.");
	return false;
}
else 
{
	return true;
}
}