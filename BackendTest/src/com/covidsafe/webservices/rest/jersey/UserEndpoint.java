package com.covidsafe.webservices.rest.jersey;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;  
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.covidsafe.webservices.objects.CreateUser;
import com.covidsafe.webservices.objects.SignInUser;
import com.covidsafe.webservices.objects.UserResponse;

@Path("/users")
public class UserEndpoint 
{	
	
	@POST 
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserResponse signInUser(SignInUser u)
	{
		return new LoginUserDao().signin(u);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserResponse createUser(CreateUser cu)
	{
		return new RegisterUserDao().insert(cu);
	}
	
}

