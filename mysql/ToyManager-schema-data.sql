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
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (00000000000000000001,'Robot','robot'),(00000000000000000002,'Đồ chơi mô hình','do-choi-mo-hinh'),(00000000000000000003,'Đồ chơi vận động','do-choi-cong-nghe'),(00000000000000000004,'Xe điều khiển','xe-dieu-khien');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (00000000000000000001,'2019-05-30 17:00:00','2019-06-01 17:00:00','2019-05-30 17:00:00',00000000000000000003,350000,00000000000000000001),(00000000000000000002,'2019-05-24 17:00:00','2019-05-31 17:00:00','2019-05-24 17:00:00',00000000000000000003,1520000,00000000000000000002);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
INSERT INTO `order_detail` VALUES (00000000000000000001,00000000000000000003,00000000000000000001,1,350000),(00000000000000000002,00000000000000000006,00000000000000000002,1,1520000);
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `order_status`
--

LOCK TABLES `order_status` WRITE;
/*!40000 ALTER TABLE `order_status` DISABLE KEYS */;
INSERT INTO `order_status` VALUES (00000000000000000001,'Đang chờ'),(00000000000000000002,'Đang giao'),(00000000000000000003,'Đã giao'),(00000000000000000004,'Đã hủy');
/*!40000 ALTER TABLE `order_status` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `parameter`
--

LOCK TABLES `parameter` WRITE;
/*!40000 ALTER TABLE `parameter` DISABLE KEYS */;
INSERT INTO `parameter` VALUES (00000000000000000001,'Thế giờ đồ chơi','134 Phạn Văn đồng','0343269874','thegioidochoi@gmail.com'),(00000000000000000002,'Đồ chơi Đẹp','43 Điện Biên Phủ','0326548569','dochoidep@gmail.com'),(00000000000000000003,'Vui Cùng Bé','23/5 Hoàng Diệu 2, quận Thủ Đức','0235614875','vuicungbe@gmail.com');
/*!40000 ALTER TABLE `parameter` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (00000000000000000001,'user',1),(00000000000000000002,'admin',2);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `toy`
--

LOCK TABLES `toy` WRITE;
/*!40000 ALTER TABLE `toy` DISABLE KEYS */;
INSERT INTO `toy` VALUES (00000000000000000001,'Robot khủng long Laite',500000,00000000000000000001,_binary '\0',' ','Khủng long Laite là chú Robot vui vẻ, đem lại nhiều niềm vui cho các bé. Bộ điều khiển cho Laite di chuyển, phát nhạc hay gầm lên dũng mãnh. Ngoài ra, Khủng long Laite có thể ghi nhớ tập hợp các lệnh và di chuyển theo các lệnh được ghi sẵn.',00000000000000000001),(00000000000000000002,'Xe địa hình Rock Crawler 1/18',480000,00000000000000000004,_binary '\0',' ','Xe địa hình Rock Crawler 1/18 là sản phẩm xe Ôtô điều khiển từ xa chất lượng cao nổi tiếng trên Thế Giới. Xe có thể leo trèo ở những địa hình hiểm trở và rất nhiều các bề mặt khác nhau mà không sợ trơn trượt hay lật xe.',00000000000000000001),(00000000000000000003,'Ô tô Drift – Fast & Furious',350000,00000000000000000004,_binary '\0',' ','Ô tô Drift Fast & Furious có 6 màu khác nhau tùy theo sở thích của mỗi người. Kích thước của chiếc xe không quá to nhưng ở mức cân đối để dễ dàng cho người chơi ở sân vườn hoặc trong nhà.',00000000000000000001),(00000000000000000004,'CYBER HUNTER VÀN',600000,00000000000000000003,_binary '\0',' ','Thiết Kế Siêu Ngầu, Động Cơ Siêu Mạnh, bắn xa trên 10m, Bắn Đạn Xốp Liên Tục',00000000000000000001),(00000000000000000005,'Mặt Nạ Skull Bones',80000,00000000000000000003,_binary '\0',' ','Món quà yêu thích cho những bạn yêu thích phim hành động.',00000000000000000001),(00000000000000000006,'Xếp Hình Siêu Xe Thể Thao Porsche 911 RSR – 1770 Miếng Ghép',1520000,00000000000000000002,_binary '\0',' ','Số lượng miếng ghép: 1770, Chất liệu: Nhựa ABS an toàn và thân thiện môi trường.',00000000000000000001);
/*!40000 ALTER TABLE `toy` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `toy_status`
--

LOCK TABLES `toy_status` WRITE;
/*!40000 ALTER TABLE `toy_status` DISABLE KEYS */;
INSERT INTO `toy_status` VALUES (00000000000000000001,'Còn hàng'),(00000000000000000002,'Hết hàng');
/*!40000 ALTER TABLE `toy_status` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (00000000000000000001,'lecunghuy','1234','Lê Cung Huy',_binary '\0','lecunghuy@gmail.com','0356548745','12 lê văn việt, quận 9, hcm','2016-05-24 17:00:00','2016-05-24 17:00:00',00000000000000000001,00000000000000000002),(00000000000000000002,'phanduyngo','12345','Phan Duy Ngô',_binary '\0','phaduyngo@gmail.com','0124856965','123 Hoàng Hoa Thám, HCM','2019-09-24 17:00:00','2019-09-24 17:00:00',00000000000000000001,00000000000000000001);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Dumping data for table `user_status`
--

LOCK TABLES `user_status` WRITE;
/*!40000 ALTER TABLE `user_status` DISABLE KEYS */;
INSERT INTO `user_status` VALUES (00000000000000000001,'Hoạt Động'),(00000000000000000002,'Không hoạt động');
/*!40000 ALTER TABLE `user_status` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-31 13:49:38
