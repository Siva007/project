function master()
{
var aid=document.updateregis.ackid.value;
if(aid.length==0)
{
	alert("Please enter the acknowledgment id.");
	return false;
}
else if(aid.length>4)
{
	alert("Acknowledgment id contains only 4 digits.");
	return false;
}
else if(isNaN(aid)==true)
{
	alert("Acknowledgment id contains only digits.");
	return false;
}
else 
{
	return true;
}
}