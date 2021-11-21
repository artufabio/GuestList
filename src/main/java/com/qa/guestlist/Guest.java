package com.qa.guestlist;

public class Guest {

	private String name;
	private int age;
	private String jobTitle;
	private String specialNotes;
	
	public Guest() {}
	
	public Guest(String name, int age, String jobTitle, String specialNotes) {
		super();
		this.name = name;
		this.age = age;
		this.jobTitle = jobTitle;
		this.specialNotes = specialNotes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getSpecialNotes() {
		return specialNotes;
	}

	public void setSpecialNotes(String specialNotes) {
		this.specialNotes = specialNotes;
	}

	@Override
	public String toString() {
		return "Guest [name=" + name + ", age=" + age + ", jobTitle=" + jobTitle + ", specialNotes=" + specialNotes
				+ "]";
	}

	
	
	
}
