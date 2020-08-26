<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/backstage/css/main.css" type="text/css" />
<title>用户管理</title>
<style type="text/css">
.th th{border:1px solid #f0f0f0;text-align:center;height:30px}
.td{text-align:center;}
.td td{border:1px solid #f0f0f0;}
.td:nth-child(odd){background-color:#e6e6e6;border:0px;height:30px;}
.td:nth-child(even){background-color:#eee9e9;border:0px;height:30px;}
</style>
</head>
<body >
   <!--   云特产管理员后台head start -->
  <%@include file="head.jsp" %>
  <!-- main开始 -->
  <div class="main" >
  
     <div class="left">
       <!--   云特产管理员后台left start -->
       <%@include file="left.jsp" %>
     </div>
     
     <div class="right" style="background:#f0f0f0;overflow: hidden; ">
        <p>平台余额为：${balance }</p> 
        <hr> 
        <!-- 商家 -->
        <div style="height:525px;">
        <p style="text-align: center;font-size:20px">用户信息如下：</p> 
        
        <div style="width:90%;margin:0 auto;height:400px;background:">
         <table border="0" cellpadding="0" cellspacing="0" style="width:100%">
          <tr class="th" style="background-color:#c0dbbb;border:0px ">
            <th>名称</th>
            <th>email</th>
            <th>QQ</th>
            <th>电话</th>
            <th>州/市</th>
            <th>详细地址</th>
             <th>余额</th>
            <th>状态</th>
          </tr>
          <c:forEach items="${pb.list }" var="Lu"> 
          
          <tr class="td"  style="border:0px ">
            <td>${Lu.name }</td>
            <td>${Lu.email }</td>
            <td>${Lu.qq }</td>
            <td>${Lu.telphone }</td>
            <td>${Lu.region }</td>
            <td>${Lu.address }</td>
            <td>${Lu.balance }</td>
            <c:if test="${Lu.state=='0' }">
            <td><a onclick="checkUser(${Lu.id})"  style="display:block;width:60px;height:22px;background:#22ac38;border-radius:5px;margin:0 auto;cursor: pointer;">待审核</a></td>
            </c:if>
            <c:if test="${Lu.state=='1'}">
            <td><a style="display:block;width:60px;height:22px;background:#a6a6a6;border-radius:5px;margin:0 auto;color:#ffe">已审核</a></td>
            </c:if>
            <c:if test="${Lu.state=='2'}">
            <td><a style="display:block;width:80px;height:22px;background:#a6a6a6;border-radius:5px;margin:0 auto;color:#ffe">普通用户</a></td>
            </c:if>
          </tr>
         
          </c:forEach>
         </table>
         <div class="paging">
			<ul>
				<li class="disablepage">
				<a href="${pageContext.request.contextPath  }/UserServlet?action=findUserByRole&currentPage=${pb.currentPage>1?pb.currentPage-1:pb.currentPage}">&lt;&lt;上一页/</a></li>													
				<li>第${pb.currentPage}页/共${pb.totalPage }页</li>
				<li class="nextPage"><a href="${pageContext.request.contextPath  }/UserServlet?action=findUserByRole&currentPage=${pb.currentPage<pb.totalPage?pb.currentPage+1:pb.totalPage}">/下一页&gt;&gt;</a></li>
			</ul>
		 </div>
       </div>
      </div>
        <!-- 商家结束 -->
       
        <!-- 普通用户 -->
        <div style="none">
        <p style="text-align: center;font-size:20px">平台商家入驻信息如下：</p> 
        
        <div style="width:90%;margin:0 auto;height:400px;background:">
         <table border="0" cellpadding="0" cellspacing="0" style="width:100%">
          <tr class="th" style="background-color:#c0dbbb;border:0px ">
            <th>店铺名称</th>
            <th>email</th>
            <th>QQ</th>
            <th>电话</th>
            <th>州/市</th>
            <th>详细地址</th>
            <th>状态</th>
          </tr>
          <c:forEach items="${pb.list }" var="Lu"> 
          
          <tr class="td"  style="border:0px ">
            <td>${Lu.name }</td>
            <td>${Lu.email }</td>
            <td>${Lu.qq }</td>
            <td>${Lu.telphone }</td>
            <td>${Lu.region }</td>
            <td>${Lu.address }</td>
            
            <c:if test="${Lu.state=='0' }">
            <td><a onclick="checkUser(${Lu.id})"  style="display:block;width:60px;height:22px;background:#22ac38;border-radius:5px;margin:0 auto;cursor: pointer;">待审核</a></td>
            </c:if>
            <c:if test="${Lu.state=='1'}">
            <td><a style="display:block;width:60px;height:22px;background:#a6a6a6;border-radius:5px;margin:0 auto;color:#ffe">已审核</a></td>
            </c:if>
          </tr>
         
          </c:forEach>
         </table>
         <div class="paging">
			<ul>
				<li class="disablepage">
				<a href="${pageContext.request.contextPath  }/UserServlet?action=findUserByRole&currentPage=${pb.currentPage>1?pb.currentPage-1:pb.currentPage}">&lt;&lt;上一页/</a></li>													
				<li>第${pb.currentPage}页/共${pb.totalPage }页</li>
				<li class="nextPage"><a href="${pageContext.request.contextPath  }/UserServlet?action=findUserByRole&currentPage=${pb.currentPage<pb.totalPage?pb.currentPage+1:pb.totalPage}">/下一页&gt;&gt;</a></li>
			</ul>
		 </div>
       </div>
      </div>
        <!-- 普通用户结束 -->
       
     </div>
        
  </div>
  <!-- main 结束 -->
  <!--   云特产管理员后台bottom start -->
 <%@include file="bottom.jsp" %> 
 
 <script type="text/javascript" src="js/jquery-3.3.1.js" charset="utf-8"></script>
 <script type="text/javascript">
  function checkUser(id){
	  //alert(id);
	  location.href="${pageContext.request.contextPath }/UserServlet?action=updateUserState&id="+id;
  }
 </script>
</body>
</html>