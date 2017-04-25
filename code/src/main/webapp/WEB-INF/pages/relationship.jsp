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
				<!-- Design Form -->
				<div class="col-md-6 col-md-offset-3 col-sm-offset-3">
					<div class="signup-header">
						<h2 style="text-align: center;">Danh Sách Mối Quan Hệ</h2>
					</div>
					<br>
					<hr>
					<p style="color: red; text-align: center;">${error}</p>
					<div id="accordion" class="panel-group">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a class="accordion-toggle" href="#collapse-Two"
										data-parent="#accordion" data-toggle="collapse">Thêm mối
										quan hệ</a>
								</h4>
							</div>
							<div id="collapse-Two" class="accordion-body collapse">
								<div class="panel-body">
									<s:form commandName="relationshipData"
										action="${pageContext.request.contextPath}/relationship"
										method="POST">
										<div class="input-group margin-bottom-20">
											<span class="input-group-addon"> <i
												class="fa fa-group"></i>
											</span>
											<s:input placeholder="Nhập mối quan hệ"
												class="form-control" type="text" path="name" />
										</div>
										<div class="row" style="text-align: center;">
											<button class="btn btn-primary" type="submit">Xác
												Nhận</button>
										</div>
									</s:form>
								</div>
							</div>
						</div>
					</div>
					<c:if test="${empty relationshipList}">
						<h2 style="text-align: center; color: red;">Chưa có mối quan
							hệ nào!</h2>
					</c:if>
					<c:if test="${!empty relationshipList}">
						<table>
							<thead>
								<tr>
									<th style="text-align: left;">STT</th>
									<th style="text-align: left;">Tên mối quan hệ</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${relationshipList}" var="relationship">
									<tr>
										<td>${relationshipList.indexOf(relationship) + 1}</td>
										<td>${relationship.name}</td>
										<td><a
											href="<c:url value='relationship/delete/${relationship.id}'/>">
												<button type="button" id="button${relationship.id}"
													hidden="true"></button>
										</a>
											<button class="btn btn-xs btn-danger delete"
												id="${relationship.id}">
												<i class="fa fa-trash-o">&nbsp;Xóa</i>
											</button></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:if>
					<br>
					<hr>
					<a href="${pageContext.request.contextPath}/manageregister"><button
							class="btn btn-primary" style="margin-left: 80%;">
							<i class="fa fa-arrow-left">&nbsp;Trở Về</i>
						</button></a> <br>
				</div>
				<!-- End Design Form -->
			</div>
		</div>
	</div>
</div>
<!-- === END CONTENT === -->
<!-- === BEGIN FOOTER === -->
<%@ include file="adminfooter.jsp"%>
<!-- === END FOOTER === -->