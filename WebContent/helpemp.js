
function checkall()
{




var cid=document.ConnectionUI.value;
var letters = /^[0-9]+$/; 
if(!eid.match(letters))
{
alert("Employee id should be a number");
document.addemployee.empid.value="";
return false;
}










var ename=document.addemployee.empname.value;
var letters = /^[A-Za-z]+$/;  

 if(!ename.match(letters))  
{
alert("Employee name should be an Alphabet");
document.addemployee.empname.value="";
return false;
}

else if(ename.length > 20)
{
alert("Employee name cannot be greater than 20 characters");
document.addemployee.empname.value="";
return false;
}




























       var dminyear = 1900;
        var dmaxyear = 2200;
        var chsep= "/"

        function checkinteger(str1){
        var x;
        
        for (x = 0; x < str1.length; x++){ 
        // verify current character is number or not !
        var cr = str1.charAt(x);



        if (((cr < "0") || (cr > "9"))) 
        return false;
        }
        return true;
        }


        function getcharacters(s, chsep1){
        var x;
        var Stringreturn = "";
        for (x = 0; x < s.length; x++){ 
        var cr = s.charAt(x);
        if (chsep.indexOf(cr) == -1) 
        Stringreturn += cr;
        }
        return Stringreturn;
        }
        function februarycheck(cyear)
        {
        return (((cyear % 4 == 0) && ( (!(cyear % 100 == 0)) || (cyear % 400 == 0))) ? 29 : 28 );
        }



        function finaldays(nr) {
        for (var x = 1; x <= nr; x++) {
        this[x] = 31
        if (x==4 || x==6 || x==9 || x==11)
        {
        this[x] = 30}
        if (x==2)
        {
        this[x] = 29}
        } 
        return this
        } 





        function dtvalid(strdate)
        {
        var monthdays = finaldays(12)
        var cpos1=strdate.indexOf(chsep)
        var cpos2=strdate.indexOf(chsep,cpos1+1)
        var daystr=strdate.substring(0,cpos1)
        var monthstr=strdate.substring(cpos1+1,cpos2)
        var yearstr=strdate.substring(cpos2+1)

        strYr=yearstr
        if (strdate.charAt(0)=="0" && strdate.length>1) strdate=strdate.substring(1)
        if (monthstr.charAt(0)=="0" && monthstr.length>1) monthstr=monthstr.substring(1)
        for (var i = 1; i <= 3; i++) {
        if (strYr.charAt(0)=="0" && strYr.length>1) strYr=strYr.substring(1)
        }
        // The parseInt is used to get a numeric value from a string
        pmonth=parseInt(monthstr)
        pday=parseInt(daystr)
        pyear=parseInt(strYr)
        if (cpos1==-1 || cpos2==-1){
        alert("The date format must be : dd/mm/yyyy");
document.addemployee.mydate.value="";
        return false;
        }
        if (monthstr.length<1 || pmonth<1 || pmonth>12){
        alert("Input a valid month")
document.addemployee.mydate.value="";
        return false;
        }
        if (daystr.length<1 || pday<1 || pday>31 || (pmonth==2 && pday>februarycheck(pyear))         || pday > monthdays[pmonth]){
        alert("Input a valid day")
document.addemployee.mydate.value="";
        return false;
        }
        if (yearstr.length != 4 || pyear==0 || pyear<dminyear || pyear>dmaxyear){
        alert("Input a valid 4 digit year between "+dminyear+" and "+dmaxyear)
document.addemployee.mydate.value="";
        return false;
        }
        if (strdate.indexOf(chsep,cpos2+1)!=-1 || checkinteger(getcharacters(strdate, chsep))==false){
        alert("Input a valid date")
document.addemployee.mydate.value="";
        return false;
        }
        return true;
        }


        

        
        
         var crdt=document.addemployee.mydate.value;
         if (dtvalid(crdt)==false)
        {
        document.addemployee.mydate.value="";
return false;
        }
        

var tmpdate=crdt;
var dd=tmpdate.substring(0,2);
var mm=tmpdate.substring(3,5);
var yyyy=tmpdate.substring(6,10);
var tmpdate=mm+'/'+dd+'/'+yyyy;


var now=new Date();


if( Date.parse(tmpdate) > now)
{
alert("Should not Greater than todays date");
document.addemployee.mydate.value="";
return false;

}




























var d1=document.addemployee.des.value;

 if(!d1.match(letters))  
{
alert("Desgination should be an Alphabet");
document.addemployee.des.value="";
document.addemployee.des.focus();
return false;
}






var c1=document.addemployee.contact.value;
if(isNaN(c1)== true)
{
alert("Contact should be a number");
document.addemployee.contact.value="";
document.addemployee.contact.focus();
return false;
}


else if(c1==0)
{
alert("Contact  number should not bo zero.");
document.addemployee.contact.value="";
document.addemployee.contact.focus();
return false;
}


else if(c1.length != 10)
{
alert("Contact  should  have 10 digits.");
document.addemployee.contact.value="";
document.addemployee.contact.focus();
return false;
}













var x=document.addemployee.emailid.value;

 if(! (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(x)) ) 
   {  
      alert("Not a valid e-mail address");
     document.addemployee.emailid.value="";
   return false;
   } 











else if( (eid==null || eid=="") ||  (ename==null || ename=="")  ||  (crdt==null || crdt=="") ||  (d1==null || d1=="") ||  (c1==null || c1=="") ||  (d1==null || d1=="") ||  (x==null || x==""))
  {
  alert("Entry Incomplete please fill all details");
  return false;
  }

else
{
alert("Sucessfully registered");
return true;
}


}









     















