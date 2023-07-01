<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Services</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>

<style type="text/css">
img{
height: 300px;
width: 300px;
}
</style>

<style type="text/css">
@import url('https://fonts.googleapis.com/css2?family=Prompt:ital,wght@1,500;1,900&family=Roboto:ital,wght@1,900&display=swap');
</style>
<!-- CSS -->
<link href="css/background_html" rel="stylesheet">
</head>
<body>
<jsp:include page="../menubar_member.jsp" />
<div class="backgrounds_html">
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
			<div class="container py-5">
			  <div class="col-md-12 mb-4 mb-lg-0">
			    <div class="row row-cols-md-4 g-4">
			     
					<c:forEach items="${ListServices}" var="Services">
			
				
			  			<div class="col-md-3 p-1">
					        <div class="card text-black">
					          <img src="<%=request.getContextPath()%>/img/${Services.image}"class="card-img-top" alt=""/>
					          <div class="card-body">
					            <div class="text-center mt-1">
					              <h4 class="card-title">${Services.serviceName}</h4>
					            </div>
					
					            <div class="text-center">
					              <div class="p-3 mx-n3 mb-4" style="background-color: #eff1f2;">
					                <h5 class="mb-0">รายละเอียด</h5>
					              </div>
					
					              <div class="d-flex flex-column text-start mb-3">
					              	<p>ประเภท : ${Services.servicetype.service_type}</p>
					                <p>${Services.serviceDetail}</p>
					                <h6 class="text-primary mb-1 pb-3">ราคา : ${Services.price}</h6>
					              </div>
					            <div class="d-flex flex-row">
					              <!-- <button type="button" class="btn btn-danger flex-fill ms-1">Buy now</button> -->
					              
								  <a href="open_register_service_page?id=${Services.service_id}" class="flex-fill ms-1"><button type="submit" class="btn btn-danger ">Buy now</button></a>
					            </div>
					          </div>
					        </div>
					      </div>
						</div>
					</c:forEach>
				</div>
				</div>
				</div>	

			</div>
</div>
 <jsp:include page="../../footer.jsp" />
    <script>
      const choices = new Choices('[data-trigger]',
      {
        searchEnabled: false,
        itemSelectText: '',
      });

    </script>
	
</body>
</html>