
import java.sql.Connection;
import java.sql.DriverManager;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;  
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response; 

@Path("/locations")
public class LocationEndpoint 
{
	private Connection conn;
	
	public LocationEndpoint()
	{
		String db = "jdbc:mysql://localhost:3036/CSCI201_Final_Database";
		String user = "root";
		String pwd = "root";
		
		conn =  DriverManager.getConnection(db, user, pwd);
	}
	
	@Path("/{locationID}/{$yelpID}")
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
		
		return new COVIDLocation();
	}

	@Path("/addLocation")
	@SET 
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message(Response) addLocation(COVIDLocation cLocation)
	{
		
	}


	
}

