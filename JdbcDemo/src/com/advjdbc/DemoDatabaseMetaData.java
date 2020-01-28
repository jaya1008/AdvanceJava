package com.advjdbc;

import java.sql.*;

import com.jayshree.MyConnection;

class DemoDatabaseMetaData
{
	public static void main(String[] args) 
	{
		Connection con = null;
		ResultSet rs = null;

		try
		{
			
			con = MyConnection.getConnection();
			System.out.println("Connected...");					
			System.out.println("-------------DatabaseMetaData=-----------------");
			
			DatabaseMetaData dbmd = con.getMetaData();
			
			System.out.println("\nDatabase product name : " + dbmd.getDatabaseProductName());
			System.out.println("\nDatabase product version : " + dbmd.getDatabaseProductVersion());
			System.out.println("\nDriver name : " + dbmd.getDriverName());
			System.out.println("\nDriver version : " + dbmd.getDriverVersion());
			System.out.println("\nUSer name : " + dbmd.getUserName());
			System.out.println("\nkeywords "+dbmd.getSQLKeywords());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
