<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*,bean.Trans"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>职务信息变更</title>
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

<body style="background:url('img/1.jpg'); background-size:cover;no-repeat;"><br/><br/>
<div id="apDiv1"> 
<br/><br/>
  <h2 align="center">职务信息查询</h2>
  <form id="form1" name="form1" method="post" action="HR_jobEdit01">
    <p>
      <label for="textfield">职位:</label>
      <input type="text" name="job" id="textfield" />
    </p>
    <p align="center">
      <input type="submit" name="submit" id="submit" value="提交" />
         
    </p>
  </form>
 
</div>
<br/><br/>
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