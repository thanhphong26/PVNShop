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
<div style="margin:30px 0px; display: flex; justify-content: space-around; border">

        <div style="text-align: center;border-radius: 15px;vertical-align: middle; margin:20px;  background-color:#DDDDDD; height:100px; width:200px;padding:20px">
            <div>
                <img src="//bizweb.dktcdn.net/thumb/icon/100/372/934/themes/892516/assets/img_poli_1.png?1699981552912" alt="Sản phẩm chính hãng" decoding="async">
            </div>
            <div> 
                Sản phẩm chính hãng
            </div>
        </div>

        <div style="text-align: center;border-radius: 15px;vertical-align: middle; margin:20px;  background-color:#DDDDDD; height:100px; width:200px;padding:20px">
            <div>
                <img src="//bizweb.dktcdn.net/thumb/icon/100/372/934/themes/892516/assets/img_poli_2.png?1699981552912" alt="Chất lượng cam kết" decoding="async">
            </div>
            <div> 
                Chất lượng cam kết
            </div>
        </div>

        <div style="text-align: center;border-radius: 15px;vertical-align: middle; margin:20px;  background-color:#DDDDDD; height:100px; width:200px;padding:20px">
            <div>
                <img src="//bizweb.dktcdn.net/thumb/icon/100/372/934/themes/892516/assets/img_poli_3.png?1699981552912" alt="Dịch vụ vượt trội" decoding="async">
            </div>
            <div> 
                Dịch vụ vượt trội
            </div>
        </div>

        <div style="text-align: center;border-radius: 15px;vertical-align: middle; margin:20px;  background-color:#DDDDDD; height:100px; width:200px;padding:20px">
            <div>
                <img src="//bizweb.dktcdn.net/thumb/icon/100/372/934/themes/892516/assets/img_poli_4.png?1699981552912" alt="Giao hàng nhanh chóng" decoding="async">
            </div>
            <div> 
                Giao hàng nhanh
            </div>
        </div>

    </div>
    <h1>Danh mục sản phẩm nổi bật</h1>
    <div style="margin:30px 0px; display: flex; justify-content: space-around;border-radius: 15px;background-color:#770000	;  width:1200px;">
		
        <div style="text-align: center;border-radius: 15px;vertical-align: middle; margin:20px;  background-color:white; height:100px; width:200px;padding:20px">
            <div>
                <img  src="//bizweb.dktcdn.net/thumb/small/100/372/934/collections/icon-laptop-van-phong.png?v=1668399644103" decoding="async" style="width: 45px; height: 40px;">
            </div>
            <div> 
                Latop Mỏng Nhẹ
            </div>
        </div>

        <div style="text-align: center;border-radius: 15px;vertical-align: middle; margin:20px;  background-color:white; height:100px; width:200px;padding:20px">
            <div>
                <img src="//bizweb.dktcdn.net/thumb/small/100/372/934/collections/7414346.png?v=1667628515297" decoding="async" style="width: 45px; height: 40px;">
            </div>
            <div> 
                Laptop Gaming
            </div>
        </div>

        <div style="text-align: center;border-radius: 15px;vertical-align: middle; margin:20px;  background-color:white	; height:100px; width:200px;padding:20px">
            <div>
                <img src="//bizweb.dktcdn.net/thumb/small/100/372/934/collections/icon-laptop-content-creator.png?v=1668399779423" decoding="async" style="width: 45px; height: 40px;">
            </div>
            <div> 
                Latop Thiết kế Đồ họa
            </div>
        </div>

        <div style="text-align: center;border-radius: 15px;vertical-align: middle; margin:20px;  background-color:white; height:100px; width:200px;padding:20px">
            <div>
                <img src="//bizweb.dktcdn.net/thumb/small/100/372/934/collections/lcd.png?v=1667057124600" alt="Giao hàng nhanh chóng" decoding="async" style="width: 45px; height: 40px;">
            </div>
            <div> 
                Laptop Doanh Nhân
                
            </div>
        </div>

    </div>
	<div style="margin:30px 0px;border-radius: 15px;background-color:#CC0000;  width:1200px">
	<h1 style=" padding-top:20px;padding-left:20px;color:white" >Best Seller <span style="padding-left:250px;color: #DDDDDD; font-size:14px">Cam kết giá tốt nhất thị trường</span></h1>
	<table style= "width:100%; height:300px; text-align: center;border-collapse: separate; border-spacing: 20px;" >	
		<tbody>
		<tr>
		<c:forEach var="i" items="${top3}">
			
				<td style="border-radius: 15px;vertical-align: middle; margin:20px;  background-color:white; ">
				<a><img style="width: 200px; height: 150px;" src= ${i.image }></a><br>		
					<a><p style="margin-top:30px; font-weight: bold; font-size: 15px;">${i.productName }</p></a>
				</td>
				
			
		</c:forEach>
		</tr>
		
		</tbody>
	</table>
	</div>
	<div style="margin:30px 0px; border-radius: 15px;background-color:#CC0000;  width:1200px">
	<h1 style=" padding-top:20px;padding-left:20px;color:white" >Đánh giá cao </h1>
	<table style= "width:100%; height:300px; text-align: center;border-collapse: separate; border-spacing: 20px;" >	
		<tbody>
		<tr>
		<c:forEach var="i" items="${topr3}">
			
				<td style="border-radius: 15px;vertical-align: middle; margin:20px;  background-color:white; ">
				<a><img style="width: 200px; height: 150px;" src= ${i.image }><br></a>
					<a><p style="margin-top:30px; font-weight: bold; font-size: 15px;">${i.productName }</p></a>
					
				</td>
				
			
		</c:forEach>
		</tr>
		
		</tbody>
	</table>
	</div>
	<div style=" margin:30px 0px; border-radius: 15px;background-color:#BBBBBB;  width:1200px">
	<h1 style=" padding-top:20px;padding-left:20px;color:white" >Đánh giá gần đây </h1>
	<table style= "width:100%; height:200px; text-align: center;border-collapse: separate; border-spacing: 20px;" >	
		<tbody>
		<tr style="">	
		<c:forEach var="i" items="${toprate3}">
			
				<td style="position: relative;border-radius: 15px; margin:20px;  background-color:white; ">
				<a><img style="width: 40px; height: 40px; position: absolute; top: 20px; left: 20px;" src="   https://cdn-icons-png.flaticon.com/512/3001/3001758.png " ><br></a>
				<p style="position: absolute; top: 30px; left:80px; font-weight: bold; font-size: 15px;">${ i.context}</p>
			
					<p style="width:300px; margin:20px 20px;margin-top:40px; font-style:italic; font-size: 15px;">"${i.username }"</p>
					
				</td>
				
			
		</c:forEach>
		</tr>
		
		</tbody>
	</table>
	</div>
</body>
</html>