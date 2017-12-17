<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'sale_no_information.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<title>单号信息登记</title>
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
  <h2 align="center">单号信息登记</h2><br/>
  <form id="form1" name="form1" method="post" action="noinformationAdd">
  <p>
    <label for="textfield">单号:</label>
    <input type="text" name="sale_no" id="textfield" >
  </p>
  <p>
    <label for="textfield2">商品编号 :</label>
    <input type="text" name="item_no" id="textfield2">
  </p>
  <p>
    <label for="textfield3">数量:</label>
    <input type="text" name="number" id="textfield3">
  </p>
 <!--  <p>
    <label for="textfield6">操作注释:</label>
    <input type="text" name="remark" id="textfield6" >
  </p>
 -->
  <p align="center">
    <input type="submit" name="submit" id="submit" value="提交">
  </p>
  </form>
</div> 
    
  </body>
</html>
