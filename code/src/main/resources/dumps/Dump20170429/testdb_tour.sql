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
-- Table structure for table `tour`
--

DROP TABLE IF EXISTS `tour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tour` (
  `ID_TOUR` int(11) NOT NULL AUTO_INCREMENT,
  `CANCEL_OR_NOT` bit(1) NOT NULL,
  `DATE_ALLOW_CANCEL` date NOT NULL,
  `DATE_ALLOW_REG` date NOT NULL,
  `DEPARTURE_DATE` date NOT NULL,
  `DEPARTURE_TIME` varchar(10) NOT NULL,
  `DETAIL` varchar(5000) NOT NULL,
  `FIELD_ADDRESS` bit(1) NOT NULL,
  `FIELD_EMAIL` bit(1) NOT NULL,
  `FIELD_IDCARD` bit(1) NOT NULL,
  `FIELD_NAME` bit(1) NOT NULL,
  `FIELD_NUMOFTICKET` bit(1) NOT NULL,
  `FIELD_PHONE` bit(1) NOT NULL,
  `FIELD_SEX` bit(1) NOT NULL,
  `FIELD_YEAROFBIRTH` bit(1) NOT NULL,
  `FULL_OR_NOT` bit(1) NOT NULL,
  `HOW_LONG` int(11) DEFAULT NULL,
  `IMAGE` varchar(200) DEFAULT NULL,
  `NAME` varchar(200) NOT NULL,
  `PRICE` varchar(255) NOT NULL,
  `PRICE_AFTER_SALE` varchar(255) DEFAULT NULL,
  `QUANTUM` int(11) NOT NULL,
  `REG_OR_NOT` bit(1) NOT NULL,
  `RETURN_DATE` date NOT NULL,
  `RETURN_TIME` varchar(10) NOT NULL,
  `TICKET_AVAILABILITY` int(11) NOT NULL,
  `VIEW` int(11) NOT NULL,
  PRIMARY KEY (`ID_TOUR`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tour`
--

LOCK TABLES `tour` WRITE;
/*!40000 ALTER TABLE `tour` DISABLE KEYS */;
INSERT INTO `tour` VALUES (1,'','2017-05-01','2017-04-30','2017-05-02','6:00','<p>Với mục đ&iacute;ch tạo ra một kh&ocirc;ng kh&iacute; mới cho một chuyến đi mang nhiều &yacute; nghĩa, NY Travel xin giới thiệu đến qu&yacute; kh&aacute;ch tour du lịch Nh&agrave; thờ Cha Diệp &ndash; ch&ugrave;a B&agrave; Nam Hải &ndash; ch&ugrave;a Dơi (1 ng&agrave;y 1 đ&ecirc;m). Hy vọng qu&yacute; kh&aacute;ch sẽ c&oacute; những trải nghiệm th&uacute; vị kh&ocirc;ng chỉ về cảnh quan m&agrave; c&ograve;n&nbsp; được tiếp cận v&agrave; t&igrave;m hiểu hai t&ocirc;n gi&aacute;o lớn ở Việt Nam l&agrave; Đạo Phật v&agrave; Thi&ecirc;n Ch&uacute;a Gi&aacute;o.</p>\r\n<p>Nh&agrave; Thờ Cha Diệp (Nh&agrave; thờ Tắc Sậy) &ndash; nơi gắn liền với một nh&acirc;n vật nổi tiếng &ndash;&nbsp; cha Trương Bửu Diệp, vị linh mục được xem như một vị th&aacute;nh v&igrave; sự linh thi&ecirc;ng, thi &acirc;n gi&aacute;ng ph&uacute;c cho những ai tin tưởng nguyện cầu. Nơi đ&acirc;y kh&ocirc;ng chỉ l&agrave; điểm h&agrave;nh hương của người miền T&acirc;y m&agrave; c&ograve;n của d&acirc;n C&ocirc;ng gi&aacute;o ở nhiều v&ugrave;ng miền kh&aacute;c. Nh&agrave; thờ hiện c&ograve;n l&agrave; Trung t&acirc;m Truyền gi&aacute;o Phanxic&ocirc; của Gi&aacute;o phận. Qu&yacute; kh&aacute;ch tham quan, viếng mộ Cha Phaxico Xavi&ecirc; Trương Bửu Diệp, cầu nguyện, xin ơn,&hellip; cảm nhận được kh&ocirc;ng kh&iacute; trang nghi&ecirc;m v&agrave; thi&ecirc;ng li&ecirc;ng của nơi n&agrave;y, t&igrave;m hiểu v&agrave; biết th&ecirc;m về Đạo Thi&ecirc;n Ch&uacute;a Gi&aacute;o.<br /> Sau khi tham quan Nh&agrave; thờ Cha Diệp, Qu&yacute; kh&aacute;ch l&ecirc;n đường đi Bạc Li&ecirc;u, gh&eacute; thăm Đức Mẹ Long Hải, ch&ugrave;a Dơi. Ch&ugrave;a Dơi (Waths&ecirc;r&acirc;ytecho Mahatup) &ndash; một trong những danh thắng nổi tiếng của S&oacute;c Trăng, nơi cư ngụ của h&agrave;ng ngh&igrave;n con dơi. Theo người Khmer, Mahatup l&agrave; trận kh&aacute;ng cự lớn (Tup: kh&aacute;ng cự; Maha: lớn). Nơi đ&acirc;y đ&atilde; diễn ra một trận đ&aacute;nh &aacute;c liệt của phong tr&agrave;o n&ocirc;ng d&acirc;n nổi dậy chống bọn phong kiến ng&agrave;y xưa. Sau trận đ&aacute;nh đ&oacute;, d&acirc;n ch&uacute;ng tản cư trở về sinh sống, họ cho rằng v&ugrave;ng đất n&agrave;y c&oacute; điềm l&agrave;nh (đất l&agrave;nh) n&ecirc;n x&acirc;y ch&ugrave;a thờ Phật, bởi họ tin rằng nếu&nbsp; được đấng tối cao che chở th&igrave; mọi chuyện trong cuộc sống của họ sẽ b&igrave;nh y&ecirc;n, họ sẽ gi&agrave;nh chiến thắng trong c&aacute;c trận đ&aacute;nh,&hellip; Đến Ch&ugrave;a Dơi, Qu&yacute; kh&aacute;ch sẽ được chi&ecirc;m ngưỡng một quần thể kiến tr&uacute;c đẹp, gần gũi với thi&ecirc;n nhi&ecirc;n, t&igrave;m hiểu về Phật gi&aacute;o Nam T&ocirc;ng của đồng b&agrave;o Khmer với phương ch&acirc;m &ldquo; tốt đời &ndash; đẹp đạo&rdquo;, Qu&yacute; kh&aacute;ch c&oacute; th&ecirc;m vốn kiến thức về đời sống t&acirc;m linh của người theo Đạo Phật,..</p>\r\n<p>Chia tay Ch&ugrave;a Dơi, về lại th&agrave;nh phố Hồ Ch&iacute; Minh, hy vọng Qu&yacute; kh&aacute;ch đ&atilde; c&oacute; một h&agrave;nh tr&igrave;nh đ&aacute;ng nhớ. Hẹn gặp lại Qu&yacute; kh&aacute;ch v&agrave;o những chuyến đi kế tiếp c&ugrave;ng với NY&nbsp; TRAVEL!</p>','','','\0','','','','','','\0',2,'0623490chadiep.jpg','Thờ Cha Diệp – Chùa Bà Nam Hải – Chùa Dơi','1,600,000','1,600,000',50,'','2017-05-04','19:00',50,4),(2,'\0','2017-04-05','2017-04-30','2017-05-06','8:15','<p><a href=\"https://www.ivivu.com/khach-san-vung-tau?utm_source=blog_rightbox&amp;utm_medium=suggested_regions&amp;utm_campaign=internal\" target=\"_blank\" rel=\"noopener noreferrer\"><strong>Vũng T&agrave;u</strong></a> l&agrave; th&agrave;nh phố biển thuộc tỉnh B&agrave; Rịa &ndash; Vũng T&agrave;u. B&atilde;i Sau l&agrave; b&atilde;i biển thường được kh&aacute;ch du lịch Vũng T&agrave;u lựa chọn để tắm biến nhất. Ngo&agrave;i ra, Vũng T&agrave;u cũng c&oacute; những điểm tham quan đ&aacute;ng ch&uacute; &yacute; như Tượng Ch&uacute;a Kit&ocirc; Vua tr&ecirc;n n&uacute;i Nhỏ, Ch&ugrave;a Th&iacute;ch Ca Phật Đ&agrave;i v&agrave; t&ograve;a Bạch Dinh nằm s&aacute;t biển. Lễ hội Nghinh &Ocirc;ng v&agrave; lễ hội Dinh C&ocirc; l&agrave; hai lễ hội văn h&oacute;a nổi bật nhất của Vũng T&agrave;u.&nbsp;</p>\r\n<div style=\"position: absolute; left: -99999px;\">Du lich Vũng T&agrave;u: Những cung đường biển đẹp như mơ, ngọn Hải đăng cổ nổi tiếng, tượng Ch&uacute;a giang tay b&igrave;nh y&ecirc;n, những g&oacute;c phố thơ mộng, c&ugrave;ng những m&oacute;n ăn hấp dẫn l&agrave; những g&igrave; du kh&aacute;ch kh&ocirc;ng thể bỏ qua khi đến với Vũng T&agrave;u. Vũng T&agrave;u trở th&agrave;nh đ&ocirc; thị loại I năm 2013, l&agrave; một th&agrave;nh phố đ&aacute;ng tới, đ&aacute;ng sống v&agrave; hạnh ph&uacute;c. <br /><br /> Xem nội dung đầy đủ tại: <a href=\"https://travel.com.vn/du-lich-vung-tau.aspx\">https://travel.com.vn/du-lich-vung-tau.aspx</a><br />Nguồn: travel.com.vn</div>','','','\0','','','','','','\0',2,'Quick-Guide-Rach-Gia.jpg','Du Lịch Vũng Tàu ','2,100,000','2,100,000',20,'','2017-05-08','21:00',13,8),(3,'','2017-05-09','2017-04-30','2017-05-10','10:00','<p style=\"text-align: justify;\">Nếu qu&yacute; kh&aacute;ch đ&atilde; qu&aacute; quen với những cảnh đẹp thi&ecirc;n nhi&ecirc;n của n&uacute;i non, s&ocirc;ng nước th&igrave; sự h&ugrave;ng vĩ v&agrave; tr&aacute;ng lệ của những c&ocirc;ng tr&igrave;nh kiến tr&uacute;c sẽ l&agrave; những trải nghiệm mới v&ocirc; c&ugrave;ng th&uacute; vị cho qu&yacute; kh&aacute;ch đấy. Đứng trước những quần thể kiến tr&uacute;c lớn về cả qui m&ocirc; v&agrave; &ldquo;lớn&rdquo; cả về bề d&agrave;y lịch sử, t&acirc;m hồn qu&yacute; kh&aacute;ch kh&ocirc;ng những được thư th&aacute;i v&agrave; thoải m&aacute;i m&agrave; c&ograve;n l&agrave; cơ hội để qu&yacute; kh&aacute;ch hiểu hơn về &yacute; nghĩa của những &ldquo;t&agrave;i sản&rdquo; qu&iacute; gi&aacute; của d&acirc;n tộc. Chương tr&igrave;nh lần n&agrave;y, <strong>NYTRAVEL</strong> sẽ đưa qu&yacute; kh&aacute;ch đến với khu du lịch t&acirc;m linh &ndash; Lạc cảnh Đại Nam Văn Hiến được xem l&agrave; khu du lịch lớn nhất Đ&ocirc;ng Nam &Aacute; về diện t&iacute;ch. Với tour du lịch Đại Nam 1 ng&agrave;y qu&yacute; kh&aacute;ch sẽ th&ecirc;m tự h&agrave;o về một Việt Nam tươi đẹp. Đừng bỏ lỡ qua cơ hội n&agrave;y nh&eacute;!</p>\r\n<p style=\"text-align: justify;\">Nổi bật:</p>\r\n<p style=\"text-align: justify;\">Tham quan Khu Kim Điện, Bảo Th&aacute;p, D&ograve;ng Bảo Giang, D&atilde;y n&uacute;i Ngũ H&agrave;nh Sơn</p>\r\n<p style=\"text-align: justify;\">Tham quan Vườn Th&uacute; Đại Nam</p>\r\n<p style=\"text-align: justify;\">Khu Vui Chơi Giải Tr&iacute;</p>\r\n<p style=\"text-align: justify;\">Tham quan tắm Biển Đại Nam</p>\r\n<p style=\"text-align: justify;\">Biển Đại Nam bao gồm 2 khu vực: khu vực Biển nước ngọt v&agrave; khu vực Biển nước mặn</p>','','','\0','','','','','','\0',-29,'dai-_nam_2_WOJO.jpg','Du Lịch Đại Nam','500,000','500,000',100,'','2017-04-11','17:00',100,2),(4,'','2017-05-15','2017-04-30','2017-05-16','6:00','<p>Ven theo những tuyến đường hay xu&ocirc;i d&ograve;ng Cửu Long Giang, du kh&aacute;ch kh&ocirc;ng chỉ được kh&aacute;m ph&aacute; những cung đường v&agrave;ng nắng ở H&agrave; Ti&ecirc;n &ndash; Rạch Gi&aacute;, hay vỡ &ograve;a trước n&eacute;t thần ti&ecirc;n, tuyệt diệu ở Ph&uacute; Quốc ngo&agrave;i đảo xa, hay đ&ocirc;i ch&uacute;t lắng l&ograve;ng với những c&acirc;u chuyện lịch sử, những sự tịch k&igrave; b&iacute;, hay mi&ecirc;n man với một m&agrave;u xanh ở những khu rừng nguy&ecirc;n sinh khắp h&agrave;nh tr&igrave;nh Ch&acirc;u Đốc &ndash; H&agrave; Ti&ecirc;n &ndash; Rạch Gi&aacute; &ndash; Ph&uacute; Quốc m&agrave; Bazan Travel mang lại cho qu&yacute; kh&aacute;ch. Đến v&agrave; trải l&ograve;ng để y&ecirc;u th&ecirc;m những mảnh đất nắng gi&oacute; của miền Nam Bộ nh&eacute;!</p>','','','\0','','','','','','\0',4,'PHU-QUOC-1.jpg','Châu Đốc - Hà Tiên - Rạch Giá - Phú Quốc','2,500,000','2,500,000',25,'','2017-05-20','19:00',25,1);
/*!40000 ALTER TABLE `tour` ENABLE KEYS */;
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
