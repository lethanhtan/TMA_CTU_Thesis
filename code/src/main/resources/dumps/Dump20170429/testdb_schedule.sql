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
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule` (
  `DETAIL` varchar(5000) DEFAULT NULL,
  `SUMARY` varchar(500) DEFAULT NULL,
  `ID_TOUR` int(11) NOT NULL,
  PRIMARY KEY (`ID_TOUR`),
  CONSTRAINT `FK_eyr45pbxtunero71y3d6e7tap` FOREIGN KEY (`ID_TOUR`) REFERENCES `tour` (`ID_TOUR`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` VALUES ('<p>Xe v&agrave; HDV của NY&nbsp; TRAVEL đ&oacute;n kh&aacute;ch tại điểm hẹn &ndash; khởi h&agrave;nh từ Tp. HCM&nbsp; l&uacute;c 22giờ &ndash; đi nh&agrave; thờ Cha Diệp, ngủ đ&ecirc;m tr&ecirc;n xe &ndash; dừng ch&acirc;n ở Cai Lậy, d&ugrave;ng điểm t&acirc;m s&aacute;ng, tham quan Nh&agrave; thờ Cha Diệp &ndash; đi Bạc Li&ecirc;u, thăm Đức Mẹ Long Hải &ndash; đi Ch&ugrave;a Dơi &ndash; d&ugrave;ng cơm trưa &ndash; về Tp. HCM.</p>','',1),('<p style=\"text-align: justify;\"><strong>Ng&agrave;y 1</strong></p>\r\n<p>Bạn n&ecirc;n d&agrave;nh nửa buổi để di chuyển, thời gian c&ograve;n lại n&ecirc;n vui chơi tr&ecirc;n b&atilde;i biển v&agrave; thưởng thức hải sản tươi ngon Vũng T&agrave;u.</p>\r\n<p style=\"text-align: justify;\">Đến Vũng T&agrave;u v&agrave; di chuyển đến b&atilde;i sau, tận hưởng l&agrave;n gi&oacute; m&aacute;t rượi v&agrave; nước biển xanh.&nbsp;Thưởng thức những m&oacute;n hải sản đặc trưng của miền biển ở c&aacute;c nh&agrave; h&agrave;ng như ốc m&oacute;ng tay nướng mỡ h&agrave;nh, s&ograve; huyết x&agrave;o bơ tỏi, m&oacute;n t&ocirc;m t&iacute;t, c&aacute; m&uacute; hấp gừng ăn k&egrave;m b&uacute;n, th&ecirc;m một đĩa cơm chi&ecirc;n tỏi&hellip; Sau bữa trưa, bạn nhận ph&ograve;ng kh&aacute;ch sạn, nghỉ ngơi v&agrave; chuẩn bị kh&aacute;m ph&aacute; Vũng T&agrave;u theo lịch tr&igrave;nh dự định.</p>\r\n<p><strong>Ng&agrave;y 2</strong></p>\r\n<p style=\"text-align: justify;\">Thưởng thức bữa s&aacute;ng bằng m&oacute;n b&aacute;nh khọt nổi tiếng. Nhiều người chọn qu&aacute;n gốc V&uacute; Sữa để thưởng thức nhưng <strong>NY Travel</strong> khuy&ecirc;n bạn h&atilde;y chạy đến đường Trần Đồng. B&aacute;nh khọt ở đ&acirc;y được chi&ecirc;n gi&ograve;n, tr&ograve;n, vị ngon lại &iacute;t dầu mỡ. Chủ qu&aacute;n phục vụ rất dễ thương v&agrave; mến kh&aacute;ch. Gi&aacute; 1 phần khoảng 7 c&aacute;i l&agrave; 35.000 đồng.</p>','',2),('<ul>\r\n<li><span class=\"bluebold\">07h00:</span> Đ&oacute;n qu&yacute; kh&aacute;ch tại kh&aacute;ch sạn khởi h&agrave;nh đi <strong>KDL Đại Nam</strong>.</li>\r\n<li><span class=\"bluebold\">08h15:</span> Qu&yacute; kh&aacute;ch sẽ <span class=\"bold\">tham quan Khu Kim Điện</span>, Bảo Th&aacute;p, D&ograve;ng Bảo Giang, D&atilde;y n&uacute;i Ngũ H&agrave;nh Sơn.</li>\r\n<li><span class=\"bluebold\">09h00:</span> <span class=\"bold\">Tham quan Vườn Th&uacute; Đại Nam</span> l&agrave; vườn th&uacute; mở duy nhất tại Việt Nam sẽ đưa du kh&aacute;ch tiếp cận dễ d&agrave;ng với <span class=\"bold\">c&aacute;c lo&agrave;i th&uacute; hoang d&atilde;, qu&yacute; hiếm </span>như: Sư Tử trắng, T&ecirc; Gi&aacute;c trắng, Hổ trắng, C&ocirc;ng trắng, Ngựa vằn, R&ugrave;a da B&aacute;o, Hươu cao cổ, H&agrave; M&atilde;, Hổ Đ&ocirc;ng Dương, Khỉ s&oacute;c Nam Mỹ, B&aacute;o lửa, Nai c&agrave; tong, Hồng Ho&agrave;ng, Linh Dương sừng kiếm&hellip;</li>\r\n<li><span class=\"bluebold\">10h00:</span> Tiếp theo, Qu&yacute; kh&aacute;ch sẽ được <span class=\"bold\">Tham quan Khu Vui Chơi Giải Tr&iacute; </span>với c&aacute;c tr&ograve; chơi hiện đại hấp dẫn nhất như xem Phim 4D, tham quan Thế Giới Tuyết.(chi ph&iacute; tự t&uacute;c)</li>\r\n<li><span class=\"bluebold\">12h00:</span> Qu&yacute; kh&aacute;ch d&ugrave;ng cơm trưa tại <span class=\"bold\">Nh&agrave; H&agrave;ng Đại Nam</span>.</li>\r\n<li><span class=\"bluebold\">13h00:</span> Di chuyển sang Biển, nghỉ ngơi tại chỗ v&agrave; Tham quan <span class=\"bold\">tắm Biển Đại Nam</span> với quy m&ocirc; 21,6 ha, tổng diện t&iacute;ch mặt nước 20.000m2 sức chứa 30.000 người, biển c&oacute; độ dập s&oacute;ng cao 1,6m,&hellip; Biển Đại Nam bao gồm 2 khu vực: khu vực Biển nước ngọt v&agrave; khu vực Biển nước mặn. Nằm giữa l&ograve;ng n&uacute;i h&ugrave;ng vĩ b&ecirc;n cạnh <span class=\"bold\">l&acirc;u đ&agrave;i tr&aacute;ng lệ</span> được thiết kế dưới h&igrave;nh thứchồ tạo s&oacute;ng k&eacute;p, bao quanh c&aacute;c đảo nhỏ giữa l&ograve;ng biển. S&oacute;ng Biển được đ&aacute;nh bằng hơi gi&oacute; với 8 kiểu tạo s&oacute;ng v&ocirc; c&ugrave;ng độc đ&aacute;o.</li>\r\n</ul>','',3),('<p>Ăn s&aacute;ng tại Rạch Gi&aacute; &ndash; đi t&agrave;u cao tốc tới Ph&uacute; Quốc &ndash; nghỉ ngơi ở thị trấn Dương Đ&ocirc;ng &ndash; Đến Đ&ocirc;ng Đảo, tham quan l&agrave;ng ch&agrave;i H&agrave;m Ninh &ndash; Tham quan Suối Tranh &ndash; Ch&ugrave;a Sư Mu&ocirc;n &ndash; Vườn ti&ecirc;u Ph&uacute; Quốc &ndash; Tối tự do tham quan.<br /> Đi t&agrave;u cao tốc tới Ph&uacute; Quốc, cập cảng An Thới v&agrave; đi về thị trấn Dương Đ&ocirc;ng, dọc đường đi Qu&yacute; kh&aacute;ch sẽ cảm nhận những điều giản dị từ cuộc sống y&ecirc;n b&igrave;nh của người d&acirc;n v&ugrave;ng biển đảo. Về đến kh&aacute;ch sạn, du kh&aacute;ch nghỉ ngơi chuẩn bị một h&agrave;nh tr&igrave;nh tham quan đầy th&uacute; vị tại nơi n&agrave;y.</p>\r\n<p>Chiều đến, kh&aacute;ch tham gia v&agrave;o cuộc sống của những người d&acirc;n ch&agrave;i tại l&agrave;ng ch&agrave;i H&agrave;m Ninh, tham quan cầu cảng, ng&oacute; ghe t&agrave;u tấp nập, xa xa biển cả xanh trong v&agrave; lặng y&ecirc;n. Tiếp tục c&ugrave;ng NAM BỘ&nbsp; TRAVEL du ngoạn phong cảnh tuyệt diệu, sơn thủy hữu t&igrave;nh tại Suối Tranh, nơi c&oacute; những th&acirc;n c&acirc;y ngả m&agrave;u x&aacute;m chen v&agrave;o đ&aacute;, suối len lỏi chảy r&oacute;c r&aacute;ch, du kh&aacute;ch c&oacute; thể thoải m&aacute;i đ&ugrave;a nghịch với l&agrave;n nước trong veo v&agrave; m&aacute;t rượi. Đến vườn ti&ecirc;u Ph&uacute; Quốc, th&iacute;ch th&uacute; ngắm những h&agrave;ng ti&ecirc;u xanh thẫm, xa t&iacute;t. Hay d&agrave;nh cho m&igrave;nh một ch&uacute;t tĩnh lặng tại ch&ugrave;a Sư Mu&ocirc;n cổ k&iacute;nh. Khi ho&agrave;ng h&ocirc;n bu&ocirc;ng xuống, qu&yacute; kh&aacute;ch tự do, ngắm ho&agrave;ng h&ocirc;n hoặc tản bộ dọc b&atilde;i biển Ph&uacute; Quốc hay thư th&aacute;i trong khu nghỉ dưỡng, c&ugrave;ng mọi người thưởng thức những bữa tối hải sản ngay tr&ecirc;n biển (chi ph&iacute; tự t&uacute;c).</p>','',4);
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-29 14:08:26
