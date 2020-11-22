
package com.covidsafe.webservices.rest.jersey;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;  
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.covidsafe.webservices.objects.CovidLocation;
import com.covidsafe.webservices.objects.LocationResponse;

@Path("/locations")
public class LocationEndpoint 
{
	@Path("/{yelpID}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public LocationResponse getlocation(@PathParam("yelpID") String yelpID)
	{
        return new GetLocationDao().getLocation(yelpID);
		
	}

	@Path("/addLocation")
	@PUT 
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public LocationResponse addLocation(CovidLocation cLocation)
	{
		return new AddLocationDao().insert(cLocation);
	} 


	
}