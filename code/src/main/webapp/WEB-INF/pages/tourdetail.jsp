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
				<form action="" class="signup-page">
					<!-- Tour Detail Box -->
					<table>
						<thead>
							<tr>
								<td>Thông Tin Tour Du Lịch</td>
								<td></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>Tên tour:</td>
								<td>${tourData.name}</td>
							</tr>
							<tr>
								<td>Ngày đi:</td>
								<td><fmt:formatDate value="${tourData.departureDate}"
										pattern="dd/MM/yyyy" /></td>
							</tr>
							<tr>
								<td>Giờ đi:</td>
								<td>${tourData.departureTime}</td>
							</tr>
							<tr>
								<td>Ngày về:</td>
								<td><fmt:formatDate value="${tourData.returnDate}"
										pattern="dd/MM/yyyy" /></td>
							</tr>
							<tr>
								<td>Giờ về:</td>
								<td>${tourData.returnTime}</td>
							</tr>
							<tr>
								<td>Ngày cho phép đăng ký:</td>
								<td><fmt:formatDate value="${tourData.dateAllowReg}"
										pattern="dd/MM/yyyy" /></td>
							</tr>
							<tr>
								<td>Ngày cho phép hủy:</td>
								<td><fmt:formatDate value="${tourData.dateAllowCancel}"
										pattern="dd/MM/yyyy" /></td>
							</tr>
							<tr>
								<td>Giá vé:</td>
								<td>${tourData.price}đ</td>
							</tr>
							<tr>
								<td>Số lượng vé:</td>
								<td>${tourData.quantum}</td>
							</tr>
							<tr>
								<td>Số vé còn:</td>
								<td>${tourData.ticketAvailability}</td>
							</tr>
							<tr>
								<td>Chi tiết tour:</td>
								<td>${tourData.detail}</td>
							</tr>
						</tbody>
						<thead>
							<tr>
								<td>Các thông tin khách hàng phải điền khi đặt vé</td>
								<td></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<c:if test="${tourData.fieldName}">
									<td>Họ tên</td>
								</c:if>
								<c:if test="${tourData.fieldSex}">
									<td>Giới tính</td>
								</c:if>
							</tr>
							<tr>
								<c:if test="${tourData.fieldPhone}">
									<td>Số điện thoại</td>
								</c:if>
								<c:if test="${tourData.fieldNumOfTicket}">
									<td>Số lượng vé</td>
								</c:if>
							</tr>
							<tr>
								<c:if test="${tourData.fieldEmail}">
									<td>Địa chỉ email</td>
								</c:if>
								<c:if test="${tourData.fieldAddress}">
									<td>Địa chỉ</td>
								</c:if>
							</tr>
							<tr>
								<c:if test="${tourData.fieldIdCard}">
									<td>Số chứng minh nhân dân</td>
									<td></td>
								</c:if>
							</tr>
						</tbody>
					</table>
				</form>
				<br> <a href="<c:url value='delete/${tourData.idTour}'/>">
					<button type="button" id="only${tourData.idTour}" hidden="true"></button>
				</a>
				<div class="row">
					<div class="col-lg-4 text-center">
						<a href="<c:url value='/updatetour/${tourData.idTour}'/>"><button
								class="btn btn-primary" type="button">Chỉnh Sửa</button></a>
					</div>
					<div class="col-lg-4 text-center">
						<button class="btn btn-primary delete" id="${tourData.idTour}">Xóa</button>
					</div>
					<div class="col-lg-4 text-center">
						<a href="<c:url value='/registrationlist/${tourData.idTour}'/>"><button
								class="btn btn-primary" type="button">Danh Sách Đăng Ký</button></a>
					</div>
				</div>
			</div>
			<!-- End Tour Detail Box -->
		</div>
	</div>
</div>
<!-- === END CONTENT === -->
<%@ include file="adminfooter.jsp"%>