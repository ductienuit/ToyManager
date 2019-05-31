CREATE DATABASE  IF NOT EXISTS `toymanager` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `toymanager`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: toymanager
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `category` (
  `Id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  `Code` varchar(255) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `order` (
  `Id` bigint(20) unsigned zerofill NOT NULL,
  `OrderDate` timestamp NOT NULL,
  `PaymentDate` timestamp NULL DEFAULT NULL,
  `LastModifiedDate` timestamp NOT NULL,
  `OrderStatusId` bigint(20) unsigned zerofill NOT NULL,
  `TotalPrice` decimal(10,0) NOT NULL,
  `UserId` bigint(20) unsigned zerofill NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_Order_OrderStatus1_idx` (`OrderStatusId`),
  KEY `fk_Order_User1_idx` (`UserId`),
  CONSTRAINT `fk_Order_OrderStatus1` FOREIGN KEY (`OrderStatusId`) REFERENCES `order_status` (`id`),
  CONSTRAINT `fk_Order_User1` FOREIGN KEY (`UserId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `order_detail` (
  `Id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `ToyId` bigint(20) unsigned zerofill NOT NULL,
  `OrderId` bigint(20) unsigned zerofill NOT NULL,
  `Quantity` int(11) NOT NULL,
  `TotalPrice` decimal(10,0) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_OrderDetail_Toy1_idx` (`ToyId`),
  KEY `fk_OrderDetail_Order1_idx` (`OrderId`),
  CONSTRAINT `fk_OrderDetail_Order1` FOREIGN KEY (`OrderId`) REFERENCES `order` (`id`),
  CONSTRAINT `fk_OrderDetail_Toy1` FOREIGN KEY (`ToyId`) REFERENCES `toy` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `order_status`
--

DROP TABLE IF EXISTS `order_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `order_status` (
  `Id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `parameter`
--

DROP TABLE IF EXISTS `parameter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `parameter` (
  `Id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `ShopName` varchar(255) NOT NULL,
  `ShopAddress` varchar(255) NOT NULL,
  `ShopPhoneNumber` char(10) NOT NULL,
  `ShopEmail` varchar(255) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `role` (
  `Id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  `Priority` int(11) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `toy`
--

DROP TABLE IF EXISTS `toy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `toy` (
  `Id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  `Price` decimal(10,0) NOT NULL,
  `CategoryId` bigint(20) unsigned zerofill NOT NULL,
  `Gender` bit(1) NOT NULL,
  `ImageURI` varchar(255) NOT NULL,
  `Description` longtext NOT NULL,
  `ToyStatusId` bigint(20) unsigned zerofill NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_Toy_Category1_idx` (`CategoryId`),
  KEY `fk_toy_toy_status1_idx` (`ToyStatusId`),
  CONSTRAINT `fk_Toy_Category1` FOREIGN KEY (`CategoryId`) REFERENCES `category` (`id`),
  CONSTRAINT `fk_toy_toy_status1` FOREIGN KEY (`ToyStatusId`) REFERENCES `toy_status` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `toy_status`
--

DROP TABLE IF EXISTS `toy_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `toy_status` (
  `Id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `Id` bigint(20) unsigned zerofill NOT NULL,
  `Username` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `FullName` varchar(255) NOT NULL,
  `Gender` bit(1) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `PhoneNumber` char(10) NOT NULL,
  `Address` varchar(255) NOT NULL,
  `CreatedDate` timestamp NOT NULL,
  `LastModifiedDate` timestamp NOT NULL,
  `RoleId` bigint(20) unsigned zerofill NOT NULL,
  `UserStatusId` bigint(20) unsigned zerofill NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_User_UserStatus1_idx` (`UserStatusId`),
  KEY `fk_User_Role1_idx` (`RoleId`),
  CONSTRAINT `fk_User_Role1` FOREIGN KEY (`RoleId`) REFERENCES `role` (`id`),
  CONSTRAINT `fk_User_UserStatus1` FOREIGN KEY (`UserStatusId`) REFERENCES `user_status` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_status`
--

DROP TABLE IF EXISTS `user_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_status` (
  `Id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-31 13:54:47
