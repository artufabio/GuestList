package com.qa.guestlist;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Queries {
	

//	Add a Guest to the guests table
	public void create(Guest g) {
		String createStmt = "INSERT INTO guests(name, age, job_title, special_notes) "
				+ "VALUES('" + g.getName() + "'," + g.getAge() + ",'"
				+ g.getJobTitle() + "','"+ g.getSpecialNotes() +"');";
		try {
			DbConnection.stmt.executeUpdate(createStmt);
			System.out.println("Guest added to your list");
		} catch (SQLException e) {
			System.out.println("Bad query");
		}
	}

//	Reset the guests table
	public void deleteAll() {
		String createStmt = "truncate guests;";
		try {
			DbConnection.stmt.executeUpdate(createStmt);
		} catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
		}
	}

//	Remove a guest from the list based on the id selected by the user
	public void deleteById(int id) {
		String read = "DELETE FROM guests WHERE id = " + id + ";";
		try {
			DbConnection.stmt.executeUpdate(read);
		} catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
		}
	}

//	Display all the guests
	public void readAll() {
		String read = "SELECT * FROM guests;";
		ResultSet rs;
		try {
			rs = DbConnection.stmt.executeQuery(read);
			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("id") + ", name: " + rs.getString("name") + ", age: "
						+ rs.getString("age") + ", job title: " + rs.getString("job_title") + ", special notes: " + rs.getString("special_notes") + ".");
			}

		} catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
		}
	}

//	Display a guest selected by the id
	public void readById(int id) {
		String read = "SELECT id, name, age, job_title, special_notes FROM guests WHERE id = " + id + ";";
		ResultSet rs;
		try {
			rs = DbConnection.stmt.executeQuery(read);
			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("id") + ", name: " + rs.getString("name") + ", age: "
						+ rs.getString("age") + ", job title: " + rs.getString("job_title") + ", special notes: " + rs.getString("special_notes") + ".");
			}
		} catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
		}
	}

//	Update a guest details selected by the user
	public void updateById(int id) {
		try {
			System.out.println("What's their new name?");
			MyScanner.sc.nextLine();
			String name = MyScanner.sc.nextLine();
			
			System.out.println("What's their new age?");
			int age = MyScanner.sc.nextInt();
			
			System.out.println("What's their new job title?");
			MyScanner.sc.nextLine();
			String jobT = MyScanner.sc.nextLine();
			
			System.out.println("What's their new special notes?");
			String sNotes = MyScanner.sc.nextLine();

			String read = "UPDATE guests SET name = '" + name + "', age = " + age + ", job_title = '" + jobT
					+ "', special_notes = '" + sNotes + "' WHERE id = " + id + ";";

			DbConnection.stmt.executeUpdate(read);
		} catch (Exception e) {
			System.out.println("Sorry...Something went wrong. Please try again.");
			MyScanner.sc.nextLine();
		}
	}

//	Display number of guests inside the list
	public void countGuests() {
		String read = "SELECT count(name) from guests;";
		ResultSet rs;
		try {
			rs = DbConnection.stmt.executeQuery(read);
			while (rs.next()) {
				int num = rs.getInt("count(name)");
				if (num > 0) {
					System.out.println("Guests in your list: " + num);
				} else {
					System.out.println("There are no guests in your list.");
				}
			}
		} catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
		}
	}

}
