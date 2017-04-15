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
								<c:if test="${cusData.tour.fieldName == true}">
									<td>Họ tên:</td>
									<td>${cusData.cusName}</td>
								</c:if>
							</tr>
							<tr>
								<c:if test="${cusData.tour.fieldSex == true}">
									<td>Giới tính:</td>
									<td>${cusData.cusSex}</td>
								</c:if>
							</tr>
							<tr>
								<c:if test="${cusData.tour.fieldYearOfBirth == true}">
									<td>Năm sinh:</td>
									<td>${cusData.cusYearOfBirth}</td>
								</c:if>
							</tr>
							<tr>
								<c:if test="${cusData.tour.fieldPhone == true}">
									<td>Số điện thoại:</td>
									<td>${cusData.cusPhone}</td>
								</c:if>
							</tr>
							<tr>
								<c:if test="${cusData.tour.fieldIdCard == true}">
									<td>Số chứng minh nhân dân:</td>
									<td>${cusData.cusIdCard}</td>
								</c:if>
							</tr>
							<tr>
								<c:if test="${cusData.tour.fieldEmail == true}">
									<td>Địa chỉ email:</td>
									<td>${cusData.cusEmail}</td>
								</c:if>
							</tr>
							<tr>
								<c:if test="${cusData.tour.fieldEmail == true}">
									<td>Địa chỉ:</td>
									<td>${cusData.cusAddress}</td>
									<td></td>
									<td></td>
								</c:if>
							</tr>
						</tbody>
					</table>
				</form>
				</br>
				<!-- End Table -->
				</br>
				<div class="row">
					<div class="col-lg-6 text-center">
						<a
							href="<c:url value='/editreginfo/${cusData.idBT}/${cusData.tour.idTour}'/>"><button
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