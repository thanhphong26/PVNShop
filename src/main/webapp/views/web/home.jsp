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
	<table border="1" style= "width:100%">	
		<tbody>
		<tr>
		<c:forEach var="i" items="${top3}">
			
				<td><img src= ${i.image }><br>
					<p>${i.productName }</p>
				</td>
				
			
		</c:forEach>
		</tr>
		</tbody>
	</table>
</body>
</html>