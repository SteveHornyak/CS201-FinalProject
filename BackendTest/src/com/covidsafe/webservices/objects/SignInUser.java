package com.covidsafe.webservices.objects;

public class SignInUser {
	
	private String passwordHash;
	private String email;
	
	public String getpasswordHash() {
		return this.passwordHash;
	}
	
	public void setpasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	
	public String getemail() {
		return this.email;
	}
	
	public void setemail(String email) {
		this.email = email;
	}
	
	
		
}
