-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: localhost    Database: testdb
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `ID_USER` int(11) NOT NULL AUTO_INCREMENT,
  `ADDRESS` varchar(100) DEFAULT NULL,
  `BIRTHDAY` date DEFAULT NULL,
  `DATE_RES` date DEFAULT NULL,
  `ROLE` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(100) DEFAULT NULL,
  `FULL_NAME` varchar(60) NOT NULL,
  `PASSWORD` varchar(20) NOT NULL,
  `PHONE` varchar(13) DEFAULT NULL,
  `SEX` varchar(5) DEFAULT NULL,
  `TIME_RES` time DEFAULT NULL,
  `USER_NAME` varchar(40) NOT NULL,
  `ID_ROLE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_USER`),
  KEY `FK_od2qnwuhcdnrylt692ty17f5k` (`ID_ROLE`),
  CONSTRAINT `FK_od2qnwuhcdnrylt692ty17f5k` FOREIGN KEY (`ID_ROLE`) REFERENCES `role` (`ID_ROLE`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Can Tho','1995-02-14','2017-03-14','Người quản lý','administrator1@email.com','Administrator','MTIzNA==','0928172123','Nam','08:21:12','admin',2),(2,'Can Tho','1995-02-02','2017-03-14','Khách hàng','user1@email.com','UserNameA','MTIzNDU2Nzg=','0928172120','Nam','08:21:12','customer',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-29 14:08:27
