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
				<!-- Create Tour Box -->
				<div class="col-md-6 col-md-offset-3 col-sm-offset-3">
					<s:form class="signup-page" commandName="cusData"
						action="${pageContext.request.contextPath }/booktourdetail/${cusData.idBT}"
						method="POST">
						<div class="signup-header">
							<h2>Thông Tin Khách Hàng Đặt Vé</h2>
							</br>
						</div>
						<label>Id customer</label>
						<div class="input-group margin-bottom-20">
							<span class="input-group-addon"> <i
								class="fa fa-key"></i>
							</span>
							<s:input class="form-control margin-bottom-20" type="text"
								path="idBT" disabled="true" />
						</div>
						<label>Họ tên</label>
						<div class="input-group margin-bottom-20">
							<span class="input-group-addon"> <i class="fa fa-font"></i>
							</span>
							<s:input class="form-control" path="cusName" disabled="true" />
						</div>
						<div class="row">
							<div class="col-sm-8">
								<label>Số điện thoại</label>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"> <i class="fa fa-tablet"></i>
									</span>
									<s:input class="form-control" path="cusPhone" disabled="true" />
								</div>
							</div>
							<div class="col-sm-4">
								<label>Giới tính</label>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"> <i class="fa fa-male"></i>
									</span>
									<s:input class="form-control" path="cusSex" disabled="true" />
								</div>
							</div>
						</div>
						<label>Email</label>
						<div class="input-group margin-bottom-20">
							<span class="input-group-addon"> <i class="fa fa-envelope"></i>
							</span>
							<s:input class="form-control" path="cusEmail" disabled="true" />
						</div>
						<label>Địa chỉ</label>
						<div class="input-group margin-bottom-20">
							<span class="input-group-addon"> <i class="fa fa-home"></i>
							</span>
							<s:input class="form-control" path="cusAddress" disabled="true" />
						</div>
						<hr>
						<div class="row">
							<div class="col-lg-6 text-center">
								<a href="<c:url value='/editbooktour/${cusData.idBT}'/>"><button
										class="btn btn-primary" type="button">Chỉnh Sửa</button></a>
							</div>
							<div class="col-lg-6 text-center">
								<a href="<c:url value='/deletebooktour/${cusData.idBT}'/>"><button
										class="btn btn-primary" type="button">Xóa</button></a>
							</div>
						</div>
					</s:form>
				</div>
				<!-- End Create Tour Box -->
			</div>
		</div>
	</div>
	<!-- === END CONTENT === -->
	<%@ include file="adminfooter.jsp"%>