package com.covidsafe.webservices.rest.jersey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.ws.rs.core.Response;

import com.covidsafe.webservices.objects.CovidLocation;
import com.covidsafe.webservices.objects.ErrorEntity;
import com.covidsafe.webservices.objects.LocationResponse;
import com.covidsafe.webservices.utilities.DbUtil;

public class AddLocationDao
{
	
	public Response insert(CovidLocation cl)
	{
    	Connection conn = DbUtil.getConnection();
    	Integer curr_id = null;
    	String status = null;    	
    	
    	String sql = "INSERT INTO CovidLocation (yelpID, isOperational, isSocialDistancing, allowsPickup, allowsIndoorActivity, "
    			+ "allowsOutdoorActivity, allowsBathroomUse, hasAcrylicShields, utensilsPackaged, staffPPE, covidReadyRating, additionalNotes, "
    			+ "hasCurbside, hasDelivery, lastPositiveCovidTest, totalRatings) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE isOperational = ?, isSocialDistancing = ?, allowsPickup = ?, allowsIndoorActivity = ?,"
    			+ "allowsOutdoorActivity = ?, allowsBathroomUse = ?, hasAcrylicShields = ?, utensilsPackaged = ?, staffPPE = ?, covidReadyRating = ?, additionalNotes = ?,"
    			+ "hasCurbside = ?, hasDelivery = ?, lastPositiveCovidTest = ?, totalRatings = ?";
    	String sql2 = "SELECT id FROM CSCI201_Final_Database.CovidLocation WHERE yelpID = (?)";
    	try
    	{
    		PreparedStatement ps = conn.prepareStatement(sql);
    		ps.setString(1,cl.getYelpID());
    		ps.setBoolean(2, cl.getIsOperational());
    		ps.setBoolean(3, cl.getIsSocialDistancing());
    		ps.setBoolean(4, cl.getAllowsPickup());
    		ps.setBoolean(5, cl.getAllowsIndoorActivity());
    		ps.setBoolean(6, cl.getAllowsOutdoorActivity());
    		ps.setBoolean(7, cl.getAllowsBathroomUse());
    		ps.setBoolean(8, cl.getHasAcrylicShields());
    		ps.setBoolean(9, cl.getUtensilsPackaged());
    		ps.setString(10, cl.getStaffPPE());
    		ps.setFloat(11, cl.getCovidReadyRating()); 
    		ps.setString(12, cl.getAdditionalNotes());
    		ps.setBoolean(13, cl.getHasCurbside());
    		ps.setBoolean(14, cl.getHasDelivery());
    		ps.setString(15, cl.getLastPositiveCovidTest());
    		ps.setInt(16, cl.getTotalRatings());
    		ps.setBoolean(17, cl.getIsOperational());
    		ps.setBoolean(18, cl.getIsSocialDistancing());
    		ps.setBoolean(19, cl.getAllowsPickup());
    		ps.setBoolean(20, cl.getAllowsIndoorActivity());
    		ps.setBoolean(21, cl.getAllowsOutdoorActivity());
    		ps.setBoolean(22, cl.getAllowsBathroomUse());
    		ps.setBoolean(23, cl.getHasAcrylicShields());
    		ps.setBoolean(24, cl.getUtensilsPackaged());
    		ps.setString(25, cl.getStaffPPE());
    		ps.setFloat(26, cl.getCovidReadyRating()); 
    		ps.setString(27, cl.getAdditionalNotes());
    		ps.setBoolean(28, cl.getHasCurbside());
    		ps.setBoolean(29, cl.getHasDelivery());
    		ps.setString(30, cl.getLastPositiveCovidTest());
    		ps.setInt(31, cl.getTotalRatings());
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
    		status = e.getMessage();
    		return Response.status(403)
                    .entity(new ErrorEntity(status))
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "*")
                    .header("Access-Control-Allow-Headers", "*").build();
    	}
    	LocationResponse result = new LocationResponse(curr_id, cl, status);
    	return Response.ok()
                .entity(result)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "*")
                .header("Access-Control-Allow-Headers", "*").build();
    }
	public static void deleteIfExist(CovidLocation cl) {
		Connection conn = DbUtil.getConnection();
		String sql = "SELECT * FROM CovidLocation WHERE CovidLocation.yelpID = ?";
		String sql2 = "DELETE * FROM CovidLocation WHERE CovidLocation.yelpID = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,cl.getYelpID());
			ResultSet rs = ps.executeQuery();
			if(rs.isBeforeFirst()) {
				PreparedStatement ps2 = conn.prepareStatement(sql2);
				ps2.setString(1,cl.getYelpID());
				ps2.executeUpdate();
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}