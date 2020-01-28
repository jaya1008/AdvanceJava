package com.jayshree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateDemo {

	public static void main(String[] args) throws NumberFormatException, IOException, SQLException {
		// TODO Auto-generated method stub

		Connection con = MyConnection.getConnection();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter  id : ");		
		int eid = Integer.parseInt(br.readLine());
		
		
		System.out.println("Enter amount to be updated : ");		
		int sal = Integer.parseInt(br.readLine());
		Statement st=con.createStatement();
		
		String sql="update employee set sal=sal+"+sal+" where id="+eid;
		
		System.out.println(sql);
		int i=st.executeUpdate(sql);
		System.out.println("No of rec updated are "+i);
		
		
		
	}

}
