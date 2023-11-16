<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Giỏ hàng</title>
</head>
<body>

	<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
}

h2 {
	background-color: #000;
	color: #cc0000; /* Màu đỏ nhẹ */
	padding: 20px;
	margin: 0;
	font-size: 36px;
	border-radius: 10px;
	text-transform: uppercase;
	letter-spacing: 2px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
	text-align: center;
	transition: background-color 0.3s ease-in-out;
}

form {
	max-width: 1000px;
	margin: 20px auto;
	text-align: center;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 10px;
	background-color: #fff;
}

th, td {
	border: 1px solid #ddd;
	padding: 8px;
	text-align: center;
	
}

th {
	background-color: #000;
	color: #fff;
	text-align: center;
}

input[type="number"] {
	width: 50px;
	padding: 5px;
	box-sizing: border-box;
}

input[type="submit"] {
	display: block;
	margin: auto;
	margin-top: 10px;
	background-color: #000;
	color: #fff;
	padding: 10px 15px; /* Giảm kích thước padding */
	border: none;
	cursor: pointer;
	border-radius: 15px; /* Góc bo tròn nhỏ hơn */
	font-size: 16px; /* Giảm kích thước chữ */
	transition: background-color 0.3s ease-in-out, color 0.3s ease-in-out,
		transform 0.2s ease-in-out;
}

input[type="submit"]:hover {
	background-color: #333; /* Màu nền đen đậm khi di chuột qua */
	transform: scale(1.05);
}
</style>

	<h2>My Cart</h2>

	<form action="thanhToan" method="post">
		<table>
			<tr>
				<th>Hình ảnh</th>
				<th>Tên Sản phẩm</th>
				<th>Giá</th>
				<th>Số lượng</th>
				<th>Action</th>
			</tr>

			<!-- Thêm dòng trong mảng 2D sử dụng JSTL -->
			<c:forEach var="p" items="${listp}">
				<tr>
					<td><img src="${p[3]}" width="150" height="100"></td>
					<td>${p[1]}</td>
					<td>${p[2]}</td>
					<td><input type="number" name="${p[0]}" value="${p[4]}" min="1"></td>
					<td><a href="deleteCart?id=${p[0]}"
						style="text-decoration: none; display: inline-block;"> <span
							style="background-color: #cc0000; color: #fff; padding: 10px 15px; border: 1px solid red; border-radius: 20px; transition: background-color 0.3s ease-in-out, color 0.3s ease-in-out;">
								Xoá </span>
					</a></td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="Mua hàng">
	</form>

</body>
</html>




