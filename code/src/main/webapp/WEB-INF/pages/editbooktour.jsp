<!-- === BEGIN HEADER === -->
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="userheader.jsp"%>
<!-- === END HEADER === -->
<!-- === BEGIN CONTENT === -->
<div id="content">
	<div class="container background-white">
		<div class="container">
			<div class="row margin-vert-30">
				<!-- Edit Book Tour Box -->
				<div class="col-md-6 col-md-offset-3 col-sm-offset-3">
					<s:form class="signup-page" commandName="cusData"
						id="createTourForm"
						action="${pageContext.request.contextPath }/editbooktour/${cusData.idBT}/${idTour}"
						method="POST">
						<div class="signup-header">
							<h2 style="text-align: center;">Cập nhật Thông Tin Khách
								Hàng Đặt Vé</h2>
							</br>
						</div>
						<s:input path="confirmCode" hidden="true" />
						<div class="row">
							<c:if test="${tour.fieldName == true}">
								<div class="col-sm-8">
									<label>Họ tên</label>
									<!-- Show error -->
									</br> <small><s:errors path="cusName" cssStyle="color:red;" /></small>
									<div class="input-group margin-bottom-20">
										<span class="input-group-addon"><i class="fa fa-font"></i>
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
										<span class="input-group-addon"><i class="fa fa-male"></i>
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
										<span class="input-group-addon"><i
											class="fa fa-envelope"></i> </span>
										<s:input placeholder="Nhập số điện thoại" class="form-control"
											type="text" path="cusPhone" />
									</div>
								</div>
							</c:if>
							<c:if test="${tour.fieldNumOfTicket == true}">
								<div class="col-sm-5">
									<label>Số lượng</label>
									<!-- Show error -->
									<div class="input-group margin-bottom-20">
										<span class="input-group-addon"><i
											class="fa fa-building-o"></i> </span>
										<s:select class="form-control margin-bottom-20"
											name="cus_offered" id="main-select" path="cusNumOfTicket">
											<option value="${cusData.cusNumOfTicket}">${cusData.cusNumOfTicket }</option>
											<c:forEach var="j" begin="1" end="4">
												<c:if test="${not (j == cusData.cusNumOfTicket )}">
													<option value="${j}">${j}</option>
												</c:if>
											</c:forEach>
										</s:select>
									</div>
								</div>
							</c:if>
						</div>
						<div class="number-option" id="number1">
							<div class="number-option" id="number2">
								<div class="row">
									<div class="col-sm-8">
										<label>Họ tên người thứ 2</label>
										<!-- Show error -->
										</br> <small><s:errors path="cusName1"
												cssStyle="color:red;" /></small>
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
										</br> <small><s:errors path="cusYearOfBirth1"
												cssStyle="color:red;" /></small>
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
							<div class="number-option" id="number3">
								<div class="row">
									<div class="col-sm-8">
										<label>Họ tên người thứ 3</label>
										<!-- Show error -->
										</br> <small><s:errors path="cusName2"
												cssStyle="color:red;" /></small>
										<div class="input-group margin-bottom-20">
											<span class="input-group-addon"> <i class="fa fa-font"></i>
											</span>
											<s:input placeholder="Nhập họ tên" class="form-control"
												type="text" path="cusName2" />
										</div>
									</div>
									<div class="col-sm-4">
										<label>Năm sinh</label>
										<!-- Show error -->
										</br> <small><s:errors path="cusYearOfBirth2"
												cssStyle="color:red;" /></small>
										<div class="input-group margin-bottom-20">
											<span class="input-group-addon"> <i
												class="fa fa-calendar"></i>
											</span>
											<s:input placeholder="Nhập năm sinh" class="form-control"
												type="text" path="cusYearOfBirth2" />
										</div>
									</div>
								</div>
							</div>
							<div class="number-option" id="number4">
								<div class="row">
									<div class="col-sm-8">
										<label>Họ tên người thứ 4</label>
										<!-- Show error -->
										</br> <small><s:errors path="cusName3"
												cssStyle="color:red;" /></small>
										<div class="input-group margin-bottom-20">
											<span class="input-group-addon"> <i class="fa fa-font"></i>
											</span>
											<s:input placeholder="Nhập họ tên" class="form-control"
												type="text" path="cusName3" />
										</div>
									</div>
									<div class="col-sm-4">
										<label>Năm sinh</label>
										<!-- Show error -->
										</br> <small><s:errors path="cusYearOfBirth3"
												cssStyle="color:red;" /></small>
										<div class="input-group margin-bottom-20">
											<span class="input-group-addon"> <i
												class="fa fa-calendar"></i>
											</span>
											<s:input placeholder="Nhập năm sinh" class="form-control"
												type="text" path="cusYearOfBirth3" />
										</div>
									</div>
								</div>
							</div>
							<c:if test="${tour.fieldEmail}">
								<label>Email</label>
								<!-- Show error -->
								</br>
								<small><s:errors path="cusEmail" cssStyle="color:red;" /></small>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"><i
										class="fa fa-envelope"></i> </span>
									<s:input placeholder="Nhập email" class="form-control"
										type="text" path="cusEmail" />
								</div>
							</c:if>
							<c:if test="${tour.fieldAddress == true}">
								<label>Địa chỉ</label>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"> <i class="fa fa-home"></i>
									</span>
									<s:input placeholder="Nhập địa chỉ" class="form-control"
										type="text" path="cusAddress" />
								</div>
							</c:if>
							<c:if test="${tour.fieldIdCard == true}">
								<label>Số chứng minh nhân dân</label>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"><i
										class="fa fa-credit-card"></i> </span>
									<s:input placeholder="Nhập chứng minh nhân dân"
										class="form-control" type="text" path="cusIdCard" />
								</div>
							</c:if>
							<hr>
							<div class="row">
								<div class="col-lg-6 text-center">
									<button class="btn btn-primary" type="submit">Xác Nhận</button>
								</div>
								<div class="col-lg-6 text-center">
									<button onclick="goBack()" class="btn btn-primary"
										type="button">Hủy Bỏ</button>
								</div>
							</div>
					</s:form>
				</div>
				<!-- End Edit Book Tour Box -->
			</div>
		</div>
	</div>
</div>
<!-- === END CONTENT === -->
<!-- === BEGIN FOOTER === -->
<%@ include file="userfooter.jsp"%>
<!-- === END FOOTER === -->