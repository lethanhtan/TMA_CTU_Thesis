<!-- === BEGIN HEADER === -->
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="userheader.jsp"%>
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
							placeholder="Nhập điện thoại/ email" name="valueSearch">
						<button type="submit" class="btn btn-primary">Tìm Kiếm</button>
					</div>
				</form>
			</div>
			<!-- End Search Form -->
			<c:if test="${not empty registrationList}">
				<table>
					<thead>
						<tr>
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
						<c:forEach items="${registrationList}" var="bookTour">
							<!-- use subList render list tour to display -->
							<tr>
								<td>${bookTour.cusName}</td>
								<td>${bookTour.cusSex}</td>
								<td>&nbsp;&nbsp;&nbsp; ${bookTour.cusPhone}</td>
								<td>&nbsp;&nbsp;&nbsp; ${bookTour.cusEmail}</td>
								<td>&nbsp;&nbsp;&nbsp;${bookTour.cusNumOfTicket}&nbsp;&nbsp;&nbsp;</td>
								<td><a
									href="<c:url value='/booktourdetail/${bookTour.idBT}/${tour.idTour}'/>"><button
											class="btn btn-sm btn-violet">
											<i class="fa fa-eye">&nbsp;Xem</i>
										</button></a> <a
									href="<c:url value='/editbooktour/${bookTour.idBT}/${tour.idTour }'/>"><button
											class="btn btn-sm btn-success">
											<i class="fa fa-pencil">&nbsp;Sửa</i>
										</button></a> <c:if test="${tour.cancelOrNot}">
										<a href="#deleteConfirm" data-toggle="modal"><button
												class="btn btn-sm btn-danger">
												<i class="fa fa-times">&nbsp;Hủy Đăng Ký</i>
											</button></a>
										<!-- Popup Cofirm -->
										<div id="deleteConfirm" class="modal fade">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal"
															aria-hidden="true">&times;</button>
														<h4 class="modal-title">Quý khách muốn hủy đăng ký
															tour đã chọn?</h4>
														</br> <a
															href="<c:url value='/cancelbooktour/${bookTour.idBT}'/>">
															<button type="button" class="btn btn-danger">Có</button>
														</a>
														<button type="button" class="btn btn-primary"
															data-dismiss="modal">Không</button>
													</div>
												</div>
											</div>
										</div>
										<!-- End Popup Cofirm -->
									</c:if></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
			<c:if test="${empty registrationList}">
				<!-- Book Tour Box -->
				<div class="signup-header">
					<h2 style="text-align: center;">Thông Tin Đặt Vé</h2>
					</br>
				</div>
				<div class="col-md-6 col-md-offset-3 col-sm-offset-3">
					<img alt="Web Counter" border="0"
						src="http://pumpernickelpixie.com/wp-content/uploads/2015/06/31.gif"
						width="500px" height="250px"
						style="display: block; margin-right: auto; margin-left: auto; text-align: center" /></br>
					<form role="form" class="signup-page"
						action="${pageContext.request.contextPath}/booktour/${idTour}"
						method="get">
						<div class="row">
							<div class="col-sm-8">
								<label for="selectTour" style="text-align: left;">Số
									lượng vé:</label>
							</div>
							<div class="col-sm-4">
								<select class="form-control margin-bottom-20" name="numTicket"
									id="main-select" onchange="this.form.submit()">
									<option value="${numOfTicket}">${numOfTicket}</option>
									<c:forEach var="j" begin="1" end="${tour.ticketAvailability}">
										<c:if test="${not (j == numOfTicket)}">
											<option value="${j}">${j}</option>
										</c:if>
									</c:forEach>
								</select>
							</div>
						</div>
					</form>
				</div>
				<div class="col-md-6 col-md-offset-3 col-sm-offset-3">
					<s:form class="signup-page" commandName="cusData"
						action="${pageContext.request.contextPath}/booktour/${idTour}"
						method="POST">
						<c:forEach var="info" items="${cusData.info}" varStatus="status">
							<label>Thông tin người thứ <c:out
									value="${status.index + 1}: " /></label>
							<div class="row">
								<div class="col-sm-8">
									<label>Họ tên</label>
									<!-- Show error -->
									</br> <small><s:errors path="info[${status.index}].cusName"
											cssStyle="color:red;" /></small>
									<div class="input-group margin-bottom-20">
										<span class="input-group-addon"> <i class="fa fa-font"></i>
										</span>
										<s:input placeholder="Nhập họ tên" class="form-control"
											type="text" path="info[${status.index}].cusName" />
									</div>
								</div>
								<div class="col-sm-4">
									<label>Giới tính</label>
									<div class="input-group margin-bottom-20">
										<span class="input-group-addon"> <i class="fa fa-male"></i>
										</span>
										<s:select class="form-control margin-bottom-20"
											path="info[${status.index}].cusSex">
											<option>Nam</option>
											<option>Nữ</option>
										</s:select>
									</div>
								</div>
							</div>
							<div class="row">
								<c:if test="${tour.fieldYearOfBirth == true}">
									<div class="col-sm-5">
										<label>Năm sinh</label>
										<!-- Show error -->
										</br> <small><s:errors path="info[${status.index}].cusName"
												cssStyle="color:red;" /></small>
										<div class="input-group margin-bottom-20">
											<span class="input-group-addon"> <i
												class="fa fa-calendar"></i>
											</span>
											<s:input placeholder="Nhập năm sinh" class="form-control"
												type="text" path="info[${status.index}].cusYearOfBirth" />
										</div>
									</div>
								</c:if>
								<c:if test="${tour.fieldPhone == true}">
									<div class="col-sm-7">
										<label>Số điện thoại</label>
										<!-- Show error -->
										</br> <small><s:errors
												path="info[${status.index}].cusPhone" cssStyle="color:red;" /></small>
										<div class="input-group margin-bottom-20">
											<span class="input-group-addon"> <i
												class="fa fa-mobile"></i>
											</span>
											<s:input placeholder="Nhập số điện thoại"
												class="form-control" type="text"
												path="info[${status.index}].cusPhone" />
										</div>
									</div>
								</c:if>
							</div>
							<c:if test="${tour.fieldIdCard}">
								<label>Số chứng minh nhân dân</label>
								<!-- Show error -->
								</br>
								<small><s:errors path="info[${status.index}].cusIdCard"
										cssStyle="color:red;" /></small>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"> <i
										class="fa fa-credit-card"></i>
									</span>
									<s:input placeholder="Nhập số chứng minh nhân dân" class="form-control"
										type="text" path="info[${status.index}].cusIdCard" />
								</div>
							</c:if>
							<c:if test="${status.index == 0}">
								<c:if test="${tour.fieldEmail}">
									<label>Email</label>
									<!-- Show error -->
									</br>
									<small><s:errors path="info[${status.index}].cusEmail"
											cssStyle="color:red;" /></small>
									<div class="input-group margin-bottom-20">
										<span class="input-group-addon"> <i
											class="fa fa-envelope"></i>
										</span>
										<s:input placeholder="Nhập email" class="form-control"
											type="text" path="info[${status.index}].cusEmail" />
									</div>
								</c:if>
								<c:if test="${tour.fieldAddress}">
									<label>Địa chỉ</label>
									<!-- Show error -->
									</br>
									<small><s:errors
											path="info[${status.index}].cusAddress" cssStyle="color:red;" /></small>
									<div class="input-group margin-bottom-20">
										<span class="input-group-addon"> <i class="fa fa-home"></i>
										</span>
										<s:input placeholder="Nhập địa chỉ" class="form-control"
											type="text" path="info[${status.index}].cusAddress" />
									</div>
								</c:if>
							</c:if>
							<hr>
							<c:if test="${status.index == numOfTicket - 1}">
								<!-- reCAPTCHA -->
								<p style="color: red;">${errorString}</p>
								<div style="margin-left: 37px;" class="g-recaptcha"
									data-sitekey="6Le28hQUAAAAAFKa2w76sfgp5ULrd4iIYJLwtxOd"></div>
								</br>
								<!-- End reCAPTCHA -->
								<div class="row">
									<div class="col-lg-6 text-center">
										<button class="btn btn-primary" type="submit">Đăng Ký</button>
									</div>
									<div class="col-lg-6 text-center">
										<a href="${pageContext.request.contextPath}/tourlist"><button
												class="btn btn-primary" type="button">Trở về</button></a>
									</div>
								</div>
							</c:if>
						</c:forEach>
					</s:form>
				</div>
			</c:if>
			<!-- End Book Tour Box -->
		</div>
	</div>
</div>
<!-- === END CONTENT === -->
<!-- === BEGIN FOOTER === -->
<%@ include file="userfooter.jsp"%>
<!-- === END FOOTER === -->