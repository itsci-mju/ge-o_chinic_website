<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Services</title>
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

<style type="text/css">
@import url('https://fonts.googleapis.com/css2?family=Prompt:ital,wght@1,500;1,900&family=Roboto:ital,wght@1,900&display=swap');
</style>
</head>
<body>
<div class="pb-5 mt-5">
    <div class="container">
      <div class="row">
        <div class="col-lg-12 p-3 bg-white rounded shadow-sm">
        <form name="frm" action="${pageContext.request.contextPath}/SreachServices" method="POST">
                <div class="input-group container mt-3 mb-3">
                    <input type="text" class="form-control py-2 border-right-0 border" name="search" id="search" placeholder="Search"> <span class="input-group-append">
                        <div class="input-group-text">
                            <i class="fa fa-search"></i>
                        </div>
                    </span>
                </div>
        </form>	
		</div>
	</div>
</div>
	<div class="pb-5 mt-2">
    <div class="container">
      <div class="row">
        <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">
		<table class="table table-bordered searchable sortable table.sortable " border="1">
			<thead class="text-center font-weight-bold">
			<tr>
				<th scope="col">img</th>
				<th scope="col">Name</th>
				<th scope="col">Detail</th>
				<th scope="col">CategoryName</th>
				<th scope="col">Price</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${ListServices}" var="Services">
			<tr>
				<td><img class="center" src="../assets/img/${Services.image}" width="100px" height="100px"></td>
				<td>${Services.serviceName}</td>
				<td>${Services.serviceDetail}</td>
				<td>${Services.servicetype.service_type}</td>
				<td>${Services.price}</td>
				
			</tr>
			</c:forEach>
			</tbody>
		</table>
		</div>
	  </div>
    </div>
</div>
</div>
    <script>
      const choices = new Choices('[data-trigger]',
      {
        searchEnabled: false,
        itemSelectText: '',
      });

    </script>
	
</body>
</html>