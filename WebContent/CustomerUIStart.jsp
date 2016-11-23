<%@ page language="java" 
    pageEncoding="ISO-8859-1"%>

<html>

<head>
<link rel="stylesheet" type="text/css" href="teleservices.css"/>

<script type="text/javascript" src="customerValidate.js">
</script>
<script type="text/javascript" src="helpemp.js">
</script>

<script>



var checkobj

function agreesubmit(el){
checkobj=el
if (document.all||document.getElementById){
for (i=0;i<checkobj.form.length;i++){  //hunt down submit button
var tempobj=checkobj.form.elements[i]
if(tempobj.type.toLowerCase()=="submit")
tempobj.disabled=!checkobj.checked
}
}
}

function defaultagree(el){
if (!document.all&&!document.getElementById){
if (window.checkobj&&checkobj.checked)
return true
else{
alert("Please read/accept terms to submit form")
return false
}
}
}

</script>


<script type="text/javascript" src="http://www.2createawebsites.com/resources/multi-level-menu-html.js">

</script>
<script type="text/javascript">
window.history.forward(1);
window.history.forward(-1);
</script>
</head>

<body topmargin="0" background="bg.gif" leftmargin="0" style="text-align: left; word-spacing: 0; line-height: 100%; margin-top: 0; margin-bottom: 0" onload="dynAnimation()">


    <table align="center" border="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111" width="700" height="192" cellpadding="0">
    
    <tr>
    <td width="100%" height="44" bgcolor="#FFFFFF">

    <div align="center">
    <center>
    
    <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111" width="100%" bgcolor="#FFFFFF">
    
    <tr>
    <td width="8%" style="border-left-style: solid; border-left-width: 1; border-right-style: none; border-right-width: medium; border-top-style: solid; border-top-width: 1">
    <img border="0" src="logo.jpg" width="57" height="48"></td>
   
    <td width="92%" style="border-left-style: none; border-left-width: medium; border-right-style: solid; border-right-width: 1; border-top-style: solid; border-top-width: 1"><b><font face="Tahoma" size="5">
      Bharat Tele Services</font><font face="Tahoma" size="2" color="#3399FF">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
      INTERNATIONAL CELLULAR MOBILE SERVICES</font></b></td>
    </tr>
    </table>
    
    </center>
    </div>
    </td>
    </tr>


    <tr>
    <td width="100%" height="33" bgcolor="#3399FF" style="border-left-style: solid; border-left-width: 1; border-right-style: solid; border-right-width: 1" valign="middle">
    <p align="right"><b><font face="Arial" color="#FFFFFF">
    <span style="letter-spacing: 2">Value Added Services </span>
    <span style="letter-spacing: 1">&nbsp; </span></font></b></td>
    </tr>
   
    <tr>
    <td width="100%" height="25" style="font-family: Tahoma; color: #FFFFFF" bgcolor="#000000">
    <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111" width="100%">
    <tr>
    <td width="2%" bordercolor="#FFFFFF" valign="middle" style="border-left-style: none; border-left-width: medium">&nbsp;</td>
    <td width="74%" valign="middle">
    <font color="#FFFF00" size="2" face="Arial">
    <font onmouseover="this.style.color='white'" onmouseout="this.style.color='#FFFF00'">
    <a href="home.html" style="text-decoration: none"><font color="#FFFF00">
      Home</font></a>&nbsp;&nbsp; |&nbsp;&nbsp; </font>
     <a href="home.html" style="text-decoration: none">
     <font color="#FFFF00" onmouseover="this.style.color='white'" onmouseout="this.style.color='#FFFF00'">Corporate&nbsp;</font></a>&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
     <a style="text-decoration: none; " href="home.html">
     <font color="#FFFF00" onmouseover="this.style.color='white'" onmouseout="this.style.color='#FFFF00'">
       Postpaid</font></a>&nbsp;&nbsp;&nbsp; |&nbsp;&nbsp;&nbsp; 
     <a href="home.html" style="text-decoration: none">
     <font color="#FFFF00" onmouseover="this.style.color='white'" onmouseout="this.style.color='#FFFF00'">
       Prepaid&nbsp;</font></a>&nbsp;&nbsp; |&nbsp;&nbsp;&nbsp; 
     <font color="#FFFF00" onmouseover="this.style.color='white'" onmouseout="this.style.color='#FFFF00'">
     <a style="text-decoration: none" href="home.html">
     <font color="#FFFF00" onmouseover="this.style.color='white'" onmouseout="this.style.color='#FFFF00'">Tariff</font></a>&nbsp; |&nbsp;&nbsp;
     <a style="text-decoration: none" href="home.html">
     <font color="#FFFF00" onmouseover="this.style.color='white'" onmouseout="this.style.color='#FFFF00'">Help Desk</font></a></font></td>
     <td width="100%" valign="middle" style="border-right-style: solid; border-right-width: 1">
     <p align="right">
     <font face="Arial" size="2" color="#FFFF00">
     <a style="text-decoration: none" href="home.html"> 
     <font color="#FFFF00" onmouseover="this.style.color='white'" onmouseout="this.style.color='#FFFF00'">
       FAQ</font></a><a href="home.html" style="text-decoration: none"><font color="#FFFF00" onmouseover="this.style.color='white'" onmouseout="this.style.color='#FFFF00'" face="Arial" size="2">&nbsp;</font></a>
     </td>
     </tr>
     </table>
     </td>
     </tr>
     <tr>
     <td width="100%" height="421" valign="top">
     <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111" width="703" height="345">
     <tr>
     <td width="672" height="1" bgcolor="#CCFFCC" style="border-left-style: solid; border-left-width: 1; border-bottom-style:solid; border-bottom-width:1; border-right-style:solid; border-right-width:1" colspan="3" bordercolor="#99CCFF" valign="top">
     <p align="center">&nbsp;<font face="Arial" size="2"><marquee scrolldelay=10 scrollamount="2">Bharat Tele Services is introducing new <b>Location Based Services</b> </marquee></font></td>
     </tr>
     <tr>
     <td width="180" height="14" bgcolor="#FFFFFF" style="border-left-style: solid; border-left-width: 1">&nbsp;
     </td>
     <td width="388" height="14" bgcolor="#FFFFFF">&nbsp;
     </td>
     </tr>
     <tr>
     <td width="180" height="330" bgcolor="#FFFFFF" valign="top" style="border-left-style: solid; border-left-width: 1; border-bottom-style: solid; border-bottom-width: 1">
     <table border="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" width="107%" height="334">
     <tr>
     <td width="5%" height="5"></td>
     <td width="89%" height="5"></td>
     <td width="17%" height="5"></td>
     </tr>
     <tr>
     <td width="5%" height="142">&nbsp;</td>
     <td width="89%" height="142" valign="top">
     
            </td>
            <div class="createawebsitediv">
  <ul id="createawebsite1">

   <li><a href="">Customer Registration</a>
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



