CREATE DATABASE  IF NOT EXISTS `loginsignup` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `loginsignup`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: loginsignup
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `Account_Id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `last_login` datetime(6) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`Account_Id`),
  UNIQUE KEY `UK_h6dr47em6vg85yuwt4e2roca4` (`user_id`),
  CONSTRAINT `FK7m8ru44m93ukyb61dfxw0apf6` FOREIGN KEY (`user_id`) REFERENCES `user` (`User_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'arijeetsignup0303@gmail.com','arijeet123','2023-07-30 23:38:02.396407',1),(2,'arijeetsignup1-0303@gmail.com','arijeet0303','2023-07-31 14:00:58.398793',2),(3,'utkarsha@mail.com','what','2023-07-31 14:04:36.209540',3);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventory` (
  `inventoryid` int NOT NULL AUTO_INCREMENT,
  `productId` int DEFAULT NULL,
  `subProductId` int DEFAULT NULL,
  `vendorId` int DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `productType` varchar(45) DEFAULT NULL,
  `stockLocation` varchar(45) DEFAULT NULL,
  `lastUpdatedBy` varchar(45) DEFAULT NULL,
  `lastUpdatedTimestamp` varchar(45) DEFAULT NULL,
  `createdBy` varchar(45) DEFAULT NULL,
  `createdByTimestamp` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`inventoryid`),
  KEY `productId_idx` (`productId`),
  KEY `subProductId_idx` (`subProductId`),
  KEY `vendorId_idx` (`vendorId`),
  CONSTRAINT `product_Id` FOREIGN KEY (`productId`) REFERENCES `productdetails` (`productId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `subProductId` FOREIGN KEY (`subProductId`) REFERENCES `subproductdetails` (`subProductId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `vendor_Id` FOREIGN KEY (`vendorId`) REFERENCES `vendordetails` (`vendorId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory`
--

LOCK TABLES `inventory` WRITE;
/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productdetails`
--

DROP TABLE IF EXISTS `productdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productdetails` (
  `productId` int NOT NULL AUTO_INCREMENT,
  `productName` varchar(45) NOT NULL,
  `lastUpdatedBy` varchar(45) DEFAULT NULL,
  `lastUpdatedTimestamp` varchar(45) DEFAULT NULL,
  `createdBy` varchar(45) DEFAULT NULL,
  `createdByTimestamp` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`productId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productdetails`
--

LOCK TABLES `productdetails` WRITE;
/*!40000 ALTER TABLE `productdetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `productdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subproductdetails`
--

DROP TABLE IF EXISTS `subproductdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subproductdetails` (
  `subProductId` int NOT NULL AUTO_INCREMENT,
  `subProductName` varchar(45) DEFAULT NULL,
  `productId` int DEFAULT NULL,
  `vendorId` int DEFAULT NULL,
  `productPurchasePrice` float DEFAULT NULL,
  `productSellingPrice` float DEFAULT NULL,
  `lastUpdatedBy` varchar(45) DEFAULT NULL,
  `lastUpdatedTimestamp` varchar(45) DEFAULT NULL,
  `createdBy` varchar(45) DEFAULT NULL,
  `createdByTimestamp` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`subProductId`),
  KEY `productId_idx` (`productId`),
  KEY `vendorId_idx` (`vendorId`),
  CONSTRAINT `productId` FOREIGN KEY (`productId`) REFERENCES `productdetails` (`productId`),
  CONSTRAINT `vendorId` FOREIGN KEY (`vendorId`) REFERENCES `vendordetails` (`vendorId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subproductdetails`
--

LOCK TABLES `subproductdetails` WRITE;
/*!40000 ALTER TABLE `subproductdetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `subproductdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `User_id` int NOT NULL AUTO_INCREMENT,
  `full_name` varchar(255) DEFAULT NULL,
  `phone_number` double DEFAULT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `Address` varchar(255) NOT NULL,
  `email_id` varchar(255) DEFAULT NULL,
  `signup_date` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`User_id`),
  UNIQUE KEY `User_id_UNIQUE` (`User_id`),
  UNIQUE KEY `Email_Id_UNIQUE` (`email_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Arijeet Sengupta',8767071731,'Aryy','Owner','Kmaptee ,Nagpur','arijeetsignup0303@gmail.com','30-07-2022','arijeet123'),(2,'Arijeet1 Sengupta',9730974301,'Aryyy','Co-Owner','Kmaptee ,Nagpur,Maharashtra','arijeetsignup1-0303@gmail.com','2023-07-31 00:04:25.828765','arijeet0303'),(3,'Utkarsha Ghagare',9423054938,'Jhonson Baby','Co-Owner','Duttawadi,Nagpur,Maharashtra','utkarsha@mail.com','2023-07-31 14:03:30.142129','what');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendordetails`
--

DROP TABLE IF EXISTS `vendordetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendordetails` (
  `vendorId` int NOT NULL AUTO_INCREMENT,
  `vendorName` varchar(45) NOT NULL,
  `vendorLocation` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `lastUpdatedBy` varchar(45) DEFAULT NULL,
  `lastUpdatedTimestamp` varchar(45) DEFAULT NULL,
  `createdBy` varchar(45) DEFAULT NULL,
  `createdByTimestamp` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`vendorId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendordetails`
--

LOCK TABLES `vendordetails` WRITE;
/*!40000 ALTER TABLE `vendordetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `vendordetails` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-31 17:25:16
