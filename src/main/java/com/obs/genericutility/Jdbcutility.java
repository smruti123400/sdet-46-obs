package com.obs.genericutility;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.xdevapi.Statement;

import okhttp3.Connection;
/**
 * 
 * @author achar
 *
 */
public class Jdbcutility {
	Driver dbDriver=null;
	java.sql.Statement statement;
	ResultSet result;
	
	/**
	 * This constructor will register driver and create statement for jdbc operations
	 */
	public Jdbcutility() {
		registerDriverAndCreateStatement();
	}
	/**
	 * This method will register the driver and will initialize the statement object
	 */
	public void registerDriverAndCreateStatement() {
		try {
			dbDriver = new Driver();
			DriverManager.registerDriver(dbDriver);
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet46","root","root");
			statement = con.createStatement();

		} catch (SQLException e) {
		
			e.printStackTrace();
		}

	}
	/**
	 * This generic method fetch the String data and integer data  using query 
	 * @param query
	 * @param strColumn
	 * @param intColumn
	 */
	public void getData(String query,Set<String>strColumn,Set<String>intColumn) {
		try {
			result = statement.executeQuery(query);
			while(result.next()) {
				for(String key:strColumn) {
					System.out.print(result.getString(key)+"  ");
				}
				for(String key:intColumn) {
					System.out.println(result.getInt(key));
				}
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * This generic method will delete the record
	 * @param query
	 */
	public void deleteData(String query) {
		try {
			int result = statement.executeUpdate(query);
			if(result==1) {
				System.out.println("row deleted");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}
	/**
	 * This generic method will update the record 
	 * @param query
	 */
	public void updateData(String query) {
		int result;
		try {
			result = statement.executeUpdate(query);
			if(result==1)
				System.out.println("Row updated");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	/**
	 * This method will close the coonection
	 */
	public void closeDatabase() {
		try {
			ResultSet con = null;
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

