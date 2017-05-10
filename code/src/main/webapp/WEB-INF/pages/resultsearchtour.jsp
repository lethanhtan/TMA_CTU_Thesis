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
		<div class="row margin-vert-30">
			<div class="col-md-12">
				<div class="error-404-page text-center">
					<img
						src="${pageContext.request.contextPath}/resources/img/illust-404.png">
					<br>
					<br>
					<h3>${notFound}</h3>
					<h3>Bạn hãy thử nhập lại với từ khóa khác</h3>
					<form class="form-search search-404">
						<div class="input-append">
							<input type="text" class="span2 search-query"
								placeholder="Nhập từ khóa" name="valueSearch">
							<button type="submit" class="btn btn-primary">Tìm Kiếm</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- === END CONTENT === -->
<%@ include file="userfooter.jsp"%>