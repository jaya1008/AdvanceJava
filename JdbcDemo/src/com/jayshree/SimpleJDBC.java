package com.jayshree;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleJDBC {

	public static void main(String[] args) 
	{
		Connection con = null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try
		{
			//step-1
			Class.forName("com.mysql.jdbc.Driver");
			
			//step-2
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jayshreedb", 
					"root", "root");
			
			System.out.println("Connection established "+con);
			
			//step3
			stmt = con.createStatement();  //empty container
			
			//step
			rs = stmt.executeQuery("select * from employee");
			
		/*	while(rs.next())
			{
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getInt(3)+"\t");
				System.out.println();
			}*/
			
			ResultSetMetaData rsmt=rs.getMetaData();
			
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("driver not loaded");
		}
		catch(SQLException e)
		{
			System.out.println("Connection rejected");
		}
		finally
		{
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

}
