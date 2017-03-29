<!-- === BEGIN HEADER === -->
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="adminheader.jsp"%>
<!-- === END HEADER === -->
<!-- === BEGIN CONTENT === -->
<div id="content">
	<div class="container background-white">
		<div class="row margin-vert-30">
			<!-- Search Form -->
			<div class="error-404-page text-center" style="margin-left: 650px;">
				<form class="form-search search-404">
					<div class="input-append">
						<input type="text" class="span2 search-query"
							placeholder="Nhập từ khóa" name="valueSearch">
						<button type="submit" class="btn btn-primary">Tìm Kiếm</button>
					</div>
				</form>
			</div>
			<!-- End Search Form -->
			<div class="col-md-12">
				<h2 class="margin-vert-20" style="text-align: center;">Danh
					Sách Tài Khoản</h2>
				<a href="register"><button
						class="btn btn-primary fa-plus-square">Tạo Mới</button></a>
				<div class="row margin-bottom-30">
					<div class="col-md-4 animate fadeInRight"></div>
					<div class="col-md-8 animate fadeIn"></div>
					<div class="col-md-12 animate fadeInRight"></div>
				</div>
				<hr class="margin-vert-20">
				<!-- Table -->
				<c:if test="${empty userList}">
					<h1 style="text-align: center;">Không có tour nào!</h1>
				</c:if>
				<c:if test="${!empty userList}">
					<!-- Choose Number For Display -->
					<div class="row">
						<form role="form" class="form-inline" action="manageuser"
							method="get">
							<label for="selectUser" style="text-align: left; margin-left: 2%">Số
								tài khoản/ trang:</label> <select id="selectUser" class="form-control"
								name="numOn">
								<option>5</option>
								<option>10</option>
								<option>15</option>
							</select>
							<button class="btn btn-aqua">Chọn</button>
						</form>
					</div>
					</br>
					<!-- End Choose Number For Display -->
					<table>
						<thead>
							<tr>
								<th>STT</th>
								<th>Họ tên</th>
								<th>Giới tính</th>
								<th>Ngày sinh</th>
								<th>Email</th>
								<th>Số điện thoại</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${userList.subList(x,y)}" var="user">
								<!-- use subList render list user to display -->
								<tr>
									<c:if test="${user.idUser != id}">
										<td>${userList.indexOf(user) + 1}</td>
										<td>${user.fullName}</td>
										<td>&nbsp;&nbsp;&nbsp; ${user.sex}</td>
										<td>&nbsp;&nbsp;&nbsp; ${user.birthday}</td>
										<td>&nbsp;&nbsp;&nbsp; ${user.email}</td>
										<td>&nbsp;&nbsp;&nbsp; ${user.phone}&nbsp;&nbsp;&nbsp;</td>
										<td><a href="<c:url value='userdetail/${user.idUser}'/>">
												<button class="btn btn-sm btn-violet">
													<i class="fa fa-eye">&nbsp;Xem</i>
												</button>
										</a><a href="<c:url value='edituser/${user.idUser}'/>"><button
													class="btn btn-sm btn-success">
													<i class="fa fa-pencil">&nbsp;Sửa</i>
												</button></a> <a
											href="<c:url value='manageuser/deleteuser/${user.idUser}'/>"><button
													class="btn btn-sm btn-danger">
													<i class="fa fa-trash-o">&nbsp;Xóa</i>
												</button></a></td>
									</c:if>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
				<!-- End Table -->
				<hr class="margin-vert-50">
				<div class="text-center">
					<!-- Pagination -->
					<c:if test="${numUser > numOnPage}">
						<!-- Paging when number of element > number of tour -->
						<!-- set active pagination when numTour >= 5 -->
						<ul class="pagination">
							<c:if test="${param.page != null}">
								<c:if test="${param.page == 1}">
									<li class="disabled"></li>
								</c:if>
								<c:if test="${param.page > 1 }">
									<li><a
										href="${pageContext.request.contextPath }/manageuser?page=${param.page -1}">&laquo;</a>
									</li>
								</c:if>
							</c:if>
							<c:forEach items="${pageNum}" var="pageE">
								<c:if test="${pageE == page}">
									<li class="active"><a
										href="${pageContext.request.contextPath}/manageuser?page=${pageE}">${pageE}</a></li>
								</c:if>
								<c:if test="${pageE != page}">
									<li><a
										href="${pageContext.request.contextPath}/manageuser?page=${pageE}">${pageE}</a></li>
								</c:if>
							</c:forEach>
							<c:if test="${numUser/numOnPage - param.page == 0}">
								<li class="disabled"><a
									href="${pageContext.request.contextPath }/manageuser?page=${param.page + 1}">&raquo;</a>
								</li>
							</c:if>
							<c:if test="${numUser/numOnPage - param.page > 0}">
								<li><a
									href="${pageContext.request.contextPath }/manageuser?page=${page + 1}">&raquo;</a>
								</li>
							</c:if>
						</ul>
					</c:if>
				</div>
				<!-- End Pagination -->
			</div>
		</div>
	</div>
</div>
<!-- === END CONTENT === -->
<!-- === BEGIN FOOTER === -->
<%@ include file="userfooter.jsp"%>
<!-- === END FOOTER === -->