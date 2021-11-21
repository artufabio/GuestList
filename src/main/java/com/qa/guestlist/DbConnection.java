package com.qa.guestlist;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public static final String URL = "jdbc:mysql://localhost:3306/";
	private String USERNAME;
	private String PASSWORD;

	protected static Connection conn;

	protected static Statement stmt; // stores our queries

	public DbConnection() {
		try {
			System.out.println("Enter MySQL username: ");
			this.USERNAME = MyScanner.sc.next();
			System.out.println("Enter MySql password: ");
			this.PASSWORD = MyScanner.sc.next();
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.createStatement(); // creates a Statement object to execute sql queries
			System.out.println("Connected.");
		} catch (SQLException e) {
			System.out.println("Incorrect Credentials");
			e.printStackTrace();
		}
//		create initial database and table if they don't exist
		this.createInitialDataBase();
		this.createInitialTable();
	}

	public void close() {
		try {
			conn.close();
			System.out.println("Closing connection...");
		} catch (SQLException e) {
			System.out.println("Sorry, unable to close the connection.");
			e.printStackTrace();
		}
	}

//	create a new database if it doesn't exist. Connect to the database
	public void createInitialDataBase() {
		String createStmt = "CREATE DATABASE IF NOT EXISTS guest_list";
		String createStmt2 = "USE guest_list";
		try {
			stmt.executeUpdate(createStmt);
			stmt.executeUpdate(createStmt2);
		} catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
		}
	}

//	create a new table if it doesn't exists
	public void createInitialTable() {
		String createStmt = "CREATE TABLE IF NOT EXISTS guests(\r\n" 
				+ "	id int not null unique auto_increment,\r\n"
				+ "    name varchar(30) not null,\r\n" 
				+ "    age int not null,\r\n"
				+ "    job_title varchar(30) not null,\r\n" 
				+ "	   special_notes varchar(50), \r\n"
				+ "    primary key(id)\r\n" + ");";
		try {
			stmt.executeUpdate(createStmt);
		} catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
		}
	}

}
