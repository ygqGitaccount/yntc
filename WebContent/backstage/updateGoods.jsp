<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/backstage/css/main.css" type="text/css" />
<title>Insert title here</title>
</head>
<body>
    <!--   云特产商家后台head start -->
  <%@include file="head.jsp" %>
   <div class="main" style="background:#fff;">
     <div class="left">;
       <!--   云特产商家后台left start -->
       <%@include file="left.jsp" %>
     </div>
     
      <div >
          <form action="${pageContext.request.contextPath}/storeGoodsServlet?action=updateGoods"  method="post" enctype="multipart/form-data" >
             <div style="display:none">
               <label>商品id：</label>
              <input type="text" name="id" value="${goods.id }">
             </div>
             
             <div>
              <label>商品名称：</label>
              <input type="text" name="name" value="${goods.name }">
             </div>
             
             <div>
              <label>类型：</label>
                <select class="select"  name="type" > 
                     <option id="option1" value="食品">食品</option>   
					   <option value="手工艺品">手工艺品</option>   
					   <option value="水果">水果</option>   
				       <option value="肉类">肉类</option>  
				       <option value="其他">其他</option>
				       <option value="干货">干货</option>
                </select>
             </div>
                  
             <div>
              <label>特产所属州/市：</label>
              <select class="select"  name="region">
                     <option value="昆明市">昆明市</option>   
					   <option value="曲靖市">曲靖市</option>   
					   <option value="玉溪市">玉溪市</option>   
				       <option value="昭通市">昭通市</option>  
				       <option value="丽江市">丽江市</option>
				       <option value="普洱市">普洱市</option>   
					   <option value="保山市">保山市</option>   
					   <option value="临沧市">临沧市</option>   
				       <option value="楚雄市">楚雄市</option>  
				       <option value="红河州">红河州</option>
				       <option value="迪庆州">迪庆州</option>   
					   <option value="文山州">文山州</option>   
					   <option value="西双版纳州">西双版纳州</option>   
				       <option value="大理州">大理州</option>  
				       <option value="德宏州">德宏州</option>
				       <option value="怒江州">怒江州</option>
                </select>
             </div>   
              <div>
              <label>原产地：</label>
              <input type="text" name="location" value="${goods.location }">
             </div>
             <div style="display:none">
              <label>月销量：</label>
              <input type="text" name="monnum" value="0" value="${goods.monnum }">
             </div>  
             <div>
              <label>数量：</label>
              <input type="text" name="num" value="${goods.num }">
             </div>
             <div>
              <label>进价：</label>
              <input type="text" name="inputprice" value="${goods.inputprice }">
             </div>
             <div>
              <label>售价：</label>
              <input type="text" name="price" value="${goods.price }">
             </div>
             <div style="display:none">
              <label>店主id：</label>
              <input type="text" name="state" value="${user.id }">
             </div>
             <div>
              <label>说明：</label>
              <input type="text" name="status" value="${goods.status }">
             </div>
             <div>
                                        图片
              <img id="img" width="200px" height="200px" src="${pageContext.request.contextPath }/${goods.picurl}"/>
              <input type="file" name="picurl" onchange="loadimg(this)" >
             </div>
             <input type="submit" class="sub"  value="提交">
          </form>
       </div>
     
     </div>
     
    
     
     
      <!--   云特产商家后台bottom start -->
 <%@include file="bottom.jsp" %> 
 
 <script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
function loadimg(obj){
	var file=obj.files[0];//拿到你的上传文件对象
	var url=window.URL.createObjectURL(file);//获得你上传文件的URL值
	document.getElementById("img").src=url;
	
}
</script>
</body>
</html>