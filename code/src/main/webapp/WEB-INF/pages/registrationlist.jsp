<!-- === BEGIN HEADER === -->
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="adminheader.jsp"%>
<!-- === END HEADER === -->
<!-- === BEGIN CONTENT === -->
<div id="content">
	<div class="container background-white">
		<div class="row margin-vert-30">
			<!-- Tab v2 -->
			<div class="tabs alternative">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#registrationlist"
						data-toggle="tab">Danh Sách Đăng Ký</a></li>
					<li><a href="#cancellist" data-toggle="tab">Danh Sách Hủy</a></li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane fade in active" id="registrationlist">
						<!-- Search Form -->
						<div class="error-404-page text-center"
							style="margin-right: -62%;">
							<form class="form-search search-404">
								<div class="input-append">
									<input type="text" class="span2 search-query"
										placeholder="Nhập họ tên/ điện thoại/ email"
										name="valueSearch">
									<button type="submit" class="btn btn-primary">Tìm Kiếm</button>
								</div>
							</form>
						</div>
						<!-- End Search Form -->
						<h2 class="margin-vert-20" style="text-align: center;">Danh
							Sách Đăng Ký</h2>
						<a
							href="${pageContext.request.contextPath}/booktour/${idTour}"><button
								class="btn btn-primary fa-plus-square">Thêm Mới</button></a>
						<div class="row margin-bottom-30">
							<div class="col-md-4 animate fadeInRight"></div>
							<div class="col-md-8 animate fadeIn"></div>
							<div class="col-md-12 animate fadeInRight"></div>
						</div>
						<hr class="margin-vert-20">
						<!-- Table -->
						<c:if test="${empty registrationList}">
							<h1 style="text-align: center;">Chưa có người đăng ký tham
								gia tour này!</h1>
						</c:if>
						<c:if test="${!empty registrationList}">
							<!-- Choose Number For Display -->
							<div class="row">
								<form role="form" class="form-inline" action="tourlist"
									method="get">
									<label for="selectTour"
										style="text-align: left; margin-left: 2%">Số người
										đăng ký/ trang:</label> <select id="selectTour" class="form-control"
										name="numOn">
										<option>5</option>
										<option>10</option>
										<option>15</option>
									</select>
									<button class="btn btn-aqua">Chọn</button>
								</form>
							</div>
							</br>
							<!-- End Choose Number For Display -->
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
									<c:forEach items="${registrationList.subList(x,y)}"
										var="bookTour">
										<!-- use subList render list tour to display -->
										<tr>
											<td>${registrationList.indexOf(bookTour) + 1}</td>
											<td>${bookTour.cusName}</td>
											<td>${bookTour.cusSex}</td>
											<td>&nbsp;&nbsp;&nbsp; ${bookTour.cusPhone}</td>
											<td>&nbsp;&nbsp;&nbsp; ${bookTour.cusEmail}</td>
											<td>&nbsp;&nbsp;&nbsp;${bookTour.cusNumOfTicket}&nbsp;&nbsp;&nbsp;</td>
											<td><a
												href="<c:url value='/reginfodetail/${bookTour.idBT}/${tour.idTour}'/>">
													<button class="btn btn-sm btn-violet">
														<i class="fa fa-eye">&nbsp;Xem</i>
													</button>
											</a><a
												href="<c:url value='/editreginfo/${bookTour.idBT}/${tour.idTour}'/>"><button
														class="btn btn-sm btn-success">
														<i class="fa fa-pencil">&nbsp;Sửa</i>
													</button></a> <a
												href="<c:url value='/cancelreg/${bookTour.idBT}/${tour.idTour}'/>"><button
														class="btn btn-sm btn-aqua">
														<i class="fa fa-times">&nbsp;Hủy Đăng Ký</i>
													</button></a> <a
												href="<c:url value='/deletebooktour/${bookTour.idBT}/${tour.idTour}'/>"><button
														class="btn btn-sm btn-danger">
														<i class="fa fa-trash-o">&nbsp;Xóa</i>
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
							<c:if test="${numBookTour > numOnPage}">
								<!-- Paging when number of element > number of book tour -->
								<ul class="pagination">
									<c:if test="${param.page != null}">
										<c:if test="${param.page == 1}">
											<li class="disabled"></li>
										</c:if>
										<c:if test="${param.page > 1 }">
											<li><a
												href="${pageContext.request.contextPath }/registrationlist/${tour.idTour}?page=${param.page -1}">&laquo;</a>
											</li>
										</c:if>
									</c:if>
									<c:forEach items="${pageNum}" var="pageE">
										<c:if test="${pageE == page}">
											<li class="active"><a
												href="${pageContext.request.contextPath}/registrationlist/${tour.idTour}?page=${pageE}">${pageE}</a></li>
										</c:if>
										<c:if test="${pageE != page}">
											<li><a
												href="${pageContext.request.contextPath}/registrationlist/${tour.idTour}?page=${pageE}">${pageE}</a></li>
										</c:if>
									</c:forEach>
									<c:if test="${numBookTour/numOnPage - param.page == 0}">
										<li class="disabled"><a>&raquo;</a></li>
									</c:if>
									<c:if test="${numBookTour/numOnPage - param.page > 0}">
										<li><a
											href="${pageContext.request.contextPath }/registrationlist/${tour.idTour}?page=${page + 1}">&raquo;</a>
										</li>
									</c:if>
								</ul>
							</c:if>
						</div>
						<!-- End Pagination -->
					</div>
					<div class="tab-pane fade in" id="cancellist">
						<!-- Search Form -->
						<div class="error-404-page text-center"
							style="margin-right: -62%;">
							<form class="form-search search-404">
								<div class="input-append">
									<input type="text" class="span2 search-query"
										placeholder="Nhập họ tên/ điện thoại/ email"
										name="valueSearch2">
									<button type="submit" class="btn btn-primary">Tìm Kiếm</button>
								</div>
							</form>
						</div>
						<!-- End Search Form -->
						<h2 class="margin-vert-20" style="text-align: center;">Danh
							Sách Hủy Đăng Ký</h2>
						<div class="row margin-bottom-30">
							<div class="col-md-4 animate fadeInRight"></div>
							<div class="col-md-8 animate fadeIn"></div>
							<div class="col-md-12 animate fadeInRight"></div>
						</div>
						<hr class="margin-vert-20">
						<!-- Table -->
						<c:if test="${empty cancelList}">
							<h1 style="text-align: center;">Không có người hủy đăng ký
								tham gia tour này!</h1>
						</c:if>
						<c:if test="${!empty cancelList}">
							<!-- Choose Number For Display -->
							<div class="row">
								<form role="form" class="form-inline" action="registrationlist"
									method="get">
									<label for="selectTour"
										style="text-align: left; margin-left: 2%">Số người
										đăng ký/ trang:</label> <select id="selectTour" class="form-control"
										name="numOn">
										<option>5</option>
										<option>10</option>
										<option>15</option>
									</select>
									<button class="btn btn-aqua">Chọn</button>
								</form>
							</div>
							</br>
							<!-- End Choose Number For Display -->
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
									<c:forEach items="${cancelList.subList(x2,y2)}" var="cancelReg">
										<!-- use subList render list tour to display -->
										<tr>
											<td>${cancelList.indexOf(cancelReg) + 1}</td>
											<td>${cancelReg.cusName}</td>
											<td>${cancelReg.cusSex}</td>
											<td>&nbsp;&nbsp;&nbsp; ${cancelReg.cusPhone}</td>
											<td>&nbsp;&nbsp;&nbsp; ${cancelReg.cusEmail}</td>
											<td>&nbsp;&nbsp;&nbsp;${cancelReg.ticketCancel}&nbsp;&nbsp;&nbsp;</td>
											<td><a
												href="<c:url value='/reginfodetail/${cancelReg.idBT}/${tour.idTour}'/>">
													<button class="btn btn-sm btn-violet">
														<i class="fa fa-eye">&nbsp;Xem</i>
													</button>
											</a><a
												href="<c:url value='/undocancel/${cancelReg.idBT}/${tour.idTour }'/>"><button
														class="btn btn-sm btn-success">
														<i class="fa fa-undo">&nbsp;Phục Hồi</i>
													</button></a> <a
												href="<c:url value='/delcuscancel/${cancelReg.idBT}/${tour.idTour }'/>"><button
														class="btn btn-sm btn-danger">
														<i class="fa fa-trash-o">&nbsp;Xóa</i>
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
							<c:if test="${numCancelReg > numOnPage2}">
								<!-- Paging when number of element > number of book tour -->
								<ul class="pagination">
									<c:if test="${param.page2 != null}">
										<c:if test="${param.page2 == 1}">
											<li class="disabled"></li>
										</c:if>
										<c:if test="${param.page2 > 1 }">
											<li><a
												href="${pageContext.request.contextPath }/cancellist/${tour.idTour}?page=${param.page2 -1}">&laquo;</a>
											</li>
										</c:if>
									</c:if>
									<c:forEach items="${pageNum2}" var="pageE2">
										<c:if test="${pageE2 == page2}">
											<li class="active"><a
												href="${pageContext.request.contextPath}/cancellist/${tour.idTour}?page=${pageE2}">${pageE2}</a></li>
										</c:if>
										<c:if test="${pageE2 != page2}">
											<li><a
												href="${pageContext.request.contextPath}/cancellist/${tour.idTour}?page=${pageE2}">${pageE2}</a></li>
										</c:if>
									</c:forEach>
									<c:if test="${numCancelReg/numOnPage2 - param.page2 == 0}">
										<li class="disabled"><a>&raquo;</a></li>
									</c:if>
									<c:if test="${numCancelReg/numOnPage2 - param.page2 > 0}">
										<li><a
											href="${pageContext.request.contextPath }/cancellist/${tour.idTour}?page=${page2 + 1}">&raquo;</a>
										</li>
									</c:if>
								</ul>
							</c:if>
						</div>
						<!-- End Pagination -->
						<!-- Pagination -->
						<c:if test="${numCancelReg >= 5}">
							<!-- set active pagination when numTour >= 5 -->
							<ul class="pagination">
								<c:if test="${param.page2 != null}">
									<c:if
										test="${numCancelReg/5 - param.page2 == numCancelReg/5 - 1}">
										<li class="disabled"><a href="#">&laquo;</a></li>
									</c:if>
									<c:if
										test="${numCancelReg/5 - param.page2 != numCancelReg/5 - 1}">
										<li><a
											href="${pageContext.request.contextPath }/cancellist/${tour.idTour }?page=${param.page2 -1}">&laquo;</a>
										</li>
									</c:if>
								</c:if>
								<c:forEach items="${pageNum2}" var="pageE">
									<c:if test="${pageE2 == param.page2}">
										<li class="active"><a
											href="${pageContext.request.contextPath}/cancellist/${tour.idTour }?page=${pageE2}">${pageE2}</a></li>
									</c:if>
									<c:if test="${pageE2 != param.page2}">
										<li><a
											href="${pageContext.request.contextPath}/cancellist/${tour.idTour }?page=${pageE2}">${pageE2}</a></li>
									</c:if>
								</c:forEach>
								<c:if test="${numCancelReg/5 - param.page2 == 0}">
									<li class="disabled"><a
										href="${pageContext.request.contextPath }/canellist/${tour.idTour }?page=${param.page2 + 1}">&raquo;</a>
									</li>
								</c:if>
								<c:if test="${numCancelReg/5 - param.page2 > 0}">
									<li><a
										href="${pageContext.request.contextPath }/cancellist/${tour.idTour }?page=${param.page2 + 1}">&raquo;</a>
									</li>
								</c:if>
							</ul>
						</c:if>
					</div>
					<!-- End Pagination -->
				</div>
			</div>
		</div>
		<!-- End Tab v2 -->
	</div>
</div>
<!-- === END CONTENT === -->
<!-- === BEGIN FOOTER === -->
<%@ include file="adminfooter.jsp"%>
<!-- === END FOOTER === -->