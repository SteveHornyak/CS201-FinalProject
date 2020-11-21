package com.covidsafe.webservices.rest.jersey;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    	String status = Utilities.verifyUserInfo(user);
    	if(status!="Success") {
    		return new UserResponse(user.getFirstName(), user.getLastName(), user.getEmail(), 
    				user.getPhone(), status);
    	}
    	String sql = "INSERT INTO UserProfile (firstName, lastName, email, passwordHash, phone) VALUES (?,?,?,?,?)";
    	try {
    		PreparedStatement ps = conn.prepareStatement(sql);
    		ps.setString(1,user.getFirstName());
    		ps.setString(2,user.getLastName());
    		ps.setString(3,user.getEmail());
    		ps.setString(4, user.getPasswordHash());
    		ps.setString(5,user.getPhone());
    		ps.executeUpdate();
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    		status = "Email/Phone Already Registered!";
    	}
    	UserResponse result = new UserResponse(user.getFirstName(), user.getLastName(), user.getEmail(), 
    				user.getPhone(), status);
    	return result;
    }

}
