<!-- === BEGIN HEADER === -->
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="adminheader.jsp" %>
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
				<a href="createtour"><button
						class="btn btn-primary fa-plus-square">Tạo Mới</button></a>
				<div class="row margin-bottom-30">
					<div class="col-md-4 animate fadeInRight"></div>
					<div class="col-md-8 animate fadeIn"></div>
					<div class="col-md-12 animate fadeInRight"></div>
				</div>

				<hr class="margin-bottom-50">
				<!-- Table -->
				<c:if test="${empty tourList}">
					<h1 align="center">Không có tour nào!</h1>
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
									<td><a href="<c:url value='detail/${tour.idTour}'/>"
										title="Xem"> <i class="fa fa-eye">&nbsp;</i>
									</a> <a href="<c:url value='updatetour/${tour.idTour}'/>"
										title="Sửa"> <i class="fa fa-pencil">&nbsp;</i>
									</a> <a data-toggle="modal"
										href="<c:url value='managetour/delete/${tour.idTour}'/>"
										title="Xóa"> <i class="fa fa-trash-o"></i> <!-- Popup Cofirm -->
											<!-- <div id="deleteConfirm" class="modal fade">
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
								<!-- End Popup Cofirm -->
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
										href="${pageContext.request.contextPath }/managetour?page=${param.page -1}">&laquo;</a>
									</li>
								</c:if>
							</c:if>
							<c:forEach items="${pageNum}" var="pageE">
								<c:if test="${param.valueSearch == null}">
								<c:if test="${pageE == param.page}">
									<li class="active"><a
										href="${pageContext.request.contextPath}/managetour?page=${pageE}">${pageE}</a></li>
								</c:if>
								<c:if test="${pageE != param.page}">
									<li><a
										href="${pageContext.request.contextPath}/managetour?page=${pageE}">${pageE}</a></li>
								</c:if>
								</c:if>
								<c:if test="${param.valueSearch != null}">
								<c:if test="${pageE == param.page}">
									<li class="active"><a
										href="${pageContext.request.contextPath}/managetour?valueSearch=${param.valueSearch}?page=${pageE}">${pageE}</a></li>
								</c:if>
								<c:if test="${pageE != param.page}">
									<li><a
										href="${pageContext.request.contextPath}/managetour?valueSearch=${param.valueSearch}?page=${pageE}">${pageE}</a></li>
								</c:if>
								</c:if>
							</c:forEach>
							<c:if test="${param.valueSearch == null}">
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
							</c:if>
							<c:if test="${param.valueSearch != null}">
								<c:if test="${numTour/5 - param.page == 0}">
									<li class="disabled"><a
										href="${pageContext.request.contextPath }/managetour?valueSearh=${param.valueSearh}?page=${param.page + 1}">&raquo;FOR</a>
									</li>
								</c:if>
								<c:if test="${numTour/5 - param.page > 0}">
									<li><a
										href="${pageContext.request.contextPath }/managetour?valueSearh=${param.valueSearh}?page=${param.page + 1}">&raquo;FOR1</a>
									</li>
								</c:if>
							</c:if>
						</ul>
					</c:if>
				</div>
				<!-- End Pagination -->
				<h6>${param.valueSearch }</h6>
			</div>
		</div>
	</div>
</div>
<!-- === END CONTENT === -->
<!-- === BEGIN FOOTER === -->
<%@ include file="adminfooter.jsp" %>
<!-- === END FOOTER === -->
