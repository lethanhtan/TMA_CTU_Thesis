<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="adminheader.jsp"%>
<!-- === BEGIN CONTENT === -->
<div id="content">
	<div class="container background-white">
		<div class="container">
			<div class="row margin-vert-40">
				<!-- Create Export Box -->
				<div class="col-md-6 col-md-offset-3 col-sm-offset-3">
					<form class="signup-page">
						<div class="signup-header">
							<div class="text-center">
								<h2>Quản lý Export</h2><br>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12">
								<label>Tên export</label>
								<br />
								<small><font color="red">${failedName}</font></small>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"> <i
										class="fa fa-font"></i>
									</span> <input placeholder="Nhập tên tour"
										class="form-control margin-bottom-20" type="text" name="nameFile"/>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6">
								<label>Từ ngày</label>
								<br />
								<small><font color="red">${failedDate}</font></small>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"> <i
										class="fa fa-calendar"></i>
									</span> <input placeholder="mm/dd/yyyy" id="datepicker"
										class="form-control margin-bottom-20" name="Date1"/>
								</div>
							</div>
							<div class="col-sm-6">
								<label>Đến ngày</label>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"> <i
										class="fa fa-calendar"></i>
									</span> <input placeholder="mm/dd/yyyy" id="datepicker2"
										class="form-control margin-bottom-20" name="Date2"/>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-7">
								<label>Loại Export</label> <br />
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"> <i class="fa fa-exchange"></i>
									</span> <select class="form-control margin-bottom-20" name="exportList" >
										<option>Danh sách tour</option>
										<option>Danh sách đăng ký cho từng tour</option>
										<option>Danh sách người dùng</option>
									</select>
								</div>
							</div>
							<div class="col-sm-5">
								<label>Loại File</label> <br />
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"> <i class="fa fa-folder-open"></i>
									</span> <select class="form-control margin-bottom-20" name="exportType" >
										<option>Pdf</option>
										<option>Excel</option>
									</select>
								</div>
							</div>
						</div>
						<!-- 
						<c:if test="${!empty param.exportList}">
						<div class="row">
							<div class="col-sm-12 col-md-12">
								<label>Chọn tour cần export</label> <br />
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"> <i class="fa fa-exchange"></i>
									</span> <select class="form-control margin-bottom-20" name="exportList" >
										<c:if test="${listTours != null}">
											<c:forEach items="${listTours}" var="tour" >
												<option>${tour.getName()}</option>
											</c:forEach>
										</c:if>
										<c:if test="${listTours == null}">
											<option>Danh sách tour rỗng</option>
										</c:if>
									</select>
								</div>
							</div>
						</div>
						</c:if>
						 -->
						<hr class="margin-bottom-20">
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
					</form>
				</div>
				<!-- End Export Box -->
			</div>
		</div>
	</div>
</div>
<!-- === END CONTENT === -->
<%@ include file="adminfooter.jsp"%>