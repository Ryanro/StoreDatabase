<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>管理员首页</title>
<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	
	
</head >
<frameset rows="110,*" cols="*" frameborder="no" border="0" framespacing="0" >
	<frame src="top.jsp" name="topFrame" scrolling="no" noresize="noresize" id="topFrame"/>
	<frameset cols="250,*" frameborder="no" border="0" framespacing="0">
		<frame src="left.jsp" name="leftFrame" scrolling="yes" noresize="noresize" id="leftFrame"/>
		<frame src="mainFrame.jsp" name="mainFrame" scrolling="yes" id="mainFrame"/>
	</frameset>
</frameset>
<body>
<%
	String senPara;
	senPara=(String)session.getAttribute("login");
	
	if(senPara==null){
		request.getRequestDispatcher("index.jsp").forward(request,response);
	}
 %>
</body>
</html>