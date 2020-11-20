package com.covidsafe.webservices.utilities;
import java.sql.*;
import java.io.*;
import com.covidsafe.webservices.objects.COVIDLocation;



public class Utilities
{
	//Login authenticator
	 public static boolean VerifyUser(Integer id, Connection con, String password){
		 String s = null;
		 
         Statement st;
		try {
			st = con.createStatement();
			 ResultSet rs = st.executeQuery("SELECT * FROM UserRating WHERE id = " + id.toString());
	         s = rs.getString("passwordHash");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
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
			// phone number maybe country codes? -> up to three digits. Number formatted?
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
			ResultSet rs = null;
			
			Statement st;
			try {
				st = con.createStatement();
				rs = st.executeQuery("SELECT * FROM UserRating WHERE id = " + id.toString());
				if(rs.next() == false){
					return null;
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			
			COVIDLocation cLocation = null;
			try {
				cLocation = new COVIDLocation(rs.getInt("id"), rs.getString("yelpID"), rs.getBoolean("isOperational"), rs.getBoolean("isSocialDistancing"), rs.getBoolean("allowsPickup"),
						rs.getBoolean("allowsIndoorActivity"), rs.getBoolean("allowsOutDoorActivity"), rs.getBoolean("allowsBathroomUse"), rs.getBoolean("hasAcrylicShields"), rs.getBoolean("utensilsPackaged"), rs.getBlob("staffPPE"),
						rs.getFloat("covidReadyRating"), rs.getString("additionalNotes"), rs.getBoolean("hasCurbside"), rs.getBoolean("hasDelivery"), rs.getString("lastPositiveCovidTest"), rs.getInt("totalRatings"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return cLocation;
		}

//		public static Boolean addLocation(COVIDLocation cLocation, Connection con){
//			if(cLocation == null){
//				return false; 
//			}
//			Inserts inserts = new Inserts();
//			inserts.insertCovidLocation(cLocation.getYelpID(), cLocation.getIsOperational(), cLocation.getIsSocialDistancing(), cLocation.getAllowsPickup(), cLocation.getAllowsIndoorActivity(), cLocation.getAllowsOutdoorActivity(), 
//			cLocation.getAllowsBathroomUse(), cLocation.getHasAcrylicShields(), cLocation.getUtensilsPackaged(), cLocation.getStaffPPE(), cLocation.getCovidReadyRating(), cLocation.getAdditionalNotes(), 
//			cLocation.getHasCurbside(), cLocation.getHasDelivery(), cLocation.getLastPositiveCovidTest(), cLocation.getTotalRatings(), con);
//			return true;
//		}

}
