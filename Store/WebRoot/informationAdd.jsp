<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>销售信息登记</title>
<style type="text/css">
#apDiv1{
z-index:1;
margin:0 auto; 
width:400px; 
height:100px;
}
body{
text-align:center;
}
</style>


</head>
<body style="background:url('img/1.jpg'); background-size:cover;no-repeat;">
<div id="apDiv1">
  <h2 align="center">销售信息登记</h2><br/>
  <form id="form1" name="form1" method="post" action="informationAdd">
  <p>
     &nbsp;&nbsp;&nbsp;<label for="textfield">单号 &nbsp;&nbsp;&nbsp;:</label>
    <input type="text" name="sale_no" id="textfield" value=<%=request.getAttribute("sale_no") %>>
  </p>
  <p>
    <label for="textfield2">员工编号:</label>
    <input type="text" name="staff_no" id="textfield2">
  </p>
  <p>
    <label for="textfield3">销售日期:</label>
    <input type="text" name="sale_date" id="textfield3">
  </p>
  <!-- <p>
    <label for="textfield2"> 应收 :</label>
    <input type="text" name="receivable" id="textfield4">
  </p>  -->
  <p>
    <label for="textfield3">实收金额:</label>
    <input type="text" name="receipts" id="textfield5">
  </p>
<!--   <p>
    <label for="textfield6">操作注释:</label>
    <input type="text" name="remark" id="textfield6" >
  </p> -->
  <br/>
  <p align="center">
     &nbsp;&nbsp;&nbsp; &nbsp;<input type="submit" name="submit" id="submit" value="提交">
  </p>
  </form>
</div>
</body>
</html>