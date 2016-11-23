package com.tcs.util;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
		private static final String DRIVER_NAME="oracle.jdbc.driver.OracleDriver";
		private static final String CONNECTION_STRING= "jdbc:oracle:thin:@intvmoradb01:1521:ORAJAVADB";
		private static final String USERNAME="PJ02DEV_T39";
		private static final String PASSWORD="tcstvm189";
		private static  Connection conn=null;
		
		public static Connection  getConnection()
		{
			try {
				Class.forName(DRIVER_NAME);
			} catch (ClassNotFoundException e1) {
				System.out.println("class not found");
				e1.printStackTrace();
			}
			conn=null;
			try {
				 conn=DriverManager.getConnection(CONNECTION_STRING, USERNAME,PASSWORD);
				 
			} catch (SQLException e) {
				System.out.println("connection not established...");
				e.printStackTrace();
			}
			return conn;
		}
		public static void closeConnection()
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
