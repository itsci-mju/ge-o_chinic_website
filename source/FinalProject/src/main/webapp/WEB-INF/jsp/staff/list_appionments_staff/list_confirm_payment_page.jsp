<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirm Appionment Page</title>
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
<jsp:include page="../menubar_staff.jsp" />

 <div class="container ">
<div style="position : absolute; top : 100px;" class="col-sm-8 bg-light-subtle card">
	<div class="m-3">
	<table id="example" class="table table-striped" style="width:100%">
					<thead class="text-center font-weight-bold">
					<tr class="">
						<th scope="col">รหัสรายการ</th>
						<th scope="col">ชื่อผู้ใช้</th>
						<th scope="col">ชื่อบริการ</th>
						<th scope="col">เบอร์โทร</th>
						<th scope="col">บริการคงเหลือ</th>
						<th scope="col">สถานะ</th>
						<th scope="col">ตรวจสอบชำระเงิน</th>

					</tr>
					</thead>
					<tbody>
						
						<c:forEach items="${ListBuyServices}" var="BuyServices">
						<tr>
							<td>${BuyServices.buyservice_id}</td>
							<td>${BuyServices.person.full_name}</td>
							<td>${BuyServices.service.serviceName}</td>
							<td>${BuyServices.person.phone_number}</td>
							<td>${BuyServices.order_qty}</td>
							<td>
								<c:choose>
								  <c:when test="${BuyServices.status eq '0'}">
								    <span>ยังไม่ได้ชำระเงิน</span>
								    
								  </c:when>
								  <c:when test="${BuyServices.status eq '1'}">
								    <span>รอการตรวจสอบ</span>
								  </c:when>
								  <c:otherwise>
								    <span>ชำระเงินเรียบร้อย</span>
								  </c:otherwise>
								</c:choose> 
							</td>
							<td><a href="${pageContext.request.contextPath}/open_confirm_payment_page/?id=${BuyServices.buyservice_id}"><button type="submit" class="btn btn-primary" onclick="return confirm('คุณต้องการดำเนินการต่อหรือไม่?')">ตรวจสอบ</button></a></td>
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