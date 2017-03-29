<!-- === BEGIN HEADER === -->
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- === END HEADER === -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div id="group">
		<div id="3" class="group">
			<c:forEach var="i" begin="1" end="${numOfInfo - 1}">
				<div class="row">
					<div class="col-sm-8">
						<label>Họ tên người thứ <c:out value="${i}" /></label>
						<!-- Show error -->
						</br> <small><s:errors path="cusName" cssStyle="color:red;" /></small>
						<div class="input-group margin-bottom-20">
							<span class="input-group-addon"> <i class="fa fa-font"></i>
							</span>
							<s:input placeholder="Nhập họ tên" class="form-control"
								type="text" path="cusName${i}" />
						</div>
					</div>
					<div class="col-sm-4">
						<label>Giới tính</label>
						<div class="input-group margin-bottom-20">
							<span class="input-group-addon"> <i class="fa fa-male"></i>
							</span> <select class="form-control margin-bottom-20">
								<option>Nam</option>
								<option>Nữ</option>
							</select>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-6">
						<label>Năm sinh</label>
						<!-- Show error -->
						</br> <small><s:errors path="cusName" cssStyle="color:red;" /></small>
						<div class="input-group margin-bottom-20">
							<span class="input-group-addon"> <i class="fa fa-font"></i>
							</span> <input placeholder="Nhập năm sinh" class="form-control"
								type="text">
						</div>
					</div>
					<div class="col-sm-6">
						<label>Mối quan hệ</label>
						<div class="input-group margin-bottom-20">
							<span class="input-group-addon"> <i class="fa fa-male"></i>
							</span> <select class="form-control margin-bottom-20">
								<option>Cha</option>
								<option>Mẹ</option>
								<option>Chồng</option>
								<option>Vợ</option>
								<option>Con</option>
								<option>Khác</option>
							</select>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>