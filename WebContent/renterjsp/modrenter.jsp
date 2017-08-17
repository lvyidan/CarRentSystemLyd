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
    
    <title>My JSP 'modrenter.jsp' starting page</title>
    
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
    <div align="center">修改租赁人信息</div>
  </center>
  <form action="mainrenter" method="post">
      <table width="95%" align="center" border="0" cellpadding="0" cellspacing="1">
	    <tr>
		  <td width="200" align="center">租赁人</td>
		  <td width="200" align="center"><input type="text" name="rentername" value="${renter.rentername}"/></td>
		  <td width="200" align="center">身份证号</td>
		  <td width="200" align="center"><input type="text" name="idnum" value="${renter.idnum}"/></td>
		</tr>
		<tr>
		  <td width="200" align="center">电话</td>
		  <td width="200" align="center"><input type="text" name="phone" value="${renter.phone}"/></td>
		  <td width="200" align="center">驾驶证号</td>
		  <td width="200" align="center"><input type="text" name="drivenum" value="${renter.drivenum}"/></td>
		</tr>
		<tr>
		  <td width="200" align="center">家庭地址</td>
		  <td width="200" align="center"><input type="text" name="address" value="${renter.address}"/></td>
		  <td width="200" align="center">工作单位</td>
		  <td width="200" align="center"><input type="text" name="workunit" value="${renter.workunit}"/></td>
		</tr>
		<tr>
		  <td width="200" align="center">备注</td>
		  <td width="200" align="center"><input type="text" name="note" value="${renter.note}"/></td>
		</tr>
		<tr>
		  <td colspan="4" align="center">	
		  <input type="hidden" name="method" value="mod">
		  <input type="hidden" name="id" value="${renter.id}"/>
			<input type="submit" value="修改" style="cursor: pointer"></td>
		</tr>
	  </table>
	  </form>
	  <center>
	    <div align="center"><a href="mainrenter">返回</a></div>
	  </center>
  </body>
</html>
