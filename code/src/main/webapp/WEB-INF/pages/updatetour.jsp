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
				<!-- Create Tour Box -->
				<div class="col-md-6 col-md-offset-3 col-sm-offset-3">
					<s:form class="signup-page" modelAttribute="tourData"
						action="${pageContext.request.contextPath }/updatetour/${idTour}"
						method="POST">
						<div class="signup-header">
							<h2>Cập nhật Thông Tin Tour Du Lịch</h2>
							</br>
						</div>
						<div class="row">
							<div class="col-sm-8">
								<label>Id tour</label>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"> <i
										class="fa fa-map-marker"></i>
									</span>
									<s:input placeholder="${idTour}"
										class="form-control margin-bottom-20" type="text"
										path="idTour" disabled="true" />
								</div>
							</div>
							<div class="col-sm-8">
								<!-- Show error -->
								<label>Tên tour</label>
								<small><s:errors path="name" cssStyle="color:red;" /></small>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"> <i
										class="fa fa-map-marker"></i>
									</span>
									<s:input placeholder="Nhập tên tour"
										class="form-control margin-bottom-20" type="text" path="name" />
								</div>
							</div>
							<div class="col-lg-4 text-right">
								<button class="btn btn-primary" type="button">Tải Ảnh
									Lên</button>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6">
								<label>Ngày đi</label> <small><s:errors
										path="departureDate" cssStyle="color:red;" /></small>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"> <i
										class="fa fa-calendar"></i>
									</span>
									<s:input placeholder="mm/dd/yyyy" id="datepicker"
										class="form-control margin-bottom-20" path="departureDate" />
								</div>
							</div>
							<div class="col-sm-6">
								<label>Giờ đi</label> <small><s:errors
										path="departureTime" cssStyle="color:red;" /></small>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"> <i
										class="fa fa-clock-o"></i>
									</span>
									<s:input placeholder="Nhập giờ đi"
										class="form-control margin-bottom-20" type="text"
										path="departureTime" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6">
								<label>Ngày về</label> <small><s:errors
										path="returnDate" cssStyle="color:red;" /></small>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"> <i
										class="fa fa-calendar"></i>
									</span>
									<s:input placeholder="mm/dd/yyyy" id="datepicker2"
										class="form-control margin-bottom-20" path="returnDate" />
								</div>
							</div>
							<div class="col-sm-6">
								<label>Giờ về</label> <small><s:errors path="returnTime"
										cssStyle="color:red;" /></small>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"> <i
										class="fa fa-clock-o"></i>
									</span>
									<s:input placeholder="Nhập giờ đi"
										class="form-control margin-bottom-20" type="text"
										path="returnTime" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6">
								<label>Giá vé</label> <small><s:errors path="price"
										cssStyle="color:red;" /></small>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"> <i class="fa fa-money"></i>
									</span>
									<s:input placeholder="Nhập giá vé"
										class="form-control margin-bottom-20" type="text" path="price" />
								</div>
							</div>
							<div class="col-sm-6">
								<label>Số lượng</label> <small><s:errors path="quantum"
										cssStyle="color:red;" /></small>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"> <i
										class="fa fa-building-o"></i>
									</span>
									<s:input placeholder="Nhập số lượng"
										class="form-control margin-bottom-20" type="text"
										path="quantum" />
								</div>
							</div>
						</div>
						<label>Chi tiết tour</label>
						<small><s:errors path="detail" cssStyle="color:red;" /></small>
						<s:textarea placeholder="Nhập chi tiết về tour" id="area2"
							class="form-control margin-bottom-20" type="text" rows="10"
							path="detail" />
						<hr>
						<div class="row">
							<div class="col-lg-4 text-left">
								<button class="btn btn-primary" type="submit">Xác Nhận</button>
							</div>
							<div class="col-lg-4 text-center">
								<a href="/TravelSystem/managetour"><button
										class="btn btn-primary" type="button">Hủy Bỏ</button></a>
							</div>
							<div class="col-lg-4 text-right">
								<input class="btn btn-primary" type="reset" value="Nhập Lại">
							</div>
						</div>
					</s:form>
				</div>
				<!-- End Create Tour Box -->
			</div>
		</div>
	</div>
	<!-- === END CONTENT === -->
	<!-- === BEGIN FOOTER === -->
	<%@ include file="adminfooter.jsp"%>
	<!-- === END FOOTER === -->