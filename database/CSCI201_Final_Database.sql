CREATE DATABASE IF NOT EXISTS CSCI201_Final_Database;
USE CSCI201_Final_Database;
DROP TABLE IF EXISTS LastVisited;
DROP TABLE IF EXISTS covidLocation;
DROP TABLE IF EXISTS UserProfile;
CREATE TABLE covidLocation(
	id BIGINT NOT NULL auto_increment,
    yelpID varchar(45),
    PRIMARY KEY (id,yelpID), 
	isOperational BIT NOT NULL,
	isSocialDistincing BIT NOT NULL,
	allowsPickup BIT NOT NULL,
	allowsIndoorActivity BIT,
	allowsOutdoorActivity BIT,
	allowsBathroomUse BIT NOT NULL,
	hasAcrylicShields BIT NOT NULL,
	utensilsPackaged BIT,
	staffPPE BLOB NOT NULL,
	covidReadyRating FLOAT NOT NULL,
	additionalNotes VARCHAR(45),
	hasCurbside BIT NOT NULL,
	hasDelivery BIT NOT NULL,
	lastPositiveCovidTest VARCHAR(45) NOT NULL,
	totalRatings BIGINT NOT NULL
);


CREATE TABLE UserProfile(
id BIGINT NOT NULL AUTO_INCREMENT,
firstName VARCHAR(45),
lastName VARCHAR(45),
email VARCHAR(45),
passwordHash VARCHAR(45),
phone VARCHAR(20) NULL,
PRIMARY KEY (id)
);
DROP TABLE IF EXISTS LastVisited;
CREATE TABLE LastVisited(
id BIGINT NOT NULL,
userID BIGINT NOT NULL,
covidTimeStamp VARCHAR(45),
covidLocationID BIGINT NOT NULL,
yelpID VARCHAR(45),
PRIMARY KEY (id),
FOREIGN KEY (userID) REFERENCES userProfile(id),
FOREIGN KEY (covidLocationID, yelpID) REFERENCES covidLocation(id, yelpID)
#FOREIGN KEY (yelpID) REFERENCES covidLocation(yelpID)
);

DROP TABLE IF EXISTS UserRating;
CREATE TABLE UserRating(
	id BIGINT NOT NULL AUTO_INCREMENT,
	covidLocationID BIGINT NOT NULL,
	yelpID VARCHAR(45) NOT NULL,
	userID BIGINT NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (userID) REFERENCES userProfile(id),
	FOREIGN KEY (covidLocationID, yelpID) REFERENCES covidLocation(id, yelpID)
#	FOREIGN KEY (yelpID) REFERENCES covidLocation(yelpID)
);