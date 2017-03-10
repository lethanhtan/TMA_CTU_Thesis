<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="adminheader.jsp"%>
<!-- === BEGIN CONTENT === -->
<div class="container background-white">
	<div class="container">
		<div class="row margin-vert-30">
		<div class="col-md-12">
				<a href="createtour"><button
						class="btn btn-primary fa-plus-square">Tạo Mới</button></a>
				<a href="createtour"><button
						class="btn btn-primary fa-plus-square">Export</button></a>
				<div class="row margin-bottom-30">
					<div class="col-md-4 animate fadeInRight"></div>
					<div class="col-md-8 animate fadeIn"></div>
					<div class="col-md-12 animate fadeInRight"></div>
				</div>

				<hr class="margin-bottom-50">
				<form class="signup-page" >
						<div class="signup-header">
							<h2>Thông Tin Tour Du Lịch</h2>
						</div>
						<div class="row">
							<div class="col-sm-8">
								<label>Tên Export</label>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"> <i
										class="fa fa-map-marker"></i>
									</span>
									<input placeholder="Nhập tên file export"
										class="form-control margin-bottom-20" type="text" />
				 				</div>
							</div>
							<div class="col-lg-4 text-right">
								<button class="btn btn-primary" type="button">Chọn file
									Lên</button>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-4 text-left">
								<button class="btn btn-primary" type="submit">Xác Nhận</button>
							</div>
							<div class="col-lg-4 text-center">
								<a href="managetour"><button class="btn btn-primary"
										type="button">Hủy Bỏ</button></a>
							</div>
							<div class="col-lg-4 text-right">
								<input class="btn btn-primary" type="reset" value="Nhập Lại">
							</div>
						</div>
					</form>
				<hr class="margin-bottom-50">
		</div>
		</div>
	</div>
</div>
<!-- === END CONTENT === -->
<%@ include file="adminfooter.jsp"%>