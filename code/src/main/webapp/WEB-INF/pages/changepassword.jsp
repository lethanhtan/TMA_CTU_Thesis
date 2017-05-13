<!-- === BEGIN HEADER === -->
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${roleId == 2}">
	<%@ include file="adminheader.jsp"%>
</c:if>
<c:if test="${roleId == 1}">
	<%@ include file="userheader.jsp"%>
</c:if>
<!-- === END HEADER === -->
<!-- === BEGIN CONTENT === -->
<div id="content">
	<div class="container background-white">
		<div class="container">
			<div class="row margin-vert-30">
				<!-- Edit User Box -->
				<div class="col-md-6 col-md-offset-3 col-sm-offset-3">
					<s:form class="login-page" commandName="userData"
						action="${pageContext.request.contextPath}/changepassword/${userData.idUser}"
						method="POST">
						<div class="login-header margin-bottom-30">
							<h2 style="text-align: center;">Thay Đổi Mật Khẩu</h2>
							<br>
						</div>
						<script>
							function redirect() {
								window
										.setTimeout(
												function() {
													window.location.href = "${pageContext.request.contextPath}/managetour";
												}, 2000);
							}
						</script>
						<s:input path="userName" hidden="true" />
						<s:input path="fullName" hidden="true" />
						<s:input path="sex" hidden="true" />
						<s:input path="birthday" hidden="true" />
						<s:input path="phone" hidden="true" />
						<s:input path="descRole" hidden="true" />
						<s:input path="email" hidden="true" />
						<s:input path="address" hidden="true" />
						<p style="color: red;">${wrongPass}</p>
						<c:if test="${!empty status}">
									<div class="alert alert-success update">
										<strong>${status}</strong>
									</div>
									<script>
										redirect();
									</script>
								</c:if>
								<c:if test="${!empty statusF}">
									<div class="alert alert-danger">
										<strong>${statusF}</strong>
									</div>
								</c:if>
						<div class="input-group margin-bottom-20">
							<span class="input-group-addon"> <i class="fa fa-lock"></i>
							</span> <input placeholder="Mật khẩu hiện tại" class="form-control"
								type="password" name="currentPass">
						</div>
						<p style="color: red;">${error}</p>
						<p style="color: red;">${confirmPass}</p>
						<div class="input-group margin-bottom-20">
							<span class="input-group-addon"> <i class="fa fa-key"></i>
							</span> <input placeholder="Nhập mật khẩu mới" class="form-control"
								type="password" name="newPass">
						</div>
						<div class="input-group margin-bottom-20">
							<span class="input-group-addon"> <i class="fa fa-undo"></i>
							</span> <input placeholder="Nhập lại mật khẩu mới" class="form-control"
								type="password" name="comPass">
						</div>
						<hr>
						<div class="row">
							<div class="col-lg-6 text-center">
								<button class="btn btn-primary" type="submit">Xác Nhận</button>
							</div>
							<div class="col-lg-6 text-center">
								<button onclick="goBack()" class="btn btn-primary" type="button">Hủy
									Bỏ</button>
							</div>
						</div>
					</s:form>
				</div>
				<!-- End Edit User Box -->
			</div>
		</div>
	</div>
</div>
<!-- === END CONTENT === -->
<%@ include file="userfooter.jsp"%>