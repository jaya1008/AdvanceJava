package com.advjdbc;
import java.sql.*;

import com.jayshree.MyConnection;
 
public class JdbcAutoGeneratedKeyExample {
	
	public static void main(String[] args) {
		
		JdbcAutoGeneratedKeyExample jdbcMysqlSelectExample = new JdbcAutoGeneratedKeyExample();
		Connection connection = MyConnection.getConnection();
		Statement statement = null;
		ResultSet rs = null;
		try {
			statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO trn_employee (EMP_NAME, EMP_SALARY) VALUES('Manish',19000)");
			rs = statement.getGeneratedKeys();
			if (rs.next()) {
				System.out.println("Auto Generated Primary Key " + rs.getInt(1));
			}
		} catch (SQLException e) {
			System.out.println("SQLException Occured..");
		} finally {
			try {
				if (rs != null) {
					rs.close(); // close result set
				}
				if (statement != null) {
					statement.close(); // close statement
				}
				if (connection != null) {
					connection.close(); // close connection
				}
			} catch (SQLException e) {
				System.out.println("SQLException Occured..");
			}
		}
	}
 
	
	
}