<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/index.css" type="text/css" >
<style type="text/css">
  .login{
    margin:50px auto;
    background: #dadada;
    width:500px;
    height:500px;
  }
  .login .item{                                  
    height:40px;
  }
  #submt{
  dispaly:block;
  width:70px;
  height:25px;
  /*  background:red; */
  }
</style>
</head>
<body>
<%
	Cookie[] cookies=request.getCookies();
    for(int i=0;cookies!=null && i<cookies.length;i++){
    	if("user".equals(cookies[i].getName())){
        //String value= cookies[i].getValue();
        String username = cookies[i].getValue().split("-")[0];
        String password = cookies[i].getValue().split("-")[1];
        
        String checked="checked='checked'";
        request.setAttribute("username", username);
        request.setAttribute("password",password);
        request.setAttribute("checked", checked);
    	}
    }
    
    
    
%>



   <!--   云特产顶部start -->
    <%@include file="head.jsp" %>
    <!--   云特产菜单列表 start-->
    <%@include file="menu.jsp" %>
   <div class="login" > 
    <form  action="${pageContext.request.contextPath }/LoginServlet" method="post">
      <table >
      <tr>
      <td style="padding:30px; align=right;"><h1>会员登录</h1></td>
      </tr>
      
      <tr>
      <td>&nbsp;</td>
        <td style="text-align:center;padding-top:20px;">
	    <font color="#f00" >${requestScope["login_message"]}</font>
		</td>
      </tr>
      
      <tr class="item">
        <td style="text-align:right;" >用户名：</td>
        <td><input type="text" name="username" required="required" value="${username }"  /></td>
      </tr>
      
      <tr class="item">
        <td style="text-align:right;" >密码：</td>
        <td><input type="password" name="password" required="required" value="${password }" /></td>
      </tr>
      
           <tr class="item">
             <td style="text-align:right;" >请输入验证码：</td>        
             <td >
             <input type="text" class="textinput" name="checkcode"/>
             </td>
           </tr>
          <tr class="item">
            <td >&nbsp;</td>
            <td >
            <img src="${pageContext.request.contextPath }/CheckImagServlet" 
            id="img" width="100" height="24">
            <a href="javascript:void(0);"  onclick="changeImage()">看不清换一张</a>${msg }
            </td>
           </tr> 
           
           <!-- <tr>
             <td>&nbsp;</td>
             <td><input type="checkbox" name="checkbox" >记住我</td>
           </tr> -->
          <tr class="item">
            <td>&nbsp;</td>
             <td><input id="submt" type="image"  src="${pageContext.request.contextPath }/images/loginbutton.gif" /></td>
          </tr> 
           
      </table>
    </form>
   </div>
   
   
   
   <script type="text/javascript" src="${pageContext.request.contextPath }/js/form.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.3.1.js"></script>
<script type="text/javascript">
function changeImage() {
	// 改变验证码图片中的文字
	document.getElementById("img").src = "${pageContext.request.contextPath}/CheckImagServlet?time="
			+ new Date().getTime();
}
</script> 
</body>
</html>