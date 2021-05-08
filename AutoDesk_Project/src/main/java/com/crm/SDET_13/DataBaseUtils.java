package com.crm.SDET_13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtils {
	/*
	@Test
	public void getExecuteQuery() throws SQLException {
		//step1:Register the database 
		
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		//step2:establish connection with the database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "root");
		
		//step3: issue create statement
		
		Statement stat = con.createStatement();
				
		//step4: execute any query
		
		ResultSet result = stat.executeQuery("select* from Customer");
		
		while(result.next()) {
			System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+
		                        result.getString(3)+"\t"+result.getString(4)+"\t"+result.getInt(5)+"\t"
					            +result.getString(6));	
		}
		
		
		//step5: close database connection
		
		con.close();
	}
*/
	@Test
	public void getExecuteUpdate() throws SQLException {
		//step1:Register the database 
		Connection con=null;
		try {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		//step2:establish connection with the database
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "root");
		
		//step3: issue create statement
		
		Statement stat = con.createStatement();
				
		//step4: execute any query
		
		 int result = stat.executeUpdate("insert into customer values ('danish', 'danish lipssi', 'hingor', 'hingor 256', '89782', 'hong kong');");
		
		 if(result==1) {
			 System.out.println("project is successfully created");
		 }else {
			 System.out.println("project creation failed");
		 }
		}catch (Exception e) {
			e.printStackTrace();
		}
		//step5: close database connection
		finally {
		con.close();
		System.out.println("connection got closed ");
		}
	}
}
