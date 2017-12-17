<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*,table.iteminfo.*"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品信息变更</title>
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
<br/><br/>
<div id="apDiv1">
  <h2 align="center">商品信息变更</h2><br/>
  
  <form id="form1" name="form1" method="post" action="iteminfoEdit02">
  
  <%
  Iteminfo itemInfo=(Iteminfo)request.getAttribute("itemInfo");
   %>
  
  <p>
    <label for="textfield">商品编号:</label>
    <input type="text" name="item_no" id="textfield" value=<%=itemInfo.getItem_no() %> readonly >
  </p>
  <p>
    &nbsp;<label for="textfield2"> 商品名 :</label>
    <input type="text" name="item_name" id="textfield2" value=<%=itemInfo.getItem_name() %> readonly>
  </p>
  <p>
    <label for="textfield3">商品种类:</label>
    <input type="text" name="goods_type" id="textfield3" value=<%=itemInfo.getGoods_type() %> readonly>
  </p>
  <p>
    &nbsp;<label for="textfield4"> 销售价 :</label>
    <input type="text" name="sale_price" id="textfield4" value=<%=itemInfo.getSale_price() %> >
  </p>
  <p>
    &nbsp;<label for="textfield5"> 进货价 :</label>
    <input type="text" name="buying_price" id="textfield5" value=<%=itemInfo.getBuying_price() %> >
  </p>
 <!--  <p>
    <label for="textfield6">操作注释:</label>
    <input type="text" name="remark" id="textfield6" >
  </p> -->
  <br/>
  <p align="center">
    &nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="submit" id="submit" value="提交">
  </p>
  </form>
</div>
</body>
</html>