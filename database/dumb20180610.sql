-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: cms
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `contact`
--

DROP TABLE IF EXISTS `contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contact` (
  `contact_id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `email_address` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `zip` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`contact_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact`
--

LOCK TABLES `contact` WRITE;
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
INSERT INTO `contact` VALUES (1,'bakos','Alexandria','Egypt','email@domain.com','Ahmed','Yehia','11111');
/*!40000 ALTER TABLE `contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract`
--

DROP TABLE IF EXISTS `contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contract` (
  `contract_id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  `account_no` varchar(255) DEFAULT NULL,
  `shop_area` float DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  `file_path` varchar(255) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`contract_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract`
--

LOCK TABLES `contract` WRITE;
/*!40000 ALTER TABLE `contract` DISABLE KEYS */;
INSERT INTO `contract` VALUES (1,'Revenue Sharing','1',1.2,1,NULL,'2018-04-29 10:36:39','PENDDING');
/*!40000 ALTER TABLE `contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract_contact`
--

DROP TABLE IF EXISTS `contract_contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contract_contact` (
  `contract_contract_id` int(11) NOT NULL,
  `contact_contact_id` int(11) NOT NULL,
  PRIMARY KEY (`contract_contract_id`,`contact_contact_id`),
  UNIQUE KEY `UK_7sborn7njybg9ys4dl3te3y69` (`contact_contact_id`),
  CONSTRAINT `FK9cxru7jv9aml1oh9fgwl8mrl8` FOREIGN KEY (`contact_contact_id`) REFERENCES `contact` (`contact_id`),
  CONSTRAINT `FKka6gdmxyma0pvw9h9y5lt4dpy` FOREIGN KEY (`contract_contract_id`) REFERENCES `contract` (`contract_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract_contact`
--

LOCK TABLES `contract_contact` WRITE;
/*!40000 ALTER TABLE `contract_contact` DISABLE KEYS */;
INSERT INTO `contract_contact` VALUES (1,1);
/*!40000 ALTER TABLE `contract_contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract_deals`
--

DROP TABLE IF EXISTS `contract_deals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contract_deals` (
  `contract_id` int(11) NOT NULL,
  `deal_id` int(11) NOT NULL,
  PRIMARY KEY (`contract_id`,`deal_id`),
  KEY `FKtq19t42yb00lb893dce75jwn3` (`deal_id`),
  CONSTRAINT `FKl419vlwtiftv9phnp85mmsq3x` FOREIGN KEY (`contract_id`) REFERENCES `contract` (`contract_id`),
  CONSTRAINT `FKtq19t42yb00lb893dce75jwn3` FOREIGN KEY (`deal_id`) REFERENCES `deal` (`deal_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract_deals`
--

LOCK TABLES `contract_deals` WRITE;
/*!40000 ALTER TABLE `contract_deals` DISABLE KEYS */;
INSERT INTO `contract_deals` VALUES (1,1),(1,2),(1,3);
/*!40000 ALTER TABLE `contract_deals` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract_mags`
--

DROP TABLE IF EXISTS `contract_mags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contract_mags` (
  `contract_id` int(11) NOT NULL,
  `mag_id` int(11) NOT NULL,
  PRIMARY KEY (`contract_id`,`mag_id`),
  KEY `FKs5u3v6nywaota775t6mxgs80j` (`mag_id`),
  CONSTRAINT `FK4x5rogrv8i5thq1jylt3r4pgg` FOREIGN KEY (`contract_id`) REFERENCES `contract` (`contract_id`),
  CONSTRAINT `FKs5u3v6nywaota775t6mxgs80j` FOREIGN KEY (`mag_id`) REFERENCES `mag` (`mag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract_mags`
--

LOCK TABLES `contract_mags` WRITE;
/*!40000 ALTER TABLE `contract_mags` DISABLE KEYS */;
INSERT INTO `contract_mags` VALUES (1,1),(1,2);
/*!40000 ALTER TABLE `contract_mags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deal`
--

DROP TABLE IF EXISTS `deal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deal` (
  `deal_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `poid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`deal_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deal`
--

LOCK TABLES `deal` WRITE;
/*!40000 ALTER TABLE `deal` DISABLE KEYS */;
INSERT INTO `deal` VALUES (1,'bac_iptv_monthly','4272156'),(2,'bac_util_power','4461432'),(3,'bac_util_water','4463480'),(4,'bac_retail_annually_lag','3782842'),(5,'bac_retail_monthly_lag','3781818'),(6,'bac_retail_mag','3783866'),(7,'bac_rental_monthly','4309250');
/*!40000 ALTER TABLE `deal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mag`
--

DROP TABLE IF EXISTS `mag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mag` (
  `mag_id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` bigint(20) DEFAULT NULL,
  `valid_from` datetime DEFAULT NULL,
  `valid_to` datetime DEFAULT NULL,
  PRIMARY KEY (`mag_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mag`
--

LOCK TABLES `mag` WRITE;
/*!40000 ALTER TABLE `mag` DISABLE KEYS */;
INSERT INTO `mag` VALUES (1,3,'2018-04-29 10:36:39','2019-04-29 10:36:39'),(2,5,'2019-04-29 10:36:39','2020-04-29 10:36:39');
/*!40000 ALTER TABLE `mag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ADMIN'),(2,'USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `active` int(11) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2,1,'ahmedyehiamokhtar@gmail.com','Ahmed Yehia mokhtar','$2a$10$9Q4Aooth/1uQDQyXMg406.UVvsnvZUin8misAcOgfMNYtml8MaQ4i'),(3,1,'ahmedeldeeb@gmail.com','Ahmed','$2a$10$yrNtsOpwfdmZlBnT./L08e2jPghBgpDF/w125uhxrsdFJIm.EGdCG'),(4,1,'abdoelsayed@gmail.com','abdoelsayed','$2a$10$w6fdl0pb8P1tkORFYVNuquR9Ss6/Z9.EosC6lOxe.8K0jyFVw4HOa'),(5,1,'eng.ahmedyehia93@gmail.com','AhmedYehia93','$2a$10$YMB/9cWlYkNGmHGYf3HZfOZ54t3K.WXpGt5MNQDPbcB5I2YzTSMc2');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (2,1),(3,1),(5,1);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-10  3:50:23
