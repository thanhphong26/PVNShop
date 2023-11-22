<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <head>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<style>
        .active {
            color: #ff0000; /* Red color for the active item */
        }
    </style>
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
						<c:choose>
							<c:when test="${sessionScope.account == null}">
								<li><a href="login"><i class="fa fa-user-o"></i> Đăng Nhập/Đăng Ký</a></li>
							</c:when>
							<c:otherwise>
								<li class="nav-item"><a class="nav-link" href="Account">${sessionScope.account.name}</a>
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
									<img src="https://scontent.fsgn8-4.fna.fbcdn.net/v/t39.30808-6/402055637_304358942504547_7059836029533435256_n.jpg?_nc_cat=105&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeFrNwb9wPoR3RytavM4A-buMN1KH-10yR4w3Uof7XTJHo7Gy8EG7jruRn1IEMTQrZsqehY8AyOUS3MuvoJ3_zuC&_nc_ohc=vBtpH1GUiUgAX924rnC&_nc_ht=scontent.fsgn8-4.fna&oh=00_AfCXDb_7Dxk1-epvhNwFl7T6FLXtQSn1N5pr7aQGGZW9yA&oe=6561843D" alt="" style="max-width: 250px; max-height: 250px;">
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
							<!-- Cart -->
								<div class="dropdown">
									<a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
										<i class="fa fa-shopping-cart"></i>
										<span>Your Cart</span>								
									</a>
									<div class="cart-dropdown">
										<div class="cart-btns">
											<a href="cart">View Cart</a>
											<a href="thanhToan">Checkout  <i class="fa fa-arrow-circle-right"></i></a>
										</div>
									</div>
								</div>
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
                <li><a href="home" onclick="setActive(this, 'Trang Chủ');">Trang Chủ</a></li>
                <li><a href="#" onclick="setActive(this, 'Phân loại');">Phân loại</a></li>
                <li><a href="product" onclick="setActive(this, 'Laptops');">Laptops</a></li>
                <li><a href="#" onclick="setActive(this, 'Smartphones');">Smartphones</a></li>
                <li><a href="#" onclick="setActive(this, 'Cameras');">Cameras</a></li>
                <li><a href="#" onclick="setActive(this, 'Accessories');">Accessories</a></li>
            </ul>
            <!-- /NAV -->
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script>
        function setActive(element, categoryName) {
            $('.main-nav a').removeClass('active');

            $(element).addClass('active');

            sessionStorage.setItem('activeCategory', categoryName);
        }

        $(document).ready(function () {
            var activeCategory = sessionStorage.getItem('activeCategory');
            if (activeCategory) {
                $('.main-nav a:contains(' + activeCategory + ')').addClass('active');
            }
        });
    </script>
    <!-- /container -->
</nav>
