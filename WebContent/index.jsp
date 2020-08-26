<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>云南特产首页</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/index.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/goodsList.css" type="text/css" />
<style type="text/css">
.bbt{width:500px;margin:0 auto;height:40px;}
.bbt ul li{float:left;list-style: none;line-height: 40px; margin-left:20px}
</style>

</head>
<body style="background:#f5f5f5" >
  <!--   云特产顶部start -->
    <%@include file="head.jsp" %>
    <!-- 云特产logostart -->
    <%@include file="logo_search.jsp" %>
  <!--   云特产菜单列表 start-->
    <%@include file="menu.jsp" %>
   
   <div class="main" style="overflow: hidden;">
     <div class="content">
       <div class="left" >
          <ul>
            <li class="list" id="list"><a >地方特产</a></li>
            <li class="list" id="list1"><a>食品</a></li>
            <li class="list" id="list2"><a>手工艺品</a></li>
            <li class="list" id="list3"><a>水果</a></li>
            <li class="list" id="list4"><a>肉类</a></li>
            <li class="list" id="list5"><a>干货</a></li>
            <li class="list" id="list6"><a>其他</a></li>
          </ul>
       </div>
      
       <div class="main_center" style="display:block" id="mainCenter">
         <div>
           <h3 class="hot">今日热销商品</h3>
         </div>
         <div class="lbt" >
            <ul>
             <c:forEach items="${lg}" var="LG" begin="0" end="9" >
            <li><a  href="javascript:findGoodsById('${LG.id }','${LG.state }')" ><img  src="${LG.picurl }" alt="" ></a></li>
            </c:forEach>
            <!-- <li><img  src="images/2.jpg" alt="" ></li> -->
            </ul>
            
           <div class="btn"> < </div>
		   <div class="btn right"> > </div>
		   <div class="circle">
				<!--icon-->
				<!--i标签行内元素，文字倾斜-->
				<i class="current"></i>
				<i></i>
				<i></i>
				<i></i>
				<i></i>
				<i></i>
				<i></i>
				<i></i>
				<i></i>
				<i></i>
			</div>
       </div>
         <div class="lbt_right">
           <ul>
             <c:forEach items="${lg}" var="LG" begin="0" end="9" >
                <li class="current1" style="overflow: hidden;text-overflow: ellipsis;white-space: nowrap;">${LG.name }</li>
             </c:forEach>
           </ul>
         </div> 
       
       <div class="main_center_bottom">
        <c:forEach items="${lg }" var="LG" begin="0" end="3"> 
          <div class="four">
            <div class="four_top">
             <a href="javascript:findGoodsById('${LG.id }','${LG.state }')"><img alt="" src="${LG.picurl}"></a>
            </div>
            <div class="four_bottom">${LG.name}&nbsp;&nbsp;${LG.status}</div>       
          </div>
          </c:forEach>
         </div>    
         
       </div>
        <!-- div class="main_center"结束--> 
        
             <!-- 商品分类category div -->
          <div class="category" id="category"  style="display:none;" >
                   <div class="category1" >
             <div class="region">
                   <label>昆明特产></label>  
             </div>
             <div class="location">
                <c:forEach items="${lg }" var="LG">
                    <c:choose>
                      <c:when test="${LG.region=='昆明市' }">
                       <a href="javascript:findGoodsById('${LG.id }','${LG.state }')">|${LG.name }</a>
                      </c:when>
                   </c:choose>
                </c:forEach>
             </div>
            </div>
            
           <div class="category1">
             <div class="region">
             <label>曲靖特产></label>
             </div>
             <div class="location">
                <c:forEach items="${lg }" var="LG">
                    <c:choose>
                      <c:when test="${LG.region=='曲靖市' }">
                       <a href="javascript:findGoodsById('${LG.id }','${LG.state }')">|${LG.name }</a>
                      </c:when>
                   </c:choose>
                </c:forEach>
             </div>
            </div>
           <div class="category1">
             <div class="region">
              <label>玉溪特产></label>
             </div>
             <div class="location">
                <c:forEach items="${lg }" var="LG">
                    <c:choose>
                      <c:when test="${LG.region=='玉溪市' }">
                       <a href="javascript:findGoodsById('${LG.id }','${LG.state }')">|${LG.name }</a>
                      </c:when>
                   </c:choose>
                </c:forEach>
             </div>
            </div>
            <div class="category1">
             <div class="region">
             <label>昭通特产></label>
             </div>
             <div class="location">
                <c:forEach items="${lg }" var="LG">
                    <c:choose>
                      <c:when test="${LG.region=='昭通市' }">
                       <a href="javascript:findGoodsById('${LG.id }','${LG.state }')">|${LG.name }</a>
                      </c:when>
                   </c:choose>
                </c:forEach>
             </div>
            </div>
             <div class="category1">
             <div class="region">
             <label>丽江特产></label>
             </div>
             <div class="location">
                <c:forEach items="${lg }" var="LG">
                    <c:choose>
                      <c:when test="${LG.region=='丽江市' }">
                       <a href="javascript:findGoodsById('${LG.id }','${LG.state }')">|${LG.name }</a>
                      </c:when>
                   </c:choose>
                </c:forEach>
             </div>
            </div>
             <div class="category1">
             <div class="region">
             <label >普洱特产></label>
             </div>
             <div class="location">
                <c:forEach items="${lg }" var="LG">
                    <c:choose>
                      <c:when test="${LG.region=='普洱市' }">
                       <a href="javascript:findGoodsById('${LG.id }','${LG.state }')">|${LG.name }</a>
                      </c:when>
                   </c:choose>
                </c:forEach>
             </div>
            </div>
             <div class="category1">
             <div class="region">
             <label >保山特产></label>
             </div>
             <div class="location">
                <c:forEach items="${lg }" var="LG">
                    <c:choose>
                      <c:when test="${LG.region=='保山市' }">
                       <a href="javascript:findGoodsById('${LG.id }','${LG.state }')">|${LG.name }</a>
                      </c:when>
                   </c:choose>
                </c:forEach>
             </div>
            </div>
             <div class="category1">
             <div class="region">
             <label >临沧特产></label>
             </div>
             <div class="location">
                <c:forEach items="${lg }" var="LG">
                    <c:choose>
                      <c:when test="${LG.region=='临沧市' }">
                       <a href="javascript:findGoodsById('${LG.id }','${LG.state }')">|${LG.name }</a>
                      </c:when>
                   </c:choose>
                </c:forEach>
             </div>
            </div>
             <div class="category1">
             <div class="region">
             <label>楚雄特产></label>
             </div>
             <div class="location">
                <c:forEach items="${lg }" var="LG">
                    <c:choose>
                      <c:when test="${LG.region=='楚雄州' }">
                       <a href="javascript:findGoodsById('${LG.id }','${LG.state }')">${LG.name }</a>|
                      </c:when>
                   </c:choose>
                </c:forEach>
             </div>
            </div>
             <div class="category1">
             <div class="region">
             <label>红河特产></label>
             </div>
             <div class="location">
                <c:forEach items="${lg }" var="LG">
                    <c:choose>
                      <c:when test="${LG.region=='红河州' }">
                       <a href="javascript:findGoodsById('${LG.id }','${LG.state }')">|${LG.name }</a>
                      </c:when>
                   </c:choose>
                </c:forEach>
             </div>
            </div>
             <div class="category1">
             <div class="region">
             <label>迪庆特产></label>
             </div>
             <div class="location">
                <c:forEach items="${lg }" var="LG">
                    <c:choose>
                      <c:when test="${LG.region=='迪庆州' }">
                       <a href="javascript:findGoodsById('${LG.id }','${LG.state }')">${LG.name }</a>|
                      </c:when>
                   </c:choose>
                </c:forEach>
             </div>
            </div>
             <div class="category1">
             <div class="region">
             <label>文山特产></label>
             </div>
             <div class="location">
                <c:forEach items="${lg }" var="LG">
                    <c:choose>
                      <c:when test="${LG.region=='文山州' }">
                       <a href="javascript:findGoodsById('${LG.id }','${LG.state }')">|${LG.name }</a>
                      </c:when>
                   </c:choose>
                </c:forEach>
             </div>
            </div>
             <div class="category1">
             <div class="region">
             <label>西双版纳特产></label>
             </div>
             <div class="location">
                <c:forEach items="${lg }" var="LG">
                    <c:choose>
                      <c:when test="${LG.region=='西双版纳州' }">
                       <a href="javascript:findGoodsById('${LG.id }','${LG.state }')">|${LG.name }</a>
                      </c:when>
                   </c:choose>
                </c:forEach>
             </div>
            </div>
             <div class="category1">
             <div class="region">
             <label>大理特产></label>
             </div>
             <div class="location">
                <c:forEach items="${lg }" var="LG">
                    <c:choose>
                      <c:when test="${LG.region=='大理州' }">
                       <a href="javascript:findGoodsById('${LG.id }','${LG.state }')">|${LG.name }</a>
                      </c:when>
                   </c:choose>
                </c:forEach>
             </div>
            </div>
             <div class="category1">
             <div class="region">
             <label>德宏特产></label>
             </div>
             <div class="location">
                <c:forEach items="${lg }" var="LG">
                    <c:choose>
                      <c:when test="${LG.region=='德宏州' }">
                       <a href="javascript:findGoodsById('${LG.id }','${LG.state }')">|${LG.name }</a>
                      </c:when>
                   </c:choose>
                </c:forEach>
             </div>
            </div>
             <div class="category1">
             <div class="region">
             <label>怒江特产></label>
             </div>
             <div class="location">
                <c:forEach items="${lg }" var="LG">
                    <c:choose>
                      <c:when test="${LG.region=='怒江州' }">
                       <a href="javascript:findGoodsById('${LG.id }','${LG.state }')">|${LG.name }</a>
                      </c:when>
                   </c:choose>
                </c:forEach>
             </div>
            </div>
        </div>
          <!-- <div class="category" id="category" >结束 --> 
            
          <!-- 食品分类开始 -->
          <div class="food" id="food" style="display:none">
             <c:forEach items="${lg }" var="LG">
                    <c:choose>
                      <c:when test="${LG.type=='食品' }">
                       <a href="javascript:findGoodsById('${LG.id }','${LG.state }')">|${LG.name }</a>
                      </c:when>
                   </c:choose>
                </c:forEach>
          </div>
          <!-- 食品分类结束 -->    
          
          <!-- 手工艺品开始 -->
             <div class="handiwork" id="handiwork" style="display:none">
                <c:forEach items="${lg }" var="LG">
                    <c:choose>
                      <c:when test="${LG.type=='手工艺品' }">
                       <a href="javascript:findGoodsById('${LG.id }','${LG.state }')">|${LG.name }</a>
                      </c:when>
                   </c:choose>
                </c:forEach>
             </div>             
           <!-- 手工艺品结束 -->  
           
           <!-- 水果开始 --> 
              <div class="fruit" id="fruit" style="display:none">
                <c:forEach items="${lg }" var="LG">
                    <c:choose>
                      <c:when test="${LG.type=='水果' }">
                       <a href="javascript:findGoodsById('${LG.id }','${LG.state }')">|${LG.name }</a>
                      </c:when>
                   </c:choose>
                </c:forEach>
              </div>
            <!-- 水果结束 --> 
            
            <!-- 肉类开始 -->
              <div class="meat" id="meat" style="display:none">
                 <c:forEach items="${lg }" var="LG">
                    <c:choose>
                      <c:when test="${LG.type=='肉类' }">
                       <a href="javascript:findGoodsById('${LG.id }','${LG.state }')">|${LG.name }</a>
                      </c:when>
                   </c:choose>
                </c:forEach>
              </div>
            <!-- 肉类结束 -->
            
            <!-- 干货开始 -->
               <div class="dryCargo" id="dryCargo" style="display:none">
                   <c:forEach items="${lg }" var="LG">
                    <c:choose>
                      <c:when test="${LG.type=='干货' }">
                       <a href="javascript:findGoodsById('${LG.id }','${LG.state }')">|${LG.name }</a>
                      </c:when>
                   </c:choose>
                </c:forEach>
               </div>
            <!-- 干货结束 -->
            <!-- 其他开始 -->
              <div class="other" id="other"  style="display:none">
                  <c:forEach items="${lg }" var="LG">
                    <c:choose>
                      <c:when test="${LG.type=='其他' }">
                       <a href="javascript:findGoodsById('${LG.id }','${LG.state }')">|${LG.name }</a>
                      </c:when>
                   </c:choose>
                </c:forEach>
              </div>
            <!-- 其他结束 -->
      </div>
         <!-- <div content结束 -->
   </div>
   <!-- <div class="main">结束 -->
   
   <!-- 推荐开始 -->
   <div style="overflow: hidden;">
      <!--食品开始 -->
    <div class="first">
       <div class="content">
          <div class="foodTop">
             <h3>热门食品</h3>
             <hr style="border:2px solid #0f0;">
          </div>
          <div class="foodItems">
               <c:forEach items="${lg }" var="LG">
                 <c:choose >
                  <c:when test="${LG.type=='食品' }">
                 
               <div class="foodHot">
                <div class="foodHotTop">
                 <a href="javascript:findGoodsById('${LG.id }','${LG.state }')"><img  alt="" src="${LG.picurl }"></a>
              </div>
              <div class="foodHotCenter">
                <ul><li><font style="color:#000;font-size: 15px;">${LG.status }</font></li></ul>
              </div>
              <div class="foodHotBottom">
                 <ul>
                   <li>￥${LG.price }</li>
                   <li id="Monnum"><font style="color:#a9a9a9; font-size: 15px">销量</font>${LG.monnum }</li>
                </ul>
              </div>
              </div>
               </c:when>
               <c:otherwise></c:otherwise>
              </c:choose>
            </c:forEach>
          </div>
          <div class="hotright">
            <p style="text-align: right;"><a onclick="moreFood()" style="cursor: pointer;">更多>></a></p>
          </div>
       </div>
    </div>
      <!--食品 div结束 -->
      <!-- 手工艺品开始 -->
       <div class="first">
       <div class="content">
          <div class="foodTop">
             <h3>手工艺品推荐</h3>
             <hr style="border:2px solid #0f0;">
          </div>
          <div class="foodItems">
               <c:forEach items="${lg }" var="LG">
                 <c:choose >
                  <c:when test="${LG.type=='手工艺品' }">
                 
               <div class="foodHot">
                <div class="foodHotTop">
                 <a href="javascript:findGoodsById('${LG.id }','${LG.state }')"><img  alt="" src="${LG.picurl }"></a>
              </div>
              <div class="foodHotCenter">
                <ul><li><font style="color:#000;font-size: 15px;">${LG.status }</font></li></ul>
              </div>
              <div class="foodHotBottom">
                 <ul>
                   <li>￥${LG.price }</li>
                   <li id="Monnum"><font style="color:#a9a9a9; font-size: 15px">销量</font>${LG.monnum }</li>
                </ul>
              </div>
              </div>
               </c:when>
               <c:otherwise></c:otherwise>
              </c:choose>
            </c:forEach>
          </div>
          <div class="hotright">
            <p style="text-align: right;"><a onclick="moreHandicraft()" style="cursor: pointer;">更多>></a></p>
          </div>
       </div>
    </div>
      <!-- 手工艺品结束 -->
      <!-- 水果开始 -->
       <div class="first">
       <div class="content">
          <div class="foodTop">
             <h3>水果类推荐</h3>
             <hr style="border:2px solid #0f0;">
          </div>
          <div class="foodItems">
               <c:forEach items="${lg }" var="LG">
                 <c:choose >
                  <c:when test="${LG.type=='水果' }">
                 
               <div class="foodHot">
                <div class="foodHotTop">
                <a href="javascript:findGoodsById('${LG.id }','${LG.state }')"><img  alt="" src="${LG.picurl }"></a>
              </div>
              <div class="foodHotCenter">
                <ul><li><font style="color:#000;font-size: 15px;">${LG.status }</font></li></ul>
              </div>
              <div class="foodHotBottom">
                 <ul>
                   <li>￥${LG.price }</li>
                   <li id="Monnum"><font style="color:#a9a9a9; font-size: 15px">销量</font>${LG.monnum }</li>
                </ul>
              </div>
              </div>
               </c:when>
               <c:otherwise></c:otherwise>
              </c:choose>
            </c:forEach>
          </div>
          <div class="hotright">
            <p style="text-align: right;"><a onclick="moreFruit()" style="cursor: pointer;">更多>></a></p>
          </div>
       </div>
    </div>
      <!-- 水果结束 -->
      
      <!-- 肉类开始 -->
       <div class="first">
       <div class="content">
          <div class="foodTop">
             <h3>肉类推荐</h3>
             <hr style="border:2px solid #0f0;">
          </div>
          <div class="foodItems">
               <c:forEach items="${lg }" var="LG">
                 <c:choose >
                  <c:when test="${LG.type=='肉类' }">
                 
               <div class="foodHot">
                <div class="foodHotTop">
                <a href="javascript:findGoodsById('${LG.id }','${LG.state }')"><img  alt="" src="${LG.picurl }"></a>
              </div>
              <div class="foodHotCenter">
                <ul><li><font style="color:#000;font-size: 15px;">${LG.status }</font></li></ul>
              </div>
              <div class="foodHotBottom">
                 <ul>
                   <li>￥${LG.price }</li>
                   <li id="Monnum"><font style="color:#a9a9a9; font-size: 15px">销量</font>${LG.monnum }</li>
                </ul>
              </div>
              </div>
               </c:when>
               <c:otherwise></c:otherwise>
              </c:choose>
            </c:forEach>
          </div>
          <div class="hotright">
            <p style="text-align: right;"><a onclick="moreMeat()" style="cursor: pointer;">更多>></a></p>
          </div>
       </div>
    </div>
      <!-- 肉类结束 -->
      <!--干货开始 -->
       <div class="first">
       <div class="content">
          <div class="foodTop">
             <h3>干货推荐</h3>
             <hr style="border:2px solid #0f0;">
          </div>
          <div class="foodItems">
               <c:forEach items="${lg }" var="LG">
                 <c:choose >
                  <c:when test="${LG.type=='干货' }">
                 
               <div class="foodHot">
                <div class="foodHotTop">
                 <a href="javascript:findGoodsById('${LG.id }','${LG.state }')"><img  alt="" src="${LG.picurl }"></a>
              </div>
              <div class="foodHotCenter">
                <ul><li><font style="color:#000;font-size: 15px;">${LG.status }</font></li></ul>
              </div>
              <div class="foodHotBottom">
                 <ul>
                   <li>￥${LG.price }</li>
                   <li id="Monnum"><font style="color:#a9a9a9; font-size: 15px">销量</font>${LG.monnum }</li>
                </ul>
              </div>
              </div>
               </c:when>
               <c:otherwise></c:otherwise>
              </c:choose>
            </c:forEach>
          </div>
          <div class="hotright">
            <p style="text-align: right;"><a onclick="moreDryCargo()" style="cursor: pointer;">更多>></a></p>
          </div>
       </div>
    </div>
      <!-- 干货结束 -->
    </div>
    <!-- 推荐结束 -->
    
    <!-- 公告 -->
      <div class="content" style="height:100px;background:#c0dbbb;margin-bottom: 10px;position: relative;">
      <c:forEach items="${ln }" var="ln" begin="0" end="4">
       <div class="noticeBoard" >
         <h4 style="text-align: center;">${ln.title }</h4>
         <div style="height:62px">
           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${ln.content }
         </div>
         <h6 style="text-align: right;">${ln.time }</h6>
       </div>
       </c:forEach>
      </div>
    <!-- 公告结束 -->
    <div style="width:100%;background:#22ac38;height:40px">
     <div class="bbt">
        <ul >
         <li>云南特产网欢迎你的到来</li>
         <li>入驻平台</li>
         <li>联系平台：15198757664</li>
        </ul>
      </div>
    </div>
 
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.3.1.js" charset="utf-8"></script>
<script type="text/javascript"  src="${pageContext.request.contextPath }/js/index.js" charset="utf-8"></script>
<script type="text/javascript">
  function moreFood(){
	   location.href="${pageContext.request.contextPath }/GoodsServlet?action=findMoreFood";
   }
   function moreHandicraft(){
	   location.href="${pageContext.request.contextPath }/GoodsServlet?action=findMoreHandicraft";
   }
   function moreFruit(){
	   location.href="${pageContext.request.contextPath }/GoodsServlet?action=findMoreFruit";
   }
   function moreMeat(){
	   location.href="${pageContext.request.contextPath }/GoodsServlet?action=findMoreMeat";
   }
   function moreDryCargo(){
	   location.href="${pageContext.request.contextPath }/GoodsServlet?action=findMoreDryCargo";
   } 
   
   var notice=$(".noticeBoard");
   var current=0;//代表将要消失的公告
   var next=current+1;//代表将要出现的公告
   var Timer=setInterval(moving,5000);
   
   function moving(){
	   notice.eq(current).fadeOut(200);
	   notice.eq(next).fadeIn(200);
	   current=next;
	   next++;
	   if(next>4){
		   next=0;
	   }
   }
    //鼠标移入轮播停止
    $(".noticeBoard").mouseenter(function(){
    	clearInterval(Timer);
    });
    $(".noticeBoard").mouseleave(function(){
    	Timer=setInterval(moving,5000);
    });
 </script>    
</body>
</html>