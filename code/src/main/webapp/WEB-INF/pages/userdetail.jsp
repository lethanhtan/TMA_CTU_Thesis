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
				<!-- User Detail Box -->
				<div class="col-md-6 col-md-offset-3 col-sm-offset-3">
					<s:form class="signup-page" commandName="userData"
						action="${pageContext.request.contextPath}/userdetail/${userData.idUser}"
						method="POST">
						<div class="signup-header">
							<h2 style="text-align: center;">Thông Tin Tài Khoản</h2>
							<br>
						</div>
						<div class="row">
							<div class="col-sm-8">
								<label>Họ tên</label>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"> <i class="fa fa-font"></i>
									</span>
									<s:input class="form-control margin-bottom-20" path="fullName"
										disabled="true" />
								</div>
							</div>
							<div class="col-sm-4">
								<label>Giới tính</label>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"><i class="fa fa-male"></i>
									</span>
									<s:input class="form-control margin-bottom-20" path="sex"
										disabled="true" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6">
								<label>Ngày sinh</label>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"><i
										class="fa fa-calendar"></i> </span>
									<s:input class="form-control margin-bottom-20" path="birthday"
										disabled="true" />
								</div>
							</div>
							<div class="col-sm-6">
								<label>Số điện thoại</label>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"><i class="fa fa-tablet"></i>
									</span>
									<s:input class="form-control margin-bottom-20" path="phone"
										disabled="true" />
								</div>
							</div>
						</div>
						<label>Phân quyền</label>
						<div class="input-group margin-bottom-20">
							<span class="input-group-addon"><i class="fa fa-minus-circle"></i>
							</span>
							<s:input class="form-control margin-bottom-20" path="descRole" disabled="true"/>
						</div>
						<label>Email</label>
						<div class="input-group margin-bottom-20">
							<span class="input-group-addon"><i class="fa fa-envelope"></i>
							</span>
							<s:input class="form-control margin-bottom-20" path="email"
								disabled="true" />
						</div>
						<label>Địa chỉ</label>
						<div class="input-group margin-bottom-20">
							<span class="input-group-addon"> <i class="fa fa-home"></i>
							</span>
							<s:input class="form-control margin-bottom-20" path="address"
								disabled="true" />
						</div>
						<hr>
						<div class="row">
							<div class="col-lg-4 text-left">
								<a href="<c:url value='/edituser/${userData.idUser}'/>"><button
										class="btn btn-primary" type="button">Chỉnh Sửa</button></a>
							</div>
							<div class="col-lg-4 text-center">
								<a href="<c:url value='deleteuser/${userData.idUser}'/>"><button
										class="btn btn-primary" type="button">Xóa</button></a>
							</div>
							<div class="col-lg-4 text-right">
								<a href="<c:url value='/manageuser'/>"><button
										class="btn btn-primary" type="button">Trở Về</button></a>
							</div>
						</div>
					</s:form>
				</div>
				<!-- End User Detail Box -->
			</div>
		</div>
	</div>
</div>
<!-- === END CONTENT === -->
<%@ include file="adminfooter.jsp"%>