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
				<!-- Update Tour Box -->
				<s:form class="signup-page" commandName="tourData"
					enctype="multipart/form-data"
					action="${pageContext.request.contextPath }/updatetour/${tourData.idTour}"
					method="POST">
					<div class="signup-header">
						<h2 style="text-align: center;">Cập nhật Thông Tin Tour</h2>
					</div>
					<script>
							function redirect() {
						 			window.setTimeout(function(){
						        		window.location.href = "${pageContext.request.contextPath}/managetour";
						    		}, 2000);
							}
							</script>
					<div class="row">
						<div class="col-sm-12">
							<c:if test="${!empty status}">
								<div class="alert alert-success">
									<strong>${status}</strong>
								</div>
								<script>
									redirect();
								</script>
							</c:if>
							<label>Tên tour</label> <br />
							<!-- Show error -->
							<small><s:errors path="name" cssStyle="color:red;" /></small>
							<div class="input-group margin-bottom-20">
								<span class="input-group-addon"> <i
									class="fa fa-map-marker"></i>
								</span>
								<s:input placeholder="Nhập tên tour"
									class="form-control margin-bottom-20" type="text" path="name" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-12 col-sm-12">
							<label>Hình ảnh</label>
							<!-- Show error -->
							<small style="color: red">${failedUpload}</small> <small
								style="color: red">${failedEmpty}</small>
							<!-- End Show Error -->
							<div class="input-group">
								<label class="input-group-btn"> <span
									class="btn btn-primary"> Tập tin&hellip; <input
										type="file" name="file" style="display: none;" multiple>
								</span>
								</label> <input type="text" name="nameFile" class="form-control" value="${oldImage}"
									readonly>
							</div>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-sm-6">
							<label>Ngày đi</label>
							<!-- Show error -->
							<small><s:errors path="departureDate"
									cssStyle="color:red;" /></small>
							<!-- End Show Error -->
							<div class="input-group margin-bottom-20">
								<span class="input-group-addon"> <i
									class="fa fa-calendar"></i>
								</span>
								<s:input placeholder="yyyy/mm/dd" id="datepicker"
									value="${date1}" class="form-control margin-bottom-20"
									path="departureDate" />
							</div>
						</div>
						<div class="col-sm-6">
							<label>Giờ đi</label> <small><s:errors
									path="departureTime" cssStyle="color:red;" /></small>
							<div class="input-group margin-bottom-20">
								<span class="input-group-addon"> <i class="fa fa-clock-o"></i>
								</span>
								<s:input placeholder="Nhập giờ đi"
									class="form-control margin-bottom-20" type="text"
									path="departureTime" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-6">
							<label>Ngày về</label> <small><s:errors path="returnDate"
									cssStyle="color:red;" /></small>
							<div class="input-group margin-bottom-20">
								<span class="input-group-addon"> <i
									class="fa fa-calendar"></i>
								</span>
								<s:input placeholder="mm/dd/yyyy" id="datepicker2"
									value="${date2}" class="form-control margin-bottom-20"
									path="returnDate" />
							</div>
						</div>
						<div class="col-sm-6">
							<label>Giờ về</label> <small><s:errors path="returnTime"
									cssStyle="color:red;" /></small>
							<div class="input-group margin-bottom-20">
								<span class="input-group-addon"> <i class="fa fa-clock-o"></i>
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
					<div class="row">
						<div class="col-sm-6">
							<label>Ngày cho phép đăng ký</label>
							<div class="input-group margin-bottom-20">
								<span class="input-group-addon"> <i
									class="fa fa-calendar"></i>
								</span>
								<s:input placeholder="mm/dd/yyyy" id="datepicker3"
									value="${date3}" class="form-control margin-bottom-20"
									path="dateAllowReg" />
							</div>
						</div>
						<div class="col-sm-6">
							<label>Ngày cho phép hủy</label>
							<div class="input-group margin-bottom-20">
								<span class="input-group-addon"> <i
									class="fa fa-calendar"></i>
								</span>
								<s:input placeholder="mm/dd/yyyy" id="datepicker4"
									value="${date4}" class="form-control margin-bottom-20"
									path="dateAllowCancel" />
							</div>
						</div>
					</div>
					<p style="text-align: center; color: #ef5b92;">Hãy chọn những
						thông tin bắt buộc khách hàng phải điền khi đăng ký tham gia tour
						du lịch!</p>
					<div class="row">
						<div class="col-lg-6">
							<label class="checkbox"><s:checkbox path="fieldName" />Họ
								tên </label>
						</div>
						<div class="col-lg-6">
							<label class="checkbox"><s:checkbox path="fieldSex" />Giới
								tính </label>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6">
							<label class="checkbox"><s:checkbox path="fieldPhone" />Số
								điện thoại</label>
						</div>
						<div class="col-lg-6">
							<label class="checkbox"><s:checkbox
									path="fieldNumOfTicket" />Số lượng vé </label>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6">
							<label class="checkbox"><s:checkbox path="fieldEmail" />Địa
								chỉ email</label>
						</div>
						<div class="col-lg-6">
							<label class="checkbox"><s:checkbox path="fieldAddress" />Địa
								chỉ </label>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6">
							<label class="checkbox"><s:checkbox path="fieldIdCard" />Số
								chứng minh nhân dân </label>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-8">
							<label class="checkbox"><input type="checkbox"
								name="select-all" id="select-all">Chọn tất cả </label>
						</div>
					</div>
					<s:input path="ticketAvailability" hidden="true" />
					<s:input path="howLong" hidden="true" />
					<s:input path="view" hidden="true" />
					<label>Chi tiết tour</label>
					<small><s:errors path="detail" cssStyle="color:red;" /></small>
					<s:textarea placeholder="Nhập chi tiết về tour" id="area2"
						class="form-control margin-bottom-20" type="text" rows="10"
						path="detail" />
					<br>
					<hr>
					<div class="row">
						<div class="col-lg-6 text-center">
							<button class="btn btn-primary" type="submit">Xác Nhận</button>
						</div>
						<div class="col-lg-6 text-center">
							<a href="${pageContext.request.contextPath }/managetour"><button
									class="btn btn-primary" type="button">Hủy Bỏ</button></a>
						</div>
					</div>
				</s:form>
				<!-- End Update Tour Box -->
			</div>
		</div>
	</div>
</div>
<!-- === END CONTENT === -->
<!-- === BEGIN FOOTER === -->
<%@ include file="adminfooter.jsp"%>
<!-- === END FOOTER === -->