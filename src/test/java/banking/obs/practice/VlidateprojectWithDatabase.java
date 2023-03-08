package banking.obs.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class VlidateprojectWithDatabase {

	public static void main(String[] args) throws SQLException {
		Driver dbDriver= new Driver();
		DriverManager.registerDriver(dbDriver);
		Connection connection =DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		Statement statement = connection.createStatement();
		 int result = statement.executeUpdate(null);
		
	

	}

}
