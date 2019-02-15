/* create tables of attributes */
DROP TABLE IF EXISTS House;
CREATE TABLE House(
	houseId INT auto_increment NOT NULL,
	address VARCHAR(50) NOT NULL,
	ownerName VARCHAR(30),
    builderName VARCHAR(30),
	bedrooms INT,
	bathrooms INT,
	sqft DECIMAL,
	latitude DECIMAL(10, 8) NOT NULL,
    longitude DECIMAL(11, 8) NOT NULL,
    pos POINT NOT NULL,
    price DECIMAL(10) NOT NULL,
	PRIMARY KEY(houseId)
);

DROP TABLE IF EXISTS HouseGeo;
CREATE TABLE HouseGeo(
	houseId INT NOT NULL,
    lattitude DECIMAL NOT NULL,
    longitude DECIMAL NOT NULL
    -- FOREIGN KEY(houseId) REFERENCES House(houseId)
);

DROP TABLE IF EXISTS Agent;
CREATE TABLE Agent(
	agentId INT auto_increment NOT NULL,
	firstName VARCHAR(30),
    lastName VARCHAR(30),
	phone CHAR(12),
	firmId INT NOT NULL,
    licenseNumber VARCHAR(40) NOT NULL,
	dateStarted DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(agentId),
    UNIQUE KEY `agentId_UNIQUE` (agentId),
	UNIQUE KEY `licenseNumber_UNIQUE` (licenseNumber)
	-- FOREIGN KEY(firmId) REFERENCES Firm(id)
);

DROP TABLE IF EXISTS Firm;
CREATE TABLE Firm(
	id INT NOT NULL,
	name VARCHAR(30),
	address VARCHAR(50),
	PRIMARY KEY(id)
);

DROP TABLE IF EXISTS HouseAgentListing;
CREATE TABLE HouseAgentListing(
	houseId INT NOT NULL,
	agentId INT NOT NULL,
    price LONG NOT NULL,
	dataListed DATETIME DEFAULT CURRENT_TIMESTAMP
	-- FOREIGN KEY(agentId) REFERENCES Agent(agentId),
	-- FOREIGN KEY(address) REFERENCES Property(address)
);

DROP TABLE IF EXISTS Buyer;
CREATE TABLE Buyer(
	buyerId INT NOT NULL,
	firstName VARCHAR(30),
    lastName VARCHAR(30) NOT NULL,
    address VARCHAR(50) NOT NULL,
    email VARCHAR(255),
	phone CHAR(12),
	PRIMARY KEY(buyerId)
);

DROP TABLE IF EXISTS Owner;
CREATE TABLE `Owner`(
	ownerId INT NOT NULL,
	firstName VARCHAR(30),
    lastName VARCHAR(30) NOT NULL,
    address VARCHAR(50) NOT NULL,
    email VARCHAR(255),
	phone CHAR(12),
	PRIMARY KEY(ownerId)
);

DROP TABLE IF EXISTS BuyerAgent;
CREATE TABLE BuyerAgent(
	buyerId INT,
	agentId INT
	-- FOREIGN KEY(buyerId) REFERENCES Buyer(id),
	-- FOREIGN KEY(agentId) REFERENCES Agent(agentId)
);

DROP TABLE IF EXISTS OwenerAgent;
CREATE TABLE OwenerAgent(
	ownerId INT,
	agentId INT
	-- FOREIGN KEY(ownerId) REFERENCES `Owner`(ownerId),
	-- FOREIGN KEY(agentId) REFERENCES Agent(agentId)
);

-- create table transaction
-- create table house details like neighborhood and utilities


/* DATA INSERTION */
/* 5 records into Firm */
INSERT INTO Firm
VALUES(135210, 'Goldman Sash', '799 Georgia Way');

INSERT INTO Firm
VALUES(146277, 'Holloway', '124 Texas Street');

INSERT INTO Firm
VALUES(165034, 'Good Target', '135 California Street');

INSERT INTO Firm
VALUES(230754, 'Cozy Home', '277 Beach Road');

INSERT INTO Firm
VALUES(210211, 'Fast Searcher', '1010 Alas Road');


/* 10 records into Agent */
INSERT INTO Agent (agentId, firstName, lastName, phone, firmId, licenseNumber)
VALUES(100, 'Leet', 'Kim', '135145636', 210211, 'abc1');

INSERT INTO Agent (agentId, firstName, lastName, phone, firmId, licenseNumber)
VALUES(112, 'Jim', 'Alpha', '171135636', 210211,'abc2');

