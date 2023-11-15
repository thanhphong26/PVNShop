<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
        <input type="submit" value="Quay Lại" style="height: 30px; width: 140px; margin: 15px 10px; background-color: #DD0000; color: white; border-radius: 15px;">
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
						<li class="active"><a href="#">Bán chạy</a></li>

						<li><a href="ThongKeDT">Doanh Thu</a></li>

					</ul>
					<!-- /NAV -->
				</div>
				<!-- /responsive-nav -->
			</div>
			<!-- /container -->
		</nav>
<table  border="1" style="margin-bottom:50px;width: 100%; border-collapse: collapse; margin-top: 20px;">
    <thead style="background-color: #f2f2f2;">
        <th style="padding: 10px; text-align: left;">ID</th>
        <th style="padding: 10px; text-align: left;">Name</th>
        <th style="padding: 10px; text-align: left;">Version</th>
        <th style="padding: 10px; text-align: left;">Description</th>
        <th style="padding: 10px; text-align: left;">Price</th>
        <th style="padding: 10px; text-align: left;">Color</th>
        <th style="padding: 10px; text-align: left;">Size</th>
        <th style="padding: 10px; text-align: left;">Inventory</th>
        <th style="padding: 10px; text-align: left;">Image</th>
        <th style="padding: 10px; text-align: left;">Category</th>
        <th style="padding: 10px; text-align: left;">Manufacturer</th>
    </thead>
    <tbody>
        <c:forEach var="i" items="${listtk}">
            <tr style="border-bottom: 1px solid #ddd;">
                <td style="padding: 10px; text-align: left;">${i.productID}</td>
                <td style="padding: 10px; text-align: left;">${i.productName}</td>
                <td style="padding: 10px; text-align: left;">${i.version}</td>
                <td style="padding: 10px; text-align: left;">${i.description}</td>
                <td style="padding: 10px; text-align: left;">${i.price}</td>
                <td style="padding: 10px; text-align: left;">${i.color}</td>
                <td style="padding: 10px; text-align: left;">${i.size}</td>
                <td style="padding: 10px; text-align: left;">${i.inventory}</td>
                <td style="padding: 10px; text-align: left;"><img style="height: 50px; width: 50px; object-fit: cover;" src="${i.image}"></td>
                <td style="padding: 10px; text-align: left;">${i.cateID}</td>
                <td style="padding: 10px; text-align: left;">${i.manuID}</td>
                
            </tr>
        </c:forEach>
    </tbody>
 
</table>
					


</body>
</html>