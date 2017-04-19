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
				<!-- Design Form -->
				<div class="col-md-6 col-md-offset-3 col-sm-offset-3">
					<s:form class="signup-page" commandName="designForm"
						action="${pageContext.request.contextPath }/designform/${idTour}"
						method="POST" id="checkboxV">
						<div class="signup-header">
							<h2 style="text-align: center;">Thiết Kế Thông Tin Đăng Ký</h2>
						</div>
						</br>
						<hr>
						<s:input value="${date4}" path="dateAllowCancel" hidden="true" />
						<s:input value="${date3}" path="dateAllowReg" hidden="true" />
						<s:input path="returnTime" hidden="true" />
						<s:input value="${date2}" path="returnDate" hidden="true" />
						<s:input value="${date1}" path="departureDate" hidden="true" />
						<s:input path="departureTime" hidden="true" />
						<s:input path="detail" hidden="true" />
						<s:input path="name" hidden="true" />
						<s:input path="price" hidden="true" />
						<s:input path="quantum" hidden="true" />
						<s:input path="ticketAvailability" hidden="true" />
						<s:input path="howLong" hidden="true" />
						<p style="text-align: center; color: #ef5b92;">Hãy chọn những
							thông tin bắt buộc khách hàng phải điền khi đăng ký tham gia tour
							du lịch!</p>
						<div class="row">
							<div class="col-lg-6">
								<label class="checkbox"><s:checkbox path="fieldName" />Họ
									tên </label>
							</div>
							<div class="col-lg-6">
								<label class="checkbox"><s:checkbox path="fieldSex" />Giới
									tính </label>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6">
								<label class="checkbox"><s:checkbox path="fieldPhone" />Số
									điện thoại</label>
							</div>
							<div class="col-lg-6">
								<label class="checkbox"><s:checkbox
										path="fieldNumOfTicket" />Số lượng vé </label>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6">
								<label class="checkbox"><s:checkbox
										path="fieldYearOfBirth" />Năm sinh</label>
							</div>
							<div class="col-lg-6">
								<label class="checkbox"><s:checkbox path="fieldIdCard" />Số
									chứng minh nhân dân </label>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6">
								<label class="checkbox"><s:checkbox path="fieldEmail" />Địa
									chỉ email</label>
							</div>
							<div class="col-lg-6">
								<label class="checkbox"><s:checkbox path="fieldAddress" />Địa
									chỉ</label>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-8">
								<label class="checkbox"><input type="checkbox"
									name="select-all" id="select-all">Chọn tất cả</label>
							</div>
						</div>
						<hr>
						<div class="row">
							<div class="col-lg-6 text-center">
								<button class="btn btn-primary" type="submit">Xác Nhận</button>
							</div>
							<div class="col-lg-6 text-center">
								<a href="<c:url value='/manageregister'/>"><button
										class="btn btn-primary" type="button">Hủy Bỏ</button></a>
							</div>
						</div>
					</s:form>
				</div>
				<!-- End Design Form -->
			</div>
		</div>
	</div>
</div>
<!-- === END CONTENT === -->
<!-- === BEGIN FOOTER === -->
<%@ include file="adminfooter.jsp"%>
<!-- === END FOOTER === -->