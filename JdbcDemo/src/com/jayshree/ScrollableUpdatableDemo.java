package com.jayshree;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ScrollableUpdatableDemo 
{

	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "");

		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
		ResultSet rs = stmt.executeQuery("select * from emp"); //scrollable and updatable result set
		
		rs.afterLast();
		
		while(rs.previous())
		{
			System.out.print("Empid : "+rs.getInt(1)+"\t");
			System.out.print("name : "+rs.getString(2)+"\t");
			System.out.print("salary : "+rs.getFloat(3)+"\t");
			System.out.println();
		}
		
		System.out.println("************");
		rs.absolute(3);
		System.out.println("Empid : "+rs.getInt(1));
				
		//rs.relative(-1)
		
		rs.updateFloat(3,88888.00f);
		rs.updateRow();
		
		System.out.println("row updated"); 
		
		
		
		
		
		
		
		
	}

}
