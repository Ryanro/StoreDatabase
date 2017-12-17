<%@ page language="java" contentType="text/html;  charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>职务信息登记</title>
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
  <h2 align="center">职务信息登记</h2><br/><br/>
  <form id="form1" name="form1" method="post" action="HR_jobadd">
    <p>
      &nbsp;&nbsp;&nbsp;<label for="textfield">职位&nbsp;&nbsp;&nbsp;:</label>
      <input type="text" name="job" id="textfield" />
    </p>
    <p>
      &nbsp;&nbsp;&nbsp;<label for="textfield2">部门&nbsp;&nbsp;&nbsp;:</label>
      <input type="text" name="partment" id="textfield2" />
    </p>
    <p>
      <label for="textfield3">基本工资:</label>
      <input type="text" name="basic_wage" id="textfield3" />
    </p>
    <p align="center">
      &nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="submit" id="submit" value="提交" />
    </p>
  </form>

</div>
</body>
</html>