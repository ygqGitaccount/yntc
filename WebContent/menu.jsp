<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="menu">
      <div class="content">
       <ul>
       
        <li id="shadow"><a href="${pageContext.request.contextPath }/GoodsServlet?action=findAll">商品分类</a></li>
         <li><a href="${pageContext.request.contextPath }/GoodsServlet?action=findAll">首页</a></li>
         <li><a href="${pageContext.request.contextPath }/GoodsServlet?action=findList">全部商品</a></li>
        <li><a href="${pageContext.request.contextPath }/UserServlet?action=findStoreName">店铺街</a></li>
        <li><a href="${pageContext.request.contextPath }/storeRegister.jsp">我要入驻</a></li>
       </ul>
       </div>
    </div>