package com.tcs.DAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.tcs.constants.QueryConstants;
import com.tcs.model.ConnectionIssue;
import com.tcs.model.Tariff;
import com.tcs.util.DBUtil;





import java.sql.*;

public class BTSSDAO {

	ArrayList <ConnectionIssue> connectionList =new ArrayList <ConnectionIssue>();
	ArrayList <Tariff> tariffList =new ArrayList <Tariff>();
	
	
	
	public ArrayList<Tariff> issueBegin() {
		// TODO Auto-generated method stub
	
		try
		{
			
			
				Connection con=DBUtil.getConnection();
				Statement st=con.createStatement();
						
				String query="select tcode from tariffd";
				System.out.println("I am came here");		
			    ResultSet rs=st.executeQuery(query);
				while(rs.next())
				{
				Tariff t=new Tariff();
				t.setTcode(rs.getString(1));
				tariffList.add(t);		
				}
		for(Tariff t:tariffList)
		{
			System.out.println(t.getTcode());
					}
				
				return tariffList;
		
		
			
			
		}
		finally
		{
			return tariffList;
		}
		
}
	
	
	
	
	
	public StringBuffer createConnectionIssue(int cid,String btype,String bplan)
	{
	
		StringBuffer msg=new StringBuffer();
		
		try{
			Connection con=DBUtil.getConnection();
			Statement st=con.createStatement();
			String query="select customerid from customerd where customerid="+cid;
			int tempcid=0;
			String empname=null;
			ResultSet rs=st.executeQuery(query);
			while(rs.next())
			{
			tempcid=rs.getInt(1);	
			}
			System.out.println(tempcid);
			
			
			//if customer not exsists go back no more connection
			if(tempcid == 0)
			{
			msg.append("This Customer Id is unavailable.<br></br>Please enter a valid Customer Id");
			return msg;	
			}
			
			
			//if customer has three connection go back no more connection
			String x="active";
			String query11="select count(*) from connectiond where customerid="+cid+" and status='"+x+"'";
			int tempcid11=0;
			String empname11=null;
			ResultSet rs11=st.executeQuery(query11);
			while(rs11.next())
			{
			tempcid11=rs11.getInt(1);	
			}
			System.out.println("active connections "+tempcid11);
			
					
			if(tempcid11 >= 3)
			{
			msg.append("Customer can have maximum of three connection");
			return msg;	
			}
							
			String query2="select max(connectionnumber) from connectiond";
			long tempcid2=0;
			ResultSet rs2=st.executeQuery(query2);
			while(rs2.next())
			{
			tempcid2=rs2.getLong(1);	
			}
			
			System.out.println(tempcid2);
			if(tempcid2==0)
			{
				tempcid2=9000000000L;
			}
			else
				{
			tempcid2++;
				}
				System.out.println("Hello"+bplan);
			String query3="insert into connectiond values("+cid+","+tempcid2+",'"+btype+"','"+bplan+"','active')";
			st.executeUpdate(query3);
			msg.append("Connection issued successfully for Customer Id : "+cid+"<br></br>Connection number is:"+tempcid2+"");					
			}
	     catch(Exception e)
		{
			
		}
			finally
			{
				DBUtil.closeConnection();
				return msg;
			}

			
	}
	
	
	
	
	public ArrayList<ConnectionIssue> viewSingleConnection(long connNo) {
		// TODO Auto-generated method stub
	
		try
		{
			
						
				Connection con=DBUtil.getConnection();
				Statement st=con.createStatement();
				
				String query="select * from connectiond where connectionnumber="+connNo;
				int tempcusid=0;
				long tempconnNo=0;
				String tempbilltype=null;
				String temptcode=null;
				String tempstatus=null;
								
				ResultSet rs=st.executeQuery(query);
			
				while(rs.next())
				{
					ConnectionIssue c=new ConnectionIssue();
				c.setCustomerId(rs.getInt(1));
				c.setConnectionNumber(rs.getLong(2));
				c.setBillType(rs.getString(3));
			     c.settCode(rs.getString(4));
				c.setStatus(rs.getString(5));
					connectionList.add(c);		
				}
				
				
				for(ConnectionIssue c:connectionList)
				{
					System.out.println(c.getCustomerId());
					//System.out.println(c.getConnectionNumber());
					
				}
						
			
				
				return connectionList;
				
		}
		finally
		{
			return connectionList;
		}
	}
	
	
	public ArrayList<ConnectionIssue> viewAllConnection() {
		// TODO Auto-generated method stub
	
		try
		{									
				Connection con=DBUtil.getConnection();
				Statement st=con.createStatement();
				String query="select * from connectiond where status='active'order by customerid";
				int tempcusid=0;
				long tempconnNo=0;
				String tempbilltype=null;
				String temptcode=null;
				String tempstatus=null;
						
				ResultSet rs=st.executeQuery(query);
				while(rs.next())
				{
				ConnectionIssue c=new ConnectionIssue();
				c.setCustomerId(rs.getInt(1));
				c.setConnectionNumber(rs.getLong(2));
				c.setBillType(rs.getString(3));
			    c.settCode(rs.getString(4));
				c.setStatus(rs.getString(5));
				connectionList.add(c);		
				}
										
				
				//System.out.println("Any way I am here;");
				
				return connectionList;
				
		}
		finally
		{
			return connectionList;
		}
	}
	
