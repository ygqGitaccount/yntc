<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/index.css" type="text/css" >
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/goodsList.css" type="text/css" />
<style type="text/css">
.option {width:150px;height:30px;border:1px solid #0f0;}
</style>
<title>进入店铺</title>
</head>
<body>
 <%@include file="head.jsp" %>
 <%@include file="menu.jsp" %>
 <!-- 搜索开始 -->
<div style="margin:0 auto;height:40px;background:#f5f5f5;overflow: hidden;width:1200px">
  <div style="float:left;width:400px;height:40px;line-height: 40px;padding-left:20px" ><font style="font-size: 20px;color:orange">${storeName.storeName}</font>&nbsp;&nbsp;&nbsp;&nbsp;欢迎光临你的到来</div>
  <div style="width:400px;height:40px;margin:0 auto;float:left;text-align: center">
    <form action="GoodsServlet?action=findGoodsByType" method="post">
    <select class="option" name="type">
     <option value="" >请选择</option>
     <option value="食品" >食品</option>
     <option value="手工艺品" >手工艺品</option>
     <option value="水果">水果</option>
     <option value="肉类">肉类</option>
     <option value="干货">干货</option>
     <option value="其他">其他</option>
    </select>
    <input type="hidden"  name="state" value="${storeName.state}"/>
     <button style="width:50px;height:30px;margin-top:5px;border-radius: 5px;background:#22ac38;cursor: pointer;">搜&nbsp;索</button>
     <button type="button" onclick="findAll(${storeName.state})" style="width:100px;height:30px;margin-top:5px;border-radius: 5px;background:#22ac38;cursor: pointer;">本店所有商品</button>
    </form>
  </div>
</div>
<!-- 搜索结束 -->
<!-- 店家商品开始 -->
 <div class="content" style="background:#eae9ee; ">
  <div style="margin:0 auto;width:1180px;overflow: hidden;min-height: 490px">
   <c:if test="${empty lg }">
     <p style="width:500px;margin:10px auto;text-align: center;">抱歉，没有该类商品</p>
   </c:if>
  
   <c:if test="${not empty lg }">
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
    </c:if>
  </div>
 </div>
 <!--店家商品结束  -->
 
 <script type="text/javascript" src="js/jquery-3.3.1.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
function findGoodsById(id,state){
	  location.href="./GoodsServlet?action=findGoodsById&id="+id+"&state="+state;
}
function findAll(state){
	//alert(state);
	location.href="${pageContext.request.contextPath }/GoodsServlet?action=findGoodsAll&state="+state;
}
</script>
</body>
</html>