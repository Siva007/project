<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.tcs.model.CallDetails" %>
    <%@ page import="java.util.ArrayList" %>
<html>

<head>
<meta http-equiv="Page-Enter" 
content="RevealTrans(Duration=1.0,Transition=12)" />

<meta http-equiv="Page-Exit" 
content="RevealTrans(Duration=1.0,Transition=12)" />

<title>Call Details Update</title>

<script type="text/javascript">
window.history.forward(1);
window.history.forward(-1);
</script>

 <script type="text/javascript">

      function validate(){
var id=document.form4.ID.value;
var numcheck=/^[0-9]*$/;
if(id==""){
	alert("Please enter the Call ID");
	return false;
}
if(!(numcheck).test(id)){
	alert("Please enter a proper number format for Call ID");
	return false;
}

if((id.length)>4)
{
	alert("Please enter valid four digit Call ID");
	return false;
}
if((isNaN(id)))
{
	alert("Please enter only numerics in this field");
return false;
}
return true;
}
    </script>
<script>

        function displayTextBox2()
        {
   
            var objElement2=document.getElementById('otherTextBox2');
                        otherTextBox2.style.display = 'block';
			otherTextBox2.style.visibility = 'visible';                                                                         otherTextBox.style.visibility='hidden';
                        otherTextBox.style.display='none';
        }
        function hideTextBox2(){
			var obj=document.getElementById('otherTextBox2');
			 otherTextBox2.style.display = 'block';
			 otherTextBox2.style.visibility = 'hidden';                                                                         otherTextBox.style.visibility='hidden';
             otherTextBox.style.display='none';
            }
		
		
		
    </script>
    
   
<link rel="stylesheet" type="text/css" href="teleservices.css"/>
<script type="text/javascript" src="helpemp.js">
</script>

<script type="text/javascript" src="http://www.2createawebsites.com/resources/multi-level-menu-html.js">
</script>

</head>


<body topmargin="0" background="bg_clouds.jpg" leftmargin="0" style="text-align: left; word-spacing: 0; line-height: 100%; margin-top: 0; margin-bottom: 0" onload="dynAnimation()">


    <table align="center" border="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#89CFF0" width="700" height="192" cellpadding="0">
    
   <table align="center" border="0" cellspacing="0" class="stable1" bordercolor="#111111" width="700" height="192" cellpadding="0">
  <tr>
    <td width="100%" height="44" bgcolor="#FFFFFF">
    <div align="center">
      <center>
      <table border="0" cellpadding="0" cellspacing="0" class="stable2" bordercolor="#111111" width="100%" bgcolor="#FFFFFF">
      <tr>
        <td width="8%" class="std1">
        <img border="0" src="logo2.JPG" width="57" height="48"></td>
        <td width="92%" class="std2"><b><font face="Tahoma" size="5">Bharat Tele Services 
        </font><font face="Tahoma" size="2" color="#3399FF">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
        INTERNATIONAL CELLULAR MOBILE SERVICES </font></b></td>
      </tr>
    </table>
    </center>
    </div>
    </td>
  </tr>
    
     <tr>
    <td width="100%" height="33" bgcolor="#3399FF" class="std3"  valign="middle">
    <p align="right"><b><font face="Arial" color="#FFFFFF">
    <span style="letter-spacing: 2">Value Added Services</span>
    <span style="letter-spacing: 1">&nbsp;</span></font></b></td>
   </tr>
   <tr>

    
    
    

<tr>
   <td width="100%" height="25" class="std4"  bgcolor="#000000">
    
<table border="0" cellpadding="0" cellspacing="0" class="stable1" bordercolor="#111111" width="100%">
      <tr>
        <td width="2%" bordercolor="#FFFFFF" valign="middle" class="std5">&nbsp;</td>
        
        <td width="74%" valign="middle">

        <font color="#FFFF00" size="2" face="Arial">

        <font onmouseover="this.style.color='white'" onmouseout="this.style.color='#FFFF00'">





        <a href="home.jsp" class="std5">
        <font color="#FFFF00" onmouseover="this.style.color='white'" onmouseout="this.style.color='#FFFF00'">
        Home
        </font>
        </a>&nbsp;&nbsp; |&nbsp;&nbsp; 
        </font>

       
        <a href="Corporate.jsp" class="stable1">
        <font color="#FFFF00" onmouseover="this.style.color='white'" onmouseout="this.style.color='#FFFF00'">
        Corporate&nbsp;
        </font>
        </a>&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;

		<a  class="stable1" href="AboutUs.jsp" >
        <font color="#FFFF00"onmouseover="this.style.color='white'" onmouseout="this.style.color='#FFFF00'">About Us</font></a>&nbsp;&nbsp;&nbsp; |&nbsp;&nbsp;&nbsp;
       <a  class="stable1" href="Services.jsp" >
       <font color="#FFFF00"onmouseover="this.style.color='white'" onmouseout="this.style.color='#FFFF00'">Services</font></a><font color="#FFFF00" onmouseover="this.style.color='white'" onmouseout="this.style.color='#FFFF00'">&nbsp;</font>&nbsp;&nbsp; |&nbsp;&nbsp;&nbsp; 
       <font color="#FFFF00" onmouseover="this.style.color='white'" onmouseout="this.style.color='#FFFF00'">
