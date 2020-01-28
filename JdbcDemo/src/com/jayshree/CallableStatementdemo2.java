package com.jayshree;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallableStatementdemo2 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
//GetAllEmployees()
		
		Connection conn=MyConnection.getConnection();
		CallableStatement cs=conn.prepareCall("{ call GetAllEmployees()}");
		cs.execute();
		ResultSet rs=cs.getResultSet();
		while(rs.next())
		{
			System.out.print(rs.getInt(1)+"\t");
			System.out.print(rs.getString(2)+"\t");
			System.out.print(rs.getInt(3)+"\t");
			System.out.println();
		}
		
	}

}
