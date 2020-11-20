package com.covidsafe.webservices.objects;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.io.*;
	
     
     public class COVIDLocation {
 
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
        


         public COVIDLocation(Integer id, String yelpID,  Boolean isOperational, Boolean isSocialDistancing,  Boolean allowsPickup, Boolean allowsIndoorActivity,
         Boolean allowsOutdoorActivity, Boolean allowsBathroomUse,  Boolean hasAcrylicShields,  Boolean utensilsPackaged, Blob staffPPE, Float covidReadyRating,
         String additionalNotes, Boolean hasCurbside, Boolean hasDelivery, String lastPositiveCovidTest, Integer totalRatings) {
          
          this.id = id;
          this.yelpID=yelpID;
          this.isOperational=isOperational;
          this.isSocialDistancing=isSocialDistancing;
          this.allowsPickup=allowsPickup;
          this.allowsIndoorActivity=allowsIndoorActivity;
          this.allowsOutdoorActivity=allowsOutdoorActivity;
          this.allowsBathroomUse=allowsBathroomUse;
          this.hasAcrylicShields=hasAcrylicShields;
          this.utensilsPackaged=utensilsPackaged;
          this.staffPPE=staffPPE;
          this.covidReadyRating=covidReadyRating;
          this.additionalNotes=additionalNotes;
          this.hasCurbside=hasCurbside;
          this.hasDelivery=hasDelivery;
          this.lastPositiveCovidTest=lastPositiveCovidTest;
          this.totalRatings=totalRatings;
          
          }
        
          public Integer getId() {
             return this.id;
          }
        
          public String getYelpID() {
             return this.yelpID;
          }
        
          public Boolean getIsOperational() {
             return this.isOperational;
          }
        
          public Boolean getIsSocialDistancing() {
             return this.isSocialDistancing;
          }
        
          public Boolean getAllowsPickup() {
             return this.allowsPickup;
          }
        
          public Boolean getAllowsIndoorActivity() {
             return this.allowsIndoorActivity;
          }
        
          public Boolean getAllowsOutdoorActivity() {
             return this.allowsOutdoorActivity;
          }
        
          public Boolean getAllowsBathroomUse() {
             return this.allowsBathroomUse;
          }
        
          public Boolean getHasAcrylicShields() {
             return this.hasAcrylicShields;
          }
        
          public Boolean getUtensilsPackaged() {
             return this.utensilsPackaged;
          }
        
          public Blob getStaffPPE() {
             return this.staffPPE;
          }
        
          public Float getCovidReadyRating() {
             return this.covidReadyRating;
          }
        
          public String getAdditionalNotes() {
             return this.additionalNotes;
          }
        
          public Boolean getHasCurbside() {
             return this.hasCurbside;
          }
        
          public Boolean getHasDelivery() {
             return this.hasDelivery;
          }
        
          public String getLastPositiveCovidTest() {
             return this.lastPositiveCovidTest;
          }
        
          public Integer getTotalRatings() {
             return this.totalRatings;
          }
       }
	


