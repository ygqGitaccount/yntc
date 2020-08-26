<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/index.css" type="text/css" >
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/shoppingCart.css" type="text/css" >
<title>我的购物车</title>
</head>
<body>
   <%@include file="head.jsp" %>
   
   <div class="cart" style="height:40px;width:100%" >
      <div class="cartLeft">
                   我的购物车
      </div>
      <a href="${pageContext.request.contextPath }/GoodsServlet?action=findAll" style="line-height: 40px;width:100px;float:right;margin-right:50px;">返回首页</a>
      <hr style="border: 1px solid #000; float:left;width:100%;">
   </div>
    
    <div class="cartItem">
      <%-- <c:if test="${empty lc }">
         <div style="width:1200px;height:30px;margin:10px auto;text-align: center;line-height: 30px;color:#a6a6a6;">你还没有收藏任何商品</div>
      </c:if> --%>
      <%-- <c:if test="${not empty lc }"> </c:if> --%>
       <div class="content" style="margin-top:10px;">
     
          <table width="100%"  >
            <tr class="bg_tr">
              <th style="display:none"></th>
              <th width="120" class="bg_th">商品图片</th>
              <th class="bg_th">商品名称</th>
              <th class="bg_th">价格</th>
              <th class="bg_th">数量</th>
              <th class="bg_th">库存</th>
              <th class="bg_th">小计</th>
              <th >删除</th>
             <!--  <th>全选<input type="checkbox" class="all"></th>     -->
            </tr>
            <c:forEach items="${lc }" var="LC">
              <c:if test="${LC.state==1 }"> 
            <tr class="bg_td">
             <td  class="cid" style="display:none">${LC.cid }</td>
             <td class="picture"><a href="javascript:findGoodsById('${LC.goodsid }','${LC.storeid }')"><img alt="" width="100" height="100" src="${LC.picurl}"></a></td>
             <td class="gName">${LC.name }</td>
             <td class="price">${LC.price}</td>
             <td class="numb"><button class="minus" id="minus" type="button" >-</button><span id="number">${LC.number }</span><button type="button" class="add" >+</button></td>
             <td class="num" id="num">${LC.num }</td>
             <td class="count"></td>
             <td><a class="del" href="${pageContext.request.contextPath }/CartServlet?action=delCartGoodsByCid&cid=${LC.cid}" onclick="if(confirm('确认删除？')==false)return false;" style="color:#f00;cursor: pointer;">X</a></td>
             <%-- <td><input type="checkbox" class="each" value="${LC.goodsid }" /></td>  --%>
            </tr>
              </c:if> 
            </c:forEach>
           <tr><td colspan="7"  style="text-align: right">总价：<span class="totalPrice"></span></td></tr>
          </table>
          <div class="buy" style="float:right;margin-top:5px;">
            <a href="${pageContext.request.contextPath }/CartServlet?action=clickCount" style="display:block;border-radius:7px; width:80px;height:40px;background:#c0dbbb;text-align: center;line-height: 40px;font-size: 18px;">结算&gt;&gt;</a>
          </div>
          
 
       </div>
     
    </div>
    
  <script type="text/javascript" src="js/jquery-3.3.1.js" charset="utf-8"></script>
 <script type="text/javascript">
 //等文档加载完再执行代码
  $(function(){
	  //计算单行的总价
	  function countPrice(){
		  var count=0;
		  for(var i=0;i<$(".count").length;i++){
			  //parents（css选择器）寻找父元素
			  //find 寻找子元素
			  //text()获取文本或设置文本
		     var price=$(".count").eq(i).parents("tr").find(".price").text();  
			  price=Number(price);
			  var numb=$(".count").eq(i).parents("tr").find("span").text();
			  numb=Number(numb);
			  $(".count").eq(i).text(price*numb);
			  var counted=$(".count").eq(i).text();
			  counted=Number(counted);
			   count+=counted;
		  }
			 
		  $(".totalPrice").text(count);
	  }
	  countPrice();
	  $(".minus").click(function(){
		  var numb=$(this).parents("td").find("span").text();
		  //var num=$(this).parents("tr").find(".num").text();
		  var cid=$(this).parents("tr").find(".cid").text();
		  numb=Number(numb);
		  if(numb==1){
			  return;
		  }
		  numb--;
		  $(this).parents("td").find("span").text(numb);
		  location.href="${pageContext.request.contextPath }/CartServlet?action=updateCartNumber&cid="+cid+"&number="+numb;
		  countPrice();
	  })
	 $(".add").click(function(){
		 var numb=$(this).parents("td").find("span").text();
		 var num=$(this).parents("tr").find(".num").text();
		 var cid=$(this).parents("tr").find(".cid").text();
		 cid=Number(cid);
		 numb=Number(numb);
		 num=Number(num);
		 if(numb<num){
		  numb++;
		 }else{
			 alert("数量已达上限");
			 return;
		 }
		 
		 $(this).parents("td").find("span").text(numb);
		 countPrice();
		 location.href="${pageContext.request.contextPath }/CartServlet?action=updateCartNumber&cid="+cid+"&number="+numb;
	 })  
  })
  function findGoodsById(id,state){
		location.href="./GoodsServlet?action=findGoodsById&id="+id+"&state="+state;
	}
 </script>
</body>
</html>