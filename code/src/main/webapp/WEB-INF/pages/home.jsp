<!-- === BEGIN HEADER === -->
<%@page import="edu.ctu.thesis.travelsystem.model.Tour"%>
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="userheader.jsp"%>
<!-- === END HEADER === -->
<!-- === BEGIN CONTENT === -->
<div id="content">
	<div class="container no-padding">
		<div class="row">
			<!-- Carousel Slideshow -->
			<div id="carousel-example" class="carousel slide"
				data-ride="carousel">
				<!-- Carousel Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#carousel-example" data-slide-to="0"
						class="active"></li>
					<li data-target="#carousel-example" data-slide-to="1"></li>
					<li data-target="#carousel-example" data-slide-to="2"></li>
					<li data-target="#carousel-example" data-slide-to="3"></li>
					<li data-target="#carousel-example" data-slide-to="4"></li>
				</ol>
				<div class="clearfix"></div>
				<!-- End Carousel Indicators -->
				<!-- Carousel Images -->
				<div class="carousel-inner">
					<div class="item active">
						<img src="resources/img/slideshow/DongThapMuoi.jpg">
					</div>
					<div class="item">
						<img src="resources/img/slideshow/DaoPhuQuoc.jpg">
					</div>
					<div class="item">
						<img src="resources/img/slideshow/DaLat.jpg">
					</div>
					<div class="item">
						<img src="resources/img/slideshow/BenTre.jpg">
					</div>
					<div class="item">
						<img src="resources/img/slideshow/TienGiang.jpg">
					</div>
				</div>
				<!-- End Carousel Images -->
				<!-- Carousel Controls -->
				<a class="left carousel-control" href="#carousel-example"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left"></span>
				</a> <a class="right carousel-control" href="#carousel-example"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right"></span>
				</a>
				<!-- End Carousel Controls -->
			</div>
			<!-- End Carousel Slideshow -->
		</div>
	</div>
	<div class="container background-gray-lighter">
		<div class="row margin-vert-40">
			<div class="col-md-4">
				<div class="col-md-4">
					<i class="fa-thumbs-up fa-5x color-primary"></i>
				</div>
				<div class="col-md-8">
					<h2 class="margin-top-5 margin-bottom-0">100+</h2>
					<p>XE CHẤT LƯỢNG CAO</p>
				</div>
			</div>
			<div class="col-md-4">
				<div class="col-md-4">
					<i class="fa-road fa-5x color-primary"></i>
				</div>
				<div class="col-md-8">
					<h2 class="margin-top-5 margin-bottom-0">500+</h2>
					<p>TUYẾN ĐƯỜNG</p>
				</div>
			</div>
			<div class="col-md-4">
				<div class="col-md-4">
					<i class="fa-ticket fa-5x color-primary"></i>
				</div>
				<div class="col-md-8">
					<h2 class="margin-top-5 margin-bottom-0">3.000+</h2>
					<p>VÉ ĐÃ BÁN</p>
				</div>
			</div>
		</div>
	</div>
	<div class="container background-white">
		<div class="row margin-vert-30">
			<!-- Main Text -->
			<div class="col-md-12">
				<h2 class="text-center">Chào mừng đến với công ty NY Travel</h2>
				<p class="text-center">Chính thức thành lập vào tháng 12 năm
					2016, NY Travel Co. hiện là một trong những đơn vị lữ hành hàng đầu
					của thành phố Cần Thơ nói riêng và vùng Tây Nam Bộ nói chung. Kế
					thừa và phát huy kinh nghiệm, bản lĩnh của thương hiệu du lịch nổi
					tiếng NY Travel đã trở thành địa chỉ tin cậy của đông đảo du khách
					trong khu vực đồng bằng sông Cửu Long.</p>
				<p class="text-center">Với tốc độ tăng trưởng kinh tế ấn tượng
					và trình độ dân trí đang ngày càng nâng cao, NY Travel Co. đã có
					đầu tư hết sức bài bản từ khâu tuyển chọn nhân sự, hoàn thiện khả
					năng giao tiếp với khách hàng cho đến việc giới thiệu các tour du
					lịch chất lượng cao theo đúng chuẩn quốc tế. Bên cạnh đó, những
					chương trình khuyến mãi hấp dẫn thường niên đã tạo nên một sức hút
					lớn đối với du khách. Sau mỗi chuyến đi, tất cả du khách đều thể
					hiện sự hài lòng về chất lượng dịch vụ tốt, hướng dẫn viên nhiệt
					tình, chu đáo và luôn sẵn sàng hỗ trợ khách hàng.</p>
			</div>
			<!-- End Main Text -->
		</div>
	</div>
	<div class="container background-gray-lighter">
		<div class="row padding-vert-20">
			<c:if test="${!empty tourList}">
				<div class="row col-md-12 col-sm-12 col-xs-12 col-lg-12">
					<c:forEach items="${tourList.subList(x,y)}" var="tour">
						<!-- Portfolio -->
						<ul class="portfolio-group">
							<!-- Portfolio Item -->
							<li class="portfolio-item padding-10 col-md-6 col-sm-6 col-xs-6 col-lg-6"><a
								href="${pageContext.request.contextPath}/viewdetail/${tour.idTour}">
									<figure class="animate fadeInLeft">
										<img alt="${tour.image}"
											src="${pageContext.request.contextPath}/image/${tour.image}">
										<figcaption>
											<h3 style="color: yellow;">${tour.name}</h3>
											<h5 style="color: white;">
												<i class="fa fa-eye"> Lượt xem: ${tour.view}</i>
											</h5>
											<h5 style="color: white;">
												<i class="fa fa-calendar"> Ngày khởi hành: <fmt:formatDate
														value="${tour.departureDate}" pattern="dd/MM/yyyy" />
												</i>
											</h5>
											<h5 style="color: white;">
												<i class="fa fa-clock-o"> Giờ khởi hành:
													${tour.departureTime} </i>
											</h5>
											<h5 style="color: white;">
												<i class="fa fa-car"> Thời gian: ${tour.howLong} ngày </i>
											</h5>
											<h5 style="color: white;">
												<i class="fa fa-ticket"> Giá vé: ${tour.price} đ</i>
											</h5>
											<c:if test="${tour.getDepartureDate().after(current)}">
												<img alt="new"
													src="${pageContext.request.contextPath}/resources/img/new.png"
													width="20" height="20">
											</c:if>
											<img alt="new"
												src="${pageContext.request.contextPath}/resources/img/sale.png"
												width="20" height="20">
											<h5 style="color: white;">${tour.getSchedule().getSumary()}</h5>
											<div class="text-center">
												<br> <a
													href="${pageContext.request.contextPath}/viewdetail/${tour.idTour}"><button
														class="btn btn-success">Chi Tiết</button></a> <a
													href="${pageContext.request.contextPath}/booktour/${tour.idTour}"><button
														class="btn btn-danger">Đăng Ký</button></a>
											</div>
										</figcaption>
									</figure>
							</a></li>
							<!-- //Portfolio Item// -->
						</ul>
						<!-- End Portfolio -->
					</c:forEach>
				</div>
			</c:if>
		</div>
		<div class="text-center">
			<!-- Pagination -->
			<c:if test="${numTour > numOnPage}">
				<!-- Paging when number of element > number of tour -->
				<!-- set active pagination when numTour >= 5 -->
				<ul class="pagination">
					<c:if test="${param.page != null}">
						<c:if test="${param.page == 1}">
							<li class="disabled"></li>
						</c:if>
						<c:if test="${param.page > 1 }">
							<li><a
								href="${pageContext.request.contextPath }/home?page=${param.page -1}">&laquo;</a>
							</li>
						</c:if>
					</c:if>
					<c:forEach items="${pageNum}" var="pageE">
						<c:if test="${pageE == page}">
							<li class="active"><a
								href="${pageContext.request.contextPath}/home?page=${pageE}">${pageE}</a></li>
						</c:if>
						<c:if test="${pageE != page}">
							<li><a
								href="${pageContext.request.contextPath}/home?page=${pageE}">${pageE}</a></li>
						</c:if>
					</c:forEach>
					<c:if test="${numTour/numOnPage - param.page == 0}">
						<li class="disabled"></li>
					</c:if>
					<c:if test="${numTour/numOnPage - param.page > 0}">
						<li><a
							href="${pageContext.request.contextPath }/home?page=${page + 1}">&raquo;</a></li>
					</c:if>
				</ul>
			</c:if>
		</div>
		<!-- End Pagination -->
	</div>
	<div class="container background-white">
		<div class="row padding-vert-40">
			<div class="col-md-12">
				<h2 class="animate fadeIn text-center">Cơ hội việc làm</h2>
				<p class="animate fadeIn text-center">Nếu bạn muốn làm việc với
					đội ngũ sáng tạo trong một môi trường năng động và thân thiện thì
					gọi chúng tôi ngay bây giờ!</p>
				<p class="animate fadeInUp text-center">
					<button class="btn btn-primary btn-lg" type="button">Xem
						chi tiết</button>
				</p>
			</div>
		</div>
	</div>
</div>
<!-- === END CONTENT === -->
<!-- === BEGIN FOOTER === -->
<%@ include file="userfooter.jsp"%>
<!-- === END FOOTER === -->