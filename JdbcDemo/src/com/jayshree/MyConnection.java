package com.jayshree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MyConnection {
	
	public static Connection getConnection()
	{
		//step-1
		Connection con=null;
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		
		//step-2
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jayshreedb", 
				"root", "root");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
		
	}
    public static Connection getConnectionUsingDriver()
    {
    	Connection con=null;
    	try
		{
    		//step 1
		    Driver d=  (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
		
			//step-2
			
		    Properties p=new Properties();
		    p.put("user", "root");
		    p.put("password", "root");
		    con=d.connect("jdbc:mysql://localhost:3306/jayshreedb",p);
	
		 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
    }
    public static Connection getConnectionByFile()
    {
    	Connection con=null;
    	try {
			FileInputStream fin=new FileInputStream(".//src//mydatabase.properties");
			Properties p=new Properties();
			p.load(fin);
			String d= p.getProperty("driver");
			String url=p.getProperty("url");
			String u=p.getProperty("user");
			String pass=p.getProperty("password");
			
			Class.forName(d);
			
			//step-2
			 con = DriverManager.getConnection(url, u,pass);
				
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return con;
    }
    
}
