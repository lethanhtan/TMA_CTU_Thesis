<%-- 
    Document   : blog
    Created on : Feb 16, 2017, 2:36:45 PM
    Author     : TranLeQueNgoc
--%>

<!-- === BEGIN HEADER === -->
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<head>
<!-- Title -->
<title>NY Travel Company</title>
<!-- Meta -->
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="">
<meta name="author" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<!-- Favicon -->
<link href="favicon.ico" rel="shortcut icon">
<!-- Bootstrap Core CSS -->
<link href="resources/css/bootstrap.css" rel="stylesheet">
<!-- Template CSS -->
<link href="resources/css/animate.css" rel="stylesheet">
<link href="resources/css/font-awesome.css" rel="stylesheet">
<link href="resources/css/nexus.css" rel="stylesheet">
<link href="resources/css/responsive.css" rel="stylesheet">
<!-- Google Fonts-->
<link
	href="http://fonts.googleapis.com/css?family=Roboto+Condensed:400,300"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=PT+Sans"
	type="text/css" rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Roboto:400,300"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div id="body-bg">
		<ul class="social-icons pull-right hidden-xs">
			<li class="social-youtube"><a href="#" target="_blank"
				title="Youtube"></a></li>
			<li class="social-skype"><a href="#" target="_blank"
				title="Skype"></a></li>
			<li class="social-facebook"><a href="#" target="_blank"
				title="Facebook"></a></li>
			<li class="social-googleplus"><a href="#" target="_blank"
				title="GooglePlus"></a></li>
		</ul>
		<div id="pre-header" class="container" style="height: 40px">
			<!-- Spacing above header -->
		</div>
		<div id="header">
			<div class="container">
				<div class="row">
					<!-- Logo -->
					<div class="logo">
						<a href="home" title=""> <img src="resources/img/logo.png"
							alt="Logo" />
						</a>
					</div>
					<!-- End Logo -->
				</div>
			</div>
		</div>
		<!-- Top Menu -->
		<div id="hornav" class="container no-padding">
			<div class="row">
				<div class="col-md-12 no-padding">
					<div class="text-center visible-lg">
						<ul id="hornavmenu" class="nav navbar-nav">
							<li><a href="home" class="fa-home">Trang Chủ</a></li>
							<li><span class="fa-question">Giới Thiệu</span>
								<ul>
									<li><a href="aboutus">Về Chúng Tôi</a></li>
									<li><a href="faq">Câu Hỏi Thường Gặp</a></li>
								</ul></li>
							<li><a href="booktour" class="fa-book">Đặt Vé</a></li>
							<li><a href="news" class="fa-tachometer">Tin Tức</a></li>
							<li><a href="blog" class="fa-tasks">Blog</a></li>
							<li><a href="contact" class="fa-phone">Liên Hệ</a></li>
							<!-- Test Account -->
							<c:if test="${userName != null}">
								<li><span class="fa-user"> ${userName}</span>
									<ul>
										<li><a href="<c:url value="/logout" />">Logout</a></li>
									</ul></li>
							</c:if>
							<c:if test="${userName == null}">
								<li><span class="fa-user">Tài khoản</span>
									<ul>
										<li><a href="login">Đăng Nhập</a></li>
										<li><a href="register">Đăng ký</a></li>
									</ul></li>
							</c:if>
							<!-- End Test Account -->
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!-- End Top Menu -->
		<div id="post_header" class="container" style="height: 40px">
			<!-- Spacing below header -->
		</div>
		<div id="content-top-border" class="container"></div>
		<!-- === END HEADER === -->
		<!-- === BEGIN CONTENT === -->
		<div id="content">
			<div class="container background-white">
				<div class="row margin-vert-30">
					<!-- Main Column -->
					<div class="col-md-9">
						<!-- Blog Post -->
						<div class="blog-post padding-bottom-20">
							<!-- Blog Item Header -->
							<div class="blog-item-header">
								<!-- Title -->
								<h2>
									<a href="#">5 điểm tham quan thú vị ở Châu Đốc</a>
								</h2>
								<div class="clearfix"></div>
								<!-- End Title -->
							</div>
							<!-- End Blog Item Header -->
							<!-- Blog Item Details -->
							<div class="blog-post-details">
								<!-- Author Name -->
								<div class="blog-post-details-item blog-post-details-item-left">
									<i class="fa fa-user color-gray-light"></i> <a href="#">Admin</a>
								</div>
								<!-- End Author Name -->
								<!-- Date -->
								<div class="blog-post-details-item blog-post-details-item-left">
									<i class="fa fa-calendar color-gray-light"></i> <a href="#">09/02/2017</a>
								</div>
								<!-- End Date -->
								<!-- Tags -->
								<div
									class="blog-post-details-item blog-post-details-item-left blog-post-details-tags">
									<i class="fa fa-tag color-gray-light"></i> <a href="#">Châu
										Đốc</a>, <a href="#">An Giang</a>
								</div>
								<!-- End Tags -->
								<!-- # of Comments -->
								<div
									class="blog-post-details-item blog-post-details-item-left blog-post-details-item-last">
									<a href=""> <i class="fa fa-comments color-gray-light"></i>
										0 Bình luận
									</a>
								</div>
								<!-- End # of Comments -->
							</div>
							<!-- End Blog Item Details -->
							<!-- Blog Item Body -->
							<div class="blog">
								<div class="clearfix"></div>
								<div class="blog-post-body row margin-top-15">
									<div class="col-md-5">
										<img class="margin-bottom-20"
											src="resources/img/blog/5DiemThamQuanThuViOChauDoc.jpg"
											alt="thumb1">
									</div>
									<div class="col-md-7">
										<p>Dọc theo hành trình du lịch trong nước, có dịp ghé thăm
											thành phố Châu Đốc thuộc tỉnh An Giang, sẽ có những địa điểm
											nhất định bạn không nên bỏ lỡ cơ hội tham quan và tìm hiểu.
											Đây là những điểm đến mang cái hồn, cái chất của người dân
											tại mảnh đất thanh bình Châu Đốc...</p>
										<!-- Read More -->
										<a href="#" class="btn btn-primary"> Xem thêm <i
											class="icon-chevron-right readmore-icon"></i>
										</a>
										<!-- End Read More -->
									</div>
								</div>
							</div>
							<!-- End Blog Item Body -->
						</div>
						<!-- End Blog Item -->
						<!-- Blog Post -->
						<div class="blog-post padding-bottom-20">
							<!-- Blog Item Header -->
							<div class="blog-item-header">
								<!-- Title -->
								<h2>
									<a href="#">9 địa danh không thể bỏ qua khi du lịch Vũng
										Tàu</a>
								</h2>
								<div class="clearfix"></div>
								<!-- End Title -->
							</div>
							<!-- End Blog Item Header -->
							<!-- Blog Item Details -->
							<div class="blog-post-details">
								<!-- Author Name -->
								<div class="blog-post-details-item blog-post-details-item-left">
									<i class="fa fa-user color-gray-light"></i> <a href="#">Admin</a>
								</div>
								<!-- End Author Name -->
								<!-- Date -->
								<div class="blog-post-details-item blog-post-details-item-left">
									<i class="fa fa-calendar color-gray-light"></i> <a href="#">03/02/2017</a>
								</div>
								<!-- End Date -->
								<!-- Tags -->
								<div
									class="blog-post-details-item blog-post-details-item-left blog-post-details-tags">
									<i class="fa fa-tag color-gray-light"></i> <a href="#">Vũng
										Tàu</a>, <a href="#">Hồ Đá Xanh</a>
								</div>
								<!-- End Tags -->
								<!-- # of Comments -->
								<div
									class="blog-post-details-item blog-post-details-item-left blog-post-details-item-last">
									<a href=""> <i class="fa fa-comments color-gray-light"></i>
										0 Bình luận
									</a>
								</div>
								<!-- End # of Comments -->
							</div>
							<!-- End Blog Item Details -->
							<!-- Blog Item Body -->
							<div class="blog">
								<div class="clearfix"></div>
								<div class="blog-post-body row margin-top-15">
									<div class="col-md-5">
										<img class="margin-bottom-20"
											src="resources/img/blog/9DiaDanhKhongTheBoQuaKhiDuLichVungTau.jpg"
											alt="thumb2">
									</div>
									<div class="col-md-7">
										<p>Vũng Tàu là một trong những điểm đến yêu thích của du
											khách phía Nam. Nằm nhô hẳn ra khỏi đất liền như một dải đất,
											từ nơi đây, người ta có thể nhìn biển Đông cả khi trời mọc
											lẫn lúc hoàng hôn.</p>
										<!-- Read More -->
										<a href="#" class="btn btn-primary">Xem thêm<i
											class="icon-chevron-right readmore-icon"></i>
										</a>
										<!-- End Read More -->
									</div>
								</div>
							</div>
							<!-- End Blog Item Body -->
						</div>
						<!-- End Blog Item -->
						<!-- Blog Post -->
						<div class="blog-post padding-bottom-20">
							<!-- Blog Item Header -->
							<div class="blog-item-header">
								<!-- Title -->
								<h2>
									<a href="#">Đặc sản nổi tiếng bào ngư Phú Quốc</a>
								</h2>
								<div class="clearfix"></div>
								<!-- End Title -->
							</div>
							<!-- End Blog Item Header -->
							<!-- Blog Item Details -->
							<div class="blog-post-details">
								<!-- Author Name -->
								<div class="blog-post-details-item blog-post-details-item-left">
									<i class="fa fa-user color-gray-light"></i> <a href="#">Admin</a>
								</div>
								<!-- End Author Name -->
								<!-- Date -->
								<div class="blog-post-details-item blog-post-details-item-left">
									<i class="fa fa-calendar color-gray-light"></i> <a href="#">02/02/2017</a>
								</div>
								<!-- End Date -->
								<!-- Tags -->
								<div
									class="blog-post-details-item blog-post-details-item-left blog-post-details-tags">
									<i class="fa fa-tag color-gray-light"></i> <a href="#">Phú
										Quốc</a>, <a href="#">bào ngư</a>
								</div>
								<!-- End Tags -->
								<!-- # of Comments -->
								<div
									class="blog-post-details-item blog-post-details-item-left blog-post-details-item-last">
									<a href=""> <i class="fa fa-comments color-gray-light"></i>
										0 Bình luận
									</a>
								</div>
								<!-- End # of Comments -->
							</div>
							<!-- End Blog Item Details -->
							<!-- Blog Item Body -->
							<div class="blog">
								<div class="clearfix"></div>
								<div class="blog-post-body row margin-top-15">
									<div class="col-md-5">
										<img class="margin-bottom-20"
											src="resources/img/blog/DacSanNoiTiengBaoNguPhuQuoc.jpg"
											alt="thumb3">
									</div>
									<div class="col-md-7">
										<p>Đến với du lịch Phú Quốc du khách sẽ được thưởng thức
											rất nhiều hải sản ngon và bổ, trong đó có bào ngư là đặc sản
											nổi tiếng của biển đảo ngọc nơi đây.</p>
										<!-- Read More -->
										<a href="#" class="btn btn-primary"> Xem thêm <i
											class="icon-chevron-right readmore-icon"></i>
										</a>
										<!-- End Read More -->
									</div>
								</div>
							</div>
							<!-- End Blog Item Body -->
						</div>
						<!-- End Blog Item -->
						<!-- Blog Post -->
						<div class="blog-post padding-bottom-20">
							<!-- Blog Item Header -->
							<div class="blog-item-header">
								<!-- Title -->
								<h2>
									<a href="#">Du xuân trên chợ nổi Cái Răng</a>
								</h2>
								<div class="clearfix"></div>
								<!-- End Title -->
							</div>
							<!-- End Blog Item Header -->
							<!-- Blog Item Details -->
							<div class="blog-post-details">
								<!-- Author Name -->
								<div class="blog-post-details-item blog-post-details-item-left">
									<i class="fa fa-user color-gray-light"></i> <a href="#">Admin</a>
								</div>
								<!-- End Author Name -->
								<!-- Date -->
								<div class="blog-post-details-item blog-post-details-item-left">
									<i class="fa fa-calendar color-gray-light"></i> <a href="#">18/01/2017</a>
								</div>
								<!-- End Date -->
								<!-- Tags -->
								<div
									class="blog-post-details-item blog-post-details-item-left blog-post-details-tags">
									<i class="fa fa-tag color-gray-light"></i> <a href="#">chợ
										nổi</a>,<a href="#">Cái Răng</a>, <a href="#">Cần Thơ</a>
								</div>
								<!-- End Tags -->
								<!-- # of Comments -->
								<div
									class="blog-post-details-item blog-post-details-item-left blog-post-details-item-last">
									<a href=""> <i class="fa fa-comments color-gray-light"></i>
										0 Bình luận
									</a>
								</div>
								<!-- End # of Comments -->
							</div>
							<!-- End Blog Item Details -->
							<!-- Blog Item Body -->
							<div class="blog">
								<div class="clearfix"></div>
								<div class="blog-post-body row margin-top-15">
									<div class="col-md-5">
										<img class="margin-bottom-20"
											src="resources/img/blog/DuXuanTrenChoNoiCaiRang.jpg"
											alt="thumb4">
									</div>
									<div class="col-md-7">
										<p>Nếu như ở miền Bắc và miền Trung có những khu chợ phiên
											độc đáo thì ở miền Nam lại thu hút khách du lịch bởi “đặc
											sản” chợ nổi, trong đó ấn tượng nhất phải kể đến chợ nổi Cái
											Răng, Cần Thơ.</p>
										<!-- Read More -->
										<a href="#" class="btn btn-primary">Xem thêm<i
											class="icon-chevron-right readmore-icon"></i>
										</a>
										<!-- End Read More -->
									</div>
								</div>
							</div>
							<!-- End Blog Item Body -->
						</div>
						<!-- End Blog Item -->
						<!-- Pagination -->
						<ul class="pagination">
							<li><a href="#">&laquo;</a></li>
							<li class="active"><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li class="disabled"><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#">&raquo;</a></li>
						</ul>
						<!-- End Pagination -->
					</div>
					<!-- End Main Column -->
					<!-- Side Column -->
					<div class="col-md-3">
						<!-- Blog Tags -->
						<div class="blog-tags">
							<h3>Tags</h3>
							<ul class="blog-tags">
								<li><a href="#" class="blog-tag">An Giang</a></li>
								<li><a href="#" class="blog-tag">Bạc Liêu</a></li>
								<li><a href="#" class="blog-tag">Cà Mau</a></li>
								<li><a href="#" class="blog-tag">Cần Thơ</a></li>
								<li><a href="#" class="blog-tag">Đồng Tháp</a></li>
								<li><a href="#" class="blog-tag">Nha Trang</a></li>
								<li><a href="#" class="blog-tag">Phú Quốc</a></li>
								<li><a href="#" class="blog-tag">Sóc Trăng</a></li>
								<li><a href="#" class="blog-tag">Vĩnh Long</a></li>
								<li><a href="#" class="blog-tag">Vũng Tàu</a></li>
							</ul>
						</div>
						<!-- End Blog Tags -->
						<!-- Recent Posts -->
						<div class="recent-posts">
							<h3>Bài viết khác</h3>
							<ul class="posts-list margin-top-10">
								<li>
									<div class="recent-post">
										<a href=""> <img class="pull-left"
											src="resources/img/blog/thumbs/LangHoaDepOMienTay.jpg"
											alt="thumb1">
										</a> <a href="#" class="posts-list-title">Làng hoa đẹp ở miền
											Tây</a> <br> <span class="recent-post-date">
											03/01/2017 </span>
									</div>
									<div class="clearfix"></div>
								</li>
								<li>
									<div class="recent-post">
										<a href=""> <img class="pull-left"
											src="resources/img/blog/thumbs/NgamSacXuanConDao.jpg"
											alt="thumb2">
										</a> <a href="#" class="posts-list-title">Ngắm sắc xuân Côn
											Đảo</a> <br> <span class="recent-post-date">
											29/12/2016 </span>
									</div>
									<div class="clearfix"></div>
								</li>
								<li>
									<div class="recent-post">
										<a href=""> <img class="pull-left"
											src="resources/img/blog/thumbs/DuLichBuiNhaTrang.jpg"
											alt="thumb3">
										</a> <a href="#" class="posts-list-title">Du lịch bụi Nha
											Trang</a> <br> <span class="recent-post-date">
											16/12/2016 </span>
									</div>
									<div class="clearfix"></div>
								</li>
								<li>
									<div class="recent-post">
										<a href=""> <img class="pull-left"
											src="resources/img/blog/thumbs/MuiNeNhatDinhPhaiThu.jpg"
											alt="thumb4">
										</a> <a href="#" class="posts-list-title">Mũi Né - Nhất định
											phải thử</a> <br> <span class="recent-post-date">
											01/12/2016 </span>
									</div>
									<div class="clearfix"></div>
								</li>
							</ul>
						</div>
						<!-- End Recent Posts -->
					</div>
					<!-- End Side Column -->
				</div>
			</div>
		</div>
		<!-- === END CONTENT === -->
		<!-- === BEGIN FOOTER === -->
		<div id="content-bottom-border" class="container"></div>
		<div id="base">
			<div class="container padding-vert-30 margin-top-60">
				<div class="row">
					<!-- Contact Details -->
					<div class="col-md-4 margin-bottom-20">
						<h3 class="margin-bottom-10">Liên hệ:</h3>
						<p>
							<span class="fa-phone">Điện thoại:</span> (0710) 3838 474 <br>
							<span class="fa-envelope">Email:</span> <a
								href="mailto:iNYtravel@gmail.com">NYtravel@gmail.com</a> <br>
							<span class="fa-link">Website:</span> <a
								href="http://www.NYtravel.com">www.NYtravel.com</a>
						</p>
						<p>
							Đường 3/2, <br>Phường Xuân Khánh, <br>Quận Ninh Kiều, <br>Thành
							Phố Cần Thơ
						</p>
					</div>
					<!-- End Contact Details -->
					<!-- Sample Menu -->
					<div class="col-md-3 margin-bottom-20">
						<h3 class="margin-bottom-10">NY Travel Company</h3>
						<ul class="menu">
							<li><a class="fa-book" href="booktour">Đặt Vé</a></li>
							<li><a class="fa-tasks" href="blog">Blog</a></li>
							<li><a class="fa-coffee" href="aboutus">Về Chúng Tôi</a></li>
							<li><a class="fa-question" href="faq">Câu Hỏi Thường Gặp</a></li>
						</ul>
						<div class="clearfix"></div>
					</div>
					<!-- End Sample Menu -->
					<div class="col-md-1"></div>
					<!-- Disclaimer -->
					<div class="col-md-3 margin-bottom-20 padding-vert-30 text-center">
						<h3 class="color-gray margin-bottom-10">Đăng Ký Bản Tin</h3>
						<p>Nhập địa chỉ email để nhận được những tin tức mới nhất từ
							chúng tôi</p>
						<input type="email"> <br>
						<button class="btn btn-primary btn-lg margin-top-20" type="button">Đăng
							Ký</button>
					</div>
					<!-- End Disclaimer -->
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
		<!-- Footer Menu -->
		<div id="footer">
			<div class="container">
				<div class="row">
					<div id="footermenu" class="col-md-8">
						<ul class="list-unstyled list-inline">
							<li><a href="home" target="_blank">Trang Chủ</a></li>
							<li><a href="booktour" target="_blank">Đặt Vé</a></li>
							<li><a href="news" target="_blank">Tin Tức</a></li>
							<li><a href="aboutus" target="_blank">Chính Sách Bảo Mật</a></li>
						</ul>
					</div>
					<div id="copyright" class="col-md-4">
						<p class="pull-right">(c) 2016 NY Travel Company</p>
					</div>
				</div>
			</div>
		</div>
		<!-- End Footer Menu -->
		<!-- JS -->
		<script type="text/javascript" src="resources/js/jquery.min.js"
			type="text/javascript"></script>
		<script type="text/javascript" src="resources/js/bootstrap.min.js"
			type="text/javascript"></script>
		<script type="text/javascript" src="resources/js/scripts.js"></script>
		<!-- Isotope - Portfolio Sorting -->
		<script type="text/javascript" src="resources/js/jquery.isotope.js"
			type="text/javascript"></script>
		<!-- Mobile Menu - Slicknav -->
		<script type="text/javascript" src="resources/js/jquery.slicknav.js"
			type="text/javascript"></script>
		<!-- Animate on Scroll-->
		<script type="text/javascript" src="resources/js/jquery.visible.js"
			charset="utf-8"></script>
		<!-- Sticky Div -->
		<script type="text/javascript" src="resources/js/jquery.sticky.js"
			charset="utf-8"></script>
		<!-- Slimbox2-->
		<script type="text/javascript" src="resources/js/slimbox2.js"
			charset="utf-8"></script>
		<!-- Modernizr -->
		<script src="resources/js/modernizr.custom.js" type="text/javascript"></script>
		<link rel="stylesheet" href="resources/css/bootstrap.css"
			rel="stylesheet">
		<!-- Template CSS -->
		<link rel="stylesheet" href="resources/css/animate.css"
			rel="stylesheet">
		<link rel="stylesheet" href="resources/css/font-awesome.css"
			rel="stylesheet">
		<link rel="stylesheet" href="resources/css/nexus.css" rel="stylesheet">
		<link rel="stylesheet" href="resources/css/responsive.css"
			rel="stylesheet">
		<link rel="stylesheet" href="resources/css/table.css" rel="stylesheet">
		<!-- Google Fonts-->
		<link
			href="http://fonts.googleapis.com/css?family=Roboto+Condensed:400,300"
			rel="stylesheet" type="text/css">
		<link href="http://fonts.googleapis.com/css?family=PT+Sans"
			type="text/css" rel="stylesheet">
		<link href="http://fonts.googleapis.com/css?family=Roboto:400,300"
			rel="stylesheet" type="text/css">
		</head>
		<body>
			<div id="body-bg">
				<ul class="social-icons pull-right hidden-xs">
					<li class="social-youtube"><a href="#" target="_blank"
						title="Youtube"></a></li>
					<li class="social-skype"><a href="#" target="_blank"
						title="Skype"></a></li>
					<li class="social-facebook"><a href="#" target="_blank"
						title="Facebook"></a></li>
					<li class="social-googleplus"><a href="#" target="_blank"
						title="GooglePlus"></a></li>
				</ul>
				<div id="pre-header" class="container" style="height: 40px">
					<!-- Spacing above header -->
				</div>
				<div id="header">
					<div class="container">
						<div class="row">
							<!-- Logo -->
							<div class="logo">
								<a href="home" title=""> <img src="resources/img/logo.png"
									alt="Logo" />
								</a>
							</div>
							<!-- End Logo -->
						</div>
					</div>
				</div>
				<!-- Back To Top -->
				<div title="Về đầu trang" onmouseover="this.style.color='#590059'"
					onmouseout="this.style.color='#004993'" id="top-up">
					<img src="resources/img/hot-air-balloon.png" width="64px"
						height="auto"></img>
				</div>
				<!-- End Back To Top -->
				<!-- Top Menu -->
				<div id="hornav" class="container no-padding">
					<div class="row">
						<div class="col-md-12 no-padding">
							<div class="text-center visible-lg">
								<ul id="hornavmenu" class="nav navbar-nav">
									<li><a href="home" class="fa-home">Trang Chủ</a></li>
									<li><span class="fa-question">Giới Thiệu</span>
										<ul>
											<li><a href="aboutus">Về Chúng Tôi</a></li>
											<li><a href="faq">Câu Hỏi Thường Gặp</a></li>
										</ul></li>
									<li><a href="booktour" class="fa-book">Đặt Vé</a></li>
									<li><a href="news" class="fa-tachometer">Tin Tức</a></li>
									<li><a href="blog" class="fa-tasks">Blog</a></li>
									<li><a href="contact" class="fa-phone">Liên Hệ</a></li>
									<li><span class="fa-users">Tài Khoản</span>
										<ul>
											<li><a href="login">Đăng Nhập</a></li>
											<li><a href="signup">Đăng ký</a></li>
										</ul></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<!-- End Top Menu -->
				<div id="post_header" class="container" style="height: 40px">
					<!-- Spacing below header -->
				</div>
				<div id="content-top-border" class="container"></div>
				<!-- === END HEADER === -->
				<!-- === BEGIN CONTENT === -->
				<div id="content">
					<div class="container background-white">
						<div class="row margin-vert-30">
							<!-- Main Column -->
							<div class="col-md-9">
								<!-- Blog Post -->
								<div class="blog-post padding-bottom-20">
									<!-- Blog Item Header -->
									<div class="blog-item-header">
										<!-- Title -->
										<h2>
											<a href="#">5 điểm tham quan thú vị ở Châu Đốc</a>
										</h2>
										<div class="clearfix"></div>
										<!-- End Title -->
									</div>
									<!-- End Blog Item Header -->
									<!-- Blog Item Details -->
									<div class="blog-post-details">
										<!-- Author Name -->
										<div
											class="blog-post-details-item blog-post-details-item-left">
											<i class="fa fa-user color-gray-light"></i> <a href="#">Admin</a>
										</div>
										<!-- End Author Name -->
										<!-- Date -->
										<div
											class="blog-post-details-item blog-post-details-item-left">
											<i class="fa fa-calendar color-gray-light"></i> <a href="#">09/02/2017</a>
										</div>
										<!-- End Date -->
										<!-- Tags -->
										<div
											class="blog-post-details-item blog-post-details-item-left blog-post-details-tags">
											<i class="fa fa-tag color-gray-light"></i> <a href="#">Châu
												Đốc</a>, <a href="#">An Giang</a>
										</div>
										<!-- End Tags -->
										<!-- # of Comments -->
										<div
											class="blog-post-details-item blog-post-details-item-left blog-post-details-item-last">
											<a href=""> <i class="fa fa-comments color-gray-light"></i>
												0 Bình luận
											</a>
										</div>
										<!-- End # of Comments -->
									</div>
									<!-- End Blog Item Details -->
									<!-- Blog Item Body -->
									<div class="blog">
										<div class="clearfix"></div>
										<div class="blog-post-body row margin-top-15">
											<div class="col-md-5">
												<img class="margin-bottom-20"
													src="resources/img/blog/5DiemThamQuanThuViOChauDoc.jpg"
													alt="thumb1">
											</div>
											<div class="col-md-7">
												<p>Dọc theo hành trình du lịch trong nước, có dịp ghé
													thăm thành phố Châu Đốc thuộc tỉnh An Giang, sẽ có những
													địa điểm nhất định bạn không nên bỏ lỡ cơ hội tham quan và
													tìm hiểu. Đây là những điểm đến mang cái hồn, cái chất của
													người dân tại mảnh đất thanh bình Châu Đốc...</p>
												<!-- Read More -->
												<a href="#" class="btn btn-primary"> Xem thêm <i
													class="icon-chevron-right readmore-icon"></i>
												</a>
												<!-- End Read More -->
											</div>
										</div>
									</div>
									<!-- End Blog Item Body -->
								</div>
								<!-- End Blog Item -->
								<!-- Blog Post -->
								<div class="blog-post padding-bottom-20">
									<!-- Blog Item Header -->
									<div class="blog-item-header">
										<!-- Title -->
										<h2>
											<a href="#">9 địa danh không thể bỏ qua khi du lịch Vũng
												Tàu</a>
										</h2>
										<div class="clearfix"></div>
										<!-- End Title -->
									</div>
									<!-- End Blog Item Header -->
									<!-- Blog Item Details -->
									<div class="blog-post-details">
										<!-- Author Name -->
										<div
											class="blog-post-details-item blog-post-details-item-left">
											<i class="fa fa-user color-gray-light"></i> <a href="#">Admin</a>
										</div>
										<!-- End Author Name -->
										<!-- Date -->
										<div
											class="blog-post-details-item blog-post-details-item-left">
											<i class="fa fa-calendar color-gray-light"></i> <a href="#">03/02/2017</a>
										</div>
										<!-- End Date -->
										<!-- Tags -->
										<div
											class="blog-post-details-item blog-post-details-item-left blog-post-details-tags">
											<i class="fa fa-tag color-gray-light"></i> <a href="#">Vũng
												Tàu</a>, <a href="#">Hồ Đá Xanh</a>
										</div>
										<!-- End Tags -->
										<!-- # of Comments -->
										<div
											class="blog-post-details-item blog-post-details-item-left blog-post-details-item-last">
											<a href=""> <i class="fa fa-comments color-gray-light"></i>
												0 Bình luận
											</a>
										</div>
										<!-- End # of Comments -->
									</div>
									<!-- End Blog Item Details -->
									<!-- Blog Item Body -->
									<div class="blog">
										<div class="clearfix"></div>
										<div class="blog-post-body row margin-top-15">
											<div class="col-md-5">
												<img class="margin-bottom-20"
													src="resources/img/blog/9DiaDanhKhongTheBoQuaKhiDuLichVungTau.jpg"
													alt="thumb2">
											</div>
											<div class="col-md-7">
												<p>Vũng Tàu là một trong những điểm đến yêu thích của du
													khách phía Nam. Nằm nhô hẳn ra khỏi đất liền như một dải
													đất, từ nơi đây, người ta có thể nhìn biển Đông cả khi trời
													mọc lẫn lúc hoàng hôn.</p>
												<!-- Read More -->
												<a href="#" class="btn btn-primary">Xem thêm<i
													class="icon-chevron-right readmore-icon"></i>
												</a>
												<!-- End Read More -->
											</div>
										</div>
									</div>
									<!-- End Blog Item Body -->
								</div>
								<!-- End Blog Item -->
								<!-- Blog Post -->
								<div class="blog-post padding-bottom-20">
									<!-- Blog Item Header -->
									<div class="blog-item-header">
										<!-- Title -->
										<h2>
											<a href="#">Đặc sản nổi tiếng bào ngư Phú Quốc</a>
										</h2>
										<div class="clearfix"></div>
										<!-- End Title -->
									</div>
									<!-- End Blog Item Header -->
									<!-- Blog Item Details -->
									<div class="blog-post-details">
										<!-- Author Name -->
										<div
											class="blog-post-details-item blog-post-details-item-left">
											<i class="fa fa-user color-gray-light"></i> <a href="#">Admin</a>
										</div>
										<!-- End Author Name -->
										<!-- Date -->
										<div
											class="blog-post-details-item blog-post-details-item-left">
											<i class="fa fa-calendar color-gray-light"></i> <a href="#">02/02/2017</a>
										</div>
										<!-- End Date -->
										<!-- Tags -->
										<div
											class="blog-post-details-item blog-post-details-item-left blog-post-details-tags">
											<i class="fa fa-tag color-gray-light"></i> <a href="#">Phú
												Quốc</a>, <a href="#">bào ngư</a>
										</div>
										<!-- End Tags -->
										<!-- # of Comments -->
										<div
											class="blog-post-details-item blog-post-details-item-left blog-post-details-item-last">
											<a href=""> <i class="fa fa-comments color-gray-light"></i>
												0 Bình luận
											</a>
										</div>
										<!-- End # of Comments -->
									</div>
									<!-- End Blog Item Details -->
									<!-- Blog Item Body -->
									<div class="blog">
										<div class="clearfix"></div>
										<div class="blog-post-body row margin-top-15">
											<div class="col-md-5">
												<img class="margin-bottom-20"
													src="resources/img/blog/DacSanNoiTiengBaoNguPhuQuoc.jpg"
													alt="thumb3">
											</div>
											<div class="col-md-7">
												<p>Đến với du lịch Phú Quốc du khách sẽ được thưởng thức
													rất nhiều hải sản ngon và bổ, trong đó có bào ngư là đặc
													sản nổi tiếng của biển đảo ngọc nơi đây.</p>
												<!-- Read More -->
												<a href="#" class="btn btn-primary"> Xem thêm <i
													class="icon-chevron-right readmore-icon"></i>
												</a>
												<!-- End Read More -->
											</div>
										</div>
									</div>
									<!-- End Blog Item Body -->
								</div>
								<!-- End Blog Item -->
								<!-- Blog Post -->
								<div class="blog-post padding-bottom-20">
									<!-- Blog Item Header -->
									<div class="blog-item-header">
										<!-- Title -->
										<h2>
											<a href="#">Du xuân trên chợ nổi Cái Răng</a>
										</h2>
										<div class="clearfix"></div>
										<!-- End Title -->
									</div>
									<!-- End Blog Item Header -->
									<!-- Blog Item Details -->
									<div class="blog-post-details">
										<!-- Author Name -->
										<div
											class="blog-post-details-item blog-post-details-item-left">
											<i class="fa fa-user color-gray-light"></i> <a href="#">Admin</a>
										</div>
										<!-- End Author Name -->
										<!-- Date -->
										<div
											class="blog-post-details-item blog-post-details-item-left">
											<i class="fa fa-calendar color-gray-light"></i> <a href="#">18/01/2017</a>
										</div>
										<!-- End Date -->
										<!-- Tags -->
										<div
											class="blog-post-details-item blog-post-details-item-left blog-post-details-tags">
											<i class="fa fa-tag color-gray-light"></i> <a href="#">chợ
												nổi</a>,<a href="#">Cái Răng</a>, <a href="#">Cần Thơ</a>
										</div>
										<!-- End Tags -->
										<!-- # of Comments -->
										<div
											class="blog-post-details-item blog-post-details-item-left blog-post-details-item-last">
											<a href=""> <i class="fa fa-comments color-gray-light"></i>
												0 Bình luận
											</a>
										</div>
										<!-- End # of Comments -->
									</div>
									<!-- End Blog Item Details -->
									<!-- Blog Item Body -->
									<div class="blog">
										<div class="clearfix"></div>
										<div class="blog-post-body row margin-top-15">
											<div class="col-md-5">
												<img class="margin-bottom-20"
													src="resources/img/blog/DuXuanTrenChoNoiCaiRang.jpg"
													alt="thumb4">
											</div>
											<div class="col-md-7">
												<p>Nếu như ở miền Bắc và miền Trung có những khu chợ
													phiên độc đáo thì ở miền Nam lại thu hút khách du lịch bởi
													“đặc sản” chợ nổi, trong đó ấn tượng nhất phải kể đến chợ
													nổi Cái Răng, Cần Thơ.</p>
												<!-- Read More -->
												<a href="#" class="btn btn-primary">Xem thêm<i
													class="icon-chevron-right readmore-icon"></i>
												</a>
												<!-- End Read More -->
											</div>
										</div>
									</div>
									<!-- End Blog Item Body -->
								</div>
								<!-- End Blog Item -->
								<!-- Pagination -->
								<ul class="pagination">
									<li><a href="#">&laquo;</a></li>
									<li class="active"><a href="#">1</a></li>
									<li><a href="#">2</a></li>
									<li><a href="#">3</a></li>
									<li class="disabled"><a href="#">4</a></li>
									<li><a href="#">5</a></li>
									<li><a href="#">&raquo;</a></li>
								</ul>
								<!-- End Pagination -->
							</div>
							<!-- End Main Column -->
							<!-- Side Column -->
							<div class="col-md-3">
								<!-- Blog Tags -->
								<div class="blog-tags">
									<h3>Tags</h3>
									<ul class="blog-tags">
										<li><a href="#" class="blog-tag">An Giang</a></li>
										<li><a href="#" class="blog-tag">Bạc Liêu</a></li>
										<li><a href="#" class="blog-tag">Cà Mau</a></li>
										<li><a href="#" class="blog-tag">Cần Thơ</a></li>
										<li><a href="#" class="blog-tag">Đồng Tháp</a></li>
										<li><a href="#" class="blog-tag">Nha Trang</a></li>
										<li><a href="#" class="blog-tag">Phú Quốc</a></li>
										<li><a href="#" class="blog-tag">Sóc Trăng</a></li>
										<li><a href="#" class="blog-tag">Vĩnh Long</a></li>
										<li><a href="#" class="blog-tag">Vũng Tàu</a></li>
									</ul>
								</div>
								<!-- End Blog Tags -->
								<!-- Recent Posts -->
								<div class="recent-posts">
									<h3>Bài viết khác</h3>
									<ul class="posts-list margin-top-10">
										<li>
											<div class="recent-post">
												<a href=""> <img class="pull-left"
													src="resources/img/blog/thumbs/LangHoaDepOMienTay.jpg"
													alt="thumb1">
												</a> <a href="#" class="posts-list-title">Làng hoa đẹp ở
													miền Tây</a> <br> <span class="recent-post-date">
													03/01/2017 </span>
											</div>
											<div class="clearfix"></div>
										</li>
										<li>
											<div class="recent-post">
												<a href=""> <img class="pull-left"
													src="resources/img/blog/thumbs/NgamSacXuanConDao.jpg"
													alt="thumb2">
												</a> <a href="#" class="posts-list-title">Ngắm sắc xuân Côn
													Đảo</a> <br> <span class="recent-post-date">
													29/12/2016 </span>
											</div>
											<div class="clearfix"></div>
										</li>
										<li>
											<div class="recent-post">
												<a href=""> <img class="pull-left"
													src="resources/img/blog/thumbs/DuLichBuiNhaTrang.jpg"
													alt="thumb3">
												</a> <a href="#" class="posts-list-title">Du lịch bụi Nha
													Trang</a> <br> <span class="recent-post-date">
													16/12/2016 </span>
											</div>
											<div class="clearfix"></div>
										</li>
										<li>
											<div class="recent-post">
												<a href=""> <img class="pull-left"
													src="resources/img/blog/thumbs/MuiNeNhatDinhPhaiThu.jpg"
													alt="thumb4">
												</a> <a href="#" class="posts-list-title">Mũi Né - Nhất định
													phải thử</a> <br> <span class="recent-post-date">
													01/12/2016 </span>
											</div>
											<div class="clearfix"></div>
										</li>
									</ul>
								</div>
								<!-- End Recent Posts -->
							</div>
							<!-- End Side Column -->
						</div>
					</div>
				</div>
				<!-- === END CONTENT === -->
				<!-- === BEGIN FOOTER === -->
				<div id="content-bottom-border" class="container"></div>
				<div id="base">
					<div class="container padding-vert-30 margin-top-60">
						<div class="row">
							<!-- Contact Details -->
							<div class="col-md-4 margin-bottom-20">
								<h3 class="margin-bottom-10">Liên hệ:</h3>
								<p>
									<span class="fa-phone">Điện thoại:</span> (0710) 3838 474 <br>
									<span class="fa-envelope">Email:</span> <a
										href="mailto:iNYtravel@gmail.com">NYtravel@gmail.com</a> <br>
									<span class="fa-link">Website:</span> <a
										href="http://www.NYtravel.com">www.NYtravel.com</a>
								</p>
								<p>
									Đường 3/2, <br>Phường Xuân Khánh, <br>Quận Ninh Kiều,
									<br>Thành Phố Cần Thơ
								</p>
							</div>
							<!-- End Contact Details -->
							<!-- Sample Menu -->
							<div class="col-md-3 margin-bottom-20">
								<h3 class="margin-bottom-10">NY Travel Company</h3>
								<ul class="menu">
									<li><a class="fa-book" href="booktour">Đặt Vé</a></li>
									<li><a class="fa-tasks" href="blog">Blog</a></li>
									<li><a class="fa-coffee" href="aboutus">Về Chúng Tôi</a></li>
									<li><a class="fa-question" href="faq">Câu Hỏi Thường
											Gặp</a></li>
								</ul>
								<div class="clearfix"></div>
							</div>
							<!-- End Sample Menu -->
							<div class="col-md-1"></div>
							<!-- Disclaimer -->
							<div
								class="col-md-3 margin-bottom-20 padding-vert-30 text-center">
								<h3 class="color-gray margin-bottom-10">Đăng Ký Bản Tin</h3>
								<p>Nhập địa chỉ email để nhận được những tin tức mới nhất từ
									chúng tôi</p>
								<input type="email"> <br>
								<button class="btn btn-primary btn-lg margin-top-20"
									type="button">Đăng Ký</button>
							</div>
							<!-- End Disclaimer -->
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<!-- Footer Menu -->
				<div id="footer">
					<div class="container">
						<div class="row">
							<div id="footermenu" class="col-md-8">
								<ul class="list-unstyled list-inline">
									<li><a href="home" target="_blank">Trang Chủ</a></li>
									<li><a href="booktour" target="_blank">Đặt Vé</a></li>
									<li><a href="news" target="_blank">Tin Tức</a></li>
									<li><a href="aboutus" target="_blank">Chính Sách Bảo
											Mật</a></li>
								</ul>
							</div>
							<div id="copyright" class="col-md-4">
								<p class="pull-right">(c) 2016 NY Travel Company</p>
							</div>
						</div>
					</div>
				</div>
				<!-- End Footer Menu -->
				<!-- JS -->
				<script type="text/javascript" src="resources/js/jquery.min.js"
					type="text/javascript"></script>
				<script type="text/javascript" src="resources/js/bootstrap.min.js"
					type="text/javascript"></script>
				<script type="text/javascript" src="resources/js/scripts.js"></script>
				<!-- Isotope - Portfolio Sorting -->
				<script type="text/javascript" src="resources/js/jquery.isotope.js"
					type="text/javascript"></script>
				<!-- Mobile Menu - Slicknav -->
				<script type="text/javascript" src="resources/js/jquery.slicknav.js"
					type="text/javascript"></script>
				<!-- Animate on Scroll-->
				<script type="text/javascript" src="resources/js/jquery.visible.js"
					charset="utf-8"></script>
				<!-- Sticky Div -->
				<script type="text/javascript" src="resources/js/jquery.sticky.js"
					charset="utf-8"></script>
				<!-- Slimbox2-->
				<script type="text/javascript" src="resources/js/slimbox2.js"
					charset="utf-8"></script>
				<!-- Modernizr -->
				<script src="resources/js/modernizr.custom.js"
					type="text/javascript"></script>
				<!--  Back to top -->
				<script src="resources/js/backtotop.js" type="text/javascript"></script>
				<!-- End JS -->
		</body>
</html>
<!-- === END FOOTER === -->