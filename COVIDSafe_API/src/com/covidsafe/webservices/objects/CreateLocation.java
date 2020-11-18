import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.io.*;

public class CreateLocation{
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

     public CreateLocation() {
     }

     public CreateLocation(Integer id, String yelpID, Boolean isOperational, Boolean isSocialDistancing, Boolean allowsPickup, Boolean allowsIndoorActivity, Boolean allowsOutdoorActivity, Boolean allowsBathroomUse, Boolean hasAcrylicShields, Boolean utensilsPackaged, Blob staffPPE, Float covidReadyRating, String additionalNotes, Boolean hasCurbside, Boolean hasDelivery, String lastPositiveCovidTest, Integer totalRatings) {
          this.id = id;
          this.yelpID = yelpID;
          this.isOperational = isOperational;
          this.isSocialDistancing = isSocialDistancing;
          this.allowsPickup = allowsPickup;
          this.allowsIndoorActivity = allowsIndoorActivity;
          this.allowsOutdoorActivity = allowsOutdoorActivity;
          this.allowsBathroomUse = allowsBathroomUse;
          this.hasAcrylicShields = hasAcrylicShields;
          this.utensilsPackaged = utensilsPackaged;
          this.staffPPE = staffPPE;
          this.covidReadyRating = covidReadyRating;
          this.additionalNotes = additionalNotes;
          this.hasCurbside = hasCurbside;
          this.hasDelivery = hasDelivery;
          this.lastPositiveCovidTest = lastPositiveCovidTest;
          this.totalRatings = totalRatings;
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

    
         
}