<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*,bean.Trans"
    pageEncoding="UTF-8"%>
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
  <form id="form1" name="form1" method="post" action="noinformationEdit01">
  <p>
    <label for="textfield">单号:</label>
    <input type="text" name="sale_no" id="textfield">
  </p>
  <p>
    <label for="textfield2">商品编号 :</label>
    <input type="text" name="item_no" id="textfield2">
  </p> 
  <br/>
  <p align="center">
    <input type="submit" name="submit" id="submit" value="提交">
  </p>
  </form>
</div>
<%
    String msg="";
    if(request.getParameter("msg")!=null  &&  !"".equals(request.getParameter("msg"))){
        msg=request.getParameter("msg");
        msg = new Trans().change(msg);	
    
   }
     %>
     <br/><br/>
<div style="color:red; text-align:center;font-size:15px;"><br/><br/>
     <span ><%=msg %></span></div>
</body>
</html>
