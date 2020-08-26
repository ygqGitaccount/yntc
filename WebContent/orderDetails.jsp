<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/index.css" type="text/css" />
<title>订单详情</title>
<style type="text/css">
.th{
 background-color:#c0dbbb;
 text-align: center;
}
.TD{
  text-align: center;
  width:100px;
  
}
</style>
</head>
<body>
  <%@include file="head.jsp" %>
   
  <div style="heigth:570px;">
  <%@include file="personalLeft.jsp" %>
  <!-- allInfo开始 -->
   <div class="info" style="width: 90%; height: 570px; background:#fff;float:left;">
   <div style="">
    <table>
      <tr><td>收件人姓名：</td><td><input type="text" value="${order.uname }" /></td></tr>
      <tr><td>收件地址：</td><td><input type="text" value="${order.address }" /></td></tr>
      <tr><td>联系电话：</td><td><input type="text" value="${order.telephone }" /></td></tr>
   </table>
  <table border="1px" cellpadding="0" cellspacing="0">
    <tr>
     <th class="th">商品图片</th>
     <th class="th">商品名称</th>
     <th class="th">商品价格</th>
     <th class="th">购买数量</th>
     <th class="th">小计</th>
    </tr>
    <tr>
     <td><img src="${order.gpicurl }" style="width:100px;height:100px;"></td>
     <td class="TD">${order.gname }</td>
     <td class="TD">${order.price }</td>  
     <td class="TD">${order.number }</td>  
     <td class="TD">${order.price*order.number }</td>    
    </tr>
   </table>
  </div>
   </div>     
   </div>
  <%@include file="personalCenterBottom.jsp" %>
    
</body>
</html>