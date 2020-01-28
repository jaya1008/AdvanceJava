package com.advjdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jayshree.MyConnection;

import java.sql.ResultSet;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class Demo
{
	public static void main(String[] args) throws Exception, IOException, SQLException 
	{
		Connection conn=MyConnection.getConnection();
		
		FileInputStream fis = null;
		PreparedStatement ps = null;
		
		try 
		{
			conn.setAutoCommit(false);
			
			File file = new File("E:\\AllJavaData\\butterfly.jpg");
			fis = new FileInputStream(file);
			
			ps = conn.prepareStatement("insert into imagestore values (?, ?)");
			
			ps.setInt(1, 100);
		
			ps.setBinaryStream(2, fis, (int) file.length());
		
			ps.executeUpdate();
			conn.commit();

			System.out.println("Stored the image");

			System.out.println("--------------------");

			String sql = "SELECT  * from imagestore where imgid=100";
			
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet resultSet = stmt.executeQuery();
			
			resultSet.next(); 
			
				int id = resultSet.getInt(1);
				
								
				File image = new File("E:\\GetMyImage.gif");
				FileOutputStream fos = new FileOutputStream(image);

				byte[] buffer = new byte[100];
				
				InputStream is = resultSet.getBinaryStream(2);
				
				while (is.read(buffer) > 0) 
				{
					fos.write(buffer);
				}

				System.out.println("Retrieved the image");
		}
		catch(Exception e){
			e.printStackTrace();
		}
  }
}
