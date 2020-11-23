package com.covidsafe.webservices.rest.jersey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.core.Response;

import com.covidsafe.webservices.objects.*;
import com.covidsafe.webservices.utilities.DbUtil;

public class GetLocationDao
{
	public Response getLocation(String yelpID)
	{
		Connection conn = DbUtil.getConnection();
		
		String status = "Failed. Invalid YelpID.";
		Integer curr_id = null;
		String curr_yelpID = null;    
		Boolean isOp = null;
		Boolean isSD = null;
		Boolean pu = null;;
		Boolean IA = null;
		Boolean OA = null;
		Boolean Bath = null;
		Boolean AS = null;
		Boolean uten = null;
		String ppe = null;
		Float crr = null;
		String notes = null;
		Boolean curb = null;
		Boolean deliv = null;
		String posCovidTest = null;
		Integer ratings = null;
		
		String sql = "SELECT * FROM CSCI201_Final_Database.CovidLocation WHERE yelpID = (?)";
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, yelpID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				curr_yelpID = rs.getString("yelpID");
					status = "Success";
					curr_id = rs.getInt("id");
					isOp = rs.getBoolean("isOperational");
					isSD = rs.getBoolean("isSocialDistancing");
					pu = rs.getBoolean("allowsPickup");
					IA = rs.getBoolean("allowsIndoorActivity");
					OA = rs.getBoolean("allowsOutdoorActivity");
					Bath = rs.getBoolean("allowsBathroomUse");
					AS = rs.getBoolean("hasAcrylicShields");
					uten = rs.getBoolean("utensilsPackaged");
					ppe = rs.getString("staffPPE");
					crr = rs.getFloat("covidReadyRating");
					notes = rs.getString("covidReadyRating");
					curb = rs.getBoolean("hasCurbside");
					deliv = rs.getBoolean("hasDelivery");
					posCovidTest = rs.getString("lastPositiveCovidTest");
					ratings = rs.getInt("totalRatings");
					
				}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
    		status = e.getMessage();
	    	return Response.status(403) // 403 also for sqlexception?
	                .entity(new ErrorEntity(status))
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "*")
                    .header("Access-Control-Allow-Headers", "*").build();
		}
		
		LocationResponse result =  new LocationResponse(curr_id,curr_yelpID,isOp,
				isSD,pu,IA,OA,Bath,AS,uten,ppe,crr,notes,curb,
				deliv,posCovidTest,ratings,status);
		
		if(status!="Success") {
			return Response.status(404)
	                .entity(new ErrorEntity(status))
	                .header("Access-Control-Allow-Origin", "*")
	                .header("Access-Control-Allow-Methods", "*")
	                .header("Access-Control-Allow-Headers", "*").build();		
		}

    	return Response.ok()
                .entity(result)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "*")
                .header("Access-Control-Allow-Headers", "*").build();		
	}
}