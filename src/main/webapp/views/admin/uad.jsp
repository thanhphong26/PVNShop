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
    <h1 style="display: inline-block; margin-right: 510px; margin-left: 5px;">Quản lý user</h1>
    

    <form action="/PVNShop/admin_page" style="display: inline-block;">
         <button class="primary-btn" type="submit">Quay lại</button>
    </form>
</div>




</div>

<table  border="1" style="margin-bottom:50px;width: 100%; border-collapse: collapse; margin-top: 20px;">
    <thead style="background-color: #f2f2f2;">
        <th style="padding: 10px; text-align: left;">Username</th>
        <th style="padding: 10px; text-align: left;">Name</th>
        <th style="padding: 10px; text-align: left;">Phone</th>
        <th style="padding: 10px; text-align: left;">Email</th>
        <th style="padding: 10px; text-align: left;">Address</th>
        <th style="padding: 10px; text-align: left;">IsAdmin</th>
        <th style="padding: 10px; text-align: left;">Password</th>
    </thead>
    <tbody>
        <c:forEach var="i" items="${listO}">
            <tr style="border-bottom: 1px solid #ddd;">
                <td style="padding: 10px; text-align: left;">${i.username}</td>
                <td style="padding: 10px; text-align: left;">${i.name}</td>
                <td style="padding: 10px; text-align: left;">${i.phone}</td>
                <td style="padding: 10px; text-align: left;">${i.email}</td>
                <td style="padding: 10px; text-align: left;">${i.address}</td>
                <td style="padding: 10px; text-align: left;">${i.isAdmin}</td>
                <td style="padding: 10px; text-align: left;">${i.password}</td>  
            </tr>
        </c:forEach>
    </tbody>
 
</table>
					


</body>
</html>