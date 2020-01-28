package com.jayshree;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoExecte {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Connection con=MyConnection.getConnection();
		Statement st=con.createStatement();
		
		String sql="select * from employee";
		
		boolean b=st.execute(sql);
		
		if(b)
		{
		   ResultSet rs=	st.getResultSet();
		   while(rs.next())
			{
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getInt(3)+"\t");
				System.out.print(rs.getInt(4)+"\t");
				System.out.println();
			}
			
		}
		else
		{
			System.out.println("DML Query");
		}
	}

}
