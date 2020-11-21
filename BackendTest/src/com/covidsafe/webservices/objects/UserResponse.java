package com.covidsafe.webservices.objects;

public class UserResponse {
	private String firstName; 
	private String lastName;
	private String email;
	private String phone; // NULL
	public String result;
	
	public UserResponse(String firstName, String lastName, String email, String phone, String result) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.result = result;
	}
	
	public UserResponse(String result) {
		this.result = result;
	}

	
}