package com.qa.guestlist;

public class CreateGuest{
	
//	Method that returns a new Person object based on what the Scanner collects from users typing
	public Guest createGuestIstance() {
		try {
			Guest g = new Guest();
			System.out.println("What's their name?");
			MyScanner.sc.nextLine();
			g.setName(MyScanner.sc.nextLine());
			System.out.println("What's their age?");
			g.setAge(MyScanner.sc.nextInt());
			System.out.println("What's their job title?");
			MyScanner.sc.nextLine();
			g.setJobTitle(MyScanner.sc.nextLine());
			System.out.println("Any special notes? (i.e. special guest, gluten intollerant,...)");
//			MyScanner.sc.nextLine();
			g.setSpecialNotes(MyScanner.sc.nextLine());
			return g;
		}catch(Exception e) {
			System.out.println("Sorry but your input is not correct... Please try again.");
		}
		MyScanner.sc.nextLine();
		return null;
	}

}