	public ArrayList<ConnectionIssue> updateConnectionIssue(long connNo) {
		// TODO Auto-generated method stub
	
		try
		{
			
			
				
				Connection con=DBUtil.getConnection();
				Statement st=con.createStatement();
												
				String query="select * from connectiond where connectionnumber="+connNo;
				int tempcusid=0;
				long tempconnNo=0;
				String tempbilltype=null;
				String temptcode=null;
				String tempstatus=null;
					
				ResultSet rs=st.executeQuery(query);
			
				while(rs.next())
				{
				ConnectionIssue c=new ConnectionIssue();
				c.setCustomerId(rs.getInt(1));
				c.setConnectionNumber(rs.getLong(2));
			 	c.setBillType(rs.getString(3));
			    c.settCode(rs.getString(4));
				c.setStatus(rs.getString(5));
				connectionList.add(c);		
				}
				
				
				for(ConnectionIssue c:connectionList)
				{
					System.out.println(c.getCustomerId());
					//System.out.println(c.getConnectionNumber());
					
				}
				
				
				System.out.println("Any way I am here;");
				
				return connectionList;
				
		}
		finally
		{
			return connectionList;
		}
		
}
	
	public StringBuffer updateFinalConnectionIssue(long connNo, String btype, String bplan) {
		// TODO Auto-generated method stub
		StringBuffer msg=new StringBuffer();
		try{
		Connection con=DBUtil.getConnection();
		Statement st=con.createStatement();	
		String query3="update connectiond set billtype='"+btype+"',tcode='"+bplan+"'where connectionnumber="+connNo;
		st.executeUpdate(query3);				
		msg.append("updatesuccess");
		System.out.println("i am displaying "+btype+"  "+bplan+" "+connNo);
		return msg;
		}		
		
	catch(Exception e)
	{
		
	}
		finally
		{
			return msg;
		}
	}
	
		public ArrayList<ConnectionIssue> deleteConnectionIssue(long connNo) {
		// TODO Auto-generated method stub
		
		try
		{
								
				Connection con=DBUtil.getConnection();
				Statement st=con.createStatement();					
				String query="select * from connectiond where connectionnumber="+connNo;
				int tempcusid=0;
				long tempconnNo=0;
				String tempbilltype=null;
				String temptcode=null;
				String tempstatus=null;
							
				ResultSet rs=st.executeQuery(query);
				while(rs.next())
				{
				ConnectionIssue c=new ConnectionIssue();
				c.setCustomerId(rs.getInt(1));
				c.setConnectionNumber(rs.getLong(2));
				c.setBillType(rs.getString(3));
			    c.settCode(rs.getString(4));
				c.setStatus(rs.getString(5));
				connectionList.add(c);		
				}
							
				for(ConnectionIssue c:connectionList)
				{
					System.out.println(c.getCustomerId());
					//System.out.println(c.getConnectionNumber());
					
				}
									
				return connectionList;
				
		}
		finally
		{
			return connectionList;
		}
		
}
	
