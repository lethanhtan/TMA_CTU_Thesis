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
					<!-- User Detail Box -->
					<table>
						<thead>
							<tr>
								<td>Thông Tin Tài Khoản</td>
								<td></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>Họ tên:</td>
								<td>${userData.fullName}</td>
							</tr>
							<tr>
								<td>Giới tính:</td>
								<td>${userData.sex}</td>
							</tr>
							<tr>
								<td>Ngày sinh:</td>
								<td><fmt:formatDate value="${userData.birthday}"
										pattern="dd/MM/yyyy" /></td>
							</tr>
							<tr>
								<td>Số điện thoại:</td>
								<td>${userData.phone}</td>
							</tr>
							<tr>
								<td>Địa chỉ email:</td>
								<td>${userData.email}</td>
							</tr>
							<tr>
								<td>Địa chỉ:</td>
								<td>${userData.address}</td>
							</tr>
							<tr>
								<td></td>
								<td></td>
							</tr>
						</tbody>
					</table>
				</form>
				<br>
				<div class="row">
					<div class="col-lg-4 text-center">
						<a href="<c:url value='/editmyacc/${userData.idUser}'/>"><button
								class="btn btn-primary" type="button">Chỉnh Sửa</button></a>
					</div>
					<div class="col-lg-4 text-center">
						<a href="<c:url value='/changepassword/${userData.idUser}'/>"><button
								class="btn btn-primary" type="button">Đổi Mật Khẩu</button></a>
					</div>
					<div class="col-lg-4 text-center">
						<a href="<c:url value='/home'/>"><button
								class="btn btn-primary" type="button">Trở Về</button></a>
					</div>
				</div>
			</div>
			<!-- End User Detail Box -->
		</div>
	</div>
</div>
<!-- === END CONTENT === -->
<%@ include file="userfooter.jsp"%>