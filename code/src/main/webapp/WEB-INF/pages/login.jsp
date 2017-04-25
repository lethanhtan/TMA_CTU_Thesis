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
				<!-- Login Box -->
				<div class="col-md-6 col-md-offset-3 col-sm-offset-3">
				<h3 style="color: #ef5b92; text-align: center;">${success}</h3><br>
					<s:form class="login-page" commandName="userData"
						action="${pageContext.request.contextPath }/login" method="POST">
						<div class="login-header margin-bottom-30">
							<h2>Đăng Nhập</h2>
							<p>
								Chưa có tài khoản? <a
									href="${pageContext.request.contextPath }/register"
									style="color: #ef5b92">Đăng ký</a>
							</p>
						</div>
						<small><font color="red">${failed}</font></small>
						<div class="input-group margin-bottom-20">
							<span class="input-group-addon"> <i class="fa fa-user"></i>
							</span> <input placeholder="Tài khoản" class="form-control" type="text"
								name="userName">
						</div>
						<div class="input-group margin-bottom-20">
							<span class="input-group-addon"> <i class="fa fa-lock"></i>
							</span> <input placeholder="Mật khẩu" class="form-control"
								type="password" name="password">
						</div>
						<div class="row">
							<div class="col-md-6">
								<label class="checkbox"> <input type="checkbox">Ghi
									nhớ
								</label>
							</div>
							<div class="col-md-6">
								<button class="btn btn-primary pull-right" type="submit">Đăng
									Nhập</button>
							</div>
						</div>
						<hr>
						<h4>Quên mật khẩu?</h4>
						<p>
							<a href="#" style="color: #ef5b92">Nhấn vào đây </a>để khôi phục
						</p>
					</s:form>
				</div>
				<!-- End Login Box -->
			</div>
		</div>
	</div>
</div>
<!-- === END CONTENT === -->
<!-- === BEGIN FOOTER === -->
<%@ include file="userfooter.jsp"%>
<!-- === END FOOTER === -->