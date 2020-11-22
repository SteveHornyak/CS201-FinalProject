package com.covidsafe.webservices.utilities;
import java.sql.*;
import java.io.*;
import com.covidsafe.webservices.objects.CovidLocation;
import com.covidsafe.webservices.objects.CreateUser;



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
		public static String verifyUserInfo(CreateUser user) {
			if(user.getFirstName()==null) {
				return "Failed. First name can't be empty.";
			}
			else if(user.getLastName()==null) {
				return "Failed. Last name can't be empty.";
			}
			else if(user.getEmail()==null) {
				return "Failed. E-mail can't be empty.";
			}
			// phone number maybe country codes? -> up to three digits. Number formatted?
			else if(user.getPhone()!=null && user.getPhone().length()>=20) {
				return "Failed. Invalid phone number format.";
			}
			else if(!user.getEmail().matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")) {
				return "Failed. Invalid email format.";
			}
			else if(user.getFirstName().contains("\s") || user.getLastName().contains("\s")) {
				return "Failed. Name can't contain spaces.";
			}
			return "Success";
		}

//		public static CovidLocation GetCovidLocation(String id, String yelpID, Connection con) {
//			ResultSet rs = null;
//			
//			Statement st;
//			try {
//				st = con.createStatement();
//				rs = st.executeQuery("SELECT * FROM UserRating WHERE id = " + id.toString());
//				if(rs.next() == false){
//					return null;
//				}
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//			
//			
//			CovidLocation cLocation = null;
//			try {
//				cLocation = new CovidLocation(rs.getInt("id"), rs.getString("yelpID"), rs.getBoolean("isOperational"), rs.getBoolean("isSocialDistancing"), rs.getBoolean("allowsPickup"),
//						rs.getBoolean("allowsIndoorActivity"), rs.getBoolean("allowsOutDoorActivity"), rs.getBoolean("allowsBathroomUse"), rs.getBoolean("hasAcrylicShields"), rs.getBoolean("utensilsPackaged"), rs.getBlob("staffPPE"),
//						rs.getFloat("covidReadyRating"), rs.getString("additionalNotes"), rs.getBoolean("hasCurbside"), rs.getBoolean("hasDelivery"), rs.getString("lastPositiveCovidTest"), rs.getInt("totalRatings"));
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			
//			return cLocation;
//		}
//
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
