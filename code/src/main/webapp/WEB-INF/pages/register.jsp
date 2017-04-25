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
				<!-- Register Box -->
				<div class="col-md-6 col-md-offset-3 col-sm-offset-3">
					<s:form class="signup-page" commandName="userData"
						action="${pageContext.request.contextPath }/register"
						method="POST" id="checkboxV">
						<div class="signup-header">
							<h2 style="text-align: center;">Đăng Ký Tài Khoản</h2>
							<p>
								Đã có tài khoản? <a href="login" style="color: #ef5b92">Đăng
									nhập</a>
							</p>
						</div>
						<small style="color: red;">${failedConnect}</small>
						<label>Tên tài khoản</label>
						<br />
						<small><s:errors path="userName" cssStyle="color:red;" /></small>
						<br />
						<small Style="color: red">${invalidUserName}</small>
						<div class="input-group margin-bottom-20">
							<span class="input-group-addon"> <i class="fa fa-user"></i>
							</span>
							<s:input placeholder="Nhập tên tài khoản"
								class="form-control margin-bottom-20" type="text"
								path="userName"/>
						</div>
						<div class="row">
							<div class="col-sm-6">
								<label>Mật Khẩu</label> <br /> <small><s:errors
										path="password" cssStyle="color:red;" /></small>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"> <i class="fa fa-lock"></i>
									</span>
									<s:input placeholder="Nhập mật khẩu"
										class="form-control margin-bottom-20" type="password"
										path="password" />
								</div>
							</div>
							<div class="col-sm-6">
								<label>Xác nhận mật khẩu</label>
								<br />
								<small Style="color: red">${failedPasswordConfirm}</small>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"> <i class="fa fa-repeat"></i>
									</span> <input placeholder="Nhập lại mật khẩu"
										class="form-control margin-bottom-20" type="password"
										name="passwordConfirm" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-7">
								<label>Họ tên</label> <br /> <small><s:errors
										path="fullName" cssStyle="color:red;" /></small>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"> <i class="fa fa-font"></i>
									</span>
									<s:input placeholder="Nhập họ tên"
										class="form-control margin-bottom-20" type="text"
										path="fullName" />
								</div>
							</div>
							<div class="col-sm-5">
								<label>Giới tính</label> <br />
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"> <i class="fa fa-male"></i>
									</span>
									<s:select class="form-control margin-bottom-20" path="sex">
										<option>Nam</option>
										<option>Nữ</option>
									</s:select>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6">
								<label>Ngày sinh</label> <br /> <small Style="color: red">${failedBirthday}</small>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"> <i
										class="fa fa-calendar"></i>
									</span>
									<s:input placeholder="mm/dd/yyyy" id="datepicker"
										class="form-control margin-bottom-20" path="birthday" />
								</div>
							</div>
							<div class="col-sm-6">
								<label>Số điện thoại</label> <br /> <small><s:errors
										path="phone" cssStyle="color:red;" /></small>
								<div class="input-group margin-bottom-20">
									<span class="input-group-addon"> <i class="fa fa-tablet"></i>
									</span>
									<s:input placeholder="Nhập số điện thoại"
										class="form-control margin-bottom-20" type="text" path="phone" />
								</div>
							</div>
						</div>
						<label>Email</label>
						<br />
						<small><s:errors path="email" cssStyle="color:red;" /></small>
						<div class="input-group margin-bottom-20">
							<span class="input-group-addon"> <i class="fa fa-envelope"></i>
							</span>
							<s:input placeholder="Nhập email"
								class="form-control margin-bottom-20" type="email" path="email" />
						</div>
						<label>Địa chỉ</label>
						<br />
						<small><s:errors path="address" cssStyle="color:red;" /></small>
						<div class="input-group margin-bottom-20">
							<span class="input-group-addon"> <i class="fa fa-home"></i>
							</span>
							<s:input placeholder="Nhập địa chỉ"
								class="form-control margin-bottom-20" type="text" path="address" />
						</div>
						<!-- reCAPTCHA -->
						<!-- 
						<p style="color: red;">${errorString}</p>
						<div style="margin-left: 37px;" class="g-recaptcha"
							data-sitekey="6Le28hQUAAAAAFKa2w76sfgp5ULrd4iIYJLwtxOd"></div>
							 -->
						<!-- End reCAPTCHA -->
						<br>
						<hr>
						<div class="row">
							<div class="col-lg-8">
								<label class="checkbox"> <input type="checkbox"
									id="field_terms" required name="terms"> Tôi đồng ý với
									<a href="gioi-thieu" style="color: blueviolet;"> điều khoản
										và chính sách </a> của NY Travel Company
								</label>
							</div>
							<div class="col-lg-4 text-right">
								<button class="btn btn-primary" type="submit">Đăng Ký</button>
							</div>
						</div>
					</s:form>
				</div>
				<!-- End Register Box -->
			</div>
		</div>
	</div>
</div>
<!-- === END CONTENT === -->
<!-- === BEGIN FOOTER === -->
<%@ include file="userfooter.jsp"%>
<!-- === END FOOTER === -->
