<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商家入驻</title>
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
       <tr><td colspan="2"><h1>商家入驻</h1></td></tr>
       <tr>
            <td  style="text-align:right;">商店名称：</td>
            <td><input type="text" name="name" requi
            red="required" value="${uf.name }"/>
            <font color="#f00">${uf.msg.name }</font>
            </td>
       </tr>
         
         <tr>
           <td style="text-align:right;">用户邮箱：</td>
           <td>
            <input type="text" class="textinput" id="email"
             name="email" required="required" value="${uf.email }" />
           <font color="#f00">${uf.msg.email }</font>
           </td>
         </tr> 
         
         <tr>
            <td style="text-align: right">用户名：</td>
            <td>
            <input type="text" class="textinput" name="username" required="required" value="${uf.username }"/>
            <font color="#f00">${uf.msg.username }</font>
            </td>
         </tr>
         
         <tr>
           <td style="text-align: right">密码：</td>
           <td>
             <input id="password" type="password" class="textinput" 
             name="password" required="required" />
             <font color="#f00">${uf.msg.password }</font>
           </td>
         </tr>
         
         <tr>
            <td style="text-align: right">重复密码：</td>
            <td>
              <input id="repassword" onBlur="fun()" type="password" class="textinput" 
              name="repassword" required="required" />
              <font id="tt" color="#f00"></font> 
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
           <input type="text" class="textinput" name="qq" required="required" value="${uf.qq }" />
           <font color="#f00">${uf.msg.qq }</font> 
          </td>
         </tr>
         
         <tr>
          <td style="text-align: right">联系电话：</td>
          <td>
           <input type="text" class="textinput" name="telphone" required="required" value="${uf.telphone }" />
           <font color="#f00">${uf.msg.telphone }</font> 
          </td>
         </tr>
         
         <tr>
          <td style="text-align:right">地区：</td>
           <td>
           <input type="text" class="textinput" name="region" required="required" value="${uf.region }" />
           <font color="#f00">${uf.msg.region }</font> 
          </td>
         </tr>
         
          <tr>
          <td style="text-align:right">详细地址：</td>
           <td>
           <input type="text" class="textinput" name="address" required="required" value="${uf.address }" />
           <font color="#f00">${uf.msg.address }</font> 
          </td>
         </tr>
         
         <tr><td colspan="2"><input style="display: none;" name="state" value="0"></td></tr>
         <tr><td colspan="2"><input style="display:none" name="balance" value="0"></td></tr>
         <!-- <tr><td><input style="display: none;" name="balance" value="0"></td></tr> -->
		 
		 <tr style="display:none">
		    <td style="text-align: right">身份：</td>
		    <td><input type="text" name="role" value="1"/></td>
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

<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.3.1.js"></script>
<script type="text/javascript">
 function fun(){
	 var password=document.getElementById("password").value;
	 var repassword=document.getElementById("repassword").value;
	 
	 if(password != repassword){
		document.getElementById("tt").innerHTML="两次密码不一致，请重新输入";
		 
	 }else{
		 return;
	 }
 }
</script>
</body>
</html>