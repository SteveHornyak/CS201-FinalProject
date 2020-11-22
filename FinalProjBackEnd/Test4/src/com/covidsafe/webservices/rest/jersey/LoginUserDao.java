package com.covidsafe.webservices.rest.jersey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.covidsafe.webservices.objects.SignInUser;
import com.covidsafe.webservices.objects.UserResponse;
import com.covidsafe.webservices.utilities.DbUtil;

public class LoginUserDao {
	public UserResponse signin(SignInUser user) {
		Connection conn = DbUtil.getConnection();
		
		String status = "Failed. Invalid Password";
		Integer curr_id = null;
		String curr_firstName = null;
		String curr_lastName = null;
		String curr_email = null;
		String curr_phone = null;
		
		
		String sql = "SELECT * FROM csci201_final_database.userprofile WHERE email = (?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,user.getemail());
			ResultSet rs = ps.executeQuery();
			String currPasswordHash = null;
			while(rs.next()) {
				 currPasswordHash = rs.getString("passwordHash");
				if(user.getpasswordHash().equals(currPasswordHash)) {
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
			return new UserResponse(null,null, null, null, null, "SQL Exception");
		}
		return new UserResponse(curr_id,curr_firstName,curr_lastName,curr_email,curr_phone,status);
		
	}
}
