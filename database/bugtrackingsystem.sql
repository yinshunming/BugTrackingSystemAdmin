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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buginfo`
--

LOCK TABLES `buginfo` WRITE;
/*!40000 ALTER TABLE `buginfo` DISABLE KEYS */;
INSERT INTO `buginfo` VALUES (18,'0364881','G11n: I18n: SC: The text template in username label doesn’t disappear after pressing Shift key when using default Chinese input method on Win8x64 with Firefox 18.0.','Receiver for Web','Failure','Assigned','<[1359975102]> - Weitao Shen (3P):<br>--Repro Steps:<br>1. Prepared XA setup with Archer RTM build on SC Windows 2008R2 SP1.<br>2. Published some apps.<br>3. Prepared Storefront setup with build 46 on SC Windows 2012.<br>4. Hosted Store on above XA setup and create Web Receiver site.<br>5. From Windows 8 X64 client machine, browsed to WR site with Firefox 18.0.<br>7. Typed some words into username label using default Chinese input method.<br>8. Pressed Shift key and checked the text template in username label.<br><br>--Expected Result:<br>After press Shift key once time, English letters should be selected and inputted into username label, the text template should be disappears,<br><br>--Actual Result:<br>After pressed Shift key, English letters was selected and seems to be inputted into username label.<br>But at this time, the text template didn’t disappear and overlapping occurred.<br>After pressed Shift key again, the text template disappeared.<br><br>--Issue occurring on language:<br>SC: Win8x64 with Firefox 18.0: Fail<br>SC: Win8x64 with IE10: Pass<br>SC: Win7x86 with Firefox 18.0: Pass <br>SC: Win7x86 with IE9: Pass<br><br>--Note:<br>1. This issue is only reproduced in Win8x64 with Firefox in SC when using default Chinese input method.<br>2. When using a popular Chinese input method like “Sougou Pinyin”, this issue is not happened in Win8x64 with Firefox.<br><br>--Environment details:<br>XenApp: Archer RTM<br>Receiver Storefront: Build 46								 <br>Windows Receiver: Zeus4 RTM									             <br>Web Receiver OS: Win8x64								              <br>Browser: Firefox 18.0									               <br>Language: SC<br><br>--Contract person:<br>Weitao.shen@pactera.com                                                                                                  <br>CC:Shally.Garg@Citrix.com<br><br><[1365580671]> - Dariusz Sczcepaniak:<br>comment from Jun Zhang:<br><br>This issue isn’t a big problem, frankly I doubt whether end-user can find the difference.<br>This bug is similar to BUG0330993  and we believe they have the same root cause: IME and browser can’t match well, because of background signals are not triggered. <br>EphramW will work on BUG0330993 solution soon, and will update you once any founding.','Vincent Huang','Weitao Shen (3P)','2013-02-04 10:51:42','S4 - Low','','No',NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ownerbugs`
--

LOCK TABLES `ownerbugs` WRITE;
/*!40000 ALTER TABLE `ownerbugs` DISABLE KEYS */;
INSERT INTO `ownerbugs` VALUES (1,4,18,0,0);
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo`
--

LOCK TABLES `userinfo` WRITE;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` VALUES (4,'admin','admin','Vincent Huang','yin-shun-ming@163.com');
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

-- Dump completed on 2014-02-11 16:28:51
