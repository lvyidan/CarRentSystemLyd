<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <frameset rows="100,*" frameborder="no">
  
		<frame name="top" src="headpage" noresize scrolling="no">
		
		<frameset cols="200,*">
			<frame name="lower_left" src="leftUser" noresize scrolling="no">
			<frame name="mainframe" src="homepage" scrolling="auto">
		</frameset>
	</frameset>
	<noframes></noframes> 
	<!-- 提交参数 -->
	   <body>
	   <form action="getParam" method="post" enctype="multipart/form-data">
             <!-- <input type="hidden" name="username" value="${username.username}"/>   -->
              <input type="text" name="username" id="usetime" value="${user.username}" onBlur="add()" readonly="readonly">
       </form>
	   </body>
</html>
