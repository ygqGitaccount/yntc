<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/backstage/css/main.css" type="text/css" />
<title>修改公告</title>
</head>
<body>
   <%@include file="head.jsp" %>
  
  <div class="main" >
     <div class="left">
       <!--   云特产商家后台left start -->
       <%@include file="left.jsp" %>
     </div>
     
     <div class="right" style="background:#f0f0f0">
         <!-- 编辑公告开始 -->
         <div id="edit" style="display:block">
            <form action="${pageContext.request.contextPath }/NoticeServlet?action=updateNotice" method="post">
                                   请输入公告标题：<br><input type="text" name="title" style="width:310px;height:25px" value="${notice.title }"><br>
                                   公告内容：<br><input  name="content" style="width:310px;height:200px;"  value="${notice.content }" ><br>
             <input type="hidden" name="id" value="${notice.id}" />
             <input type="submit"  value="提交" />
            </form>
         </div>
         <!-- 编辑公告结束 -->
     </div>
  </div>
  
  <!--   云特产商家后台bottom start -->
 <%@include file="bottom.jsp" %> 
 
</body>
</html>