<a class="stable1" href="Login2Controller?operation=logout">
       <font color="#FFFF00" onmouseover="this.style.color='white'" onmouseout="this.style.color='#FFFF00'">Logout</font></a>&nbsp; |&nbsp;&nbsp;
        <a class="stable1" href="ContactUs.jsp">
       <font color="#FFFF00" onmouseover="this.style.color='white'" onmouseout="this.style.color='#FFFF00'">Contact Us</font></a></font></td>
        <td width="100%" valign="middle" class="std6">
        <p align="right">
        <iframe src="http://free.timeanddate.com/clock/i392spca/n1892/fn15/fcfff/tc000/tt0/tw0/tm1/ta1/tb2" frameborder="0" width="184" height="18"></iframe></a>
      </td>

     </tr>
     </table>
     </td>
     </tr>
     <tr>
     <td bgcolor="#89CFF0" width="100%" height="421" valign="top">
     <table bgcolor="#89CFF0" border="0" cellpadding="0" cellspacing="0" style="border-bottom-style: solid; border-bottom-width: 1 ;border-right-style: solid; border-right-width: 1 ;border-left-style: solid; border-left-width: 1 " bordercolor="#111111" width="703" height="370">
     <tr>
     <td width="672" height="1" bgcolor="#CCFFCC" style="border-left-style: solid; border-left-width: 1" colspan="3" bordercolor="#99CCFF" valign="top">
     <p align="center">&nbsp;<font face="Arial" size="2"><marquee scrolldelay=10 scrollamount="2">Bharat Tele Services is introducing new <b>Location Based Services</b> </marquee></font></td>
     </tr>
     <tr bgcolor="#89CFF0">
     <td bgcolor="#89CFF0" width="672" height="14" bgcolor="#FFFFFF" style="border-left-style: solid; border-left-width: 1">&nbsp;
     </td>
     <td bgcolor="#89CFF0" width="388" height="14" bgcolor="#FFFFFF"  >&nbsp;
     </td>
     </tr>
     
     
     
     <tr>
     <td width="180" height="380" bgcolor="#FFFFFF" valign="top" >
     <table bgcolor="#89CFF0" border="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" width="181" height="459">
     
     
     
     
    
            
   <div class="createawebsitediv">
  <ul id="createawebsite1">

   
<li><a href="sample-admin.jsp">Customer Registration </a>
   <ul>

   <li><a href="CustomerUI.jsp">Add Customer</a></li>
   <li><a href="CustomerUpdateRegistration.jsp">Update Customer Registration</a></li>
   
<li><a href="CustomerController?operation=viewSingleCustomerPage">View Single Customer </a></li>

<li><a href="CustomerController?operation=viewAllCustomer">View All Customers</a></li>

   <li><a href="CustomerUpdateUIStart.jsp">Update Customer</a></li>
	<li><a href="CustomerDeleteUIStart.jsp">Delete Customer</a></li>


   </ul>

<li><a href="sample-admin.jsp">Connection Details</a>
   <ul>
   <li><a href='ConnectionControllerD?id=issuebegin&option=issuebegin'>Issue connection</a></li>
   <li><a href="ConnectionTariffUIStart.jsp">Add Tariff</a></li>
<li><a href='ConnectionControllerD?id=viewbyidadmin&option=viewbyidadmin'>View By ConnectionNumber</a></li>
<li><a href='ConnectionControllerD?id=viewalladmin&option=viewalladmin'>View All Connection</a></li>
<li><a href='ConnectionControllerD?id=viewalltariff&option=tariffview'>View Tariff </a></li>
<li><a href="ConnectionUpdateByAdminUIStart.jsp">Update Connection</a></li>
<li><a href="ConnectionDeleteByAdminUIStart.jsp">Delete Connection</a></li>
   </ul> 



