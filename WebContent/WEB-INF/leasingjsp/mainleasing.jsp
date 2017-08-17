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
		if (confirm("确定要删除吗？")) {
			window.location.href = "mainleasing?method=del&id=" + id;
		}
	}
	function toWhere(){
	   var pgno=document.getElementById("pgno").value;
	   window.location.href="mainleasing?pg=1&pgno="+pgno;
	}
	function init(pgno){
	   document.getElementById("pgno").value=pgno;
	}
	</script>

  </head>
  
  <body onLoad="init(${pageBean.pageSize})" style="background-image: url(images/12bg.jpg);background-repeat: repeat-x;">
     <table width="95%" align="center" border="0" cellpadding="0" cellspacing="1" >
	   <tr>
	     <td align="center">合同号</td>
		 <td align="center">车牌号</td>
		 <td align="center">每月租金</td>
		 <td align="center">租赁人</td>
		 <td align="center">租赁期限</td>
		 <td align="center">押金</td>
		 <td align="center">经手人</td>
		 <td align="center">发车时间</td>
		 <td align="center">操作</td>
	   </tr>
	   <c:forEach var="leasing" items="${pageBean.list}" varStatus="sta">
	   <tr>
	     <td align="center">${sta.count}</td>
		 <td align="center">${leasing.number}</td>
		 <td align="center">${leasing.price}</td>
		 <td align="center">${leasing.rentername}</td>
		 <td align="center">${leasing.usetime}</td>
		 <td align="center">${leasing.pledge}</td>
		 <td align="center">${leasing.transactor}</td>
		 <td align="center">${leasing.starttime}</td>
		 <td align="center"><a href="mainleasing?method=queryt&id=${leasing.id}">查看</a></td>
	   </tr>
	    </c:forEach>
	 </table>
	 <center>
	 <div style="width:1000px; height:25px; text-align:right; padding-right:10px;">
		   当前${pageBean.page }/${pageBean.total}&nbsp;
		   <a href="mainleasing?pg=1&pgno=${pageBean.pageSize }">首页</a>&nbsp;&nbsp;
		   <c:if test="${pageBean.page > 1}">
		     <a href="mainleasing?pg=${pageBean.page-1}&pgno=${pageBean.pageSize}">上一页</a> &nbsp;&nbsp; 
		   </c:if>
		   <c:if test="${pageBean.page < pageBean.total}">
		     <a href="mainleasing?pg=${pageBean.page+1}&pgno=${pageBean.pageSize}">下一页</a>&nbsp;&nbsp;
		   </c:if>
		     <a href="mainleasing?pg=${pageBean.total}&pgno=${pageBean.pageSize}">末页</a>&nbsp;&nbsp;
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
