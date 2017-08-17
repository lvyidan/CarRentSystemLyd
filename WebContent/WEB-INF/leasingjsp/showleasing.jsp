<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showleasing.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	function mod(id) {
	var obligate=document.getElementById("obligate").value;
	  if("进行中"==obligate){	  
		  
	   var renewal=document.getElementById("renewal").value; 
		if ("否"==renewal) {	
			window.location.href = "mainleasing?method=query&id=" + id;
		}else{
		   window.location.href = "mainleasing?method=queryf&id=" + id;
		}}else{
	      alert('该合同已完成，不能进行此操作！');
		  window.location.href = "mainleasing?method=queryt&id=" + id;
	   }
	}
	function mods(id){
	 var obligate=document.getElementById("obligate").value;
	  if("进行中"==obligate){
	   var renewal=document.getElementById("renewal").value;
	   if("否"==renewal){
	      window.location.href = "mainleasing?method=querys&id=" + id;
	   }else{
	      alert('以续约一次，如需再次使用车辆，请重新租赁！');
	   }}else{
	      alert('该合同已完成，不能进行此操作！');
		  window.location.href = "mainleasing?method=queryt&id=" + id;
	   }
	}
	function backcar(id,number){
	 var obligate=document.getElementById("obligate").value;
	  if("进行中"==obligate){
	   if (confirm("确定车辆已返还了吗")) {
	      window.location.href = "mainleasing?method=backs&id=" + id +"&number=" + number;
	   }else{
	      window.location.href = "mainleasing?method=queryt&id=" + id;
	   }}else{
	      alert('该合同已完成，不能进行此操作！');
		  window.location.href = "mainleasing?method=queryt&id=" + id;
	   }
	}
	   
	</script>

  </head>
  
  <body style="background-image: url(images/12bg.jpg);background-repeat: repeat-x;">
 
      <table width="95%" align="center" border="0" cellpadding="0" cellspacing="1">
	    <tr>
	     <td colspan="2" width="200" align="center">状态</td>
		 <td colspan="2" width="200" align="center"><input type="text" name="obligate" id="obligate" value="${leasing.obligate}" readonly="readonly"></td>
	  </tr>
	  <tr>
	    <td width="200" align="center">车牌号</td>
		<td width="200" align="center"><input type="text" name="number" value="${leasing.number}"></td>
		<td width="200" align="center">每月租金</td>
		<td width="200" align="center"><input type="text" name="price" value="${leasing.price}" onBlur="add()"></td>
	  </tr>
	  	  <tr>
	    <td width="200" align="center">租赁人</td>
		<td width="200" align="center"><input type="text" name="rentername" value="${leasing.rentername}"></td>
		<td width="200" align="center">租赁期限</td>
		<td width="200" align="center"><input type="text" name="usetime" value="${leasing.usetime}" onBlur="add()"></td>
	  </tr>
	    <tr>
	    <td width="200" align="center">押金</td>
		<td width="200" align="center"><input type="text" name="pledge" value="${leasing.pledge}"></td>
		 <td width="200" align="center">发车时间</td>
		<td width="200" align="center"><input type="text" name="starttime" value="${leasing.starttime}"></td>
	  </tr>
	     <tr>
	    <td width="200" align="center">经手人</td>
		<td width="200" align="center"><input type="text" name="transactor" value="${leasing.transactor}"></td>
		 <td width="200" align="center">还车时间</td>
		<td width="200" align="center"><input type="text" name="backtime" value="${leasing.backtime}"></td>
	  </tr>
	     <tr>
	    <td width="200" align="center">总金额</td>
		<td width="200" align="center"><input type="text" name="total" value="${leasing.total}"></td>
	    <td width="200" align="center">备注</td>
		<td width="200" align="center"><input type="text" name="note" value="${leasing.note}"></td>
	  </tr>
	  <tr>
	     <td width="200" align="center">是否续约</td>
		 <td width="200" align="center"><input type="text" name="renewal" id="renewal" value="${leasing.renewal}"></td>
	  </tr>
	   <tr>
	    <td width="200" align="center">延长期限</td>
		<td width="200" align="center"><input type="text" name="rtime" id="rtime" value="${leasing.rtime}"></td>
	    <td width="200" align="center">续约经手人</td>
		<td width="200" align="center"><input type="text" name="rtransactor" value="${leasing.rtransactor}"></td>
	  </tr>
	</table>
	 <center>
	 <div><a href="javascript:mod(${leasing.id})">修改</a> |<a href="javascript:mods(${leasing.id})">续约</a> | <a href="javascript:backcar(${leasing.id},${leasing.number})">返还</a></div>
	 <div><a href="mainleasing">返回</a></div>
  </center>
  </body>
</html>
