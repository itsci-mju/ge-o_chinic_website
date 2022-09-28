<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
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

body{font-family: 'Prompt', sans-serif;}
.table.sortable th:not(.sorttable_sorted):not(.sorttable_sorted_reverse):not(.sorttable_nosort):after { 
    content: "\25BE" ;
}

body {
  background: #eecda3;
  background: -webkit-linear-gradient(to right, #eecda3, #ef629f);
  background: linear-gradient(to right, #eecda3, #ef629f);
  min-height: 100vh;
}
</style>
<link href="<%= request.getContextPath()%>/css/sreach.css" rel = "stylesheet">
<link href="<%= request.getContextPath()%>/css/inputnumber.css" rel = "stylesheet">
<link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet" />

<script src="https://kit.fontawesome.com/8e4d971ffd.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script>
    function message() {
      var message = "${message}";
      if(message!=""){
          alert(message);
      }
    }
    
    function validate(frm) {
        function valition(){
            if(frm.id.value == ""){
                document.getElementById('err_id').innerHTML = " *กรุณากรอกรหัสพนักงาน";
                frm.id.focus();
                return false;
            }
            if(frm.user.value == ""){
                document.getElementById('err_user').innerHTML = " *กรุณากรอกชื่อผู้ใช้";
                frm.user.focus();
                return false;
            }
            if(frm.pwd.value == ""){
                document.getElementById('err_pwd').innerHTML = " *กรุณากรอกชื่อผู้ใช้";
                frm.pwd.focus();
                return false;
            }
            if(frm.name.value == ""){
                document.getElementById('err_name').innerHTML = " *กรุณากรอกชื่อพนักงาน";
                frm.name.focus();
                return false;
            }
            if(frm.idcard.value == ""){
                document.getElementById('err_idcard').innerHTML = " *กรุณากรอกรหัสประชาชน";
                frm.idcard.focus();
                return false;
            }
            if(frm.phone.value == ""){
                document.getElementById('err_phone').innerHTML = " *กรุณากรอกเบอร์โทรศัพท์";
                frm.phone.focus();
                return false;
            }
            if(frm.email.value == ""){
                document.getElementById('err_email').innerHTML = " *กรุณากรอกอีเมล์";
                frm.email.focus();
                return false;
            }
            if(frm.address.value == ""){
                document.getElementById('err_address').innerHTML = " *กรุณากรอกที่อยู่";
                frm.address.focus();
                return false;
            }
        }

</script>
</head>
<body>
<body onload="message()">
<jsp:include page="menubar_admin.jsp" />
	<div class="pb-5 mt-5">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">
					<form action="register" method="POST">

						รหัสพนักงาน : <input type="text" name="id"><label id="err_id" style="color:red"></label><br>
                        ชื่อผู้ใช้ : <input type="text" name="user"><label id="err_user" style="color:red"></label> <br>
                        รหัสผ่าน : <input type="password" name="pwd"><label id="err_pwd" style="color:red"></label> <br>
                        ชื่อ - นามสกุล : <input type="text" name="name"><label id="err_name" style="color:red"></label><br>
                        รหัสประจำตัวประชาชน : <input type="text" name="idcard"><label id="err_idcard" style="color:red"></label><br>
                        เบอร์โทรศัพท์ : <input type="text" name="phone"><label id="err_phone" style="color:red"></label><br>
                        E-Mail : <input type="text" name="email"><label id="err_email" style="color:red"></label><br> 
                        ที่อยู่ : <input type="text" name="address"><label id="err_address" style="color:red"></label><br>

						<button type="submit" value="submit" onclick="validate(frm)">ลงทะเบียน</button>
						<button type="reset" value="reset" >ยกเลิก</button>

					</form>
				</div>
			</div>
		</div>

	</div>
</body>
</body>
</html>