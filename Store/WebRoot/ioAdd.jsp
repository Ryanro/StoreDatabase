<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>仓库信息登记</title>
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
    
  <h2 align="center">仓库信息登记</h2><br/>
  <form id="form1" name="form1" method="post" action="ioAdd">
 <!--  <p>
    <label for="textfield">入库单号:</label>
    <input type="text" name="io_no" id="textfield">
  </p> -->
  <p>
    <label for="textfield2"> 商品编号 :</label>
    <input type="text" name="item_no" id="textfield2" >
  </p>
  <p>
    <label for="textfield3">  供应商 :</label>
    <input type="text" name="supplier" id="textfield3">
  </p>
  <p>
    <label for="textfield3">  进货量 :</label>
    <input type="text" name="io_num" id="textfield4">
  </p>
  
    <p>
    <label for="textfield3">入库时间:</label>
    <input type="text" name="io_date" id="textfield5">
  </p>
  
    <p>
    <label for="textfield3">生产日期:</label>
    <input type="text" name="pro_date" id="textfield6">
  </p>

<p>
    <label for="textfield3">过期日期:</label>
    <input type="text" name="best_before" id="textfield7">
  </p>
  
 <!--  <p>
    <label for="textfield3">库存量:</label>
    <input type="text" name="remain_num" id="textfield8">
  </p> -->

  <p align="center">
    <input type="submit" name="submit" id="submit" value="提交">
  </p>
  </form>
</div> 
  </body>
</html>
