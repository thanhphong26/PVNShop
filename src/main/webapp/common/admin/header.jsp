<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <head>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
</head>
<header>
			<!-- TOP HEADER -->
			<div id="top-header">
				<div class="container">
					<ul class="header-links pull-left">
						<li><a href="#"><i class="fa fa-phone"></i> +021-95-51-84</a></li>
						<li><a href="#"><i class="fa fa-envelope-o"></i> email@email.com</a></li>
						<li><a href="#"><i class="fa fa-map-marker"></i> 1734 Stonecoal Road</a></li>
					</ul>
					<ul class="header-links pull-right">
						<li><a href="#"><i class="fa fa-dollar"></i> USD</a></li>
						<c:choose>
							<c:when test="${sessionScope.account == null}">
								<li><a href="login"><i class="fa fa-user-o"></i> Đăng Nhập/Đăng Ký</a></li>
							</c:when>
							<c:otherwise>
								<li class="nav-item"><a class="nav-link" href="#">${sessionScope.account.name}</a>
								<li class="nav-item"><a class="nav-link"
									href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
			</div>
			<!-- /TOP HEADER -->
<img src="" alt="">
			<!-- MAIN HEADER -->
			<div id="header">
				<!-- container -->
				<div class="container">
					<!-- row -->
					<div class="row">
						<!-- LOGO -->
						<div class="col-md-3">
							<div class="header-logo">
								<a href="#" class="logo">
									<img src="   https://cdn-icons-png.flaticon.com/512/3790/3790091.png " alt="" style="max-width: 100px; max-height: 100px;">
								</a>
							</div>
						</div>
						<div class="col-md-3">
							<div class="header-logo">
								<a href="#" class="logo">
									<img src=" https://scontent.fsgn8-4.fna.fbcdn.net/v/t39.30808-6/402055637_304358942504547_7059836029533435256_n.jpg?_nc_cat=105&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeFrNwb9wPoR3RytavM4A-buMN1KH-10yR4w3Uof7XTJHo7Gy8EG7jruRn1IEMTQrZsqehY8AyOUS3MuvoJ3_zuC&_nc_ohc=vBtpH1GUiUgAX924rnC&_nc_ht=scontent.fsgn8-4.fna&oh=00_AfCXDb_7Dxk1-epvhNwFl7T6FLXtQSn1N5pr7aQGGZW9yA&oe=6561843D" alt="" style="max-width: 1000px; max-height: 1000px;">
								</a>
							</div>
						</div>
						<!-- /LOGO -->
							</div>
						</div>
						<!-- /ACCOUNT -->
					</div>
					<!-- row -->
				</div>
				<!-- container -->
			</div>
			<!-- /MAIN HEADER -->
		</header>
		<!-- /HEADER -->

		<!-- NAVIGATION -->
		<nav id="navigation">
			<!-- container -->
			<div class="container">
				<!-- responsive-nav -->
				<div id="responsive-nav">
					<!-- NAV -->
					<ul class="main-nav nav navbar-nav">
				

					</ul>
					<!-- /NAV -->
				</div>
				<!-- /responsive-nav -->
			</div>
			<!-- /container -->
		</nav>