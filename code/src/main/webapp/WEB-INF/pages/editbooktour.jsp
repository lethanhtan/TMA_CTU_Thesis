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
						id="createTourForm"
						action="${pageContext.request.contextPath }/editbooktour/${cusData.idBT}"
						method="POST">
						<div class="signup-header">
							<h2>Cập nhật Thông Tin Khách Hàng Đặt Vé</h2>
							</br>
						</div>
						<label>Id customer</label>
						<div class="input-group margin-bottom-20">
							<span class="input-group-addon"> <i class="fa fa-key"></i>
							</span>
							<s:input placeholder="${cusData.idBT}"
								class="form-control margin-bottom-20" type="text" path="idBT"
								disabled="true" />
						</div>
						<label>Họ tên</label>
						<div class="input-group margin-bottom-20">
							<span class="input-group-addon"> <i class="fa fa-font"></i>
							</span>
							<s:input placeholder="Nhập họ tên" class="form-control"
								type="text" path="cusName" />
						</div>
						<div class="row">
							<div class="col-sm-8">
								<label>Số điện thoại</label>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"> <i class="fa fa-tablet"></i>
									</span>
									<s:input placeholder="Nhập số điện thoại" class="form-control"
										type="text" path="cusPhone" />
								</div>
							</div>
							<div class="col-sm-4">
								<label>Giới tính</label>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"> <i class="fa fa-male"></i>
									</span>
									<s:select class="form-control margin-bottom-20" path="cusSex">
										<option>Nam</option>
										<option>Nữ</option>
									</s:select>
								</div>
							</div>
						</div>
						<label>Email</label>
						<div class="input-group margin-bottom-20">
							<span class="input-group-addon"> <i class="fa fa-envelope"></i>
							</span>
							<s:input placeholder="Nhập email" class="form-control"
								type="text" path="cusEmail" />
						</div>
						<label>Địa chỉ</label>
						<div class="input-group margin-bottom-20">
							<span class="input-group-addon"> <i class="fa fa-home"></i>
							</span>
							<s:input placeholder="Nhập địa chỉ" class="form-control"
								type="text" path="cusAddress" />
						</div>
						<hr>
						<div class="row">
							<div class="col-lg-6 text-center">
								<button class="btn btn-primary" type="submit">Xác Nhận</button>
							</div>
							<div class="col-lg-6 text-center">
								<button class="btn btn-primary" type="button" onclick="goBack()">Hủy
									Bỏ</button>
							</div>
						</div>
					</s:form>
				</div>
				<!-- End Create Tour Box -->
			</div>
		</div>
	</div>
	<!-- === END CONTENT === -->
	<!-- === BEGIN FOOTER === -->
	<%@ include file="adminfooter.jsp"%>
	<!-- === END FOOTER === -->