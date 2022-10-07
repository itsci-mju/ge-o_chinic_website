<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<script type="text/javascript"></script>
<style type="text/css">
    .navbar-brand {
        padding: 23.5px 20px;
        font-size: 18px
    }

    .navbar-nav {
        width: 100%
    }

    .navbar-brand {
        padding: 23.5px 20px;
        font-size: 18px
    }

    .navbar-nav {
        width: 100%
    }

    .nav-item {
        padding: 20px 8px;
        margin: 0px 3px;
        text-align: center;
        border-radius: 5px;
        font-size: 16px;
        color: grey;
        position: static
    }

    }
</style>

<link rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Additional CSS Files  -->
<link rel="stylesheet" href="css/fontawesome.css">
<link rel="stylesheet" href="css/templatemo-sixteen.css">
<link rel="stylesheet" href="css/owl.css">

<body>
<!-- Header -->
<header class="">
    <nav class="navbar navbar-expand-lg">
        <div class="container">
            <a class="navbar-brand"
               href="${pageContext.request.contextPath}/open_home_customer_page"><h2>
                Go' <em>Clinic</em>
            </h2></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse"
                    data-target="#navbarResponsive" aria-controls="navbarResponsive"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="${pageContext.request.contextPath}/open_home_customer_page">Home<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/open_services_c_page">Services</a>
                    </li>
                    <security:authorize access="hasRole('ADMIN')">
                    <li class="nav-item ">
                        <a class="nav-link" href="${pageContext.request.contextPath}/open_add_service_page">Add Service</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/open_list_service_page">List Service</a>
                    </li>
                    <li class="nav-item ">
                        <a class="nav-link" href="${pageContext.request.contextPath}/open_add_staff_page">Add Staff</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/open_list_staff_page">List Staff</a>
                    </li>
                    </security:authorize>
                    <li class="nav-item ">
                        <a class="nav-link" href="${pageContext.request.contextPath}/open_about_c_page">About Us</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/open_contact_page">Contact Us</a>
                    </li>
                    <security:authorize access="hasRole('MEMBER')">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/open_edit_profile_page?id=xxx">Edit Profile</a>
                    </li>
                    </security:authorize>
                    <security:authorize access="!isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/open_Login_page">
                            <ion-icon name="person-outline"></ion-icon>Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/open_Registers_page">
                        <ion-icon name="create"></ion-icon>Register</a>
                    </li>
                    </security:authorize>
                    <security:authorize access="isAuthenticated()">
                        <li>
                            <form:form action="${pageContext.request.contextPath}/logout" method="POST" name="frmLogout"></form:form>
                            <security:authentication property="principal.username" />
                            <a class="nav-link" onclick="javascript: frmLogout.submit();"><ion-icon name="person-outline"></ion-icon>Logout</a>
                        </li>
                    </security:authorize>
                </ul>
            </div>
        </div>
    </nav>
</header>
<script type="module"
        src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule
        src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>

</body>
</html>