package com.tcs.DAO;


import java.io.BufferedReader;

import com.tcs.model.CallDetails;
import com.tcs.util.DBUtil;

import com.tcs.constants.QueryConstants;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.StringTokenizer;


public class CallDAO  
{
	Connection con;
	public CallDAO(){
	}
	public String filecal(String filecsvn)
	{
		Connection con=null;
		String filecs=filecsvn;
		String x="1";
		
	
		try{
			 con = DBUtil.getConnection();
			 PreparedStatement pst = null;
			 BufferedReader data = new BufferedReader(new FileReader(filecs));
			 BufferedReader data1 = new BufferedReader(new FileReader(filecs));
			 BufferedReader data2 = new BufferedReader(new FileReader(filecs));
		String dtlstr="";
		String dtlstr1="";
		String dtlstr2="";
		StringTokenizer stdtl = null;
		StringTokenizer stdt2 = null;
		pst = con.prepareStatement(QueryConstants.insertcl);
		
		
		String[] monthName = {"Jan", "Feb","Mar", "Apr", "May", "Jun", "Jul","Aug", "Sep", "Oct", "Nov","Dec"};
		
		
		int lineCount = 0; 
		int j=0;
		String arr[];
		arr=new String[12];
		
		
		
		
		while((dtlstr2 = data2.readLine())!= null)
		{
		if((dtlstr2.trim().length() > 0))
		{ 
		stdt2=new StringTokenizer(dtlstr2,",");
		while(stdt2.hasMoreTokens())
		{
		arr[j]=stdt2.nextToken();
		j++;
		}
		j=0;
		}
		}
		
		
		
		
		
		
		
		
		while((dtlstr1 = data1.readLine()) != null) 
		{
					
			if (dtlstr1.trim().length() > 0)
			{
				++lineCount;

                int fd=Integer.parseInt(arr[3].substring(0,2));
                String fm=arr[3].substring(3,6);
                          
                int fy=Integer.parseInt(arr[3].substring(7,11));
				
                
                Calendar cal = Calendar.getInstance(); 
               
                
                int sd=cal.get(Calendar.DATE);
                String sm = monthName[cal.get(Calendar.MONTH)];
                int sy=cal.get(Calendar.YEAR);
                
                if(fy>sy)
                {
                	x="CallDetails of Future year: "+arr[3]+" cannot be uploaded  for callid "+arr[2];
                	               	               	
                	return x;
                }
                
                
                int len=monthName.length;
                
                int i,k;
                for(i=1;i<=len;i++)
                {
                	if(fm.equalsIgnoreCase(monthName[i]))
                	{
                		break;
                	}
                
                }
                
                for(k=1;k<=len;k++)
                {
                	if(sm.equalsIgnoreCase(monthName[k]))
                	{
                		break;
                	}
                
                }
                
                
                
                

                if(fy==sy)
                {
                	
                	if(i>k)
                	{
                		x="CallDetails of Current Year Furture month: "+arr[3]+" cannot be uploaded  callid "+arr[2];
            			return x;
                	}
                	
                }
                
                
                
                
                
                if(fy==sy)
                {
                if(fm.equalsIgnoreCase(sm))
                {
                	if(fd>sd)
                	{
                	x="CallDetails of Future Days: "+arr[3]+" cannot be uploaded  callid "+arr[2];
        			return x;
                	}
                	if(fd==sd)
                	{
                	x="CallDetails of Current Day: "+arr[3]+" cannot be uploaded  callid "+arr[2];
        			return x;
                	}
                              	
                }
                }
                
                
                
                
				
		 
			}
			
		}
		
		
		
		
		System.out.println(lineCount);
		
		
		if(lineCount==0)
		{
			x="Empty File cannot be uploaded";
			return x;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		lineCount++;
		while((dtlstr = data.readLine())!= null)
		{
			int i=1;
			
			if((dtlstr.trim().length() > 0))
			{ 
				stdtl=new StringTokenizer(dtlstr,",");
				while(stdtl.hasMoreTokens())
				{
					 dtlstr=stdtl.nextToken();
					 pst.setString(i++,dtlstr);
				}
				int rowsdtl=pst.executeUpdate();
				
				if(rowsdtl>0)
				{
					x="uploadSuccess";
				}
				else
				{
					
				}
						
            }
			
	
		}
		
	}
		
		catch(Exception e)
		{
			x="callId already exsists";
			System.out.println(e);
		}
		finally
		{
			DBUtil.closeConnection();
			return x;
	    }
 
		
		
		
		
  }
	

	public CallDetails viewCall(CallDetails ucd) {
		Connection con=null;
		//int id=ucd.getCallid();
		//String sql="select * from TELECALL where CALLID=?";
			try{
				con = DBUtil.getConnection();
				PreparedStatement st=con.prepareStatement(QueryConstants.viewcl1);
				st.setInt(1,ucd.getCallid());
				
				ResultSet rs=st.executeQuery();
				if(rs.next())
				{
					ucd.setCallid(rs.getInt("CALLID"));
					ucd.setDoc(rs.getDate("DOC"));
					ucd.setDuration(rs.getInt("DURATION"));
					ucd.setDialno(rs.getLong("DIALNO"));
					ucd.setCalltype(rs.getString("CALLTYPE"));
					System.out.println(rs.getString("CALLTYPE"));
					
							
				}
			}
				
				catch (Exception e)
				{
					System.out.println(e);
				}
				finally
				{
					DBUtil.closeConnection();
			    }
		return ucd;
	}
	
	public ArrayList<CallDetails> viewallCl() {
		Connection con=null;
		ArrayList<CallDetails> newlist=new ArrayList<CallDetails>();
		//String sql="SELECT * FROM TELECALL";
			try
		{
				con = DBUtil.getConnection();
				PreparedStatement st=con.prepareStatement(QueryConstants.viewcl);
				ResultSet rs=st.executeQuery();
				while(rs.next())
				{
					CallDetails cObj=new CallDetails();
					cObj.setCustid(rs.getLong(1));
					cObj.setConno(rs.getLong(2));
					cObj.setCallid(rs.getInt(3));
					cObj.setDoc(rs.getDate(4));
					cObj.setDuration(rs.getInt(5));
					cObj.setDialno(rs.getLong(6));
					cObj.setCalltype(rs.getString(7));
					
					newlist.add(cObj);
				}
				
		}
		catch (SQLException e) 
		{
					System.out.println(e);
		}
		
		finally
		{
			DBUtil.closeConnection();
	    }
		return newlist;
	}
	public void viewCall1(CallDetails ucd) {
		Connection con=null;
		
		
	
		
		//String sql="update TELECALL set DURATION=?,CALLTYPE=?,DIALNO=? where CALLID=?";
		try{
			con = DBUtil.getConnection();
			PreparedStatement st=con.prepareStatement(QueryConstants.updatecl);
			st.setInt(1, ucd.getDuration());
			st.setString(2, ucd.getCalltype());
			st.setLong(3, ucd.getDialno());
			st.setInt(4, ucd.getCallid());
			st.executeUpdate();
			
		}		
		catch (Exception e)
		{
			e.printStackTrace();
		}
	finally
	{
		DBUtil.closeConnection();
    }
	}
	
		
		
	public int deletefile(CallDetails ucd ){
		Connection con=null;
		//int id=ucd.getCallid();
		
		//String sql="DELETE FROM TELECALL WHERE CALLID=?";
		int del=0;
		try{
			con = DBUtil.getConnection();
			PreparedStatement st=con.prepareStatement(QueryConstants.deletecl);
			st.setInt(1,ucd.getCallid());
			System.out.println("the value of callid is:"+ucd.getCallid());
			int r=st.executeUpdate();
			System.out.println("the r value in DAO is"+r);
			if(r>0)
			{
			del=1;
			}
			System.out.println("deleted");
			//System.out.println("The Customer Call Details with CallID= are deleted from database");
			System.out.println("the value to be returned from dao is"+del);
			return del;
		}
         

			
		catch (Exception e)
			{
				e.printStackTrace();
			}
		finally
		{
			DBUtil.closeConnection();
        }
		return del;
	}	
	public boolean checkcl(int Callid){
		PreparedStatement pst = null;
		ResultSet rs= null;
		boolean isvalid= false;
		try{
			Connection con = DBUtil.getConnection();
			String query = "Select CALLID from calld";
			pst = con.prepareStatement(query);
			rs = pst.executeQuery();
			
			while(rs.next()){
			if(rs.getInt("CALLID")==Callid){
				isvalid= true;
			}
				
			}
				
			pst.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return isvalid;
	}

}

