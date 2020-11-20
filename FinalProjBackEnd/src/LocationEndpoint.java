
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

@Path("/locations")
public class LocationEndpoint 
{	
	@Path("/{$yelpID}")
	@GET 
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public COVIDLocation getlocation(@PathParam("yelpID") String yelpID)
	{
		String locationID = Utilities.SearchLocationID(yelpID, LocationDAO.getConnection());
		
        COVIDLocation cLocation = Utilities.GetCovidLocation(locationID, yelpID, LocationDAO.getConnection());
		if(cLocation != null)
		{
			return cLocation;
		}
		else {
			return null;
		}
	}

	@Path("/addLocation")
	@PUT 
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public COVIDLocation addLocation(COVIDLocation cLocation)
	{
		Boolean added = Utilities.addLocation(cLocation, LocationDAO.getConnection());
		if(added)
		{
			return cLocation;
		}
		else {
			return null;
		}
	}


	
}

