package com.jayshree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class CallableDemo {

	public static void main(String[] args)  throws Exception
	{
        
		
		Connection con = MyConnection.getConnection();
		
		CallableStatement cs = con.prepareCall("{ call updateSal(?,?) }");
		
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter  id : ");
		
		int eid = Integer.parseInt(br.readLine());
		cs.setInt(1,eid);	
		
		System.out.println("Enter salary : ");
		
		int sal = Integer.parseInt(br.readLine());
	
		cs.setInt(2,sal);
		
		cs.execute();
		
		int cnt=cs.getUpdateCount();
		System.out.println("Updated Count is "+cnt);
		
		cs.close();
		
		con.close();
		
	}

}
	