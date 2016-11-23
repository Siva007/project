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

<title>Call Details Delete</title>


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
			otherTextBox2.style.visibility = 'visible';                                                                       
			  otherTextBox.style.visibility='hidden';
                        otherTextBox.style.display='none';
        }
        function hideTextBox2(){
        	document.getElementById("rad").checked=false;
			var obj=document.getElementById('otherTextBox2');
			 otherTextBox2.style.display = 'block';
			 otherTextBox2.style.visibility = 'hidden';                                                                
			          otherTextBox.style.visibility='hidden';
             otherTextBox.style.display='none';
            }
		
		
		
    </script>
    
    <script type="text/javascript">
    function openpage()
    {
  	  var radioObj = document.butval.radio;     

  		for(var i=0; i<radioObj.length; i++) 
  		     {         
  			if( radioObj[i].checked ) 
  			    {             
  			  return true;    
  		        }
  		     }  
		     alert("please select a record to delete details"); 
  		   return false; 
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
     <td bgcolor="#89CFF0" width="100%" height="1" valign="top">
     <table width="100%" height="1" bgcolor="#89CFF0" border="0" cellpadding="0" cellspacing="0" >
     <tr>
     <td width="100%" height="1" bgcolor="#CCFFCC"  colspan="3"  valign="top">
     <p align="center">&nbsp;<font face="Arial" size="2"><marquee scrolldelay=10 scrollamount="2">Bharat Tele Services is introducing new <b>Location Based Services</b> </marquee></font></td>
     </tr>
     
     </table>
     
     
     <table width="700" height="450" bgcolor="#89CFF0" style="border-bottom-style: solid; border-bottom-width: 1 ;border-right-style: solid; border-right-width: 1 ;border-left-style: solid; border-left-width: 1 " bordercolor="#111111" >
     <tr>
     <td width="180" height="404" bgcolor="#89CFF0" valign="top"  bordercolor="#89CFF0">
     <table bgcolor="#89CFF0" cellpadding="2"  height="200" bordercolor="#89CFF0">
     <tr valign="top">
     
     <td>
     
   
            
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
 </td></tr>
        </table>
        </td>
<td height="410" bgcolor="#89CFF0" width="530" valign="top" bordercolor="#89CFF0">
        <table border="0" bgcolor="#89CFF0"cellspacing="0" width="410" cellpadding="0" height="1" >
          <tr>
            <td width="2%" height="8" bordercolor="#89CFF0" ></td>
            <td width="98%" height="8"></td>
            
          </tr>
          <tr>
            <td width="2%" height="26" bordercolor="#FFFFFF" >&nbsp;</td>
            <td width="95%" height="26" valign="middle" bgcolor="#D3EDF1" align="center">
            <font color="#0000FF">&nbsp;</font><font color="#3399FF" face="Myriad Web"> </font>
            <font color="#800000" face="Arial" ><b>
            Delete Call Details</b></font></td>
            <td width="3%" height="26">&nbsp;</td>
          </tr>
          <tr>
            <td width="2%" height="20" bordercolor="#FFFFFF" >&nbsp;</td>
            <td width="99%" height="20" valign="top">&nbsp;</td>
            
          </tr>
          <tr>
            <td width="2%" height="154" bordercolor="#FFFFFF" >&nbsp;</td>
            <td width="98%" height="154" valign="bottom" bgcolor="#F4F4F4" bordercolor="#C0C0C0">
            <table border="0" cellpadding="0" cellspacing="0" width="100%" height="221">
              


              <tr>
                
                <td width="100%" height="197" valign="top">
                
                
                
           <table width="550" height="404" bgcolor="#D3EDF1">
           <tr valign="middle">
           
           <td align="center">
                 
    <div id="content">
      <br>
<center><h3>Delete Call Details</h3><br>
 <table  align="center" border="0">
<tr><td>
  <center> <input name="radio"  type="radio" id="rad" onclick="displayTextBox2()"/><label for="choice2"><font color="#03AFF7"> Delete By Call ID </font></label></center>
        
  </td>
 </tr>
 <tr> 
<td height="65"><center>
                <div id="otherTextBox2" style="display:none;visibility:hidden;">
		
               <form id="2" name="form4" action="CallDetailsControllerD" method="post" onsubmit="return validate()">
                <input type="hidden" name="checkpage" value="id2"/></INPUT>
                <br><font color="#03AFF7">Enter Call ID  </font><input type="text" name="ID">
                <INPUT TYPE="submit" value="Delete"  class="button" onclick="return confirm('do you really want to delete the call details?')"></INPUT>&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="reset" value="Cancel"  class="button" onclick='return hideTextBox2()'/>
                </form>
               
                </div></center> 
                </td>
                </tr>
                <tr><td>
                <%String msg = request.getParameter("msg");if(msg != null){
                    %><font color="red"> <%=msg %></font><%}%> 
               </td> </tr>
                </table>
               
                <br>
                


                <form name="butval" method="post" action="CallDetailsControllerD">
<input type="hidden" name="checkpage" value="viewall1">

<%
	if(request!=null){
		String msg1 = request.getParameter("msg1");
	ArrayList<CallDetails> clist=new ArrayList<CallDetails>();
	clist=(ArrayList<CallDetails>)request.getAttribute("viewall");
   if(clist!=null){
%><div style="height:210px;width:550px;border:1px solid #ccc;overflow:scroll;">
   <table border=1 width="450"  align="center">
     <tr valign="middle" bgcolor="skyblue">
  
<td> Customer&nbsp;ID</td>
<td> Connection&nbsp;NO</td>
<td> Call&nbsp;ID&nbsp;</td>
<td width="170" align="center">Date Of Call<br>(YYYY&nbsp;-&nbsp;MM&nbsp;-&nbsp;DD&nbsp;)</td>
</tr>

<%for(int i=0;i<clist.size();i++){%>


<a href='CallDetailsControllerD?callId=<%=clist.get(i).getCallid()%>&checkpage=Delete'>
<tr ONMOUSEOVER="this.style.backgroundColor='skyblue'" ONMOUSEOUT="this.style.backgroundColor='#D3EDF1'" title="click call Id to delete the details" >
<td><%=clist.get(i).getCustid()%></td>
<td><%=clist.get(i).getConno()%></td>
<td><%=clist.get(i).getCallid()%></td>
<td align="center"><%=clist.get(i).getDoc()%></td>

</tr> 
<%
 	}
 %>
<tr></tr></table>
</div>
<table>
<tr><td>


</td></tr>
<tr>
<td>
<%
	} else {
		%>
		<%if(msg1!= null){
                    %><font color="red"> <%=msg1 %></font><%}%><br>
                    
   	<input type="reset" class="button" value="Cancel" onclick="sample-admin.jsp"/>
		<%
			}
   %>
   
   <%} %>
 </td></tr>  
 </table>
</form>

</center>
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
        
        <tr>
            <td width="2%" height="26" bordercolor="#FFFFFF" >&nbsp;</td>
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
</table>

</body>

</html>