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
						<s:form class="signup-page" modelAttribute="promotionData"
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
										<s:select class="form-control margin-bottom-20" path="percent">
											<option>10%</option>
											<option>20%</option>
											<option>30%</option>
											<option>50%</option>
										</s:select>
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
										<s:input placeholder="mm/dd/yyyy" id="datepicker5"
											class="form-control margin-bottom-20" path="fromDate" />
									</div>
								</div>
								<div class="col-sm-6">
									<label>Ngày kết thúc khuyến mãi</label>
									<div class="input-group margin-bottom-20">
										<span class="input-group-addon"> <i
											class="fa fa-calendar"></i>
										</span>
										<s:input placeholder="mm/dd/yyyy" id="datepicker6"
											class="form-control margin-bottom-20" path="toDate" />
									</div>
								</div>
							</div>
							<hr>
							<div class="row">
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
</div>
<!-- === END CONTENT === -->
<!-- === BEGIN FOOTER === -->
<%@ include file="adminfooter.jsp"%>
<!-- === END FOOTER === -->