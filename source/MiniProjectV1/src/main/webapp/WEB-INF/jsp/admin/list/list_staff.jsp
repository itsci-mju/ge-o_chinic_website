<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Staff</title>
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
<script src="<%=request.getContextPath()%>/css/sorttable.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/css/inputnumbers.js" type="text/javascript"></script>

<style type="text/css">
@import url('https://fonts.googleapis.com/css2?family=Prompt:ital,wght@1,500;1,900&family=Roboto:ital,wght@1,900&display=swap');
</style>
<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
     
     <!-- Additional CSS Files  -->
    <link rel="stylesheet" href="css/fontawesome.css">
    <link rel="stylesheet" href="css/templatemo-sixteen.css">
    <link rel="stylesheet" href="css/owl.css">
   
</head>
<body>
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
	<table class="table table-bordered searchable sortable table.sortable " border="1">
					<thead class="text-center font-weight-bold">
					<tr>
						<th scope="col">Staff ID</th>
						<th scope="col">ชื่อ - นามสกุล</th>
						<th scope="col">ชื่อเล่น</th>
						<th scope="col">วันเกิด</th>
						<th scope="col">เพศ</th>
						<th scope="col">รหัสประจำตัวประชาชน</th>
						<th scope="col">เบอร์โทรศัพท์</th>
						<th scope="col">อีเมล</th>
						<th scope="col">ที่อยู่</th>
						<th scope="col">แก้ไข</th>
						<th scope="col">ลบ</th>
					</tr>
					</thead>
					<tbody>
						
						<c:forEach items="${list_staff}" var="Staff">
						<tr>
							<td>${Staff.person_id}</td>
							<td>${Staff.full_name}</td>
							<td>${Staff.nickname}</td>
							<td>${Staff.birthday}</td>
							<td>${Staff.gender}</td>
							<td>${Staff.id_card}</td>
							<td>${Staff.phone_number}</td>
							<td>${Staff.logins.email}</td>
							<td>${Staff.address}</td>
							<td><a href="open_edit_staff_page?id=${Staff.logins.email}"><button type="submit" class="btn btn-primary"> <ion-icon name="create"></ion-icon></button></a></td>
							<td><a href="delete_staff?id=${Staff.logins.email}"><button type="submit" class="btn btn-primary" onclick="return confirm('คุณต้องการดำเนินการต่อหรือไม่?')"> <ion-icon name="trash"></ion-icon></button></a></td>
						</tr>
						</c:forEach>
						
					</tbody>
				</table>
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
</html>