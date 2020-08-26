<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/index.css" type="text/css" />
<title>个人中心</title>

</head>
<body style="background:white">  
   <%@include file="head.jsp" %>
   
  <div style="heigth:570px;">
  <%@include file="personalLeft.jsp" %>
  <!-- allInfo开始 -->
   <div class="info" style="width: 90%; height: 570px; background:#fff;float:left;">
      <p style="height:100px;line-height: 100px;text-align: center;">欢迎来到个人中心</p>
     </div>     
          <!-- 用信息结束 -->
   </div>
  <!-- allInfo结束 -->
  <%@include file="personalCenterBottom.jsp" %>
</body>
</html>