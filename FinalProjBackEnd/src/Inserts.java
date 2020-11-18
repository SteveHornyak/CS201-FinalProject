import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Inserts
{
	public ResultSet insertCovidLocation(String yelpID, boolean isOp, boolean isSD, boolean PU, boolean indoor, boolean outdoor,
			boolean bath, boolean aShield, boolean uten, String ppe, double rating, String notes, boolean curb, boolean delivery, String posCovidTest, int ratings, Connection con)
	{
		ResultSet rs = null;
		
		try
		{
			Statement st = con.createStatement();
			rs = st.executeQuery("INSERT INTO CovidLocation (yelpID, isOperational, isSocialDistancing, allowsPickup, allowsIndoorActivity, allowsOutdoorActivity,"
					+ " allowsBathroomUse, hasAcrylicShields, utenilsPackaged, staffPPE, covidReadyRating, additionalNotes."
					+ " hasCurbside, hasDelivery, lastPositiveCovidTest, totalRatings) VALUES (" + yelpID + ", " + isOp + ", " + isSD + ", " + PU + ", " + indoor + ", " + outdoor + ", " + bath + ", " + aShield + ", " + uten +
					", " + ppe + ", " + rating + ", " + notes + ", " + curb + ", " + delivery + ", " + posCovidTest + ", " + ratings + ");");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet insertUserProfile(String fname, String lname, String email, String pass, String phone, Connection con)
	{
		ResultSet rs = null;
		
		try
		{
			Statement st = con.createStatement();
			rs = st.executeQuery("INSERT INTO UserProfile (firstName, lastName, email, passwordHash, phone) VALUES (" + fname + ", " + lname + ", " +
											email + ", " + pass + ", " + phone + ");");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet insertUserRating(String yelpId, String userId, Connection con)
	{
		ResultSet rs = null;
		
		try
		{
			Statement st = con.createStatement();
			rs = st.executeQuery("INSERT INTO UserRating (covidLocationID, yelpID, userID) VALUES ((SELECT id FROM covidLocation WHERE yelpID IN (" + yelpId + ")), " + yelpId + ", " + userId + ");");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet insertLastVisted(String timeStamp, String userId, String yelpId, Connection con)
	{
		ResultSet rs = null;
		
		try
		{
			Statement st = con.createStatement();
			rs = st.executeQuery("INSERT INTO LastVisited (userID, covidTimeStamp, covidLocationID, yelpID) VALUES (" + userId + ", " + timeStamp + ", (SELECT id FROM covidLocation WHERE yelpID IN (" + yelpId + ")), "
					+ yelpId + ");");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return rs;
	}
}
