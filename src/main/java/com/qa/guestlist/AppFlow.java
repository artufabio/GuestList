package com.qa.guestlist;

public class AppFlow {

	UserActions ua = new UserActions();
	
	String answer;
	
	public void startAppFlow() {
		do {
			ua.createListGuests();
			
			ua.updateListGuests();
			
			System.out.println("Would you like to terminate the program? Type \"yes\" or \"no\"");
			answer = MyScanner.sc.next();

		} while(answer.equals("no"));
	}
}
