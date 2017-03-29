<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Xác nhận hủy đặt vé</title>
</head>
<body>
	<h3 style="color: red" align="center">Bạn vui lòng xác nhận mã để thực hiện hủy đăng ký!</h3>
	<h6 style="color: blue" align="center">Một email đã được gửi đến hộp thư của bạn!</h6>
	<s:form>
	<small style="color:red">${failed}</small>
	<center><input name = "confirmCode"></center>
	<br />
	<center><button type="submit">Xác nhân</button></center>
	</s:form>
	<h4 align="center"><a href="/TravelSystem">Nhấn vào đây để trở về.</a></h4>
</body>
</html>