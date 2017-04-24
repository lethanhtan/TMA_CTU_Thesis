<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="userheader.jsp"%>
<!-- === BEGIN CONTENT === -->
<div id="content">
	<div class="container background-white">
		<div class="container">
			<div class="row margin-vert-40">
				<!-- Portfolio -->
				<ul class="portfolio-group">
					<!-- Portfolio Item -->
					<li class="portfolio-item col-sm-12 col-xs-12 padding-20"><a
						href="#"> <img class="text-center" alt="SaDecFlowerVillage"
							src="${pageContext.request.contextPath}/image/${tour.image}">
							<figcaption>
								<h3 class="text-center" style="color: yellow;">${tour.name}</h3>
								<br>
								<hr>
								<div class="col-md-12 col-sm-12 col-xs-12">
									<div class="col-md-4 col-sm-4 col-xs-4">
										<h4 style="color: white;">
											<i class="fa fa-eye"> Lượt xem: ${tour.view}</i>
										</h4>
										<h4 style="color: white;">
											<i class="fa fa-calendar"> Ngày khởi hành: <fmt:formatDate
													value="${tour.departureDate}" pattern="dd/MM/yyyy" />
											</i>
										</h4>

										<h4 style="color: white;">
											<i class="fa fa-clock-o"> Giờ khởi hành:
												${tour.departureTime} </i>
										</h4>
									</div>
									<div class="col-md-4 col-sm-4 col-xs-4">
										<h4 style="color: white;">
											<i class="fa fa-car"> Thời gian: ${tour.howLong} ngày </i>
										</h4>
										<h4 style="color: white;">
											<i class="fa fa-ticket"> Giá vé: ${tour.price} đ</i>
										</h4>
										<h4 style="color: white;">
											<i class="fa fa-smile-o"> Số chỗ còn nhận:
												${tour.ticketAvailability}</i>
										</h4>
									</div>
									<div class="col-md-4 col-sm-4 col-xs-4">
										<img
											src="http://cungcaphatgiong.com/asset/editor/ResponsiveFilemanager-master/source/Salepage/nhan-uom-ma.gif">
										<br> <a
											href="${pageContext.request.contextPath}/booktour/${tour.idTour}"><button
												class="btn btn-danger" style="margin-left: 5%;">Đăng
												Ký Ngay</button></a>
									</div>
								</div>
								<c:if test="${tour.getDepartureDate().after(current)}">
									<img alt="new"
										src="${pageContext.request.contextPath}/resources/img/new.png"
										width="20" height="20">
								</c:if>
								<img alt="new"
									src="${pageContext.request.contextPath}/resources/img/sale.png"
									width="20" height="20">
								<h3 style="color: blue;">Thông tin:</h3>
								<h6 style="color: white;">${tour.detail}</h6>
								<hr>
								<h3 style="color: blue;">Chi tiết lịch trình:</h3>
								<h6 style="color: white;">${tour.getSchedule().getDetailSchedule()}</h6>
								<br>
								<hr>
								<h4 style="color: white;">Dịch vụ đi kèm:</h4>
								<div class="row fa-icon-list">
									<div class="col-md-2">
										<i class="fa fa-umbrella"></i> <br>
										<h4 style="color: white;">Bảo hiểm</h4>
									</div>
									<div class="col-md-2">
										<i class="fa fa-cutlery"></i> <br>
										<h4 style="color: white;">Bữa ăn theo chương trình</h4>
									</div>
									<div class="col-md-2">
										<i class="fa fa-coffee"></i> <br>
										<h4 style="color: white;">Thức uống</h4>
									</div>
									<div class="col-md-2">
										<i class="fa fa-flag"></i> <br>
										<h4 style="color: white;">Hướng dẫn viên</h4>
									</div>
									<div class="col-md-2">
										<i class="fa fa-ticket"></i> <br>
										<h4 style="color: white;">Vé tham quan</h4>
									</div>
									<div class="col-md-2">
										<i class="fa fa-car"></i> <br>
										<h4 style="color: white;">Xe đưa đón</h4>
									</div>
								</div>
								<img style="margin-left: 75%;"
									src="http://cungcaphatgiong.com/asset/editor/ResponsiveFilemanager-master/source/Salepage/nhan-uom-ma.gif">
								<br>
								<br> <a
									href="${pageContext.request.contextPath}/booktour/${tour.idTour}"><button
										class="btn btn-danger" style="margin-left: 75%;">Đăng
										Ký Ngay</button></a> <a href="${pageContext.request.contextPath}"><button
										class="btn btn-success">Trở Về</button></a><br>
							</figcaption>
					</a></li>
				</ul>
				<!-- //Portfolio Item// -->
			</div>
		</div>
	</div>
</div>
<!-- === END CONTENT === -->
<%@ include file="userfooter.jsp"%>