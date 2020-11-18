
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

@Path("/users")
public class UserEndpoint 
{
	private Connection conn;
	
	public UserEndpoint()
	{
		String db = "jdbc:mysql://localhost:3036/CSCI201_Final_Database";
		String user = "root";
		String pwd = "root";
		
		conn =  DriverManager.getConnection(db, user, pwd);
	}
	
	@Path("/{userID}/{$passwordHash}")
	@GET 
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("userID") String userID, @PathParam("passwordHash") String passwordHash)
	{
		if(Utilities.VerifyUser(Integer.parseInt(userID), conn, passwordHash))
		{
			return new User();
		}
		else {
			return null;
		}
		
		return new User();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	// Alternatively, we can set the password to null in user and return that??
	public Message(Response) createUser(User u)
	{
		
	}
	
}

