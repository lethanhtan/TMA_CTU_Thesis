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
				<div class="col-md-6 col-md-offset-3 col-sm-offset-3">
					<s:form class="signup-page" commandName="cusData"
						action="${pageContext.request.contextPath}/booktour/${tour.idTour}"
						method="POST">
						<div class="signup-header">
							<h2 style="text-align: center;">Đặt Vé</h2>
							<img alt="Web Counter" border="0"
								src="http://pumpernickelpixie.com/wp-content/uploads/2015/06/31.gif"
								width="500px" height="250px"
								style="display: block; margin-right: auto; margin-left: auto; text-align: center" />
						</div>
						<div class="row">
							<c:if test="${tour.fieldName == true}">
								<div class="col-sm-8">
									<label>Họ tên</label>
									<!-- Show error -->
									</br> <small><s:errors path="cusName" cssStyle="color:red;" /></small>
									<div class="input-group margin-bottom-20">
										<span class="input-group-addon"> <i class="fa fa-font"></i>
										</span>
										<s:input placeholder="Nhập họ tên" class="form-control"
											type="text" path="cusName" />
									</div>
								</div>
							</c:if>
							<c:if test="${tour.fieldSex == true}">
								<div class="col-sm-4">
									<label>Giới tính</label>
									<div class="input-group margin-bottom-20">
										<span class="input-group-addon"> <i class="fa fa-male"></i>
										</span>
										<s:select class="form-control margin-bottom-20" path="cusSex">
											<option>Nam</option>
											<option>Nữ</option>
										</s:select>
									</div>
								</div>
							</c:if>
						</div>
						<div class="row">
							<c:if test="${tour.fieldPhone == true}">
								<div class="col-sm-7">
									<label>Số điện thoại</label>
									<!-- Show error -->
									</br> <small><s:errors path="cusPhone" cssStyle="color:red;" /></small>
									<div class="input-group margin-bottom-20">
										<span class="input-group-addon"> <i
											class="fa fa-envelope"></i>
										</span>
										<s:input placeholder="Nhập số điện thoại" class="form-control"
											type="text" path="cusPhone" />
									</div>
								</div>
							</c:if>
							<c:if test="${tour.fieldNumOfTicket == true}">
								<div class="col-sm-5">
									<label>Số lượng</label>
									<div class="input-group margin-bottom-20">
										<span class="input-group-addon"> <i
											class="fa fa-building-o"></i>
										</span>
										<s:select class="form-control margin-bottom-20"
											name="cus_offered" id="selectMe" path="cusNumOfTicket">
											<c:forEach var="j" begin="1" end="4">
												<option value="${j}">${j}</option>
											</c:forEach>
										</s:select>
									</div>
								</div>
							</c:if>
						</div>
						<div id="2" class="group">
							<div class="row">
								<div class="col-sm-8">
									<label>Họ tên người thứ 2</label>
									<!-- Show error -->
									</br> <small><s:errors path="cusName" cssStyle="color:red;" /></small>
									<div class="input-group margin-bottom-20">
										<span class="input-group-addon"> <i class="fa fa-font"></i>
										</span>
										<s:input placeholder="Nhập họ tên" class="form-control"
											type="text" path="cusName1" />
									</div>
								</div>
								<div class="col-sm-4">
									<label>Năm sinh</label>
									<!-- Show error -->
									</br> <small><s:errors path="cusName" cssStyle="color:red;" /></small>
									<div class="input-group margin-bottom-20">
										<span class="input-group-addon"> <i
											class="fa fa-calendar"></i>
										</span>
										<s:input placeholder="Nhập năm sinh" class="form-control"
											type="text" path="cusYearOfBirth1" />
									</div>
								</div>
							</div>
						</div>
						<div id="3" class="group">
							<c:forEach var="i" begin="1" end="2">
								<div class="row">
									<div class="col-sm-8">
										<label>Họ tên người thứ <c:out value="${i + 1}" /></label>
										<!-- Show error -->
										</br> <small><s:errors path="cusName" cssStyle="color:red;" /></small>
										<div class="input-group margin-bottom-20">
											<span class="input-group-addon"> <i class="fa fa-font"></i>
											</span>
											<s:input placeholder="Nhập họ tên" class="form-control"
												type="text" path="cusName${i}" />
										</div>
									</div>
									<div class="col-sm-4">
										<label>Năm sinh</label>
										<!-- Show error -->
										</br> <small><s:errors path="cusName" cssStyle="color:red;" /></small>
										<div class="input-group margin-bottom-20">
											<span class="input-group-addon"> <i
												class="fa fa-calendar"></i>
											</span>
											<s:input placeholder="Nhập năm sinh" class="form-control"
												type="text" path="cusYearOfBirth${i}" />
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
						<div id="4" class="group">
							<c:forEach var="i" begin="1" end="3">
								<div class="row">
									<div class="col-sm-8">
										<label>Họ tên người thứ <c:out value="${i + 1}" /></label>
										<!-- Show error -->
										</br> <small><s:errors path="cusName" cssStyle="color:red;" /></small>
										<div class="input-group margin-bottom-20">
											<span class="input-group-addon"> <i class="fa fa-font"></i>
											</span>
											<s:input placeholder="Nhập họ tên" class="form-control"
												type="text" path="cusName${i}" />
										</div>
									</div>
									<div class="col-sm-4">
										<label>Năm sinh</label>
										<!-- Show error -->
										</br> <small><s:errors path="cusName" cssStyle="color:red;" /></small>
										<div class="input-group margin-bottom-20">
											<span class="input-group-addon"> <i
												class="fa fa-calendar"></i>
											</span>
											<s:input placeholder="Nhập năm sinh" class="form-control"
												type="text" path="cusYearOfBirth${i}" />
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
						<c:if test="${tour.fieldEmail}">
							<label>Email</label>
							<!-- Show error -->
							</br>
							<small><s:errors path="cusEmail" cssStyle="color:red;" /></small>
							<div class="input-group margin-bottom-20">
								<span class="input-group-addon"> <i
									class="fa fa-envelope"></i>
								</span>
								<s:input placeholder="Nhập email" class="form-control"
									type="text" path="cusEmail" />
							</div>
						</c:if>
						<c:if test="${tour.fieldAddress}">
							<label>Địa chỉ</label>
							<!-- Show error -->
							</br>
							<small><s:errors path="cusAddress" cssStyle="color:red;" /></small>
							<div class="input-group margin-bottom-20">
								<span class="input-group-addon"> <i class="fa fa-home"></i>
								</span>
								<s:input placeholder="Nhập địa chỉ" class="form-control"
									type="text" path="cusAddress" />
							</div>
						</c:if>
						<c:if test="${tour.fieldIdCard}">
							<label>Số chứng minh nhân dân</label>
							<!-- Show error -->
							</br>
							<small><s:errors path="cusIdCard" cssStyle="color:red;" /></small>
							<div class="input-group margin-bottom-20">
								<span class="input-group-addon"> <i
									class="fa fa-credit-card"></i>
								</span>
								<s:input placeholder="Nhập địa chỉ" class="form-control"
									type="text" path="cusIdCard" />
							</div>
						</c:if>
						<hr>
						<div class="row">
							<div class="col-lg-6 text-center">
								<button class="btn btn-primary" type="submit">Đăng Ký</button>
							</div>
							<div class="col-lg-6 text-center">
								<a href="${pageContext.request.contextPath}/tourlist"><button
										class="btn btn-primary" type="button">Hủy Bỏ</button></a>
							</div>
						</div>
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