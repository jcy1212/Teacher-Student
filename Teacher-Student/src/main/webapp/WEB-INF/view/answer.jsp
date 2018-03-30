<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>你问我答</title>

<style>
html, body {
  height: 80%;
}
body {
  background:#FFF url(http://39.106.194.219:8080/Teacher-Student/temp/miao.gif) no-repeat 0 0 fixed;
  background-size: 100%;
  font-size:18px;
}
#clock{
	Float:left;
	margin-top:20%;
	margin-left:28%;
}
	
</style> 	

</head>
<body>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/vue.min.js"></script>

<div id="clock">
   <form action="${pageContext.request.contextPath}/total/answer">
   <table>
   <tr>
   	<td colspan="3" align="center"><label style="letter-spacing:8px;color:#F0FFFF;">请开始提问吧^.^亲</label></td>
   </tr>
   	<tr >
   		<td  height="50px" ><label style="color:#F0FFFF;letter-spacing:8px;font-size:18px;">问题</label></td>
   		<td><input name="question" style="BACKGROUND-COLOR: transparent;color:#F0FFFF;font-size:18px;width:293px" value="${question }"/></td>
   		<td><button type="submit" style="BACKGROUND-COLOR: transparent;color:#F0FFFF;margin-left:20px">确定</button></td>
   	</tr>
   	<tr>
   		<td><label style="color:#F0FFFF;letter-spacing:8px;">答曰</label></td>
   		<td >
   		<textarea name="answer" cols="30" rows="4" style="BACKGROUND-COLOR: transparent;color:#F0FFFF;font-size:18px;" value="${content }">${content }</textarea>
   		</td>
   		<td></td>
   	</tr>
   	
   </table>
   	
   </form>
</div>



</body>
</html>