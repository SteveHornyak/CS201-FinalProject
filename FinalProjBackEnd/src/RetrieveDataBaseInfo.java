import java.sql.*;
import java.io.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

public class RetrieveDataBaseInfo {

     static String db = "jdbc:mysql://localhost:3306/CSCI201_Final_Database";
     static String user = "root";
     static  String pwd = "root";
          

     public static void main(String[] args) {
          try
		{
               Connection con = DriverManager.getConnection(db, user, pwd);
               ResultSetConverter converter = new ResultSetConverter();
               
		} catch (SQLException e){
               System.out.println("check sql connection");
          }

     }


     public static ResultSet GetCovidLocation(Integer id, String yelpID, Connection con){
          Statement st = con.createStatement();
          ResultSet rs = st.executeQuery("SELECT * FROM covidLocation WHERE id = " + id.toString() + "AND yelpID = " + yelpID);
          return rs;
     }
     public static ResultSet GetUserProfile(Integer id, Connection con){
          Statement st = con.createStatement();
          ResultSet rs = st.executeQuery("SELECT * FROM UserProfile WHERE id = " + id.toString());
          return rs;
     }
     public static ResultSet GetLastVisited(Integer id, Connection con){
          Statement st = con.createStatement();
          ResultSet rs = st.executeQuery("SELECT * FROM LastVisited WHERE id = " + id.toString() + "AND yelpID = ");
          return rs;
     }
     public static ResultSet GetUserRating(Integer id, Connection con){
          Statement st = con.createStatement();
          ResultSet rs = st.executeQuery("SELECT * FROM UserRating WHERE id = " + id.toString());
          return rs;
     }

     public static boolean VerifyUser(Integer id, Connection con, String password){
          Statement st = con.createStatement();
          ResultSet rs = st.executeQuery("SELECT * FROM UserRating WHERE id = " + id.toString());
          String s = rs.getString("passwordHash");
          if(s.equals(password)){
               return true;
          }
          return false;
     }
}
