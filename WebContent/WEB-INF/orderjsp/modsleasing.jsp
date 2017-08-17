<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'modsleasing.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script type="text/javascript">
	
	   	   function adds(){
	    var price=document.getElementById("price").value;
		var usetime=document.getElementById("usetime").value;
		var rtime=document.getElementById("rtime").value;
	    var total=document.getElementById("total");
	    var reg=/^[-]?[0-9]+\.{0,1}[0-9]{0,2}$/;
	 if(!reg.test(rtime)){
	         alert("请输入正确数字");
	         rtime=document.getElementById("price");
                     rtime.value=0;
                     rtime.focus();
	   }else{
	   price=parseFloat(price);
	   usetime=parseFloat(usetime);
	   rtime=parseFloat(rtime);
	   var s=usetime+rtime;
	   var total1=price*s;
	   total.value=total1;
	   }
	   }
	</script>

  </head>
  
  <body style="background-image: url(images/12bg.jpg);background-repeat: repeat-x;">
      <center>
	  <div align="center">
	     修改合同信息
	  </div>
	</center>
   <form action="mainorder" method="post">
    <table width="95%" align="center" border="0" cellpadding="0" cellspacing="1">
	  <tr>
	    <td width="200" align="center">车牌号</td>
		<td width="200" align="center"><input type="text" name="number" value="${leasing.number}" readonly="readonly"></td>
		<td width="200" align="center">每月租金</td>
		<td width="200" align="center"><input type="text" name="price" id="price" value="${leasing.price}" onBlur="add()" readonly="readonly"></td>
	  </tr>
	  	  <tr>
	    <td width="200" align="center">租赁人</td>
		<td width="200" align="center"><input type="text" name="rentername" value="${leasing.rentername}" readonly="readonly"></td>
		<td width="200" align="center">租赁期限</td>
		<td width="200" align="center"><input type="text" name="usetime" id="usetime" value="${leasing.usetime}" onBlur="add()" readonly="readonly"></td>
	  </tr>
	    <tr>
	    <td width="200" align="center">押金</td>
		<td width="200" align="center"><input type="text" name="pledge" value="${leasing.pledge}" readonly="readonly"></td>
		 <td width="200" align="center">发车时间</td>
		<td width="200" align="center"><input type="text" name="starttime" value="${leasing.starttime}" readonly="readonly"></td>
	  </tr>
	     <tr>
	    <td width="200" align="center">经手人</td>
		<td width="200" align="center"><input type="text" name="transactor" value="${leasing.transactor}" readonly="readonly"></td>
		 <td width="200" align="center">还车时间</td>
		<td width="200" align="center"><input type="text" name="backtime" value="${leasing.backtime}" readonly="readonly"></td>
	  </tr>
	     <tr>
	    <td width="200" align="center">总金额</td>
		<td width="200" align="center"><input type="text" name="total" id="total" value="${leasing.total}" readonly="readonly"></td>
	    <td width="200" align="center">备注</td>
		<td width="200" align="center"><input type="text" name="note" value="${leasing.note}"></td>
	  </tr>
	    <tr>
	    <td width="200" align="center">延长期限</td>
		<td width="200" align="center"><input type="text" name="rtime" id="rtime" onBlur="adds()" value="0"></td>
	    <td width="200" align="center">续约经手人</td>
		<td width="200" align="center"><input type="text" name="rtransactor"></td>
	  </tr>
	  <tr>
	     <td colspan="4" align="center">
		   	<input type="hidden" name="method" value="mods">
			<input type="hidden" name="id" value="${leasing.id}"/>
			<input type="submit" value="续约" style="cursor: pointer">
		 </td>
	  </tr>
	</table>
	</form>
		  <center>
	    <div align="center"><a href="mainorder">返回</a></div>
	  </center>
  </body>
</html>
