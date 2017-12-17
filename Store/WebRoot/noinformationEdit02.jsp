<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="table.noinformation.*"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>销售单号信息变更</title>
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
  <h2 align="center">销售单号信息变更</h2><br/>
  <form method="post" action="noinformationEdit02">
  <%
  noinformation noinformation=(noinformation)request.getAttribute("noinformation");
  %>
  <p>
    <label for="textfield">单号:</label>
    <input type="text" name="sale_no" id="textfield" value=<%=noinformation.getSale_no() %> readonly>
  </p>
  <p>
    &nbsp;<label for="textfield2"> 商品编号 :</label>
    <input type="text" name="item_no" id="textfield2" value=<%=noinformation.getGoods_no() %> readonly>
  </p>
  <p>
    <label for="textfield3">数量:</label>
    <input type="text" name="number" id="textfield3" value=<%=noinformation.getNumber() %>>
  </p>
<p>
    <label for="textfield6">操作注释:</label>
    <input type="text" name="remark" id="textfield6" >
  </p>


  
  <br/>
  <p align="center">
    <input type="submit" name="submit" id="submit" value="提交">
  </p>
  </form>
</div>
</body>
</html>
