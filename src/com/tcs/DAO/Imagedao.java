package com.tcs.DAO;

import java.sql.*;

import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.xml.ws.Response;

import com.tcs.util.DBUtil;
public class Imagedao
{
	public int insertImage(File image)
	{
		int s=0;
		Connection connection = null;


		//String connectionURL = "jdbc:mysql://intvmunix1:3306/u481624";


		ResultSet rs = null;
		PreparedStatement psmnt = null;
		FileInputStream fis;
		 try{
		//Class.forName("com.mysql.jdbc.Driver").newInstance();
			 connection=DBUtil.getConnection();
		//connection = DriverManager.getConnection(connectionURL, "PJ01DEV_T39", "tcstvm139");
		 Statement st=connection.createStatement();
		 rs=st.executeQuery("select count(*) from images");
		 rs.next();

		 s=rs.getInt(1);
		 
		 
		// image=new File("D:/Users/481624/Desktop/loop.jpg");
		
		 fis=  new FileInputStream(image);
		 psmnt = connection.prepareStatement("insert into images(imageid,image) "+ "values(?,?)");
		 psmnt.setInt(1,s+1);
		 psmnt.setBinaryStream(2,(InputStream)fis,(int)(image.length()));
		 
		  s = psmnt.executeUpdate();
		 if(s>0)
		 {
			 System.out.println("Uploaded successfully !");
		 }else 
		 {
			 System.out.println("unsucessfull ");
			 }
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
		return s;
	}
	
	
	public int updateImage(File image,int input)
	{

		int s=0;
		Connection connection = null;


		//String connectionURL = "jdbc:mysql://intvmunix1:3306/u481624";


		ResultSet rs = null;
		PreparedStatement psmnt = null;
		FileInputStream fis;
		 try{
		//Class.forName("com.mysql.jdbc.Driver").newInstance();
			 connection=DBUtil.getConnection();
		//connection = DriverManager.getConnection(connectionURL, "PJ01DEV_T39", "tcstvm139");
		 Statement st=connection.createStatement();
		 rs=st.executeQuery("select count(*) from images");
		 rs.next();

		 s=rs.getInt(1);
		 
		 
		// image=new File("D:/Users/481624/Desktop/loop.jpg");
		
		 fis=  new FileInputStream(image);
		// psmnt = connection.prepareStatement("insert into images(imgid,image) "+ "values(?,?)");
		 psmnt = connection.prepareStatement("update images set image=? where imageid=?");
		
		 psmnt.setBinaryStream(1,(InputStream)fis,(int)(image.length()));
		 psmnt.setInt(2,input);
		  s = psmnt.executeUpdate();
		 if(s>0)
		 {
			 System.out.println("Uploaded successfully !");
		 }else 
		 {
			 System.out.println("unsucessfull ");
			 }
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
		return s;
	
	}
	
	public BufferedImage getImage(int id) throws Exception
	{
		BufferedImage bf=null;
		byte b[]=null;
		Connection connection = DBUtil.getConnection();
		Statement stmt=connection.createStatement();
		ResultSet rs=stmt.executeQuery("select image from images where imageid="+id);
		System.out.println("select image from images where imageid="+id);
		if (rs.next()) {
		 
		
		InputStream x=rs.getBinaryStream(1);
		 
		 bf= ImageIO.read(x);
	
		
		
		
		
	}
		return bf;
	}
}
/*public static void main(String[] args) throws SQLException 
{
	int output=new demo().getCount();
	System.out.println("output is "+output);
}*/

