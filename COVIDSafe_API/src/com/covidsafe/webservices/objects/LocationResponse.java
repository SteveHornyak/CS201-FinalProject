import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.io.*;

public class LocationResponse{
     Integer id;
        
     String yelpID;
        
     Boolean isOperational;
     Boolean isSocialDistancing;
     Boolean allowsPickup;
     Boolean allowsIndoorActivity;
     Boolean allowsOutdoorActivity;
          Boolean allowsBathroomUse;
          Boolean hasAcrylicShields;
          Boolean utensilsPackaged;
          Blob staffPPE;
          Float covidReadyRating;
          String additionalNotes;
          Boolean hasCurbside;
          Boolean hasDelivery;
          String lastPositiveCovidTest;
          Integer totalRatings;
          Connection conn;

          public LocationResponse(){
               String db = "jdbc:mysql://localhost:3036/CSCI201_Final_Database";
		String user = "root";
		String pwd = "root";
		
		conn =  DriverManager.getConnection(db, user, pwd);
          }

     public Boolean createLocation(CreateLocation loc){

          this.id = loc.getId();
          this.yelpID=loc.getYelpID();
          this.isOperational=loc.getIsOperational();
          this.isSocialDistancing=loc.getIsSocialDistancing();
          this.allowsPickup=loc.getAllowsPickup();
          this.allowsIndoorActivity=loc.getAllowsIndoorActivity();
          this.allowsOutdoorActivity=loc.getAllowsOutdoorActivity();
          this.allowsBathroomUse=loc.getAllowsBathroomUse();
          this.hasAcrylicShields=loc.getHasAcrylicShields();
          this.utensilsPackaged=loc.getUtensilsPackaged();
          this.staffPPE=loc.getStaffPPE();
          this.covidReadyRating=loc.getCovidReadyRating();
          this.additionalNotes=loc.getAdditionalNotes();
          this.hasCurbside=loc.getHasCurbside();
          this.hasDelivery=loc.getHasDelivery();
          this.lastPositiveCovidTest=loc.getLastPositiveCovidTest();
          this.totalRatings=loc.getTotalRatings();

          String sql = "INSERT INTO covidLocation (id, yelpID, isOperational, isSocialDistancing, allowsPickup, allowsIndoorActivity, allowsOutdoorActivity, allowsBathroomUse, hasAcrylicShields, utensilsPackaged, staffPPE, covidReadyRating, additionalNotes, hasCurbside"
          +", hasDelivery, lastPositiveCovidTest, totalRatings) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
          PreparedStatement st = conn.prepareStatement(sql);
          st.setInt(1,   id);
          st.setString(2, yelpID);
          st.setBoolean(3, isOperational);
          st.setBoolean(4, isSocialDistancing);
          st.setBoolean(5, allowsPickup);

          st.setBoolean(6, allowsIndoorActivity);
          st.setBoolean(7, allowsOutdoorActivity);
          st.setBoolean(8, allowsBathroomUse);
          st.setBoolean(9, hasAcrylicShields);
          st.setBoolean(10, utensilsPackaged);
          st.setBlob(11, staffPPE);
          st.setFloat(12, covidReadyRating);
          st.setString(13, additionalNotes);
          st.setBoolean(14, hasCurbside);
          st.setBoolean(15, hasDelivery);
          st.setString(16, lastPositiveCovidTest);
          st.setInt(17, totalRatings);
          return st.execute();
     }

     public Boolean getLocation(String yID){
          try {
               String sql = "SELECT * FROM covidLocation WHERE yelpID =" + yID ;
               Statement st = con.createStatement();
               ResultSet rs = st.executeQuery(sql);
               id = rs.getInt("id"); 
               yelpId = rs.getString("yelpID");
               isOperational= rs.getBoolean("isOperational"); isSocialDistancing= rs.getBoolean("isSocialDistancing"); allowsPickup= rs.getBoolean("allowsPickup");
             allowsIndoorActivity= rs.getBoolean("allowsIndoorActivity"); allowsOutdoorActivity= rs.getBoolean("allowsOutDoorActivity"); allowsBathroomUse= rs.getBoolean("allowsBathroomUse"); hasAcrylicShields = rs.getBoolean("hasAcrylicShields"); utensilsPackaged= rs.getBoolean("utensilsPackaged");
              staffPPE= rs.getBlob("staffPPE");
              covidReadyRating= rs.getFloat("covidReadyRating"); additionalNotes= rs.getString("additionalNotes"); hasCurbside= rs.getBoolean("hasCurbside"); hasDelivery= rs.getBoolean("hasDelivery"); lastPositiveCovidTest= rs.getString("lastPositiveCovidTest"); totalRatings= rs.getInt("totalRatings");
              return true;
          } catch (Exception e) {
          return false;
          }   
     }

