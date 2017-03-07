<!-- === BEGIN HEADER === -->
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
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
<<<<<<< HEAD
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
=======
<link href="resources/css/bootstrap.css" rel="stylesheet">
<!-- Template CSS -->
<link href="resources/css/animate.css" rel="stylesheet">
<link href="resources/css/font-awesome.css" rel="stylesheet">
<link href="resources/css/nexus.css" rel="stylesheet">
<link href="resources/css/responsive.css" rel="stylesheet">
<link href="resources/css/table.css" rel="stylesheet">
<!--<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>

>>>>>>> 2e01d0fb0f21ac9e80fe063dcf4a0e00c54efdc0
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
<<<<<<< HEAD
		<div id="pre-header" class="container" style="height: 40px">
			<!-- Spacing above header -->
		</div>
=======
		<div id="pre-header" class="container" style="height: 340px"></div>
>>>>>>> 2e01d0fb0f21ac9e80fe063dcf4a0e00c54efdc0
		<div id="header">
			<div class="container">
				<div class="row">
					<!-- Logo -->
					<div class="logo">
						<a href="${pageContext.request.contextPath }/home" title=""> <img src="resources/img/logo.png"
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
<<<<<<< HEAD
							<li><a href="${pageContext.request.contextPath }/home"
								class="fa-home">Trang Chủ</a></li>
=======
							<li><a href="${pageContext.request.contextPath }/home" class="fa-home">Trang Chủ</a></li>
>>>>>>> 2e01d0fb0f21ac9e80fe063dcf4a0e00c54efdc0
							<li><span class="fa-question">Giới Thiệu</span>
								<ul>
									<li><a href="aboutus">Về Chúng Tôi</a></li>
									<li><a href="faq">Câu Hỏi Thường Gặp</a></li>
								</ul></li>
<<<<<<< HEAD
							<li><a href="${pageContext.request.contextPath }/tourlist"
								class="fa-book">Đặt Vé</a></li>
							<li><a href="${pageContext.request.contextPath }/news"
								class="fa-tachometer">Tin Tức</a></li>
							<li><a href="${pageContext.request.contextPath }/blog"
								class="fa-tasks">Blog</a></li>
							<li><a href="${pageContext.request.contextPath }/contact"
								class="fa-phone">Liên Hệ</a></li>
=======
							<li><a href="${pageContext.request.contextPath }/booktour" class="fa-book">Đặt Vé</a></li>
							<li><a href="${pageContext.request.contextPath }/news" class="fa-tachometer">Tin Tức</a></li>
							<li><a href="${pageContext.request.contextPath }/blog" class="fa-tasks">Blog</a></li>
							<li><a href="${pageContext.request.contextPath }/contact" class="fa-phone">Liên Hệ</a></li>
>>>>>>> 2e01d0fb0f21ac9e80fe063dcf4a0e00c54efdc0
							<!-- Test Account -->
							<c:if test="${userName != null}">
								<li><span class="fa-user"> ${userName}</span>
									<ul>
										<c:if test="${roleId == 2}">
<<<<<<< HEAD
											<li><a
												href="<c:url value="/managetour" />">Quản
													lý tour</a></li>
										</c:if>
										<li><a
											href="<c:url value="/logout" />">Logout</a></li>
=======
											<li><a href="<c:url value="${pageContext.request.contextPath }/managetour" />">Quản lý tour</a></li>
										</c:if>
										<li><a href="<c:url value="${pageContext.request.contextPath }/logout" />">Logout</a></li>
>>>>>>> 2e01d0fb0f21ac9e80fe063dcf4a0e00c54efdc0
									</ul>
							</c:if>
							<c:if test="${userName == null}">
								<li><span class="fa-user">Tài khoản</span>
									<ul>
<<<<<<< HEAD
										<li><a href="${pageContext.request.contextPath }/login">Đăng
												Nhập</a></li>
										<li><a
											href="${pageContext.request.contextPath }/register">Đăng
												ký</a></li>
=======
										<li><a href="${pageContext.request.contextPath }/login">Đăng Nhập</a></li>
										<li><a href="${pageContext.request.contextPath }/register">Đăng ký</a></li>
>>>>>>> 2e01d0fb0f21ac9e80fe063dcf4a0e00c54efdc0
									</ul></li>
							</c:if>
							<!-- End Test Account -->
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!-- End Top Menu -->
<<<<<<< HEAD
		<div id="post_header" class="container" style="height: 40px">
			<!-- Spacing below header -->
		</div>
=======
		<div id="post_header" class="container" style="height: 340px"></div>
>>>>>>> 2e01d0fb0f21ac9e80fe063dcf4a0e00c54efdc0
		<div id="content-top-border" class="container"></div>
		<!-- === END HEADER === -->