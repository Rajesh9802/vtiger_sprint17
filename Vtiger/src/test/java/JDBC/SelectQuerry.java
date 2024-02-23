package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class SelectQuerry {

	public static void main(String[] args) throws SQLException {
		//SQL instance
		Driver dataBaseDriver = new Driver();  //class of mySql
		//JDB(Java Data Base) Register with my SQL
		DriverManager.registerDriver(dataBaseDriver);   //class of java
		//Connection Establish
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vtiger5", "root", "root"); //database connection established
        //Quarry Pass
		ResultSet result = connection.createStatement().executeQuery("select * from lead;");
        //Result
		String sno = " ";
		String leadName = " ";
		String leadCompanyName =" ";
        while(result.next()) {
        	sno= sno+" "+result.getString("SNo");
        	leadName= leadName+" "+result.getString("leadName");
        	leadCompanyName=leadCompanyName+" "+ result.getString("leadCompany");

        }
        System.out.println(sno);
        System.out.println(leadName);
        System.out.println(leadCompanyName);


        connection.close();
	}

}
