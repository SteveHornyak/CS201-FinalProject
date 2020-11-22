package com.covidsafe.webservices.rest.jersey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.covidsafe.webservices.objects.CreateUser;
import com.covidsafe.webservices.objects.UserResponse;
import com.covidsafe.webservices.utilities.DbUtil;
import com.covidsafe.webservices.utilities.Utilities;


public class RegisterUserDao {
    
    // needs to add 
    public UserResponse insert(CreateUser user) {
    	System.out.println(user.toString());
    	Connection conn = DbUtil.getConnection();
    	Integer curr_id = null;
    	String status = Utilities.verifyUserInfo(user);
    	if(status!="Success") {
    		return new UserResponse(curr_id,user.getFirstName(), user.getLastName(), user.getEmail(), 
    				user.getPhone(), status);
    	}
    	String sql = "INSERT INTO UserProfile (firstName, lastName, email, passwordHash, phone) VALUES (?,?,?,?,?)";
    	String sql2 = "SELECT id FROM csci201_final_database.userprofile WHERE email = (?)";
    	try {
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
    		while(rslt.next()) {
    			curr_id = rslt.getInt("id");
    		}
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    		status = "Email/Phone Already Registered!";
    	}
    	UserResponse result = new UserResponse(curr_id,user.getFirstName(), user.getLastName(), user.getEmail(), 
    				user.getPhone(), status);
    	return result;
    }

}
