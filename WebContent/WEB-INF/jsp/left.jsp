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
   root.add(2,1,'车辆管理','','','main');
   root.add(3,2,'车辆信息','maincar','','mainframe');
   root.add(4,2,'添加车辆','carjsp/addcar.jsp','','mainframe');
   
   
   root.add(5,1,'租赁人管理','','','main');
   root.add(6,5,'租赁人信息','mainrenter','','mainframe');
   root.add(7,5,'添加租赁人','renterjsp/addrenter.jsp','','mainframe');

   
   root.add(8,1,'租赁合同管理','','','main');
   root.add(9,8,'租赁合同信息','mainleasing','','mainframe');
   root.add(10,8,'添加合同','leasingjsp/addleasing.jsp','','mainframe');
   
   root.add(11,1,'用户管理','','','main');
   root.add(12,11,'用户信息','mainuser','','mainframe');
   root.add(13,11,'添加用户','userjsp/adduser.jsp','','mainframe');
   

   root.add(14,1,'系统管理','','','main');
   root.add(15,14,'退出系统','jsp/exit.jsp','','_top');
   
   document.write(root);
   
</script>
</head>
 <body style="background-color: #99CC00;">
</body>
</html>
