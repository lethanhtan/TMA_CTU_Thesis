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
					<div class="signup-header">
						<h2 style="text-align: center;">Thông Tin Đặt Vé</h2>
						<br>
					</div>
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
								<td><fmt:formatDate value="${cusData.tour.departureDate}"
										pattern="dd/MM/yyyy" /></td>
								<td>Giờ đi:</td>
								<td>${cusData.tour.departureTime}</td>
							</tr>
							<tr>
								<td>Ngày về:</td>
								<td><fmt:formatDate value="${cusData.tour.returnDate}"
										pattern="dd/MM/yyyy" /></td>
								<td>Giờ về:</td>
								<td>${cusData.tour.returnTime}</td>
							</tr>
							<tr>
								<td>Thời gian:</td>
								<td>${cusData.tour.howLong}ngày</td>
								<td style="color: #ef5b92;">Giá vé:</td>
								<td style="color: #ef5b92;">${price}<c:out value=" đ" /></td>
							</tr>
						</tbody>
					</table>
					<br>
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
				<br>
				<!-- End Table -->
				<a href="<c:url value='/cancel/${cusData.idBT}'/>">
					<button type="button" id="regcancel${cusData.idBT}" hidden="true"></button>
				</a> <a
					href="<c:url value='/cancelall/${cusData.idBT}/${cusData.relationship}'/>">
					<button type="button" id="allcancel${cusData.idBT}" hidden="true"></button>
				</a> <a href="<c:url value='/undo/${cusData.idBT}'/>">
					<button type="button" id="onlyundo${cusData.idBT}" hidden="true"></button>
				</a> <a
					href="<c:url value='/undoallcancel/${cusData.idBT}/${cusData.relationship}/${cusData.tour.idTour}'/>">
					<button type="button" id="allundo${cusData.idBT}" hidden="true"></button>
				</a> 
				<c:if test="${not cusData.goneOrNot}">
					<div class="row">
						<c:if test="${not cusData.cusCancel}">
							<div class="col-lg-4 text-center">
								<a
									href="<c:url value='/editbooktour/${cusData.idBT}/${idTour}'/>"><button
										class="btn btn-primary">Chỉnh Sửa</button></a>
							</div>
							<c:if test="${cusData.tour.cancelOrNot}">
								<c:if test="${not login}">
									<div class="col-lg-4 text-center">
										<a href="<c:url value='/cancelbooktour/${bookTour.idBT}'/>"><button
												class="btn btn-primary">Hủy Đăng Ký</button></a>
									</div>
								</c:if>
								<c:if test="${login}">
									<div class="col-lg-4 text-center">
										<c:if test="${cusData.cusName eq cusData.whoIsRegistered}">
											<button class="btn btn-primary cancelall"
												id="cancel${cusData.idBT}">Hủy Đăng Ký</button>
										</c:if>
										<c:if test="${cusData.cusName ne cusData.whoIsRegistered}">
											<button class="btn btn-primary cancel"
												id="cancel${cusData.idBT}">Hủy Đăng Ký</button>
										</c:if>
									</div>
								</c:if>
							</c:if>
							<div class="col-lg-4 text-center">
								<button onclick="goBack()" class="btn btn-primary" type="button">Trở
									Về</button>
							</div>
						</c:if>
						<c:if test="${cusData.cusCancel}">
							<div class="col-lg-6 text-center">
								<c:if test="${cusData.cusName eq cusData.whoIsRegistered}">
									<button class="btn btn-primary undoall"
										id="undo${cusData.idBT}">Phục Hồi</button>
								</c:if>
								<c:if test="${cusData.cusName ne cusData.whoIsRegistered}">
									<button class="btn btn-primary undo" id="undo${cusData.idBT}">
										Phục Hồi</button>
								</c:if>
							</div>
							<div class="col-lg-6 text-center">
								<button onclick="goBack()" class="btn btn-primary">Trở
									Về</button>
							</div>
						</c:if>
					</div>
				</c:if>
				<c:if test="${cusData.goneOrNot}">
					<button class="btn btn-primary" onclick="goBack()"
						style="margin-left: 85%;">
						<i class="fa fa-arrow-left">&nbsp;Trở Về</i>
					</button>
				</c:if>
			</div>
		</div>
	</div>
</div>
<!-- === END CONTENT === -->
<%@ include file="userfooter.jsp"%>