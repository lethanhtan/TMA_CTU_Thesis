<!-- === BEGIN HEADER === -->
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="userheader.jsp"%>
<!-- === END HEADER === -->
<!-- === BEGIN CONTENT === -->
<div id="content">
	<div class="container background-white">
		<div class="row margin-vert-30">
			<!-- Search Form -->
			<div class="error-404-page text-center" style="margin-left: 650px;">
				<form class="form-search search-404">
					<div class="input-append">
						<input type="text" class="span2 search-query"
							placeholder="Nhập từ khóa" name="valueSearch">
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
								<th>STT</th>
								<th>Mã tour</th>
								<th>Tên tour</th>
								<th>Ngày đi</th>
								<th>Giờ đi</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${tourList.subList(x,y)}" var="tour">
								<!-- use subList render list tour to display -->
								<tr>
									<td>${tourList.indexOf(tour) + 1}</td>
									<td>${tour.idTour}</td>
									<td>${tour.name}</td>
									<td>&nbsp;&nbsp;&nbsp; ${tour.departureDate}</td>
									<td>&nbsp;&nbsp;&nbsp; ${tour.departureTime}
										&nbsp;&nbsp;&nbsp;</td>
									<td><a href="<c:url value='viewtour/${tour.idTour}'/>"
										title="Xem"> <i class="fa fa-eye">&nbsp;</i>
									</a> <a href="<c:url value='booktour/${tour.idTour}'/>" title="Đăng Ký">
											<i class="fa fa-edit">&nbsp;</i>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
				<!-- End Table -->
				<hr class="margin-vert-50">
				<div class="text-center">
					<!-- Pagination -->
					<c:if test="${numTour >= 5}">
						<!-- set active pagination when numTour >= 5 -->
						<ul class="pagination">
							<c:if test="${param.page != null}">
								<c:if test="${numTour/5 - param.page == numTour/5 - 1}">
									<li class="disabled"><a href="#">&laquo;</a></li>
								</c:if>
								<c:if test="${numTour/5 - param.page != numTour/5 - 1}">
									<li><a
										href="${pageContext.request.contextPath }/tourlist?page=${param.page -1}">&laquo;</a>
									</li>
								</c:if>
							</c:if>
							<c:forEach items="${pageNum}" var="pageE">
								<c:if test="${pageE == param.page}">
									<li class="active"><a
										href="${pageContext.request.contextPath}/tourlist?page=${pageE}">${pageE}</a></li>
								</c:if>
								<c:if test="${pageE != param.page}">
									<li><a
										href="${pageContext.request.contextPath}/tourlist?page=${pageE}">${pageE}</a></li>
								</c:if>
							</c:forEach>
							<c:if test="${numTour/5 - param.page == 0}">
								<li class="disabled"><a
									href="${pageContext.request.contextPath }/tourlist?page=${param.page + 1}">&raquo;</a>
								</li>
							</c:if>
							<c:if test="${numTour/5 - param.page > 0}">
								<li><a
									href="${pageContext.request.contextPath }/tourlist?page=${param.page + 1}">&raquo;</a>
								</li>
							</c:if>
						</ul>
					</c:if>
				</div>
				<!-- End Pagination -->
			</div>
		</div>
	</div>
</div>
<!-- === END CONTENT === -->
<!-- === BEGIN FOOTER === -->
<%@ include file="userfooter.jsp"%>
<!-- === END FOOTER === -->