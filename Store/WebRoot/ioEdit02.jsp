<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="table.io.*"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>出入库信息变更</title>
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
  <h2 align="center">出入库信息变更</h2><br/>
  <form method="post" action="ioEdit02">
  <%
  io io=(io)request.getAttribute("io");
  %>
  <p>
    &nbsp;<label for="textfield2"> 商品编号 :</label>
    <input type="text" name="item_no" id="textfield2" value=<%=io.getItem_no() %> readonly>
  </p>
  <p>
    <label for="textfield3">上次供应商:</label>
    <input type="text" name="supplier0" id="textfield3" value=<%=io.getSupplier() %> readonly>
  </p>
  <p>
    <label for="textfield3">上次进货量:</label>
    <input type="text" name="io_num0" id="textfield3" value=<%=io.getIo_num() %> readonly>
  </p>
  <p>
    <label for="textfield3">上次入库时间:</label>
    <input type="text" name="io_date0" id="textfield3" value=<%=io.getIo_date() %> readonly>
  </p>
  <p>
    <label for="textfield3">上次生产日期:</label>
    <input type="text" name="pro_date0" id="textfield3" value=<%=io.getPro_date() %> readonly>
  </p>
 
  <p>
    <label for="textfield3">上次过期日期:</label>
    <input type="text" name="best_before0" id="textfield3" value=<%=io.getBest_before() %> readonly>
  </p>
    <p>
    <label for="textfield3">本次供应商:</label>
    <input type="text" name="supplier" id="textfield3" value=<%=io.getSupplier() %>>
  </p>
  <p>
    <label for="textfield3">本次进货量:</label>
    <input type="text" name="io_num" id="textfield3" >
  </p>
  <p>
    <label for="textfield3">本次入库时间:</label>
    <input type="text" name="io_date" id="textfield3" >
  </p>
  <p>
    <label for="textfield3">本次生产日期:</label>
    <input type="text" name="pro_date" id="textfield3" >
  </p>
 
  <p>
    <label for="textfield3">本次过期日期:</label>
    <input type="text" name="best_before" id="textfield3" >
  </p>
<!-- <p>
    <label for="textfield6">操作注释:</label>
    <input type="text" name="remark" id="textfield6" >
  </p> -->
  
  <br/>
  <p align="center">
    <input type="submit" name="submit" id="submit" value="提交">
  </p>
  </form>
</div>
</body>
</html>