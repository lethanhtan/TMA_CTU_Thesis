<!-- === BEGIN HEADER === -->
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="adminheader.jsp"%>
<!-- === END HEADER === -->
<!-- === BEGIN CONTENT === -->
<div id="content">
	<div class="container background-white">
		<div class="container">
			<div class="row col-sm-12 margin-vert-30">
				<div class="row">
					<!-- Create Tour Box -->
					<s:form class="signup-page" modelAttribute="scheduleData"
						action="${pageContext.request.contextPath}/updateschedule/${idTour}"
						method="POST">
						<div class="signup-header">
							<h2 style="text-align: center;">Quản lý lịch trình</h2>
							<h3 style="text-align: center;">${tour.getName()}</h3>
						</div>
						<div class="signup-header">
							<h4 style="text-align: center;"></h4>
						</div>
						<div class="row col-sm-8 col-sm-offset-2">
							<label>Lịch trình</label> <small><s:errors
									path="detailSchedule" cssStyle="color:red;" /></small>
							<s:textarea placeholder="Nhập chi tiết về lịch trình" id="area2"
								class="form-control margin-bottom-20" type="text" rows="10"
								path="detailSchedule" />
						</div>
						<div class="row col-sm-8 col-sm-offset-2">
							<div class="col-lg-6 text-center">
								<button class="btn btn-primary" type="submit">Xác Nhận</button>
							</div>
							<div class="col-lg-6 text-center">
								<a href="managetour"><button class="btn btn-primary"
										type="button">Hủy Bỏ</button></a>
							</div>
						</div>
					</s:form>
					<!-- End Create Tour Box -->
				</div>
			</div>
		</div>
	</div>
</div>
<!-- === END CONTENT === -->
<!-- === BEGIN FOOTER === -->
<%@ include file="adminfooter.jsp"%>
<!-- === END FOOTER === -->