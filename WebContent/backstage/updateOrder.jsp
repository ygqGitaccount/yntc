<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/backstage/css/main.css" type="text/css" />
<title>修改订单</title>
<style type="text/css">
.orderInfo{
 text-align: right;
}

</style>
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
         <form action="${pageContext.request.contextPath }/OrderServlet?action=backstageUpdateOrder" method="post">
           <table>
             <tr><td class="orderInfo">收件人姓名：</td><td><input type="text" name="uname" value="${order.uname }"/></td></tr>
             <tr><td class="orderInfo">收件人地址：</td><td><input type="text" name="address" value="${order.address }"/></td></tr>
             <tr><td class="orderInfo">联系电话：</td><td><input type="text" name="telephone" value="${order.telephone }"/></td></tr>
             <tr><td class="orderInfo">商品名称：</td><td><input type="text" value="${order.gname }" readonly="readonly" /></td></tr>
             <tr><td class="orderInfo">单价：</td><td><input type="text" value="${order.price }" readonly="readonly"/></td></tr>
             <tr><td class="orderInfo">订单总价：</td><td><input type="text" value="${order.price*order.number }" readonly="readonly" /></td></tr>
             <tr><td class="orderInfo">备注：</td><td><input type="text" name="remark" value="${order.remark }"/></td></tr>
             <tr><td colspan="2"><input type="hidden" name="oid" value="${order.oid }"/></td></tr>
             <tr><td>&nbsp;</td><td ><input type="submit" value="提交"/></td></tr>
             
           </table>
         </form>
     </div>
     
  </div>
   <%@include file="bottom.jsp" %> 
</body>
</html>