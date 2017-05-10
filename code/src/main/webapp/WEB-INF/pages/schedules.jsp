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
				<div class="row col-sm-12 col-md-12">
					<div>
						<!-- Create Tour Box -->
						<s:form class="signup-page" modelAttribute="scheduleData"
							action="${pageContext.request.contextPath}/update_schedule/${idTour}"
							method="POST">
							<a href="${pageContext.request.contextPath}/managetour"><button
							class="btn btn-primary fa fa-arrow-left" id="back">Trở về</button></a>
							<div class="signup-header">
								<h2 style="text-align: center;">Quản lý lịch trình</h2>
								<h3 style="text-align: center;">${tour.getName()}</h3>
							</div>
							<div class="signup-header">
								<h4 style="text-align: center;"></h4>
							</div>
							<div class="row">
								<div class="col-md-8 col-sm-8 col-xs-8 col-sm-offset-2 col-md-offset-2 col-xs-offset-2">
									<c:if test="${!empty status}">
										<div class="alert alert-success">
											<strong>${status}</strong>
										</div>
									</c:if>
									<c:if test="${!empty statusF}">
										<div class="alert alert-danger">
											<strong>${statusF}</strong>
										</div>
									</c:if>
								</div>
							</div>
							<div class="row margin-bottom-30">
								<div
									class="col-xs-8 col-sm-8 col-md-8 col-sm-offset-2 col-md-offset-2 col-xs-offset-2">
									<label>Tóm tắt lịch trình</label> <small><s:errors
											path="sumary" cssStyle="color:red;" /></small>
									<s:textarea placeholder="Nhập tóm tắt lịch trình" id="area2"
										class="form-control margin-bottom-20" type="text" rows="10"
										path="sumary" />
								</div>
							</div>
							<div class="row margin-bottom-30">
								<div
									class="col-xs-8 col-sm-8 col-md-8 col-sm-offset-2 col-md-offset-2 col-xs-offset-2">
									<label>Chi tiết lịch trình</label> <small><s:errors
											path="detailSchedule" cssStyle="color:red;" /></small>
									<s:textarea placeholder="Nhập chi tiết về lịch trình"
										id="area2" class="form-control margin-bottom-20" type="text"
										rows="10" path="detailSchedule" />
								</div>
							</div>
							<div class="row margin-bottom-30">
								<div
									class="col-xs-8 col-sm-8 col-md-8 col-sm-offset-2 col-md-offset-2 col-xs-offset-2">
									<div class="col-lg-6 text-center">
										<button class="btn btn-primary update" type="submit">Xác
											Nhận</button>
									</div>
									<div class="col-lg-6 text-center">
										<a href="${pageContext.request.contextPath}/managetour"><button
												class="btn btn-primary">Hủy Bỏ</button></a>
									</div>
								</div>
							</div>
						</s:form>
						<!-- End Create Tour Box -->
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- === END CONTENT === -->
<!-- === BEGIN FOOTER === -->
<%@ include file="adminfooter.jsp"%>
<!-- === END FOOTER === -->