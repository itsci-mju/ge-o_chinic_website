<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page import="models.* "%>
    <%
    	Logins l = (Logins) session.getAttribute("member");
    	Person p = (Person) session.getAttribute("memberp");
    %>
<!DOCTYPE html>
<html>
<script type="text/javascript"></script>
<style type="text/css">
.navbar-brand {
    padding: 23.5px 20px;อุ่
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

.textlogin{
	color: white;
	margin-bottom: 25px;
}

}
</style>
<!-- Dropdown Menu -->
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


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
         
		          <a class="navbar-brand" href="${pageContext.request.contextPath}/open_home_customer_page""><h2>Go' <em>Clinic</em></h2></a>
		          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
		            <span class="navbar-toggler-icon"></span>
		          </button>

		          <div class="collapse navbar-collapse" id="navbarResponsive">
					            <ul class="navbar-nav ml-auto">
					              <li class="nav-item active">
					                <a class="nav-link" href="${pageContext.request.contextPath}/open_home_customer_page">Home
					                  <span class="sr-only">(current)</span>
					                </a>
					              </li> 
					              <li class="nav-item">
					                <a class="nav-link" href="${pageContext.request.contextPath}/open_services_m_page">Services</a>
					              </li>
					              <li class="nav-item ">
					                <a class="nav-link" href="${pageContext.request.contextPath}/open_about_m_page">About Us</a>
					              </li>
					              <li class="nav-item">
					                <a class="nav-link" href="${pageContext.request.contextPath}/open_contact_m_page">Contact Us</a>
					              </li>
					              <li class="nav-item">
					                <a class="nav-link" href="${pageContext.request.contextPath}/open_edit_profile_page?id=<%=l.getEmail()%>">Edit Profile</a>
					              </li>
					           	</ul>
					           		<div class="col-md-1 ml-auto">
					           			<span class="navbar-text textlogin"><%= p.getFull_name() %></span>
					           			
					           		</div>
					           		 <div class="col-md-3 ml-auto">	
					           			<span class="navbar-text textlogin"><a href="logout">Log Out</a></span>
					           		</div>
           	            </div>
                    </div>
      </nav>
    </header>
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>
</html>