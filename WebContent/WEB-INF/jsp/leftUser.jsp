<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'left.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="images/dtree.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript" src="images/dtree.js"></script>
		<script type="text/javascript">

   var root=new dTree("root");
   
   root.config.target = "main";
   root.config.folderLinks=false;
   
   root.add(1,-1,'汽车租赁管理系统','','','main');
   root.add(8,1,'汽车预定 ','','','main');
   root.add(9,8,'汽车预定  ','ordercar','','mainframe');
  
   
   root.add(11,1,'用户信息 ','','','main');
   root.add(12,11,'用户基本信息','userinfo','','mainframe');
   root.add(13,11,'订单信息 ','mainorder ','','mainframe');
   

   root.add(14,1,'系统管理','','','main');
   root.add(15,14,'退出系统','jsp/exit.jsp','','_top');
   
   document.write(root);
   
</script>
</head>
 <body style="background-color: #99CC00;">
</body>
</html>
