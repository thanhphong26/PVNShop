<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <!-- ... your other content ... -->

    <div style="text-align: right; margin-top: 10px;">
      <div style="text-align: right; margin-top: 20px;">
    <h1 style="display: inline-block; margin-right: 750px; margin-left: 5px;">Thống Kê</h1>
    
   

    <form action="/PVNShop/admin_page" style="display: inline-block;">
         <button class="primary-btn" type="submit">Quay lại</button>
    </form>
</div>
</div>
<nav id="navigation">
			<!-- container -->
			<div class="container">
				<!-- responsive-nav -->
				<div id="responsive-nav">
					<!-- NAV -->
					<ul class="main-nav nav navbar-nav">
						<li ><a href="ThongKe">Bán chạy</a></li>

						<li class="active"><a href="#">Doanh Thu</a></li>

					</ul>
					<!-- /NAV -->
				</div>
				<!-- /responsive-nav -->
			</div>
			<!-- /container -->
		</nav>
<div style="margin:30px 0px;text-align: center; padding: 20px; background-color: #f0f0f0; border-radius: 10px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);">
    <h1 style="font-size: 24px; color: #333;">Tổng Doanh Thu:</h1>
    <p style="font-size: 18px; color: #555; margin-top: 10px;">
    <fmt:formatNumber type="currency" value="${sum}" currencyCode="VND" pattern="#,##0 VND" var="formattedOldPrice" />
				                            ${formattedOldPrice} 
    </p>
</div>
</body>
</html>