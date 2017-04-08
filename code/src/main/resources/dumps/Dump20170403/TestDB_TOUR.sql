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
-- Table structure for table `TOUR`
--

DROP TABLE IF EXISTS `TOUR`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TOUR` (
  `ID_TOUR` int(11) NOT NULL AUTO_INCREMENT,
  `CANCEL_OR_NOT` bit(1) NOT NULL,
  `DATE_ALLOW_CANCEL` date NOT NULL,
  `DATE_ALLOW_REG` date NOT NULL,
  `DEPARTURE_DATE` date NOT NULL,
  `DEPARTURE_TIME` varchar(10) NOT NULL,
  `DETAIL` varchar(2000) NOT NULL,
  `FIELD_ADDRESS` bit(1) NOT NULL,
  `FIELD_EMAIL` bit(1) NOT NULL,
  `FIELD_IDCARD` bit(1) NOT NULL,
  `FIELD_NAME` bit(1) NOT NULL,
  `FIELD_NUMOFTICKET` bit(1) NOT NULL,
  `FIELD_PHONE` bit(1) NOT NULL,
  `FIELD_SEX` bit(1) NOT NULL,
  `FULL_OR_NOT` bit(1) NOT NULL,
  `IMAGE` varchar(200) DEFAULT NULL,
  `NAME` varchar(50) NOT NULL,
  `PRICE` varchar(255) NOT NULL,
  `QUANTUM` int(11) NOT NULL,
  `REG_OR_NOT` bit(1) NOT NULL,
  `RETURN_DATE` date NOT NULL,
  `RETURN_TIME` varchar(10) NOT NULL,
  `TICKET_AVAILABILITY` int(11) NOT NULL,
  PRIMARY KEY (`ID_TOUR`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TOUR`
--

