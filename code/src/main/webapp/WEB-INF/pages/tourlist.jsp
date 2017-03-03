<%-- 
    Document   : tourlist
    Created on : Mar 03, 2017, 8:22:29 PM
    Author     : TranLeQueNgoc
--%>

<!-- === BEGIN HEADER === -->
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>

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
<link href="resources/css/table.css" rel="stylesheet">
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
					<!-- Search Form -->
					<div class="error-404-page text-center" style="margin-left: 650px;">
						<form class="form-search search-404">
							<div class="input-append">
								<input type="text" class="span2 search-query"
									placeholder="Nhập họ tên/ điện thoại/ email">
								<button type="submit" class="btn btn-primary">Tìm Kiếm</button>
							</div>
						</form>
					</div>
					<!-- End Search Form -->
					<div class="col-md-12">
						<h2 class="margin-vert-20" style="text-align: center;">Danh
							Sách Tour Du Lịch</h2>
						<div class="row margin-bottom-30">
							<div class="col-md-4 animate fadeInRight"></div>
							<div class="col-md-8 animate fadeIn"></div>
							<div class="col-md-12 animate fadeInRight"></div>
						</div>
						<!-- Table -->
						<c:if test="${empty tourList}">
							<h1>Không có tour nào!</h1>
						</c:if>
						<c:if test="${!empty tourList}">
							<table>
								<thead>
									<tr>
										<th>Mã tour</th>
										<th>Tên tour</th>
										<th>Ngày đi</th>
										<th>Giờ đi</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${tourList}" var="tour">
										<tr>
											<td>${tour.idTour}</td>

											<td>${tour.tourName}</td>
											<td>&nbsp;&nbsp;&nbsp; ${tour.departureDate}</td>
											<td>&nbsp;&nbsp;&nbsp; ${tour.departureTime}
												&nbsp;&nbsp;&nbsp;</td>
											<td><a href="<c:url value='detail/${tour.idTour}'/>"
												title="Xem"> <i class="fa fa-eye">&nbsp;</i>
											</a> <a href="<c:url value='booktour/${tour.idTour}'/>"
												title="Đăng Ký"> <i class="fa fa-edit">&nbsp;</i>
											</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</c:if>
						<!-- End Table -->
						<hr class="margin-vert-50">
						<!-- Pagination -->
						<c:if test="${numTour > 2}">
							<ul class="pagination">
								<li><a href="#">&laquo;</a></li>
								<li class="active"><a href="#">1</a></li>
								<li><a href="#">${numTour - 1}</a></li>
								<li><a href="#">&raquo;</a></li>
							</ul>
						</c:if>
						<!-- End Pagination -->
					</div>
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
		<!--  Back to top -->
		<script src="resources/js/backtotop.js" type="text/javascript"></script>
		<!-- End JS -->
</body>
</html>
<!-- === END FOOTER === -->