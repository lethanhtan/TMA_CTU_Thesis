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
<style>
#chartdiv {
  width: 100%;
  height: 500px;
}

.amcharts-export-menu-top-right {
  top: 10px;
  right: 0;
}
</style>

<!-- Resources -->
<script src="https://www.amcharts.com/lib/3/amcharts.js"></script>
<script src="https://www.amcharts.com/lib/3/serial.js"></script>
<script src="https://www.amcharts.com/lib/3/plugins/export/export.min.js"></script>
<link rel="stylesheet" href="https://www.amcharts.com/lib/3/plugins/export/export.css" type="text/css" media="all" />
<script src="https://www.amcharts.com/lib/3/themes/light.js"></script>

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
						<a href="${pageContext.request.contextPath }/home" title=""> <img
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
							<li><a href="${pageContext.request.contextPath }/managetour"
								class="fa-gear">Quản Lý Tour</a></li>
							<li><a class="fa-gear">Thống kê dữ liệu</a>
								<ul>
									<li><a href="<c:url value="/toursales" />">Doanh số tour</a></li>
									<li><a href="<c:url value="/tourres" />">Tour đăng ký</a></li>
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
									<li><a href="<c:url value="/logout" />">Logout</a></li>
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
		<h1 align="center">Biểu đồ doanh số tour theo tháng</h1>
		<div class="container">
			<!-- Chart code -->
			<h1>${Size}</h1>
<script>
var chartData = [{
    "month": "1",
    "sales": 3025,
    "color": "#FF0F00"
  }, {
    "month": "2",
    "sales": 1882,
    "color": "#FF6600"
  }, {
    "month": "3",
    "sales": 1809,
    "color": "#FF9E01"
  }, {
    "month": "4",
    "sales": 1322,
    "color": "#FCD202"
  }, {
    "month": "5",
    "sales": 1122,
    "color": "#F8FF01"
  }, {
    "month": "6",
    "sales": 1114,
    "color": "#B0DE09"
  }, {
    "month": "7",
    "sales": 984,
    "color": "#04D215"
  }, {
    "month": "8",
    "sales": 711,
    "color": "#0D8ECF"
  }, {
    "month": "9",
    "sales": 665,
    "color": "#0D52D1"
  }, {
    "month": "10",
    "sales": 580,
    "color": "#2A0CD0"
  }, {
    "month": "11",
    "sales": 443,
    "color": "#8A0CCF"
  }, {
    "month": "12",
    "sales": 441,
    "color": "#CD0D74"
  }];

var chart = AmCharts.makeChart("chartdiv", {
  "type": "serial",
  "theme": "light",
  "marginRight": 70,
  "dataProvider": chartData,
  "valueAxes": [{
    "axisAlpha": 0,
    "position": "left",
    "title": "Biểu đồ doanh số tour"
  }],
  "startDuration": 1,
  "graphs": [{
    "balloonText": "<b>[[category]]: [[value]]</b>",
    "fillColorsField": "color",
    "fillAlphas": 0.9,
    "lineAlpha": 0.2,
    "type": "column",
    "valueField": "sales"
  }],
  "chartCursor": {
    "categoryBalloonEnabled": false,
    "cursorAlpha": 0,
    "zoomable": false
  },
  "categoryField": "month",
  "categoryAxis": {
    "gridPosition": "start",
    "labelRotation": 45
  },
  "export": {
    "enabled": true
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