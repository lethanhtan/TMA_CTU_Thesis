<%-- 
    Document   : faq
    Created on : Jan 15, 2017, 7:31:34 PM
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
			<li class="social-rss"><a href="#" target="_blank" title="RSS"></a>
			</li>
			<li class="social-twitter"><a href="#" target="_blank"
				title="Twitter"></a></li>
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
					<div class="col-md-12">
						<h2>Câu Hỏi Thường Gặp</h2>
						<p>Dưới đây là một số câu hỏi cũng như thắc mắc thường gặp khi
							bạn đến với Website của chúng tôi. Hi vọng có thể giúp được bạn!</p>
						<hr class="margin-vert-40">
						<div class="row">
							<div class="col-md-8">
								<div class="tab-content">
									<div class="tab-pane active in fade" id="faq">
										<div class="panel-group" id="accordion">
											<!-- Faq Item -->
											<div class="panel panel-default panel-faq">
												<div class="panel-heading">
													<a data-toggle="collapse" data-parent="#accordion"
														href="#faq-sub-5">
														<h4 class="panel-title">
															Tạo tài khoản để làm gì? <span class="pull-right">
																<i class="fa-plus-square"></i>
															</span>
														</h4>
													</a>
												</div>
												<div id="faq-sub-5" class="panel-collapse collapse">
													<div class="panel-body">Để được hưởng những chương
														trình ưu đãi dành cho khách hàng là thành viên cũng như
														cập nhật các tin tức mới nhất về công ty chúng tôi thì
														đăng ký tài khoản là cách tốt nhất bạn có thể làm.</div>
												</div>
											</div>
											<!-- End FAQ Item -->
											<!-- FAQ Item -->
											<div class="panel panel-default panel-faq">
												<div class="panel-heading">
													<a data-toggle="collapse" data-parent="#accordion"
														href="#faq-sub">
														<h4 class="panel-title">
															Tại sao chúng tôi yêu cầu thông tin của bạn khi đăng ký
															tài khoản? <span class="pull-right"> <i
																class="fa-plus-square"></i>
															</span>
														</h4>
													</a>
												</div>
												<div id="faq-sub" class="panel-collapse collapse">
													<div class="panel-body">Tài khoản cung cấp cho bạn
														quyền truy cập vào các dịch vụ của hệ thống. Chúng tôi yêu
														cầu một số thông tin cá nhân trong quá trình đăng ký để
														giữ bảo mật tài khoản của bạn và đảm bảo bạn có trải
														nghiệm tuyệt vời, bất kể bạn sử dụng dịch vụ nào của chúng
														tôi.</div>
												</div>
											</div>
											<!-- End FAQ Item -->
											<!-- Faq Item -->
											<div class="panel panel-default panel-faq">
												<div class="panel-heading">
													<a data-toggle="collapse" data-parent="#accordion"
														href="#faq-sub-2">
														<h4 class="panel-title">
															Làm sao để khôi phục tài khoản bị xâm nhập hay đánh cắp?
															<span class="pull-right"> <i
																class="fa-plus-square"></i>
															</span>
														</h4>
													</a>
												</div>
												<div id="faq-sub-2" class="panel-collapse collapse">
													<div class="panel-body">Nếu bạn cho rằng tài khoản
														của mình đã bị xâm phạm, hãy đổi mật khẩu ngay lập tức.
														Sau khi bảo mật cho tài khoản của bạn, bạn sẽ cần phải
														đăng nhập lại trên mỗi thiết bị và trình duyệt đã từng có
														truy cập đầy đủ vào tài khoản của bạn.</div>
												</div>
											</div>
											<!-- End FAQ Item -->
											<!-- Faq Item -->
											<div class="panel panel-default panel-faq">
												<div class="panel-heading">
													<a data-toggle="collapse" data-parent="#accordion"
														href="#faq-sub-3">
														<h4 class="panel-title">
															Làm thế nào để giữ an toàn cho tài khoản của bạn? <span
																class="pull-right"> <i class="fa-plus-square"></i>
															</span>
														</h4>
													</a>
												</div>
												<div id="faq-sub-3" class="panel-collapse collapse">
													<div class="panel-body">
														Bạn hãy thực hiện các bước sau: </br>- Kiểm tra virus và phần
														mềm độc hại. </br>- Cập nhật tùy chọn phục hồi tài khoản của
														bạn. </br>- Thường xuyên cập nhật trình duyệt và hệ điều hành.
														</br>- Sử dụng mật khẩu mạnh, khó nhớ, khó đoán.
													</div>
												</div>
											</div>
											<!-- End FAQ Item -->
											<!-- Faq Item -->
											<div class="panel panel-default panel-faq">
												<div class="panel-heading">
													<a data-toggle="collapse" data-parent="#accordion"
														href="#faq-sub-6">
														<h4 class="panel-title">
															Tạo mật khẩu mạnh như thế nào? <span class="pull-right">
																<i class="fa-plus-square"></i>
															</span>
														</h4>
													</a>
												</div>
												<div id="faq-sub-6" class="panel-collapse collapse">
													<div class="panel-body">
														Dưới đây là một số mẹo giúp bạn tạo mật khẩu mạnh: </br>- Đảm
														bảo mật khẩu của bạn dài ít nhất 8 ký tự. </br>- Kết hợp số và
														chữ cái nhưng không bao gồm các từ thường được sử dụng. </br>-
														Chọn một từ hoặc từ viết tắt và chèn số vào giữa một số
														chữ cái. </br>- Bao gồm dấu chấm câu. </br>- Kết hợp chữ in hoa và
														chữ thường.
													</div>
												</div>
											</div>
											<!-- End FAQ Item -->
											<!-- Faq Item -->
											<div class="panel panel-default panel-faq">
												<div class="panel-heading">
													<a data-toggle="collapse" data-parent="#accordion"
														href="#faq-sub-4">
														<h4 class="panel-title">
															Làm gì khi không đăng ký tham gia tour du lịch được? <span
																class="pull-right"> <i class="fa-plus-square"></i>
															</span>
														</h4>
													</a>
												</div>
												<div id="faq-sub-4" class="panel-collapse collapse">
													<div class="panel-body">Bạn hãy tải lại trang, sau đó
														tiến hành đăng ký lại. Trong trường hợp xấu nhất, hãy gọi
														cho tổng đài hỗ trợ trực tuyến (0710) 3838 474 để được
														đăng ký nhanh chóng.</div>
												</div>
											</div>
											<!-- End FAQ Item -->
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<h3 class="margin-bottom-10">Không tìm thấy câu trả lời
									mong muốn?</h3>
								<p>Mời bạn đặt câu hỏi trên Diễn đàn trợ giúp nếu vẫn chưa
									tìm được câu trả lời trong phần câu hỏi thường gặp.</p>
								<button type="button" class="btn btn-primary btn-sm">Đặt
									câu hỏi</button>
							</div>
						</div>
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
