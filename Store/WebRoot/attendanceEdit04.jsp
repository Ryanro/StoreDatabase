<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*,table.attendance.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>缺勤信息删除</title>
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
  <h2 align="center">缺勤信息删除</h2><br/>
  <form id="form1" name="form1" method="post" action="AttendanceEdit04">
  
  <%
  Attendance attendance=(Attendance)request.getAttribute("attendance");
   %>
   
    <p>
      <label for="textfield">员工编号:</label>
      <input type="text" name="staff_no" id="textfield" value=<%=attendance.getstaff_no() %>>
    </p>
    <p>
      <label for="textfield2">缺勤日期:</label>
      <input type="text" name="absence_date" id="textfield2" value=<%=attendance.getabsence_date()%>>
    </p>
    <p>
      <label for="textfield4">缺勤原因:</label>
      <input type="text" name="absence_reason" id="textfield3" value=<%=attendance.getabsence_reason() %>>
    </p>
    <br/>
    <p align="center">
      &nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="submit" id="submit" value="删除">
    </p>
    
  </form>
  
</div>
</body>
</html>