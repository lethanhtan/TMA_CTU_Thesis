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
								<h3 class="text-center" style="color: black;"><strong>${tour.name}</strong></h3>
								<br>
								<hr>
								<div class="col-md-12 col-sm-12 col-xs-12">
									<div class="col-md-4 col-sm-4 col-xs-4">
										<h4  style="color: black;">
											<i class="fa fa-eye"> Lượt xem: <strong>${tour.view}</strong></i>
										</h4>
										<h4  style="color: black;">
											<i class="fa fa-calendar"> Ngày khởi hành: <strong><fmt:formatDate
													value="${tour.departureDate}" pattern="dd/MM/yyyy" /></strong>
											</i>
										</h4>
										<h4  style="color: black;">
											<i class="fa fa-clock-o"> Giờ khởi hành:
												<strong>${tour.departureTime} </strong></i>
										</h4>
										<c:if test="${tour.promotion.percent != 0}">
											<h4  style="color: black;">
												<i class="fa fa-smile-o"> Số chỗ còn nhận:
													<strong>${tour.ticketAvailability}</strong></i>
											</h4>
										</c:if>
									</div>
									<div class="col-md-4 col-sm-4 col-xs-4">
										<h4 style="color: black;">
											<i class="fa fa-car"> Thời gian: <strong>${tour.howLong} ngày</strong></i>
										</h4>
										<c:if test="${tour.promotion.percent != 0}">
											<h4 style="color: black;">
												<i class="fa fa-ticket"> Giá vé: </i>
												<del style="font-size: 18px;"><strong>${tour.price} đ</strong></del>
											</h4>
											<h4 style="color: black;">
												<i class="fa fa-bell-o"> Giảm còn: <span
													style="color: red; font-size: 20px;"><strong>${tour.priceAfterSale}
														đ</strong></span></i>
											</h4>
											<h4 style="color: black;">
												<i class="fa fa-calendar-o"> Thời gian khuyến mãi: </i>
											</h4>
										</c:if>
										<c:if test="${tour.promotion.percent == 0}">
											<h4 style="color: black;">
												<i class="fa fa-ticket"> Giá vé: <strong>${tour.price} đ</strong></i>
											</h4>
											<h4 style="color: black;">
												<i class="fa fa-smile-o"> Số chỗ còn nhận:
													<strong>${tour.ticketAvailability}</strong></i>
											</h4>
										</c:if>
									</div>
									<div class="col-md-4 col-sm-4 col-xs-4">
										<img
											src="http://cungcaphatgiong.com/asset/editor/ResponsiveFilemanager-master/source/Salepage/nhan-uom-ma.gif">
										<br> <a
											href="${pageContext.request.contextPath}/booktour/${tour.idTour}"><button
												class="btn btn-danger" style="margin-left: 5%;">Đăng
												Ký Ngay</button></a><br>
										<c:if test="${tour.promotion.percent != 0}">
											<h5 style="color: white;">
												từ
												<fmt:formatDate value="${tour.promotion.fromDate}"
													pattern="dd/MM/yyyy" />
											</h5>
											<h5 style="color: white;">
												đến
												<fmt:formatDate value="${tour.promotion.toDate}"
													pattern="dd/MM/yyyy" />
											</h5>
										</c:if>
										<c:if test="${tour.promotion.percent == 0}">
											<img alt="new"
												src="${pageContext.request.contextPath}/resources/img/new.png"
												width="20" height="20">
										</c:if>
									</div>
								</div>
								<br>
								<h3 style="color: black;"><strong>Thông tin</strong></h3>
								<h6 style="color: black;">${tour.detail}</h6>
								<hr>
								<h3 style="color: black;"><strong>Chi tiết lịch trình</strong></h3>
								<h6 style="color: black;"><strong>${tour.getSchedule().getDetailSchedule()}</strong></h6>
								<br>
								<hr>
								<h4 style="color: black;"><strong>Dịch vụ đi kèm:</strong></h4>
								<div class="row fa-icon-list">
									<div class="col-md-2">
										<i class="fa fa-umbrella"></i> <br>
										<h4 style="color: black;">Bảo hiểm</h4>
									</div>
									<div class="col-md-2">
										<i class="fa fa-cutlery"></i> <br>
										<h4 style="color: black;">Bữa ăn theo chương trình</h4>
									</div>
									<div class="col-md-2">
										<i class="fa fa-coffee"></i> <br>
										<h4 style="color: black;">Thức uống</h4>
									</div>
									<div class="col-md-2">
										<i class="fa fa-flag"></i> <br>
										<h4 style="color: black;">Hướng dẫn viên</h4>
									</div>
									<div class="col-md-2">
										<i class="fa fa-ticket"></i> <br>
										<h4 style="color: black;">Vé tham quan</h4>
									</div>
									<div class="col-md-2">
										<i class="fa fa-car"></i> <br>
										<h4 style="color: black;">Xe đưa đón</h4>
									</div>
								</div>
								<img style="margin-left: 75%;"
									src="http://cungcaphatgiong.com/asset/editor/ResponsiveFilemanager-master/source/Salepage/nhan-uom-ma.gif">
								<br> <br> <a
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