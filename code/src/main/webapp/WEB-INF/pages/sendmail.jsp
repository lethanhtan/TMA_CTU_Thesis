<!-- === BEGIN HEADER === -->
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="adminheader.jsp" %>
<!-- === END HEADER === -->
<!-- === BEGIN CONTENT === -->
<div id="content">
	<div class="container background-white">
		<div class="row margin-vert-30">
			<!-- Main Column -->
			<div class="col-md-9">
				<!-- Main Content -->
				<div class="headline">
					<h2>Gửi mail</h2>
				</div>
				<br>
				<!-- Mail Form -->
				<a><button class="btn btn-primary fa-plus-square">Cấu hình</button></a>
				<a><button class="btn btn-primary fa-plus-square">Thư đã gửi</button></a>
				<form>
					<small style="color:green;">${sendSuccess}</small>
					<small style="color:red;">${failedConnect}</small>
					<br />
					<label>Người gửi <span class="color-red">*</span>
					</label>
					<div class="row margin-bottom-20">
						<div class="col-md-6 col-md-offset-0">
							<input class="form-control" type="text" name="from">
						</div>
					</div>
					<label>Mật khẩu <span class="color-red">*</span>
					</label>
					<div class="row margin-bottom-20">
						<div class="col-md-6 col-md-offset-0">
							<input class="form-control" type="password" name="password">
						</div>
					</div>
					<label>Người nhận <span class="color-red">*</span>
					</label>
					<div class="row margin-bottom-20">
						<div class="col-md-6 col-md-offset-0">
							<input class="form-control" type="text" name="to">
						</div>
					</div>
					<label>Cc <span class="color-red"></span>
					</label>
					<div class="row margin-bottom-20">
						<div class="col-md-6 col-md-offset-0">
							<input class="form-control" type="text">
						</div>
					</div>
					<label>Chủ đề <span class="color-red">*</span>
					</label>
					<div class="row margin-bottom-20">
						<div class="col-md-6 col-md-offset-0">
							<input class="form-control" type="text" name="subject">
						</div>
					</div>
					<label>Nội Dung <span class="color-red">*</span></label>
					<div class="row margin-bottom-20">
						<div class="col-md-8 col-md-offset-0">
							<textarea rows="7" class="form-control" name="message"></textarea>
						</div>
					</div>
					<label style="color: red; font-style: italic;">(*) Nội dung
						bắt buộc phải điền </label>
					<p>
						<button type="submit" class="btn btn-primary">Gửi</button>
					</p>
				</form>
				<!-- End Contact Form -->
				<!-- End Main Content -->
			</div>
			<!-- End Main Column -->
			<!-- Side Column -->
			<div class="col-md-3">
				<!-- Recent Posts -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Tài khoản đăng nhập</h3>
					</div>
					<div class="panel-body">
						<ul class="list-unstyled">
							<li><i class="fa-phone color-primary"></i>(0710) 3838 474</li>
							<li><i class="fa-envelope color-primary"> <a
									href="mailto:iNYtravel@gmail.com"></i>NYtravel@gmail.com</a></li>
							<li><i class="fa-home color-primary"> <a
									href="http://www.NYtravel.com"></i>www.NYtravel.com</a></li>
						</ul>
						<ul class="list-unstyled">
							<li><strong class="color-primary">Số giờ online
									việc:</strong> 24/7</li>
						</ul>
					</div>
				</div>
				<!-- End recent Posts -->
				<!-- About -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Thống kê mail</h3>
					</div>
					<div class="panel-body">
					<p>- Số mail đã gửi: 
						- Số mail đăng ký đã gủi:
						- Số mail thông báo đã gủi: 
					</p>
					</div>
				</div>
				<!-- End About -->
			</div>
			<!-- End Side Column -->
		</div>
	</div>
</div>
<!-- === END CONTENT === -->
<!-- === BEGIN FOOTER === -->
<%@ include file="userfooter.jsp" %>
<!-- === END FOOTER === -->