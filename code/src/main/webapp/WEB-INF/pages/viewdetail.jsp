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
								<h3 class="text-center">${tour.name}</h3>
								<p class="fa fa-eye" style="color: red">${tour.view}</p>
								<p class="fa fa-calendar" style="color: red">${tour.departureDate}
									-
									<fmt:formatDate value="${tour.returnDate}" pattern="dd/MM/yyyy" />
								</p>
								<c:if test="${tour.getDepartureDate().after(current)}">
									<img alt="new"
										src="${pageContext.request.contextPath}/resources/img/new.png"
										width="20" height="20">
								</c:if>
								<img alt="new"
									src="${pageContext.request.contextPath}/resources/img/sale.png"
									width="20" height="20">
								<h4 style="color: green;">Giá: ${tour.price}đ</h4>
								<span><a href="${pageContext.request.contextPath}"><input
										class="btn btn-success text-center" type="submit"
										value="Quay về"></a></span> <span><a
									href="${pageContext.request.contextPath}/booktour/${tour.idTour}"><input
										class="btn btn-danger text-center" type="submit"
										value="Đăng ký"></a></span> <br /> <span style="color: white;">${tour.detail}</span>
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