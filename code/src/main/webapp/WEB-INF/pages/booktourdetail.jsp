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
							<td>${tourData.name}</td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td>Ngày đi:</td>
							<td>${tourData.departureDate}</td>
							<td>Giờ đi:</td>
							<td>${tourData.departureTime}</td>
						</tr>
						<tr>
							<td>Ngày về:</td>
							<td>${tourData.returnDate}</td>
							<td>Giờ về:</td>
							<td>${tourData.returnTime}</td>
						</tr>
					</tbody>
				</table>
				</br>
				<table>
					<thead>
						<tr>
							<td>Thông tin đặt vé</td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${bookTourList}" var="bookTour">
							<tr>
								<td style="color: #ef5b92;">Thông tin người thứ <c:out
										value="${bookTourList.indexOf(bookTour) + 1}" /></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<c:if test="${tourData.fieldName == true}">
									<td>Họ tên:</td>
									<td>${bookTour.cusName}</td>
								</c:if>
								<c:if test="${tourData.fieldSex == true}">
									<td>Giới tính:</td>
									<td>${bookTour.cusSex}</td>
								</c:if>
							</tr>
							<tr>
								<c:if test="${tourData.fieldYearOfBirth == true}">
									<td>Năm sinh:</td>
									<td>${bookTour.cusYearOfBirth}</td>
								</c:if>
								<c:if test="${tourData.fieldPhone == true}">
									<td>Số điện thoại:</td>
									<td>${bookTour.cusPhone}</td>
								</c:if>
							</tr>
							<tr>
								<c:if test="${tourData.fieldIdCard == true}">
									<td>Số chứng minh nhân dân:</td>
									<td>${bookTour.cusIdCard}</td>
								</c:if>
								<c:if test="${tourData.fieldEmail == true}">
									<c:if test="${bookTourList.indexOf(bookTour) == 0}">
										<td>Địa chỉ email:</td>
										<td>${bookTour.cusEmail}</td>
									</c:if>
								</c:if>
								<c:if test="${bookTourList.indexOf(bookTour) != 0}">
									<td></td>
									<td></td>
								</c:if>
							</tr>
							<tr>
								<c:if test="${tourData.fieldEmail == true}">
									<c:if test="${bookTourList.indexOf(bookTour) == 0}">
										<td>Địa chỉ:</td>
										<td>${bookTour.cusAddress}</td>
										<td></td>
										<td></td>
									</c:if>
								</c:if>
							</tr>
							<tr>
								<c:if test="${bookTourList.indexOf(bookTour) + 1 == total}">
									<td></td>
									<td></td>
									<td style="color: #ef5b92;">Số lượng:</td>
									<td style="color: #ef5b92;">${total}</td>
								</c:if>
							</tr>
							<tr>
								<c:if test="${bookTourList.indexOf(bookTour) + 1 == total}">
									<td></td>
									<td></td>
									<td style="color: #ef5b92;">Tổng tiền:</td>
									<td style="color: #ef5b92;">${price}<c:out value=" đ" /></td>
								</c:if>
							</tr>
						</c:forEach>
					</tbody>
				</table>
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