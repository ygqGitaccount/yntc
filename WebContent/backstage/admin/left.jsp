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
			  	<td><a class="left_list" onclick="userManager()"  >用户管理</a></td>
			  	<!-- <tr><td><a class="left_1" onclick="findUser()" style="width:135px;height:25px;line-height:25px;padding-left:20px;font-family:'宋体';font-size: 15px;display:none">普通用户</a></td></tr>
			  	<tr><td><a class="left_1" style="width:135px;height:25px;line-height:25px;padding-left:20px;font-family:'宋体';font-size: 15px;display:none">入驻商家</a></td></tr> -->
			  </tr> 
			  <tr>
			  <td><a onclick="findNotice()" class="left_list" >公告管理</a></td>
			  </tr>
		</table>
		
		
<script type="text/javascript" src="js/jquery-3.3.1.js" charset="utf-8"></script>
<script type="text/javascript">
function userManager(){
		location.href="${pageContext.request.contextPath }/UserServlet?action=findUserByRole";
}
/* $(document).ready(function(){
	 $(".left_list").click(function(){
		  $(".left_1").slideToggle("slow");
	  });
}); */
function findNotice(){
	location.href="${pageContext.request.contextPath }/NoticeServlet?action=findNotice"
}
</script>
	</body>
</html>
