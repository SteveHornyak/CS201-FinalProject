import java.sql.*;
import java.io.*;

public class CovidLocation 
{
	static void main(String[] args)
	{
		String db = "jdbc:mysql://localhost:3306/CSCI201_Final_Database";
		String user = "root";
		String pwd = "root";
		
		String sql = "SELECT * FROM covidLocation";
		
		try(Connection con = DriverManager.getConnection(db, user, pwd); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql))
		{
			while(rs.next()) {
				System.out.println(rs.getString("firstName"));
			}
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
