<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="table.iteminfo.*,table.io.*"%>	
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ioSearchResult.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="background:url('img/1.jpg'); background-size:cover;no-repeat;">
<div id="apDiv1">
  <h2 align="center">商品库存信息</h2><br/>
  
  <form id="form1" name="form1" align="center" method="post" action="">
  
  <%
  Iteminfo itemInfo=(Iteminfo)request.getAttribute("itemInfo");
   %>
  
  <p>
    <label for="textfield">商品编号:</label>
    <input type="text" name="item_no" id="textfield" value=<%=itemInfo.getItem_no() %> >
  </p>
  <p>
    &nbsp;<label for="textfield2"> 商品名 :</label>
    <input type="text" name="item_name" id="textfield2" value=<%=itemInfo.getItem_name() %> >
  </p>
  <p>
    <label for="textfield3">商品种类:</label>
    <input type="text" name="goods_type" id="textfield3" value=<%=itemInfo.getGoods_type() %> >
  </p>
  <p>
    &nbsp;<label for="textfield4"> 销售价 :</label>
    <input type="text" name="sale_price" id="textfield4" value=<%=itemInfo.getSale_price() %> >
  </p>
  <p>
    &nbsp;<label for="textfield5"> 进货价 :</label>
    <input type="text" name="buying_price" id="textfield5" value=<%=itemInfo.getBuying_price() %> >
  </p>
    <%
  io io=(io)request.getAttribute("io");
  %>
 <%-- <%--  <p>
    &nbsp;<label for="textfield2"> 商品编号 :</label>
    <input type="text" name="item_no" id="textfield2" value=<%=io.getItem_no() %>>
  </p> --%> 
  <p>
    <label for="textfield3">供应商:</label>
    <input type="text" name="supplier" id="textfield3" value=<%=io.getSupplier() %>>
  </p>
  <p>
    <label for="textfield3">进货量:</label>
    <input type="text" name="io_num" id="textfield3" value=<%=io.getIo_num() %>>
  </p>
  <p>
    <label for="textfield3">入库时间:</label>
    <input type="text" name="io_date" id="textfield3" value=<%=io.getIo_date() %>>
  </p>
  <p>
    <label for="textfield3">生产日期:</label>
    <input type="text" name="pro_date" id="textfield3" value=<%=io.getPro_date() %>>
  </p>
 
  <p>
    <label for="textfield3">过期日期:</label>
    <input type="text" name="best_before" id="textfield3" value=<%=io.getBest_before() %>>
  </p>
   <p>
    <label for="textfield3">  库存量 :</label>
    <input type="text" name="remain_num" id="textfield3" value=<%=io.getRemain_num() %>>
  </p>
  <p>
    &nbsp;&nbsp;&nbsp;<label for="textfield6">备注&nbsp;&nbsp;&nbsp;:</label>
    <input type="text" name="item_ps" id="textfield6" value=<%=itemInfo.getItem_ps() %>>
  </p></form>
  </body>
</html>
