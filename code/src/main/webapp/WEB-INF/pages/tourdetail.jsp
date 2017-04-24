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
				<!-- Tour Detail Box -->
				<div class="col-md-6 col-md-offset-3 col-sm-offset-3">
					<s:form class="signup-page" commandName="tourData"
						action="${pageContext.request.contextPath }/detail/${tourData.idTour}"
						method="POST">
						<div class="signup-header">
							<h2 style="text-align: center;">Thông Tin Tour Du Lịch</h2>
							<br>
						</div>
						<label>Tên tour</label>
						<div class="input-group margin-bottom-20">
							<span class="input-group-addon"> <i class="fa fa-font"></i>
							</span>
							<s:input class="form-control margin-bottom-20" type="text"
								path="name" disabled="true" />
						</div>
						<div class="row">
							<div class="col-sm-6">
								<label>Ngày đi</label>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"> <i
										class="fa fa-calendar"></i>
									</span>
									<s:input class="form-control margin-bottom-20"
										path="departureDate" disabled="true" />
								</div>
							</div>
							<div class="col-sm-6">
								<label>Giờ đi</label>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"> <i
										class="fa fa-clock-o"></i>
									</span>
									<s:input class="form-control margin-bottom-20"
										path="departureTime" disabled="true" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6">
								<label>Ngày về</label>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"><i
										class="fa fa-calendar"></i> </span>
									<s:input class="form-control margin-bottom-20"
										path="returnDate" disabled="true" />
								</div>
							</div>
							<div class="col-sm-6">
								<label>Giờ về</label>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"><i class="fa fa-clock-o"></i>
									</span>
									<s:input class="form-control margin-bottom-20"
										path="returnTime" disabled="true" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6">
								<label>Giá vé</label>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"> <i class="fa fa-money"></i>
									</span>
									<s:input class="form-control margin-bottom-20" path="price"
										disabled="true" />
								</div>
							</div>
							<div class="col-sm-6">
								<label>Số lượng</label>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"><i
										class="fa fa-building-o"></i> </span>
									<s:input class="form-control margin-bottom-20" path="quantum"
										disabled="true" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6">
								<label>Ngày cho phép đăng ký</label>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"><i
										class="fa fa-calendar"></i> </span>
									<s:input class="form-control margin-bottom-20"
										path="dateAllowReg" disabled="true" />
								</div>
							</div>
							<div class="col-sm-6">
								<label>Ngày cho phép hủy</label>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"><i
										class="fa fa-calendar"></i> </span>
									<s:input class="form-control margin-bottom-20"
										path="dateAllowCancel" disabled="true" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6">
								<label>Số vé còn</label>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"><i
										class="fa fa-building-o"></i> </span>
									<s:input class="form-control margin-bottom-20"
										path="ticketAvailability" disabled="true" />
								</div>
							</div>
						</div>
						<p style="text-align: center; color: #ef5b92;">Những thông tin
							bắt buộc khách hàng phải điền khi đăng ký tham gia tour du lịch</p>
						<div class="row">
							<c:if test="${tourData.fieldName == true}">
								<div class="col-lg-6">
									<label class="checkbox"><s:checkbox path="fieldName"
											disabled="true" />Họ tên </label>
								</div>
							</c:if>
							<c:if test="${tourData.fieldSex == true}">
								<div class="col-lg-6">
									<label class="checkbox"><s:checkbox path="fieldSex"
											disabled="true" />Giới tính </label>
								</div>
							</c:if>
						</div>
						<div class="row">
							<c:if test="${tourData.fieldPhone == true}">
								<div class="col-lg-6">
									<label class="checkbox"><s:checkbox path="fieldPhone"
											disabled="true" />Số điện thoại</label>
								</div>
							</c:if>
							<c:if test="${tourData.fieldNumOfTicket == true}">
								<div class="col-lg-6">
									<label class="checkbox"><s:checkbox
											path="fieldNumOfTicket" disabled="true" />Số lượng vé </label>
								</div>
							</c:if>
						</div>
						<div class="row">
							<c:if test="${tourData.fieldEmail == true}">
								<div class="col-lg-6">
									<label class="checkbox"><s:checkbox path="fieldEmail"
											disabled="true" />Địa chỉ email</label>
								</div>
							</c:if>
							<c:if test="${tourData.fieldAddress == true}">
								<div class="col-lg-6">
									<label class="checkbox"><s:checkbox path="fieldAddress"
											disabled="true" />Địa chỉ </label>
								</div>
							</c:if>
						</div>
						<div class="row">
							<c:if test="${tourData.fieldIdCard == true}">
								<div class="col-lg-6">
									<label class="checkbox"><s:checkbox path="fieldIdCard"
											disabled="true" />Số chứng minh nhân dân </label>
								</div>
							</c:if>
						</div>
						<!-- <div class="col-sm-6">
								<label>Số vé hủy</label>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"><i
										class="fa fa-building-o"></i> </span>
									<s:input class="form-control margin-bottom-20"
										path="ticketAvailability" disabled="true" />
								</div>
							</div>
						</div> -->
						<label>Chi tiết tour</label>
						<s:input class="form-control margin-bottom-20" path="detail"
							disabled="true" />
						<br>
						<hr>
						<div class="row">
							<div class="col-lg-4 text-left">
								<a href="<c:url value='/updatetour/${tourData.idTour}'/>"><button
										class="btn btn-primary" type="button">Chỉnh Sửa</button></a>
							</div>
							<div class="col-lg-4 text-center">
								<a href="<c:url value='delete/${tourData.idTour}'/>"><button
										class="btn btn-primary" type="button">Xóa</button></a>
							</div>
							<div class="col-lg-4 text-right">
								<a href="<c:url value='/registrationlist/${tourData.idTour}'/>"><button
										class="btn btn-primary" type="button">DS Đăng Ký</button></a>
							</div>
						</div>
					</s:form>
				</div>
				<!-- End Tour Detail Box -->
			</div>
		</div>
	</div>
</div>
<!-- === END CONTENT === -->
<%@ include file="adminfooter.jsp"%>