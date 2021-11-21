package com.qa.guestlist;


public class UserActions {

	Queries q = new Queries();
	String name;
	int id;
	CreateGuest cg = new CreateGuest();
	
//	Method that uses a while loop to dynamically create a Person instances and add them to people database 
	public void createListGuests() {
		System.out.println("Would you like to add a new guest to your list? Type \"yes\" or \"no\"");
		String answer = MyScanner.sc.next().toLowerCase();
		
		// Create a person instances and add them to people database
		while (answer.equals("yes")) {

			Guest g = cg.createGuestIstance();
			if (g != null) {
				q.create(g);
			}
			
			q.countGuests();

			System.out.println("Would you like to add another guest? Type \"yes\" or \"no\"");
			answer = MyScanner.sc.next().toLowerCase();
		}
	}
	
	
//	CRUD operations inside a while loop in order to make changes to data saved on guests table
	public void updateListGuests() {
		System.out.println("Would you like to make any change to your list? Type \"yes\" or \"no\"");
		String answer = MyScanner.sc.next().toLowerCase();

		while (answer.equals("yes")) {
			System.out.println("What would you like to do?\n Type:\n"
					+ "\"add\": add a new guest to the list\n"
					+ "\"delete\": delete a guest from the list\n"
					+ "\"read\": view a guest details\n"
					+ "\"update\": modify a guest details from the list\n"
					+ "\"reset\": reset all the list and restart a new one");
			answer = MyScanner.sc.next().toLowerCase();
			
			switch(answer) {
			case "add":
				Guest g = cg.createGuestIstance();
				if (g != null) {
					q.create(g);
				}
				break;
			case "delete":
				q.readAll();
				System.out.println("Type in the ID number of the guest that you want to remove from the list:");
				id = MyScanner.sc.nextInt();
				q.deleteById(id);
				break;
			case "read":
				q.readAll();
				System.out.println("Type in the ID number of the guest that you want to visualize:");
				id = MyScanner.sc.nextInt();
				q.readById(id);
				break;
			case "update":
				q.readAll();
				System.out.println("Type in the ID number of the guest that you want to modify:");
				id = MyScanner.sc.nextInt();
				q.updateById(id);
				break;
			case "reset":
				q.deleteAll();
				break;
			default:
				System.out.println("Sorry, incorrect command.. Try again!");
				break;
			}

			q.countGuests();

			System.out.println("Would you like to make any more changes? Type \"yes\" or \"no\"");
			answer = MyScanner.sc.next().toLowerCase();
		}
	}
}
