package banking.obs.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class UpdateData {

	public static void main(String[] args) throws SQLException {
		//step=1  create instance for driver---register driver
				Driver dbDriver=new Driver();
				DriverManager.registerDriver(dbDriver);
				
				
				//step-2 get connection with geturl
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet46", "root", "root");
				
				
				//step-3  create statement
				Statement statement = connection.createStatement();
				
				
				//step-4  execute query
				int result = statement.executeUpdate(" insert into employee values(103,'archit',80000,78007456,'Newyork');");
				
				if(result==1)
					System.out.println("Row inserted");
					connection.close();
				
				
				

			
				
				
				
				
				

			}

	}


