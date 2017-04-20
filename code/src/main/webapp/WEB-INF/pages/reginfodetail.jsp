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
				<form action="" class="signup-page">
					<!-- Table -->
					<table>
						<thead>
							<tr>
								<td>Thông tin khách hàng đặt vé</td>
								<td></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<c:if test="${cusData.tour.fieldName}">
									<td>Họ tên:</td>
									<td>${cusData.cusName}</td>
								</c:if>
							</tr>
							<tr>
								<c:if test="${cusData.tour.fieldSex}">
									<td>Giới tính:</td>
									<td>${cusData.cusSex}</td>
								</c:if>
							</tr>
							<tr>
								<c:if test="${cusData.tour.fieldYearOfBirth}">
									<td>Năm sinh:</td>
									<td>${cusData.cusYearOfBirth}</td>
								</c:if>
							</tr>
							<tr>
								<c:if test="${cusData.tour.fieldPhone}">
									<td>Số điện thoại:</td>
									<td>${cusData.cusPhone}</td>
								</c:if>
							</tr>
							<tr>
								<c:if test="${cusData.tour.fieldIdCard}">
									<td>Số chứng minh nhân dân:</td>
									<td>${cusData.cusIdCard}</td>
								</c:if>
							</tr>
							<tr>
								<c:if test="${cusData.tour.fieldEmail}">
									<td>Địa chỉ email:</td>
									<td>${register.cusEmail}</td>
								</c:if>
							</tr>
							<tr>
								<c:if test="${cusData.tour.fieldEmail}">
									<td>Địa chỉ:</td>
									<td>${register.cusAddress}</td>
								</c:if>
							</tr>
							<tr>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>Được đăng ký bởi:</td>
								<td>${cusData.whoIsRegistered}</td>
							</tr>
							<c:if test="${!empty cusData.relation}">
								<tr>
									<td>Mối quan hệ với người đăng ký:</td>
									<td>${cusData.relation}</td>
								</tr>
							</c:if>
						</tbody>
					</table>
				</form>
				<br>
				<!-- End Table -->
				<a
					href="<c:url value='/cancelreg/${cusData.idBT}/${cusData.tour.idTour}'/>">
					<button type="button" id="regcancel${cusData.idBT}" hidden="true"></button>
				</a> <a
					href="<c:url value='/cancelallreg/${cusData.idBT}/${cusData.relationship}/${cusData.tour.idTour}'/>">
					<button type="button" id="allcancel${cusData.idBT}" hidden="true"></button>
				</a> <br>
				<div class="row">
					<c:if test="${not cusData.cusCancel}">
						<div class="col-lg-4 text-center">
							<a
								href="<c:url value='/editreginfo/${cusData.idBT}/${cusData.tour.idTour}'/>"><button
									class="btn btn-primary">Chỉnh Sửa</button></a>
						</div>
						<c:if test="${cusData.tour.cancelOrNot}">
							<div class="col-lg-4 text-center">
								<c:if test="${cusData.cusName eq cusData.whoIsRegistered}">
									<button class="btn btn-primary cancel"
										id="cancel${cusData.idBT}">Hủy Đăng Ký</button>
								</c:if>
								<c:if test="${cusData.cusName ne cusData.whoIsRegistered}">
									<a
										href="<c:url value='/cancelreg/${cusData.idBT}/${cusData.tour.idTour}'/>"><button
											class="btn btn-primary">Hủy Đăng Ký</button></a>
								</c:if>
							</div>
						</c:if>
						<div class="col-lg-4 text-center">
							<button onclick="goBack()" class="btn btn-primary" type="button">Trở
								Về</button>
						</div>
					</c:if>
					<c:if test="${cusData.cusCancel}">
						<div class="col-lg-6 text-center">
							<a
								href="<c:url value='/undocancel/${cusData.idBT}/${cusData.tour.idTour}'/>"><button
									class="btn btn-primary">Phục Hồi</button></a>
						</div>
						<div class="col-lg-6 text-center">
							<button onclick="goBack()" class="btn btn-primary" type="button">Trở
								Về</button>
						</div>
					</c:if>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- === END CONTENT === -->
<%@ include file="userfooter.jsp"%>