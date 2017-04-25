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

<!-- Styles -->
<!-- Styles -->
<style>
#chartdiv {
	width: 100%;
	height: 500px;
	font-size: 11px;
}
</style>

<!-- Resources -->
<script src="https://www.amcharts.com/lib/3/amcharts.js"></script>
<script src="https://www.amcharts.com/lib/3/pie.js"></script>
<script
	src="https://www.amcharts.com/lib/3/plugins/export/export.min.js"></script>
<link rel="stylesheet"
	href="https://www.amcharts.com/lib/3/plugins/export/export.css"
	type="text/css" media="all" />
<script src="https://www.amcharts.com/lib/3/themes/light.js"></script>

<!-- Bootstrap Core CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<!-- Template CSS -->
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
			<img src="${pageContext.request.contextPath }/resources/img/hot-air-balloon.png" width="64px"
				height="auto"></img>
		</div>
		<!-- End Back To Top -->
		<!-- Top Menu -->
		<div id="hornav" class="container no-padding">
			<div class="row">
				<div class="col-md-12 no-padding">
					<div class="text-center visible-lg">
						<ul id="hornavmenu" class="nav navbar-nav">
							<li><a href="${pageContext.request.contextPath }/managetour"
								class="fa-gear">Quản Lý Tour</a></li>
							<li><a class="fa-gear">Thống kê dữ liệu</a>
								<ul>
									<li><a href="<c:url value="/toursales" />">Doanh số
											tour</a></li>
								</ul></li>
							<li><a
								href="${pageContext.request.contextPath }/manageregister"
								class="fa-list-ul">Quản Lý Đăng Ký</a></li>
							<li><a href="${pageContext.request.contextPath }/managedata"
								class="fa-gear">Quản Lý Dữ Liệu</a>
								<ul>
									<li><a href="<c:url value="/import" />">Import</a></li>
									<li><a href="<c:url value="/export" />">Export</a></li>
								</ul></li>
							<li><span class="fa-user"> ${userName}</span>
								<ul>
									<li><a href="<c:url value="/logout" />">Đăng Xuất</a></li>
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
				<h1 align="center">Biểu đồ tình hình bán tour</h1>
				<a href="${pageContext.request.contextPath}/managetour"><button
						class="btn btn-primary fa-backward">Quay về</button></a>
				<h3 style="color: red" align="center">${tourName}</h3>
				<h6 style="color: green" align="center">Đi từ ngày:
					${departureDate} đến ${returnDate}</h6>
				<c:if test="${status == 1}">
					<h6 style="color: blue" align="center">(Có thể đăng ký)</h6>
				</c:if>
				<c:if test="${status == 0}">
					<h6 style="color: red" align="center">(Không thể đăng ký)</h6>
				</c:if>
				<div class="container">
					<!-- Chart code -->
					<script>
						var chart = AmCharts.makeChart("chartdiv", {
							"type" : "pie",
							"theme" : "light",
							"dataProvider" : [ {
								"title" : "Số vé hủy",
								"value" : "${numCan}"
							}, {
								"title" : "Số vé đăng ký",
								"value" : "${numReg}"
							} ],
							"titleField" : "title",
							"valueField" : "value",
							"labelRadius" : 5,

							"radius" : "42%",
							"innerRadius" : "60%",
							"labelText" : "[[title]]",
							"export" : {
								"enabled" : true
							}
						});
					</script>

					<div class="row margin-vert-40">
						<div id="chartdiv"></div>
					</div>
				</div>
			</div>
		</div>
<!-- === END CONTENT === -->
<%@ include file="adminfooter.jsp"%>
