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
						<a href="${pageContext.request.contextPath}/booktour/${idTour}"><button
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
							<div class="row">
								<!-- Filter Buttons -->
								<div class="portfolio-filter-container margin-top-20">
									<ul class="portfolio-filter">
										<li class="portfolio-filter-label label label-warning"
											style="margin-left: 3%;"><i class="fa fa-filter">
												Lọc theo:</i></li>
										<li style="margin-left: 1%"><form role="form"
												class="form-inline"
												action="${pageContext.request.contextPath}/registrationlist/${idTour}"
												method="GET">
												<select id="filterSex" class="form-control" name="filterSex"
													onchange="this.form.submit()">
													<option>Giới tính</option>
													<option value="All">Tất cả</option>
													<option value="Nam">Nam</option>
													<option value="Nữ">Nữ</option>
												</select>
											</form></li>
										<li style="margin-left: 1%"><form role="form"
												class="form-inline"
												action="${pageContext.request.contextPath}/registrationlist/${idTour}"
												method="GET">
												<select id="filterTicket" class="form-control"
													name="filterTicket" onchange="this.form.submit()">
													<option>Số vé</option>
													<option value="">Tất cả</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
												</select>
											</form></li>
									</ul>
								</div>
								</br>
								<!-- End Filter Buttons -->
								<!-- Choose Number For Display -->
								<form role="form" class="form-inline"
									action="${pageContext.request.contextPath}/registrationlist/${idTour}"
									method="get">
									<label for="selectBookTour"
										style="text-align: left; margin-left: 70%">Số người
										đăng ký/ trang:</label> <select id="selectBookTour"
										class="form-control" name="numOn">
										<option>5</option>
										<option>10</option>
										<option>15</option>
									</select>
									<button class="btn btn-aqua">Chọn</button>
								</form>
								<!-- End Choose Number For Display -->
							</div>
							</br>
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
													</button></a> <c:if test="${bookTour.tour.cancelOrNot}">
													<a
														href="<c:url value='/cancelreg/${bookTour.idBT}/${tour.idTour}'/>"><button
															class="btn btn-sm btn-aqua">
															<i class="fa fa-times">&nbsp;Hủy Đăng Ký</i>
														</button></a>
												</c:if> <a href="#deleteConfirm" data-toggle="modal"><button
														class="btn btn-sm btn-danger">
														<i class="fa fa-trash-o">&nbsp;Xóa</i>
													</button></a> <!-- Popup Cofirm -->
												<div id="deleteConfirm" class="modal fade">
													<div class="modal-dialog">
														<div class="modal-content">
															<div class="modal-header">
																<button type="button" class="close" data-dismiss="modal"
																	aria-hidden="true">&times;</button>
																<h4 class="modal-title">Bạn muốn xóa người đăng ký
																	đã chọn?</h4>
																</br> <a
																	href="<c:url value='/deletebooktour/${bookTour.idBT}/${tour.idTour}'/>">
																	<button type="button" class="btn btn-danger">
																		Có</button>
																</a>
																<button type="button" class="btn btn-primary"
																	data-dismiss="modal">Không</button>
															</div>
														</div>
													</div>
												</div> <!-- End Popup Cofirm --></td>
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
								<!-- Filter Buttons -->
								<div class="portfolio-filter-container margin-top-20">
									<ul class="portfolio-filter">
										<li class="portfolio-filter-label label label-warning"
											style="margin-left: 3%;"><i class="fa fa-filter">
												Lọc theo:</i></li>
										<li style="margin-left: 1%"><form role="form"
												class="form-inline"
												action="${pageContext.request.contextPath}/registrationlist/${idTour}"
												method="GET">
												<select id="filterSex2" class="form-control"
													name="filterSex2" onchange="this.form.submit()">
													<option>Giới tính</option>
													<option value="All">Tất cả</option>
													<option value="Nam">Nam</option>
													<option value="Nữ">Nữ</option>
												</select>
											</form></li>
										<li style="margin-left: 1%"><form role="form"
												class="form-inline"
												action="${pageContext.request.contextPath}/registrationlist/${idTour}"
												method="GET">
												<select id="filterTicket2" class="form-control"
													name="filterTicket2" onchange="this.form.submit()">
													<option>Số vé</option>
													<option value="">Tất cả</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
												</select>
											</form></li>
									</ul>
								</div>
								</br>
								<!-- End Filter Buttons -->
								<form role="form" class="form-inline"
									action="${pageContext.request.contextPath}/registrationlist/${idTour}"
									method="get">
									<label for="selectCancelReg"
										style="text-align: left; margin-left: 70%">Số người
										hủy đăng ký/ trang:</label> <select id="selectCancelReg"
										class="form-control" name="numOn2">
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
											</a> <c:if test="${cancelReg.tour.regOrNot}">
													<a
														href="<c:url value='/undocancel/${cancelReg.idBT}/${tour.idTour }'/>"><button
															class="btn btn-sm btn-success">
															<i class="fa fa-undo">&nbsp;Phục Hồi</i>
														</button></a>
												</c:if> <a href="#deleteConfirm2" data-toggle="modal"><button
														class="btn btn-sm btn-danger">
														<i class="fa fa-trash-o">&nbsp;Xóa</i>
													</button></a> <!-- Popup Cofirm -->
												<div id="deleteConfirm2" class="modal fade">
													<div class="modal-dialog">
														<div class="modal-content">
															<div class="modal-header">
																<button type="button" class="close" data-dismiss="modal"
																	aria-hidden="true">&times;</button>
																<h4 class="modal-title">Bạn muốn xóa người hủy đăng
																	ký đã chọn?</h4>
																</br> <a
																	href="<c:url value='/delcuscancel/${cancelReg.idBT}/${tour.idTour }'/>">
																	<button type="button" class="btn btn-danger">
																		Có</button>
																</a>
																<button type="button" class="btn btn-primary"
																	data-dismiss="modal">Không</button>
															</div>
														</div>
													</div>
												</div> <!-- End Popup Cofirm --></td>
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