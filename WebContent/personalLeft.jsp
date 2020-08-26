<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>菜单</title>
<link href="${pageContext.request.contextPath}/backstage/css/left.css" rel="stylesheet" type="text/css">
<style type="text/css">
</style>
	 
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
function lookUserInfo(id){
	location.href="${pageContext.request.contextPath }/UserServlet?action=FindUserById&id="+id;
}
function findOrder(id){
	location.href="${pageContext.request.contextPath }/OrderServlet?action=findOrderByState&id="+id;
}
function findCollect(id){
	location.href="${pageContext.request.contextPath }/CollectServlet?action=findCollect&userid="+id;
}

</script> 
</head>
	<body>
	
		<div style="float:left;width:10%;height:570px;background:#e6e6e6;">
			<table style="border: 0px;">
				<tr>
					<td><a href="javascript:lookUserInfo('${user.id }');" class="left_list">个人信息</a></td>
				</tr>
				<tr>
					<td><a href="javascript:findOrder('${user.id }');" class="left_list">查看订单</a></td>
				</tr>
				<tr>
					<td><a href="javascript:findCollect('${user.id }');" class="left_list">我的收藏</a></td>
				</tr>
				<tr>
				  <td><a href="${pageContext.request.contextPath }/GoodsServlet?action=findAll" class="left_list">&lt;&lt;返回主页</a></td>
				</tr>
			</table>
		</div>
		
	
</body>
</html>
