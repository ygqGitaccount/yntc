<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/index.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/shoppingCart.css" type="text/css" >
<title>我的收藏</title>
<style type="text/css">
 .bg_tr th{text-align: center;border:1px solid #fff;}
 .td td{border:1px solid #f5f5f5;text-align: center;}
</style>
</head>
<body>
<%@include file="head.jsp" %>
 <div style="min-height: 620px;">
   <%@include file="personalLeft.jsp" %>
   
   <div style="width:90%;min-height: 610px;float:left"">
     <div style="margin:0 auto;width:80%">
        <c:if test="${empty lc }">
           <div style="width:1000px;height:30px;margin:10px auto;text-align: center;line-height: 30px;color:#a6a6a6;">你还没有收藏任何商品</div>
        </c:if>
     <c:if test="${not empty lc }">
      <table style="width:100%" border="0" cellpadding="0" cellspacing="0">
            <tr class="bg_tr">
              <th class="bg_th" style="width:140px;">商品图片</th>
              <th class="bg_th" style="width:150px;">商品名称</th>
              <th class="bg_th">价格</th>
              <th class="bg_th">库存</th>
              <th >删除</th>
            </tr>
            <c:forEach items="${lc }" var="lc">
            <tr class="td">
              <td style="height:140px"><a href="javascript:findGoodsById('${lc.id }','${lc.state }')"><img style="width:140px;height:140px;cursor:pointer;" alt="" src="${lc.picurl }"></a></td>
              <td>${lc.name }</td>
              <td>${lc.price }</td>
              <td>${lc.num }</td>
              <td style="color:red; width:160px;cursor: pointer" onclick="cancelCollect('${lc.cid}','${lc.userid }');">取消收藏</td>
            </tr>
            </c:forEach>
       </table>
       </c:if>
       </div>
   </div>
 </div>
 
 <script type="text/javascript" src="js/jquery-3.3.1.js" charset="utf-8"></script>
 <script type="text/javascript">
 function findGoodsById(id,state){
		location.href="./GoodsServlet?action=findGoodsById&id="+id+"&state="+state;
	}	
 function cancelCollect(cid){
	 //alert(userid);
	 if(confirm("真的要取消收藏吗？")){
		 location.href="${pageContext.request.contextPath }/CollectServlet?action=cancelCollect&cid="+cid;
	 }
 }
 </script>
</body>
</html>