INSERT INTO Agent (agentId, firstName, lastName, phone, firmId, licenseNumber)
VALUES(123, 'George', 'Grey', '176321636', 135210,'abc3');

INSERT INTO Agent (agentId, firstName, lastName, phone, firmId, licenseNumber)
VALUES(145, 'Sarah', 'Core', '135145909', 135210, 'abc4');

INSERT INTO Agent (agentId, firstName, lastName, phone, firmId, licenseNumber)
VALUES(168, 'Livia', 'Watson', '137145638', 146277, 'abc5');

INSERT INTO Agent (agentId, firstName, lastName, phone, firmId, licenseNumber)
VALUES(189, 'Nik', 'Ray', '135873630', 146277, 'abc6');

INSERT INTO Agent (agentId, firstName, lastName, phone, firmId, licenseNumber)
VALUES(201, 'Cris', 'Paul', '136141236', 165034, 'abc7');

INSERT INTO Agent (agentId, firstName, lastName, phone, firmId, licenseNumber)
VALUES(223, 'Lena', 'Clay', '137145123', 165034,'abc8');

INSERT INTO Agent (agentId, firstName, lastName, phone, firmId, licenseNumber)
VALUES(267, 'Kevin', 'Nil', '190145636', 230754, 'abc9');

INSERT INTO Agent (agentId, firstName, lastName, phone, firmId, licenseNumber)
VALUES(310, 'Hugh', 'Grant', '132145639', 230754, 'abc10');

/* 5 records into House */
INSERT INTO House(address, ownerName, builderName, bedrooms, bathrooms, sqft, latitude, longitude, pos, price)
VALUES('2350 Gibson Road', 'John Smith', 'ABC Con', 3, 2, 196, -73.856077, 40.848447, ST_GeomFromText('POINT(-73.856077 40.848447)'), 1000000);

INSERT INTO House(address, ownerName, builderName, bedrooms, bathrooms, sqft, latitude, longitude, pos,  price)
VALUES('197 Watson Street', 'Raymond Chou', 'ABC Con', 2, 4, 203, -73.856077, 40.848447, ST_GeomFromText('POINT(-73.856077 40.848447)'), 1000000);

INSERT INTO House(address, ownerName, builderName, bedrooms, bathrooms, sqft, latitude, longitude, pos,  price)
VALUES('2525 Pottsdamer Street', 'Jim Lee', 'ABC Con', 2, 3, 180, -73.856077, 40.848447, ST_GeomFromText('POINT(-73.856077 40.848447)'), 1000000);

INSERT INTO House(address, ownerName, builderName, bedrooms, bathrooms, sqft, latitude, longitude, pos,  price)
VALUES('193 Love BLVD', 'Kim Abudal', 'ABC Con', 3, 2, 401, -73.856077, 40.848447, ST_GeomFromText('POINT(-73.856077 40.848447)'), 1000000);

INSERT INTO House(address, ownerName, builderName, bedrooms, bathrooms, sqft, latitude, longitude, pos,  price)
VALUES('647 Maston Road', 'Robert Clue', 'ABC Con', 3, 2, 102, -73.856077, 40.848447, ST_GeomFromText('POINT(-73.856077 40.848447)'), 1000000);

/* 10 records into Listing */
INSERT INTO HouseAgentListing (agentId, houseId, price)
VALUES(100, 1, 252000);

INSERT INTO HouseAgentListing(agentId, houseId, price)
VALUES(112, 2, 150000);

INSERT INTO HouseAgentListing(agentId, houseId, price)
VALUES(123, 3, 720000);

INSERT INTO HouseAgentListing(agentId, houseId, price)
VALUES(145, 4, 960000);

INSERT INTO HouseAgentListing(agentId, houseId, price)
VALUES(145, 5, 118000);

/* 6 records into Buyer */
INSERT INTO Buyer(buyerId, firstName, lastName, phone, address, email)
VALUES(799, 'John', 'Nay', '125345790', 'address 1', 'not applied');

INSERT INTO Buyer
VALUES(801, 'Retina', 'Grey', '146345790', 'address 2', 'not applied');

INSERT INTO Buyer
VALUES(813, 'Reg', 'Neal', '189345791', 'address 3', 'not applied');

INSERT INTO Buyer
VALUES(845, 'Gena', 'Sarah', '789345790', 'address 4', 'not applied');

INSERT INTO Buyer
VALUES(875, 'Bill', 'Clay', '888345798', 'address 5', 'office space');

INSERT INTO Buyer
VALUES(999, 'Hilton', 'Clag', '999345792', 'address 6', 'office space');