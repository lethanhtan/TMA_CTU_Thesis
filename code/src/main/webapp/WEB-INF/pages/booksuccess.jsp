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
								<td style="text-align: left;">Tên tour:</td>
								<td style="text-align: left;">${tourData.name}</td>
								<c:if test="${tourData.fieldName == true}">
									<td style="text-align: left;">Họ tên:</td>
									<td style="text-align: left;">${cusData.cusName}</td>
								</c:if>
							</tr>
							<tr>
								<td style="text-align: left;">Ngày đi:</td>
								<td style="text-align: left;">${tourData.departureDate}</td>
								<c:if test="${tourData.fieldSex == true}">
									<td style="text-align: left;">Giới tính:</td>
									<td style="text-align: left;">${cusData.cusSex}</td>
								</c:if>
							</tr>
							<tr>
								<td style="text-align: left;">Giờ đi:</td>
								<td style="text-align: left;">${tourData.departureTime}</td>
								<c:if test="${tourData.fieldPhone == true}">
									<td style="text-align: left;">Số điện thoại:</td>
									<td style="text-align: left;">${cusData.cusPhone}</td>
								</c:if>
							</tr>
							<tr>
								<td style="text-align: left;">Ngày về:</td>
								<td style="text-align: left;">${tourData.returnDate}</td>
								<c:if test="${tourData.fieldEmail == true}">
									<td style="text-align: left;">Email:</td>
									<td style="text-align: left;">${cusData.cusEmail}</td>
								</c:if>
							</tr>
							<tr>
								<td style="text-align: left;">Giờ về:</td>
								<td style="text-align: left;">${tourData.returnTime}</td>
								<c:if test="${tourData.fieldAddress == true}">
									<td style="text-align: left;">Địa chỉ:</td>
									<td style="text-align: left;">${cusData.cusAddress}</td>
								</c:if>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<c:if test="${tourData.fieldNumOfTicket == true}">
									<td style="text-align: left;">Số lượng:</td>
									<td style="text-align: left;">${cusData.cusNumOfTicket}</td>
								</c:if>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td style="text-align: left;">Tổng tiền:</td>
								<td style="text-align: left;">${price}<c:out value=" đ" /></td>
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