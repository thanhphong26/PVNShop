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
    <h1 style="display: inline-block; margin-right: 410px; margin-left: 5px;">Quản lý hóa đơn</h1>
    
    <input type="button" value="Thêm" style="display: inline-block; height: 30px; width: 140px; margin: 15px 10px; background-color: #33FF99; color: white; border-radius: 15px;">

    <form action="/PVNShop/admin_page" style="display: inline-block;">
        <input type="submit" value="Quay Lại" style="height: 30px; width: 140px; margin: 15px 10px; background-color: #FF6633; color: white; border-radius: 15px;">
    </form>
</div>




</div>

<table  border="1" style="margin-bottom:50px;width: 100%; border-collapse: collapse; margin-top: 20px;">
    <thead style="background-color: #f2f2f2;">
        <th style="padding: 10px; text-align: left;">ID</th>
        <th style="padding: 10px; text-align: left;">Time</th>
        <th style="padding: 10px; text-align: left;">Total</th>
        <th style="padding: 10px; text-align: left;">State</th>
        <th style="padding: 10px; text-align: left;">Note</th>
        <th style="padding: 10px; text-align: left;">Payment_method</th>
        <th style="padding: 10px; text-align: left;">User_name</th>
        <th style="padding: 10px; text-align: left;">Discount_id</th>
        <th style="padding: 10px; text-align: left;">Shipping_method</th>
        <th style="padding: 10px; text-align: left;">Ship_cost</th>
		<th style="padding: 10px; text-align: left;">Option</th>
    </thead>
    <tbody>
        <c:forEach var="i" items="${listO}">
            <tr style="border-bottom: 1px solid #ddd;">
                <td style="padding: 10px; text-align: left;">${i.orderID}</td>
                <td style="padding: 10px; text-align: left;">${i.time}</td>
                <td style="padding: 10px; text-align: left;">${i.total}</td>
                <td style="padding: 10px; text-align: left;">${i.state}</td>
                <td style="padding: 10px; text-align: left;">${i.note}</td>
                <td style="padding: 10px; text-align: left;">${i.payment_method}</td>
                <td style="padding: 10px; text-align: left;">${i.user_name}</td>
                <td style="padding: 10px; text-align: left;">${i.discount_id}</td>
                <td style="padding: 10px; text-align: left;">${i.shipping_method}</td>
                <td style="padding: 10px; text-align: left;">${i.ship_cost}</td>
                <td style="padding: 10px; text-align: left;">

                    <input type="button" value="Sửa" style="margin: 15px 21px; background-color:#6699FF; color: white; border-radius:15px;">

                    <input type="submit" value="Xóa" style="margin: 15px 21px; background-color:#FF6633; color: white; border-radius:15px;">
                </td>
            </tr>
        </c:forEach>
    </tbody>
 
</table>
					


</body>
</html>