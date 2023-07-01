<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Service</title>
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

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/1.13.3/css/dataTables.bootstrap5.min.css">

<link rel="stylesheet" href="https://cdn.datatables.net/buttons/2.3.4/css/buttons.bootstrap5.min.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.13.2/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.13.2/js/dataTables.bootstrap5.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/2.3.4/js/buttons.bootstrap5.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.13.2/js/dataTables.bootstrap5.min.js"></script>

<style type="text/css">
@import url('https://fonts.googleapis.com/css2?family=Prompt:ital,wght@1,500;1,900&family=Roboto:ital,wght@1,900&display=swap');
</style>
<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>

</head>
<body style="background-color: #D4D4D4">
<jsp:include page="../menubar_admin.jsp" />

 <div class="container ">
<div style="position : absolute; top : 100px;" class="col-sm-8 bg-light-subtle card">
	<div class="m-3">
	<table id="example" class="table table-striped" style="width:100%">
					<thead class="text-center font-weight-bold">
					<tr class="">
						<th scope="col">Service ID</th>
						<th scope="col">ชื่อบริการ</th>
						<th scope="col">รายละเอียดบริการ</th>
						<th scope="col">ราคา</th>
						<th scope="col">รูป</th>
						<th scope="col">สถานะ</th>
						<th scope="col">ความเชี่ยวชาญ</th>
						<th scope="col">ประเภท</th>
						<th scope="col">แก้ไข</th>
						<th scope="col">ลบ</th>
					</tr>
					</thead>
					<tbody>
						
						<c:forEach items="${ListServices}" var="Services">
						<tr>
							<td>${Services.service_id}</td>
							<td>${Services.serviceName}</td>
							<td>${Services.serviceDetail}</td>
							<td>${Services.price}</td>
							<td>${Services.image}</td>
							<td>${Services.serviceStatus}</td>
							<td>${Services.expertise.expertise_name}</td>
							<td>${Services.servicetype.service_type}</td>
							<td><a href="open_edit_service_page?id=${Services.service_id}"><button type="submit" class="btn btn-primary"> <ion-icon name="create"></ion-icon></button></a></td>
							<td><a href="delete_service?id=${Services.service_id}"><button type="submit" class="btn btn-danger" onclick="return confirm('คุณต้องการดำเนินการต่อหรือไม่?')"> <ion-icon name="trash"></ion-icon></button></a></td>
						</tr>
						</c:forEach>
						
					</tbody>
				</table>
	</div>
</div>
</div>
	<script type="text/javascript">
	$(document).ready(function () {
	    $('#example').DataTable({
	    	lengthMenu: [
                [  20,25,50],
                [  '20', '25', '50' ]
            ],
            language: {
                "info": "แสดงหน้า _START_ / _END_ ทั้งหมด _TOTAL_ รายการ",
                "lengthMenu": "แสดง _MENU_ รายการ",
                "search": "",
                "searchPlaceholder": "ค้นหา...",
                "zeroRecords": "ขออภัยไม่พบรายการ",
                "infoEmpty": "ไม่พบรายการ",
                "infoFiltered": "(ผลลัพธ์จากทั้งหมด _MAX_  รายการ)",
                "paginate": {
                    "first": "หน้าแรก",
                    "last": "หน้าสุดท้าย",
                    "next": "ต่อไป",
                    "previous": "ก่อนหน้า",
                },
              }
	    	
	    });
	    
	});
	</script>

</body>
</html>