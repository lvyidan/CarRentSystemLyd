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
    
    <title>My JSP 'mainrenter.jsp' starting page</title>
    
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
			window.location.href = "mainrenter?method=del&id=" + id;
		}else{
		   window.location.href = "mainrenter";
		}
	}
	function goto(){
	   var pgno=document.getElementById("pgno").value;
	   window.location.href="mainrenter?pg=1&pgno="+pgno;
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
		 <td>租赁人</td>
		 <td>身份证号</td>
		 <td>电话</td>
		 <td>驾驶证号</td>
		 <td>家庭住址</td>
		 <td>工作单位</td>
		 <td>备注</td>
		 <td>操作</td>
	   </tr>
	      <c:forEach var="renter" items="${pageBean.list}" varStatus="sta">
	   <tr>
	     <td>${sta.count}</td>
		 <td>${renter.rentername}</td>
		 <td>${renter.idnum}</td>
		 <td>${renter.phone}</td>
		 <td>${renter.drivenum}</td>
		 <td>${renter.address}</td>
		 <td>${renter.workunit}</td>
		 <td>${renter.note}</td>
		 <td><a href="mainrenter?method=query&id=${renter.id}">修改</a> | <a href="javascript:del(${renter.id})">删除</a></td>
	   </tr>
	     </c:forEach>
	 </table>
	 <center>
	 <div style="width:1000px; height:25px; text-align:right; padding-right:10px;">
		   当前${pageBean.page }/${pageBean.total}&nbsp;
		   <a href="mainrenter?pg=1&pgno=${pageBean.pageSize }">首页</a>&nbsp;&nbsp;
		   <c:if test="${pageBean.page > 1}">
		     <a href="mainrenter?pg=${pageBean.page-1}&pgno=${pageBean.pageSize}">上一页</a> &nbsp;&nbsp; 
		   </c:if>
		   <c:if test="${pageBean.page < pageBean.total}">
		     <a href="mainrenter?pg=${pageBean.page+1}&pgno=${pageBean.pageSize}">下一页</a>&nbsp;&nbsp;
		   </c:if>
		     <a href="mainrenter?pg=${pageBean.total}&pgno=${pageBean.pageSize}">末页</a>&nbsp;&nbsp;
		     每页显示<select name="pgno" id="pgno" onChange="goto()">
		          <option value="2">2</option>
		           <option value="3">3</option>
		            <option value="4">4</option>
		             <option value="5">5</option>
		     </select>  
		   </div>
	</center>
  </body>
</html>