<li><a href="">Call Details</a>
   <ul>
   <li><a href="uploadcall.jsp">Upload CallDetails</a></li>
  <li><a href='CallDetailsControllerD?id=viewalladmin&checkpage=viewall'>View CallDetails</a></li>


<li><a href='CallDetailsControllerD?id=update&checkpage=viewall2'>Update CallDetails</a></li>
<li><a href='CallDetailsControllerD?id=delete&checkpage=viewall3'>Delete CallDetails</a></li>

   </ul>   
  
   



<li><a href="">Bill Payment</a>
   <ul>
   <li><a href="">  </a></li>
<li><a href="">  </a></li>
<li><a href="">  </a></li>
<li><a href="">  </a></li>

   </ul>   







<li><a href="">Bill Generation</a>
   <ul>
   <li><a href="">  </a></li>
<li><a href="">  </a></li>
<li><a href="">  </a></li>
<li><a href="">  </a></li>

   </ul>   






<li><a href="">Bill Payment</a>
   <ul>
   <li><a href="">  </a></li>
<li><a href="">  </a></li>
<li><a href="">  </a></li>
<li><a href="">  </a></li>

   </ul>   







<li><a href="">Bill Dispute</a>
   <ul>
   <li><a href="">  </a></li>
<li><a href="">  </a></li>
<li><a href="">  </a></li>
<li><a href="">  </a></li>

   </ul>   



<li><a href="">Add HelpDesk Employee</a>
   <ul>
   <li><a href="">  </a></li>
<li><a href="">  </a></li>
<li><a href="">  </a></li>
<li><a href="">  </a></li>

   </ul>   









 </div>
 
            <td width="17%" height="15"></td>
          </tr>
          <tr>
            <td width="5%" height="15"></td>
            <td width="89%" height="15"></td>
            <td width="17%" height="15"></td>
          </tr>
          <tr>
            <td width="5%" height="15"></td>
            <td width="17%" height="15"></td>
          </tr>
          <tr>
            <td width="5%" height="15"></td>
            <td width="89%" height="15">
            </td>
            <td width="17%" height="15"></td>
          </tr>
          <tr>
            <td width="5%" height="15"></td>
            <td width="89%" height="15"></td>
            <td width="17%" height="15"></td>
          </tr>
          <tr>
            <td width="5%" height="15"></td>
            <td width="89%" height="15"></td>
            <td width="17%" height="15"></td>
          </tr>
          <tr>
            <td width="5%" height="15"></td>
            <td width="89%" height="15"></td>
            <td width="17%" height="15"></td>
          </tr>
        </table>
        </td>
