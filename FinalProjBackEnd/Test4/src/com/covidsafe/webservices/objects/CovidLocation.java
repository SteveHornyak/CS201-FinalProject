package com.covidsafe.webservices.objects;
import java.sql.*;
import java.io.*;
	
     
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
    private Blob staffPPE;
    private Float covidReadyRating;
    private String additionalNotes;
    private Boolean hasCurbside;
    private Boolean hasDelivery;
    private String lastPositiveCovidTest;
    private Integer totalRatings;
    
    public CovidLocation(String yelpID, Boolean isOp, Boolean isSD, Boolean pu, Boolean IA, Boolean OA, Boolean Bath,
			Boolean AS, Boolean uten, Blob ppe, Float crr, String notes, Boolean curb, Boolean deliv, String positive, Integer rate)
	{
		this.yelpID = yelpID;
		this.isOperational = isOp;
		this.isSocialDistancing = isSD;
		this.allowsPickup = pu;
		this.allowsIndoorActivity = IA; 
		this.allowsOutdoorActivity = OA;
		this.allowsBathroomUse = Bath;
		this.hasAcrylicShields = AS;
		this.utensilsPackaged = uten;
		this.staffPPE = ppe;
		this.covidReadyRating = crr;
		this.additionalNotes = notes;
		this.hasCurbside = curb;
		this.hasDelivery = deliv;
		this.lastPositiveCovidTest = positive;
		this.totalRatings = rate;
	}
	
	public String getYelpID()
	{
		return yelpID;
	}
	
	public Boolean getIsOperational()
	{
		return isOperational;
	}
	
	public Boolean getIsSocialDistancing()
	{
		return isSocialDistancing;
	}
	
	public Boolean getAllowsPickup()
	{
		return allowsPickup;
	}

	public Boolean getAllowsIndoorActivity()
	{
		return allowsIndoorActivity;
	}
	
	public Boolean getAllowsOutdoorActivity()
	{
		return allowsOutdoorActivity;
	}
	
	public Boolean getAllowsBathroomUse()
	{
		return allowsBathroomUse;
	}
	public Boolean getHasAcrylicShields()
	{
		return hasAcrylicShields;
	}
	public Boolean getUtensilsPackaged()
	{
		return utensilsPackaged;
	}
	public Blob getStaffPPE()
	{
		return staffPPE;
	}
	public Float getCovidReadyRating()
	{
		return covidReadyRating;
	}
	public String getAdditionalNotes()
	{
		return additionalNotes;
	}
	public Boolean getHasCurbside()
	{
		return hasCurbside;
	}
	public Boolean getHasDelivery()
	{
		return hasDelivery;
	}
	public String getLastPositiveCovidTest()
	{
		return lastPositiveCovidTest;
	}
	public Integer getTotalRatings()
	{
		return totalRatings;
	}
    
}