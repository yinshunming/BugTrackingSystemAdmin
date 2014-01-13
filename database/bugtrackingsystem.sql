-- MySQL dump 10.13  Distrib 5.6.14, for Win64 (x86_64)
--
-- Host: localhost    Database: bugtrackingsystem
-- ------------------------------------------------------
-- Server version	5.6.14

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
-- Table structure for table `buginfo`
--

DROP TABLE IF EXISTS `buginfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `buginfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bugId` varchar(255) DEFAULT NULL,
  `title` varchar(500) DEFAULT NULL,
  `project` varchar(500) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `description` text,
  `owner` varchar(255) DEFAULT NULL,
  `submitter` varchar(255) DEFAULT NULL,
  `submitData` datetime DEFAULT NULL,
  `severity` varchar(255) DEFAULT NULL,
  `tags` varchar(255) DEFAULT NULL,
  `regression` varchar(255) DEFAULT NULL,
  `component` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buginfo`
--

LOCK TABLES `buginfo` WRITE;
/*!40000 ALTER TABLE `buginfo` DISABLE KEYS */;
INSERT INTO `buginfo` VALUES (1,'0410174','G11N: JA: The title in the PDF document exported from Trends page of Director gets truncated.','Jasper','Failure','Assigned','<[1376535206]> - Jingjing Mao (3P):\r\nContact person:\r\n=============\r\nTest Engineer email ID: jingjing.mao@pactera.com (cc:Hideaki.Fujiwara@citrix.co.jp)\r\n\r\nEnvironment:\r\n=======\r\nController: JA WS2012R2 + Bruin #4010\r\nClient: JA Win8.1-32 + Bruin #4010\r\nBrowser: IE 11\r\n\r\nRepro steps:\r\n=======\r\n1. Prepare XenDesktop environment.\r\n2. Publish VDI desktop and RDS desktop.\r\n3. Open Desktop Director.\r\n4. Navigate to Trends page.\r\n5. Under Session tab, randomly select a Time period and click Apply button.\r\n6. Click “Export graph(PDF)” button and open the PDF document\r\n7. Make sure the title of PDF document gets truncated. (See “JA_Bruin#4010_Session.pdf”)\r\n\r\nAddition Info:\r\n=======\r\n1. It is not reproduced on Excalibur RTM.\r\n2. It is also reproduced under Connection tab, Failed Desktop OS Machines tab, Failed Server OS Machines tab, Logon Performance tab, Load Evaluator Index tab.\r\n3. It is also reproduced if client is JA Win8-32 (IE 10).\r\n\r\n<[1379468137]> - Ning Wang:\r\nthis issue reproduces in WS2012r2\r\n\r\n<[1380177842]> - Ning Wang:\r\npostship reason: only reproduce if ddc is WS2012R2.\r\ncustomer impact: low.\r\nworkaround: none.','1','Jingjing Mao (3P)','2013-08-15 02:53:26','S3 - Medium','G11N, I18N','Yes',NULL);
/*!40000 ALTER TABLE `buginfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `managedbugs`
--

DROP TABLE IF EXISTS `managedbugs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `managedbugs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userInfoId` int(11) DEFAULT NULL,
  `bugInfoId` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT '0' COMMENT '0 represents not deleted. 1 represents having been deleted',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique` (`userInfoId`,`bugInfoId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `managedbugs`
--

LOCK TABLES `managedbugs` WRITE;
/*!40000 ALTER TABLE `managedbugs` DISABLE KEYS */;
/*!40000 ALTER TABLE `managedbugs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ownerbugs`
--

DROP TABLE IF EXISTS `ownerbugs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ownerbugs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userInfoId` int(11) DEFAULT NULL,
  `bugInfoId` int(11) DEFAULT NULL,
  `status` int(2) DEFAULT '0',
  `changed` int(2) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique` (`userInfoId`,`bugInfoId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ownerbugs`
--

LOCK TABLES `ownerbugs` WRITE;
/*!40000 ALTER TABLE `ownerbugs` DISABLE KEYS */;
INSERT INTO `ownerbugs` VALUES (1,1,1,1,1);
/*!40000 ALTER TABLE `ownerbugs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinfo`
--

DROP TABLE IF EXISTS `userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `oneBugFullName` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo`
--

LOCK TABLES `userinfo` WRITE;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` VALUES (1,'1','1','1','1');
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-01-13 10:32:20
