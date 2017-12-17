<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>仓库信息变更</title>
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
  <h2 align="center">库存量查询</h2><br/>
  <h3 align="center">（将输出低于输入库存数值的全部商品）</h3><br/>
  <form id="form1" name="form1" method="get" action="ionum01">
  <p>
    <label for="textfield">请输入查询数额：</label>
    <input type="text" name="num" id="textfield" >
  </p>
 
  <br/>
  <p align="center">
    <input type="submit" name="submit" id="submit" value="提交">
  </p>
  </form></div>
</body>
</html>