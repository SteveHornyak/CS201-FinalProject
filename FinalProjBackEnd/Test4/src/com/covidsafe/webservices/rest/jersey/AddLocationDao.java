package com.covidsafe.webservices.rest.jersey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.covidsafe.webservices.objects.CovidLocation;
import com.covidsafe.webservices.objects.LocationResponse;
import com.covidsafe.webservices.utilities.DbUtil;
import com.covidsafe.webservices.utilities.Utilities;

public class AddLocationDao
{
	public LocationResponse insert(CovidLocation cl)
	{
    	Connection conn = DbUtil.getConnection();
    	Integer curr_id = null;
    	String status = null;
    	
    	String sql = "INSERT INTO UserProfile (yelpID, isOperational, isSocialDistancing, allowsPickup, allowsIndoorActivity, "
    			+ "allowsOutdoorActivity, allowsBathroomUse, hasAcrylicShields, utensilsPackaged, staffPPE, covidReadyRating, additionalNotes, "
    			+ "hasCurbside, hasDelivery, lastPositiveCovidTest, totalRatings) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    	String sql2 = "SELECT id FROM csci201_final_database.covidLocation WHERE yelpID = (?)";
    	try
    	{
    		PreparedStatement ps = conn.prepareStatement(sql);
    		ps.setString(1,cl.getYelpID());
    		ps.setBoolean(2, cl.getIsOperational());
    		ps.setBoolean(3, cl.getIsOperational());
    		ps.setBoolean(4, cl.getAllowsPickup());
    		ps.setBoolean(5, cl.getAllowsIndoorActivity());
    		ps.setBoolean(6, cl.getAllowsOutdoorActivity());
    		ps.setBoolean(7, cl.getAllowsBathroomUse());
    		ps.setBoolean(8, cl.getHasAcrylicShields());
    		ps.setBoolean(9, cl.getUtensilsPackaged());
    		ps.setBlob(10, cl.getStaffPPE());
    		ps.setFloat(11, cl.getCovidReadyRating()); 
    		ps.setString(12, cl.getAdditionalNotes());
    		ps.setBoolean(13, cl.getHasCurbside());
    		ps.setBoolean(14, cl.getHasDelivery());
    		ps.setString(15, cl.getLastPositiveCovidTest());
    		ps.setInt(16, cl.getTotalRatings());
    		ps.executeUpdate();
    		PreparedStatement ps2 = conn.prepareStatement(sql2);
    		ps2.setString(1, cl.getYelpID());
    		ResultSet rslt = ps2.executeQuery();
    		while(rslt.next())
    		{
    			curr_id = rslt.getInt("id");
    		}
    		
    		status = "Successful";
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    		status = "YelpID already registered!";
    	}
    	LocationResponse result = new LocationResponse(curr_id, cl, status);
    	return result;
    }
}
