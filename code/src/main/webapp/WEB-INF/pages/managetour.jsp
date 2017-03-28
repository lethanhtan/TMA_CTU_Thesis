<!-- === BEGIN HEADER === -->
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="adminheader.jsp"%>
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
				<a href="createtour"><button
						class="btn btn-primary fa-plus-square">Tạo Mới</button></a>
				<div class="row margin-bottom-30">
					<div class="col-md-4 animate fadeInRight"></div>
					<div class="col-md-8 animate fadeIn"></div>
					<div class="col-md-12 animate fadeInRight"></div>
				</div>
				<hr class="margin-vert-20">
				<div class="row">
					<form role="form" class="form-inline" action="managetour" method="get">
						<div class="form-group">
							<label for="selectUser"
								style="float: left; padding: 6px 12px 2px 12px;">Số
								tour/trang:</label> <select id="selectUser" style="width: auto;"
								class="form-control selectWidth" name="numOn">
								<option >5</option>
								<option >10</option>
								<option >15</option>
							</select>
						</div>
						<div class="btn-group">
							<button class="btn btn-default">Chọn</button>
						</div>
					</form>
				</div>
				<h6>${x} - ${y}</h6>
				<!-- Table -->
				<c:if test="${empty tourList}">
					<h1 align="center">Không có tour nào!</h1>
				</c:if>
				<c:if test="${!empty tourList}">
					<table>
						<thead>
							<tr>
								<th>STT</th>
								<th>Tên tour</th>
								<th>Ngày đi</th>
								<th>Giờ đi</th>
								<th>Ngày về</th>
								<th>Giờ về</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${tourList.subList(x,y)}" var="tour">
								<!-- use subList render list tour to display -->
								<tr>
									<td>${tourList.indexOf(tour) + 1}</td>
									<td>${tour.name}</td>
									<td>&nbsp;&nbsp;&nbsp; ${tour.departureDate}</td>
									<td>&nbsp;&nbsp;&nbsp; ${tour.departureTime}</td>
									<td>&nbsp;&nbsp;&nbsp; ${tour.returnDate}</td>
									<td>&nbsp;&nbsp;&nbsp;
										${tour.returnTime}&nbsp;&nbsp;&nbsp;</td>
									<td><a href="<c:url value='tourdetail/${tour.idTour}'/>">
											<button class="btn btn-sm btn-violet">
												<i class="fa fa-eye">&nbsp;Xem</i>
											</button>
									</a> <a href="<c:url value='updatetour/${tour.idTour}'/>"><button
												class="btn btn-sm btn-success">
												<i class="fa fa-pencil">&nbsp;Sửa</i>
											</button> </a> <!-- <a data-toggle="modal" --> <a
										href="<c:url value='managetour/delete/${tour.idTour}'/>"><button
												class="btn btn-sm btn-danger">
												<i class="fa fa-trash-o">&nbsp;Xóa</i>
											</button> </a> <a href="<c:url value='tourreg/${tour.idTour}'/>"><button
												class="btn btn-sm btn-danger">
												<i class="fa fa-trash-o">&nbsp;Biểu đồ</i>
											</button> </a> <a href="<c:url value='export/${tour.idTour}'/>"><button
												class="btn btn-sm btn-danger">
												<i class="fa fa-trash-o">&nbsp;Export</i>
											</button> </a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<br />
				</c:if>
				<!-- End Table -->
				<hr class="margin-bottom-20">
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
										href="${pageContext.request.contextPath }/managetour?page=${param.page -1}">&laquo;</a>
									</li>
								</c:if>
							</c:if>
							<c:forEach items="${pageNum}" var="pageE">
								<c:if test="${pageE == page}">
									<li class="active"><a
										href="${pageContext.request.contextPath}/managetour?page=${pageE}">${pageE}</a></li>
								</c:if>
								<c:if test="${pageE != page}">
									<li><a
										href="${pageContext.request.contextPath}/managetour?page=${pageE}">${pageE}</a></li>
								</c:if>
							</c:forEach>
							<c:if test="${numTour/numOnPage - param.page == 0}">
								<li class="disabled"></li>
							</c:if>
							<c:if test="${numTour/numOnPage - param.page > 0}">
								<li><a
									href="${pageContext.request.contextPath }/managetour?page=${page + 1}">&raquo;</a>
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
<%@ include file="adminfooter.jsp"%>
<!-- === END FOOTER === -->