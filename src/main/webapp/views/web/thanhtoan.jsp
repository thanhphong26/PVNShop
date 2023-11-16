<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thông tin thanh toán</title>
</head>
<body>

    <div style="max-width: 700px; margin: 40px auto; padding: 20px; background-color: #ededed; border-radius: 10px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); border: 3px solid #000000;">

     <form action="xacnhanthanhtoan" method="post" style="display: grid; gap: 15px;">

            <h2 style="text-align: center; color: #333; font-size: 24px;">Thông tin thanh toán</h2>

            <div style="display: grid; gap: 10px;">
                <label style="font-weight: bold; color: #555;">Họ và tên</label>
                <input type="text" value="${u[0]}" style="width: 100%; padding: 10px; border: 1px solid #ddd; border-radius: 5px; box-sizing: border-box;" readonly>
            </div>

            <div style="display: grid; gap: 10px;">
                <label style="font-weight: bold; color: #555;">Địa chỉ</label>
                <input type="text" value="${u[1]}" style="width: 100%; padding: 10px; border: 1px solid #ddd; border-radius: 5px; box-sizing: border-box;" required>
            </div>

            <div style="display: grid; gap: 10px;">
                <label style="font-weight: bold; color: #555;">Số điện thoại</label>
                <input type="text" value="${u[2]}" style="width: 100%; padding: 10px; border: 1px solid #ddd; border-radius: 5px; box-sizing: border-box;" required>
            </div>

            <div style="display: grid; gap: 10px;">
                <label style="font-weight: bold; color: #555;">Email</label>
                <input type="email" value="${u[3]}" style="width: 100%; padding: 10px; border: 1px solid #ddd; border-radius: 5px; box-sizing: border-box;" readonly>
            </div>

            <div style="display: grid; gap: 10px;">
                <label style="font-weight: bold; color: #555;">Phương thức thanh toán</label>
                <select name="paymentMethod" style="width: 100%; padding: 10px; border: 1px solid #ddd; border-radius: 5px; cursor: pointer; box-sizing: border-box;">
                    <option value="bank">Thanh toán trực tuyến</option>
                    <option value="direct">Thanh toán trực tiếp</option>
                </select>
            </div>

            <div style="display: grid; gap: 10px;">
                <label style="font-weight: bold; color: #555;">Phương thức vận chuyển</label>
                <select name="shipMethod" style="width: 100%; padding: 10px; border: 1px solid #ddd; border-radius: 5px; cursor: pointer; box-sizing: border-box;">
                    <option value="express">Giao hàng nhanh</option>
                    <option value="standard">Giao hàng tiêu chuẩn</option>
                </select>
            </div>
            
            <div style="display: grid; gap: 10px;">
                <label style="font-weight: bold; color: #555;">Mã giảm giá</label>
                <select name="discount" style="width: 100%; padding: 10px; border: 1px solid #ddd; border-radius: 5px; cursor: pointer; box-sizing: border-box;">
		        <option value="None" style="padding: 10px; background-color: #f5f5f5; border: 1px solid #ddd; border-radius: 5px; cursor: pointer; box-sizing: border-box; font-size: 14px;">
		                None
		            </option>
		        <c:forEach var="dis" items="${discount}">
		            <option value="${dis[0]}" style="padding: 10px; background-color: #f5f5f5; border: 1px solid #ddd; border-radius: 5px; cursor: pointer; box-sizing: border-box; font-size: 14px;">
		                Mã giảm ${dis[1]*100}% (Giảm tối đa ${dis[2]}, thời hạn còn ${dis[3]} ngày)
		            </option>
		        </c:forEach>
    		</select>
            </div>
            <div style="display: grid; gap: 10px;">
                <label style="font-weight: bold; color: #555;">Ghi chú</label>
                <input type="text" name="note" style="width: 100%; padding: 10px; border: 1px solid #ddd; border-radius: 5px; box-sizing: border-box;">
            </div>

            <input type="submit" value="Xác nhận thông tin" style="background-color: #000000; color: white; cursor: pointer; width: 100%; padding: 10px; border: none; border-radius: 5px; transition: background-color 0.3s; box-sizing: border-box;">
			
        </form>

    </div>


</body>
</html>