LOCK TABLES `TOUR` WRITE;
/*!40000 ALTER TABLE `TOUR` DISABLE KEYS */;
INSERT INTO `TOUR` VALUES (1,'','2017-04-11','2017-04-05','2017-04-10','19:00','<p><strong>N&uacute;i Thủy Đ&agrave;i Sơn (n&uacute;i Nước): </strong> N&uacute;i Thủy Đ&agrave;i Sơn nằm c&aacute;ch thị trấn Ba Ch&uacute;c chừng 2km về ph&iacute;a đi ra ng&atilde; ba Lạc Quới. N&uacute;i Thủy Đ&agrave;i Sơn l&agrave; ngọn n&uacute;i nhỏ nhất, v&agrave; cũng l&agrave; thấp nhất trong d&atilde;y Thất Sơn, với độ cao chỉ 20m. Xung quanh h&ograve;n n&uacute;i n&agrave;y khung cảnh thật đẹp, với những c&aacute;nh đồng l&uacute;a ch&iacute;n v&agrave;ng tươi, xa xa l&agrave; d&atilde;y n&uacute;i Ngọa Long Sơn ( n&uacute;i D&agrave;i) nằm ngang ph&iacute;a trước.</p>\r\n<p>V&agrave;o m&ugrave;a lũ, nơi đ&acirc;y c&agrave;ng tuyệt vời hơn, v&igrave; xung quanh l&agrave; một biển nước m&ecirc;nh m&ocirc;ng, chỉ c&ograve;n lại một h&ograve;n n&uacute;i nho nhỏ nằm trơ trọi b&ecirc;n những cơn s&oacute;ng. D&ugrave; ở độ cao khi&ecirc;m tốn, do nằm ở một khoảng kh&ocirc;ng rất rộng r&atilde;i, l&uacute;c n&agrave;o gi&oacute; nơi đ&acirc;y cũng thổi đến rất nhiều, tạo n&ecirc;n kh&ocirc;ng gian tho&aacute;ng đ&atilde;ng v&agrave; m&aacute;t mẻ tr&ecirc;n đỉnh n&uacute;i. Điều đặc biệt l&agrave; những phiến đ&aacute; nơi đ&acirc;y rất b&oacute;ng nhẵn v&agrave; phẳng như b&agrave;n thạch. Từ thời xa xưa, ngọn n&uacute;i n&agrave;y đ&atilde; từng nằm dưới mặt nước trong một thời gian rất d&agrave;i, n&ecirc;n &aacute;p lực của nước đ&atilde; t&aacute;c động tr&ecirc;n những phiến đ&aacute;, tạo n&ecirc;n những mặt phẳng thật đẹp.</p>','','','\0','','','','','\0','Bay-ngon-nui-trong-day-That-Son-o-An-Giang-ivivu-8.jpg','Du lịch An Giang khám phá Thất Sơn','500,000',10,'','2017-04-14','16:00',9),(2,'','2017-04-10','2017-04-06','2017-04-04','19:00','<p>Với mục đ&iacute;ch tạo ra một kh&ocirc;ng kh&iacute; mới cho một chuyến đi mang nhiều &yacute; nghĩa, NAM BỘ Travel xin giới thiệu đến qu&yacute; kh&aacute;ch tour du lịch Nh&agrave; thờ Cha Diệp &ndash; ch&ugrave;a B&agrave; Nam Hải &ndash; ch&ugrave;a Dơi (1 ng&agrave;y 1 đ&ecirc;m). Hy vọng qu&yacute; kh&aacute;ch sẽ c&oacute; những trải nghiệm th&uacute; vị kh&ocirc;ng chỉ về cảnh quan m&agrave; c&ograve;n&nbsp; được tiếp cận v&agrave; t&igrave;m hiểu hai t&ocirc;n gi&aacute;o lớn ở Việt Nam l&agrave; Đạo Phật v&agrave; Thi&ecirc;n Ch&uacute;a Gi&aacute;o.</p>\r\n<p>Xe v&agrave; HDV của NAM BỘ&nbsp; TRAVEL đ&oacute;n kh&aacute;ch tại điểm hẹn &ndash; khởi h&agrave;nh từ Tp. HCM&nbsp; l&uacute;c 22giờ &ndash; đi nh&agrave; thờ Cha Diệp, ngủ đ&ecirc;m tr&ecirc;n xe &ndash; dừng ch&acirc;n ở Cai Lậy, d&ugrave;ng điểm t&acirc;m s&aacute;ng, tham quan Nh&agrave; thờ Cha Diệp &ndash; đi Bạc Li&ecirc;u, thăm Đức Mẹ Long Hải &ndash; đi Ch&ugrave;a Dơi &ndash; d&ugrave;ng cơm trưa &ndash; về Tp. HCM.</p>\r\n<p>Nh&agrave; Thờ Cha Diệp (Nh&agrave; thờ Tắc Sậy) &ndash; nơi gắn liền với một nh&acirc;n vật nổi tiếng &ndash;&nbsp; cha Trương Bửu Diệp, vị linh mục được xem như một vị th&aacute;nh v&igrave; sự linh thi&ecirc;ng, thi &acirc;n gi&aacute;ng ph&uacute;c cho những ai tin tưởng nguyện cầu. Nơi đ&acirc;y kh&ocirc;ng chỉ l&agrave; điểm h&agrave;nh hương của người miền T&acirc;y m&agrave; c&ograve;n của d&acirc;n C&ocirc;ng gi&aacute;o ở nhiều v&ugrave;ng miền kh&aacute;c. Nh&agrave; thờ hiện c&ograve;n l&agrave; Trung t&acirc;m Truyền gi&aacute;o Phanxic&ocirc; của Gi&aacute;o phận. Qu&yacute; kh&aacute;ch tham quan, viếng mộ Cha Phaxico Xavi&ecirc; Trương Bửu Diệp, cầu nguyện, xin ơn,&hellip; cảm nhận được kh&ocirc;ng kh&iacute; trang nghi&ecirc;m v&agrave; thi&ecirc;ng li&ecirc;ng của nơi n&agrave;y, t&igrave;m hiểu v&agrave; biết th&ecirc;m về Đạo Thi&ecirc;n Ch&uacute;a Gi&aacute;o.</p>','','','\0','','','','','\0','42562226.jpg','Du lịch Nhà Thờ Cha Diệp – Chùa Bà Nam Hải','5,000,000',10,'','2017-04-12','19:00',9),(3,'','2017-04-09','2017-04-05','2017-04-10','7:00','<p style=\"text-align: justify;\">Nếu qu&yacute; kh&aacute;ch đ&atilde; qu&aacute; quen với những cảnh đẹp thi&ecirc;n nhi&ecirc;n của n&uacute;i non, s&ocirc;ng nước th&igrave; sự h&ugrave;ng vĩ v&agrave; tr&aacute;ng lệ của những c&ocirc;ng tr&igrave;nh kiến tr&uacute;c sẽ l&agrave; những trải nghiệm mới v&ocirc; c&ugrave;ng th&uacute; vị cho qu&yacute; kh&aacute;ch đấy. Đứng trước những quần thể kiến tr&uacute;c lớn về cả qui m&ocirc; v&agrave; &ldquo;lớn&rdquo; cả về bề d&agrave;y lịch sử, t&acirc;m hồn qu&yacute; kh&aacute;ch kh&ocirc;ng những được thư th&aacute;i v&agrave; thoải m&aacute;i m&agrave; c&ograve;n l&agrave; cơ hội để qu&yacute; kh&aacute;ch hiểu hơn về &yacute; nghĩa của những &ldquo;t&agrave;i sản&rdquo; qu&iacute; gi&aacute; của d&acirc;n tộc. Chương tr&igrave;nh lần n&agrave;y, <strong>NAM BỘ TRAVEL</strong> sẽ đưa qu&yacute; kh&aacute;ch đến với khu du lịch t&acirc;m linh &ndash; Lạc cảnh Đại Nam Văn Hiến được xem l&agrave; khu du lịch lớn nhất Đ&ocirc;ng Nam &Aacute; về diện t&iacute;ch. Với tour du lịch Đại Nam 1 ng&agrave;y qu&yacute; kh&aacute;ch sẽ th&ecirc;m tự h&agrave;o về một Việt Nam tươi đẹp. Đừng bỏ lỡ qua cơ hội n&agrave;y nh&eacute;!</p>\r\n<p style=\"text-align: justify;\">Nổi bật:</p>\r\n<p style=\"text-align: justify;\">Tham quan Khu Kim Điện, Bảo Th&aacute;p, D&ograve;ng Bảo Giang, D&atilde;y n&uacute;i Ngũ H&agrave;nh Sơn</p>\r\n<p style=\"text-align: justify;\">Tham quan Vườn Th&uacute; Đại Nam</p>','','','\0','','','','','\0','dscn3681.jpg','Du Lịch Đại Nam ','2,000,000',10,'','2017-03-12','17:00',9);
/*!40000 ALTER TABLE `TOUR` ENABLE KEYS */;
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