     public Boolean updateLocation(UpdateLocation loc){
          this.id = loc.getId();
          this.yelpID=loc.getYelpID();
          this.isOperational=loc.getIsOperational();
          this.isSocialDistancing=loc.getIsSocialDistancing();
          this.allowsPickup=loc.getAllowsPickup();
          this.allowsIndoorActivity=loc.getAllowsIndoorActivity();
          this.allowsOutdoorActivity=loc.getAllowsOutdoorActivity();
          this.allowsBathroomUse=loc.getAllowsBathroomUse();
          this.hasAcrylicShields=loc.getHasAcrylicShields();
          this.utensilsPackaged=loc.getUtensilsPackaged();
          this.staffPPE=loc.getStaffPPE();
          this.covidReadyRating=loc.getCovidReadyRating();
          this.additionalNotes=loc.getAdditionalNotes();
          this.hasCurbside=loc.getHasCurbside();
          this.hasDelivery=loc.getHasDelivery();
          this.lastPositiveCovidTest=loc.getLastPositiveCovidTest();
          this.totalRatings=loc.getTotalRatings();

          String sql = "UPDATE covidLocation SET isOperational = ?, isSocialDistancing = ?, allowsPickup = ?, allowsIndoorActivity = ?, allowsOutdoorActivity = ?, allowsBathroomUse = ?, hasAcrylicShields = ?, utensilsPackaged = ?, staffPPE = ?, covidReadyRating = ?, additionalNotes = ?, hasCurbside"
          +" = ?, hasDelivery = ?, lastPositiveCovidTest = ?, totalRatings = ? WHERE yelpID = " + yelpID;
          PreparedStatement st = conn.prepareStatement(sql);
          st.setBoolean(1, isOperational);
          st.setBoolean(2, isSocialDistancing);
          st.setBoolean(3, allowsPickup);

          st.setBoolean(4, allowsIndoorActivity);
          st.setBoolean(5, allowsOutdoorActivity);
          st.setBoolean(6, allowsBathroomUse);
          st.setBoolean(7, hasAcrylicShields);
          st.setBoolean(8, utensilsPackaged);
          st.setBlob(9, staffPPE);
          st.setFloat(10, covidReadyRating);
          st.setString(11, additionalNotes);
          st.setBoolean(12, hasCurbside);
          st.setBoolean(13, hasDelivery);
          st.setString(14, lastPositiveCovidTest);
          st.setInt(15, totalRatings);
          return st.execute();
     }

     public Integer getId() {
          return this.id;
     }

     public void setId(Integer id) {
          this.id = id;
     }

     public String getYelpID() {
          return this.yelpID;
     }

     public void setYelpID(String yelpID) {
          this.yelpID = yelpID;
     }

     public Boolean isIsOperational() {
          return this.isOperational;
     }

     public Boolean getIsOperational() {
          return this.isOperational;
     }

     public void setIsOperational(Boolean isOperational) {
          this.isOperational = isOperational;
     }

     public Boolean isIsSocialDistancing() {
          return this.isSocialDistancing;
     }

     public Boolean getIsSocialDistancing() {
          return this.isSocialDistancing;
     }

     public void setIsSocialDistancing(Boolean isSocialDistancing) {
          this.isSocialDistancing = isSocialDistancing;
     }

     public Boolean isAllowsPickup() {
          return this.allowsPickup;
     }

     public Boolean getAllowsPickup() {
          return this.allowsPickup;
     }

     public void setAllowsPickup(Boolean allowsPickup) {
          this.allowsPickup = allowsPickup;
     }

     public Boolean isAllowsIndoorActivity() {
          return this.allowsIndoorActivity;
     }

     public Boolean getAllowsIndoorActivity() {
          return this.allowsIndoorActivity;
     }

     public void setAllowsIndoorActivity(Boolean allowsIndoorActivity) {
          this.allowsIndoorActivity = allowsIndoorActivity;
     }

     public Boolean isAllowsOutdoorActivity() {
          return this.allowsOutdoorActivity;
     }

     public Boolean getAllowsOutdoorActivity() {
          return this.allowsOutdoorActivity;
     }

     public void setAllowsOutdoorActivity(Boolean allowsOutdoorActivity) {
          this.allowsOutdoorActivity = allowsOutdoorActivity;
     }

     public Boolean isAllowsBathroomUse() {
          return this.allowsBathroomUse;
     }

     public Boolean getAllowsBathroomUse() {
          return this.allowsBathroomUse;
     }

     public void setAllowsBathroomUse(Boolean allowsBathroomUse) {
          this.allowsBathroomUse = allowsBathroomUse;
     }

