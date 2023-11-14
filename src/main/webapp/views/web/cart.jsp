<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Cart Example</title>
</head>
<body>
	<h2>Giỏ hàng</h2>
	<form action="thanhToan" method="post">
		<table border="1">
			<tr>
				<th>Sản phẩm</th>
				<th>Giá</th>
				<th>Số lượng</th>
				<th>Action</th>
			</tr>
			<tr>
				<c:forEach var="p" items="${listp}">
					<td>${p[1]}</td>
					<td>${p[2]}</td>
					<td><input type="number" name="${p[0]}sl" value="1" min="1"></td>
					<td><a href="deleteCart">Delete</a></td>
				</c:forEach>
			</tr>
			<tr>
				<td>Laptop A</td>
				<td>1000000đ</td>
				<td><input type="number" name="${p[0]}sl" value="1" min="1"></td>
				<td><a href="deleteCart">Delete</a></td>
			</tr>
			<tr>
				<td>Laptop A</td>
				<td>1000000đ</td>
				<td><input type="number" name="${p[0]}sl" value="1" min="1"></td>
				<td><a href="deleteCart">Delete</a></td>
			</tr>
		</table>
		<input type="submit" value="Thanh toán">
	</form>
</body>
</html>

