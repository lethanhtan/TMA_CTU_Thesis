<!-- === BEGIN HEADER === -->
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="userheader.jsp"%>
<!-- === END HEADER === -->
<!-- === BEGIN CONTENT === -->
<div id="content">
	<div class="container background-white">
		<div class="row margin-vert-30">
			<div class="col-md-12">
				<div class="error-404-page text-center">
					<img
						src="${pageContext.request.contextPath}/resources/img/FAQ_illusts35.png">
					<br> <br><br>
					<h3 style="color: #ef5b92;">
						Quý khách đã thay đổi mật khẩu thành công <br><br> Xin vui lòng <a
							href="${pageContext.request.contextPath}/login"> đăng nhập</a>
						lại!
					</h3>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- === END CONTENT === -->
<%@ include file="userfooter.jsp"%>