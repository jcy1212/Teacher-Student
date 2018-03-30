students<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib-css/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib-css/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>用户管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 用户中心 <span class="c-gray en">&gt;</span> 用户管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" id="reflash" title="刷新" name="reflash" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">

	<div class="text-c"> 
	<form action="${pageContext.request.contextPath}/teachers/teacherList?">日期范围：
		<input type="text" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}' })" id="datemin" name="beginDate" class="input-text Wdate" style="width:120px;" value="${beginDate }">
		-
		<input type="text" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d' })" id="datemax" name="endDate"  class="input-text Wdate" style="width:120px;" value="${endDate }">
		<input type="text" class="input-text" style="width:250px" placeholder="输入会员名称、电话、邮箱" id="str" name="str"  value="${str }">
		<button type="submit" class="btn btn-success radius" id="findTeacher" ><i class="Hui-iconfont">&#xe665;</i> 搜用户</button>
	</form>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"> <a href="javascript:;" onclick="member_add('添加用户','${pageContext.request.contextPath}/teachers/addTeacher','500','300')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加用户</a></span> <span class="r">共有数据：<strong>${num }</strong> 条</span> </div>
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
			<tr class="text-c">
				<th width="80">ID</th>
				<th width="100">姓名</th>
				<th width="40">职位</th>
				<th width="40">薪资</th>
				<th width="130">加入时间</th>
				<th width="70">状态</th>
				<th width="100">操作</th>
			</tr>
		</thead>
		<tbody>
		 <c:forEach items="${teacherList}" var="teacher" varStatus="teacherStatus">                         
			<tr class="text-c">
				<td><label for="uid${teacherStatus.index}">${teacherStatus.index+1}</label></td>
				<td><label for="uid${teacherStatus.index}">${teacher.teacherName }</label></td>
				<td><label for="uid${teacherStatus.index}">${teacher.teacherJob }</label></td>
				<td><label for="uid${teacherStatus.index}">${teacher.salary }</label></td>
				<td><label for="uid${teacherStatus.index}">${teacher.comeDate }</label></td>
				<td class="td-status"><label for="uid${teacherStatus.index}"><span class="label label-success radius">
					<c:set var="isExist" scope="session" value="${teacher.isExist}"/>
					<c:if test="${isExist == 0}">
   						<c:out value="在职"/>
					</c:if>
					<c:if test="${isExist == 1}">
   						<c:out value="离职"/>
					</c:if>
				</span></label></td>
				<td class="td-manage"> <a title="编辑" href="javascript:;" onclick="member_edit('编辑','${pageContext.request.contextPath}/teachers/updateTeacher?id='+${teacher.id},${teacher.id},'','510')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">编辑【&#xe6df;】</i> <a title="删除" href="javascript:;" onclick="member_del(this,${teacher.id})" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">删除【&#xe6e2;】</i></a></td>
			</tr>
		 </c:forEach>	
		</tbody>
	</table>
	</div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${pageContext.request.contextPath}/lib-css/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/lib-css/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${pageContext.request.contextPath}/lib-css/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/lib-css/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/lib-css/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
$(function(){
	$('.table-sort').dataTable({
		"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"bServerSide":false,
		"bInfo":true,
		"bPaginage":true,
		"bFilter":false,
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":true,"aTargets":[0]}// 制定列不参与排序
		]
	});
	
}); 
/*用户-添加*/
function member_add(title,url,w,h){
	layer_show(title,url,w,h);
}

/*用户-编辑*/
function member_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
}

/*用户-删除*/
function member_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			url: 'delTeacher?id='+id,
			dataType: 'json',
			success: function(data){
				$(obj).parents("tr").remove();
				window.location.reload();
				layer.msg('已删除!',{icon:1,time:1000});
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
}


</script> 
</body>
</html>