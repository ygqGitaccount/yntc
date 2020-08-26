<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/index.css" type="text/css" />
<style type="text/css">
.storeName div:hover{background:rgba(0,0,0,.2);}
</style>
<title>店铺街</title>
</head>
<body>
  <!--   云特产顶部start -->
    <%@include file="head.jsp" %>
    <!-- 云特产logostart -->
    <%@include file="logo_search.jsp" %>
  <!--   云特产菜单列表 start-->
    <%@include file="menu.jsp" %>
    
    <!-- 店铺街开始 -->
    <div class="storeStreet" style="">
     <div class="content" style="background:#e6e6e6;min-height: 490px;margin-top:10px;padding:5px 0" >
      <div style="overflow: hidden;">
       <c:forEach items="${lu }" var="lu">
        <div class="storeName" style="width:290px;height:110px;background:#fff;margin:5px 5px;float:left;">
        <div style="width:280px;height:100px;margin:5px 5px;text-align: center;line-height: 100px;" onclick="findStore(${lu.id})">${lu.name }</div>
        </div> 
       </c:forEach> 
      </div>
       <div style="margin-top:10px;">
        <hr>
        <p style="width:400px;margin:0 auto;text-align: center;">更多店铺尽情期待</p>
       </div> 
     </div>
    </div>
    <!-- 店铺街结束 -->
   <%@include file="bottom.jsp" %>
   
   
<script type="text/javascript" src="/js/jquery-3.3.1.js" charset="UTF-8"></script>
<script type="text/javascript">
 function findStore(id){
	 //alert(id);
	 location.href="${pageContext.request.contextPath }/GoodsServlet?action=findGoodsByState&state="+id;
 }
</script>
</body>
</html>