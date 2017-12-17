<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="table.information.*,table.money.*"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>销售信息变更</title>
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
<div id="apDiv1">
  <h2 align="center">销售信息变更</h2><br/>
  <form method="post" action="informationEdit02">
  <%
  information information=(information)request.getAttribute("information");
  money money=(money)request.getAttribute("money");
  %>
  <p>
     &nbsp;&nbsp;&nbsp;<label for="textfield">单号 &nbsp;&nbsp;&nbsp;:</label>
    <input type="text" name="sale_no" id="textfield" value=<%=information.getsale_no() %> readonly>
  </p>
  <p>
    <label for="textfield2">员工编号:</label>
    <input type="text" name="staff_no" id="textfield2" value=<%=information.getstaff_no() %> readonly>
  </p>
  <p>
    <label for="textfield3">销售日期:</label>
    <input type="text" name="sale_date" id="textfield3" value=<%=information.getsale_date() %> readonly>
  </p>
<%-- <p>
    &nbsp;<label for="textfield6"> 应收 :</label>
    <input type="text" name="receivable" id="textfield6" value=<%=money.getReceivable() %>>
  </p> --%>  
  <p>
    <label for="textfield3">实收金额:</label>
    <input type="text" name="receipts" id="textfield4" value=<%=money.getReceipts() %>>
  </p>
  <!-- <p>
    <label for="textfield6">操作注释:</label>
    <input type="text" name="remark" id="textfield6" >
  </p> -->
 <%--  <p>
    &nbsp;<label for="textfield7"> 找零 :</label>
    <input type="text" name="receivable" id="textfield7" value=<%=money.getCharge() %>>
  </p> --%>  
  <br/>
  <p align="center">
     &nbsp;&nbsp;&nbsp; &nbsp;<input type="submit" name="submit" id="submit" value="提交">
  </p>
  </form>
</div>
</body>
</html>