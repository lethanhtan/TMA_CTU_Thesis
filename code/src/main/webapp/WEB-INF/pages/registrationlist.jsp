<<<<<<< HEAD
<!-- === BEGIN HEADER === -->
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="adminheader.jsp" %>
<!-- === END HEADER === -->
=======
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="adminheader.jsp" %>
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
							placeholder="Nhập từ khóa">
						<button type="submit" class="btn btn-primary">Tìm Kiếm</button>
					</div>
				</form>
			</div>
			<!-- End Search Form -->
			<div class="col-md-12">
				<h2 class="margin-vert-20" style="text-align: center;">Danh
					Sách Đăng Ký</h2>
				<a href="createtour"><button
						class="btn btn-primary fa-plus-square">Thêm Mới</button></a>
				<div class="row margin-bottom-30">
					<div class="col-md-4 animate fadeInRight"></div>
					<div class="col-md-8 animate fadeIn"></div>
					<div class="col-md-12 animate fadeInRight"></div>
				</div>
				<!-- Table -->
				<c:if test="${empty tourList}">
					<h1>Chưa có người đăng ký tham gia tour này!</h1>
				</c:if>
				<c:if test="${!empty tourList}">
					<table>
						<thead>
							<tr>
								<th>Họ tên</th>
								<th>Giới tính</th>
								<th>Số điện thoại</th>
								<th>Email</th>
								<th>Địa chỉ</th>
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
					<!-- Pagination -->
					<c:if test="${numTour > 2}">
						<ul class="pagination">
							<li><a href="#">&laquo;</a></li>
							<li class="active"><a href="#">1</a></li>
							<li><a href="#">${numTour - 1}</a></li>
							<li><a href="#">&raquo;</a></li>
						</ul>
						<!-- End Pagination -->
					</c:if>
				</c:if>
				<!-- End Table -->
				<hr class="margin-vert-50">
			</div>
		</div>
	</div>
</div>
<!-- === END CONTENT === -->
<<<<<<< HEAD
<!-- === BEGIN FOOTER === -->
<%@ include file="adminfooter.jsp" %>
<!-- === END FOOTER === -->
=======
<%@ include file="adminfooter.jsp" %>
>>>>>>> 2e01d0fb0f21ac9e80fe063dcf4a0e00c54efdc0
