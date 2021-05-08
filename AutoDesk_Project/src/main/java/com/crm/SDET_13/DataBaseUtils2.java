package com.crm.SDET_13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtils2 {
	Connection con = null;

	@Test
	public void getExecuteQuery() throws SQLException {
		// step1:Register the database
		try {
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);

			// step2:establish connection with the database
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "root");

			// step3: issue create statement

			Statement stat = con.createStatement();

			// step4: execute any query

			ResultSet result = stat.executeQuery("select* from Customer");

			String expected = "Rohith";
			while (result.next()) {
				String actualRes = result.getString(1);
				System.out.println(actualRes);

				// verification

				if (actualRes.equalsIgnoreCase(expected)) {
					System.out.println("PASS::The expected and actual is same");
				} else {
					System.out.println("FAIL::The expected and actual is not same");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// step5: close database connection
		finally {
			con.close();
			System.out.println("Database closed");
		}
	}
}
