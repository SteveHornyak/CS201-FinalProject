package com.covidsafe.webservices.rest.jersey;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;  
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.covidsafe.webservices.objects.CreateUser;
import com.covidsafe.webservices.objects.SignInUser;
import com.covidsafe.webservices.objects.UserResponse;
import com.covidsafe.webservices.objects.UserResponse; 

@Path("/users")
public class UserEndpoint 
{	
	private static Connection conn;
	
	@POST 
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public SignInUser signInUser(SignInUser u)
	{
		return u;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserResponse createUser(CreateUser cu)
	{
		return new RegisterUserDao().insert(cu);
	}
	
	public static void main (String[] args)
	{
		String db = "jdbc:mysql://localhost:3306/CSCI201_Final_Database";
	    String user = "root";
	    String pwd = "root";
	    
	    try {
			conn = DriverManager.getConnection(db, user, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}

