CREATE DATABASE  IF NOT EXISTS `TestDB` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `TestDB`;
-- MySQL dump 10.13  Distrib 5.5.54, for debian-linux-gnu (i686)
--
-- Host: localhost    Database: TestDB
-- ------------------------------------------------------
-- Server version	5.5.54-0+deb8u1

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
-- Table structure for table `USER`
--

DROP TABLE IF EXISTS `USER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER` (
  `ID_USER` int(11) NOT NULL AUTO_INCREMENT,
  `ADDRESS` varchar(100) DEFAULT NULL,
  `BIRTHDAY` date DEFAULT NULL,
  `DATE_RES` date DEFAULT NULL,
  `EMAIL` varchar(100) DEFAULT NULL,
  `FULL_NAME` varchar(60) NOT NULL,
  `PASSWORD` varchar(20) NOT NULL,
  `PHONE` varchar(255) DEFAULT NULL,
  `SEX` varchar(255) DEFAULT NULL,
  `TIME_RES` time DEFAULT NULL,
  `USER_NAME` varchar(40) NOT NULL,
  `ID_ROLE` int(11) NOT NULL,
  `ROLE` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`ID_USER`),
  KEY `FK_od2qnwuhcdnrylt692ty17f5k` (`ID_ROLE`),
  CONSTRAINT `FK_od2qnwuhcdnrylt692ty17f5k` FOREIGN KEY (`ID_ROLE`) REFERENCES `ROLE` (`ID_ROLE`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER`
--

LOCK TABLES `USER` WRITE;
/*!40000 ALTER TABLE `USER` DISABLE KEYS */;
INSERT INTO `USER` VALUES (1,'Can Tho','1995-02-14','2017-03-14','administrator1@email.com','Administrator','MTIzNA==','092817212','Nam','08:21:12','admin',2,'Quản trị viên'),(2,'Can Tho','1995-02-14','2017-03-14','user1@email.com','UserNameA','MTIzNDU2Nzg=','092817212','Nam','08:21:12','usernamea',1,'Khách hàng'),(3,'190/2 Ä�Æ°á»�ng 30/4, HÆ°ng Lá»£i, Ninh Kiá»�u, Cáº§n ThÆ¡','1990-03-08','2017-03-31','ribostrush@gmail.com','LÃª ThÃ nh NhÃ¢n','MTIzNDU2Nzg=','01203267006','Nam','13:30:09','ltn09244',1,'Khách hàng'),(4,'190/2, 30/4, Xuan Khanh, Ninh Kieu, Can Tho','1995-03-10','2017-03-31','pc.nt95@gmail.com','LÃª NhÆ° Ã�','MTIzNDU2Nzg=','01203267006','Nam','14:21:23','lny09244',1,'Khách hàng'),(5,'190/2, 30/4, Xuan Khanh, Ninh Kieu, Can Tho','1995-03-10','2017-03-31','pc.nt95@gmail.com','LÃª NhÆ° Ã�','MTIzNDU2Nzg=','01203267006','Nam','14:23:13','lny09244',1,'Khách hàng'),(6,'190/2 Ä�Æ°á»�ng 30/4, HÆ°ng Lá»£i, Ninh Kiá»�u, Cáº§n ThÆ¡','2017-03-14','2017-03-31','ribostrush@gmail.com','LÃª NhÆ° Ã�','MTIzNDU2Nzg=','01203267006','Nam','15:19:45','nly09244',1,'Khách hàng'),(7,'190/2 Ä�Æ°á»�ng 30/4, HÆ°ng Lá»£i, Ninh Kiá»�u, Cáº§n ThÆ¡','1994-04-11','2017-04-03','pc.nt95@gmail.com','Tráº§n Anh TÃº','MTIzNDU2Nzg=','09273723611','Nam','21:46:45','tat09244',1,'Khách hàng');
/*!40000 ALTER TABLE `USER` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-03 22:01:19
