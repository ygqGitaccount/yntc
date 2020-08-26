<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/backstage/css/main.css" type="text/css" />
</head>
<body>
     <!--   云特产商家后台head start -->
  <%@include file="head.jsp" %>
  
    <div class="main">
     <div class="left">
       <!--   云特产商家后台left start -->
       <%@include file="left.jsp" %>
     </div>
     
     <div class="right">
       <div id="right1" style="display:block;">
           <div class="TB" >
           <div><label>商品列表</label><button name="add" onclick="change();" id="add" style="margin-left: 60px">添加商品</button></div>
			<table style="width:100%">
			   <tr><th>州市</th>
			       <th>地区</th>
			       <th>商品名称</th>
			       <th>类别</th>
			       <th>销量</th>
			       <th>库存</th>
			       <th>进价</th>
			       <th>售价</th>
			       <th>描述</th>
			      <!--  <th>图片路径</th> -->
			       <th>编辑</th>
			       <th>删除</th>
			   </tr>
			<c:forEach items="${pb.list}" var="LG">
			   <tr>
			     <td>${LG.region }</td>
			     <td>${LG.location }</td>
			     <td>${LG.name }</td>
			     <td>${LG.type }</td>
			     <td>${LG.monnum }</td>
			     <c:if test="${LG.num <= 10 }">
			       <td style="color:#f00;">${LG.num }（请补货）</td>
			     </c:if>
			     <c:if test="${LG.num > 10}">
			        <td>${LG.num }</td>
			     </c:if>
			     <td>${LG.inputprice }</td>
			     <td>${LG.price }</td>
			     <td >${LG.status }</td>
			    <%--  <td>${LG.picurl }</td> --%>
			     <td><a href="${pageContext.request.contextPath }/storeGoodsServlet?action=initUpdate&id=${LG.id}" >编辑</a></td>
			     <%-- <td><a href="${pageContext.request.contextPath }/storeGoodsServlet?action=delGoods&id=${LG.id}">删除</a></td> --%>
			     <td><a href="javascript:delGoods('${LG.id }')">删除</a></td>
			   </tr>  
			</c:forEach>  
 		  
			</table>
          </div>
          
          <div class="paging">
			<ul>

				<li class="disablepage">
				<a href="${pageContext.request.contextPath  }/storeGoodsServlet?action=findGoodsByState&currentPage=${pb.currentPage>1?pb.currentPage-1:pb.currentPage}&word=${pb.words}">&lt;&lt;上一页</a></li>													
				<li>第${pb.currentPage}页/共${pb.totalPage }页</li>
				<li class="nextPage"><a href="${pageContext.request.contextPath  }/storeGoodsServlet?action=findGoodsByState&currentPage=${pb.currentPage<pb.totalPage?pb.currentPage+1:pb.totalPage}&word=${pb.words}">&lt;&lt;下一页</a></li>


			</ul>
		 </div>
          
        </div>
     
       <div id="right2" style="display:none">
          <form action="${pageContext.request.contextPath}/storeGoodsServlet?action=addGoods"  method="post" enctype="multipart/form-data" >
             <div>
              <label>商品名称：</label>
              <input type="text" required="required" name="name">
             </div>
             
             <div>
              <label>类型：</label>
                <select class="select"  name="type">
                     <option value="食品">食品</option>   
					   <option value="手工艺品">手工艺品</option>   
					   <option value="水果">水果</option>   
				       <option value="肉类">肉类</option> 
				        <option value="肉类">干货</option> 
				       <option value="其他">其他</option>
                </select>
             </div>
                  
             <div>
              <label>商品所属州/市：</label>
              <select class="select"  name="region">
                       <option value="昆明市">昆明市</option>   
					   <option value="曲靖市">曲靖市</option>   
					   <option value="玉溪市">玉溪市</option>   
				       <option value="昭通市">昭通市</option>  
				       <option value="丽江市">丽江市</option>
				       <option value="普洱市">普洱市</option>   
					   <option value="保山市">保山市</option>   
					   <option value="临沧市">临沧市</option>   
				       <option value="楚雄市">楚雄州</option>  
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
              <input type="text" required="required" name="location">
             </div>  
             <div style="display:none">
              <label>月销量：</label>
              <input type="text" name="monnum" value="0">
             </div>  
             <div>
              <label>数量：</label>
              <input type="text" id="num" required="required" name="num" onBlur="Number()">
              <font id="a" color="red"></font>
             </div>
             <div>
              <label>进价：</label>
              <input type="text" id="inPrice" required="required" name="inputprice" onBlur="innn()" >
              <font id="b" color="red"></font>
             </div>
             <div>
              <label>售价：</label>
              <input type="text" id="price" required="required" name="price" onBlur="ppp()">
              <font id="c" color="red"></font>
             </div>
             <div style="display:none">
              <label>店主id：</label>
              <input type="text" name="state" value="${user.id }">
             </div>
             <div>
              <label>说明：</label>
              <input type="text" required="required" name="status">
             </div>
             <div>
                                        图片
              <img id="img" width="200px" height="200px" />
              <input type="file" name="picurl" required="required" onchange="loadimg(this)">
             </div>
             <input type="submit" class="sub"  value="提交">
            <%--  <a href="${pageContext.request.contextPath}/GoodsServlet?action=addGoods">提交</a> --%>
          </form>
       </div>
       
       
       
     </div>
    </div>
    
  <!--   云特产商家后台bottom start -->
 <%@include file="bottom.jsp" %> 
  
<script type="text/javascript" src="js/jquery-3.3.1.js" charset="utf-8"></script>
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
 function delGoods(id){
	   if(confirm("确认删除吗？")){
		   location.href="${pageContext.request.contextPath }/storeGoodsServlet?action=delGoods&id="+id;
	   }
 }
 function Number(){
	 var num=document.getElementById("num").value;
	 //alert(num);
	 if(num < 0 || num == 0){
		 document.getElementById("a").innerHTML="数值不能为空或小于0";
	 }
 }
 function innn(){
	 var inPrice=document.getElementById("inPrice").value;
	 if(inPrice < 0 || inPrice == 0){
		 document.getElementById("b").innerHTML="数值不能为空或小于0";
	 }
 }
 function ppp(){
	 var price=document.getElementById("price").value;
	 if(price < 0 || price == 0){
		 document.getElementById("c").innerHTML="数值不能为空或小于0";
	 }
 }
 </script>
</body>
</html>