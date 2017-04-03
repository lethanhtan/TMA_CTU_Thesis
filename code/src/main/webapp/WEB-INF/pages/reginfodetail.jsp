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
				<!-- Book Tour Detail Box -->
				<div class="col-md-6 col-md-offset-3 col-sm-offset-3">
					<s:form class="signup-page" commandName="cusData"
						action="${pageContext.request.contextPath }/booktourdetail/${cusData.idBT}/${idTour}"
						method="POST">
						<div class="signup-header">
							<h2 style="text-align: center;">Thông Tin Khách Hàng Đặt Vé</h2>
							</br>
						</div>
						<div class="row">
							<c:if test="${tour.fieldName == true}">
								<div class="col-sm-8">
									<label>Họ tên</label>
									<!-- Show error -->
									</br>
									<small><s:errors path="cusName" cssStyle="color:red;" /></small>
									<div class="input-group margin-bottom-20">
										<span class="input-group-addon"><i class="fa fa-font"></i>
										</span>
										<s:input class="form-control" path="cusName" disabled="true" />
									</div>
								</div>
							</c:if>
							<c:if test="${tour.fieldSex == true}">
								<div class="col-sm-4">
									<label>Giới tính</label>
									<div class="input-group margin-bottom-20">
										<span class="input-group-addon"> <i class="fa fa-male"></i>
										</span>
										<s:input class="form-control margin-bottom-20" path="cusSex"
											disabled="true" />
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
											class="fa fa-tablet"></i>
										</span>
										<s:input class="form-control" path="cusPhone" disabled="true" />
									</div>
								</div>
							</c:if>
							<c:if test="${tour.fieldNumOfTicket == true}">
								<div class="col-sm-5">
									<label>Số lượng</label>
									<!-- Show error -->
									<div class="input-group margin-bottom-20">
										<span class="input-group-addon"> <i
											class="fa fa-building-o"></i>
										</span>
										<s:input class="form-control margin-bottom-20"
											path="ticketCancel" disabled="true" />
									</div>
								</div>
							</c:if>
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
								<s:input class="form-control" path="cusEmail" disabled="true" />
							</div>
						</c:if>
						<c:if test="${tour.fieldAddress == true}">
							<label>Địa chỉ</label>
							<div class="input-group margin-bottom-20">
								<span class="input-group-addon"> <i class="fa fa-home"></i>
								</span>
								<s:input class="form-control" path="cusAddress" disabled="true" />
							</div>
						</c:if>
						<c:if test="${tour.fieldIdCard == true}">
							<label>Số chứng minh nhân dân</label>
							<div class="input-group margin-bottom-20">
								<span class="input-group-addon"> <i
									class="fa fa-credit-card"></i>
								</span>
								<s:input class="form-control" path="cusIdCard" disabled="true" />
							</div>
						</c:if>
						<hr>
						<div class="row">
							<div class="col-lg-4 text-left">
								<a
									href="<c:url value='/undocancel/${cusData.idBT}/${cusData.tour.idTour}'/>"><button
										class="btn btn-primary" type="button">Phục Hồi</button></a>
							</div>
							<div class="col-lg-4 text-center">
								<a href="<c:url value='/deletebooktour/${cusData.idBT}'/>"><button
										class="btn btn-primary" type="button">Xóa</button></a>
							</div>
							<div class="col-lg-4 text-right">
								<a href="<c:url value='/registrationlist/${idTour}'/>"><button
										class="btn btn-primary" type="button">Trở Về</button></a>
							</div>
						</div>
					</s:form>
				</div>
				<!-- End Book Tour Detail Box -->
			</div>
		</div>
	</div>
</div>
<!-- === END CONTENT === -->
<%@ include file="adminfooter.jsp"%>