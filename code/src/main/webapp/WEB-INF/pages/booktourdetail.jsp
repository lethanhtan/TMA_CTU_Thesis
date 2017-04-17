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
				<form class="signup-page">
					<!-- Table -->
					<table>
						<thead>
							<tr>
								<td>Thông tin tour</td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>Tên tour:</td>
								<td>${cusData.tour.name}</td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>Ngày đi:</td>
								<td>${cusData.tour.departureDate}</td>
								<td>Giờ đi:</td>
								<td>${cusData.tour.departureTime}</td>
							</tr>
							<tr>
								<td>Ngày về:</td>
								<td>${cusData.tour.returnDate}</td>
								<td>Giờ về:</td>
								<td>${cusData.tour.returnTime}</td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td style="color: #ef5b92;">Giá vé:</td>
								<td style="color: #ef5b92;">${price}<c:out value=" đ" /></td>
							</tr>
						</tbody>
					</table>
					</br>
					<table>
						<thead>
							<tr>
								<td>Thông tin đặt vé</td>
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
				</br>
				<!-- End Table -->
				</br>
				<div class="row">
					<div class="col-lg-6 text-center">
						<a href="<c:url value='/editbooktour/${cusData.idBT}/${idTour}'/>"><button
								class="btn btn-primary">Chỉnh Sửa</button></a>
					</div>
					<div class="col-lg-6 text-center">
						<button onclick="goBack()" class="btn btn-primary" type="button">Trở
							Về</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- === END CONTENT === -->
<%@ include file="userfooter.jsp"%>