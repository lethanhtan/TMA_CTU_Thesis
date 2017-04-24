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
			<div class="error-404-page text-center" style="margin-left: 60%;">
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
				<!-- Choose Number For Display -->
				<div class="row">
					<form role="form" class="form-inline" action="tourlist"
						method="get">
						<label for="selectTour" style="text-align: left; margin-left: 83%">Số
							tour/ trang:</label> <select id="selectTour" name="numOn"
							onchange="this.form.submit()">
							<option>5</option>
							<option>10</option>
							<option>15</option>
						</select>
					</form>
				</div>
				<br />
				<!-- End Choose Number For Display -->
				<!-- Table -->
				<c:if test="${empty showTourList}">
					<h1 style="text-align: center;">Không có tour nào!</h1>
				</c:if>
				<c:if test="${!empty showTourList}">
					<table>
						<thead>
							<tr>
								<th>STT</th>
								<th>Tên tour</th>
								<th>Ngày đi</th>
								<th>Giờ đi</th>
								<th>Ngày về</th>
								<th>Giờ về</th>
								<th>Số chỗ còn</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${showTourList.subList(x,y)}" var="tour">
								<!-- use subList render list tour to display -->
								<tr>
									<td>${showTourList.indexOf(tour) + 1}</td>
									<td>${tour.name}</td>
									<td><fmt:formatDate value="${tour.departureDate}"
											pattern="dd/MM/yyyy" /></td>
									<td>${tour.departureTime}</td>
									<td><fmt:formatDate value="${tour.returnDate}"
											pattern="dd/MM/yyyy" /></td>
									<td>${tour.returnTime}</td>
									<td>${tour.ticketAvailability}</td>
									<td><a href="<c:url value='viewdetail/${tour.idTour}'/>">
											<button class="btn btn-sm btn-success">
												<i class="fa fa-eye">&nbsp;Xem</i>
											</button>
									</a><a href="<c:url value='booktour/${tour.idTour}'/>"><button
												class="btn btn-sm btn-danger">
												<i class="fa fa-edit">&nbsp;Đăng Ký</i>
											</button></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
				<!-- End Table -->
				<hr class="margin-vert-50">
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
										href="${pageContext.request.contextPath }/tourlist?page=${param.page -1}">&laquo;</a>
									</li>
								</c:if>
							</c:if>
							<c:forEach items="${pageNum}" var="pageE">
								<c:if test="${pageE == page}">
									<li class="active"><a
										href="${pageContext.request.contextPath}/tourlist?page=${pageE}">${pageE}</a></li>
								</c:if>
								<c:if test="${pageE != page}">
									<li><a
										href="${pageContext.request.contextPath}/tourlist?page=${pageE}">${pageE}</a></li>
								</c:if>
							</c:forEach>
							<c:if test="${numTour/numOnPage - param.page == 0}">
								<li class="disabled"><a
									href="${pageContext.request.contextPath }/tourlist?page=${param.page + 1}">&raquo;</a>
								</li>
							</c:if>
							<c:if test="${numTour/numOnPage - param.page > 0}">
								<li><a
									href="${pageContext.request.contextPath }/tourlist?page=${page + 1}">&raquo;</a>
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