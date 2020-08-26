<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商家后台管理</title>
<style type="text/css">
*{
  margin:0;
  padding:0;
}
a{
  text-decoration: none;
}
 ul li{
  list-style:none;
  float:left;
}
.merchant_head{
   width:100%;
   height:50px;
   background:#22ac38;
  /*  position: relative; */
}
.ytcHt{
  width:350px;
  height:100%;
   /* background:red;  */
   float:left;
  margin-left:500px;
  line-height: 50px;
  font-size: 30px;
  text-align: center;
  font-family: STSong;
  /* position: absolute; */
}
.welcome{
  width:300px;
  height:100%;
  float:left; 
  /* background:blue; */
  margin-left:150px;
  line-height: 50px;
  font-size: 20px;
  text-align: center;
  font-family: STSong;
}
#login{
  color:#f59f1d;
}
#out{
 font-size: 20px;
}
</style>
</head>
<body>
      <div class="merchant_head">
      
         <c:if test="${not empty user }">
          
            <div class="ytcHt">云特产后台商家管理系统</div>
            <div class="welcome">
             <ul>
              <li><a id="login">${user.name }欢迎您</a></li>
              <li><a  id="out" href="${pageContext.request.contextPath }/LoginOutServlet">[安全退出]</a></li>
             </ul>
            </div>
         </c:if> 
      </div>


</body>
</html>