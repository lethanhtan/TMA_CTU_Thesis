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
				<!-- Search Form -->
				<div class="error-404-page text-center" style="margin-left: 625px;">
					<form class="form-search search-404">
						<div class="input-append">
							<input type="text" class="span2 search-query"
								placeholder="Nhập email hoặc số điện thoại" name="valueSearch">
							<button type="submit" class="btn btn-primary">Tìm Kiếm</button>
						</div>
					</form>
				</div>
				<!-- End Search Form -->
				<!-- View Tour Box -->
				<div class="col-md-6 col-md-offset-3 col-sm-offset-3">
					<s:form class="signup-page" commandName="tourData"
						action="${pageContext.request.contextPath }/detail/${tourData.idTour}"
						method="POST">
						<div class="signup-header">
							<h2 style="text-align: center;">Thông Tin Tour Du Lịch</h2>
							</br>
						</div>
						<label>Tên tour</label>
						<div class="input-group margin-bottom-20">
							<span class="input-group-addon"> <i class="fa fa-font"></i>
							</span>
							<s:input class="form-control margin-bottom-20" path="name"
								disabled="true" />
						</div>
						<div class="row">
							<div class="col-sm-6">
								<label>Ngày đi</label>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"> <i
										class="fa fa-calendar"></i>
									</span>
									<s:input class="form-control margin-bottom-20"
										path="departureDate" disabled="true" />
								</div>
							</div>
							<div class="col-sm-6">
								<label>Giờ đi</label>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"> <i
										class="fa fa-clock-o"></i>
									</span>
									<s:input class="form-control margin-bottom-20"
										path="departureTime" disabled="true" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6">
								<label>Ngày về</label>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"> <i
										class="fa fa-calendar"></i>
									</span>
									<s:input class="form-control margin-bottom-20"
										path="returnDate" disabled="true" />
								</div>
							</div>
							<div class="col-sm-6">
								<label>Giờ về</label>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"> <i
										class="fa fa-clock-o"></i>
									</span>
									<s:input class="form-control margin-bottom-20"
										path="returnTime" disabled="true" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6">
								<label>Giá vé</label>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"> <i class="fa fa-money"></i>
									</span>
									<s:input class="form-control margin-bottom-20" path="price"
										disabled="true" />
								</div>
							</div>
							<div class="col-sm-6">
								<label>Số lượng</label>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"> <i
										class="fa fa-building-o"></i>
									</span>
									<s:input class="form-control margin-bottom-20"
										path="ticketAvailability" disabled="true" />
								</div>
							</div>
						</div>
						<label>Chi tiết tour</label>
						<s:input class="form-control margin-bottom-20" path="detail"
							disabled="true" />
						<hr>
						<div class="row">
							<div class="col-lg-6 text-center">
								<a href="${pageContext.request.contextPath }/tourlist"><button
										class="btn btn-primary" type="button">Trở Về</button></a>
							</div>
							<div class="col-lg-6 text-center">
								<a href="<c:url value='/booktour/${tourData.idTour}'/>"><button
										class="btn btn-primary" type="button">Đăng Ký</button></a>
							</div>
						</div>
					</s:form>
				</div>
				<!-- End View Tour Box -->
			</div>
		</div>
	</div>
</div>
<!-- === END CONTENT === -->
<%@ include file="adminfooter.jsp"%>