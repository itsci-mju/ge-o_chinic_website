<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900&display=swap" rel="stylesheet">

    <title>Register Page</title>
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

	  // ตรวจสอบโรคประจำตัว
	  var congenital_disorder = frm.congenital_disorder.value;
	  if (congenital_disorder.trim() === "") {
	    alert("กรุณากรอกโรคประจำตัว (ในกรณีที่ไม่มีโรคประจำตัวให้ใส่เครื่องหมาย - )");
	    return false;
	  }

	  // ตรวจสอบแพ้ยา
	  var drug_allergy = frm.drug_allergy.value;
	  if (drug_allergy.trim() === "") {
	    alert("กรุณากรอกข้อมูลแพ้ยา (ในกรณีที่ไม่มีโรคประจำตัวให้ใส่เครื่องหมาย - )");
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
    <style type="text/css">
@import url('https://fonts.googleapis.com/css2?family=Prompt:ital,wght@1,500;1,900&family=Roboto:ital,wght@1,900&display=swap');
</style>

<link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet" />

<script src="https://kit.fontawesome.com/8e4d971ffd.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

     <!-- Additional CSS Files  -->
    <link rel="stylesheet" href="css/fontawesome.css">
    <link rel="stylesheet" href="css/templatemo-sixteen.css">
    <link rel="stylesheet" href="css/owl.css">
   
</head>
<body onclick="message()">
<!-- Navbar -->
<jsp:include page="menubar_general.jsp" />
<div class="vh-500 py-5 gradient-custom"></div>
    <section class="vh-500 gradient-custom">
  <div class="container py-5 h-500">
    <div class="row justify-content-center align-items-center h-100">
      <div class="col-12 col-lg-9 col-xl-8">
        <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
          <div class="card-body p-4 p-md-5">
            <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Registration Form</h3>
            <form name="frm" action="${pageContext.request.contextPath}/open_Registers_page" method="POST">

              <div class="row">
                <div class="col-md-6 mb-4">

                  <div class="form-outline">
                    <input type="text" name="name" class="form-control form-control-lg" />
                    <label class="form-label" for="name">ชื่อ - นามสกุล</label>
                  </div>
                </div>
              </div>
              <div class="row">
              	<div class="col-md-6 mb-4">
              		<div class="form-outline">
              		<input type="text" name="nickname" class="form-control form-control-lg" />
                    <label class="form-label" for="nickname">ชื่อเล่น</label>
                   </div>
              	</div>
              </div>

              <div class="row">
                <div class="col-md-3 mb-4">
				  <h6 class="mb-2 pb-1">วันเกิด: </h6>
                    <input type="date" class="form-control" name="birthday" />

                </div>
                <div class="col-md-3 mb-4"></div>
                <div class="col-md-6 mb-4">

                  <h6 class="mb-2 pb-1">เพศ : </h6>

                  <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="err_gender"
                      value="0" checked />
                    <label class="form-check-label" for="femaleGender">ชาย</label>
                  </div>

                  <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="err_gender" 
                      value="1" />
                    <label class="form-check-label" for="maleGender">หญิง</label>
                  </div>
                </div>
              </div>
				
			  <div class="row">
			  	<div class="col-md-6 mb-4 pb-2">
			  	  <div class="form-outline">
			  	 	<input type="text" name="idcard" class="form-control form-control-lg" />
                    <label class="form-label" for="idcard">รหัสประจำตัวประชาชน</label>
			  	  </div>
			  	</div>
			  </div>
			  
			  <div class="row">
			  	<div class="col-md-6 mb-4 pb-2">
			  	  <div class="form-outline">
			  	 	<input type="text" name="congenital_disorder" class="form-control form-control-lg" />
                    <label class="form-label" for="congenital_disorder">โรคประจำตัว</label>
			  	  </div>
			  	</div>
			  	<div class="col-md-6 mb-4 pb-2">
			  	  <div class="form-outline">
			  	 	<input type="text" name="drug_allergy" class="form-control form-control-lg" />
                    <label class="form-label" for="drug_allergy">แพ้ยา</label>
			  	  </div>
			  	</div>
			  </div>
			  
              <div class="row">
                <div class="col-md-6 mb-4 pb-2">

                  <div class="form-outline">
                    <input type="email" name="email" class="form-control form-control-lg" />
                    <label class="form-label" for="email">อีเมล</label>
                  </div>
                </div>
                <div class="col-md-6 mb-4 pb-2">
                  <div class="form-outline">
                    <input type="text" name="phone" class="form-control form-control-lg" />
                    <label class="form-label" for="phone">เบอร์โทรติดต่อ</label>
                  </div>
                </div>
              </div>
              
              <div class="row">
			  	<div class="col-md-6 mb-4 pb-2">
			  	  <div class="form-outline">
			  	 	<textarea class="form-control" name="address" rows="4"></textarea>
           			 <label class="form-label" for="address">ที่อยู่</label>
			  	  </div>
			  	</div>
			  </div>
			  
			  <div class="row">
			  	<div class="col-md-6 mb-4 pb-2">
			  	  <div class="form-outline">
			  	 	<input type="password" name="pwd" class="form-control form-control-lg" />
                    <label class="form-label" for="pwd">รหัสผ่าน</label>
			  	  </div>
			  	</div>
			  </div>

              <div class="mt-4 pt-2">
                <button class="btn btn-primary btn-lg" type="submit" onclick="return validate(this.form)" value="ลงทะเบียน">ลงทะเบียน</button>
                <button class="btn btn-primary btn-lg" type="reset" value="ยกเลิก">ยกเลิก</button>
              </div>
              

            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

	
	<!-- ***** Input Register End ***** -->

    <jsp:include page="footer.jsp" />
    
  

  
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