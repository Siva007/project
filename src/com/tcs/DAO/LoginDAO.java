package com.tcs.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tcs.util.DBUtil;

public class LoginDAO {
	Connection con;
	
public LoginDAO()
{
	
}

public ArrayList<String> checkCredentials(String lid,String pid)
{
Connection con=null;
con=DBUtil.getConnection();
ArrayList<String> a=new ArrayList<String>();
try{
	
	Statement st=con.createStatement();
	System.out.println("login enters");
	System.out.println(lid);
	System.out.println(pid);
String queryadmin="select adminid,adminpwd from admind where adminid='"+lid+"' and adminpwd='"+pid+"'";
ResultSet rs=st.executeQuery(queryadmin);
String logtemp=null;
String logid=null;
String name=null;
int pws=0;
String status=null;
while (rs.next())
{
logtemp=rs.getString(1);
logid=rs.getString(2);
if((logtemp.compareTo(lid)==0)&&(logid.compareTo(pid)==0))
{
	System.out.println("admin matches");
status="1";
System.out.println("status"+status);
a.add(status);
a.add("Admin");
System.out.println(a.get(0));
return a;

}

}

String query="Select customerid,password,pwdstatus,customername from customerd where customerid='"+lid+"' and password='"+pid+"'";
ResultSet rs1=st.executeQuery(query);
while(rs1.next())
{
	logtemp=rs1.getString(1);
	logid=rs1.getString(2);
	pws=rs1.getInt(3);
	name=rs1.getString(4);
	if((logtemp.compareTo(lid)==0)&&(logid.compareTo(pid)==0)&&(pws==0))
	{
		System.out.println("customer matches");
		status="2";
		a.add(status);
		a.add(name);
		return a;
		
	}
	else if((logtemp.compareTo(lid)==0)&&(logid.compareTo(pid)==0)&&(pws==1))
	{
		System.out.println("customer matches");
		status="3";
		a.add(status);
		a.add(name);
		return a;
		
	}
}

}
catch(Exception e)
{
	System.out.println("error");
}
a.add("0");
a.add("error");

return a;
}



//for new password

public int checkLogin(String olp,String nwp,String conp,String id)throws Exception
{
Connection con=null;
con=DBUtil.getConnection();
try{
	Statement st=con.createStatement();
	String querylog="Select customerid,password,pwdstatus from customerd where customerid='"+id+"' and password='"+olp+"'";
	ResultSet rs=st.executeQuery(querylog);
	String pwd=null;
	String logid=null;
	int pws=0;
	int status=0;
	
		while(rs.next())
		{
			logid=rs.getString(1);
			pwd=rs.getString(2);
			pws=rs.getInt(3);
		}
	
	
	if((logid.compareTo(id)==0)&&(pwd.compareTo(olp)==0)&&(pws==0))
	{
		System.out.println("customer matches");
		status=1;
		
		PreparedStatement pre = con.prepareStatement("Update CustomerD set password=?,pwdstatus=? where customerid="+id);
		
		System.out.println("updating");
		 
		    pre.setString(1,nwp);
		    pre.setInt(2,1);
		    int i=pre.executeUpdate();
			 
		return status;
		
	}
	else if((logid.compareTo(id)==0)&&(pwd.compareTo(olp)==0)&&(pws==1))
	{
		System.out.println("customer matches");
		status=2;
		return status;
	}
	
	
	return status;
}
finally
{
	DBUtil.closeConnection();
}
}

}
