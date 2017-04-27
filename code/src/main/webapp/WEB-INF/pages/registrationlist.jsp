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
				<ul class="nav nav-tabs" id="myTab">
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
						<a href="${pageContext.request.contextPath}/export/${idTour}"><button
								class="btn btn-danger fa-plus-square">Export</button></a>
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
													<option selected="selected" disabled="disabled">Giới
														tính</option>
													<option value="All">Tất cả</option>
													<option value="Nam">Nam</option>
													<option value="Nữ">Nữ</option>
												</select>
											</form></li>
										<li style="margin-left: 1%"><form role="form"
												class="form-inline"
												action="${pageContext.request.contextPath}/registrationlist/${idTour}"
												method="GET">
												<select id="filterAge" class="form-control" name="filterAge"
													onchange="this.form.submit()">
													<option selected="selected" disabled="disabled">Tuổi</option>
													<option value="All">Tất cả</option>
													<option value="18">Dưới 18</option>
													<option value="40">Từ 18 - 40</option>
													<option value="60">Từ 41 - 60</option>
													<option value="100">Trên 60</option>
												</select>
											</form></li>
									</ul>
								</div>
								<br>
								<!-- End Filter Buttons -->
								<!-- Choose Number For Display -->
								<form role="form" class="form-inline"
									action="${pageContext.request.contextPath}/registrationlist/${idTour}"
									method="get">
									<label for="selectBookTour"
										style="text-align: left; margin-left: 70%">Số người
										đăng ký/ trang:</label> <select id="selectBookTour"
										class="form-control" name="numOn"
										onchange="this.form.submit()">
										<option>5</option>
										<option>10</option>
										<option>15</option>
									</select>
								</form>
								<!-- End Choose Number For Display -->
							</div>
							<br>
							<table style="font-size: 13px;">
								<thead>
									<tr>
										<th>STT</th>
										<th>Họ tên</th>
										<th>Giới tính</th>
										<th>Năm sinh</th>
										<th>Số điện thoại</th>
										<th>Đăng ký bởi</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${registrationList.subList(x,y)}"
										var="bookTour" varStatus="loop">
										<!-- use subList render list tour to display -->
										<tr>
											<td>${registrationList.indexOf(bookTour) + 1}</td>
											<td>${bookTour.cusName}</td>
											<td>${bookTour.cusSex}</td>
											<td>${bookTour.cusYearOfBirth}</td>
											<td>${bookTour.cusPhone}</td>
											<td>${bookTour.whoIsRegistered}</td>
											<td><a
												href="<c:url value='/cancelreg/${bookTour.idBT}/${tour.idTour}'/>">
													<button type="button" id="regcancel${bookTour.idBT}"
														hidden="true"></button>
											</a> <a
												href="<c:url value='/cancelallreg/${bookTour.idBT}/${bookTour.relationship}/${tour.idTour}'/>">
													<button type="button" id="allcancel${bookTour.idBT}"
														hidden="true"></button>
											</a> <a
												href="<c:url value='/deletebooktour/${bookTour.idBT}/${tour.idTour }'/>">
													<button type="button" id="only${bookTour.idBT}"
														hidden="true"></button>
											</a> <a
												href="<c:url value='/delallbooktour/${bookTour.idBT}/${bookTour.relationship}/${tour.idTour }'/>">
													<button type="button" id="all${bookTour.idBT}"
														hidden="true"></button>
											</a> <a href="<c:url value='/reginfodetail/${bookTour.idBT}'/>">
													<button class="btn btn-xs btn-violet success">
														<i class="fa fa-eye">&nbsp;Xem</i>
													</button>
											</a><a
												href="<c:url value='/editreginfo/${bookTour.idBT}/${tour.idTour}'/>"><button
														class="btn btn-xs btn-success">
														<i class="fa fa-pencil">&nbsp;Sửa</i>
													</button></a> <c:if test="${bookTour.tour.cancelOrNot}">
													<c:if
														test="${bookTour.cusName eq bookTour.whoIsRegistered}">
														<button class="btn btn-xs btn-aqua cancelall"
															id="cancel${bookTour.idBT}">
															<i class="fa fa-times">&nbsp;Hủy Đăng Ký</i>
														</button>
													</c:if>
													<c:if
														test="${bookTour.cusName ne bookTour.whoIsRegistered}">
														<button class="btn btn-xs btn-aqua cancel"
															id="cancel${bookTour.idBT}">
															<i class="fa fa-times">&nbsp;Hủy Đăng Ký</i>
														</button>
													</c:if>
												</c:if> <c:if
													test="${bookTour.cusName eq bookTour.whoIsRegistered}">
													<button class="btn btn-xs btn-danger deleteall"
														id="${bookTour.idBT }">
														<i class="fa fa-trash-o">&nbsp;Xóa</i>
													</button>
												</c:if> <c:if
													test="${bookTour.cusName ne bookTour.whoIsRegistered}">
													<button class="btn btn-xs btn-danger delete"
														id="${bookTour.idBT }">
														<i class="fa fa-trash-o">&nbsp;Xóa</i>
													</button>
												</c:if></td>
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
													<option selected="selected" disabled="disabled">Giới
														tính</option>
													<option value="All">Tất cả</option>
													<option value="Nam">Nam</option>
													<option value="Nữ">Nữ</option>
												</select>
											</form></li>
										<li style="margin-left: 1%"><form role="form"
												class="form-inline"
												action="${pageContext.request.contextPath}/registrationlist/${idTour}"
												method="GET">
												<select id="filterAge2" class="form-control"
													name="filterAge2" onchange="this.form.submit()">
													<option selected="selected" disabled="disabled">Tuổi</option>
													<option value="All">Tất cả</option>
													<option value="18">Dưới 18</option>
													<option value="40">Từ 18 - 40</option>
													<option value="60">Từ 41 - 60</option>
													<option value="100">Trên 60</option>
												</select>
											</form></li>
									</ul>
								</div>
								<br>
								<!-- End Filter Buttons -->
								<form role="form" class="form-inline"
									action="${pageContext.request.contextPath}/registrationlist/${idTour}"
									method="get">
									<label for="selectCancelReg"
										style="text-align: left; margin-left: 70%">Số người
										hủy đăng ký/ trang:</label> <select id="selectCancelReg"
										class="form-control" name="numOn2"
										onchange="this.form.submit()">
										<option>5</option>
										<option>10</option>
										<option>15</option>
									</select>
								</form>
							</div>
							<br>
							<!-- End Choose Number For Display -->
							<table style="font-size: 13px;">
								<thead>
									<tr>
										<th>STT</th>
										<th>Họ tên</th>
										<th>Giới tính</th>
										<th>Năm sinh</th>
										<th>Số điện thoại</th>
										<th>Đăng ký bởi</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${cancelList.subList(x2,y2)}" var="cancelReg"
										varStatus="loop">
										<!-- use subList render list tour to display -->
										<tr>
											<td>${cancelList.indexOf(cancelReg) + 1}</td>
											<td>${cancelReg.cusName}</td>
											<td>${cancelReg.cusSex}</td>
											<td>${cancelReg.cusYearOfBirth}</td>
											<td>${cancelReg.cusPhone}</td>
											<td>${cancelReg.whoIsRegistered}</td>
											<td><a
												href="<c:url value='/undocancel/${cancelReg.idBT}/${tour.idTour}'/>">
													<button type="button" id="onlyundo${cancelReg.idBT}"
														hidden="true"></button>
											</a> <a
												href="<c:url value='/undoallcancel/${cancelReg.idBT}/${cancelReg.relationship}/${tour.idTour}'/>">
													<button type="button" id="allundo${cancelReg.idBT}"
														hidden="true"></button>
											</a> <a
												href="<c:url value='/deletebooktour/${cancelReg.idBT}/${tour.idTour }'/>">
													<button type="button" id="only${cancelReg.idBT}"
														hidden="true"></button>
											</a> <a
												href="<c:url value='/delallbooktour/${cancelReg.idBT}/${cancelReg.relationship}/${tour.idTour }'/>">
													<button type="button" id="all${cancelReg.idBT}"
														hidden="true"></button>
											</a> <a href="<c:url value='/reginfodetail/${cancelReg.idBT}'/>">
													<button class="btn btn-xs btn-violet">
														<i class="fa fa-eye">&nbsp;Xem</i>
													</button>
											</a> <c:if test="${cancelReg.tour.regOrNot}">
													<c:if
														test="${cancelReg.cusName eq cancelReg.whoIsRegistered}">
														<button class="btn btn-xs btn-success undoall"
															id="undo${cancelReg.idBT}">
															<i class="fa fa-undo">&nbsp;Phục Hồi</i>
														</button>
													</c:if>
													<c:if
														test="${cancelReg.cusName ne cancelReg.whoIsRegistered}">
														<button class="btn btn-xs btn-success undo"
															id="undo${cancelReg.idBT}">
															<i class="fa fa-undo">&nbsp;Phục Hồi</i>
														</button>
													</c:if>
												</c:if> <c:if
													test="${cancelReg.cusName eq cancelReg.whoIsRegistered}">
													<button class="btn btn-xs btn-danger deleteall"
														id="${cancelReg.idBT}">
														<i class="fa fa-trash-o">&nbsp;Xóa</i>
													</button>
												</c:if> <c:if
													test="${cancelReg.cusName ne cancelReg.whoIsRegistered}">
													<button class="btn btn-xs btn-danger delete"
														id="${cancelReg.idBT}">
														<i class="fa fa-trash-o">&nbsp;Xóa</i>
													</button>
												</c:if></td>
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
												href="${pageContext.request.contextPath }/registrationlist/${tour.idTour}?page2=${param.page2 -1}">&laquo;</a>
											</li>
										</c:if>
									</c:if>
									<c:forEach items="${pageNum2}" var="pageE2">
										<c:if test="${pageE2 == page2}">
											<li class="active"><a
												href="${pageContext.request.contextPath}/registrationlist/${tour.idTour}?page2=${pageE2}">${pageE2}</a></li>
										</c:if>
										<c:if test="${pageE2 != page2}">
											<li><a
												href="${pageContext.request.contextPath}/registrationlist/${tour.idTour}?page2=${pageE2}">${pageE2}</a></li>
										</c:if>
									</c:forEach>
									<c:if test="${numCancelReg/numOnPage2 - param.page2 == 0}">
										<li class="disabled"><a>&raquo;</a></li>
									</c:if>
									<c:if test="${numCancelReg/numOnPage2 - param.page2 > 0}">
										<li><a
											href="${pageContext.request.contextPath}/registrationlist/${tour.idTour}?page2=${page2 + 1}">&raquo;</a>
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
</div>
<!-- === END CONTENT === -->
<!-- === BEGIN FOOTER === -->
<%@ include file="adminfooter.jsp"%>
<!-- === END FOOTER === -->