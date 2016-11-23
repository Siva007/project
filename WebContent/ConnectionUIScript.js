function check()
{
   
 var customerid=document.connectionForm.cid.value;
 
 var numcheck=/^[0-9]*$/;
 if(customerid=="")
 {
 	alert("Please enter the Customer ID");
 	return false;
 }
 if(!(numcheck).test(customerid)){
 	alert("Please enter a proper number format for Customer ID");
 	return false;
 }

 if((customerid.length)>6 ||(customerid.length<6))
 {
 	alert("Please enter valid six digit Customer ID");
 	return false;
 }
 if((isNaN(customerid)))
 {
 	alert("Please enter only numerics in this field");
 return false;
 }

var r0=document.connectionForm.btype[0].checked;

var r1=document.connectionForm.btype[1].checked;

if(r0==false && r1==false)
{
alert("Please select the Bill type");
return false;
}
var check=document.connectionForm.bplan.value;
if(check==0)
{
	alert("Please select type of plan");
	return false;
}
return true;
     
	}
