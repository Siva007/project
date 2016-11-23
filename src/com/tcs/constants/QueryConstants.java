package com.tcs.constants;

public class QueryConstants 
{
	public static String insertcl="insert into CALLD values(?,?,?,?,?,?,?)";
	public static String updatecl="update CALLD set DURATION=?,CALLTYPE=?,DIALNO=? where CALLID=?";
	public static String deletecl="DELETE FROM CALLD WHERE CALLID=? and to_char(doc,'mm-dd-yyyy')<to_char(add_months(sysdate,-1),'mm-dd-yyyy')";
	public static String viewcl="SELECT * FROM CALLD order by to_char(doc,'yyyy-mm-dd'),callid,connectionnumber,custid";
	public static String viewcl1="select * from CALLD where CALLID=?";
	
}
