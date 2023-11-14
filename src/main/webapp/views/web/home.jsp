<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" style= "width:100%">	
		<tbody>
		<c:forEach var="i" items="${top3}">
			<tr>
				<td><img src= ${i.image }><br>
					<p>${i.productName }</p>
				</td>
				
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>