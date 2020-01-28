package com.jayshree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class PreparedDemo {

	public static void main(String[] args) throws Exception 
	{
	
		
		Connection con = MyConnection.getConnection();

		PreparedStatement ps = con.prepareStatement("update employee set Salary = ? where Empid = ? ");
		
		//Statement stmt = con.createStatement();
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter emp id : ");
		
		int eid = Integer.parseInt(br.readLine());
		
		System.out.println("Enter new salary : ");
		
		float sal = Float.parseFloat(br.readLine());
		
		ps.setFloat(1, sal);
		
		ps.setInt(2, eid);
		
		int n = ps.executeUpdate();
		
		System.out.println(n + " records updated");
		
		ps.close();
		
		con.close();
		
			
	}

}
