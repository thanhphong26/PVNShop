<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Xác nhận thanh toán</title>
</head>
<body>
	<form action="capnhatdb"  style="display: flex; justify-content: center; align-items: center; height: auto; padding: 5px; margin: 20px auto;">
    <div style="flex-grow: 1; max-width: 600px; padding: 20px; border: 1px solid #ddd; border-radius: 5px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); background-color: #faf0e6; border: 3px solid #000000;">
        <table style="width: 100%; border-collapse: collapse;">
            <tr>
                <th colspan="2" style="text-align: center; font-size: 1.5em; padding-bottom: 10px;">Đơn hàng của bạn</th>
            </tr>
            <tr>
                <th style="border: 1px solid #ddd; padding: 10px; text-align: left;">Sản phẩm</th>
                <th style="border: 1px solid #ddd; padding: 10px; text-align: left;">Tổng</th>
            </tr>
            <c:forEach var="p" items="${plist}">
                <tr>
                    <td style="border: 1px solid #ddd; padding: 10px; text-align: left;">${p[0]} x ${p[1]}</td>
                    <td style="border: 1px solid #ddd; padding: 10px; text-align: left;">${p[2]}</td>
                </tr>
            </c:forEach>
            <tr>
                <th style="border: 1px solid #ddd; padding: 10px; text-align: left;">Phí vận chuyển</th>
                <th style="border: 1px solid #ddd; padding: 10px; text-align: left;">${shipCost}</th>
            </tr>
            <tr>
                <th style="border: 1px solid #ddd; padding: 10px; text-align: left;">Giảm giá</th>
                <th style="border: 1px solid #ddd; padding: 10px; text-align: left;">-${discount}</th>
            </tr>
            
            <tr>
                <th style="border: 1px solid #ddd; padding: 10px; text-align: left;">Tổng</th>
                <th style="border: 1px solid #ddd; padding: 10px; text-align: left; color: green;">${total}</th>
            </tr>
        </table>
        <div style="text-align: center; margin-top: 20px;">
        <c:if test="${isBank == true}">
        <div style="text-align: center;">
		<img src="https://storage.googleapis.com/image_cnpm/Image_Product/momo2.jpg" style="width: 60%; height:400px; border-radius: 10px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.5); margin-bottom:30px; display:block;margin-left: auto; margin-right: auto;">
		</div>
        </c:if>
	    <input type="submit" value="Xác nhận thanh toán" style="background-color: #4caf50; color: #fff; padding: 12px 20px; border: none; border-radius: 20px; cursor: pointer; font-size: 15px; transition: background-color 0.3s;">
	
	    <a href="home" style="text-decoration: none;">
	        <button type="button" style="background-color: #cc0000; color: #fff; padding: 12px 20px; border: none; border-radius: 20px; cursor: pointer; font-size: 15px; transition: background-color 0.3s;">Hủy thanh toán</button>
	    </a>

</div>

    </div>

</form>

</body>
</html>