<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'modcar.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="background-image: url(images/12bg.jpg);background-repeat: repeat-x;">
     <center>
	  <div align="center">
	     修改车辆信息
	  </div>
	</center>
  
       <form action="maincar" method="post">
    <table width="95%" align="center" border="0" cellpadding="0" cellspacing="1">
	  <tr>
	    <td width="200" align="center">车辆名称</td>
		<td width="200" align="center"><input type="text" name="name" id="name" value="${car.name}"></td>
	  </tr>
	  	  <tr>
	    <td width="200" align="center">车辆类型</td>
		<td width="200" align="center"><input type="text" name="type" id="type" value="${car.type}"></td>
	  </tr>
	  	  <tr>
	    <td width="200" align="center">车牌号</td>
		<td width="200" align="center"><input type="text" name="number" value="${car.number}"></td>
	  </tr>
	  	  <tr>
	    <td width="200" align="center">每月租金</td>
		<td width="200" align="center"><input type="text" name="price" value="${car.price}"></td>
	  </tr>
	    <tr>
	    <td width="200" align="center">保险状况</td>
		<td width="200" align="center"><input type="text" name="safetype" value="${car.safetype}"></td>
	  </tr>
	  <tr>
	     <td colspan="2" align="center">
		   	<input type="hidden" name="method" value="mod">
			<input type="hidden" name="id" value="${car.id}"/>
			<input type="submit" value="修改" style="cursor: pointer">
		 </td>
	  </tr>
	</table>
	</form>
		  <center>
	    <div align="center"><a href="maincar">返回</a></div>
	  </center>
  </body>
</html>
