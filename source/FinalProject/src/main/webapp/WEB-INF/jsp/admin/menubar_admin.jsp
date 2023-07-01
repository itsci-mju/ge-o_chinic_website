<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="org.itsci.models.* "%>
    <%
    	Logins a = (Logins) session.getAttribute("admin");
    %>
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
          <li><b><a href="${pageContext.request.contextPath}/open_home_admin_page" class=" nav-link px-2 text-white">Home</a></b></li>
          
          <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle text-white" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Service</a>
          <ul class="dropdown-menu bg-dark">
            <li><a href="${pageContext.request.contextPath}/open_add_service_page" class="nav-link px-2 text-white ">Add Service</a></li>
         	<li><a href="${pageContext.request.contextPath}/open_list_service_page" class="nav-link px-2 text-white">List Service</a></li>
          </ul>
       	  </li>
       	  <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle text-white" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Staff</a>
          <ul class="dropdown-menu bg-dark">
            <li><a href="${pageContext.request.contextPath}/open_add_staff_page" class="nav-link px-2 text-white">Add Staff</a></li>
          	<li><a href="${pageContext.request.contextPath}/open_list_staff_page" class="nav-link px-2 text-white">List Staff</a></li>
          </ul>
       	  </li>
          
        </ul>

		<div class="text-end navbar-right"><span class="nav-link px-4 text-white"><%= a.getEmail() %></span></div>
        <div class="text-end navbar-right"><a class="btn btn-warning" href="logout" role="button">Log Out</a></div>
    
      </div>
    </div>
    
    
  </header>
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>
</html>