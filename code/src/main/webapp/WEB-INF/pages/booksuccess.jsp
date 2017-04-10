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
				<h2 style="color: red" align="center">Quý khách đã đặt vé thành
					công!</h2>
				</br>
				<s:form class="signup-page" commandName="tourData"
					action="${pageContext.request.contextPath }/booksuccess/${tourData.idTour}"
					method="POST">
					<!-- Table -->
					<table>
						<thead>
							<tr>
								<th>Thông tin tour</th>
								<th></th>
								<th>Thông tin đặt vé</th>
								<th></th>
							</tr>
							<tr>
								<td>Tên tour:</td>
								<td>${tourData.name}</td>
								<c:if test="${tourData.fieldName == true}">
									<td>Họ tên:</td>
									<td>${cusData.cusName}</td>
								</c:if>
							</tr>
							<tr>
								<td>Ngày đi:</td>
								<td>${tourData.departureDate}</td>
								<c:if test="${tourData.fieldSex == true}">
									<td>Giới tính:</td>
									<td>${cusData.cusSex}</td>
								</c:if>
							</tr>
							<tr>
								<td>Giờ đi:</td>
								<td>${tourData.departureTime}</td>
								<c:if test="${tourData.fieldPhone == true}">
									<td>Số điện thoại:</td>
									<td>${cusData.cusPhone}</td>
								</c:if>
							</tr>
							<tr>
								<td>Ngày về:</td>
								<td>${tourData.returnDate}</td>
								<c:if test="${tourData.fieldEmail == true}">
									<td>Email:</td>
									<td>${cusData.cusEmail}</td>
								</c:if>
							</tr>
							<tr>
								<td>Giờ về:</td>
								<td>${tourData.returnTime}</td>
								<c:if test="${tourData.fieldAddress == true}">
									<td>Địa chỉ:</td>
									<td>${cusData.cusAddress}</td>
								</c:if>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<c:if test="${tourData.fieldNumOfTicket == true}">
									<td>Số lượng:</td>
									<td>${cusData.cusNumOfTicket}</td>
								</c:if>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td>Tổng tiền:</td>
								<td>${price}<c:out value=" đ" /></td>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
					</br>
					<!-- End Table -->
					</br>
					<h2 align="center">
						<a href="/TravelSystem">Nhấn vào đây để trở về.</a>
					</h2>
				</s:form>
			</div>

		</div>

	</div>
</div>
<!-- === END CONTENT === -->
<%@ include file="userfooter.jsp"%>