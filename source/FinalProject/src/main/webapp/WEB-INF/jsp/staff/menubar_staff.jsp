<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <!-- <%@ page import="org.itsci.utils.models.* "%> --> 
   <%
    	Person s = (Person) session.getAttribute("staffp");
    %> 
<%@ page import="org.itsci.models.Person" %>
<%@ page import="org.itsci.models.Logins" %>
<!DOCTYPE html>
<html>
<body>

<!-- Header -->
 	<header class="p-3 bg-dark text-white">
      <div class="container">
      <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
		
        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
          <li><b><a href="${pageContext.request.contextPath}/open_home_staff_page" class=" nav-link px-2 text-secondary">Home</a></b></li>
            <li><a href="${pageContext.request.contextPath}/open_List_confirm_payment_page" class="nav-link px-2 text-white ">Confirm Payment</a></li>
         	<li><a href="${pageContext.request.contextPath}/open_list_appionment_page" class="nav-link px-2 text-white">List Appiontment</a></li>
         	<li><a href="${pageContext.request.contextPath}/open_succeed_appionment" class="nav-link px-2 text-white">List Succeed Appiontment</a></li>
        </ul>
			<div class="text-end navbar-right"><span class="nav-link px-4 text-white"><%= s.getFull_name() %></span></div>
			<div class="text-end navbar-right"><a class="btn btn-warning" href="logout" role="button">Log Out</a></div>
         </div>
        </div>

    
    </header>
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>
</html>