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
    	
    	String sql = "INSERT INTO UserProfile (yelpID, isOperational, isSocialDistancing,  email, passwordHash, phone) VALUES (?,?,?,?,?)";
    	String sql2 = "SELECT id FROM csci201_final_database.covidLocation WHERE yelpID = (?)";
    	try
    	{
    		PreparedStatement ps = conn.prepareStatement(sql);
    		ps.setString(1,user.getFirstName());
    		ps.setString(2,user.getLastName());
    		ps.setString(3,user.getEmail());
    		ps.setString(4, user.getPasswordHash());
    		ps.setString(5,user.getPhone());
    		ps.executeUpdate();
    		PreparedStatement ps2 = conn.prepareStatement(sql2);
    		ps2.setString(1, user.getEmail());
    		ResultSet rslt = ps2.executeQuery();
    		while(rslt.next())
    		{
    			curr_id = rslt.getInt("id");
    		}
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    		status = "YelpID already registered!";
    	}
    	LocationResponse result = new LocationResponse(curr_id, cl, status);
    	return result;
    }
}
