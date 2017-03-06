<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="adminheader.jsp" %>
<!-- === BEGIN CONTENT === -->
<div id="content">
	<div class="container background-white">
		<div class="container">
			<div class="row margin-vert-30">
				<!-- Create Tour Box -->
				<div class="col-md-6 col-md-offset-3 col-sm-offset-3">
					<s:form class="signup-page" commandName="tourData"
						action="${pageContext.request.contextPath}/createtour"
						method="POST">
						<div class="signup-header">
							<h2>Thông Tin Tour Du Lịch</h2>
						</div>
						<div class="row">
							<div class="col-sm-8">
								<label>Tên tour</label>
								<!-- Show Error -->
								</br> <small><s:errors path="name" cssStyle="color:red;" /></small>
								<!--  End Show Error -->
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
								<label>Ngày đi</label>
								<!-- Show error -->
								</br> <small><s:errors path="departureDate"
										cssStyle="color:red;" /></small>
								<!-- End Show Error -->
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"> <i
										class="fa fa-calendar"></i>
									</span>
									<s:input placeholder="mm/dd/yyyy" id="datepicker"
										class="form-control margin-bottom-20" path="departureDate" />
								</div>
							</div>
							<div class="col-sm-6">
								<label>Giờ đi</label>
								<!-- Show Error -->
								</br> <small><s:errors path="departureTime"
										cssStyle="color:red;" /></small>
								<!-- End Show Error -->
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
								<label>Ngày về</label>
								<!-- Show Error -->
								</br> <small><s:errors path="returnDate"
										cssStyle="color:red;" /></small>
								<!-- End Show Error -->
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"> <i
										class="fa fa-calendar"></i>
									</span>
									<s:input placeholder="mm/dd/yyyy" id="datepicker2"
										class="form-control margin-bottom-20" path="returnDate" />
								</div>
							</div>
							<div class="col-sm-6">
								<label>Giờ về</label>
								<!-- Show Error -->
								</br> <small><s:errors path="returnTime"
										cssStyle="color:red;" /></small>
								<!-- End Show Error -->
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
								<label>Giá vé</label>
								<!-- Show Error -->
								</br> <small><s:errors path="price" cssStyle="color:red;" /></small>
								<!-- End Show Error -->
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"> <i class="fa fa-money"></i>
									</span>
									<s:input placeholder="Nhập giá vé"
										class="form-control margin-bottom-20" type="text" path="price" />
								</div>
							</div>
							<div class="col-sm-6">
								<label>Số lượng</label>
								<!-- Show Error -->
								</br> <small><s:errors path="quantum" cssStyle="color:red;" /></small>
								<!-- End Show Error -->
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
						<!-- Show Error -->
						</br>
						<small><s:errors path="detail" cssStyle="color:red;" /></small>
						<!-- End Show Error -->
						<s:textarea placeholder="Nhập chi tiết về tour" id="area2"
							class="form-control margin-bottom-20" type="text" rows="10"
							path="detail" />
						<hr>
						<div class="row">
							<div class="col-lg-4 text-left">
								<button class="btn btn-primary" type="submit">Xác Nhận</button>
							</div>
							<div class="col-lg-4 text-center">
								<a href="managetour"><button class="btn btn-primary"
										type="button">Hủy Bỏ</button></a>
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
<%@ include file="adminfooter.jsp" %>