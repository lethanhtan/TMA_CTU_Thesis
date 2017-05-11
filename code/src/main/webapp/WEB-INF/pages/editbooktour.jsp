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
				<!-- Edit Book Tour Box -->
				<div class="col-md-6 col-md-offset-3 col-sm-offset-3">
					<s:form class="signup-page" commandName="cusData"
						id="createTourForm"
						action="${pageContext.request.contextPath }/editbooktour/${cusData.idBT}/${tour.idTour}"
						method="POST">
						<div class="signup-header">
							<h2 style="text-align: center;">Cập nhật Thông Tin Đặt Vé</h2>
							<br>
						</div>
						<script>
							function redirect() {
								window
										.setTimeout(
												function() {
													window.location.href = "${pageContext.request.contextPath}/managetour";
												}, 2000);
							}
						</script>
						<s:input path="confirmCode" hidden="true" />
						<div class="row">
							<c:if test="${!empty cusData.cusName}">
								<div class="col-sm-8">
									<c:if test="${!empty status}">
										<div class="alert alert-success">
											<strong>${status}</strong>
										</div>
										<script>
											redirect();
										</script>
									</c:if>
									<label>Họ tên</label>
									<!-- Show error -->
									<br> <small><s:errors path="cusName"
											cssStyle="color:red;" /></small>
									<div class="input-group margin-bottom-20">
										<span class="input-group-addon"><i class="fa fa-font"></i>
										</span>
										<s:input placeholder="Nhập họ tên" class="form-control"
											type="text" path="cusName" />
									</div>
								</div>
							</c:if>
							<c:if test="${!empty cusData.cusSex}">
								<div class="col-sm-4">
									<label>Giới tính</label>
									<div class="input-group margin-bottom-20">
										<span class="input-group-addon"><i class="fa fa-male"></i>
										</span>
										<s:select class="form-control margin-bottom-20" path="cusSex">
											<option>${cusData.cusSex}</option>
											<option>Nam</option>
											<option>Nữ</option>
										</s:select>
									</div>
								</div>
							</c:if>
						</div>
						<div class="row">
							<c:if test="${!empty cusData.cusYearOfBirth}">
								<div class="col-sm-6">
									<label>Năm sinh</label>
									<!-- Show error -->
									<br> <small><s:errors path="cusYearOfBirth"
											cssStyle="color:red;" /></small>
									<div class="input-group margin-bottom-20">
										<span class="input-group-addon"><i
											class="fa fa-envelope"></i> </span>
										<s:input placeholder="Nhập năm sinh" class="form-control"
											type="text" path="cusYearOfBirth" />
									</div>
								</div>
							</c:if>
							<c:if test="${!empty cusData.relation}">
								<div class="col-sm-6">
									<label>Mối quan hệ</label>
									<div class="input-group margin-bottom-20">
										<span class="input-group-addon"><i
											class="fa fa-envelope"></i> </span>
										<s:select class="form-control margin-bottom-20"
											path="relation">
											<c:forEach items="${relationshipList}" var="relationship">
												<option>${relationship.name}</option>
											</c:forEach>
										</s:select>
									</div>
								</div>
						</div>
						<c:if test="${!empty cusData.cusPhone}">
							<label>Số điện thoại</label>
							<!-- Show error -->
							<br>
							<small><s:errors path="cusPhone" cssStyle="color:red;" /></small>
							<div class="input-group margin-bottom-20">
								<span class="input-group-addon"><i class="fa fa-envelope"></i>
								</span>
								<s:input placeholder="Nhập số điện thoại" class="form-control"
									type="text" path="cusPhone" />
							</div>
						</c:if>
						</c:if>
						<c:if test="${empty cusData.relation}">
							<c:if test="${!empty cusData.cusPhone}">
								<div class="col-sm-6">
									<label>Số điện thoại</label>
									<!-- Show error -->
									<br> <small><s:errors path="cusPhone"
											cssStyle="color:red;" /></small>
									<div class="input-group margin-bottom-20">
										<span class="input-group-addon"><i
											class="fa fa-envelope"></i> </span>
										<s:input placeholder="Nhập số điện thoại" class="form-control"
											type="text" path="cusPhone" />
									</div>
								</div>
				</div>
				</c:if>
				</c:if>
				<c:if test="${!empty cusData.cusIdCard}">
					<label>Số chứng minh nhân dân</label>
					<div class="input-group margin-bottom-20">
						<span class="input-group-addon"><i
							class="fa fa-credit-card"></i> </span>
						<s:input placeholder="Nhập chứng minh nhân dân"
							class="form-control" type="text" path="cusIdCard" />
					</div>
				</c:if>
				<c:if test="${!empty cusData.cusEmail}">
					<label>Email</label>
					<!-- Show error -->
					<br>
					<small><s:errors path="cusEmail" cssStyle="color:red;" /></small>
					<div class="input-group margin-bottom-20">
						<span class="input-group-addon"><i class="fa fa-envelope"></i>
						</span>
						<s:input placeholder="Nhập email" class="form-control" type="text"
							path="cusEmail" />
					</div>
				</c:if>
				<c:if test="${!empty cusData.cusAddress}">
					<label>Địa chỉ</label>
					<div class="input-group margin-bottom-20">
						<span class="input-group-addon"> <i class="fa fa-home"></i>
						</span>
						<s:input placeholder="Nhập địa chỉ" class="form-control"
							type="text" path="cusAddress" />
					</div>
				</c:if>
				<s:input path="idUser" hidden="true" />
				<s:input path="relationship" hidden="true" />
				<s:input path="whoIsRegistered" hidden="true" />
				<hr>
				<!-- reCAPTCHA -->
				<p style="color: red;">${errorString}</p>
				<div style="margin-left: 37px;" class="g-recaptcha"
					data-sitekey="6Le28hQUAAAAAFKa2w76sfgp5ULrd4iIYJLwtxOd"></div>
				<br>
				<!-- End reCAPTCHA -->
				<div class="row">
					<div class="col-lg-6 text-center">
						<button class="btn btn-primary" type="submit">Xác Nhận</button>
					</div>
					<div class="col-lg-6 text-center">
						<button onclick="goBack()" class="btn btn-primary" type="button">Hủy
							Bỏ</button>
					</div>
				</div>
				</s:form>
			</div>
			<!-- End Edit Book Tour Box -->
		</div>
	</div>
</div>
</div>
<!-- === END CONTENT === -->
<!-- === BEGIN FOOTER === -->
<%@ include file="userfooter.jsp"%>
<!-- === END FOOTER === -->