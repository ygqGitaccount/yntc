<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册页面</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/index.css" type="text/css" />
<style type="text/css">
*{
  margin:0;
  padding:0;
}
table tr td{
 /* height:30px; */
}
#img{
   margin-left:155px;
   margin-top:20px;
}
</style>
</head>
<body>
    <!--   云特产顶部start -->
    <%@include file="head.jsp" %>
    <!--   云特产菜单列表 start-->
    <%@include file="menu.jsp" %>
    
    <!--   用户注册 -->
<div class="register" align="center">
 <form action="${pageContext.request.contextPath }/RegisterServlet" method="post" >
    <table width="600px" border="0px" cellpadding="0" style="background:; margin:50px;auto">
       <tr><td colspan="2"><h1>会员注册</h1></td></tr>
       <tr>
            <td  style="text-align:right;">昵称：</td>
            <td><input type="text" name="name"  value="${uf.name }"/>
            <font color="#f00">${uf.msg.name }</font>
            </td>
       </tr>
         
         <tr>
           <td style="text-align:right;">用户邮箱：</td>
           <td>
            <input type="text" class="textinput" id="email"
             name="email"  value="${uf.email }" />
           <font color="#f00">${uf.msg.email }</font>
           </td>
         </tr> 
         
         <tr>
            <td style="text-align: right">用户名：</td>
            <td>
            <input type="text" class="textinput" name="username" value="${uf.username }"/>
            <font color="#f00">${uf.msg.username }</font>
            </td>
         </tr>
         
         <tr>
           <td style="text-align: right">密码：</td>
           <td>
             <input type="password" class="textinput" 
             name="password" />
             <font color="#f00">${uf.msg.password }</font>
           </td>
         </tr>
         
         <tr>
            <td style="text-align: right">重复密码：</td>
            <td>
              <input type="password" class="textinput" 
              name="repassword"  />
              <font color="#f00">${uf.msg.repassword }</font> 
            </td>
         </tr>
         
         <tr>
           <td style="text-align: right">性别：</td>
           <td colspan="2"> &nbsp;&nbsp;
            <input type="radio" name="gender" value="男" checked="checked"/>男
            &nbsp;&nbsp;&nbsp;&nbsp;
            <input type="radio" name="gender" value="女" />女
           </td>
         </tr>
         
         <tr>
          <td style="text-align:right">QQ号：</td>
           <td >
           <input type="text" class="textinput" name="qq" value="${uf.qq }" />
           <font color="#f00">${uf.msg.qq }</font> 
          </td>
         </tr>
         
         <tr>
          <td style="text-align: right">联系电话：</td>
          <td>
           <input type="text" class="textinput" name="telphone" value="${uf.telphone }" />
           <font color="#f00">${uf.msg.telphone }</font> 
          </td>
         </tr>
         
         <tr>
          <td style="text-align:right">地区：</td>
           <td>
           <input type="text" class="textinput" name="region" value="${uf.region }" />
           <font color="#f00">${uf.msg.region }</font> 
          </td>
         </tr>
         
          <tr>
          <td style="text-align:right">详细地址：</td>
           <td>
           <input type="text" class="textinput" name="address" value="${uf.address }" />
           <font color="#f00">${uf.msg.address }</font> 
          </td>
         </tr>
         
         <tr><td colspan="2"><input style="display: none;" name="state" value="2"></td></tr>
         <tr><td colspan="2"><input style="display: none;" name="balance" value="1000"></td></tr>
         <!-- <tr><td><input style="display: none;" name="balance" value="0"></td></tr> -->
		 
		 <tr style="display:none">
		    <td style="text-align: right">身份：</td>
		    <td><input type="text" name="role" value="2"/></td>
		 </tr>		
           <tr>
             <td colspan="2" >
               <input type="image" src="${pageContext.request.contextPath }/images/signup.gif" 
               name="submit" border="0" id="img"/>
             </td>
           </tr>
            </table>
 </form>
</div> 
</body>
</html>