<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/index.css" type="text/css" />
<title>个人信息</title>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
function change(){
	 var r1=document.getElementById("right1");
	  r1.style.display="none";
	  var r101=document.getElementById("right2");
	  r101.style.display="block";
 }
function submit(){
	  location.href="${pageContext.request.contextPath}/UserServlet?action=updateUserInfo&id="+id;
}
function recharge(){
	var recharge =prompt("请输入充值金额！小于1000大于100")
	if(recharge != null){
	   if(recharge > 1000 || recharge < 100){
		  if(confirm("充值金额大于1000或小于100，请重新输入"));
			return;
	   } else{
		location.href="${pageContext.request.contextPath}/UserServlet?action=Recharge&recharge="+recharge;
	   } 
    }else{
    	return;
    }
}
</script>


<style type="text/css">
.TB table{
  *border-collapse;/* 兼容ie7及其以下版本的浏览器 */
   border-spacing:0;
   border:solid #ccc 1px;
   box-shadow:0 1px 1px #ccc;
}
.TB th, .TB td{
  border-left:1px solid #ccc;
  border-top: 1px solid #ccc;
  padding:10px;
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
</head>
<body>
 <%@include file="head.jsp" %>
   
  <div style="heigth:570px;">
  <%@include file="personalLeft.jsp" %>
  <!-- allInfo开始 -->
   <div class="info" style="width: 90%; height: 570px; background:#fff;float:left;">
<!-- 用户信息开始 -->
	  <div id="right1" style="display:block;"> 
          <div class="TB">
			<table style="width:100%">
			   <tr>
			       <th>昵称</th>
			       <th>邮箱</th>
			       <th>用户名</th>
			       <th>QQ号</th>
			       <th>联系电话</th>
			       <th>账户余额</th>
			       <th>操作</th>
			       <th>账户充值</th>
			   </tr>
			   <tr>
			       <td id="name">${user.name }</td>
			       <td id="email">${user.email }</td>
			       <td id="username"  >${user.username }</td>
			       <td id="qq">${user.qq }</td>
			       <td id="telphone"  >${user.telphone }</td>
			       <td id="balance"  >${user.balance }</td>
			       <td><a href="#" onclick="change()" >修改</a></td>
			       <td><a href="#" onclick="recharge()" >充值</a></td>
			   </tr>
			</table>
           </div>
          </div>   
          <!-- 用信息结束 -->
          <!-- updateinfo开始 -->
           <div id="right2" style="display:none;"> 
        <form action="${pageContext.request.contextPath }/UserServlet?action=updateUserInfo" method="post">
         <div class="">
            <div class="update">
                <div class="loginBoxCenter">
                    <p><label for="name">昵称：</label></p>
                    <!--autofocus 规定当页面加载时按钮应当自动地获得焦点。 -->
                    <!-- placeholder提供可描述输入字段预期值的提示信息-->
                    <p><input type="text" name="name" autofocus="autofocus" required="required" autocomplete="off"  value="${user.name}" /></p>
                    <!-- required 规定必需在提交之前填写输入字段-->
                    <p><label for="email">邮箱：</label></p>
                    <p><input type="text"  name="email"  required="required" value="${user.email}" /></p>
                    <p><label for="username">用户名：</label></p>
                    <p><input type="text" name="username"  autofocus="autofocus" required="required" autocomplete="off" value="${user.username }" /></p>
                    <p><label for="qq">QQ号：</label></p>
                    <p><input type="text" name="qq"  autofocus="autofocus" required="required" autocomplete="off" value="${user.qq }" /></p>
                    <p><label for="telphone">联系电话：</label></p>
                    <p><input type="text" name="telphone"  autofocus="autofocus" required="required" autocomplete="off" value="${user.telphone }" /></p>
                    <input type="hidden" name="id" value="${user.id }" />
                        <input type="submit" value="提交"/>
                       <%--  <a href="${pageContext.request.contextPath }/UserServlet?action=updateUser&id=${user.id}">提交</a> --%>
               </div> 
            </div>
       </div>
       </form> 
     </div>     
       <!-- updateinfo结束 -->   
   </div>
   </div>
  <!-- allInfo结束 -->
  <%@include file="personalCenterBottom.jsp" %>
</body>
</html>