<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="background:url('img/1.jpg'); background-size:cover;no-repeat;">
<br/>
 <div id="menuBar" >
 	<ul id="nav">
 	
 	<li><a>员工信息管理</a>
 	   <ul>
 	   	<li><a href="EmployeeAddPre" target="mainFrame">员工信息登记</a>
 	   	<li><a href="employeeEdit.jsp" target="mainFrame">员工信息变更</a>
 	   	</ul>
 	   	<br/>
 	  </li>
 	  
 	 <li><a>职务信息管理</a>
 	   <ul>
 	   	<li><a href="HR_jobAdd.jsp" target="mainFrame">职务信息登记</a>
 	   	<li><a href="HR_jobEdit.jsp" target="mainFrame">职务信息变更</a>
 	   	</ul>
 	   	<br/>
 	  </li>
 	  
 	 <li><a>缺勤信息管理</a>
 	   <ul>
 	   	<li><a href="attendanceAdd.jsp" target="mainFrame">缺勤信息登记</a>
 	   	<li><a href="attendanceEdit.jsp" target="mainFrame">缺勤信息变更</a>
 	   	<li><a href="attendanceEdit03.jsp" target="mainFrame">缺勤信息删除</a>
 	   	</ul>
 	   	<br/>
 	  </li>
 	  
 	 <li><a>工资信息管理</a>
 	   <ul>
 	   	<li><a href="wageAdd.jsp" target="mainFrame">工资信息登记</a>
 	   	<li><a href="wageEdit.jsp" target="mainFrame">工资信息查询</a>
 	   	</ul>
 	   	<br/>
 	  </li>
 	  
 	  <li><a>系统管理</a>
 	   <ul>
 	   	<li><a href="Logout?logoutId=1" >退出系统</a>
 	   	<li><a href="Logout?logoutId=2" >重新登录</a>
 	   	</ul>
 	   	<br/>
 	  </li>
 	  
 	</ul>
 </div>
 <br/><br/>
</body>
</html>