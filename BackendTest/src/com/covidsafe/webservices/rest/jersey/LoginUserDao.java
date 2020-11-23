package com.covidsafe.webservices.rest.jersey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.core.Response;

import com.covidsafe.webservices.objects.ErrorEntity;
import com.covidsafe.webservices.objects.SignInUser;
import com.covidsafe.webservices.objects.UserResponse;
import com.covidsafe.webservices.utilities.DbUtil;
import com.covidsafe.webservices.utilities.Utilities;

public class LoginUserDao {
	public Response signin(SignInUser user) {
		Connection conn = DbUtil.getConnection();
		
		String status = "Failed. Invalid Password";
		Integer curr_id = null;
		String curr_firstName = null;
		String curr_lastName = null;
		String curr_email = null;
		String curr_phone = null;
		
		
		String sql = "SELECT * FROM CSCI201_Final_Database.UserProfile WHERE email = (?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,user.getemail());
			ResultSet rs = ps.executeQuery();
			String currPasswordHash = null;
			if(rs.next() == false) {
				return Response.status(403)
		                .entity(new ErrorEntity("Incorrect Password"))
		                .header("Access-Control-Allow-Origin", "*")
		                .header("Access-Control-Allow-Methods", "*")
		                .header("Access-Control-Allow-Headers", "*").build();	
			}
			while(rs.next()) {
				 currPasswordHash = rs.getString("passwordHash");
				if(Utilities.hashPassword(user.getpassword()).equals(currPasswordHash)) {
					status = "Success";
					curr_id = rs.getInt("id");
					curr_firstName = rs.getString("firstName");
					curr_lastName = rs.getString("lastName");
					curr_email = rs.getString("email");
					curr_phone = rs.getString("phone");
				}
			}
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
		UserResponse result =  new UserResponse(curr_id,curr_firstName,curr_lastName,curr_email,curr_phone,status);

		if(status!="Success") {
			return Response.status(403)
	                .entity(new ErrorEntity("Incorrect Password"))
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
