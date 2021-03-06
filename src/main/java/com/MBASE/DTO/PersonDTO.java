package com.MBASE.DTO;

public class PersonDTO {
	
	String Id;
	String firstname;
	String lastname;
	int age;
	
	public PersonDTO() {
		
	}
	
	public PersonDTO(String firstname, String lastname, int age) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String tosString() {
		return "A person by the name: " + firstname +' '+ lastname + " aged : " + age +" saved successfully";
	}

}
