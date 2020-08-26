<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link>
<div class="header">
      <div class="content">
      <c:if test="${empty user }">
        <a style="float:left">您好，云特产欢迎你！</a>
        <div class="right" style="float:left">
         <ul>
           <li><a id="login" href="login.jsp">请登录</a>/</li>
           <li><a href="register.jsp">注册</a>/</li>
           <li><a href="#" onclick="alert('请先登录');">购物车</a></li>
         </ul>
        </div>
        </c:if>
        
         <c:if test="${not empty user }">
          
         <a style="float:left">您好，云特产欢迎你！</a>
          <div class="right" style="float:left">
         <ul>
           <li><a id="login">${user.name }欢迎您</a></li>
           <li><a href="${pageContext.request.contextPath }/CartServlet?action=clickShopping" >购物车</a>|</li>
           <li><a href="${pageContext.request.contextPath }/personalCenter.jsp">个人中心</a>|</li>
           <li><a href="${pageContext.request.contextPath }/LoginOutServlet">[安全退出]</a></li>
         </ul>
        </div>
         </c:if> 
       
      </div>
</div>
 