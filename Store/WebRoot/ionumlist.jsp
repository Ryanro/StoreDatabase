<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
table{  
    border: solid 1px #B4B4B4;  
    border-collapse: collapse;     --折叠样式.  
}  
 tr th{  
    background:url("../../images/gray/bg_table_th.gif") repeat;  
    padding-left:4px;  
    height:27px;  
    border: solid 1px #B4B4B4;  
}  
 tr td{  
    height:25px;  
    padding:4px;  
    border: solid 1px #B4B4B4;  
}  
</style>
</head>
<body style="background:url('img/1.jpg'); background-size:cover;no-repeat;">
<%
   String resultstr="";
   if(session.getAttribute("resultstr")!=null){
        resultstr=session.getAttribute("resultstr").toString();
        out.println(resultstr);
   
   }
   
    %>
</body>
</html>