<%-- 
    Document   : managetour
    Created on : Feb 08, 2017, 3:30:09 PM
    Author     : TranLeQueNgoc
--%>

<!-- === BEGIN HEADER === -->
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

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
<link rel="stylesheet" href="resources/css/bootstrap.css" rel="stylesheet">
<!-- Template CSS -->
<link rel="stylesheet" href="resources/css/animate.css" rel="stylesheet">
<link rel="stylesheet" href="resources/css/font-awesome.css" rel="stylesheet">
<link rel="stylesheet" href="resources/css/nexus.css" rel="stylesheet">
<link rel="stylesheet" href="resources/css/responsive.css" rel="stylesheet">
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
						<a href="home" title=""> <img src="resources/img/icon/logo.png"
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
				<div class="row margin-vert-30">
					<!-- Search Form -->
					<div class="error-404-page text-center" style="margin-left: 650px;">
						<form class="form-search search-404">
							<div class="input-append">
								<input type="text" class="span2 search-query"
									placeholder="Nhập từ khóa">
								<button type="submit" class="btn btn-primary">Tìm Kiếm</button>
							</div>
						</form>
					</div>
					<!-- End Search Form -->
					<div class="col-md-12">
						<h2 class="margin-vert-20" style="margin-left: 350px;">Danh
							Sách Tour Du Lịch</h2>
						<a href="tao-tour"><button
								class="btn btn-primary fa-plus-square">Tạo Mới</button></a>
						<div class="row margin-bottom-30">
							<div class="col-md-4 animate fadeInRight"></div>
							<div class="col-md-8 animate fadeIn"></div>
							<div class="col-md-12 animate fadeInRight"></div>
						</div>
						<!-- Table -->
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
								<tr>
									<td>NY01</td>
									<td>Cần Thơ - Vĩnh Long - Bạc Liêu</td>
									<td>&nbsp;&nbsp;&nbsp; 12/12/2017</td>
									<td>&nbsp;&nbsp;&nbsp; 10:30 &nbsp;&nbsp;&nbsp;</td>
									<td><a href="#" title="Xem"> <i class="fa fa-eye">&nbsp;</i>
									</a> <a href="tao-tour" title="Sửa"> <i class="fa fa-pencil">&nbsp;</i>
									</a> <a data-toggle="modal" href="#deleteConfirm" title="Xóa"> <i
											class="fa fa-trash-o"></i>
									</a></td>
								</tr>

								<!-- Popup Cofirm -->
								<div id="deleteConfirm" class="modal fade">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal"
													aria-hidden="true">&times;</button>
												<h4 class="modal-title">Bạn muốn xóa tour đã chọn?</h4></br>
												<button type="button" class="btn btn-default">Có</button>
												<button type="button" class="btn btn-primary"
													data-dismiss="modal">Không</button>
											</div>
										</div>
									</div>
								</div>
								<!-- End Popup Cofirm -->

								<tr>
									<td>NY02</td>
									<td>Cần Thơ - Vĩnh Long - Bạc Liêu - Cà Mau</td>
									<td>&nbsp;&nbsp;&nbsp; 12/12/2017</td>
									<td>&nbsp;&nbsp;&nbsp; 10:30 &nbsp;&nbsp;&nbsp;</td>
									<td><a href="tao-tour" title="Xem"> <i
											class="fa fa-eye">&nbsp;</i>
									</a> <a href="tao-tour" title="Sửa"> <i class="fa fa-pencil">&nbsp;</i>
									</a> <a href="quan-ly-tour" title="Xóa"> <i
											class="fa fa-trash-o"></i>
									</a></td>
								</tr>
							</tbody>
						</table>
						<!-- End Table -->
						<hr class="margin-bottom-50">
						<div class="row">
							<div class="col-md-6">
								<div class="row">
									<div class="col-sm-3"></div>
								</div>
								<div class="row">
									<div class="col-sm-3"></div>
								</div>
								<div class="row">
									<div class="col-sm-3"></div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="row">
									<div class="col-sm-3"></div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="row">
									<div class="col-sm-3"></div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="row">
									<div class="col-sm-3"></div>
								</div>
							</div>
						</div>
						<hr class="margin-vert-40">
					</div>
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
		<script type="text/javascript" src="resources/js/slimbox2.js" charset="utf-8"></script>
		<!-- Modernizr -->
		<script src="resources/js/modernizr.custom.js" type="text/javascript"></script>
		<!-- End JS -->
</body>
</html>
<!-- === END FOOTER === -->