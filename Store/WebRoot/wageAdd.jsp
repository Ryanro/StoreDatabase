<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>工资信息登记</title>
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
  <h2 align="center">工资信息登记</h2><br/>
  <form id="form1" name="form1" method="post" action="wageAdd">
    <p>
      <label for="textfield">员工编号:</label>
      <input type="text" name="staff_no" id="textfield" >
    </p>
    
    <p>
      <label for="textfield4">发放年月:</label>
      <input type="text" name="wage_date" id="textfield4">
    </p>
	   

    <br/>
    <p align="center">
      &nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="submit" id="submit" value="提交">
    </p>
    
  </form>
  
</div>
</body>
</html>