package com.jayshree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;



public class CallableDemo1 {

	public static void main(String[] args) throws Exception
	{
			
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root","");
		
		CallableStatement cs = con.prepareCall("{ call getDept(?) }");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter emp id : ");
		
		int eid = Integer.parseInt(br.readLine());
		
		cs.setInt(1, eid);

		cs.registerOutParameter(1, Types.INTEGER);
		
		cs.executeQuery();
		
		System.out.println("Dept no : "+cs.getInt(1));
	
		cs.close();
		
		con.close();
		
	}

}
