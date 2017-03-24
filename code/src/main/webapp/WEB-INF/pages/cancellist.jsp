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
			<div class="error-404-page text-center" style="margin-left: 650px;">
				<form class="form-search search-404">
					<div class="input-append">
						<input type="text" class="span2 search-query"
							placeholder="Nhập họ tên/ điện thoại/ email" name="valueSearch">
						<button type="submit" class="btn btn-primary">Tìm Kiếm</button>
					</div>
				</form>
			</div>
			<!-- End Search Form -->
			<div class="col-md-12">
				<h2 class="margin-vert-20" style="text-align: center;">Danh
					Sách Hủy Đăng Ký</h2>
				<div class="row margin-bottom-30">
					<div class="col-md-4 animate fadeInRight"></div>
					<div class="col-md-8 animate fadeIn"></div>
					<div class="col-md-12 animate fadeInRight"></div>
				</div>
				<!-- Table -->
				<c:if test="${empty cancelList}">
					<h1 style="text-align: center;">Không có người hủy đăng ký
						tham gia tour này!</h1>
				</c:if>
				<c:if test="${!empty cancelList}">
					<table>
						<thead>
							<tr>
								<th>STT</th>
								<th>Họ tên</th>
								<th>Giới tính</th>
								<th>Số điện thoại</th>
								<th>Email</th>
								<th>Số vé</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${cancelList.subList(x,y)}" var="cancelReg">
								<!-- use subList render list tour to display -->
								<tr>
									<td>${cancelList.indexOf(cancelReg) + 1}</td>
									<td>${cancelReg.cusName}</td>
									<td>${cancelReg.cusSex}</td>
									<td>&nbsp;&nbsp;&nbsp; ${cancelReg.cusPhone}</td>
									<td>&nbsp;&nbsp;&nbsp; ${cancelReg.cusEmail}</td>
									<td>&nbsp;&nbsp;&nbsp;${cancelReg.ticketCancel}&nbsp;&nbsp;&nbsp;</td>
									<td><a
										href="<c:url value='/booktourdetail/${cancelReg.idBT}/${tour.idTour}'/>"
										title="Xem"> <i class="fa fa-eye">&nbsp;</i>
									</a> <a
										href="<c:url value='/undocancel/${cancelReg.idBT}/${tour.idTour }'/>"
										title="Phục hồi"> <i class="fa fa-undo">&nbsp;</i>
									</a> <a data-toggle="modal"
										href="<c:url value='/delcuscancel/${cancelReg.idBT}/${tour.idTour }'/>"
										title="Xóa"> <i class="fa fa-trash-o"></i>
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
					<c:if test="${numCancelReg >= 5}">
						<!-- set active pagination when numTour >= 5 -->
						<ul class="pagination">
							<c:if test="${param.page != null}">
								<c:if
									test="${numCancelReg/5 - param.page == numCancelReg/5 - 1}">
									<li class="disabled"><a href="#">&laquo;</a></li>
								</c:if>
								<c:if
									test="${numCancelReg/5 - param.page != numCancelReg/5 - 1}">
									<li><a
										href="${pageContext.request.contextPath }/cancellist/${tour.idTour }?page=${param.page -1}">&laquo;</a>
									</li>
								</c:if>
							</c:if>
							<c:forEach items="${pageNum}" var="pageE">
								<c:if test="${pageE == param.page}">
									<li class="active"><a
										href="${pageContext.request.contextPath}/cancellist/${tour.idTour }?page=${pageE}">${pageE}</a></li>
								</c:if>
								<c:if test="${pageE != param.page}">
									<li><a
										href="${pageContext.request.contextPath}/cancellist/${tour.idTour }?page=${pageE}">${pageE}</a></li>
								</c:if>
							</c:forEach>
							<c:if test="${numCancelReg/5 - param.page == 0}">
								<li class="disabled"><a
									href="${pageContext.request.contextPath }/canellist/${tour.idTour }?page=${param.page + 1}">&raquo;</a>
								</li>
							</c:if>
							<c:if test="${numCancelReg/5 - param.page > 0}">
								<li><a
									href="${pageContext.request.contextPath }/cancellist/${tour.idTour }?page=${param.page + 1}">&raquo;</a>
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