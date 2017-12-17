<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品信息登记</title>
<style type="text/css">
#apDiv1{
z-index:1;
margin:0 auto; 
width:400px; 
height:200px;
}
body{
text-align:center;
}
</style>

</head>
<body style="background:url('img/1.jpg'); background-size:cover;no-repeat;">
<br/><br/>
<div id="apDiv1">
  <h2 align="center">商品信息登记</h2><br/>
  
  <form id="form1" name="form1" method="post" action="iteminfoAdd">
  <p>
    <label for="textfield">商品编号:</label>
    <input type="text" name="item_no" id="textfield" value=<%=request.getAttribute("item_no") %>>
  </p>
  <p>
    &nbsp;<label for="textfield2"> 商品名 :</label>
    <input type="text" name="item_name" id="textfield2">
  </p>
  <p>
    <label for="textfield3">商品种类:</label>
    <input type="text" name="goods_type" id="textfield3">
  </p>
  <p>
    &nbsp;<label for="textfield4"> 销售价 :</label>
    <input type="text" name="sale_price" id="textfield4">
  </p>
  <p>
    &nbsp;<label for="textfield5"> 进货价 :</label>
    <input type="text" name="buying_price" id="textfield5">
  </p>
  <p>
    <label for="textfield3">  供应商 :</label>
    <input type="text" name="supplier" id="textfield6">
  </p>
  <p>
    <label for="textfield3">  进货量 :</label>
    <input type="text" name="io_num" id="textfield7">
  </p>
  
    <p>
    <label for="textfield3">入库时间:</label>
    <input type="text" name="io_date" id="textfield8">
  </p>
  
    <p>
    <label for="textfield3">生产日期:</label>
    <input type="text" name="pro_date" id="textfield9">
  </p>

<p>
    <label for="textfield3">过期日期:</label>
    <input type="text" name="best_before" id="textfield10">
  </p>
  <!-- <p>
    <label for="textfield6">操作注释:</label>
    <input type="text" name="remark" id="textfield11">
  </p> -->
  <br/>
  <p align="center">
    &nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="submit" id="submit" value="提交">
  </p>
  </form>
</div>
</body>
</html>