package com.covidsafe.webservices.objects;
import java.sql.*;
	
     
public class CovidLocation
{       
    private String yelpID;    
    private Boolean isOperational;
    private Boolean isSocialDistancing;
    private Boolean allowsPickup;
    private Boolean allowsIndoorActivity;
    private Boolean allowsOutdoorActivity;
    private Boolean allowsBathroomUse;
    private Boolean hasAcrylicShields;
    private Boolean utensilsPackaged;
    private String staffPPE;
    private Float covidReadyRating;
    private String additionalNotes;
    private Boolean hasCurbside;
    private Boolean hasDelivery;
    private String lastPositiveCovidTest;
    private Integer totalRatings;
    
	public String getYelpID() {
		return yelpID;
	}
	public void setYelpID(String yelpID) {
		this.yelpID = yelpID;
	}
	public Boolean getIsOperational() {
		return isOperational;
	}
	public void setIsOperational(Boolean isOperational) {
		this.isOperational = isOperational;
	}
	public Boolean getIsSocialDistancing() {
		return isSocialDistancing;
	}
	public void setIsSocialDistancing(Boolean isSocialDistancing) {
		this.isSocialDistancing = isSocialDistancing;
	}
	public Boolean getAllowsPickup() {
		return allowsPickup;
	}
	public void setAllowsPickup(Boolean allowsPickup) {
		this.allowsPickup = allowsPickup;
	}
	public Boolean getAllowsIndoorActivity() {
		return allowsIndoorActivity;
	}
	public void setAllowsIndoorActivity(Boolean allowsIndoorActivity) {
		this.allowsIndoorActivity = allowsIndoorActivity;
	}
	public Boolean getAllowsOutdoorActivity() {
		return allowsOutdoorActivity;
	}
	public void setAllowsOutdoorActivity(Boolean allowsOutdoorActivity) {
		this.allowsOutdoorActivity = allowsOutdoorActivity;
	}
	public Boolean getAllowsBathroomUse() {
		return allowsBathroomUse;
	}
	public void setAllowsBathroomUse(Boolean allowsBathroomUse) {
		this.allowsBathroomUse = allowsBathroomUse;
	}
	public Boolean getHasAcrylicShields() {
		return hasAcrylicShields;
	}
	public void setHasAcrylicShields(Boolean hasAcrylicShields) {
		this.hasAcrylicShields = hasAcrylicShields;
	}
	public Boolean getUtensilsPackaged() {
		return utensilsPackaged;
	}
	public void setUtensilsPackaged(Boolean utensilsPackaged) {
		this.utensilsPackaged = utensilsPackaged;
	}
	public String getStaffPPE() {
		return staffPPE;
	}
	public void setStaffPPE(String staffPPE) {
		this.staffPPE = staffPPE;
	}
	public Float getCovidReadyRating() {
		return covidReadyRating;
	}
	public void setCovidReadyRating(Float covidReadyRating) {
		this.covidReadyRating = covidReadyRating;
	}
	public String getAdditionalNotes() {
		return additionalNotes;
	}
	public void setAdditionalNotes(String additionalNotes) {
		this.additionalNotes = additionalNotes;
	}
	public Boolean getHasCurbside() {
		return hasCurbside;
	}
	public void setHasCurbside(Boolean hasCurbside) {
		this.hasCurbside = hasCurbside;
	}
	public Boolean getHasDelivery() {
		return hasDelivery;
	}
	public void setHasDelivery(Boolean hasDelivery) {
		this.hasDelivery = hasDelivery;
	}
	public String getLastPositiveCovidTest() {
		return lastPositiveCovidTest;
	}
	public void setLastPositiveCovidTest(String lastPositiveCovidTest) {
		this.lastPositiveCovidTest = lastPositiveCovidTest;
	}
	public Integer getTotalRatings() {
		return totalRatings;
	}
	public void setTotalRatings(Integer totalRatings) {
		this.totalRatings = totalRatings;
	}
	

}