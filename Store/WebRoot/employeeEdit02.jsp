<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*,table.employee.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工信息变更</title>
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
  <h2 align="center">员工信息变更</h2><br/>
  <form id="form1" name="form1" method="post" action="EmployeeEdit02">
  
  <%
  Employee employee=(Employee)request.getAttribute("employee");
   %>
   
    <p>
      <label for="textfield">员工编号:</label>
      <input type="text" name="staff_no" id="textfield" value=<%=employee.getStaff_no() %> >
    </p>
    <p>
      <label for="textfield2">员工姓名:</label>
      <input type="text" name="staff_name" id="textfield2" value=<%=employee.getStaff_name() %>>
    </p>
    <p>员工性别：
      <label>&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="radio" name="sex" value="男" 
        <% if(employee.getSex().equals("男")){ %>
         checked="checked"
         <% } %> >男</label>
      
      <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="radio" name="sex" value="女" 
        <% if(employee.getSex().equals("女")){ %>
         checked="checked"
         <% } %>>女</label>
    </p>
    <p>
      <label for="textfield3">员工年龄:</label>
      <input type="text" name="age" id="textfield3" value=<%=employee.getAge() %>>
    </p>
    <p>
      <label for="textfield4">员工职务:</label>
      <input type="text" name="job" id="textfield4" value=<%=employee.getJob() %>>
    </p>
    <p>
    &nbsp;&nbsp;&nbsp;<label for="textfield4">备注&nbsp;&nbsp;&nbsp;:</label>
    <input type="text" name="staff_ps" id="textfield5" value=<%=employee.getStaff_ps() %>>
  </p>
    <br/>
    <p align="center">
      &nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="submit" id="submit" value="提交">
    </p>
    
  </form>
  
</div>
</body>
</html>