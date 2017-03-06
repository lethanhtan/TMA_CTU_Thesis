<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="userheader.jsp" %>
<!-- === BEGIN CONTENT === -->
<div id="content">
	<div class="container background-white">
		<div class="row margin-vert-30">
			<!-- Main Column -->
			<div class="col-md-9">
				<!-- Main Content -->
				<div class="headline">
					<h2>Liên Hệ</h2>
				</div>
				<br>
				<!-- Contact Form -->
				<form>
					<label>Họ Tên <span class="color-red">*</span></label>
					<div class="row margin-bottom-20">
						<div class="col-md-6 col-md-offset-0">
							<input class="form-control" type="text">
						</div>
					</div>
					<label>Địa Chỉ Email <span class="color-red">*</span>
					</label>
					<div class="row margin-bottom-20">
						<div class="col-md-6 col-md-offset-0">
							<input class="form-control" type="text">
						</div>
					</div>
					<label>Nội Dung <span class="color-red">*</span></label>
					<div class="row margin-bottom-20">
						<div class="col-md-8 col-md-offset-0">
							<textarea rows="7" class="form-control"></textarea>
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
						<h3 class="panel-title">Thông Tin Liên Hệ</h3>
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
							<li><strong class="color-primary">Thời gian làm
									việc:</strong> 24/7</li>
						</ul>
					</div>
				</div>
				<!-- End recent Posts -->
				<!-- About -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Giới Thiệu</h3>
					</div>
					<div class="panel-body">NY Travel Company được thành lập từ
						năm 2016. Sau một năm phấn đấu, NY Travel Company đã tạo dựng được
						niềm tin vững chắc trong lòng khách hàng, những người có sở thích
						du lịch, khám phá các vùng miền khác lạ trong khu vực Đồng bằng
						sông Cửu Long.</div>
				</div>
				<!-- End About -->
			</div>
			<!-- End Side Column -->
			<!--  Map -->
			<iframe width="1000" height="350" frameborder="0"
				style="border: 0; display: block; margin-right: auto; margin-left: auto; text-align: center;"
				src="https://www.google.com/maps/embed/v1/place?q=Can%20Tho%20University&key=AIzaSyCIBw6iN2PD-z9GUqFdLJeeKJuhzodUhe8"
				allowfullscreen></iframe>
			</br>
			<!-- End Map -->
		</div>
	</div>
</div>
<!-- === END CONTENT === -->
<%@ include file="userfooter.jsp" %>