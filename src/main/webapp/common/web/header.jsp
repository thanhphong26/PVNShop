<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <head>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
</head>
<header>
			<!-- TOP HEADER -->
			<div id="top-header">
				<div class="container">
					<ul class="header-links pull-left">
						<li><a href="#"><i class="fa fa-phone"></i> 012-345-1234</a></li>
						<li><a href="#"><i class="fa fa-envelope-o"></i> pvnshop@gmail.com</a></li>
						<li><a href="#"><i class="fa fa-map-marker"></i> 1 Vo Van Ngan, TP Thu Duc</a></li>
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
									<img src="" alt="" style="max-width: 100px; max-height: 100px;">
								</a>
							</div>
						</div>
						<!-- /LOGO -->

						<!-- SEARCH BAR -->
								<div class="col-md-6">
								    <div class="header-search">
								        <form action="search" method="get">
								            <select class="input-select">
								                <option value="0">Tất cả</option>
								                <option value="1">Doanh nhân</option>
								                <option value="2">Mỏng nhẹ</option>
								                <option value="3">Sinh viên</option>
								                <option value="4">Thiết kế đồ hoạ</option>
								            </select>
								            <input name="txt" class="input" placeholder="Search here">
								            <button type="submit" class="search-btn">Tìm kiếm</button>
								        </form>
								    </div>
								</div>
						<!-- /SEARCH BAR -->

						<!-- ACCOUNT -->
						<div class="col-md-3 clearfix">
							<div class="header-ctn">
								<!-- Wishlist -->

								<!-- /Wishlist -->

								<!-- Cart -->
								<div class="dropdown">
									<a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
										<i class="fa fa-shopping-cart"></i>
										<span>Giỏ hàng</span>
										<div class="qty">3</div>
									</a>
									
										<div class="cart-btns">
											<a href="cart">View Cart</a>
											<a href="thanhToan">Checkout  <i class="fa fa-arrow-circle-right"></i></a>
										</div>
									</div>
								</div>
								<!-- /Cart -->
								<!-- Menu Toogle -->
								<div class="menu-toggle">
									<a href="#">
										<i class="fa fa-bars"></i>
										<span>Menu</span>
									</a>
								</div>
								<!-- /Menu Toogle -->
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
		<nav id="navigation">
			<!-- container -->
			<div class="container">
				<!-- responsive-nav -->
				<div id="responsive-nav">
					<!-- NAV -->
					<ul class="main-nav nav navbar-nav">
						<li class="active"><a href="home">Trang Chủ</a></li>

						<li><a href="#">Phân loại</a></li>
						<li><a href="product">Laptops</a></li>
						<li><a href="#">Smartphones</a></li>
						<li><a href="#">Cameras</a></li>
						<li><a href="#">Accessories</a></li>
					</ul>
					<!-- /NAV -->
				</div>
				<!-- /responsive-nav -->
			</div>
			<!-- /container -->
		</nav>