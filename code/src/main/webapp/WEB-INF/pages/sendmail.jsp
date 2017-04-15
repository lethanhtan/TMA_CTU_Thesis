<!-- === BEGIN HEADER === -->
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="userheader.jsp" %>
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
				<!-- Contact Form -->
				<form>
					<label>Họ Tên <span class="color-red">*</span></label>
					<div class="row margin-bottom-20">
						<div class="col-md-6 col-md-offset-0">
							<input class="form-control" type="text">
						</div>
					</div>
					<label>Người gửi <span class="color-red">*</span>
					</label>
					<div class="row margin-bottom-20">
						<div class="col-md-6 col-md-offset-0">
							<input class="form-control" type="text">
						</div>
					</div>
					<label>Người nhận <span class="color-red">*</span>
					</label>
					<div class="row margin-bottom-20">
						<div class="col-md-6 col-md-offset-0">
							<input class="form-control" type="text">
						</div>
					</div>
					<label>Cc <span class="color-red">*</span>
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
		</div>
	</div>
</div>
<!-- === END CONTENT === -->
<!-- === BEGIN FOOTER === -->
<%@ include file="userfooter.jsp" %>
<!-- === END FOOTER === -->