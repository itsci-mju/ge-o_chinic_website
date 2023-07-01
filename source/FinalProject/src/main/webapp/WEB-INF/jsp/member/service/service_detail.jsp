<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
   <head>
      <meta charset="utf-8">
      <title>Service Detail</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>

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
  href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.1.0/mdb.min.css"
  rel="stylesheet"
/>

<!-- MDB -->
<script
  type="text/javascript"
  src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.1.0/mdb.min.js"
></script>

      <meta name="viewport" content="width=device-width, initial-scale=1.0">
   </head>
 <body onload="message()" background="">

	 <jsp:include page="../menubar_member.jsp" />
<section class="vh-100" style="background-color: #D4D4D4;">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col col-xl-10">
        <div class="card" style="border-radius: 1rem;">
          <div class="row g-0">
          
          
            <div class="col-md-5">
			  <img src="<%=request.getContextPath()%>/img/${services.image}"
			    alt="login form" class="img-fluid" style="border-radius: 1rem 0 0 1rem; width: 100%; height: 100%;" />
			</div>
            
            
            <div class="col-md-6 row ">
              <div class="card-body p-4 p-lg-5 text-black m-5">

                  <div class="d-flex align-items-center mb-3 pb-1">
                    <i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
                    <span class="h1 fw-bold mb-0">${services.serviceName}</span>
                  </div>
                  	<div class="row d-flex flex-column mb-4">
					    <div class="mb-4">
					     <span  class="h5 fw-bold">ประเภท : </span> 
		                  <label class="col-md-3">${services.servicetype.service_type}</label>
					    </div>
						<div class="mb-4">
		                    <label class="col-md-4 fw-bold">รายละเอียด : </label><br>
		                    <label class="col-md-12">${services.serviceDetail}</label>
		                </div>
		                <div class="mb-4">
		                    <label class="col-md-4 fw-bold">ราคา : </label>
		                    <label class="col-md-3">${services.price}</label>
		                </div>
                  </div>
					  
              </div>
              		<div class="mb-4 justify-content-end " style="width:100%; text-align:right;">
					   <a href="${pageContext.request.contextPath}/open_services_m_page" class="btn btn-danger btn-lg m-1" type="submit" >ยกเลิก</a>
					   <a href="register_service_page?id=${services.service_id}" class="btn btn-success btn-lg m-1" type="submit" onclick="return confirm('คุณต้องการดำเนินการต่อหรือไม่?')">ดำเนินการต่อ</a>
					 </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
 <jsp:include page="../../footer.jsp" />
</body>
</html>