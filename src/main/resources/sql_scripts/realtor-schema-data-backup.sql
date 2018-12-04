CREATE DATABASE  IF NOT EXISTS `realtor` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `realtor`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: realtor
-- ------------------------------------------------------
-- Server version	5.7.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Agent`
--

DROP TABLE IF EXISTS `Agent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Agent` (
  `agentId` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(30) DEFAULT NULL,
  `lastName` varchar(30) DEFAULT NULL,
  `phone` char(12) DEFAULT NULL,
  `firmId` int(11) NOT NULL,
  `licenseNumber` varchar(40) NOT NULL,
  `dateStarted` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `userSHA` varchar(100) NOT NULL,
  PRIMARY KEY (`agentId`),
  UNIQUE KEY `agentId_UNIQUE` (`agentId`),
  UNIQUE KEY `licenseNumber_UNIQUE` (`licenseNumber`)
) ENGINE=InnoDB AUTO_INCREMENT=311 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Agent`
--

LOCK TABLES `Agent` WRITE;
/*!40000 ALTER TABLE `Agent` DISABLE KEYS */;
INSERT INTO `Agent` VALUES (100,'Leet','Kim','135145636',210211,'abc1','2018-11-19 15:54:30',''),(112,'Jim','Alpha','171135636',210211,'abc2','2018-11-19 15:55:10',''),(123,'George','Grey','176321636',135210,'abc3','2018-11-19 15:55:10',''),(145,'Sarah','Core','135145909',135210,'abc4','2018-11-19 15:55:52',''),(168,'Livia','Watson','137145638',146277,'abc5','2018-11-19 15:55:55',''),(189,'Nik','Ray','135873630',146277,'abc6','2018-11-19 15:55:58',''),(201,'Cris','Paul','136141236',165034,'abc7','2018-11-19 15:56:16',''),(223,'Lena','Clay','137145123',165034,'abc8','2018-11-19 15:56:16',''),(267,'Kevin','Nil','190145636',230754,'abc9','2018-11-19 15:56:16',''),(310,'Hugh','Grant','132145639',230754,'abc10','2018-11-19 15:56:16','');
/*!40000 ALTER TABLE `Agent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Buyer`
--

DROP TABLE IF EXISTS `Buyer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Buyer` (
  `buyerId` int(11) NOT NULL,
  `firstName` varchar(30) DEFAULT NULL,
  `lastName` varchar(30) NOT NULL,
  `address` varchar(50) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` char(12) DEFAULT NULL,
  `userSHA` varchar(100) NOT NULL,
  PRIMARY KEY (`buyerId`),
  UNIQUE KEY `userSHA_UNIQUE` (`userSHA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Buyer`
--

LOCK TABLES `Buyer` WRITE;
/*!40000 ALTER TABLE `Buyer` DISABLE KEYS */;
/*!40000 ALTER TABLE `Buyer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `BuyerAgent`
--

DROP TABLE IF EXISTS `BuyerAgent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `BuyerAgent` (
  `buyerId` int(11) DEFAULT NULL,
  `agentId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BuyerAgent`
--

LOCK TABLES `BuyerAgent` WRITE;
/*!40000 ALTER TABLE `BuyerAgent` DISABLE KEYS */;
/*!40000 ALTER TABLE `BuyerAgent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Firm`
--

DROP TABLE IF EXISTS `Firm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Firm` (
  `id` int(11) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Firm`
--

LOCK TABLES `Firm` WRITE;
/*!40000 ALTER TABLE `Firm` DISABLE KEYS */;
INSERT INTO `Firm` VALUES (135210,'Goldman Sash','799 Georgia Way'),(146277,'Holloway','124 Texas Street'),(165034,'Good Target','135 California Street'),(210211,'Fast Searcher','1010 Alas Road'),(230754,'Cozy Home','277 Beach Road');
/*!40000 ALTER TABLE `Firm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `House`
--

DROP TABLE IF EXISTS `House`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `House` (
  `houseId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `address` varchar(50) NOT NULL,
  `ownerName` varchar(30) DEFAULT NULL,
  `builderName` varchar(30) DEFAULT NULL,
  `bedrooms` int(11) DEFAULT NULL,
  `bathrooms` int(11) DEFAULT NULL,
  `sqft` float DEFAULT NULL,
  PRIMARY KEY (`houseId`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `House`
--

LOCK TABLES `House` WRITE;
/*!40000 ALTER TABLE `House` DISABLE KEYS */;
INSERT INTO `House` VALUES (17,'2350 Gibson Road','John Smith','',3,2,196),(18,'197 Watson Street','Raymond Chou','',2,4,203),(19,'2525 Pottsdamer Street','Jim Lee','',2,3,180),(20,'193 Love BLVD','Kim Abudal','',3,2,401),(21,'647 Maston Road','Robert Clue','',3,2,102),(22,'Vincom',NULL,NULL,0,0,0),(23,'Vincom',NULL,NULL,0,0,0),(24,'Vincom',NULL,NULL,0,0,0),(25,'Vincom',NULL,NULL,0,0,0);
/*!40000 ALTER TABLE `House` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `HouseAgentListing`
--

DROP TABLE IF EXISTS `HouseAgentListing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `HouseAgentListing` (
  `agentId` int(11) NOT NULL,
  `houseId` int(11) NOT NULL,
  `price` int(10) unsigned NOT NULL,
  `dataListed` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `HouseAgentListing`
--

LOCK TABLES `HouseAgentListing` WRITE;
/*!40000 ALTER TABLE `HouseAgentListing` DISABLE KEYS */;
INSERT INTO `HouseAgentListing` VALUES (100,1,252000,'2018-11-19 16:20:02'),(112,2,150000,'2018-11-19 16:20:25'),(123,3,720000,'2018-11-19 16:20:25'),(145,4,960000,'2018-11-19 16:20:25'),(145,5,118000,'2018-11-19 16:20:25');
/*!40000 ALTER TABLE `HouseAgentListing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `HouseGeo`
--

DROP TABLE IF EXISTS `HouseGeo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `HouseGeo` (
  `houseId` int(11) NOT NULL,
  `lattitude` float NOT NULL,
  `longitude` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `HouseGeo`
--

LOCK TABLES `HouseGeo` WRITE;
/*!40000 ALTER TABLE `HouseGeo` DISABLE KEYS */;
/*!40000 ALTER TABLE `HouseGeo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `userSHA` varchar(100) NOT NULL,
  `userName` varchar(100) NOT NULL,
  `password` varchar(500) NOT NULL,
  `created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`userSHA`),
  UNIQUE KEY `userName_UNIQUE` (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `_Owner`
--

DROP TABLE IF EXISTS `_Owner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `_Owner` (
  `ownerId` int(11) NOT NULL,
  `firstName` varchar(30) DEFAULT NULL,
  `lastName` varchar(30) NOT NULL,
  `address` varchar(50) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` char(12) DEFAULT NULL,
  PRIMARY KEY (`ownerId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `_Owner`
--

LOCK TABLES `_Owner` WRITE;
/*!40000 ALTER TABLE `_Owner` DISABLE KEYS */;
/*!40000 ALTER TABLE `_Owner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `_OwnerAgent`
--

DROP TABLE IF EXISTS `_OwnerAgent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `_OwnerAgent` (
  `ownerId` int(11) DEFAULT NULL,
  `agentId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `_OwnerAgent`
--

LOCK TABLES `_OwnerAgent` WRITE;
/*!40000 ALTER TABLE `_OwnerAgent` DISABLE KEYS */;
/*!40000 ALTER TABLE `_OwnerAgent` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-04 22:26:11
