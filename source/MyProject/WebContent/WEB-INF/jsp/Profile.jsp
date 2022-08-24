<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.*,itsci.controller.spring.*" %>
    <%  Logins log = (Logins) session.getAttribute("list_log");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
My Profile </br> 
 =================== </br> 
	Username :${emp_username}<br>
	Fullname :<%= log.getFullname()%><br>
	Gender	:<%= log.getGender()%><br>
	Image : <img src="img/<%=log.getImage() %>" width="100px">
</body>
</html>