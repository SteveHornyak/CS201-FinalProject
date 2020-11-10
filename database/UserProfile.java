import java.sql.*;
import java.io.*;

public class UserProfile {
	
	
	public static final String db = "jdbc:mysql://localhost:3306/CSCI201_Final_Database";
	public static final String user = "root";
	public static String pwd = "root";
	
	public static void main(String[] args) {
		ResultSet test = getData("userprofile");
		try {
			while(test.next()) {
				System.out.println(test.getString("firstName") + "!");
			}
		}
		catch(Exception e) {
			
		}
	}
	
	public static ResultSet getData(String table) {
	
		String sql = "SELECT * FROM " + "CSCI201_Final_Database." + table;
		
		try(Connection conn = DriverManager.getConnection(db,user,pwd);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);){
			return rs; // Replace this line by the converting function
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
