import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.io.*;
//import org.json.JSONArray;
//import org.json.JSONObject;
//import org.json.JSONException;

public class CreateUser 
{
	private String firstName; 
	private String lastName;
	private String email;
	private String passwordHash;
	private String phone; // NULL
	
	public CreateUser(String firstName, String lastName, String email, String passwordHash, String phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.passwordHash = passwordHash;
		this.phone = phone;
	}
	
	public boolean authenticator()
	{
		return Utilities.verifyUserInfo(firstName, lastName, email, phone);
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public String getPhone() {
		return phone;
	}
		return this.firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getlastName() {
		return this.lastName;
	}
	
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public String getemail() {
		return this.email;
	}
	
	public void setemail(String email) {
		this.email = email;
	}
	
	
	
	public String getpasswordHash() {
		return this.passwordHash;
	}
	
	public void setpasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	
	
	
	public String getphone() {
		return this.phone;
	}
	
	public void setphone(String phone) {
		this.phone = phone;
	}

}
