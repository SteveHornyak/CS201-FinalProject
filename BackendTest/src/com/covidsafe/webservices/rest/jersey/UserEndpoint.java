package com.covidsafe.webservices.rest.jersey;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;  
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.covidsafe.webservices.objects.CreateUser;
import com.covidsafe.webservices.objects.SignInUser;

@Path("/users")
public class UserEndpoint 
{	
	@Path("/login")
	@POST 
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response signInUser(SignInUser u)
	{
		return new LoginUserDao().signin(u);
	}
	
	@Path("/register")
	@POST 
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUser(CreateUser cu)
	{
		return new RegisterUserDao().insert(cu);
	}
	
}

