<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单管理</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/backstage/css/main.css" type="text/css" />
<style type="text/css">
.main{
  width:100%;
  height:80%;
  /* background:#f00; */
 margin-top:30px;
}
.left{
  width:12%;
  height:100%;
  float:left;
  background: #E6E6E6;
}
.right{
  width:88%;
  height:100%;
  float:left;
  background: #fff;
}
.TB table{
  *border-collapse;/* 兼容ie7及其以下版本的浏览器 */
   border-spacing:0;
   border:solid #ccc 1px;
   box-shadow:0 1px 1px #ccc;
}
.TB th, .TB td{
  border-left:1px solid #ccc;
  border-top: 1px solid #ccc;
  padding:8px;
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

<script type="text/javascript" src="js/jquery-3.3.1.js" charset="utf-8"></script>
 <script type="text/javascript">
 function updateOrder(oid){
	 location.href="${pageContext.request.contextPath }/OrderServlet?action=updateOrder&oid="+oid;
 }
 function settleAccounts(oid){
	//alert(oid);
	location.href="${pageContext.request.contextPath }/OrderServlet?action=backstageUpdateOrderCount&oid="+oid;
 } 
 </script>
</head>
<body>
     <!--   云特产商家后台head start -->
  <%@include file="head.jsp" %>
  
  <div class="main">
     <div class="left">
       <!--   云特产商家后台left start -->
       <%@include file="left.jsp" %>
     </div>
     
     <div class="right">
          <div class="TB" style="width:100%">
			<table style="width:100%;margin:0 auto;">
			   <tr class="setWidth">
			      <th>商品名称</th>
			       <th>商品单价</th>
			       <th>数量</th>
			       <th>小计</th>
			       <th>收件人姓名</th>
			       <th>收货地址</th>
			       <th>收件人电话</th>
			       <th>备注</th>
			       <th>下单时间</th>
			       <th>订单状态</th>
			       <th>操作 </th>
			      <!--  <th>详情</th> -->
			       <th>发货状态</th>
			   <tr>
			   <c:forEach items="${pb.list }" var="PL">
			   <tr class="setheight">
			     <td >${PL.gname }</td>
				<td class="price">${PL.price }</td>
				<td class="number">${PL.number }</td>
				<td class="count" >${PL.price*PL.number }</td>
				<td>${PL.uname }</td>
				<td class="point">${PL.address }</td>
				<td>${PL.telephone }</td>
				<td class="point">${PL.remark }</td>
				<td>${PL.time }</td>
				<td class="state">${PL.ordState }</td>
			<c:if test="${PL.ordState=='已付款' }">
				<td><a onclick="updateOrder(${PL.oid})" style="text-decoration: underline;color:#00f;cursor: pointer;">修改</a></td>
			</c:if>
			<c:if test="${PL.ordState=='已收货' }">
				<td>已收货</td>
			</c:if>
			<c:if test="${PL.ordState=='已退货' }">
				<td>已退货</td>
			</c:if>
			<c:if test="${PL.ordState=='交易完成' }">
				<td>已完成</td>
			</c:if>
			
				<!-- <td>详情</td> -->
			 <c:if test="${PL.count=='发货' }">	
				<td ><a onclick="settleAccounts(${PL.oid });" style="display:block;width:40px;height:25px;border:1px solid #000;border-radius: 5px;background:#22ac3b;cursor: pointer;">发货</a></td>
			</c:if>
			<c:if test="${PL.count=='已发货' }">
			  <td ><a  style="display:block;width:54px;height:25px;border:1px solid #fff;border-radius: 5px;background:#a6a6a6;cursor: pointer;color:white;">已发货</a></td>
			</c:if>
			<c:if test="${PL.count=='已退货' }">
			  <td ><a  style="display:block;width:54px;height:25px;border:1px solid #fff;border-radius: 5px;background:#a6a6a6;cursor: pointer;color:white;">已退货</a></td>
			</c:if>
			   </tr>
			   </c:forEach>
			</table>
			<div class="paging">
			<ul>
				<li class="disablepage">
				<a href="${pageContext.request.contextPath  }/OrderServlet?action=backstageFindOrderByState&currentPage=${pb.currentPage>1?pb.currentPage-1:pb.currentPage}&word=${pb.words}">&lt;&lt;上一页/</a></li>													
				<li>第${pb.currentPage}页/共${pb.totalPage }页</li>
				<li class="nextPage"><a href="${pageContext.request.contextPath  }/OrderServlet?action=backstageFindOrderByState&currentPage=${pb.currentPage<pb.totalPage?pb.currentPage+1:pb.totalPage}&word=${pb.words}">/下一页&gt;&gt;</a></li>
			</ul>
		 </div>  
          </div>
    </div>
       
  </div>

      <%@include file="bottom.jsp" %> 
 
</body>
</html>