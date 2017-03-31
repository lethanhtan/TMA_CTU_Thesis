<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="adminheader.jsp"%>
<!-- === BEGIN CONTENT === -->
<div id="content">
	<div class="container background-white">
		<div class="container">
			<div class="row margin-vert-40">
				<!-- Portfolio -->
				<ul class="portfolio-group">
					<!-- Portfolio Item -->
					<li class="portfolio-item col-sm-12 col-xs-12 padding-20"><a
						href="#">
							
								<p style="text-align:center"><img alt="SaDecFlowerVillage"
									src="${pageContext.request.contextPath}/image/${img}"></p>
								<figcaption>
									<h3>${name}</h3>
									<span style="color: white;">${detail}</span> 
									<span><a href="/TravelSystem/booktour/${id}"><input class="btn btn-danger text-center" type="submit" value="Đăng ký"></span></a>
								</figcaption>
					</a></li>
				</ul>
					<!-- //Portfolio Item// -->
			</div>
		</div>
	</div>
</div>
<!-- === END CONTENT === -->
<%@ include file="adminfooter.jsp"%>