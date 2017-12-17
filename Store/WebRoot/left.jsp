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
 	
 	 <li><a><strong>商品信息管理</strong></a>
 	   <ul>
 	   	<li><a href="iteminfoAddPre" target="mainFrame" ><strong>商品信息登记</strong></a>
 	   	<li><a href="iteminfoEdit.jsp" target="mainFrame"><strong>商品信息变更</strong></a>
 	   	</ul>
 	   	<br/>
 	  </li>
 	  
 	<!--  <li><a>员工信息管理</a>
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
 	  </li> -->
 	  
 	 <li><a><strong>销售信息管理</strong></a>
 	   <ul>
 	   	<li><a href="informationAddPre" target="mainFrame"><strong>销售信息登记</strong></a>
 	   	<li><a href="informationEdit.jsp" target="mainFrame"><strong>销售信息变更</strong></a>
 	 	<li><a href="salelistSearch.jsp" target="mainFrame"><strong>查看单张销售信息报表</strong></a>
 	   	
 	   	</ul>
 	   	<br/>
 	  </li>
 	  
 	 <li><a><strong>单号信息详情管理</strong></a>
 	   <ul>
 	   	<li><a href="noinfomationAdd.jsp" target="mainFrame"><strong>单号信息登记</strong></a>
 	   	<li><a href="noinformationEdit.jsp" target="mainFrame"><strong>单号信息变更</strong></a>
 	   	</ul>
 	   	<br/>
 	  </li>
 	  
 	 
 	  
 	 <li><a><strong>仓库信息管理</strong></a>
 	   <ul>
<!--  	   	<li><a href="ioAdd.jsp" target="mainFrame">仓库信息登记</a>
 --> 	   	<li><a href="ioEdit.jsp" target="mainFrame"><strong>入库信息登记</strong></a>
 	   	<li><a href="ioSearch.jsp" target="mainFrame"><strong>查看商品编号对应报表</strong></a>
 	   	<li><a href="iolistall" target="mainFrame"><strong>仓库总情况</strong></a>
 	   	<li><a href="ionum.jsp" target="mainFrame"><strong>按库存量查询</strong></a>
 	   	</ul>
 	   	<br/>
 	  </li>
 	  
 	  <li><a href="remarks" target="mainFrame"><strong>操作记录</strong></a><br/></li>
 	  <br/>
 	  <li><a><strong>系统管理</strong></a>
 	   <ul>
 	   	<li><a href="Logout?logoutId=1" ><strong>退出系统</strong></a>
 	   	<li><a href="Logout?logoutId=2" ><strong>重新登录</strong></a>
 	   	</ul>
 	   	<br/>
 	  </li>
 	  
 	</ul>
 </div>
 <br/><br/>
</body>
</html>