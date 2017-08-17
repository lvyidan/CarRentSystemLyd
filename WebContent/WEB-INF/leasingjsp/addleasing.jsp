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
    
    <title>My JSP 'addleasing.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	
	   	   function add(){
	   
	    var price=document.getElementById("price").value;
		var usetime=document.getElementById("usetime").value;
	    var total=document.getElementById("total");
	    var reg=/^[-]?[0-9]+\.{0,1}[0-9]{0,2}$/;
	 if(!reg.test(price)){
	         alert("请输入正确数字");
	         price=document.getElementById("price");
                     price.value=0;
                     price.focus();
			 usetime=document.getElementById("usetime");	
			 usetime.value=0;
				    
	   }else if(!reg.test(usetime)){
	         alert("请输入正确数字");
			 usetime=document.getElementById("usetime");	
			 usetime.value=0;
	   }else{
	   price=parseFloat(price);
	   usetime=parseFloat(usetime);
	   var total1=price*usetime;
	   total.value=total1;
	   }
	   }
	</script>

  </head>
  
  <body style="background-image: url(images/12bg.jpg);background-repeat: repeat-x;">
     <center>
	  <div align="center">
	     添加合同信息
	  </div>
	</center>
   <form action="mainleasing" method="post">
    <table width="95%" align="center" border="0" cellpadding="0" cellspacing="1">
	  <tr>
	    <td width="200" align="center">车牌号</td>
		<td width="200" align="center"><input type="text" name="number"></td>
		<td width="200" align="center">每月租金</td>
		<td width="200" align="center"><input type="text" name="price" id="price" onBlur="add()" value="0"></td>
	  </tr>
	  	  <tr>
	    <td width="200" align="center">租赁人</td>
		<td width="200" align="center"><input type="text" name="rentername"></td>
		<td width="200" align="center">租赁期限</td>
		<td width="200" align="center"><input type="text" name="usetime" id="usetime" value="0" onBlur="add()"></td>
	  </tr>
	    <tr>
	    <td width="200" align="center">押金</td>
		<td width="200" align="center"><input type="text" name="pledge"></td>
		 <td width="200" align="center">发车时间</td>
		<td width="200" align="center"><input type="text" name="starttime"></td>
	  </tr>
	     <tr>
	    <td width="200" align="center">经手人</td>
		<td width="200" align="center"><input type="text" name="transactor"></td>
		 <td width="200" align="center">还车时间</td>
		<td width="200" align="center"><input type="text" name="backtime"></td>
	  </tr>
	     <tr>
	    <td width="200" align="center">总金额</td>
		<td width="200" align="center"><input type="text" name="total" id="total"></td>
	    <td width="200" align="center">备注</td>
		<td width="200" align="center"><input type="text" name="note"></td>
	  </tr>
	  <tr>
	     <td colspan="4" align="center">
		   	<input type="hidden" name="method" value="add">
			<input type="submit" value="添加" style="cursor: pointer">
		 </td>
	  </tr>
	</table>
	</form>
		  <center>
	    <div align="center"><a href="mainleasing">返回</a></div>
	  </center>
  </body>
</html>
