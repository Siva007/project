<%@ page language="java" 
    pageEncoding="ISO-8859-1"%>

<html>

<head>
<meta http-equiv="Page-Enter" 
content="RevealTrans(Duration=1.0,Transition=12)" />

<meta http-equiv="Page-Exit" 
content="RevealTrans(Duration=1.0,Transition=12)" />

<title>Change Password </title>

<link rel="stylesheet" type="text/css" href="teleservices.css"/>

<script type="text/javascript" >


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
	        alert("The New password should not contain any special characters");
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
	        alert("The Confirm password should not contain any special characters");
	        return false;
	      }
		

	
	else if((nep!=op))
	{
		
		alert("New password and confirm password does not match");
		return false;
	}
	else
	{
		alert("Password changed successfully.Please login again");
		return true;
	}
	}
</script>
<script type="text/javascript" src="http://www.2createawebsites.com/resources/multi-level-menu-html.js">
window.history.forward(1);
window.history.forward(-1);
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
     <table bgcolor="#89CFF0" border="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" width="100%" height="514">
     
     
     
<div class="createawebsitediv">
  <ul id="createawebsite1">


<%
String customerid=(String) session.getAttribute("SessionUser"); 
 %>
   <li><a href='CustomerController?customerId=<%=customerid %>&operation=viewSingleCustmoerDetails' >My Profile </a>
   </li>

   
   
   <li><a  href='ConnectionControllerD?id=<%=customerid %>&option=myconnectionview'>My Connection Details</a></li>
   
   
   
  

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
            Welcome <%out.println(session.getAttribute("SessionUserName")); %></b></font></td>
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

<table width="550" height="475" bgcolor="#D3EDF1">
<tr valign="middle">
<td align="center">

<form name="changepwd"  method="post" action="Login2Controller" >
 <input type="hidden" name="operation" value="changepwd"/>
<input type="hidden" name="custid" value=<%out.println(request.getAttribute("id")); %>/>


<h3><font color="blue">Change Password</font></h3><br></br>
Enter Old Password <input type="password" name="oldp" /><br></br>
Enter New Password <input type="password" name="newp" /><br></br>
Confirm New Password <input type="password" name="confirmp" /><br></br>

<input type="submit"  value="Submit" Onclick=" return check()" />

 </form>
 
 
</td>
</tr>
</table>

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
        
        <tr  style="border-left-style: solid; border-left-width: 1 " bordercolor="#FFFFFF">
            <td width="2%" height="26" bordercolor="#FFFFFF" style="border-left-style: solid; border-left-width: 1 ">&nbsp;</td>
            <td width="95%" height="26" style="border-left-style: none; border-left-width: medium">
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

 