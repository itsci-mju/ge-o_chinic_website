<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
   <head>
      <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900&display=swap" rel="stylesheet">
      
      <title>Edit Staff Page</title>
     
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

<script type="text/javascript">
function validate(frm) {
	  // ตรวจสอบชื่อ - นามสกุล
	  var name = frm.name.value;
	  if (name.trim() === "") {
	    alert("กรุณากรอกชื่อ - นามสกุล");
	    return false;
	  }

	  // ตรวจสอบชื่อเล่น
	  var nickname = frm.nickname.value;
	  if (nickname.trim() === "") {
	    alert("กรุณากรอกชื่อเล่น");
	    return false;
	  }

	  // ตรวจสอบวันเกิด
	  var birthday = frm.birthday.value;
	  if (birthday === "") {
	    alert("กรุณาเลือกวันเกิด");
	    return false;
	  }

	  // ตรวจสอบเพศ
	  var gender = frm.err_gender.value;
	  if (gender === "") {
	    alert("กรุณาเลือกเพศ");
	    return false;
	  }

	  // ตรวจสอบรหัสประจำตัวประชาชน
	  var idcard = frm.idcard.value;
	  if (idcard.trim() === "" || isNaN(idcard) || idcard.length !== 13) {
	    alert("กรุณากรอกรหัสประจำตัวประชาชนให้ถูกต้อง 13 ตัว");
	    return false;
	  }

	  // ตรวจสอบอีเมล
	  var email = frm.email.value;
	  var emailRegex = /^[A-Za-z0-9._-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/;
	  if (email.trim() === "" || !emailRegex.test(email)) {
	    alert("กรุณากรอกอีเมลให้ถูกต้อง ตัวอย่าง (xxxxx@gmail.com, xxxxx@hotmail.com)");
	    return false;
	  }

	  // ตรวจสอบเบอร์โทรติดต่อ
	  var phone = frm.phone.value;
	  if (phone.trim() === "" || isNaN(phone) || phone.length !== 10) {
	    alert("กรุณากรอกเบอร์โทรติดต่อให้ถูกต้อง 10 ตัว");
	    return false;
	  }

	  // ตรวจสอบที่อยู่
	  var address = frm.address.value;
	  if (address.trim() === "") {
	    alert("กรุณากรอกที่อยู่");
	    return false;
	  }

	  // ตรวจสอบรหัสผ่าน
	  var password = frm.pwd.value;
	  if (password.trim() === "" || password.length < 5 || password.length > 16) {
	    alert("กรุณากรอกรหัสผ่านให้ถูกต้อง (ความยาว 5-16 ตัวอักษร)");
	    return false;
	  }

	  return true;
	}

</script>
</head>
<body style="background-color: #D4D4D4">
<jsp:include page="../menubar_admin.jsp" />

 <div class="container py-5 h-500 vh-500">
    <div class="row justify-content-center align-items-center h-100">
      <div class="col-12 col-lg-9 col-xl-8">
        <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
          <div class="card-body p-4 p-md-5">
            <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Edit Staff Form</h3>
            <form name="frm" action="${pageContext.request.contextPath}/edit_staff_page" method="POST">

              <div class="row">
                <div class="col-md-6 mb-4">

                  <div class="form-outline">
                    <input type="text" name="name" class="form-control form-control-lg" value="${person.full_name}"/>
                    <label class="form-label" for="name">ชื่อ - นามสกุล</label>
                  </div>
                </div>
              </div>
              <div class="row">
              	<div class="col-md-6 mb-4">
              		<div class="form-outline">
              		<input type="text" name="nickname" class="form-control form-control-lg" value="${person.nickname}"/>
                    <label class="form-label" for="nickname">ชื่อเล่น</label>
                   </div>
              	</div>
              </div>

              <div class="row">
                <div class="col-md-3 mb-4">
				  <h6 class="mb-2 pb-1">วันเกิด: </h6>
                    <input type="date" class="form-control" name="birthday" value="${person.setBirthdayFormate()}"/>

                </div>
                <div class="col-md-3 mb-4"></div>
                <div class="col-md-6 mb-4">

                  <h6 class="mb-2 pb-1">เพศ : </h6>

                 <input type="radio" name="err_gender" value="0" ${person.gender eq '0' ? 'checked' : ''}>ชาย
				  <input type="radio" name="err_gender" value="1" ${person.gender eq '1' ? 'checked' : ''}>หญิง
                </div>
              </div>
				
			  <div class="row">
			  	<div class="col-md-6 mb-4 pb-2">
			  	  <div class="form-outline">
			  	 	<input type="text" name="idcard" class="form-control form-control-lg" value="${person.id_card}"/>
                    <label class="form-label" for="idcard">รหัสประจำตัวประชาชน</label>
			  	  </div>
			  	</div>
			  </div>
			  
              <div class="row">
                <div class="col-md-6 mb-4 pb-2">

                  <div class="form-outline">
                    <input type="email" name="email" class="form-control form-control-lg" value="${person.logins.email}"/>
                    <label class="form-label" for="email">อีเมล</label>
                  </div>
                </div>
                <div class="col-md-6 mb-4 pb-2">
                  <div class="form-outline">
                    <input type="text" name="phone" class="form-control form-control-lg" value="${person.phone_number}"/>
                    <label class="form-label" for="phone">เบอร์โทรติดต่อ</label>
                  </div>
                </div>
              </div>
              
              <div class="row">
			  	<div class="col-md-6 mb-4 pb-2">
			  	  <div class="form-outline">
			  	 	<textarea class="form-control" name="address" rows="4">${person.address}</textarea>
           			 <label class="form-label" for="address">ที่อยู่</label>
			  	  </div>
			  	</div>
			  </div>
			  
			  <div class="row">
			  	<div class="col-md-6 mb-4 pb-2">
			  	  <div class="form-outline">
			  	 	<input type="password" name="pwd" class="form-control form-control-lg" value="${person.logins.password}"/>
                    <label class="form-label" for="pwd">รหัสผ่าน</label>
			  	  </div>
			  	</div>
			  </div>
              <div class="d-flex justify-content-end">
				<button class="btn btn-success btn-lg m-1" type="submit" value="submit" onclick="return validate(this.form)">บันทึก</button>
				<a href="${pageContext.request.contextPath}/open_list_staff_page"><button class="btn btn-danger btn-lg m-1" type="reset" value="reset" >ยกเลิก</button></a>
			  </div>

            </form>
          </div>
        </div>
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