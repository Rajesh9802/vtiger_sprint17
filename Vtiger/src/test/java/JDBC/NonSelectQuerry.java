package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class NonSelectQuerry {

	public static void main(String[] args) throws SQLException {

		// SQL instance
		Driver dataBaseDriver = new Driver(); // class of mySql
		// JDB(Java Data Base) Register with my SQL
		DriverManager.registerDriver(dataBaseDriver); // class of java
		// Connection Establish
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vtiger5", "root", "root"); // database
																													// connection
																													// established
		// Quarry Pass
		int result = connection.createStatement().executeUpdate("insert into lead value(5, 'Sanjay', 'Infosys');");

		if (result == 1) {
			System.out.println("The Data base has been updated");
		} 
		else
			System.out.println("The data base has not been updated");
		
          connection.close();
	}

}
