<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/index.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/goodsList.css" type="text/css" />

<script type="text/javascript" src="js/jquery-3.3.1.js" charset="utf-8"></script>
<script  src="js/index.js" type="text/javascript" charset="utf-8"></script>
</head>
<body style="background:#c9c9c9">
  <div class="staticPosition">
   <!--   云特产顶部start -->
    <%@include file="head.jsp" %>
    <!-- 云特产logostart -->
    <%@include file="logo_search.jsp" %>
  <!--   云特产菜单列表 start-->
    <%@include file="menu.jsp" %>
    </div>
    
    <div class="bigBox" style="min-height: 500px;">
    
    <c:forEach items="${lg}" var="LG">
     <div class="item">
       <div class="top">
         <ul><li> <a href="javascript:findGoodsById('${LG.id }','${LG.state }')"><img src="${LG.picurl } "/></a></li></ul>
       </div>
       <div class="center_goodStatus" >
        <ul><li><font style="color:#000;font-size: 15px;">${LG.status }</font></li></ul>
       </div>
       <div class="bottom">
         <ul>
          <li>￥${LG.price }</li>
          <li id="monnum"><font style="color:#a9a9a9; font-size: 15px">销量</font>${LG.monnum }</li>
         </ul>
       </div>
      </div>
    </c:forEach>
    </div>
 <%@include file="bottom.jsp" %>
<script type="text/javascript" src="js/jquery-3.3.1.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
 $(window).scroll(function(){
	 var height=$(this).scrollTop();
	 if(height>137){
		 $(".menu").css({
			 position:"fixed",
			 top:0,
			 zIndex:1,
			 width:"100%"
		 });
	 }else{
		 $(".menu").css({
			 position:"static"
		 });
	 }
 })
</script>
</body>
</html>