     public Boolean isHasAcrylicShields() {
          return this.hasAcrylicShields;
     }

     public Boolean getHasAcrylicShields() {
          return this.hasAcrylicShields;
     }

     public void setHasAcrylicShields(Boolean hasAcrylicShields) {
          this.hasAcrylicShields = hasAcrylicShields;
     }

     public Boolean isUtensilsPackaged() {
          return this.utensilsPackaged;
     }

     public Boolean getUtensilsPackaged() {
          return this.utensilsPackaged;
     }

     public void setUtensilsPackaged(Boolean utensilsPackaged) {
          this.utensilsPackaged = utensilsPackaged;
     }

     public Blob getStaffPPE() {
          return this.staffPPE;
     }

     public void setStaffPPE(Blob staffPPE) {
          this.staffPPE = staffPPE;
     }

     public Float getCovidReadyRating() {
          return this.covidReadyRating;
     }

     public void setCovidReadyRating(Float covidReadyRating) {
          this.covidReadyRating = covidReadyRating;
     }

     public String getAdditionalNotes() {
          return this.additionalNotes;
     }

     public void setAdditionalNotes(String additionalNotes) {
          this.additionalNotes = additionalNotes;
     }

     public Boolean isHasCurbside() {
          return this.hasCurbside;
     }

     public Boolean getHasCurbside() {
          return this.hasCurbside;
     }

     public void setHasCurbside(Boolean hasCurbside) {
          this.hasCurbside = hasCurbside;
     }

     public Boolean isHasDelivery() {
          return this.hasDelivery;
     }

     public Boolean getHasDelivery() {
          return this.hasDelivery;
     }

     public void setHasDelivery(Boolean hasDelivery) {
          this.hasDelivery = hasDelivery;
     }

     public String getLastPositiveCovidTest() {
          return this.lastPositiveCovidTest;
     }

     public void setLastPositiveCovidTest(String lastPositiveCovidTest) {
          this.lastPositiveCovidTest = lastPositiveCovidTest;
     }

     public Integer getTotalRatings() {
          return this.totalRatings;
     }

     public void setTotalRatings(Integer totalRatings) {
          this.totalRatings = totalRatings;
     }

     public LocationResponse id(Integer id) {
          this.id = id;
          return this;
     }

     public LocationResponse yelpID(String yelpID) {
          this.yelpID = yelpID;
          return this;
     }

     public LocationResponse isOperational(Boolean isOperational) {
          this.isOperational = isOperational;
          return this;
     }

     public LocationResponse isSocialDistancing(Boolean isSocialDistancing) {
          this.isSocialDistancing = isSocialDistancing;
          return this;
     }

     public LocationResponse allowsPickup(Boolean allowsPickup) {
          this.allowsPickup = allowsPickup;
          return this;
     }

     public LocationResponse allowsIndoorActivity(Boolean allowsIndoorActivity) {
          this.allowsIndoorActivity = allowsIndoorActivity;
          return this;
     }

     public LocationResponse allowsOutdoorActivity(Boolean allowsOutdoorActivity) {
          this.allowsOutdoorActivity = allowsOutdoorActivity;
          return this;
     }

     public LocationResponse allowsBathroomUse(Boolean allowsBathroomUse) {
          this.allowsBathroomUse = allowsBathroomUse;
          return this;
     }

     public LocationResponse hasAcrylicShields(Boolean hasAcrylicShields) {
          this.hasAcrylicShields = hasAcrylicShields;
          return this;
     }

     public LocationResponse utensilsPackaged(Boolean utensilsPackaged) {
          this.utensilsPackaged = utensilsPackaged;
          return this;
     }

     public LocationResponse staffPPE(Blob staffPPE) {
          this.staffPPE = staffPPE;
          return this;
     }

     public LocationResponse covidReadyRating(Float covidReadyRating) {
          this.covidReadyRating = covidReadyRating;
          return this;
     }

     public LocationResponse additionalNotes(String additionalNotes) {
          this.additionalNotes = additionalNotes;
          return this;
     }

     public LocationResponse hasCurbside(Boolean hasCurbside) {
          this.hasCurbside = hasCurbside;
          return this;
     }

     public LocationResponse hasDelivery(Boolean hasDelivery) {
          this.hasDelivery = hasDelivery;
          return this;
     }

     public LocationResponse lastPositiveCovidTest(String lastPositiveCovidTest) {
          this.lastPositiveCovidTest = lastPositiveCovidTest;
          return this;
     }

     public LocationResponse totalRatings(Integer totalRatings) {
          this.totalRatings = totalRatings;
          return this;
     }

    

     
     
}