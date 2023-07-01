<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
   <head>
      <meta charset="utf-8">
      <title>Add Service Page</title>
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
      <link rel="stylesheet" href="style.css">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      
<!-- Font Awesome -->
<link
  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
  rel="stylesheet"
/>
<!-- Google Fonts -->
<link
  href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
  rel="stylesheet"
/>
<!-- MDB -->
<link
  href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.2.0/mdb.min.css"
  rel="stylesheet"
/>
<style type="text/css">
@import url('https://fonts.googleapis.com/css2?family=Prompt:ital,wght@1,500;1,900&family=Roboto:ital,wght@1,900&display=swap');
</style>

<link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet" />

<script src="https://kit.fontawesome.com/8e4d971ffd.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body style="background-color: #D4D4D4">
<jsp:include page="../menubar_admin.jsp" />

 <div class="container ">
<div style="position : absolute; top : 120px;" class="col-sm-8 bg-light-subtle card">
	<div class="m-3">
		<h2>Edit Service </h2>
		<form name="frm" enctype="multipart/form-data" action="${pageContext.request.contextPath}/edit_service_page" method="POST">
			<div class="row">
				<div class="col">
				
					<div class="form-outline mb-3">
	                    <input type="text" name="name_service" class="form-control form-control-lg" value="${services.serviceName}"/>
	                    <label class="form-label" for="name_service">ชื่อบริการ</label>
	                </div>
	                
				</div>
				
				<div class="col">
					<div class="form-outline mb-3">
					  <input class="form-control form-control-lg" type="file" id="name_img" name="name_img" value="<%=request.getContextPath()%>/img/${services.image}">
					</div>
				</div>
				
			</div>
			<div class="row">
				<div class="col">
					<div class="form-outline mb-3">
						<textarea name="service_detail" class="form-control form-control-lg" >${services.serviceDetail}</textarea>
           			 	<label class="form-label" for="service_detail" >รายละเอียด</label>
           			 	
					</div>
				</div>
				
				<div class="col">
					<div class="form-outline mb-3">			
						<select class="form-select" id="servicetype" name="servicetype">
							<c:forEach items="${servicetype}" var="Servicetype">
								<option value="${Servicetype.servicetype_id}" <c:if test="${services.servicetype.servicetype_id == Servicetype.servicetype_id}">selected</c:if>>${Servicetype.service_type}</option>
							</c:forEach> 
						</select>
					</div>
					<div class="form-outline mb-3">
						<select class="form-select" id="expertise" name="expertise">
							<c:forEach items="${expertise}" var="Expertise">
								<option value="${Expertise.expertise_id}" <c:if test="${services.expertise.expertise_id == Expertise.expertise_id}">selected</c:if>>${Expertise.expertise_name}</option>
							</c:forEach> 
						</select>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-6">
					<div class=" mb-3">
						<label class="form-label" for="serive_price">ราคา :</label> 
	                </div>
	                <div class=" mb-3">
	                	<input type="text" name="serive_price" class="form-control form-control-lg" value="${services.price}"/>
	                </div>
				</div>
				<div class="col">
					<div class="form-outline mb-3">
	                </div>
				</div>
			</div>
			<div class="d-flex justify-content-end">
				<button class="btn btn-success btn-lg m-1" type="submit" value="submit" onclick="validate(frm)">บันทึก</button>
				<a href="${pageContext.request.contextPath}/open_list_service_page"><button class="btn btn-danger btn-lg m-1" type="reset" value="reset" >ยกเลิก</button></a>
			</div>
		</form>
	</div>
</div>
</div>
    <!-- MDB -->
	<script
	  type="text/javascript"
	  src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.1.0/mdb.min.js"
	></script>
</body>
</html>