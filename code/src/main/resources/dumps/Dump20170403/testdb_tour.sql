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
  `NAME` varchar(200) NOT NULL,
  `PRICE` varchar(255) NOT NULL,
  `QUANTUM` int(11) NOT NULL,
  `REG_OR_NOT` bit(1) NOT NULL,
  `RETURN_DATE` date NOT NULL,
  `RETURN_TIME` varchar(10) NOT NULL,
  `TICKET_AVAILABILITY` int(11) NOT NULL,
  `VIEW` int(11) NOT NULL,
  PRIMARY KEY (`ID_TOUR`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tour`
--

LOCK TABLES `tour` WRITE;
/*!40000 ALTER TABLE `tour` DISABLE KEYS */;
INSERT INTO `tour` VALUES (1,'','2017-04-13','2017-04-09','2017-04-14','14:50','<p>Nh&agrave; Thờ Cha Diệp (Nh&agrave; thờ Tắc Sậy) &ndash; nơi gắn liền với một nh&acirc;n vật nổi tiếng &ndash;&nbsp; cha Trương Bửu Diệp, vị linh mục được xem như một vị th&aacute;nh v&igrave; sự linh thi&ecirc;ng, thi &acirc;n gi&aacute;ng ph&uacute;c cho những ai tin tưởng nguyện cầu. Nơi đ&acirc;y kh&ocirc;ng chỉ l&agrave; điểm h&agrave;nh hương của người miền T&acirc;y m&agrave; c&ograve;n của d&acirc;n C&ocirc;ng gi&aacute;o ở nhiều v&ugrave;ng miền kh&aacute;c. Nh&agrave; thờ hiện c&ograve;n l&agrave; Trung t&acirc;m Truyền gi&aacute;o Phanxic&ocirc; của Gi&aacute;o phận. Qu&yacute; kh&aacute;ch tham quan, viếng mộ Cha Phaxico Xavi&ecirc; Trương Bửu Diệp, cầu nguyện, xin ơn,&hellip; cảm nhận được kh&ocirc;ng kh&iacute; trang nghi&ecirc;m v&agrave; thi&ecirc;ng li&ecirc;ng của nơi n&agrave;y, t&igrave;m hiểu v&agrave; biết th&ecirc;m về Đạo Thi&ecirc;n Ch&uacute;a Gi&aacute;o.<br />Sau khi tham quan Nh&agrave; thờ Cha Diệp, Qu&yacute; kh&aacute;ch l&ecirc;n đường đi Bạc Li&ecirc;u, gh&eacute; thăm Đức Mẹ Long Hải, ch&ugrave;a Dơi. Ch&ugrave;a Dơi (Waths&ecirc;r&acirc;ytecho Mahatup) &ndash; một trong những danh thắng nổi tiếng của S&oacute;c Trăng, nơi cư ngụ của h&agrave;ng ngh&igrave;n con dơi. Theo người Khmer, Mahatup l&agrave; trận kh&aacute;ng cự lớn (Tup: kh&aacute;ng cự; Maha: lớn). Nơi đ&acirc;y đ&atilde; diễn ra một trận đ&aacute;nh &aacute;c liệt của phong tr&agrave;o n&ocirc;ng d&acirc;n nổi dậy chống bọn phong kiến ng&agrave;y xưa. Sau trận đ&aacute;nh đ&oacute;, d&acirc;n ch&uacute;ng tản cư trở về sinh sống, họ cho rằng v&ugrave;ng đất n&agrave;y c&oacute; điềm l&agrave;nh (đất l&agrave;nh) n&ecirc;n x&acirc;y ch&ugrave;a thờ Phật, bởi họ tin rằng nếu&nbsp; được đấng tối cao che chở th&igrave; mọi chuyện trong cuộc sống của họ sẽ b&igrave;nh y&ecirc;n, họ sẽ gi&agrave;nh chiến thắng trong c&aacute;c trận đ&aacute;nh,&hellip;</p>','','','\0','','','','','\0','42562226.jpg','Du lịch Nhà Thờ Cha Diệp – Chùa Bà Nam Hải – Chùa Dơi','2,000,000',100,'','2017-04-16','19:00',100,0),(2,'','2017-04-17','2017-04-09','2017-04-18','14:50','<p>Nếu qu&yacute; kh&aacute;ch đ&atilde; qu&aacute; quen với những cảnh đẹp thi&ecirc;n nhi&ecirc;n của n&uacute;i non, s&ocirc;ng nước th&igrave; sự h&ugrave;ng vĩ v&agrave; tr&aacute;ng lệ của những c&ocirc;ng tr&igrave;nh kiến tr&uacute;c sẽ l&agrave; những trải nghiệm mới v&ocirc; c&ugrave;ng th&uacute; vị cho qu&yacute; kh&aacute;ch đấy. Đứng trước những quần thể kiến tr&uacute;c lớn về cả qui m&ocirc; v&agrave; &ldquo;lớn&rdquo; cả về bề d&agrave;y lịch sử, t&acirc;m hồn qu&yacute; kh&aacute;ch kh&ocirc;ng những được thư th&aacute;i v&agrave; thoải m&aacute;i m&agrave; c&ograve;n l&agrave; cơ hội để qu&yacute; kh&aacute;ch hiểu hơn về &yacute; nghĩa của những &ldquo;t&agrave;i sản&rdquo; qu&iacute; gi&aacute; của d&acirc;n tộc. Chương tr&igrave;nh lần n&agrave;y, <strong>NAM BỘ TRAVEL</strong> sẽ đưa qu&yacute; kh&aacute;ch đến với khu du lịch t&acirc;m linh &ndash; Lạc cảnh Đại Nam Văn Hiến được xem l&agrave; khu du lịch lớn nhất Đ&ocirc;ng Nam &Aacute; về diện t&iacute;ch. Với tour du lịch Đại Nam 1 ng&agrave;y qu&yacute; kh&aacute;ch sẽ th&ecirc;m tự h&agrave;o về một Việt Nam tươi đẹp. Đừng bỏ lỡ qua cơ hội n&agrave;y nh&eacute;!</p>\r\n<p>Nổi bật:</p>\r\n<p>Tham quan Khu Kim Điện, Bảo Th&aacute;p, D&ograve;ng Bảo Giang, D&atilde;y n&uacute;i Ngũ H&agrave;nh Sơn</p>\r\n<p>Tham quan Vườn Th&uacute; Đại Nam</p>\r\n<p>Khu Vui Chơi Giải Tr&iacute;</p>\r\n<p>Tham quan tắm Biển Đại Nam</p>\r\n<p>Biển Đại Nam bao gồm 2 khu vực: khu vực Biển nước ngọt v&agrave; khu vực Biển nước mặn</p>','','','\0','','','','','\0','dscn3681.jpg','Du lịch Đại Nam','3,000,000',200,'','2017-04-20','17:00',200,0),(3,'','2017-04-23','2017-04-10','2017-04-24','7:00','<p>Tới Th&agrave;nh phố Mỹ Tho (tỉnh Tiền Giang), du kh&aacute;ch tham quan v&ugrave;ng đất trứ danh của thời Nam Kỳ lục Tỉnh, c&ograve;n c&oacute; t&ecirc;n l&agrave; Mỹ Tho Đại Phố. Xuống đ&ograve; qua s&ocirc;ng Tiền, du kh&aacute;ch tham quan l&agrave;ng nghề truyền thống l&ograve; kẹo dừa, cơ sở nu&ocirc;i ong lấy mật...; ngồi xuồng ch&egrave;o kh&aacute;m ph&aacute; cuộc sống s&ocirc;ng nước miền T&acirc;y, qu&yacute; kh&aacute;ch tham gia chương tr&igrave;nh &ldquo;T&aacute;t mương bắt c&aacute;&rdquo; v&agrave; d&ugrave;ng cơm trưa với những con c&aacute; m&agrave; qu&yacute; kh&aacute;ch vừa bắt được, thưởng thức kết hợp với 2 m&oacute;n ăn đặc sản v&ugrave;ng s&ocirc;ng nước như: C&aacute; tai tượng chi&ecirc;n x&ugrave;, c&aacute; linh kho tộ&hellip; Xe đ&oacute;n đo&agrave;n v&agrave; tiếp tục đưa du kh&aacute;ch đi qua cầu Rạch Miễu - một c&ocirc;ng tr&igrave;nh mới ho&agrave;n th&agrave;nh của tỉnh Bến Tre.</p>','','','\0','','','','','\0','du-lich-can-tho-43.jpg','Du lịch Cân Thơ - Tiền Giang','4,000,000',60,'','2017-04-28','19:00',60,2),(4,'','2017-04-30','2017-04-10','2017-05-01','7:00','<p>Đ&ograve;an t&acirc;̣p trung tại b&atilde;i bi&ecirc;̉n tham gia c&aacute;c tr&ograve; chơi vận động tr&ecirc;n biển với d&agrave;n &acirc;m thanh s&ocirc;́ng đ&ocirc;̣ng: Đưa nước về nguồn, đ&aacute; b&oacute;ng t&igrave;nh nh&acirc;n, Vũ đi&ecirc;̣u t&igrave;nh n&ocirc;̀ng, Ai d&agrave;i hơn ai,k&eacute;o co t&igrave;nh y&ecirc;u, đua ghe ngo tr&ecirc;n cạn, đi t&igrave;m n&agrave;ng ti&ecirc;n c&aacute;&hellip;do Mc c&ocirc;ng ty du lịch NAM BỘ TRAVEL t&ocirc;̉ chức c&ugrave;ng nhi&ecirc;̀u ph&acirc;̀n qu&agrave; thưởng h&acirc;́p d&acirc;̃n.</p>\r\n<p>Xe đưa đ&ograve;an đi tham quan: Ti&ecirc;́p tục l&ocirc;̣ tr&igrave;nh đi Vũng T&agrave;u, Đ&ecirc;́n Vũng T&agrave;u qu&yacute; kh&aacute;ch đi tham quan tượng Ch&uacute;a Kit&ocirc; ngắm nh&igrave;n to&agrave;n cảnh Tp. Vũng T&agrave;u. Th&iacute;ch Ca Phật đ&agrave;i. Tạm biệt Vũng T&agrave;u đo&agrave;n về lại B&agrave; Rịa. Tr&ecirc;n đường về gh&eacute; tham quan mua sắm đặc sản tại Trung t&acirc;m thương mại B&agrave; Rịa. Ti&ecirc;́p tục tr&ecirc;n đường v&ecirc;̀ gh&eacute; nghỉ ngơi v&agrave; thư gi&atilde;n tại B&ograve; sữa Long Th&agrave;nh. Ti&ecirc;́p tục v&ecirc;̀ lại Tp. H&ocirc;̀ Ch&iacute; Minh.</p>','','','\0','','','','','\0','geographical-location-7081.jpg','Du lịch Vũng Tàu - Biển Gọi','5,000,000',45,'','2017-05-07','19:00',45,0),(5,'','2017-04-30','2017-04-10','2017-05-01','7:00','<p>Miền T&acirc;y rất đẹp v&agrave; b&igrave;nh y&ecirc;n với những con s&ocirc;ng chảy d&agrave;i như suối t&oacute;c của một thiếu nữ xu&acirc;n th&igrave; c&ugrave;ng những con người hiếu kh&aacute;ch v&agrave; b&igrave;nh dị. Miền T&acirc;y từ l&acirc;u đ&atilde; được nhiều du kh&aacute;ch d&agrave;nh nhiều t&igrave;nh cảm v&agrave; hướng về. Họ đến đ&acirc;y v&agrave; họ quay lại kh&ocirc;ng đơn thuần chỉ v&igrave; vẻ đẹp, v&igrave; con người, v&igrave; bức tranh cuộc sống miền qu&ecirc; thanh b&igrave;nh m&agrave; c&ograve;n v&igrave; nơi đ&acirc;y với nhiều v&ugrave;ng đất của sự linh thi&ecirc;ng v&agrave; t&iacute;n ngưỡng gắn với nhiều truyền thuyết đ&atilde; tồn tại từ xa xưa. NAM BỘ&nbsp; TRAVEL sẽ c&ugrave;ng du kh&aacute;ch trải nghiệm chuyến đi th&uacute; vị kết hợp giữa du lịch kh&aacute;m ph&aacute; v&agrave; h&agrave;nh hương về những v&ugrave;ng đất n&agrave;y, chắc chắn sẽ đem lại cho Qu&yacute; kh&aacute;ch cảm gi&aacute;c thư th&aacute;i, thoải m&aacute;i v&agrave; sự b&igrave;nh an trong t&acirc;m hồn.</p>','','','\0','','','','','\0','Biển Hà Tiên.jpg','Du Lịch Châu Đốc – Hà Tiên – Rạch Giá – Phú Quốc','4,000,000',40,'','2017-05-04','18:00',40,0),(6,'','2017-04-19','2017-04-10','2017-04-20','10:00','<p>C&acirc;u hỏi hay l&agrave; c&acirc;u ch&agrave;o của người con trai miệt vườn ấy cứ da diết trong l&ograve;ng mỗi người đ&atilde; đến v&agrave; cả những ai chưa đến Nam Kỳ lục tỉnh, chưa gh&eacute; qua bến Ninh Kiều thơ mộng. Kh&ocirc;ng chỉ l&agrave; một nền văn h&oacute;a lu&ocirc;n được giao lưu, học hỏi m&agrave; c&ograve;n l&agrave; sự nhiệt t&igrave;nh, ph&oacute;ng kho&aacute;ng của những người d&acirc;n bản xứ; kh&ocirc;ng chỉ l&agrave; sự sầm uất, n&aacute;o nhiệt của một khu trung t&acirc;m mua sắm thời xưa m&agrave; c&ograve;n l&agrave; ch&uacute;t tĩnh lặng, l&atilde;ng mạn, hữu t&igrave;nh của những bến đ&ograve; đi v&agrave;o biết bao c&acirc;u thơ, c&acirc;u văn.</p>','','','\0','','','','','\0','1480671468_du-lich-mien-tay-kham-pha-6-cho-.jpg','Du Lịch Mỹ Tho – Cần Thơ – Chợ Nổi','2,000,000',30,'','2017-04-22','19:00',30,1);
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

-- Dump completed on 2017-04-08  9:21:56
