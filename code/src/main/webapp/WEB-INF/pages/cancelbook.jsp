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
				<title>Xác nhận hủy đặt vé</title>
				<h2 style="color: blue" align="center">Một email đã được gửi
					đến hộp thư của bạn</h2>
				</br>
				<h2 style="color: red" align="center">Quý khách vui lòng nhập
					mã xác nhận để thực hiện hủy đăng ký</h2>
				</br>
				<div class="col-md-6 col-md-offset-3 col-sm-offset-3">
					<s:form class="signup-page">
						<small style="color: red">${failed}</small>
						<center>
							<div class="input-group margin-bottom-20">
								<span class="input-group-addon"> <i
									class="fa fa-envelope"></i>
								</span><input class="form-control margin-bottom-20" name="confirmCode">
							</div>
						</center>
						<div class="row">
							<center>
								<button class="btn btn-primary" type="submit">Xác nhận</button>
							</center>
						</div>
					</s:form>
					</br><h2 align="center">
						<a href="/TravelSystem">Nhấn vào đây để trở về</a>
					</h2>
				</div>
				</br>
			</div>
		</div>
	</div>
</div>
<!-- === END CONTENT === -->
<%@ include file="userfooter.jsp"%>