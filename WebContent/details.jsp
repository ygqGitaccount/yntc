<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品详情</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/index.css" type="text/css" >
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/details.css" type="text/css" >
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/goodsList.css" type="text/css" />

</head>
<body style="background:white">
   <%@include file="head.jsp" %>
   
   <div class="detailsHead">
    <div class="content">
        <a href="${pageContext.request.contextPath }/GoodsServlet?action=findAll" style="line-height: 40px;">&lt;&lt;主页</a>
    </div>
   </div>
   
   <!-- details开始 -->
   <div class="details" >
     <div class="content" style="background:;height:;margin-top:25px;">
     <form action="CartServlet?action=addCart" method="post">
       <div class="detailsLeft">
         <img src="${goods.picurl }">
       </div>
       <div class="detailsCenter" backgropund:red>
         <ul>
           <li>${goods.name }&nbsp;&nbsp;&nbsp;${goods.status }</li>
           <li>价格<font style="color:#ff5102;">￥${goods.price }</font></li>
           <li>销量:${goods.monnum }</li>
         </ul>
         <div style="width:500px;height:50px;background:;float:left">
            <span style=";font-size: 18px;line-height: 50px;margin-left:5px;">数量</span>
            <input id="buyNum" type=text name="buyNum" style="width:40px;height:20px;" value="1" onBlur="info()"/>
            <input type="hidden" name="id" value="${goods.id }" />
             <input type="hidden" name="state" value="${goods.state }" />
                                  库存（<span id="num" style=";font-size: 15px;line-height: 50px;margin-left:10px;">${goods.num }</span>）
         </div>
         <div class="detailsCenterBtm" style="background:">
           <!--  <a>立即购买</a>
            <a >加入购物车</a> -->
            <c:if test="${not empty user }">
            <a class="buy" type="button" onclick="collect('${goods.id}','${goods.state }')">加入收藏</a>
            <button class="addCart">加入购物车</button>
            </c:if>
            <c:if test="${empty user }">
            <a onclick='alert("请先登录")'>加入收藏</a>
            <a onclick='alert("请先登录")'>加入购物车</a>
            </c:if>
         </div>
        </div>
        </form>
        <!-- 看看又看开始 -->
       <div class="detailsRight">
          <p style="height:25px;text-align: center;">看了又看</p>
          <c:forEach items="${lg }" var="Lg" begin="0" end="1">
         <div class="detailsRightTop">
           <a href="javascript:findGoodsById('${Lg.id }','${Lg.state }')"><img src="${Lg.picurl }"></a>
            <p style="height:25px;text-align: center;background:rgba(0,0,0,.3);width:240;overflow:hidden;text-overflow: ellipsis;white-space: nowrap;">${Lg.name }&nbsp;&nbsp;${Lg.status }</p>
         </div>
         </c:forEach>
       </div>
       <!-- 看了又看结束 -->
    </div>
   </div>
  <!-- details结束 -->
  
   <!-- 店长推荐开始 -->
      <div style="">
        <div class="content" style="background:#f7f7f7">
         <label style="width: 100px; height: 30px; background: red; display: block; text-align: center; line-height: 30px;">店长推荐</label>
			<hr style="border: 1px solid #f00;">
       
		<div id="changeHeight" class="bigBox" style="background:#c9c9c9;margin-top:10px;height:343px">
			<c:forEach items="${lg}" var="Lg" begin="0" end="4">
				<div class="item" style="margin-top:3px;margin-left:5px;margin-right:5px;">
					<div class="top">
						<ul>
							<li><a href="javascript:findGoodsById('${Lg.id }','${Lg.state }')"><img src="${Lg.picurl } " /></a></li>
						</ul>
					</div>
					<div class="center_goodStatus">
						<ul>
							<li><font style="color: #000; font-size: 15px;">${Lg.status }</font></li>
						</ul>
					</div>
					<div class="bottom">
						<ul>
							<li>￥${Lg.price }</li>
							<li id="monnum"><font style="color: #a9a9a9; font-size: 15px">销量</font>${Lg.monnum }</li>
						</ul>
					</div>
				</div>
			</c:forEach>
			
		</div>
		 <div class="hotright">
              <p style="text-align:right;"><a onclick="inStore(${goods.state})" style="cursor: pointer;" >进店逛逛>></a></p>
         </div>
        </div>
	</div>
	
   <!--店长推荐结束  -->
   
   <!-- 商品评价开始 -->
    <div class="" style="">
		<div class="content" style="min-height: 100px;">
			<label style="width: 100px; height: 30px; background: red; display: block; text-align: center; line-height: 30px;">商品评价</label>
			<hr style="border: 1px solid #f00;">
			<c:if test="${empty la }">
			  <div style="width:1200px;height:30px;margin:10px auto;text-align: center;line-height: 30px;color:#a6a6a6;">商品还没有评价</div>
			</c:if>
			<c:if test="${ not empty la}">
			 <c:forEach items="${la }" var="La">
			 <div style="width:1200px;margin:10px auto;height:30px;border-radius: 10px;border:1px solid #f00;">
				<div style="float:left;width:900px;margin-left:5px;overflow: hidden;text-overflow: ellipsis;white-space: nowrap;line-height: 30px">${La.content }</div>
				<div style="float:left;line-height: 30px">${La.uname }&nbsp;&nbsp;发表于：&nbsp;&nbsp;${La.mark }</div>
			 </div>
			 </c:forEach>
			 </c:if>
		</div>

	</div>
	<!--商品评价结束  -->


<script type="text/javascript" src="js/jquery-3.3.1.js" charset="utf-8"></script>
<script type="text/javascript">
 function info(){
    var buynum=document.getElementById("buyNum").value;
    var num=document.getElementById("num").innerHTML;
     num=Number(num);
     if(buynum>num){
    	 alert("库存不足");
    	 document.getElementById("buyNum").value=1;
     }if(buynum<=0){
    	 alert("数量不能为0");
    	 document.getElementById("buyNum").value=1;
     }
 }
 function findGoodsById(id,state){
  location.href="./GoodsServlet?action=findGoodsById&id="+id+"&state="+state;
}
function inStore(state){
  //alert(state);
  location.href="${pageContext.request.contextPath }/GoodsServlet?action=findGoodsByState&state="+state;	
}
function collect(id,state){
	//alert(id);
	location.href="${pageContext.request.contextPath }/CollectServlet?action=addCollect&goodsid="+id+"&state="+state;
}
</script>   
</body>
</html>