<li><a href="sample-admin.jsp">Call Details </a>
   <ul>
   <li><a href="uploadcall.jsp">Upload CallDetails</a></li>
  <li><a href='CallDetailsControllerD?id=viewalladmin&checkpage=viewall'>View CallDetails</a></li>


<li><a href='CallDetailsControllerD?id=update&checkpage=viewall2'>Update CallDetails</a></li>
<li><a href='CallDetailsControllerD?id=delete&checkpage=viewall3'>Delete CallDetails</a></li>

   </ul>     
  

 </div>
 
        </table>
        </td>
<td height="410" bgcolor="#FFFFFF" width="530" valign="top" >
        <table border="0" bgcolor="#89CFF0"cellspacing="0" width="410" cellpadding="0" height="1" style="border-left-width: 0; border-bottom-width: 0; border-collapse:collapse" bordercolor="#111111">
          <tr>
            <td width="2%" height="8" bordercolor="#FFFFFF" style="border-left-style: solid; border-left-width: 1"></td>
            <td width="98%" height="8"></td>
            
          </tr>
          <tr>
            <td width="2%" height="26" bordercolor="#FFFFFF" style="border-left-style: solid; border-left-width: 1">&nbsp;</td>
            <td width="95%" height="26" valign="middle" bgcolor="#D3EDF1" align="center">
            <font color="#0000FF">&nbsp;</font><font color="#3399FF" face="Myriad Web"> </font>
            <font color="#800000" face="Arial" ><b>
            Update Call Details</b></font></td>
            <td width="3%" height="26">&nbsp;</td>
          </tr>
          <tr>
            <td width="2%" height="20" bordercolor="#FFFFFF" >&nbsp;</td>
            <td width="99%" height="20" valign="top">&nbsp;</td>
            
          </tr>
          <tr>
            <td width="2%" height="154" bordercolor="#FFFFFF" >&nbsp;</td>
            <td width="98%" height="154" valign="bottom" bgcolor="#F4F4F4" bordercolor="#C0C0C0">
            <table border="0" cellpadding="0" cellspacing="0" width="100%" style="border-collapse: collapse" bordercolor="#111111" height="221">
              


              <tr>
                
                <td width="100%" height="197" valign="top">
                
                <table width="550" height="404" bgcolor="#D3EDF1">
                <tr valign="middle">
               

                <td align="center"> 


<div id="content">
      
      <h3>Update Call Details</h3>
	

<table>
<tr>
<td>
<form method="post" action="CallDetailsControllerD">
<input type="hidden" name="checkpage" value="viewall2"></input>

<input type="submit" class="button" value="Update" onclick="UpdateCl.jsp"></input>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</form></td><td>
<form action="sample-admin.jsp">
<input type="submit" class="button" value="Cancel" ></input>

</form>
</td>
</tr>
</table>
</div>



       
        </td>

                
               </tr>

 
           
            </table>
          
            </td>
            
          </tr>

          <tr >
            <td bgcolor="#89CFF0" width="2%" height="30" bordercolor="#FFFFFF" ></td>
            <td bgcolor="#89CFF0" width="95%" height="30"></td>
            <td bgcolor="#89CFF0" width="3%" height="30"></td>
          </tr>
          
        </table>
        
        <tr  >
            <td width="2%" height="26" >&nbsp;</td>
            <td width="95%" height="26" >
            <p align="center"><font color="#003366" size="1" face="Arial"><b>
            Copyright@2012, Bharat Tele Services Ltd.</b><br>
            </font><font size="1" color="#003366" face="Arial">All rights 
            reserved. For suggestions or any difficulties on this site please 
            contact</font><font size="1" face="Verdana" color="#003366"><a style="text-decoration: underline; font-family: Arial; color: #0000ff" href="home.html">
            </a> </font>
            <font size="1" face="Verdana">
            <a style="text-decoration: none; font-weight: 700" href="#">webmaster</a></font><br>
            <font color="#003366" size="1" face="Arial"><br>
            </font><font face="Verdana" color="#003366" size="1">
            </font></td>
            <td width="3%" height="26">&nbsp;</td>
          </tr>
        </td>
      </tr>
    </table>
    </td>
  </tr>
</table>

</body>

</html>