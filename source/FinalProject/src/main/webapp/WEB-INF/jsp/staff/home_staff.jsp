<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
   <head>
      <meta charset="utf-8">
      <title>Home Staff page</title>
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
<style>
  .custom-background {
    background-image: url('<%=request.getContextPath()%>/img/home_img_4.jpg');
    background-size: cover;
    background-position: right;
    background-repeat: no-repeat;
    box-shadow: 0 0 30px rgba(0, 0, 0, 0.1);
  }
</style>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
   </head>
 <body onload="message()">
 <jsp:include page="menubar_staff.jsp" />
<div class="container mt-5 m-auto">
	<div class="jumbotron p-3 p-md-5 text-dark rounded custom-background">
        <div class="col-md-6 px-0">
          <h1 class="display-4 font-italic">บริการปรับแต่งโดยใช้เทคนิคแบบโอเพ่น</h1>
          <p class="lead my-3">การทำศัลยกรรมปรับโครงหน้า คือ การทำศัลยกรรมเพื่อปรับโครงหน้าและบริเวณใบหน้า โดยการใช้เทคนิคทางการแพทย์ พร้อมกับดูแลทุกขั้นตอนโดยศัลยแพทย์ที่มีความชำนาญเฉพาะทาง เพื่อวางแผนรักษาสำหรับท่านที่มีปัญหา  ซึ่งแต่ละส่วนบนใบหน้าสามารถแก้ไขด้วยบริการนี้ โดยศัลยแพทย์จะทำการวางแผนการรักษา</p>
        </div>
      </div>

      <div class="row mb-2 mt-2">
        <div class="col-md-6">
          <div class="card flex-md-row mb-4 box-shadow h-md-250">
            <div class="card-body d-flex flex-column align-items-start">
              <h3 class="mb-0">
                <a class="text-dark" href="#">ศัลยกรรมปรับโครงหน้าคืออะไร?</a>
              </h3>

              <p class="card-text mb-auto mt-3">เป็นเทคนิคเฉพาะที่ศัลยแพทย์จะนำเนื้อเยื่อเทียม ซึ่งเป็นวัสดุที่สังเคราะห์ได้จากคอลลาเจน มาปรับแต่งแทนการใช้วัสดุทางการแพทย์ เพื่อให้ดั้งโด่งขึ้น ดูสวยเป็นธรรมชาติ</p>

            </div>
            <img class="card-img-right flex-auto d-none d-md-block"  alt="Thumbnail [200x250]" style="width: 200px; height: 250px;" src="<%=request.getContextPath()%>/img/home_img_1.jpg" data-holder-rendered="true">
          </div>
        </div>
        <div class="col-md-6">
          <div class="card flex-md-row mb-4 box-shadow h-md-250">
            <div class="card-body d-flex flex-column align-items-start">
              <h3 class="mb-0">
                <a class="text-dark" href="#">บริการปรับแต่งโดยใช้เนื้อเยื่อเทียม</a>
              </h3>
              <p class="card-text mb-auto mt-3" >เป็นเทคนิคเฉพาะที่ศัลยแพทย์จะนำเนื้อเยื่อเทียม ซึ่งเป็นวัสดุที่สังเคราะห์ได้จากคอลลาเจน มา ปรับแต่งแทนการใช้วัสดุทางการแพทย์ เพื่อให้ดั้งโด่งขึ้น ดูสวยเป็นธรรมชาติ</p>

            </div>
            <img class="card-img-right flex-auto d-none d-md-block" data-src="holder.js/200x250?theme=thumb" alt="Thumbnail [200x250]" style="width: 200px; height: 250px;" src="<%=request.getContextPath()%>/img/home_img_2.jpg" data-holder-rendered="true">
          </div>
        </div>
      </div>
    </div>

<div class="bg-dark" id="footer"> <jsp:include page="../footer.jsp" /></div>
</body>
</html>