package com.advjdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.jayshree.MyConnection;

public class ScrollableDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try
		{
		
			con = MyConnection.getConnection();
			System.out.println("Connected...");

			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
				                   ResultSet.CONCUR_UPDATABLE);
			
			String sql = "select m.* from Employee m ";
		//	String sql="select * from Employee";
			rs = st.executeQuery(sql);
			System.out.println("All record are");
			while(rs.next())
			{
				System.out.println(rs.getInt(1));
				
			}
			rs.absolute(2);
			rs.updateInt(1, 100);
			rs.updateString(2, "Deepa");
			rs.updateInt(3, 20);
			rs.updateInt(4, 7800);
			rs.updateRow();

			System.out.println("The Updated Row is.....");
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3)+ " "+rs.getInt(4));
			
		
			
			rs.moveToInsertRow();
			rs.updateInt(1, 101);
			rs.updateString(2, "pqr");
			rs.updateInt(3, 10);
			rs.updateInt(4, 10000);
			rs.insertRow();
			
			rs.absolute(3);
			rs.deleteRow();
			/*
			 * Scrolling
			 * rs = st.executeQuery(sql);
			
			rs.last();
			System.out.println("The Last Record is......");
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3)+" "+rs.getInt(4));
			
			rs.first();
			System.out.println("The first Record is......");
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
			
			
			rs.absolute(3);
			System.out.println("Absolute(3) rec");
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));

			rs.relative(1);
			System.out.println("relative(1) rec");
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));

			rs.relative(-1);
			System.out.println("relative(-1) rec");
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));

			*/
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
