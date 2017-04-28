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
				<div class="row col-md-12 col-sm-12 col-xs-12 col-lg-12">
					<!-- Update Promotion Box -->
					<div class="row col-sm-8 col-sm-offset-2">
						<form class="signup-page"
							action="${pageContext.request.contextPath}/update_promotion/${idTour}"
							method="POST">
							<div class="signup-header margin-bottom-30">
								<h2 style="text-align: center;">Quản lý thông tin khuyến
									mãi</h2>
								<h3 style="text-align: center;">${tour.getName()}</h3>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-6">
									<label>Mức giảm giá</label> <br />
									<div class="input-group margin-bottom-20">
										<span class="input-group-addon"> <i class="fa fa-money"></i>
										</span>
										<select class="form-control margin-bottom-20" name="percent">
										<option value=0>Không giảm giá</option>
											<option value=10>10%</option>
											<option value=20>20%</option>
											<option value=30>30%</option>
											<option value=40>40%</option>
											<option value=50>50%</option>
										</select>
									</div>
								</div>
							</div>
							<div class="row col-sm-offset-0 margin-bottom-30">
								<div class="col-sm-6">
									<label>Ngày bắt đầu khuyến mãi</label>
									<div class="input-group margin-bottom-20">
										<span class="input-group-addon"> <i
											class="fa fa-calendar"></i>
										</span>
										<input value='<fmt:formatDate value="${fromDate}" pattern="MM/dd/yyyy"/>'id="datepicker5" type="date"
											class="form-control margin-bottom-20" name="fromDate"/>
									</div>
								</div>
								<div class="col-sm-6">
									<label>Ngày kết thúc khuyến mãi</label>
									<div class="input-group margin-bottom-20">
										<span class="input-group-addon"> <i
											class="fa fa-calendar"></i>
										</span>
										<input value='<fmt:formatDate value="${toDate}" pattern="MM/dd/yyyy"/>'  id="datepicker6" type="date"
											class="form-control margin-bottom-20" name="toDate"/>
									</div>
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-lg-6 text-center">
									<button class="btn btn-primary" type="submit">Xác Nhận</button>
								</div>
								<div class="col-lg-6 text-center">
									<a href="${pageContext.request.contextPath}/managetour"><button class="btn btn-primary"
											type="button">Hủy Bỏ</button></a>
								</div>
							</div>
						</form>
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