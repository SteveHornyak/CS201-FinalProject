import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.io.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

public class User 
{
	private Integer id; // primary
	private String firstName; 
	private String lastName;
	private String email;
	private String passwordHash;
	private String phone; // NULL
	
	public User(Integer id, String firstName, String lastName, String email, String passwordHash, String phone) {
		this.id = id;
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

}
