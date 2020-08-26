<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div class="logo">
       <div class="content">
       <div class="logo_left">
         <a href="#" id="logo"><img  src="${pageContext.request.contextPath }/images/model_logo.png"></a>
         <a id="font">云特产</a>
       </div>
        <div class="searchFrom">
        <form action="${pageContext.request.contextPath }/GoodsServlet" method="post">
           <div class="center" style="position: relative;padding-left:130px">
                 <input type="hidden" name="action" value="searchGoodsByName" />
                 <input id="search" type="text" name="word" class="inputtable" placeholder="输入关键字" onkeyup="searchWord(this)" >
                 <div id="showDiv" style="display:none; position:absolute;z-index:1000;background:#fff; width:300px;border:2px solid #ccc;"></div>
                <button id="bt" type="submit">搜&nbsp;&nbsp;索</button>
           </div>  
        </form> 
        </div>  
       </div>
 </div>
 
 
 <script type="text/javascript" src="js/jquery-3.3.1.js" charset="utf-8"></script>
 <script type="text/javascript">
 function onclickFun(obj){
	  var value = $(obj).html();
	  $("#search").val(value);
	  document.getElementById("showDiv").style.display="none";
 }
 
 function onmouseoverFun(obj){
	  $(obj).css("background","green");
 }
 function onmouseoutFun(obj){
	  $(obj).css("background","white");
 }
 
	 function searchWord(obj){
		 var word=$("#search").val();
		 //alert(word);
		 $.post(
	      "${pageContext.request.contextPath }/GoodsServlet",
			  {"action":"searchGoodsByLikeName","word":word},
			  function(data){
				    if(data.length>0){
				    	var content="";
				    	for(var i=0;i<data.length;i++){
				    		content+="<div onclick='onclickFun(this)' onmouseover='onmouseoverFun(this)' onmouseout='onmouseoutFun(this)'>"+data[i]+"</div>";
				    	}
				        
				    	$("#showDiv").css("display","block");
				    	$("#showDiv").html(content);
				      }
				    },
			  
			  "json"
		 );
	 }
 </script>
</body>
</html>