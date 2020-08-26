<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/backstage/css/main.css" type="text/css" />
<link href="${pageContext.request.contextPath}/backstage/css/left.css" rel="stylesheet" type="text/css" /> 
</head>
<body>
     <!--   云特产商家后台head start -->
  <%@include file="head.jsp" %>
  
    <div class="main">
     <div class="left">
      <table width="10%" height="10%" border="0px">
			 <tr><!-- target="mainFrame"  -->
			  	<td><a href="${pageContext.request.contextPath}/backstage/merchant.jsp" class="left_list"   >个人中心</a></td>
			  </tr> 
			  <tr>
			  	<td><a href="${pageContext.request.contextPath}/backstage/test.jsp" class="left_list" >商品管理</a></td>
			  </tr>
			  <tr>
			  	<td><a href="" class="left_list">订单管理</a></td>
			  </tr>
			  <tr>
			  	<td><a href="#" class="left_list">销售分析</a></td>
			  </tr>
		</table>
     </div>
     
     <div class="right">
      
     
       <div id="right2" style="display:block">
          <form action="${pageContext.request.contextPath}/GoodsServlet?action=addGoods"  method="post" enctype="multipart/form-data" >
             <div>
              <label>商品名称：</label>
              <input type="text" name="name">
             </div>
             
             <div>
              <label>类型：</label>
                <select class="select"  name="type">
                     <option value="食品">食品</option>   
					   <option value="手工艺品">手工艺品</option>   
					   <option value="水果">水果</option>   
				       <option value="肉类">肉类</option>  
				       <option value="其他">其他</option>
                </select>
             </div>
                  
             <div>
              <label>地区：</label>
              <input type="text" name="region">
             </div>   
             <div style="display:none">
              <label>月销量：</label>
              <input type="text" name="monnum">
             </div>  
             <div>
              <label>数量：</label>
              <input type="text" name="num">
             </div>
             <div>
              <label>价格：</label>
              <input type="text" name="price">
             </div>
             <div style="display:none">
              <label>店主id：</label>
              <input type="text" name="state">
             </div>
             <div>
              <label>说明：</label>
              <input type="text" name="status">
             </div>
             <div>
                                        图片
              <img id="img" width="200px" height="200px" />
              <input type="file" name="picurl" onchange="loadimg(this)">
             </div>
             <input type="submit" class="sub"  value="提交">
             <%-- <a href="${pageContext.request.contextPath}/GoodsServlet?action=addGoods">提交</a> --%>
          </form>
       </div>
     
     </div>
    </div>
  
  
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
function loadimg(obj){
	var file=obj.files[0];//拿到你的上传文件对象
	var url=window.URL.createObjectURL(file);//获得你上传文件的URL值
	document.getElementById("img").src=url;
	
}


 function change(){
	 var r1=document.getElementById("right1");
	  r1.style.display="none";
	  var r101=document.getElementById("right2");
	  r101.style.display="block";
  }


 </script>
</body>
</html>