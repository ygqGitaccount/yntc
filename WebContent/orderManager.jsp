<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/index.css" type="text/css" />
<title>订单管理</title>
<style type="text/css">
.TB table{
  *border-collapse;/* 兼容ie7及其以下版本的浏览器 */
   border-spacing:0;
   border:solid #ccc 1px;
   box-shadow:0 1px 1px #ccc;
}
.TB th, .TB td{
  border-left:1px solid #ccc;
  border-top: 1px solid #ccc;
  padding:5px;
  text-align:center;
}
.TB th{
 color:#fff;
  background-color:#6a6a6a;
  background-image: linear-gradient(top,#ebf3fc,#dec9f9);
  box-shadow: 0 1px 0 rgba(255,255,255,.8) inset;
  border-top:none;
  text-shadow:0 1px 0 rgbs(255,255,255,.5);
}
</style>



</head>
<body>
  <%@include file="head.jsp" %>
  
  <div style="heigth:570px;">
  
  <%@include file="personalLeft.jsp" %>
  <!-- allInfo开始 -->
   <div class="info" style="width: 90%; height: 570px; background:#fff;float:left;">
      <div id="right1" style="display:block;"> 
          <div class="TB">
			<table style="width:100%">
			   <tr>
			       <th style="display:none">订单id</th>
			       <th style="display:none">商品id</th>
			       <th style="display:none">商家id</th>
			       <th>商品名称</th>
			       <th style="display:none">商品id</th>
			       <th>商品单价</th>
			       <th>数量</th>
			       <th>小计</th>
			       <th>订单详情</th>
			       <th>订单状态</th>
			       <th>退货</th>
			   </tr>
			   <c:forEach items="${pb.list }" var="PBL">
			   <tr class="zhuangtai">
			    <td class="oid" style="display:none">${PBL.oid }</td>
			    <td class="goodsid" style="display:none">${PBL.goodsid }</td>
			    <td class="storeid" style="display:none">${PBL.storeid }</td>
				<td>${PBL.gname }</td>
				<td class="price">${PBL.price }</td>
				<td class="number">${PBL.number }</td>
				<td class="count"></td>
				<td><a href="${pageContext.request.contextPath  }/OrderServlet?action=findOrderByOid&oid=${PBL.oid }" style="text-decoration: underline;" target="_blank">详情</a></td>
				   <!-- 订单状态开始 -->
				  <c:if test="${PBL.ordState=='已付款' }">
				    <td ><a class="th" onclick="confirmReceipt('${PBL.storeid}','${PBL.price*PBL.number }','${PBL.oid }');" style="width:70px;height:25px;background:#45ba51;border-radius: 5px;border:1px solid #000;display:block;margin:0 auto;cursor: pointer;">确认收货</a></td>
				  </c:if>
				  <c:if test="${PBL.ordState=='已收货' }">
				    <td ><a class="th" onclick="appraise('${PBL.goodsid}','${PBL.oid }')" style="width:65px;height:25px;background:#45ba51;border-radius: 5px;border:1px solid #000;display:block;margin:0 auto;cursor: pointer;">评价</a></td>
				  </c:if>
				  <c:if test="${PBL.ordState=='交易完成' }">
				    <td><a  class="th" style="width:65px;height:25px;background:#a6a6a6;border-radius: 5px;border:1px solid #fff;display:block;margin:0 auto;color:white;">交易完成</a></td>
				  </c:if>
				  <c:if test="${PBL.ordState=='已退货' }">
				    <td ><a class="th" style="width:65px;height:25px;background:#a6a6a6;border-radius: 5px;border:1px solid #fff;display:block;margin:0 auto;color:white;">已退货</a></td>
				  </c:if>
				   <!-- 订单状态结束 -->
				   <!-- 退货开始 -->
				  <c:if test="${PBL.th == 0 }">
				      <%-- <td><a class="back" onclick="back('${PBL.oid}','${PBL.price*PBL.number }','${PBL.storeid }','${PBL.number }','${PBL.goodsid }')" style="width:50px;height:25px;background:#45ba51;border-radius: 3px;border:1px solid #000;display:block;margin:0 auto;cursor: pointer;">退货</a></td> --%>
				       <td><a class="back" style="width:50px;height:25px;background:#45ba51;border-radius: 3px;border:1px solid #000;display:block;margin:0 auto;cursor: pointer;">退货</a></td>
				  </c:if>
				  <c:if test="${PBL.th == 1 }">
				    <td ><a style="width:60px;height:25px;background:#a6a6a6;border-radius: 5px;border:1px solid #fff;display:block;margin:0 auto;color:white;">已退货</a></td>
				  </c:if>
				  <c:if test="${PBL.th == 2 }">
				    <td ><a style="width:65px;height:25px;background:#a6a6a6;border-radius: 5px;border:1px solid #fff;display:block;margin:0 auto;color:white;">不可退货</a></td>
				  </c:if>
				   <!--退货结束-->
				   
			   </tr>
			   </c:forEach>
			</table>
           </div>
          </div>   
          <div class="paging">
			<ul>
				<li class="disablepage">
				<a href="${pageContext.request.contextPath  }/OrderServlet?action=findOrderByState&currentPage=${pb.currentPage>1?pb.currentPage-1:pb.currentPage}">&lt;&lt;上一页/</a></li>													
				<li>第${pb.currentPage}页/共${pb.totalPage }页</li>
				<li class="nextPage"><a href="${pageContext.request.contextPath  }/OrderServlet?action=findOrderByState&currentPage=${pb.currentPage<pb.totalPage?pb.currentPage+1:pb.totalPage}">/下一页&gt;&gt;</a></li>
			</ul>
		 </div>
      </div>   
        
   </div>
  <!-- allInfo结束 -->
  <%@include file="personalCenterBottom.jsp" %>
</body>
<script type="text/javascript" src="js/jquery-3.3.1.js" charset="utf-8"></script>
<script type="text/javascript">
$(function(){
	function countPrice(){ 
		var count=0;
		for(var i=0;i<$(".count").length;i++){
		 var price=$(".count").eq(i).parents("tr").find(".price").text();
		 price=Number(price);
		 var number=$(".count").eq(i).parents("tr").find(".number").text();
		 number=Number(number);
		 $(".count").eq(i).text(price*number);
		}
	}
	countPrice();
})
function confirmReceipt(storeid,count,oid){
	 //alert(storeid);
	 //alert(count);
	 //alert(oid);
	 if(confirm("确认收货后不可退货，确认吗？")){
		 location.href="${pageContext.request.contextPath  }/OrderServlet?action=updateOrdstateConfirmReceipt&storeid="+storeid+"&count="+count+"&oid="+oid; 
	 }
     	
}
function appraise(goodsid,oid){
	//alert(goodsid);
	var content=null;
	content=prompt("请输入评价内容");
	//alert(content);
	 if(content!=null){
	location.href="${pageContext.request.contextPath  }/AppraiseServlet?action=addAppraise&goodsid="+goodsid+"&content="+content+"&oid="+oid;
	}
}
function delOrder(oid){
	//alert(oid);
	if(confirm("确认删除吗？")){
		location.href="${pageContext.request.contextPath }/OrderServlet?action=delOrderByOid&oid="+oid;
		
	}
}
/* function back(oid,count,storeid,number,gid){
	for(var i =0; i<$(".back").length;i++){
		var zhuangtai =$(".back").eq(i).parents(".zhuangtai").find(".th").text();
	}
	alert(zhuangtai);
	//location.href="${pageContext.request.contextPath }/OrderServlet?action=updateOrderTh&oid="+oid+"&count="+count+"&storeid="+storeid+"&number="+number+"&gid="+gid;
}
 */
 $(".back").click(function(){
	 var oid = $(this).parents(".zhuangtai").find(".oid").text();
	 oid =Number(oid);
	 //alert(oid);
	 var storeid =$(this).parents(".zhuangtai").find(".storeid").text();
	 storeid = Number(storeid);
	 //alert(storeid);
	 var number = $(this).parents(".zhuangtai").find(".number").text(); 
	 number = Number(number);
	 //alert(number);
	 var goodsid =$(this).parents(".zhuangtai").find(".goodsid").text();
	 goodsid = Number(goodsid);
	 //alert(goodsid);
	 var price =$(this).parents(".zhuangtai").find(".price").text();
	 price =Number(price);
	 //alert(price);
     var zhuangtai =$(this).parents(".zhuangtai").find(".th").text();
     var count =price*number;
     //alert(count);
     if(zhuangtai == "确认收货"){
    	// alert(222);
    	if(confirm("确认退货吗？")){
    		location.href="${pageContext.request.contextPath }/OrderServlet?action=updateOrderTh&oid="+oid+"&count="+count+"&storeid="+storeid+"&number="+number+"&gid="+goodsid;
    	}else{
    		return;
    	}
     }
 })
</script>
</html>