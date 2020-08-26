<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>菜单</title>
	 <link href="${pageContext.request.contextPath}/backstage/css/left.css" rel="stylesheet" type="text/css"> 
</head>
	<body>
		<table style="width:10%; height:10%; border:0px;">
			 <tr><!-- target="mainFrame"  -->
			  	<td><a href="javascript:findUser('${user.id }');" class="left_list"   >个人中心</a></td>
			  </tr> 
			  <tr>
			  	<%-- <td><a href="${pageContext.request.contextPath}/GoodsServlet?action=getList" class="left_list" >商品管理</a></td> --%>
			  <td><a href="javascript:findGoods('${user.id }');" class="left_list" >商品管理</a></td>
			  </tr>
			  <tr>
			  	<td><a href="javascript:findOrder('${user.id }');" class="left_list">订单管理</a></td>
			  </tr>
			  <tr>
			  	<td><a href="${pageContext.request.contextPath}/backstage/analyse.jsp" class="left_list">销售分析</a></td>
			  </tr>
		</table>
		
		
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
function findGoods(id){
	location.href="${pageContext.request.contextPath }/storeGoodsServlet?action=findGoodsByState&id="+id;
}
function findUser(id){
	location.href="${pageContext.request.contextPath }/UserServlet?action=findUserById&id="+id;
}
function findOrder(id){
	location.href="${pageContext.request.contextPath }/OrderServlet?action=backstageFindOrderByState&id="+id;
}

</script>
	</body>
</html>
