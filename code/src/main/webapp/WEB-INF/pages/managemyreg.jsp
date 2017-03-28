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
				<ul class="nav nav-tabs">
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
						<!-- Table -->
						<c:if test="${empty myRegList}">
							<h1 style="text-align: center;">Bạn chưa đăng ký tham gia
								tour nào!</h1>
						</c:if>
						<c:if test="${!empty myRegList}">
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
									<c:forEach items="${myRegList.subList(x,y)}" var="bookTour">
										<!-- use subList render list book tour to display -->
										<tr>
											<td>${myRegList.indexOf(bookTour) + 1}</td>
											<td>${bookTour.cusName}</td>
											<td>${bookTour.cusSex}</td>
											<td>&nbsp;&nbsp;&nbsp; ${bookTour.cusPhone}</td>
											<td>&nbsp;&nbsp;&nbsp; ${bookTour.cusEmail}</td>
											<td>&nbsp;&nbsp;&nbsp;${bookTour.cusNumOfTicket}&nbsp;&nbsp;&nbsp;</td>
											<td><a
												href="<c:url value='/booktourdetail/${bookTour.idBT}/${bookTour.tour.idTour}'/>">
													<button class="btn btn-sm btn-violet">
														<i class="fa fa-eye">&nbsp;Xem</i>
													</button>
											</a><a
												href="<c:url value='/editbooktour/${bookTour.idBT}/${bookTour.tour.idTour}'/>"><button
														class="btn btn-sm btn-success">
														<i class="fa fa-pencil">&nbsp;Sửa</i>
													</button></a> <c:if test="${bookTour.tour.cancelOrNot}">
													<a href="<c:url value='/cancel/${bookTour.idBT}'/>"><button
															class="btn btn-sm btn-danger">
															<i class="fa fa-pencil">&nbsp;Hủy Đăng Ký</i>
														</button></a>
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
							<c:if test="${myNumBT >= 5}">
								<!-- set active pagination when number of book tour >= 5 -->
								<ul class="pagination">
									<c:if test="${param.page != null}">
										<c:if test="${myNumBT/5 - param.page == myNumBT/5 - 1}">
											<li class="disabled"><a href="#">&laquo;</a></li>
										</c:if>
										<c:if test="${myNumBT/5 - param.page != myNumBT/5 - 1}">
											<li><a
												href="${pageContext.request.contextPath }/managemyreg/${idUser}?page=${param.page -1}">&laquo;</a>
											</li>
										</c:if>
									</c:if>
									<c:forEach items="${pageNum}" var="pageE">
										<c:if test="${pageE == param.page}">
											<li class="active"><a
												href="${pageContext.request.contextPath}/managemyreg/${idUser}?page=${pageE}">${pageE}</a></li>
										</c:if>
										<c:if test="${pageE != param.page}">
											<li><a
												href="${pageContext.request.contextPath}/managemyreg/${idUser}?page=${pageE}">${pageE}</a></li>
										</c:if>
									</c:forEach>
									<c:if test="${myNumBT/5 - param.page == 0}">
										<li class="disabled"><a
											href="${pageContext.request.contextPath }/managemyreg/${idUser}?page=${param.page + 1}">&raquo;</a>
										</li>
									</c:if>
									<c:if test="${myNumBT/5 - param.page > 0}">
										<li><a
											href="${pageContext.request.contextPath }/managemyreg/${idUser}?page=${param.page + 1}">&raquo;</a>
										</li>
									</c:if>
								</ul>
							</c:if>
						</div>
						<!-- End Pagination -->
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
						<!-- Table -->
						<c:if test="${empty myCancelList}">
							<h1 style="text-align: center;">Bạn chưa hủy đăng ký tham
								gia tour nào!</h1>
						</c:if>
						<c:if test="${!empty myCancelList}">
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
									<c:forEach items="${myCancelList.subList(x2,y2)}"
										var="myCancelReg">
										<!-- use subList render list cancel book tour to display -->
										<tr>
											<td>${myCancelList.indexOf(myCancelReg) + 1}</td>
											<td>${myCancelReg.cusName}</td>
											<td>${myCancelReg.cusSex}</td>
											<td>&nbsp;&nbsp;&nbsp; ${myCancelReg.cusPhone}</td>
											<td>&nbsp;&nbsp;&nbsp; ${myCancelReg.cusEmail}</td>
											<td>&nbsp;&nbsp;&nbsp;
												${myCancelReg.ticketCancel}&nbsp;&nbsp;&nbsp;</td>
											<td><a
												href="<c:url value='/booktourdetail/${myCancelReg.idBT}/${myCancelReg.tour.idTour}'/>">
													<button class="btn btn-sm btn-violet">
														<i class="fa fa-eye">&nbsp;Xem</i>
													</button>
											</a> <c:if test="${myCancelReg.tour.regOrNot}">
													<a
														href="<c:url value='/undo/${myCancelReg.idBT}/${myCancelReg.tour.idTour }'/>"><button
															class="btn btn-sm btn-success">
															<i class="fa fa-undo">&nbsp;Phục Hồi</i>
														</button></a>
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
							<c:if test="${myNumCancelReg >= 5}">
								<!-- set active pagination when number of cancel registration >= 5 -->
								<ul class="pagination">
									<c:if test="${param.page2 != null}">
										<c:if
											test="${myNumCancelReg/5 - param.page2 == myNumCancelReg/5 - 1}">
											<li class="disabled"><a href="#">&laquo;</a></li>
										</c:if>
										<c:if
											test="${myNumCancelReg/5 - param.page2 != myNumCancelReg/5 - 1}">
											<li><a
												href="${pageContext.request.contextPath }/managemyreg/${idUser}?page=${param.page2 -1}">&laquo;</a>
											</li>
										</c:if>
									</c:if>
									<c:forEach items="${pageNum2}" var="pageE2">
										<c:if test="${pageE2 == param.page2}">
											<li class="active"><a
												href="${pageContext.request.contextPath}/managemyreg/${idUser}?page=${pageE2}">${pageE2}</a></li>
										</c:if>
										<c:if test="${pageE2 != param.page2}">
											<li><a
												href="${pageContext.request.contextPath}/managemyreg/${idUser}?page=${pageE2}">${pageE2}</a></li>
										</c:if>
									</c:forEach>
									<c:if test="${myNumCancelReg/5 - param.page2 == 0}">
										<li class="disabled"><a
											href="${pageContext.request.contextPath }/managemyreg/${idUser}?page=${param.page2 + 1}">&raquo;</a>
										</li>
									</c:if>
									<c:if test="${myNumCancelReg/5 - param.page2 > 0}">
										<li><a
											href="${pageContext.request.contextPath }/managemyreg/${idUser}?page=${param.page2 + 1}">&raquo;</a>
										</li>
									</c:if>
								</ul>
							</c:if>
						</div>
						<!-- End Pagination -->
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
									<c:forEach items="${myBookTourList.subList(x3,y3)}"
										var="myBookTour">
										<!-- use subList render list cancel book tour to display -->
										<tr>
											<td>${myBookTourList.indexOf(myBookTour) + 1}</td>
											<td>${myBookTour.cusName}</td>
											<td>${myBookTour.cusSex}</td>
											<td>&nbsp;&nbsp;&nbsp; ${myBookTour.cusPhone}</td>
											<td>&nbsp;&nbsp;&nbsp; ${myBookTour.cusEmail}</td>
											<td>&nbsp;&nbsp;&nbsp;
												${myBookTour.ticketCancel}&nbsp;&nbsp;&nbsp;</td>
											<td><a
												href="<c:url value='/booktourdetail/${myBookTour.idBT}/${myBookTour.tour.idTour}'/>">
													<button class="btn btn-sm btn-violet">
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
							<c:if test="${myNumBookTour >= 5}">
								<!-- set active pagination when number of cancel registration >= 5 -->
								<ul class="pagination">
									<c:if test="${param.page3 != null}">
										<c:if
											test="${myNumBookTour/5 - param.page3 == myNumBookTour/5 - 1}">
											<li class="disabled"><a href="#">&laquo;</a></li>
										</c:if>
										<c:if
											test="${myNumBookTour/5 - param.page3 != myNumBookTour/5 - 1}">
											<li><a
												href="${pageContext.request.contextPath }/managemyreg/${idUser}?page=${param.page3 -1}">&laquo;</a>
											</li>
										</c:if>
									</c:if>
									<c:forEach items="${pageNum3}" var="pageE3">
										<c:if test="${pageE3 == param.page3}">
											<li class="active"><a
												href="${pageContext.request.contextPath}/managemyreg/${idUser}?page=${pageE3}">${pageE3}</a></li>
										</c:if>
										<c:if test="${pageE3 != param.page3}">
											<li><a
												href="${pageContext.request.contextPath}/managemyreg/${idUser}?page=${pageE3}">${pageE3}</a></li>
										</c:if>
									</c:forEach>
									<c:if test="${myNumBookTour/5 - param.page3 == 0}">
										<li class="disabled"><a
											href="${pageContext.request.contextPath }/managemyreg/${idUser}?page=${param.page3 + 1}">&raquo;</a>
										</li>
									</c:if>
									<c:if test="${myNumBookTour/5 - param.page3 > 0}">
										<li><a
											href="${pageContext.request.contextPath }/managemyreg/${idUser}?page=${param.page3 + 1}">&raquo;</a>
										</li>
									</c:if>
								</ul>
							</c:if>
						</div>
						<!-- End Pagination -->
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
<%@ include file="adminfooter.jsp"%>
<!-- === END FOOTER === -->