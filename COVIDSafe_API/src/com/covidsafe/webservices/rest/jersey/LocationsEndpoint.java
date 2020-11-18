package com.covidsafe.webservices.rest.jersey;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/users")
public class LocationsEndpoint {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public LocationResponse createLocation(CreateLocation location) {
		UserResponse res = new UserResponse();
		/*if(!Utils.validateCreateUser(cu)) {
			return 
		}
		UserImplemention userImp = UserImplemention();
		UserResponse res = userImp.creatUser(cu);*/
		
		//res.setFirstName(cu.getFirstName());		
		return res;
	}
	
	@Path("/{yelpID}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public LocationResponse getLocation(@PathParam("yelpID") String yelpID) {
		return res;
	}

	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public LocationResponse updateLocation(UpdateLocation location) {
		return res;
	}
}
