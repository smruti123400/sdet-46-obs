package banking.obs.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Datadrivenfromsql {

	public static void main(String[] args) throws SQLException {
		
		
	//step=1  create instance for driver---register driver
		Driver dbDriver=new Driver();
		DriverManager.registerDriver(dbDriver);
		
		
		//step-2 get connection with geturl
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet46", "root", "root");
		
		
		//step-3  create statement
		Statement statement = connection.createStatement();
		
		
		//step-4  execute query
		ResultSet result = statement.executeQuery("select * from employee;");
		
		
		//step-5  iterator the data
		while(result.next()) {
		 String empname = result.getString("emp_name");
		 System.out.println(empname);
		 
		 //step-6
		 
		}
		connection.close();
		
		
		

	}

}
