<!-- === BEGIN HEADER === -->
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="userheader.jsp"%>
<!-- === END HEADER === -->
<!-- === BEGIN CONTENT === -->
<div id="content">
	<div class="container background-white">
		<div class="row margin-vert-30">
			<!-- Tabs -->
			<div class="tabs alternative">
				<ul class="nav nav-tabs" id="myTab">
					<li class="active"><a href="#myreglist" data-toggle="tab">Danh
							Sách Đăng Ký</a></li>
					<li><a href="#mycancellist" data-toggle="tab">Danh Sách
							Hủy</a></li>
					<li><a href="#mytourlist" data-toggle="tab">Danh Sách Tour
							Đã Đi</a></li>
				</ul>
				<div class="tab-content">
					<!--  My Registration List -->
					<div class="tab-pane fade in active" id="myreglist">
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
						<div class="row margin-bottom-30">
							<div class="col-md-4 animate fadeInRight"></div>
							<div class="col-md-8 animate fadeIn"></div>
							<div class="col-md-12 animate fadeInRight"></div>
						</div>
						<hr class="margin-vert-20">
						<!-- Choose Number For Display -->
						<form role="form" class="form-inline"
							action="${pageContext.request.contextPath}/managemyreg/${idUser}"
							method="get">
							<label for="selectBookTour"
								style="text-align: left; margin-left: 80%">Số đăng ký/
								trang:</label> <select id="selectBookTour" name="numOn"
								onchange="this.form.submit()">
								<option>5</option>
								<option>10</option>
								<option>15</option>
							</select>
						</form>
						<br>
						<!-- End Choose Number For Display -->
						<!-- Table -->
						<c:if test="${empty myRegList}">
							<h1 style="text-align: center;">Bạn chưa đăng ký tham gia
								tour nào!</h1>
						</c:if>
						<c:if test="${!empty myRegList}">
							<table style="font-size: 13px;">
								<thead>
									<tr>
										<th>STT</th>
										<th>Tên tour</th>
										<th>Họ tên</th>
										<th>Giới tính</th>
										<th>Năm sinh</th>
										<th>Số điện thoại</th>
										<th>Đăng ký bởi</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${myRegList.subList(x,y)}" var="bookTour"
										varStatus="loop">
										<!-- use subList render list book tour to display -->
										<tr>
											<td>${myRegList.indexOf(bookTour) + 1}</td>
											<td>${bookTour.tour.name}</td>
											<td>${bookTour.cusName}</td>
											<td>${bookTour.cusSex}</td>
											<td>${bookTour.cusYearOfBirth}</td>
											<td>${bookTour.cusPhone}</td>
											<td>${bookTour.whoIsRegistered}</td>
											<td><a href="<c:url value='/cancel/${bookTour.idBT}'/>">
													<button type="button" id="regcancel${bookTour.idBT}"
														hidden="true"></button>
											</a> <a
												href="<c:url value='/cancelall/${bookTour.idBT}/${bookTour.relationship}'/>">
													<button type="button" id="allcancel${bookTour.idBT}"
														hidden="true"></button>
											</a> <a
												href="<c:url value='/booktourdetail/${bookTour.idBT}/${bookTour.tour.idTour}'/>">
													<button class="btn btn-xs btn-violet">
														<i class="fa fa-eye">&nbsp;Xem</i>
													</button>
											</a><a
												href="<c:url value='/editbooktour/${bookTour.idBT}/${bookTour.tour.idTour}'/>"><button
														class="btn btn-xs btn-success">
														<i class="fa fa-pencil">&nbsp;Sửa</i>
													</button></a> <c:if test="${bookTour.tour.cancelOrNot}">
													<c:if
														test="${bookTour.cusName eq bookTour.whoIsRegistered}">
														<button class="btn btn-xs btn-danger cancel"
															id="cancel${bookTour.idBT}">
															<i class="fa fa-times">&nbsp;Hủy Đăng Ký</i>
														</button>
													</c:if>
													<c:if
														test="${bookTour.cusName ne bookTour.whoIsRegistered}">
														<a href="<c:url value='/cancel/${bookTour.idBT}'/>"><button
																class="btn btn-xs btn-danger">
																<i class="fa fa-times">&nbsp;Hủy Đăng Ký</i>
															</button></a>
													</c:if>
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
							<c:if test="${myNumBT > numOnPage}">
								<!-- Paging when number of element > number of book tour -->
								<ul class="pagination">
									<c:if test="${param.page != null}">
										<c:if test="${param.page == 1}">
											<li class="disabled"></li>
										</c:if>
										<c:if test="${param.page > 1 }">
											<li><a
												href="${pageContext.request.contextPath }/managemyreg/${idUser}?page=${param.page -1}">&laquo;</a>
											</li>
										</c:if>
									</c:if>
									<c:forEach items="${pageNum}" var="pageE">
										<c:if test="${pageE == page}">
											<li class="active"><a
												href="${pageContext.request.contextPath}/managemyreg/${idUser}?page=${pageE}">${pageE}</a></li>
										</c:if>
										<c:if test="${pageE != page}">
											<li><a
												href="${pageContext.request.contextPath}/managemyreg/${idUser}?page=${pageE}">${pageE}</a></li>
										</c:if>
									</c:forEach>
									<c:if test="${myNumBT/numOnPage - param.page == 0}">
										<li class="disabled"><a>&raquo;</a></li>
									</c:if>
									<c:if test="${myNumBT/numOnPage - param.page > 0}">
										<li><a
											href="${pageContext.request.contextPath }/managemyreg/${idUser}?page=${page + 1}">&raquo;</a>
										</li>
									</c:if>
								</ul>
							</c:if>
						</div>
						<!-- End pagination -->
					</div>
					<!--  End My Registration List -->
					<!--  My Cancel List -->
					<div class="tab-pane fade in" id="mycancellist">
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
						<!-- Choose Number For Display -->
						<form role="form" class="form-inline"
							action="${pageContext.request.contextPath}/managemyreg/${idUser}"
							method="get">
							<label for="selectBookTour"
								style="text-align: left; margin-left: 80%">Số người đăng
								ký/ trang:</label> <select id="selectBookTour" name="numOn2"
								onchange="this.form.submit()">
								<option>5</option>
								<option>10</option>
								<option>15</option>
							</select>
						</form>
						<br>
						<!-- End Choose Number For Display -->
						<!-- Table -->
						<c:if test="${empty myCancelList}">
							<c:choose>
								<c:when test="${search2 == 1}">
									<h1 style="text-align: center;">Không tìm thấy kết quả
										trùng khớp!</h1>
								</c:when>
								<c:otherwise>
									<h1 style="text-align: center;">Bạn chưa hủy đăng ký tham
										gia tour nào!</h1>
								</c:otherwise>
							</c:choose>
						</c:if>
						<c:if test="${!empty myCancelList}">
							<table style="font-size: 13px;">
								<thead>
									<tr>
										<th>STT</th>
										<th>Tên tour</th>
										<th>Họ tên</th>
										<th>Giới tính</th>
										<th>Năm sinh</th>
										<th>Số điện thoại</th>
										<th>Đăng ký bởi</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${myCancelList.subList(x2,y2)}"
										var="myCancelReg" varStatus="loop">
										<!-- use subList render list cancel book tour to display -->
										<tr>
											<td>${myCancelList.indexOf(myCancelReg) + 1}</td>
											<td>${myCancelReg.tour.name}</td>
											<td>${myCancelReg.cusName}</td>
											<td>${myCancelReg.cusSex}</td>
											<td>${myCancelReg.cusYearOfBirth}</td>
											<td>${myCancelReg.cusPhone}</td>
											<td>${myCancelReg.whoIsRegistered}</td>
											<td><a
												href="<c:url value='/undo/${myCancelReg.idBT}/${myCancelReg.tour.idTour}'/>">
													<button type="button" id="onlyundo${myCancelReg.idBT}"
														hidden="true"></button>
											</a> <a
												href="<c:url value='/undoallcancel/${myCancelReg.idBT}/${myCancelReg.relationship}/${myCancelReg.tour.idTour}'/>">
													<button type="button" id="allundo${myCancelReg.idBT}"
														hidden="true"></button>
											</a> <a
												href="<c:url value='/booktourdetail/${myCancelReg.idBT}/${myCancelReg.tour.idTour}'/>">
													<button class="btn btn-xs btn-violet">
														<i class="fa fa-eye">&nbsp;Xem</i>
													</button>
											</a> <c:if test="${myCancelReg.tour.regOrNot}">
													<c:if
														test="${myCancelReg.cusName eq myCancelReg.whoIsRegistered}">
														<button class="btn btn-xs btn-success undo"
															id="undo${myCancelReg.idBT}">
															<i class="fa fa-undo">&nbsp;Phục Hồi</i>
														</button>
													</c:if>
													<c:if
														test="${myCancelReg.cusName ne myCancelReg.whoIsRegistered}">
														<a href="<c:url value='/undo/${myCancelReg.idBT}'/>"><button
																class="btn btn-xs btn-success">
																<i class="fa fa-undo">&nbsp;Phục Hồi</i>
															</button></a>
													</c:if>
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
							<c:if test="${myNumCancelReg > numOnPage2}">
								<!-- Paging when number of element > number of book tour -->
								<ul class="pagination">
									<c:if test="${param.page2 != null}">
										<c:if test="${param.page2 == 1}">
											<li class="disabled"></li>
										</c:if>
										<c:if test="${param.page2 > 1 }">
											<li><a
												href="${pageContext.request.contextPath }/managemyreg/${idUser}?page=${param.page2 -1}">&laquo;</a>
											</li>
										</c:if>
									</c:if>
									<c:forEach items="${pageNum2}" var="pageE2">
										<c:if test="${pageE2 == page2}">
											<li class="active"><a
												href="${pageContext.request.contextPath}/managemyreg/${idUser}?page=${pageE2}">${pageE2}</a></li>
										</c:if>
										<c:if test="${pageE2 != page2}">
											<li><a
												href="${pageContext.request.contextPath}/managemyreg/${idUser}?page=${pageE2}">${pageE2}</a></li>
										</c:if>
									</c:forEach>
									<c:if test="${myNumCancelReg/numOnPage2 - param.page2 == 0}">
										<li class="disabled"><a>&raquo;</a></li>
									</c:if>
									<c:if test="${myNumCancelReg/numOnPage2 - param.page2 > 0}">
										<li><a
											href="${pageContext.request.contextPath }/managemyreg/${idUser}?page=${page2 + 1}">&raquo;</a>
										</li>
									</c:if>
								</ul>
							</c:if>
						</div>
						<!-- End pagination -->
					</div>
					<!--  End My Cancel List -->
					<!-- My Tour List -->
					<div class="tab-pane fade in" id="mytourlist">
						<!-- Search Form -->
						<div class="error-404-page text-center"
							style="margin-right: -62%;">
							<form class="form-search search-404">
								<div class="input-append">
									<input type="text" class="span2 search-query"
										placeholder="Nhập họ tên/ điện thoại/ email"
										name="valueSearch3">
									<button type="submit" class="btn btn-primary">Tìm Kiếm</button>
								</div>
							</form>
						</div>
						<!-- End Search Form -->
						<h2 class="margin-vert-20" style="text-align: center;">Danh
							Sách Tour Đã Đi</h2>
						<div class="row margin-bottom-30">
							<div class="col-md-4 animate fadeInRight"></div>
							<div class="col-md-8 animate fadeIn"></div>
							<div class="col-md-12 animate fadeInRight"></div>
						</div>
						<hr class="margin-vert-20">
						<!-- Table -->
						<c:if test="${empty myBookTourList}">
							<h1 style="text-align: center;">Bạn chưa đi tour nào cả!</h1>
						</c:if>
						<c:if test="${!empty myBookTourList}">
							<table style="font-size: 13px;">
								<thead>
									<tr>
										<th>STT</th>
										<th>Tên tour</th>
										<th>Họ tên</th>
										<th>Giới tính</th>
										<th>Năm sinh</th>
										<th>Số điện thoại</th>
										<th>Đăng ký bởi</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${myBookTourList.subList(x3,y3)}"
										var="myBookTour" varStatus="loop">
										<!-- use subList render list cancel book tour to display -->
										<tr>
											<td>${myBookTourList.indexOf(myBookTour) + 1}</td>
											<td>${myBookTour.tour.name}</td>
											<td>${myBookTour.cusName}</td>
											<td>${myBookTour.cusSex}</td>
											<td>${myBookTour.cusYearOfBirth}</td>
											<td>${myBookTour.cusPhone}</td>
											<td>${myBookTour.whoIsRegistered}</td>
											<td><a
												href="<c:url value='/booktourdetail/${myBookTour.idBT}/${myBookTour.tour.idTour}'/>">
													<button class="btn btn-xs btn-violet">
														<i class="fa fa-eye">&nbsp;Xem</i>
													</button>
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
							<c:if test="${myNumBookTour > numOnPage3}">
								<!-- Paging when number of element > number of book tour -->
								<ul class="pagination">
									<c:if test="${param.page3 != null}">
										<c:if test="${param.page3 == 1}">
											<li class="disabled"></li>
										</c:if>
										<c:if test="${param.page3 > 1 }">
											<li><a
												href="${pageContext.request.contextPath }/managemyreg/${idUser}?page=${param.page3 -1}">&laquo;</a>
											</li>
										</c:if>
									</c:if>
									<c:forEach items="${pageNum3}" var="pageE3">
										<c:if test="${pageE3 == page3}">
											<li class="active"><a
												href="${pageContext.request.contextPath}/managemyreg/${idUser}?page=${pageE3}">${pageE3}</a></li>
										</c:if>
										<c:if test="${pageE3 != page3}">
											<li><a
												href="${pageContext.request.contextPath}/managemyreg/${idUser}?page=${pageE3}">${pageE3}</a></li>
										</c:if>
									</c:forEach>
									<c:if test="${myNumBookTour/numOnPage3 - param.page3 == 0}">
										<li class="disabled"><a>&raquo;</a></li>
									</c:if>
									<c:if test="${myNumBookTour/numOnPage3 - param.page3 > 0}">
										<li><a
											href="${pageContext.request.contextPath }/managemyreg/${idUser}?page=${page3 + 1}">&raquo;</a>
										</li>
									</c:if>
								</ul>
							</c:if>
						</div>
						<!-- End pagination -->
					</div>
					<!-- End My Tour List -->
				</div>
			</div>
			<!-- End Tabs -->
		</div>
	</div>
</div>
<!-- === END CONTENT === -->
<!-- === BEGIN FOOTER === -->
<%@ include file="userfooter.jsp"%>
<!-- === END FOOTER === -->