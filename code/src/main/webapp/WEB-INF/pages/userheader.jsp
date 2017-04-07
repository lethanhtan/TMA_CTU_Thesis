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
<!-- Bootstrap Core CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<!-- Template CSS -->
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/resources/img/hot-air-balloon.png">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/animate.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/font-awesome.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/nexus.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/responsive.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/table.css">
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
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
						<a href="${pageContext.request.contextPath}/home" title=""> <img
							src="${pageContext.request.contextPath}/resources/img/logo.png"
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
			<img
				src="${pageContext.request.contextPath}/resources/img/hot-air-balloon.png"
				width="64px" height="auto"></img>
		</div>
		<!-- End Back To Top -->
		<!-- Top Menu -->
		<div id="hornav" class="container no-padding">
			<div class="row">
				<div class="col-md-12 no-padding">
					<div class="text-center visible-lg">
						<ul id="hornavmenu" class="nav navbar-nav">
							<li><a href="${pageContext.request.contextPath}/home"
								class="fa-home">Trang Chủ</a></li>
							<li><span class="fa-question">Giới Thiệu</span>
								<ul>
									<li><a href="${pageContext.request.contextPath}/aboutus">Về
											Chúng Tôi</a></li>
									<li><a href="${pageContext.request.contextPath}/faq">Câu
											Hỏi Thường Gặp</a></li>
								</ul></li>
							<li><a href="${pageContext.request.contextPath}/tourlist"
								class="fa-book">Đặt Vé</a></li>
							<li><a href="${pageContext.request.contextPath}/news"
								class="fa-tachometer">Tin Tức</a></li>
							<li><a href="${pageContext.request.contextPath}/blog"
								class="fa-tasks">Blog</a></li>
							<li><a href="${pageContext.request.contextPath}/contact"
								class="fa-phone">Liên Hệ</a></li>
							<!-- Test Account -->
							<c:if test="${userName != null}">
								<li><span class="fa-user"> ${userName}</span>
									<ul>
										<c:if test="${roleId == 2}">
											<li><a href="<c:url value="/managetour" />">Quản lý
													tour</a></li>
										</c:if>
										<c:if test="${!(roleId == 2)}">
											<li><a href="<c:url value="/managemyacc/${idUser}" />">Quản
													lý tài khoản</a></li>
											<li><a href="<c:url value="/managemyreg/${idUser}" />">Quản
													lý đăng ký</a></li>
										</c:if>
										<li><a href="<c:url value="/logout" />">Đăng Xuất</a></li>
									</ul>
							</c:if>
							<c:if test="${userName == null}">
								<li><span class="fa-user">Tài khoản</span>
									<ul>
										<li><a href="${pageContext.request.contextPath}/login">Đăng
												Nhập</a></li>
										<li><a href="${pageContext.request.contextPath}/register">Đăng
												ký</a></li>
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