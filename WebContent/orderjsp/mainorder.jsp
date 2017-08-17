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
    
    <title>My JSP 'mainleasing.jsp' starting page</title>
    
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
		if (confirm("确定要取消吗？ ")) {
			window.location.href = "mainorder?method=cancel&id=" + id;
		}
	}
	</script>

  </head>
  
  <body onLoad="init(${pageBean.pageSize})" style="background-image: url(images/12bg.jpg);background-repeat: repeat-x;">
     <table width="95%" align="center" border="0" cellpadding="0" cellspacing="1" >
	   <tr>
	     
		 <td align="center">车牌号</td>
		 <td align="center">每月租金</td>
		 <td align="center">租赁人</td>
		 <td align="center">租赁期限</td>
		 <td align="center">押金</td>
		 <td align="center">经手人</td>
		 <td align="center">发车时间</td>
	   </tr>
	   
	   <tr>
		 <td align="center">${leasing.number}</td>
		 <td align="center">${leasing.price}</td>
		 <td align="center">${leasing.rentername}</td>
		 <td align="center">${leasing.usetime}</td>
		 <td align="center">${leasing.pledge}</td>
		 <td align="center">${leasing.transactor}</td>
		 <td align="center">${leasing.starttime}</td>
		 <td align="center"> <a href="javascript:del(${leasing.id})">取消订单</a></td>
	   </tr>

	 </table>
  </body>
</html>
