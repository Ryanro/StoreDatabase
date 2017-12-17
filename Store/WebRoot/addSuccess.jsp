<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*,bean.Trans"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>处理结果</title>
<style type="text/css">
body{
text-align:center;
}

</style>
</head>
<body style="background:url('img/1.jpg'); background-size:cover;no-repeat;">
<br/><br/><br/><br/>
<font size="10">恭喜您，信息处理成功！</font>
<br/><br/>
<%
    String msg="";
    if(request.getParameter("msg")!=null  &&  !"".equals(request.getParameter("msg"))){
        msg=request.getParameter("msg");
        msg = new Trans().change(msg);	
    
   }
     %>
     <br/><br/>
<div style="color:red; text-align:center;font-size:25px;"><br/><br/>
     <span ><%=msg %></span></div>
</body>
</html>