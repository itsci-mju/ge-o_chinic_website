<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<nav class="navbar navbar-expand-lg navbar-dark  " style="background-color: #B36CFF;">
  <a class="navbar-brand" href="${pageContext.request.contextPath}/openHome">Home</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">

      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/openMenus">Menu</a>
      </li>
    </ul>
    <span class="navbar-text">
      <a class="nav-link" href="${pageContext.request.contextPath}/openProfile">My Profile</a>
    </span>
  </div>
</nav>
</body>
</html>