<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="images/home.css" rel="stylesheet" type="text/css" />

  </head>
  
  <body style="background-color:#D5F499">
     <div class="b_w">
   <div class="l_t">
   
	 
   </div>
  <div class="l_bg">
  
  <h2>登陆</h2>
    <form action="syslogin" method="post" enctype="multipart/form-data">
    <ul class="l_user">
	  <li>帐户：<input name="account" value="" size="14" type="text" class="l_input" style="width:120;"/></li>
	  <li>密码：<input name="password" value="" size="14" type="password" class="l_input" style="width:120;"/></li>
	  <li><input class="l_bnt" accesskey="login" value="登 录" type="submit" />　<input class="l_bnt" value="重 写" type="reset" /></li>
	  <li>${loginresult}</li>
	</ul>
	  </form>
  </div>
  
  <div class="l_f">
    <div class="left"><img src="images/f_l.gif" /></div>
	<div class="left">
		<img src="images/f_bg.gif" width="378" height="36"/></div>
	<div class="right"><img src="images/f_r.gif" /></div>
  </div>
</div>
  </body>
</html>
