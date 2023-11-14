<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="author" content="Untree.co">
<title><decorator:title default="Trang chủ" /></title>
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">
<link href='<c:url value="/templates/web/css/slick.css"/>'
	rel="stylesheet" />
<link href='<c:url value="/templates/web/css/bootstrap.min.css"/>'
	rel="stylesheet" />
<link href='<c:url value="/templates/web/css/slick-theme.css"/>'
	rel="stylesheet" />
<link href='<c:url value="/templates/web/css/nouislider.min.css"/>'
	rel="stylesheet" />
<link href='<c:url value="/templates/web/css/style.css"/>'
	rel="stylesheet" />
<link rel="stylesheet" href='<c:url value="css/font-awesome.min.css"/>'>
</head>
<body>
	<%@ include file="/common/web/header.jsp"%>
	<div class="container">
		<decorator:body></decorator:body>
	</div>
	<%@ include file="/common/footer.jsp"%>
	<script src="<c:url value="/templates/web/js/jquery.min.js"/>"></script>
	<script src="<c:url value="/templates/web/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/templates/web/js/slick.min.js"/>"></script>
	<script src="<c:url value="/templates/web/js/nouislider.min.js"/>"></script>
	<script src="<c:url value="/templates/web/js/jquery.zoom.min.js"/>"></script>
	<script src="<c:url value="/templates/web/js/main.js"/>"></script>
	
</body>
</html>