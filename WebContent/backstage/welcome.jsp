<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="${pageContext.request.contextPath }/backstage/css/bootstrap.css" rel="stylesheet">
	
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.3.1.js"></script>
<script type="text/javascript">
 function update(id,name) {
	 if(confirm("确认要修改"+name+"的信息吗？")){
	 location.href="${pageContext.request.contextPath}/UserServlet?action=initUpdateUser&id="+id;
	 }
 }
 
</script>
	
<style type="text/css">
*{
 margin:0;
 padding:0;
}
.info{
   margin:0px 0 0 120px;
}

</style>
<style>
</style>
</head>
<body>
 <div class="info">
 <form action="">
 
      <div style="margin-left:300px">
			<%-- <img src="${pageContext.request.contextPath}/images/smile.jpg" width="50" class="img-rounded"> --%>
			<span>个人中心</span>
      </div>
		
      <div class="form-group">
       <label>昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称：</label>
       <input id="username" type="text" name="name" value="${user.name }" class="form-control" style="width:900px">
      </div> 
      
      <div class="form-group">
       <label>用户邮箱：</label>
       <input id="username" type="text" name="email" value="${user.email }" class="form-control" style="width:900px">
      </div> 
      
      <div class="form-group">
       <label>用&nbsp;&nbsp;户&nbsp;&nbsp;名：</label>
       <input id="username" type="text" name="username" value="${user.username }" class="form-control" style="width:900px">
      </div> 
      
      <div class="form-group">
       <label>Q&nbsp;Q&nbsp;号&nbsp;：</label>
       <input id="username" type="text" name="qq" value="${user.qq }" class="form-control" style="width:900px">
      </div> 
      
      <div class="form-group">
       <label>联系电话：</label>
       <input id="username" type="text" name="telphone" value="${user.telphone }" class="form-control" style="width:900px">
      </div> 
      
      <div class="form-group">
       <label>余&nbsp;&nbsp;&nbsp;&nbsp;额：</label>
       <input id="username" type="text" name="balance" value="${user.balance }" class="form-control" style="width:900px" readonly="readonly">
      </div> 
       
       
       <a href="javascript:update('${user.id}','${user.name}')" style="font-size: 15px">修&nbsp;&nbsp;改</a>
   
     
     
  </form>
 </div>	
 	
</body>
</html>