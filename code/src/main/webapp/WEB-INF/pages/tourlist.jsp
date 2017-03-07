<<<<<<< HEAD
<!-- === BEGIN HEADER === -->
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="userheader.jsp" %>
<!-- === END HEADER === -->
=======
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="userheader.jsp" %>
>>>>>>> 2e01d0fb0f21ac9e80fe063dcf4a0e00c54efdc0
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
			<div class="col-md-12">
				<h2 class="margin-vert-20" style="text-align: center;">Danh
					Sách Tour Du Lịch</h2>
				<div class="row margin-bottom-30">
					<div class="col-md-4 animate fadeInRight"></div>
					<div class="col-md-8 animate fadeIn"></div>
					<div class="col-md-12 animate fadeInRight"></div>
				</div>
				<!-- Table -->
				<c:if test="${empty tourList}">
					<h1>Không có tour nào!</h1>
				</c:if>
				<c:if test="${!empty tourList}">
					<table>
						<thead>
							<tr>
								<th>Mã tour</th>
								<th>Tên tour</th>
								<th>Ngày đi</th>
								<th>Giờ đi</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${tourList}" var="tour">
								<tr>
									<td>${tour.idTour}</td>
									<td>${tour.name}</td>
									<td>&nbsp;&nbsp;&nbsp; ${tour.departureDate}</td>
									<td>&nbsp;&nbsp;&nbsp; ${tour.departureTime}
										&nbsp;&nbsp;&nbsp;</td>
									<td><a href="<c:url value='detail/${tour.idTour}'/>"
										title="Xem"> <i class="fa fa-eye">&nbsp;</i>
									</a> <a href="<c:url value='booktour/${tour.idTour}'/>"
										title="Đăng Ký"> <i class="fa fa-edit">&nbsp;</i>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
				<!-- End Table -->
				<hr class="margin-vert-50">
				<!-- Pagination -->
				<c:if test="${numTour > 2}">
					<ul class="pagination">
						<li><a href="#">&laquo;</a></li>
						<li class="active"><a href="#">1</a></li>
						<li><a href="#">${numTour - 1}</a></li>
						<li><a href="#">&raquo;</a></li>
					</ul>
				</c:if>
				<!-- End Pagination -->
			</div>
		</div>
	</div>
</div>
<!-- === END CONTENT === -->
<<<<<<< HEAD
<!-- === BEGIN FOOTER === -->
<%@ include file="userfooter.jsp" %>
<!-- === END FOOTER === -->
=======
<%@ include file="userfooter.jsp" %>
>>>>>>> 2e01d0fb0f21ac9e80fe063dcf4a0e00c54efdc0
