
package com.covidsafe.webservices.rest.jersey;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;  
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.covidsafe.webservices.objects.CovidLocation;

@Path("/locations")
public class LocationEndpoint 
{
	@Path("/{yelpID}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getlocation(@PathParam("yelpID") String yelpID)
	{
        return new GetLocationDao().getLocation(yelpID);
		
	}

	@POST 
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addLocation(CovidLocation cLocation)
	{
		return new AddLocationDao().insert(cLocation);
	} 


	
}