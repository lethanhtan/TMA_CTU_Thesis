<!-- === BEGIN HEADER === -->
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="userheader.jsp"%>
<!-- === END HEADER === -->
<!-- === BEGIN CONTENT === -->
<div id="content">
	<div class="container background-white">
		<div class="row margin-vert-30">
			<!-- Book Tour Box -->
			<div class="col-md-6 col-md-offset-3 col-sm-offset-3">
				<div class="signup-header">
					<h2 style="text-align: center;">Đặt Vé</h2>
					<img alt="Web Counter" border="0"
						src="http://pumpernickelpixie.com/wp-content/uploads/2015/06/31.gif"
						width="500px" height="250px"
						style="display: block; margin-right: auto; margin-left: auto; text-align: center" />
				</div>
				<s:form class="signup-page" commandName="cusNextData"
					action="${pageContext.request.contextPath}/booktour/next/${idBT}"
					method="POST">
					<c:forEach var="info" items="${cusNextData.info}"
						varStatus="status">
						<label>Thông tin người thứ <c:out
								value="${status.index + 1}: " /></label>
						<div class="row">
							<div class="col-sm-8">
								<label>Họ tên</label>
								<!-- Show error -->
								</br> <small><s:errors path="info[${status.index}].cusName"
										cssStyle="color:red;" /></small>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"> <i class="fa fa-font"></i>
									</span>
									<s:input placeholder="Nhập họ tên" class="form-control"
										type="text" path="info[${status.index}].cusName" />
								</div>
							</div>
							<div class="col-sm-4">
								<label>Giới tính</label>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"> <i class="fa fa-male"></i>
									</span>
									<s:select class="form-control margin-bottom-20"
										path="info[${status.index}].cusSex">
										<option>Nam</option>
										<option>Nữ</option>
									</s:select>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-8">
								<label>Năm sinh</label>
								<!-- Show error -->
								</br> <small><s:errors
										path="info[${status.index}].cusYearOfBirth"
										cssStyle="color:red;" /></small>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"> <i
										class="fa fa-calendar"></i>
									</span>
									<s:input placeholder="Nhập họ tên" class="form-control"
										type="text" path="info[${status.index}].cusYearOfBirth" />
								</div>
							</div>
							<div class="col-sm-4">
								<label>Mối quan hệ</label>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"> <i class="fa fa-users"></i>
									</span>
									<s:select class="form-control margin-bottom-20"
										path="info[${status.index}].relationship">
										<option>Cha</option>
										<option>Mẹ</option>
										<option>Vợ</option>
										<option>Chồng</option>
										<option>Con</option>
										<option>Ông</option>
										<option>Bà</option>
										<option>Anh</option>
										<option>Chị</option>
										<option>Em</option>
										<option>Khác</option>
									</s:select>
								</div>
							</div>
						</div>
						<hr>
						<c:if test="${status.index == bookTour.cusNumOfTicket - 2 }">
							<div class="row">
								<div class="col-lg-6 text-center">
									<button class="btn btn-primary" type="submit">Đăng Ký</button>
								</div>
								<div class="col-lg-6 text-center">
									<a href="${pageContext.request.contextPath}/booktour/${bookTour.idBT}/${bookTour.tour.idTour}"><button
											class="btn btn-primary" type="button">Trở về trước</button></a>
								</div>
							</div>
						</c:if>
					</c:forEach>
				</s:form>
			</div>
			<!-- End Book Tour Box -->
		</div>
	</div>
</div>
<!-- === END CONTENT === -->
<!-- === BEGIN FOOTER === -->
<%@ include file="userfooter.jsp"%>
<!-- === END FOOTER === -->