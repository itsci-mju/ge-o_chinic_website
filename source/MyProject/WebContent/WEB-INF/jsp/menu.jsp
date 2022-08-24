<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page import="utils.Manager,java.util.*,model.*,servlet.*" %>
    <%
    	Manager m = new Manager();
    	Menu mm = new Menu();
    	List<Menu> menus = m.getMenus();
 		List<Menu> list = (List<Menu>)request.getAttribute("result");
    	List<Category> c = m.getCategory();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Memu</title>
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
    integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
    crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
    integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
    crossorigin="anonymous"></script>
<script
    src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
    integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
    crossorigin="anonymous"></script>
<script
    src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
    integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
    crossorigin="anonymous"></script>
    
    
</head>
<body>

<form action="${pageContext.request.contextPath}/openSearchMenu" method="post">
<jsp:include page="MuneBar.jsp" />
<input type="text" name="st" value=""><input type="submit" name="search" value="ค้นหา"><br>
</form>	
	<table class="table table-bordered" border="1">
			<tr>
				<td>ID</td>
				<td>Name</td>
				<td>Price</td>
				<td>img</td>
			</tr>
			<%if(list != null){ %>
			<%for(Menu ms : list){ %>
				<tr>
					<td><%= ms.getMenuid()%></td>
					<td><%= ms.getMenuName()%></td>
					<td><%= ms.getPrice()%></td>
					<td><img src="img/<%=ms.getImage() %>" width="100px"></td>
					<td>
						<a href="${pageContext.request.contextPath}/openEditMenus?id=<%= ms.getMenuid()%>"><input type ="submit" value="แก้ไข" class="button"></a>
						<a href="${pageContext.request.contextPath}/Del?id=<%= ms.getMenuid()%>"><input type ="submit" value="ลบ" class="buttone" onclick="return confirm('แน่ใจหรือไม่ว่าจะลบ')"></a>
					</td>
				</tr>
			<%} %>
			<%} %>	
	</table>
<jsp:include page="Footer.jsp" />
</body>
</html>