<!-- === BEGIN HEADER === -->
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="adminheader.jsp"%>
<!-- === END HEADER === -->
<!-- === BEGIN CONTENT === -->
<div id="content">
	<div class="container background-white">
		<div class="row margin-vert-30">
			<!-- Tab v2 -->
			<div class="tabs alternative">
				<ul class="nav nav-tabs" id="myTab">
					<li class="active"><a href="#mailconfig" data-toggle="tab">Cấu
							hình Mail Server</a></li>
					<li><a href="#sendmail" data-toggle="tab">Gửi Email</a></li>
				</ul>
				<div class="tab-content">
					<!-- Start Mail Config Tab -->
					<div class="tab-pane fade in active" id="mailconfig">
						<form>
							<div>
								<div class="row margin-bottom-20">
									<div class="col-md-12 col-md-offset-3">
										<div class="col-sm-6 col-md-6">
											<small style="color: green;">${status}</small> <br /> <small
												style="color: red;">${failedConnect}</small> <br /> <label>Tài
												khoản email</label> <input class="form-control" type="text"
												name="from">
										</div>
									</div>
								</div>
								<div class="row margin-bottom-20">
									<div
										class="row col-md-12 col-sm-6 col-md-offset-3 col-sm-offset-3">
										<div class="col-md-3 col-sm-3">
											<label>Mật khẩu </label> <input class="form-control"
												type="password" name="password">
										</div>
										<div class="col-md-3 col-sm-3">
											<label>Encoding</label> <select class="form-control"
												name="encoding">
												<option>UTF-8</option>
												<option>UTF-16</option>
												<option>ISO-8859-2</option>
											</select>
										</div>
									</div>
								</div>
								<div class="row margin-bottom-20">
									<div
										class="row col-md-12 col-sm-12 col-sm-offset-3 col-md-offset-3">
										<div class="col-md-3">
											<label>Mail server </label> <select class="form-control"
												name="host">
												<option>Gmail</option>
												<option>Outlook</option>
											</select>
										</div>
										<div class="col-md-3">
											<label>Cổng</label> <select class="form-control" name="port">
												<option>587</option>
												<option>588</option>
											</select>
										</div>
									</div>
								</div>
								<div class="row">
									<div
										class="col-sm-12 col-md-12 col-md-offset-4 col-sm-offset-4">
										<div class="col-sm-3 col-md-3">
											<button type="submit" class="btn btn-primary">Xác
												nhận</button>
										</div>
										<div class="col-sm-3 col-md-3">
											<button type="submit" class="btn btn-primary">Hủy bỏ</button>
										</div>
									</div>
								</div>
							</div>
						</form>
					</div>
					<!-- End Mail Config Tab -->
					<!-- Start Send Mail Tab -->
					<div class="tab-pane fade in" id="sendmail">
						<!-- Mail Form -->
						<div class="row">
							<div class="col-md-8">
								<form>
									<small style="color: green;">${sendSuccess}</small> <small
										style="color: red;">${failedConnect}</small> <br /> <label>Người
										nhận <span class="color-red">*</span>
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
									<label style="color: red; font-style: italic;">(*) Nội
										dung bắt buộc phải điền </label>
									<p>
										<button type="submit" class="btn btn-primary">Gửi</button>
									</p>
								</form>
							</div>
							<!-- End Main Content -->
							<!-- End Send Mail Tab -->
							<!-- Side Column -->
							<div class="col-md-4">
								<!-- Recent Posts -->
								<div class="panel panel-default">
									<div class="panel-heading">
										<h3 class="panel-title">Tài khoản đăng nhập</h3>
									</div>
									<div class="panel-body">
										<ul class="list-unstyled">
											<li><i class="fa-phone color-primary">${phoneUser}</i></li>
											<li><a href="mailto:${emailConfig}"><i
													class="fa-envelope color-primary">${emailConfig}</i></a></li>
											<li><a href="#"><i class="fa-home color-primary">Quản
												trị viên</i></a></li>
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
										<h3 class="panel-title">Thống kê</h3>
									</div>
									<div class="panel-body">
										<ul class="list-unstyled">
											<li><i>Tổng số mail đã gửi: ${totalMail}</i></li>
											<li><i>Số mail gửi thành công: ${numSuccess}</i></li>
											<li><i>Số mail gửi thất bại: ${totalMail - numSuccess}</i></li>
										</ul>
									</div>
								</div>
								<!-- End About -->
							</div>
							<!-- End Side Column -->
						</div>
					</div>
				</div>
				<!-- End Tab Content -->
			</div>
			<!-- End Tab -->
		</div>
	</div>
</div>
<!-- === END CONTENT === -->
<!-- === BEGIN FOOTER === -->
<%@ include file="userfooter.jsp"%>
<!-- === END FOOTER === -->