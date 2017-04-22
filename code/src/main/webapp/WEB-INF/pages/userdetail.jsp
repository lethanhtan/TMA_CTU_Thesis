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
					<!-- Table -->
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
								<td>Phân quyền:</td>
								<td>${userData.descRole}</td>
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
				<br> <a
					href="<c:url value='manageuser/deleteuser/${user.idUser}'/>">
					<button type="button" id="button${user.idUser}" hidden="true"></button>
				</a>
				<div class="row">
					<div class="col-lg-4 text-center">
						<a href="<c:url value='/edituser/${userData.idUser}'/>"><button
								class="btn btn-primary" type="button">Chỉnh Sửa</button></a>
					</div>
					<div class="col-lg-4 text-center">
						<button class="btn btn-primary delete" id="${user.idUser}">Xóa</button>
					</div>
					<div class="col-lg-4 text-center">
						<a href="<c:url value='/manageuser'/>"><button
								class="btn btn-primary" type="button">Trở Về</button></a>
					</div>
				</div>
			</div>
			<!-- End Table -->
			<!-- User Detail Box -->
			<!-- End User Detail Box -->
		</div>
	</div>
</div>
<!-- === END CONTENT === -->
<%@ include file="adminfooter.jsp"%>