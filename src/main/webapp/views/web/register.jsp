<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
</head>
<body style="background-color: #f5f5f5; font-family: Arial, sans-serif;">
    <div style="background-color: #fff; padding: 20px; margin: 20px auto; width: 300px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.2); text-align: center;">
        <div>
            <c:if test="${not empty message}">
                <div style="color: #155724; background-color: #d4edda; border: 1px solid #c3e6cb; padding: 10px; margin-bottom: 10px;">${message}</div>
            </c:if>
            <c:if test="${not empty error}">
                <div style="color: #721c24; background-color: #f8d7da; border:1px solid #f5c6cb; padding: 10px; margin-bottom: 10px;">${error}</div>
            </c:if>
        </div>
        <form action="register" method="post" style="text-align: left;">
            <div class="form-group" style="margin-bottom: 10px;">
                <label for="email" style="font-weight: bold;">Email:</label>
                <input type="text" class="form-control" id="email" name="email" style="width: 100%; padding: 5px;" autocomplete="new-password">
            </div>
            <div class="form-group" style="margin-bottom: 10px;">
                <label for="fullname" style="font-weight: bold;">Full Name:</label>
                <input type="text" class="form-control" id="fullname" name="fullname" style="width: 100%; padding: 5px;" autocomplete="new-password">
            </div>
            <div class="form-group" style="margin-bottom: 10px;">
                <label for="passwd" style="font-weight: bold;">Password:</label>
                <input type="password" class="form-control" id="passwd" name="passwd" style="width: 100%; padding: 5px;" autocomplete="new-password">
            </div>
            <button type="submit" class="btn btn-primary" style="width: 100%; padding: 10px; background-color: #007bff; color: #fff; border: none;">Register</button>
        </form>
    </div>
</body>
</html>
