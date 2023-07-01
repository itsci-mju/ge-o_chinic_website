<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
          <li><a href="${pageContext.request.contextPath}/open_home_customer_page" class="nav-link px-2 text-secondary">Home</a></li>
          <li><a href="${pageContext.request.contextPath}/open_services_c_page" class="nav-link px-2 text-white">Services</a></li>
        </ul>


        <div class="text-end navbar-right">
          <a class="btn btn-outline-light me-2" href="${pageContext.request.contextPath}/open_Login_page" role="button">Login</a>
          <a class="btn btn-warning" href="${pageContext.request.contextPath}/open_Registers_page" role="button">Sign-up</a>
        </div>
      </div>
    </div>
  </header>

</body>
</html>