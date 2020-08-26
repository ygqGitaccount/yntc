<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/backstage/css/main.css" type="text/css" />
<style type="text/css">
*{
  margin:0;
  padding:0;
}
.main{
  width:100%;
  height:80%;
  /* background:#f00; */
 margin-top:30px;
}
html,body{
 height:100%;
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
</style>  
</head>
<body >
    <!--   云特产商家后台head start -->
  <%@include file="head.jsp" %>
  
  <div class="main">
     <div class="left">
       <!--   云特产商家后台left start -->
       <%@include file="left.jsp" %>
     </div>
     
     <div class="right">
        <p style="padding-left:450px;height:100px;line-height: 100px;">欢迎你，登录成功</p>
    </div>
        
  </div>
  
  <!--   云特产商家后台bottom start -->
 <%@include file="bottom.jsp" %> 
 
</body>
</html>