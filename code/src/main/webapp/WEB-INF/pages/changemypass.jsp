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
				<!-- Edit User Box -->
				<div class="col-md-6 col-md-offset-3 col-sm-offset-3">
					<s:form class="login-page" commandName="userData"
						action="${pageContext.request.contextPath}/changemypass/${userData.idUser}"
						method="POST">
						<div class="login-header margin-bottom-30">
							<h2 style="text-align: center;">Thay Đổi Mật Khẩu</h2>
							</br>
						</div>
						<s:input path="userName" hidden="true" />
						<s:input path="password" hidden="true" />
						<div class="input-group margin-bottom-20">
							<span class="input-group-addon"> <i class="fa fa-user"></i>
							</span> <s:input placeholder="Mật khẩu hiện tại" class="form-control" type="text"
								path="password"/>
						</div>
						<div class="input-group margin-bottom-20">
							<span class="input-group-addon"> <i class="fa fa-lock"></i>
							</span> <input placeholder="Nhập mật khẩu mới" class="form-control"
								type="password" name="password">
						</div>
						<div class="input-group margin-bottom-20">
							<span class="input-group-addon"> <i class="fa fa-lock"></i>
							</span> <input placeholder="Nhập lại mật khẩu mới" class="form-control"
								type="password" name="password">
						</div>
						<hr>
						<div class="row">
							<div class="col-lg-6 text-center">
								<button class="btn btn-primary" type="submit">Xác Nhận</button>
							</div>
							<div class="col-lg-6 text-center">
								<a href="<c:url value='/manageuser'/>"><button
										class="btn btn-primary" type="button">Hủy Bỏ</button></a>
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
<%@ include file="adminfooter.jsp"%>