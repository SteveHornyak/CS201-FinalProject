package com.covidsafe.webservices.rest.jersey;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.covidsafe.webservices.objects.*;

@Path("/users")
public class LocationsEndpoint {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public LocationResponse createLocation(CreateLocation location) {
		LocationResponse lResponse = new LocationResponse();
		if(lResponse.createLocation(location)){
			return lResponse;
		} else{
			return null;
		}
				
		
	}
	
	@Path("/{yelpID}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public LocationResponse getLocation(@PathParam("yelpID") String yelpID) {
		LocationResponse lResponse = new LocationResponse();
		if(lResponse.getLocation(yelpID)){
			return lResponse;
		} else{
			return null;
		}
	}

	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public LocationResponse updateLocation(UpdateLocation location) {
		LocationResponse lResponse = new LocationResponse();
		if(lResponse.updateLocation(location)){
			return lResponse;
		} else{
			return null;
		}
	}
}
