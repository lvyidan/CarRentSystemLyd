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
    
    <title>My JSP 'mainuser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	
		function del(id) {
		if (confirm("确定要删除吗？")) {
			window.location.href = "userinfo?method=del&id=" + id;
		}else{
		   window.location.href = "userinfo";
		}
		}
	</script>

  </head>
  
  <body onLoad="init(${pageBean.pageSize})" style="background-image: url(images/12bg.jpg);background-repeat: repeat-x;">
     <table width="95%" align="center" border="0" cellpadding="0" cellspacing="1">
	   <tr>
		 <td>用户名</td>
		 <td>电话</td>
		 <td>性别</td>
		 <td>年龄</td>
		<td>身份证号</td>
		 <td>家庭住址</td>
		 <td>备注</td>
	   </tr>
	   <tr>
		 <td>${user.username}</td>
		 <td>${user.phone}</td>
		 <td>${user.sex}</td>
		 <td>${user.age}</td>
		 <td>${user.idnum}</td>
		 <td>${user.address}</td>
		 <td>${user.note}</td>
		 <td><a href="userinfo?method=query&name=${user.username}">修改</a></td>
	   </tr>
	 </table>
	
  </body>
</html>