	public StringBuffer deleteFinalConnectionIssue(long connNo,String r) {
		// TODO Auto-generated method stub
		StringBuffer msg=new StringBuffer();
		try{
		Connection con=DBUtil.getConnection();
		Statement st=con.createStatement();	
		System.out.println("I am came for delete 12312");
		String stat="cancelled";
		String query3="update connectiond set status='"+stat+"' where connectionnumber="+connNo;
		st.executeUpdate(query3);
		String query13="insert into cancelreason values('"+connNo+"','"+r+"')";
		st.executeUpdate(query13);
		msg.append("deletesuccess");
		return msg;
		
		}		
			

	catch(Exception e)
	{
		
	}
		finally
		{
			return msg;
		}
	}

	
	
	public ArrayList<ConnectionIssue> viewCustomerAllConnection(int cusid) {
		
	
		try
		{									
				Connection con=DBUtil.getConnection();
				Statement st=con.createStatement();
				String query="select * from connectiond where customerid="+cusid;
				int tempcusid=0;
				long tempconnNo=0;
				String tempbilltype=null;
				String temptcode=null;
				String tempstatus=null;
						
				ResultSet rs=st.executeQuery(query);
				while(rs.next())
				{
				ConnectionIssue c=new ConnectionIssue();
				c.setCustomerId(rs.getInt(1));
				c.setConnectionNumber(rs.getLong(2));
				c.setBillType(rs.getString(3));
			    c.settCode(rs.getString(4));
				c.setStatus(rs.getString(5));
				connectionList.add(c);		
				}
										
				
				//System.out.println("Any way I am here;");
				
				return connectionList;
				
		}
		finally
		{
			return connectionList;
		}
	}
	
	
	
	
	public StringBuffer createTariff(String tcode1,double monthlyRental,double local,double std,double isd)
	{
	
		StringBuffer msg=new StringBuffer();
		
		try{
			
			Connection con=DBUtil.getConnection();
			Statement st=con.createStatement();
			
			
			
			String query2="select max(tno) from tariffd";
		    int tempcid2=0;
			ResultSet rs2=st.executeQuery(query2);
			while(rs2.next())
			{
			tempcid2=rs2.getInt(1);	
			}
			
			System.out.println(tempcid2);
			if(tempcid2==0)
			{
				tempcid2=1;
			}
			else
				{
			tempcid2++;
				}
			
			
									
			String temptcode=tcode1;
			String check=null;
			
			
			String query21="select tcode from tariffd";
		    
			ResultSet rs21=st.executeQuery(query21);
			while(rs21.next())
			{
			check=rs21.getString(1);	
			if(check.equalsIgnoreCase(temptcode))
			{
				msg.append("Tariff plan <font color=red> "+temptcode+" </font> already exists <br>Please add a new plan with different name");
				return msg;
			}
			}
			
			
			
			
			
			
			
			
			
			
			msg.append("Tariff Not inserted");
					
			
			System.out.println("I am here for tariff");
			System.out.println(monthlyRental);
			System.out.println(local);
			System.out.println(std);
			System.out.println(isd);
			String query3="insert into tariffd values('"+temptcode+"',"+monthlyRental+","+local+","+std+","+isd+","+tempcid2+")";
			st.executeUpdate(query3);
			msg=new StringBuffer();
			
			msg.append("The new Tariff plan is inserted successfully  <br> Tariff code is : "+tempcid2+" <br> Tariff plan is : "+temptcode+" ");	
			
			
			
			
			return msg;
			}
	     catch(Exception e)
		{
			
		}
			finally
			{
				DBUtil.closeConnection();
				return msg;
			}

			
	}
	public ArrayList<Tariff> viewAllTariff() {
		
		String msg=null;
		try
		{									
				Connection con=DBUtil.getConnection();
				Statement st=con.createStatement();
				String query="select * from tariffd";
				
						
				ResultSet rs=st.executeQuery(query);
				while(rs.next())
				{
					Tariff t=new Tariff();
					t.setTcode(rs.getString(1));
					t.setMonthlyRental(rs.getDouble(2));
					t.setLocal(rs.getDouble(3));
					t.setStd(rs.getDouble(4));
					t.setIsd(rs.getDouble(5));
					tariffList.add(t);
				}
										
				
				//System.out.println("Any way I am here;");
				
				return tariffList;
		}
		finally
		{
			return  tariffList;
		}
	
	}
	
	
	
	
}
	