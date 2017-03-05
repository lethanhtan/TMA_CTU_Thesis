<%-- 
    Document   : createtour
    Created on : Feb 08, 2017, 8:42:34 PM
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
<link rel="stylesheet" href="resources/css/bootstrap.css"
	rel="stylesheet">
<!-- Template CSS -->
<link rel="stylesheet" href="resources/css/animate.css" rel="stylesheet">
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
						<a href="home" title=""> <img
							src="resources/img/logo.png" alt="Logo" />
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
							<li><a href="managetour" class="fa-gear">Quản Lý Tour</a></li>
							<li><a href="manageregister" class="fa-list-ul">Quản Lý
									Đăng Ký</a></li>
							<li><a href="survey" class="fa-file-text">Khảo Sát Ý
									Kiến</a></li>
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
				<div class="container">
					<div class="row margin-vert-30">
						<!-- Create Tour Box -->
						<div class="col-md-6 col-md-offset-3 col-sm-offset-3">
							<s:form class="signup-page" commandName="tourData"
								action="${pageContext.request.contextPath}/createtour"
								method="POST">
								<div class="signup-header">
									<h2>Thông Tin Tour Du Lịch</h2>
								</div>
								<div class="row">
									<div class="col-sm-8">
										<label>Tên tour</label>
										<!-- Show Error -->
										</br> <small><s:errors path="name" cssStyle="color:red;" /></small>
										<!--  End Show Error -->
										<div class="input-group margin-bottom-20">
											<span class="input-group-addon"> <i
												class="fa fa-map-marker"></i>
											</span>
											<s:input placeholder="Nhập tên tour"
												class="form-control margin-bottom-20" type="text"
												path="name" />
										</div>
									</div>
									<div class="col-lg-4 text-right">
										<button class="btn btn-primary" type="button">Tải Ảnh
											Lên</button>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-6">
										<label>Ngày đi</label>
										<!-- Show error -->
										</br> <small><s:errors path="departureDate"
												cssStyle="color:red;" /></small>
										<!-- End Show Error -->
										<div class="input-group margin-bottom-20">
											<span class="input-group-addon"> <i
												class="fa fa-calendar"></i>
											</span>
											<s:input placeholder="mm/dd/yyyy" id="datepicker"
												class="form-control margin-bottom-20" path="departureDate" />
										</div>
									</div>
									<div class="col-sm-6">
										<label>Giờ đi</label>
										<!-- Show Error -->
										</br> <small><s:errors path="departureTime"
												cssStyle="color:red;" /></small>
										<!-- End Show Error -->
										<div class="input-group margin-bottom-20">
											<span class="input-group-addon"> <i
												class="fa fa-clock-o"></i>
											</span>
											<s:input placeholder="Nhập giờ đi"
												class="form-control margin-bottom-20" type="text"
												path="departureTime" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-6">
										<label>Ngày về</label>
										<!-- Show Error -->
										</br> <small><s:errors path="returnDate"
												cssStyle="color:red;" /></small>
										<!-- End Show Error -->
										<div class="input-group margin-bottom-20">
											<span class="input-group-addon"> <i
												class="fa fa-calendar"></i>
											</span>
											<s:input placeholder="mm/dd/yyyy" id="datepicker2"
												class="form-control margin-bottom-20" path="returnDate" />
										</div>
									</div>
									<div class="col-sm-6">
										<label>Giờ về</label>
										<!-- Show Error -->
										</br> <small><s:errors path="returnTime"
												cssStyle="color:red;" /></small>
										<!-- End Show Error -->
										<div class="input-group margin-bottom-20">
											<span class="input-group-addon"> <i
												class="fa fa-clock-o"></i>
											</span>
											<s:input placeholder="Nhập giờ đi"
												class="form-control margin-bottom-20" type="text"
												path="returnTime" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-6">
										<label>Giá vé</label>
										<!-- Show Error -->
										</br> <small><s:errors path="price" cssStyle="color:red;" /></small>
										<!-- End Show Error -->
										<div class="input-group margin-bottom-20">
											<span class="input-group-addon"> <i
												class="fa fa-money"></i>
											</span>
											<s:input placeholder="Nhập giá vé"
												class="form-control margin-bottom-20" type="text"
												path="price" />
										</div>
									</div>
									<div class="col-sm-6">
										<label>Số lượng</label>
										<!-- Show Error -->
										</br> <small><s:errors path="quantum" cssStyle="color:red;" /></small>
										<!-- End Show Error -->
										<div class="input-group margin-bottom-20">
											<span class="input-group-addon"> <i
												class="fa fa-building-o"></i>
											</span>
											<s:input placeholder="Nhập số lượng"
												class="form-control margin-bottom-20" type="text"
												path="quantum" />
										</div>
									</div>
								</div>
								<label>Chi tiết tour</label>
								<!-- Show Error -->
								</br>
								<small><s:errors path="detail" cssStyle="color:red;" /></small>
								<!-- End Show Error -->
								<s:textarea placeholder="Nhập chi tiết về tour" id="area2"
									class="form-control margin-bottom-20" type="text" rows="10"
									path="detail" />
								<hr>
								<div class="row">
									<div class="col-lg-4 text-left">
										<button class="btn btn-primary" type="submit">Xác
											Nhận</button>
									</div>
									<div class="col-lg-4 text-center">
										<a href="managetour"><button class="btn btn-primary"
												type="button">Hủy Bỏ</button></a>
									</div>
									<div class="col-lg-4 text-right">
										<input class="btn btn-primary" type="reset" value="Nhập Lại">
									</div>
								</div>
							</s:form>
						</div>
						<!-- End Create Tour Box -->
					</div>
				</div>
			</div>
			<!-- === END CONTENT === -->
			<!-- === BEGIN FOOTER === -->
			<div id="content-bottom-border" class="container"></div>
			<div id="base"></div>
			<!-- Footer Menu -->
			<div id="footer">
				<div class="container">
					<div class="row">
						<div id="footermenu" class="col-md-8">
							<ul class="list-unstyled list-inline">
								<li><a href="managetour" target="_blank">Quản lý tour</a></li>
								<li><a href="manageregister" target="_blank">Quản lý
										đăng ký</a></li>
								<li><a href="survey" target="_blank">Khảo sát ý kiến</a></li>
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
			<!-- Calendar -->
			<link rel="stylesheet"
				href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
			<script
				src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
			<script type="text/javascript" src="resources/js/calendar.js"
				type="text/javascript"></script>
			<!-- Text editor -->
			<script type="text/javascript"
				src="http://js.nicedit.com/nicEdit-latest.js"></script>
			<!--  Back to top -->
			<script src="resources/js/backtotop.js" type="text/javascript"></script>
			<!-- End JS -->
</body>
</html>
<!-- === END FOOTER === -->
