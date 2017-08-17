<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.jd.framwork.sys.user.jdbc.DbManager"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'relogin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
      <%
        String username=request.getParameter("username");
        String password=request.getParameter("password");
         String loginresult;
        if(username!=""&&password!=""){
        ResultSet rs=DbManager.getInstance().preQuery(username,password);
        if(rs.next()){
        session.setAttribute("id",rs.getInt(1));
        session.setAttribute("username",rs.getString(2));
        response.sendRedirect("index.jsp");
        
        }else{
        
          loginresult="登录名或密码错误";
          session.setAttribute("loginresult",loginresult);
          response.sendRedirect("login.jsp");
        }}else{
           loginresult="登录名或密码不能为空！";
           session.setAttribute("loginresult",loginresult);
          response.sendRedirect("login.jsp");
        }
        
      %>
  </body>
</html>
