<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="userheader.jsp" %>
<!-- Back To Top -->
<div title="Về đầu trang" onmouseover="this.style.color='#590059'"
	onmouseout="this.style.color='#004993'" id="top-up">
	<img src="resources/img/hot-air-balloon.png" width="64px" height="auto"></img>
</div>
<!-- End Back To Top -->
<!-- === BEGIN CONTENT === -->
<div id="content">
	<div class="container background-white">
		<div class="row margin-vert-30">
			<!-- Search Form -->
			<div class="error-404-page text-center" style="margin-left: 650px;">
				<form class="form-search search-404">
					<div class="input-append">
						<input type="text" class="span2 search-query"
							placeholder="Nhập họ tên/ điện thoại/ email">
						<button type="submit" class="btn btn-primary">Tìm Kiếm</button>
					</div>
				</form>
			</div>
			<!-- End Search Form -->

			<!-- Register Box -->
			<div class="col-md-6 col-md-offset-3 col-sm-offset-3">
				<form class="signup-page">
					<div class="signup-header">
						<h2>Đặt Vé</h2>
						<img alt="Web Counter" border="0"
							src="http://pumpernickelpixie.com/wp-content/uploads/2015/06/31.gif"
							width="500px" height="250px"
							style="display: block; margin-right: auto; margin-left: auto; text-align: center" />
					</div>
					<!-- <div class="row">
								<div class="col-sm-6">
									<label>Tỉnh đi</label>
									<div class="input-group margin-bottom-20">
										<span class="input-group-addon"> <i
											class="fa fa-map-marker"></i>
										</span> <input placeholder="Nhập tỉnh đi" class="form-control"
											type="text" list="placego">
										<datalist id="placego">
											<option value="Bạc Liêu">
											<option value="Cà Mau">
											<option value="Cần Thơ">
											<option value="Đồng Tháp">
											<option value="Kiên Giang">
											<option value="Sóc Trăng">
											<option value="Vĩnh Long">
										</datalist>
									</div>
								</div>
								<div class="col-sm-6">
									<label>Tỉnh đến</label>
									<div class="input-group margin-bottom-20">
										<span class="input-group-addon"> <i
											class="fa fa-map-marker"></i>
										</span> <input placeholder="Nhập tỉnh đến" class="form-control"
											type="text" list="placearrive">
										<datalist id="placearrive">
											<option value="Bạc Liêu">
											<option value="Cà Mau">
											<option value="Cần Thơ">
											<option value="Đồng Tháp">
											<option value="Kiên Giang">
											<option value="Sóc Trăng">
											<option value="Vĩnh Long">
										</datalist>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6">
									<label>Ngày đi</label>
									<div class="input-group margin-bottom-20">
										<span class="input-group-addon"> <i
											class="fa fa-calendar"></i>
										</span> <input placeholder="mm/dd/yyyy" id="datepicker"
											class="form-control" type="text" name="datestart">
									</div>
								</div>
								<div class="col-sm-6">
									<label>Giờ đi</label>
									<div class="input-group margin-bottom-20">
										<span class="input-group-addon"> <i
											class="fa fa-clock-o"></i>
										</span> <select class="form-control margin-bottom-20">
											<option>8:00</option>
											<option>10:00</option>
											<option>12:00</option>
											<option>14:00</option>
											<option>16:00</option>
											<option>18:00</option>
											<option>20:00</option>
										</select>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6">
									<label>Giá vé</label>
									<div class="input-group margin-bottom-20">
										<span class="input-group-addon"> <i class="fa fa-money"></i>
										</span> <input class="form-control" type="text" readonly="readonly">
									</div>
								</div>
								<div class="col-sm-6">
									<label>Chỗ còn trống</label>
									<div class="input-group margin-bottom-20">
										<span class="input-group-addon"> <i
											class="fa fa-ticket"></i>
										</span> <input class="form-control" type="text" readonly="readonly">
									</div>
								</div>
							</div> -->
					<div class="row">
						<div class="col-sm-8">
							<label>Họ tên</label>
							<div class="input-group margin-bottom-20">
								<span class="input-group-addon"> <i class="fa fa-font"></i>
								</span> <input placeholder="Nhập họ tên" class="form-control"
									type="text">
							</div>
						</div>
						<div class="col-sm-4">
							<label>Giới tính</label>
							<div class="input-group margin-bottom-20">
								<span class="input-group-addon"> <i class="fa fa-male"></i>
								</span> <select class="form-control margin-bottom-20">
									<option>Nam</option>
									<option>Nữ</option>
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-7">
							<label>Email</label>
							<div class="input-group margin-bottom-20">
								<span class="input-group-addon"> <i
									class="fa fa-envelope"></i>
								</span> <input placeholder="Nhập email" class="form-control"
									type="text">
							</div>
						</div>
						<div class="col-sm-5">
							<label>Số điện thoại</label>
							<div class="input-group margin-bottom-20">
								<span class="input-group-addon"> <i class="fa fa-tablet"></i>
								</span> <input placeholder="Nhập số điện thoại" class="form-control"
									type="text">
							</div>
						</div>
					</div>
					<label>Địa chỉ</label>
					<div class="input-group margin-bottom-20">
						<span class="input-group-addon"> <i class="fa fa-home"></i>
						</span> <input placeholder="Nhập địa chỉ" class="form-control"
							type="text">
					</div>
					<hr>
					<div class="row">
						<div class="col-lg-4 text-left">
							<button class="btn btn-primary" type="submit">Đăng Ký</button>
						</div>
						<div class="col-lg-4 text-center">
							<a href="/TravelSystem/booktour"><button
									class="btn btn-primary" type="button">Hủy Bỏ</button></a>
						</div>
						<div class="col-lg-4 text-right">
							<button class="btn btn-primary" type="reset">Nhập Lại</button>
						</div>
					</div>
				</form>
			</div>
			<!-- End Register Box -->
		</div>
	</div>
</div>
<!-- === END CONTENT === -->
<%@ include file="userfooter.jsp" %>
