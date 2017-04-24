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
									<td>&nbsp;&nbsp;&nbsp; ${tour.returnTime}
										&nbsp;&nbsp;&nbsp;</td>
									<td><a href="<c:url value='tourdetail/${tour.idTour}'/>">
											<button class="btn btn-sm btn-violet">
												<i class="fa fa-eye">&nbsp;Xem</i>
											</button>
									</a><a href="<c:url value='updatetour/${tour.idTour}'/>"><button
												class="btn btn-sm btn-success">
												<i class="fa fa-pencil">&nbsp;Sửa</i>
											</button></a> <!-- <a data-toggle="modal" --> <a
										href="<c:url value='managetour/delete/${tour.idTour}'/>"><button
												class="btn btn-sm btn-danger">
												<i class="fa fa-trash-o">&nbsp;Xóa</i>
											</button> <!-- Popup Cofirm --> <!-- <div id="deleteConfirm" class="modal fade">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal"
													aria-hidden="true">&times;</button>
												<h4 class="modal-title">Bạn muốn xóa tour đã chọn?</h4>
												</br>
												<button type="button" class="btn btn-default"><a href="<c:url value='managetour#deleteCofirm/delete/${tour.idTour}'/>">Có</a></button>
												<button type="button" class="btn btn-primary"
													data-dismiss="modal">Không</button>
											</div>
										</div>
									</div>
								</div>
								<!-- End Popup Cofirm --></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table><br>
				</c:if>
				<!-- End Table -->
				<hr class="margin-bottom-20">
				<div class="text-center">
					<!-- Pagination -->
					<c:if test="${numTour > 5}">
						<!-- set active pagination when numTour >= 5 -->
						<ul class="pagination">
							<c:if test="${param.page != null}">
								<c:if test="${numTour/5 - param.page == numTour/5 - 1}">
									<li class="disabled"><a href="#">&laquo;</a></li>
								</c:if>
								<c:if test="${numTour/5 - param.page != numTour/5 - 1}">
									<li><a
										href="${pageContext.request.contextPath }/managetour?page=${param.page -1}">&laquo;</a>
									</li>
								</c:if>
							</c:if>
							<c:forEach items="${pageNum}" var="pageE">
								<c:if test="${pageE == param.page}">
									<li class="active"><a
										href="${pageContext.request.contextPath}/managetour?page=${pageE}">${pageE}</a></li>
								</c:if>
								<c:if test="${pageE != param.page}">
									<li><a
										href="${pageContext.request.contextPath}/managetour?page=${pageE}">${pageE}</a></li>
								</c:if>
							</c:forEach>
							<c:if test="${numTour/5 - param.page == 0}">
								<li class="disabled"><a
									href="${pageContext.request.contextPath }/managetour?page=${param.page + 1}">&raquo;</a>
								</li>
							</c:if>
							<c:if test="${numTour/5 - param.page > 0}">
								<li><a
									href="${pageContext.request.contextPath }/managetour?page=${param.page + 1}">&raquo;</a>
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