<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
   <head>
      <meta charset="utf-8">
      <title>Confirm Payment page</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
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
<body>

<div class="container mt-5 mb-3">
    <div class="row d-flex justify-content-center">
        <div class="col-md-8">
            <div class="card">
                <div class="d-flex flex-row p-2"> <img src="https://i.imgur.com/vzlPPh3.png" width="48">
                    <div class="d-flex flex-column"> <span class="font-weight-bold">Tax Invoice</span> <small>INV-${BuyServices.buyservice_id}</small> </div>
                    
                </div>
                <div class="d-flex flex-row p-2"><span class="d-flex flex-column">ที่อยู่การออกใบเสร็จ / Billing Address</span></div>
                <div class="d-flex flex-row p-2"><span class="d-flex flex-column">16/1 หมู่ 4 ต.เวียง, ตำบล สันทราย อำเภอ ฝาง เชียงใหม่ 50110</span></div>
                <hr>
                <div class="table-responsive p-2">
                    <table class="table table-borderless">
                        <tbody>
                        	<tr class="content">
                        		<td></td>
                        	</tr>
                            <tr class="content">
                                <td class="font-weight-bold">
									<ul class="list-unstyled">
						              <li class="text-muted">ชื่อผู้ซื้อ :<span style="color:#8f8061 ;"> ${BuyServices.person.full_name}</span></li>
						              <li class="text-muted">ที่อยู่ผู้ซื้อ : ${BuyServices.person.address}</li>
						              <li class="text-muted"><i class="fas fa-phone"></i>${BuyServices.person.phone_number}</li>
						            </ul>
								</td>
                                 <td class="font-weight-bold " align="right">ใบแจ้งหนี้ / Invoce <br>
                                วันที่  
                                <script>
							        var appointmentTime = new Date("${BuyServices.order_date}");
							        var formattedDate = appointmentTime.toISOString().split('T')[0];
							        document.write(formattedDate);
							    </script>
							    เวลา 
							    <script>
							        var dateTime = "${BuyServices.order_date}";
							        var time = dateTime.substring(11, 16);  // ตัดส่วนของเวลาออกมาเท่านั้น
							        document.write(time);
							    </script> 
							    <br> </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <hr>
                <div class="products p-2">
                    <table class="table table-borderless">
                        <tbody>
                            <tr class="add">
                                <td></td>
                                <td>Description</td>
                                <td></td>
                                <td class="text-center">Total</td>
                            </tr>
                            <tr class="content">
                            
                                <td>
                                	<div class="bg-image ripple rounded-5 mb-4 overflow-hidden d-block" data-ripple-color="light">
						              <img src="<%=request.getContextPath()%>/img/${BuyServices.service.image}" class="w-50" height="100px"/>
						              <a href="#!">
						                <div class="hover-overlay">
						                  <div class="mask" style="background-color: hsla(0, 0%, 98.4%, 0.2)"></div>
						                </div>
						              </a>
						            </div>
                                </td>
                                <td>${BuyServices.service.serviceName}</td>
                                <td></td>
                                <td class="text-center">${BuyServices.service.price}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <hr>
                <div class="address p-2">
                    <table class="table table-borderless">
                        <tbody>
                            <tr class="content" align="center">
                                <td>
                                	<div class="col-12">
	                                		<div class="col-md-12 mb-4"><img src="<%=request.getContextPath()%>/img/${BuyServices.uploadpayment.images}" style="width:355px;height:550px;" /></div>
	                                		<div class="d-flex justify-content-end">
												<div>
													<a href="${pageContext.request.contextPath}/open_List_confirm_payment_page"><button class="btn btn-danger btn-lg m-1 " type="reset" value="reset" >ยกเลิก</button></a>
													<a href="${pageContext.request.contextPath}/confirm_payment_page?id=${BuyServices.buyservice_id}"><button type="submit" class="btn btn-success btn-lg m-1">ยืนยันการตรวจสอบ</button></a>
												</div>
											</div>
                                	</div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>