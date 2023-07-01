<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="org.itsci.models.* "%>
    <%
    	Person m = (Person) session.getAttribute("memberp");
    %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<script type="text/javascript"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>

<body>
	<!-- Header -->

	
	<header class="p-3 bg-dark text-white">
    <div class="container">
      <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">

        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
          <li><a href="${pageContext.request.contextPath}/open_home_member_page" class="nav-link px-2 text-secondary">Home</a></li>
          <li><a href="${pageContext.request.contextPath}/open_services_m_page" class="nav-link px-2 text-white">Services</a></li>
          <li><a href="${pageContext.request.contextPath}/open_list_rigister_service_page?id=<%= m.getLogins().getEmail() %>" class="nav-link px-2 text-white">Appionments</a></li>
          <li><a href="${pageContext.request.contextPath}/open_succeed_appionment_page?id=<%= m.getLogins().getEmail() %>" class="nav-link px-2 text-white">Appionments Succeed</a></li>
          <li><a href="${pageContext.request.contextPath}/open_edit_profile_page?id=<%= m.getLogins().getEmail() %>" class="nav-link px-2 text-white">Edit Profile</a></li>
        </ul>


		<div class="text-end navbar-right"><span class="nav-link px-4 text-white"><%= m.getFull_name() %></span></div>
        <div class="text-end navbar-right"><a class="btn btn-warning" href="logout" role="button">Log Out</a></div>
      </div>
    </div>
  </header>

</body>
</html>