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
    
    <title>My JSP 'maincar.jsp' starting page</title>
    
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
			window.location.href = "maincar?method=del&id=" + id;
		}
	}
	function toWhere(){
	   var pgno=document.getElementById("pgno").value;
	   window.location.href="maincar?pg=1&pgno="+pgno;
	}
	function init(pgno){
	   document.getElementById("pgno").value=pgno;
	}
	</script>

  </head>
  
  <body onLoad="init(${pageBean.pageSize})" style="background-image: url(images/12bg.jpg);background-repeat: repeat-x;">
    
	<table width="95%" align="center" border="0" cellpadding="0" cellspacing="1">
	   <tr>
	     <td>行号</td>
		 <td>车名</td>
		 <td>车型</td>
		 <td>车牌号</td>
		 <td>每月租金</td>
		 <td>是否保险</td>
		 <td>状态</td>
		 <td>操作</td>
	   </tr>
	   <c:forEach var="car" items="${pageBean.list}" varStatus="sta">
	   <tr>
	     <td>${sta.count}</td>
		 <td>${car.name}</td>
		 <td>${car.type}</td>
		 <td>${car.number}</td>
		 <td>${car.price}</td>
		 <td>${car.safetype}</td>
		 <td>${car.obligate}</td>
		 <td><a href="maincar?method=query&id=${car.id}">修改</a> | <a href="javascript:del(${car.id})">删除</a></td>
	   </tr>
	   </c:forEach>
	</table>
	<center>
	 <div style="width:1000px; height:25px; text-align:right; padding-right:10px;">
		   当前${pageBean.page }/${pageBean.total}&nbsp;
		   <a href="maincar?pg=1&pgno=${pageBean.pageSize }">首页</a>&nbsp;&nbsp;
		   <c:if test="${pageBean.page > 1}">
		     <a href="maincar?pg=${pageBean.page-1}&pgno=${pageBean.pageSize}">上一页</a> &nbsp;&nbsp; 
		   </c:if>
		   <c:if test="${pageBean.page < pageBean.total}">
		     <a href="maincar?pg=${pageBean.page+1}&pgno=${pageBean.pageSize}">下一页</a>&nbsp;&nbsp;
		   </c:if>
		     <a href="maincar?pg=${pageBean.total}&pgno=${pageBean.pageSize}">末页</a>&nbsp;&nbsp;
		     每页显示<select name="pgno" id="pgno" onChange="toWhere()">
		          <option value="2">2</option>
		           <option value="3">3</option>
		            <option value="4">4</option>
		             <option value="5">5</option>
		     </select>  
		   </div>
	</center>
	
  </body>
</html>
