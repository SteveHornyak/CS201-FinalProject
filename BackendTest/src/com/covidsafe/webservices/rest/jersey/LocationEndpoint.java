package com.covidsafe.webservices.rest.jersey;


import java.sql.Connection;
import java.sql.DriverManager;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;  
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.covidsafe.webservices.objects.COVIDLocation;
import com.covidsafe.webservices.utilities.Utilities; 

@Path("/locations")
public class LocationEndpoint 
{
	private Connection conn;
	
	
	@Path("/{$yelpID}")
	@GET 
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public COVIDLocation getlocation(@PathParam("locationID") String locationID, @PathParam("yelpID") String yelpID)
	{
          COVIDLocation cLocation = Utilities.GetCovidLocation(locationID, yelpID, conn);
		if(cLocation != null)
		{
			return cLocation;
		}
		else {
			return null;
		}
		
	}

//	@Path("/addLocation")
//	@PUT 
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public Message(Response) addLocation(COVIDLocation cLocation)
//	{
//		
//	}


	
}