<td height="330" bgcolor="#FFFFFF" width="550" style="border-bottom-style: solid; border-bottom-width: 1" valign="top">
        <table border="0" cellspacing="0" width="101%" cellpadding="0" height="1" style="border-left-width: 0; border-bottom-width: 0; border-collapse:collapse" bordercolor="#111111">
          <tr>
            <td width="2%" height="8" bordercolor="#FFFFFF" style="border-left-style: solid; border-left-width: "1"></td>
            <td width="98%" height="8"></td>
            
          </tr>
          <tr>
            <td width="2%" height="26" bordercolor="#FFFFFF" style="border-left-style: solid; border-left-width:" 1">&nbsp;</td>
            <td width="95%" height="26" valign="middle" bgcolor="#D3EDF1">
            <font color="#0000FF">&nbsp;</font><font color="#3399FF" face="Myriad Web"> </font>
            <font color="#800000" face="Arial">
            <b>Welcome Admin</b></font></td>
            <td width="3%" height="26">&nbsp;</td>
          </tr>
          <tr>
            <td width="2%" height="20" bordercolor="#FFFFFF" style="border-left-style: solid; border-left-width: 1">&nbsp;</td>
            <td width="99%" height="20" valign="top">&nbsp;</td>
            
          </tr>
          <tr>
            <td width="2%" height="154" bordercolor="#FFFFFF" style="border-left-style: solid; border-left-width: 1">&nbsp;</td>
            <td width="98%" height="154" valign="bottom" bgcolor="#F4F4F4" bordercolor="#C0C0C0">
            <table border="0" cellpadding="0" cellspacing="0" width="100%" style="border-collapse: collapse" bordercolor="#111111" height="221">
              <tr>
                <td width="4%" height="15"></td>
                <td width="93%" height="15"></td>
                <td width="3%" height="15"></td>
              </tr>


              <tr>
                <td width="4%" height="197">&nbsp;</td>
                <td width="96%" height="197" valign="top">













<form name="regform" action="CustomerController" method="post" onSubmit="return defaultagree(this)">


<br/>
<center>
<table>




<tr>
<td>Customer Name<font color="red">*</font>:</td><td><input type="text" name="custname" /></td>
</tr>

<tr><td>Address<font color="red">*</font>:  </td><td><textarea name="address" rows="5" cols="30"></textarea></td></tr>

<tr>
<td>Date of Birth<font color="red">*</font>:<br/>(dd/mm/yyyy)</td><td><input type="text" name="dob" /></td>
</tr>   


<tr><td>Gender<font color="red">*</font>:  </td><td><input type="radio" name="sex" value="male" />Male
<input type="radio" name="sex" value="female"/>Female</td></tr>

<tr>
<td>Contact Number<font color="red">*</font>:</td><td><input type="text"name="contact" /></td>
</tr>   

 

<tr>
<td>Email Id<font color="red">*</font>:</td><td><input type="text" name="email" /></td>
</tr>   


<tr><td>Id Proof<font color="red">*</font>:  </td><td><select name="idproof">
<option value=" ">--</option>
<option value="Passport">Passport</option>
<option value="Pan Card">Pan Card</option>
<option value="VoterId">Voter Id</option></td></tr>

<tr><td>
<input name="agreecheck" type="checkbox" onClick="agreesubmit(this)"><b>I agree to the above terms</b><br>
<input type="Submit" value="Submit!" disabled Onclick=" return master()">&nbsp;&nbsp;&nbsp;<input type="reset" value="Reset">

</td>


  </tr>         
</table>


</center>
<br/>

<center> <b>Note: All Fields marked <font color="red">*</font> are Mandatory</b></center>

</form>




<script>
//change two names below to your form's names
document.forms.regform.agreecheck.checked=false
</script>

<br/>
<br/>
<br/>
<br/>





                </td>

                <td width="3%" height="197">&nbsp;</td>
               </tr>

 
           
            </table>
          
            </td>
            
          </tr>

          <tr>
            <td width="2%" height="18" bordercolor="#FFFFFF" style="border-left-style: solid; border-left-width: 1; border-bottom-style:none; border-bottom-width:medium"></td>
            <td width="95%" height="18"></td>
            <td width="3%" height="18"></td>
          </tr>
          <tr>
            <td width="2%" height="26" bordercolor="#99CCFF" style="border-style:none; border-width:medium; ">&nbsp;</td>
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
        </table>
        </td>
      </tr>
    </table>
    </td>
  </tr>
</table>

</body>

</html>