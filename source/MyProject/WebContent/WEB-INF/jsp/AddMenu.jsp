<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="utils.Manager,java.util.*,model.*" %>
    <%
    	Manager m = new Manager();
    	List<Category> c = m.getCategory();
    	int id = m.getMaxIdMenu()+1;
    %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function validate(frm) {
 	var Name = /^[ก-์A-Za-z0-9 ]{1,50}$/;
 	var Price = /^[0-9.]+$/;
 	if(!Name.test(frm.nameMenu.value)){
 		alert("กรุณากรอกชื่อแอปให้ถูกต้อง ด้วยภาษาไทย ภาษาอังกฤษ และตัวเลข เท่านั้น");
 		frm.nameMenu.focus();
 		return false;

 	}if(!Price.test(frm.priceMenu.value)){
 		alert("กรุณากรอกราคา");
 		frm.priceMenu.focus();
 		return false;
 	}
 	
 	
}
</script>
<meta charset="UTF-8">
<title>Addmenu</title>
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
<jsp:include page="MuneBar.jsp" />
<label>${message}</label>
	<form name="frm" method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/openAddmenu">
	ID : <input type="text" name="idmenu" value="<%= id %>" ReadOnly><br> 
	Name : <input type="text" name="nameMenu"><br>
	Price : <input type="text" name="priceMenu"><br>
	Category : <select name="CategoryMenu">
					<% for(Category cm : c){ %>
						<option value="<%= cm.getCategoryid() %>"><%= cm.getCategoryName() %></option>
					<%} %>
				</select><br>
	Upload : <input type="file" name="profile_pic"> </br></br>
	<button type="submit" name="AddMenu" value="Add Menu" onclick = "return validate(frm)">Add Menu</button><br>  
	</form>
</body>
</html>