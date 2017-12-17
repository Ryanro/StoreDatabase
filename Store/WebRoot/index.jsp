<%@ page language="java" import="java.util.*,bean.Trans" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml" >
  <head>
    <base href="<%=basePath%>">
    
    <title>登录界面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/default.css" rel="stylesheet" type="text/css" />
	<!--必要样式-->
    <link href="css/styles.css" rel="stylesheet" type="text/css" />
    <link href="css/demo.css" rel="stylesheet" type="text/css" />
    <link href="css/loaders.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
    <div class='login'>

	  <div class='login_title' style="text-align:center;">
	    <span>管理员登录</span>
	  </div>
	  <form id="form1" name="form1" method="post" action="AdminLogin"><br/>
	  <div class='login_fields'>
	    <div class='login_fields__user'>
	      <div class='icon'>
	        <img alt="" src='img/user_icon_copy.png'>
	      </div>
	      <input name="Admname" placeholder='用户名' maxlength="16" type='text' autocomplete="off" />
	        <div class='validation'>
	          <img alt="" src='img/tick.png'>
	        </div>
	    </div><br/>
	    <div class='login_fields__password'>
	      <div class='icon'>
	        <img alt="" src='img/lock_icon_copy.png'>
	      </div>
	      <input name="Admpassword" placeholder='密码' maxlength="16" type='password' autocomplete="off">
	      <div class='validation'>
	        <img alt="" src='img/tick.png'>
	      </div><br/>
	    </div>
	    <div class='login_fields__submit' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	      &nbsp;&nbsp;<input type='submit' value='登录' >
	    </div>
	  </div>
	  <div class='success'>
	  </div>
	  <div class='disclaimer' >
	    <p style="color:#EFFFD7; text-align:center;">欢迎登录士多店数据库管理系统</p>
	  </div>
	  </form>
	</div>
	
	<%
    String msg="";
    if(request.getParameter("msg")!=null  &&  !"".equals(request.getParameter("msg"))){
        msg=request.getParameter("msg");
        msg = new Trans().change(msg);	
    }
   
     %><div style="color:#EFFFD7; text-align:center;font-size:20px;"><br/><br/>
     <span ><%=msg %></span></div>
  </body>
</html>
