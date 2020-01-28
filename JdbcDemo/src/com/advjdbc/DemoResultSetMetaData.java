package com.advjdbc;

import java.sql.*;

import com.jayshree.MyConnection;

class DemoResultSetMetaData
{
	public static void main(String[] args) 
	{
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try
		{
			
			con = MyConnection.getConnectionByFile();
			System.out.println("Connected...");
			
			st = con.createStatement();

			String sql = "select * from employee";
			rs = st.executeQuery(sql);
		
			System.out.println("-------------ResultMetaData=-----------------");
			
			ResultSetMetaData rsmd = rs.getMetaData();
			
			System.out.println("\nNo. of columns : " + rsmd.getColumnCount());
			
			for(int i=1; i<=rsmd.getColumnCount(); i++)
			{
				System.out.print("\nColumns name : " + rsmd.getColumnName(i) );
				System.out.println(" SQL Data type : " + rsmd.getColumnTypeName(i));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
