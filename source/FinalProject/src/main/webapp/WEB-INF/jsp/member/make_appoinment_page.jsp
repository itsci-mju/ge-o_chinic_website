<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ page import="org.itsci.models.* "%>
    <%
    	Person m = (Person) session.getAttribute("memberp");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Make Appionment Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
<style>
    #footer {
        position: fixed;
        bottom: 0px;
        left: 0px;
        padding: 10px;
        text-align: center;
        width: 100%;
        color: white;
    }
</style>
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
<style type="text/css">
.gradient-custom {
/* fallback for old browsers */
background: #D4D4D4;

.card-registration .select-input.form-control[readonly]:not([disabled]) {
font-size: 1rem;
line-height: 2.15;

padding-left: .75em;
padding-right: .75em;
}
.card-registration .select-arrow {
top: 13px;
}
</style>

<script>
    function message() {
      var message = "${message}";
      if(message!=""){
          alert(message);
      }
    }
</script>
<script type="text/javascript">
<script>
// สร้างอ็อบเจ็กต์ Date ของวันที่ปัจจุบัน
var currentDate = new Date();

// ตรวจสอบว่าวันที่เป็นวันอาทิตย์หรือไม่
function isSunday(date) {
  return date.getDay() === 0; // 0 หมายถึงวันอาทิตย์
}

// กำหนดฟังก์ชันให้เรียกตอนเปลี่ยนค่าใน input
document.getElementById("dateInput").addEventListener("input", function () {
  var selectedDate = new Date(this.value);

  // ตรวจสอบวันที่ที่ผู้ใช้เลือก
  if (isSunday(selectedDate)) {
    alert("ไม่สามารถเลือกวันอาทิตย์ได้");
    this.value = ""; // ล้างค่าวันที่
  }
});

// ตรวจสอบและป้องกันให้ไม่สามารถเลือกวันอาทิตย์ในวันที่ปัจจุบัน
if (isSunday(currentDate)) {
  document.getElementById("dateInput").setAttribute("min", getNextMonday(currentDate));
}

// ฟังก์ชันเพื่อหาวันจันทร์ถัดไป
function getNextMonday(date) {
  var nextMonday = new Date(date);
  nextMonday.setDate(date.getDate() + ((1 + 7 - date.getDay()) % 7)); // หาวันจันทร์ของสัปดาห์ถัดไป
  return nextMonday.toISOString().split("T")[0]; // ให้คืนค่าเป็นวันที่ในรูปแบบ YYYY-MM-DD
}
</script>
</script>
      <meta name="viewport" content="width=device-width, initial-scale=1.0"> <style type="text/css">
@import url('https://fonts.googleapis.com/css2?family=Prompt:ital,wght@1,500;1,900&family=Roboto:ital,wght@1,900&display=swap');
</style>

<link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet" />

<script src="https://kit.fontawesome.com/8e4d971ffd.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

     <!-- Additional CSS Files  -->
    <link rel="stylesheet" href="css/fontawesome.css">
    <link rel="stylesheet" href="css/templatemo-sixteen.css">
    <link rel="stylesheet" href="css/owl.css">
    
 <style>
  .label {
    font-family: Arial, sans-serif;
    font-size: 16px;
    font-weight: bold;
    color: #333;
    /* และคุณสามารถปรับแต่งคุณสมบัติอื่น ๆ ตามต้องการ */
  }
</style>  
<script>
  function validateForm() {
    var selectedDate = document.querySelector('input[name="date_app"]').value;
    var selectedTime = document.querySelector('.form-select').value;

    if (selectedDate === '') {
      alert('กรุณาเลือกวันที่');
      return false; // ยกเลิกการส่งแบบฟอร์ม
    }

    if (selectedTime === '') {
      alert('กรุณาเลือกเวลา');
      return false; // ยกเลิกการส่งแบบฟอร์ม
    }
  }
</script>
<script type="text/javascript">
	var today = new Date();
	today.setDate(today.getDate() + 1);  // เซ็ตค่าวันที่ของวันถัดไป
	
	var dd = today.getDate();
	var mm = today.getMonth() + 1;  // เดือนเริ่มต้นที่ 0
	var yyyy = today.getFullYear();
	
	if (dd < 10) {
	  dd = '0' + dd;
	}
	
	if (mm < 10) {
	  mm = '0' + mm;
	}
	
	var tomorrow = yyyy + '-' + mm + '-' + dd;
	document.getElementById("myDate").setAttribute("min", tomorrow);
	document.getElementById("myDate").value = tomorrow;
</script>


</head>
<body style="background-color: #D4D4D4">
<!-- Navbar -->
<jsp:include page="menubar_member.jsp" />
<div class="vh-500 py-5 gradient-custom"></div>
    <section class="vh-500 gradient-custom">
  <div class="container py-5 h-500">
    <div class="row justify-content-center align-items-center h-100">
      <div class="col-12 col-lg-9 col-xl-8">
        <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
          <div class="card-body p-4 p-md-5">
          <h2>Make Appionment</h2>
            <h3 class="mb-4 pb-2 pb-md-0 mb-md-5"></h3>
            
            
            
            
            
			  <input type="hidden" name="id" value="${BuyServices.buyservice_id}">
			  <input type="hidden" name="member_id" value="<%= m.getLogins().getEmail() %>">
              <div class="row">
                <div class="col-md-6 mb-4">
                    <label class="label" >ชื่อบริการ : ${BuyServices.service.serviceName}</label>
                </div>
              </div>
              <div class="row">
              	<div class="col-md-6 mb-4">
                    <label class="label" >ผู้ซื้อบริการ : ${BuyServices.person.full_name}</label>
              	</div>
              </div>
              
              <!-- ฟอร์ม1 Date -->
              <form id="inner-form" action="${pageContext.request.contextPath}/check_make_appoinment_page" method="GET">
	              	<input type="hidden" name="id" value="${BuyServices.buyservice_id}">
              	<div class="row">
              	<div class="col-md-2 mb-4">
                    <label class="label" >วันที่เลือก : </label>
              	</div>
              		<div class="col-md-4 mb-4 ">
              			<input type="date" class="form-control" name="date_app" id="dateInput" value="${date_now}" onchange="myFunction()"/>
              		</div>
                </div>
              </form>
              <script type="text/javascript">
				function myFunction() {
					document.getElementById("inner-form").submit();
				}
			  </script>
              
              
              <!-- ฟอร์ม2  -->
              <form onsubmit="return confirm('คุณต้องการดำเนินการต่อหรือไม่?')" name="frm" action="${pageContext.request.contextPath}/make_appoinment_page" method="POST">
              <div class="row">
              	<div class="col-md-2 mb-4">
              	<input type="hidden" name="id" value="${BuyServices.buyservice_id}">
              	<input type="hidden" name="member_id" value="<%= m.getLogins().getEmail() %>">
              	</div>
              		<div class="col-md-4 mb-4 ">
              			<input type="hidden" class="form-control" name="date_app" id="dateInput" value="${date_now}"/>
              		</div>
              </div>

              <div class="row">
              	<div class="col-md-2 mb-4">
                    <label class="label" >เวลาที่นัด : </label>
                </div>
                    <div class="col-md-4 mb-4">
                    	<select class="form-select" name="select_time">
						  <option value="">กรุณาเลือกเวลา</option>
						  <c:forEach items="${Times}" var="time">
						  	<option value="${time}">${time}</option>
						  </c:forEach>
						</select>
                    </div>
              </div>

              <div class="d-flex justify-content-end" >
              	<a href="${pageContext.request.contextPath}/open_list_rigister_service_page?id=<%= m.getLogins().getEmail() %>" class="btn btn-danger btn-lg m-1" >ยกเลิก</a>
                <button class="btn btn-success btn-lg m-1" type="submit" onclick="return validateForm() "  value="submit">บันทึก</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

	
	<!-- ***** Input Register End ***** -->
<div class="bg-dark" id="footer" >
    <jsp:include page="../footer.jsp" />
   </div> 
  

  
    <!-- Bootstrap core JavaScript -->
    <script src="jquery/jquery.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>


    <!-- Additional Scripts -->
    <script src="js/custom.js"></script>
    <script src="js/owl.js"></script>
    <script src="js/slick.js"></script>
    <script src="js/isotope.js"></script>
    <script src="js/accordions.js"></script>


    <script language = "text/Javascript"> 
      cleared[0] = cleared[1] = cleared[2] = 0; //set a cleared flag for each field
      function clearField(t){                   //declaring the array outside of the
      if(! cleared[t.id]){                      // function makes it static and global
          cleared[t.id] = 1;  // you could use true and false, but that's more typing
          t.value='';         // with more chance of typos
          t.style.color='#fff';
          }
      }
    </script>
    <!-- MDB -->
	<script
	  type="text/javascript"
	  src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.1.0/mdb.min.js"
	></script>
</body>
</html>