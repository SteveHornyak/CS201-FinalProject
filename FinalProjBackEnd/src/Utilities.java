import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.io.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;


public class Utilities
{
	//Login authenticator
	 public static boolean VerifyUser(Integer id, Connection con, String password){
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery("SELECT * FROM UserRating WHERE id = " + id.toString());
         String s = rs.getString("passwordHash");
         if(s.equals(password)){
              return true;
         }
         return false;
    }
	 
	 //Verifying correct or acceptable user input
		public static boolean verifyUserInfo(String firstName, String lastName, String email, String phone) {
			if(firstName!=null||lastName==null||email==null) {
				return false;
			}
			// phone number maybe countrycodes? -> up to three digits. Number formatted?
			else if(phone!=null && phone.length()>=20) {
				return false;
			}
			else if(!email.contains("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")) {
				return false;
			}
			else if(firstName.contains("\s") || lastName.contains("\s")) {
				return false;
			}
			return true;
		}

		public static COVIDLocation GetCovidLocation(String id, String yelpID, Connection con) {
			Statement st = con.createStatement();
	    ResultSet rs = st.executeQuery("SELECT * FROM UserRating WHERE id = " + id.toString());
	    if(rs.next() == false){
		    return null;
	    }
	    COVIDLocation cLocation = new COVIDLocation(rs.getInt("id"), rs.getString("yelpID"), rs.getBoolean("isOperational"), rs.getBoolean("isSocialDistancing"), rs.getBoolean("allowsPickup"),
	    rs.getBoolean("allowsIndoorActivity"), rs.getBoolean("allowsOutDoorActivity"), rs.getBoolean("allowsBathroomUse"), rs.getBoolean("hasAcrylicShields"), rs.getBoolean("utensilsPackaged"), rs.getBlob("staffPPE"),
	    rs.getFloat("covidReadyRating"), rs.getString("additionalNotes"), rs.getBoolean("hasCurbside"), rs.getBoolean("hasDelivery"), rs.getString("lastPositiveCovidTest"), rs.getInt("totalRatings"));
			
			return cLocation;
		}

}
