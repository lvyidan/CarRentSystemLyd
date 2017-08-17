<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adduser.jsp' starting page</title>
    
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
    <div align="center">添加用户</div>
  </center>
  <form action="mainuser" method="post">
      <table width="95%" align="center" border="0" cellpadding="0" cellspacing="1">
	    <tr>
		  <td width="200" align="center">用户姓名</td>
		  <td width="200" align="center"><input type="text" name="username"/></td>
		  <td width="200" align="center">电话</td>
		  <td width="200" align="center"><input type="text" name="phone"/></td>
		</tr>
		<tr>
		  <td width="200" align="center">性别</td>
		  <td width="200" align="center"><input type="radio" name="sex" value="男"/>男
		  <input type="radio" name="sex" value="女"/>女</td>
		  <td width="200" align="center">年龄</td>
		  <td width="200" align="center"><input type="text" name="age"/></td>
		</tr>
		<tr>
		  <td width="200" align="center">身份证号</td>
		  <td width="200" align="center"><input type="text" name="idnum"/></td>
		  <td width="200" align="center">家庭住址</td>
		  <td width="200" align="center"><input type="text" name="address"/></td>
		</tr>
		<tr>
		<td width="200" align="center">密码</td>
		  <td width="200" align="center"><input type="text" name="password"/></td>
		  <td width="200" align="center">备注</td>
		  <td width="200" align="center"><input type="text" name="note"/></td>
		</tr>
		<tr>
		  <td colspan="4" align="center">	<input type="hidden" name="method" value="add">
			<input type="submit" value="添加" style="cursor: pointer"></td>
		</tr>
	  </table>
	  </form>
	  	  <center>
	    <div align="center"><a href="login">返回</a></div>
	  </center>
  </body>
</html>
