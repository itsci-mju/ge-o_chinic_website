<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Staff Page</title>
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
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
     
     <!-- Additional CSS Files  -->
    <link rel="stylesheet" href="css/fontawesome.css">
    <link rel="stylesheet" href="css/templatemo-sixteen.css">
    <link rel="stylesheet" href="css/owl.css">
   
</head>
<body>
<body onload="message()">
<jsp:include page="../menubar_admin.jsp" />
 <!-- ***** Preloader Start ***** -->
    <div id="preloader">
        <div class="jumper">
            <div></div>
            <div></div>
            <div></div>
        </div>
    </div>  
    <!-- ***** Preloader End ***** -->
    <!-- Page Content -->
    <div class="page-heading about-heading header-text">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="text-content">
              <h4>about us</h4>
              <h2>Go'Clinic Company</h2>
            </div>
          </div>
        </div>
      </div>
    </div>
    
    <div class="best-features about-features">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="section-heading">
              <h2>Edit Staff</h2>
            </div>
          </div>
          <div class="col-md-12">
            <div class="left-content">
            	<!-- ***** Input Register Start ***** -->
					<form action="${pageContext.request.contextPath}/edit_staff_page" method="POST">
						<input type="hidden" name="person_id" value="${person.person_id}"><br>
                        ชื่อ - นามสกุล : <input type="text" name="name" value="${person.full_name}"><br>
                        ชื่อเล่น : <input type="text" name="nickname" value="${person.nickname}"><br>
                        รหัสผ่าน : <input type="password" name="pwd" value="${person.logins.password}"><br>
                        วันเกิด : <input type="date" name="birthday" value="${person.setBirthdayFormate()}"><br>
                        เพศ : <input type="radio" name="err_gender" value="0" <c:if test = "${person.gender == '0'}">checked = "checked"</c:if>>ชาย <input type="radio" name="err_gender" value="1" <c:if test = "${person.gender == '1'}">checked = "checked"</c:if>>หญิง<br>
                        รหัสประจำตัวประชาชน : <input type="text" name="idcard" value="${person.id_card}"><br>
                        เบอร์โทรศัพท์ : <input type="text" name="phone" value="${person.phone_number}"><br>
                        E-Mail : <input type="text" name="email" value="${person.logins.email}"><br> 
                        ที่อยู่ : <input type="text" name="address" value="${person.address}"><br>

						<button type="submit" value="submit" onclick="validate(frm)">แก้ไขพนักงาน</button>
						<button type="reset" value="reset" >ยกเลิก</button>
					</form>
		</div>
		</div>
		</div>
		</div>
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
</body>
</body>
</html>