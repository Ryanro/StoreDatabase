<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*,bean.Trans"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="table.information.*,table.money.*" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>销售信息查询</title>
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
  <h2 align="center">销售详细信息</h2>
  <br/>
  <form id="form1" name="form1" method="post" action="sale_search_result">


  <%
  money money=(money)request.getAttribute("money");
  %>
  <p>
    <label for="textfield">单号:</label>
    <input type="text" name="sale_no" id="textfield" value=<%=money.getSale_no() %>>
  </p>
  
  <c:forEach items="${sessionScope['list']}" var="sale">
<div style="background:lightgrey; width:300px; position:center;">

	<p>
	<label for="textfield3">商品编号:</label>
    <input type="text" name="item_no" id="textfield3" value=${sale['item_no']} %>
  </p>
    <p>
    <label for="textfield3">数量:</label>
    <input type="text" name="charge" id="textfield3" value=${sale['number']} %>
  </p>
</div>		

</c:forEach>
  
  <p>
    &nbsp;<label for="textfield2"> 应收 :</label>
    <input type="text" name="receivable" id="textfield2" value=<%=money.getReceivable() %>>
  </p>
  <p>
    <label for="textfield3">实收:</label>
    <input type="text" name="receipts" id="textfield3" value=<%=money.getReceipts() %>>
  </p>
    <%-- <p>
    <label for="textfield3">找零:</label>
    <input type="text" name="charge" id="textfield3" value=<%=money.getCharge() %>>
  </p> --%>
<%
  information information=(information)request.getAttribute("information");
  %>

  <p>
    <label for="textfield2">员工编号:</label>
    <input type="text" name="staff_no" id="textfield2" value=<%=information.getstaff_no() %>>
  </p>
  <p>
    <label for="textfield3">销售日期:</label>
    <input type="text" name="sale_date" id="textfield3" value=<%=information.getsale_date() %>>
  </p>
  <br/>
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