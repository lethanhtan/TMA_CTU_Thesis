<!-- === BEGIN HEADER === -->
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="adminheader.jsp"%>
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
						action="${pageContext.request.contextPath }/editreginfo/${cusData.idBT}/${idTour}"
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
							<c:if test="${tour.fieldYearOfBirth == true}">
								<div class="col-sm-5">
									<label>Năm sinh</label>
									<!-- Show error -->
									</br> <small><s:errors path="cusYearOfBirth"
											cssStyle="color:red;" /></small>
									<div class="input-group margin-bottom-20">
										<span class="input-group-addon"><i
											class="fa fa-envelope"></i> </span>
										<s:input placeholder="Nhập số điện thoại" class="form-control"
											type="text" path="cusYearOfBirth" />
									</div>
								</div>
							</c:if>
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
						</div>
						<c:if test="${tour.fieldIdCard == true}">
							<label>Số chứng minh nhân dân</label>
							<div class="input-group margin-bottom-20">
								<span class="input-group-addon"><i
									class="fa fa-credit-card"></i> </span>
								<s:input placeholder="Nhập chứng minh nhân dân"
									class="form-control" type="text" path="cusIdCard" />
							</div>
						</c:if>
						<c:if test="${tour.fieldEmail}">
							<label>Email</label>
							<!-- Show error -->
							</br>
							<small><s:errors path="cusEmail" cssStyle="color:red;" /></small>
							<div class="input-group margin-bottom-20">
								<span class="input-group-addon"><i class="fa fa-envelope"></i>
								</span>
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
						<s:input path="idUser" hidden="true" />
						<hr>
						<div class="row">
							<div class="col-lg-6 text-center">
								<button class="btn btn-primary" type="submit">Xác Nhận</button>
							</div>
							<div class="col-lg-6 text-center">
								<a href="<c:url value='/registrationlist/${idTour}'/>"><button
										class="btn btn-primary" type="button">Hủy Bỏ</button></a>
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
<%@ include file="adminfooter.jsp"%>
<!-- === END FOOTER === -->