package com.covidsafe.webservices.rest.jersey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.covidsafe.webservices.objects.CreateUser;
import com.covidsafe.webservices.objects.UserResponse;

public class RegisterUserDao {
	static String db = "jdbc:mysql://localhost:3306/CSCI201_Final_Database";
    static String user = "root";
    static String pwd = "root";
    
    public Connection getConnection() {
    	Connection conn = null;
    	try {
    		conn = DriverManager.getConnection(db,user,pwd);
    	}
    	catch (SQLException e){
    		e.printStackTrace();
    	}
    	return conn;
    }
    
    // needs to add 
    public UserResponse insert(CreateUser user) {
    	System.out.println(user.toString());
    	Connection conn = this.getConnection();
    	String status = "Successful";
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
    		status = "Failed";
    	}
    	UserResponse result = new UserResponse(user.getFirstName(), user.getLastName(), user.getEmail(), 
    				user.getPhone(), status);
    	return result;
    }

}
