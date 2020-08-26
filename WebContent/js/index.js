 $(window).scroll(function(){
   	 var height=$(this).scrollTop();
   	 if(height>137){
   		 $(".menu").css({
   			 position:"fixed",
   			 top:0,
   			 zIndex:1,
   			 width:"100%"
   		 });
   	 }else{
   		 $(".menu").css({
   			 position:"static"
   		 });
   	 }
    })
  //  $("css的所有选择器")
//	eq(对应元素的下标);
//	fadeOut(毫秒)淡出消失
//	$(".box ul li").eq(0).fadeOut(400);
//	$(".box ul li").eq(1).fadeIn(400);//出现

    var lis=$(".lbt ul li");
    var currentIndex =0;//代表要消失的那一张
    var nextIndex = currentIndex+1;//要出现的那一张
    var timer = setInterval(move,3000);
    var is = $(".circle i");
    var lies=$(".lbt_right li");
    	/*lis.eq(currentIndex).fadeOut(400);
    	lis.eq(nextIndex).fadeIn(400);
    	currentIndex=nextIndex;
    	nextIndex++;
    	if(nextIndex>4){
    		nextIndex=0;
    	}
    },2000);*/
//	1.鼠标进入时轮播停止
    $(".lbt").mouseenter(function(){
    	clearInterval(timer);
    });
    
//  2.鼠标离开时，轮播继续
    $(".lbt").mouseleave(function(){
    	timer = setInterval(move,2000);
    });
    //1.鼠标进入时轮播停止
    $(".lbt_right ul li").mouseenter(function(){
    	clearInterval(timer);
    });
    
//  2.鼠标离开时，轮播继续
    $(".lbt_right ul li").mouseleave(function(){
    	timer = setInterval(move,2000);
    });
   function move(){
   	    lis.eq(currentIndex).fadeOut(400);
    	lis.eq(nextIndex).fadeIn(400);
    	is.eq(currentIndex).removeClass("current");
    	is.eq(nextIndex).addClass("current");
    	lies.eq(currentIndex).removeClass("current1");
    	lies.eq(nextIndex).addClass("current1");
    	currentIndex=nextIndex;
    	nextIndex++;
    	if(nextIndex>9){
    		nextIndex=0;
    	}
   }
// 3.左右按钮
   $(".right").click(function(){
   	  move();
   })
   $(".btn").first().click(function(){
   	 nextIndex=currentIndex-1;
   	 if(nextIndex<0){
   	 	nextIndex=9;
   	 }
   	 move();
   })
// 4.小圆点上鼠标移入图片切换
   is.mouseenter(function(){
   	  var index= $(this).index();
   	  if(index===currentIndex){
   	  /*	"55"==55 true
   	  	"55"===55 false*/
   	  	return;
   	  }
   	  nextIndex=index;
   	  move();
   }) 
   lies.mouseenter(function(){
   	  var index= $(this).index();
   	  if(index===currentIndex){
   	  /*	"55"==55 true
   	  	"55"===55 false*/
   	  	return;
   	  }
   	  nextIndex=index;
   	  move();
   }) 



document.getElementById('list').onmouseover = function (e) {
    	if (!e) e = window.event;
    	var reltg = e.relatedTarget ? e.relatedTarget : e.fromElement;
    	while (reltg && reltg != this) reltg = reltg.parentNode;
    	if (reltg != this) {
    	// 这里可以编写 onmouseenter 事件的处理代码
    			  var list=document.getElementById("list");
    			  list.style.background="rgba(0,0,0,.2)"
    			   var category=document.getElementById("category");
    			   category.style.display="block";
    			   var maincenter=document.getElementById("mainCenter");
    			   maincenter.style.display="none";
    	 
    	}
} 
   document.getElementById('list').onmouseout = function (e) {
    	if (!e) e = window.event;
    	var reltg = e.relatedTarget ? e.relatedTarget : e.toElement;
    	while (reltg && reltg != this) reltg = reltg.parentNode;
    	if (reltg != this) {
    	// 这里可以编写 onmouseenter 事件的处理代码
    			  var list=document.getElementById("list");
    			  list.style.background=""
    			   var category=document.getElementById("category");
    			   category.style.display="none";
    			   var maincenter=document.getElementById("mainCenter");
    			   maincenter.style.display="block";
    	 
    	}
    	}
   document.getElementById('category').onmouseout = function (e) {
    	if (!e) e = window.event;
    	var reltg = e.relatedTarget ? e.relatedTarget : e.toElement;
    	while (reltg && reltg != this) reltg = reltg.parentNode;
    	if (reltg != this) {
    	// 这里可以编写 onmouseleave 事件的处理代码
    		var category=document.getElementById("category");
    		   category.style.display="none";
    		   var list=document.getElementById("list");
    		   list.style.background="";
    		   var maincenter=document.getElementById("mainCenter");
    		   maincenter.style.display="block";
    	}
    	}
   document.getElementById('category').onmouseover = function (e) {
   	if (!e) e = window.event;
   	var reltg = e.relatedTarget ? e.relatedTarget : e.toElement;
   	while (reltg && reltg != this) reltg = reltg.parentNode;
   	if (reltg != this) {
   	// 这里可以编写 onmouseleave 事件的处理代码
   		var category=document.getElementById("category");
   		   category.style.display="block";
   		   var list=document.getElementById("list");
   		   list.style.background="rgba(0,0,0,.2)";
   		   var maincenter=document.getElementById("mainCenter");
   		   maincenter.style.display="none";
   	}
   	}
    // 地方特产结束
   
   document.getElementById('list1').onmouseover = function (e) {
   	if (!e) e = window.event;
   	var reltg = e.relatedTarget ? e.relatedTarget : e.fromElement;
   	while (reltg && reltg != this) reltg = reltg.parentNode;
   	if (reltg != this) {
   	// 这里可以编写 onmouseenter 事件的处理代码
   			  var list=document.getElementById("list1");
   			  list.style.background="rgba(0,0,0,.2)"
   			   var category=document.getElementById("food");
   			   category.style.display="block";
   			   var maincenter=document.getElementById("mainCenter");
   			   maincenter.style.display="none";
   	 
   	}
   	} 
  document.getElementById('list1').onmouseout = function (e) {
   	if (!e) e = window.event;
   	var reltg = e.relatedTarget ? e.relatedTarget : e.toElement;
   	while (reltg && reltg != this) reltg = reltg.parentNode;
   	if (reltg != this) {
   	// 这里可以编写 onmouseenter 事件的处理代码
   			  var list=document.getElementById("list1");
   			  list.style.background=""
   			   var category=document.getElementById("food");
   			   category.style.display="none";
   			   var maincenter=document.getElementById("mainCenter");
   			   maincenter.style.display="block";
   	 
   	}
   	}
  document.getElementById('food').onmouseout = function (e) {
   	if (!e) e = window.event;
   	var reltg = e.relatedTarget ? e.relatedTarget : e.toElement;
   	while (reltg && reltg != this) reltg = reltg.parentNode;
   	if (reltg != this) {
   	// 这里可以编写 onmouseleave 事件的处理代码
   		var category=document.getElementById("food");
   		   category.style.display="none";
   		   var list=document.getElementById("list1");
   		   list.style.background="";
   		   var maincenter=document.getElementById("mainCenter");
   		   maincenter.style.display="block";
   	}
   	}
  document.getElementById('food').onmouseover = function (e) {
  	if (!e) e = window.event;
  	var reltg = e.relatedTarget ? e.relatedTarget : e.toElement;
  	while (reltg && reltg != this) reltg = reltg.parentNode;
  	if (reltg != this) {
  	// 这里可以编写 onmouseleave 事件的处理代码
  		var category=document.getElementById("food");
  		   category.style.display="block";
  		   var list=document.getElementById("list1");
  		   list.style.background="rgba(0,0,0,.2)";
  		   var maincenter=document.getElementById("mainCenter");
  		   maincenter.style.display="none";
  	}
  	}
  
   //手工艺品结束

  document.getElementById('list2').onmouseover = function (e) {
  	if (!e) e = window.event;
  	var reltg = e.relatedTarget ? e.relatedTarget : e.fromElement;
  	while (reltg && reltg != this) reltg = reltg.parentNode;
  	if (reltg != this) {
  	// 这里可以编写 onmouseenter 事件的处理代码
  			  var list=document.getElementById("list2");
  			  list.style.background="rgba(0,0,0,.2)"
  			   var category=document.getElementById("handiwork");
  			   category.style.display="block";
  			   var maincenter=document.getElementById("mainCenter");
  			   maincenter.style.display="none";
  	 
  	}
  	} 
 document.getElementById('list2').onmouseout = function (e) {
  	if (!e) e = window.event;
  	var reltg = e.relatedTarget ? e.relatedTarget : e.fromElement;
  	while (reltg && reltg != this) reltg = reltg.parentNode;
  	if (reltg != this) {
  	// 这里可以编写 onmouseenter 事件的处理代码
  			  var list=document.getElementById("list2");
  			  list.style.background=""
  			   var category=document.getElementById("handiwork");
  			   category.style.display="none";
  			   var maincenter=document.getElementById("mainCenter");
  			   maincenter.style.display="block";
  	 
  	}
  	}
 document.getElementById('handiwork').onmouseout = function (e) {
  	if (!e) e = window.event;
  	var reltg = e.relatedTarget ? e.relatedTarget : e.toElement;
  	while (reltg && reltg != this) reltg = reltg.parentNode;
  	if (reltg != this) {
  	// 这里可以编写 onmouseleave 事件的处理代码
  		var category=document.getElementById("handiwork");
  		   category.style.display="none";
  		   var list=document.getElementById("list2");
  		   list.style.background="";
  		   var maincenter=document.getElementById("mainCenter");
  		   maincenter.style.display="block";
  	}
  	}
 document.getElementById('handiwork').onmouseover = function (e) {
 	if (!e) e = window.event;
 	var reltg = e.relatedTarget ? e.relatedTarget : e.toElement;
 	while (reltg && reltg != this) reltg = reltg.parentNode;
 	if (reltg != this) {
 	// 这里可以编写 onmouseleave 事件的处理代码
 		var category=document.getElementById("handiwork");
 		   category.style.display="block";
 		   var list=document.getElementById("list2");
 		   list.style.background="rgba(0,0,0,.2)";
 		   var maincenter=document.getElementById("mainCenter");
 		   maincenter.style.display="none";
 	}
 	}
   
    //水果开始
 document.getElementById('list3').onmouseover = function (e) {
	  	if (!e) e = window.event;
	  	var reltg = e.relatedTarget ? e.relatedTarget : e.fromElement;
	  	while (reltg && reltg != this) reltg = reltg.parentNode;
	  	if (reltg != this) {
	  	// 这里可以编写 onmouseenter 事件的处理代码
	  			  var list=document.getElementById("list3");
	  			  list.style.background="rgba(0,0,0,.2)"
	  			   var category=document.getElementById("fruit");
	  			   category.style.display="block";
	  			   var maincenter=document.getElementById("mainCenter");
	  			   maincenter.style.display="none";
	  	 
	  	}
	  	} 
	 document.getElementById('list3').onmouseout = function (e) {
	  	if (!e) e = window.event;
	  	var reltg = e.relatedTarget ? e.relatedTarget : e.fromElement;
	  	while (reltg && reltg != this) reltg = reltg.parentNode;
	  	if (reltg != this) {
	  	// 这里可以编写 onmouseenter 事件的处理代码
	  			  var list=document.getElementById("list3");
	  			  list.style.background=""
	  			   var category=document.getElementById("fruit");
	  			   category.style.display="none";
	  			   var maincenter=document.getElementById("mainCenter");
	  			   maincenter.style.display="block";
	  	 
	  	}
	  	}
	 document.getElementById('fruit').onmouseout = function (e) {
	  	if (!e) e = window.event;
	  	var reltg = e.relatedTarget ? e.relatedTarget : e.toElement;
	  	while (reltg && reltg != this) reltg = reltg.parentNode;
	  	if (reltg != this) {
	  	// 这里可以编写 onmouseleave 事件的处理代码
	  		var category=document.getElementById("fruit");
	  		   category.style.display="none";
	  		   var list=document.getElementById("list3");
	  		   list.style.background="";
	  		   var maincenter=document.getElementById("mainCenter");
	  		   maincenter.style.display="block";
	  	}
	  	}
	 document.getElementById('fruit').onmouseover = function (e) {
	 	if (!e) e = window.event;
	 	var reltg = e.relatedTarget ? e.relatedTarget : e.toElement;
	 	while (reltg && reltg != this) reltg = reltg.parentNode;
	 	if (reltg != this) {
	 	// 这里可以编写 onmouseleave 事件的处理代码
	 		var category=document.getElementById("fruit");
	 		   category.style.display="block";
	 		   var list=document.getElementById("list3");
	 		   list.style.background="rgba(0,0,0,.2)";
	 		   var maincenter=document.getElementById("mainCenter");
	 		   maincenter.style.display="none";
	 	}
	 	}
	   
   //水果结束
	 
	 //肉类开始
	 document.getElementById('list4').onmouseover = function (e) {
		  	if (!e) e = window.event;
		  	var reltg = e.relatedTarget ? e.relatedTarget : e.fromElement;
		  	while (reltg && reltg != this) reltg = reltg.parentNode;
		  	if (reltg != this) {
		  	// 这里可以编写 onmouseenter 事件的处理代码
		  			  var list=document.getElementById("list4");
		  			  list.style.background="rgba(0,0,0,.2)"
		  			   var category=document.getElementById("meat");
		  			   category.style.display="block";
		  			   var maincenter=document.getElementById("mainCenter");
		  			   maincenter.style.display="none";
		  	 
		  	}
		  	} 
		 document.getElementById('list4').onmouseout = function (e) {
		  	if (!e) e = window.event;
		  	var reltg = e.relatedTarget ? e.relatedTarget : e.fromElement;
		  	while (reltg && reltg != this) reltg = reltg.parentNode;
		  	if (reltg != this) {
		  	// 这里可以编写 onmouseenter 事件的处理代码
		  			  var list=document.getElementById("list4");
		  			  list.style.background=""
		  			   var category=document.getElementById("meat");
		  			   category.style.display="none";
		  			   var maincenter=document.getElementById("mainCenter");
		  			   maincenter.style.display="block";
		  	 
		  	}
		  	}
		 document.getElementById('meat').onmouseout = function (e) {
		  	if (!e) e = window.event;
		  	var reltg = e.relatedTarget ? e.relatedTarget : e.toElement;
		  	while (reltg && reltg != this) reltg = reltg.parentNode;
		  	if (reltg != this) {
		  	// 这里可以编写 onmouseleave 事件的处理代码
		  		var category=document.getElementById("meat");
		  		   category.style.display="none";
		  		   var list=document.getElementById("list4");
		  		   list.style.background="";
		  		   var maincenter=document.getElementById("mainCenter");
		  		   maincenter.style.display="block";
		  	}
		  	}
		 document.getElementById('meat').onmouseover = function (e) {
		 	if (!e) e = window.event;
		 	var reltg = e.relatedTarget ? e.relatedTarget : e.toElement;
		 	while (reltg && reltg != this) reltg = reltg.parentNode;
		 	if (reltg != this) {
		 	// 这里可以编写 onmouseleave 事件的处理代码
		 		var category=document.getElementById("meat");
		 		   category.style.display="block";
		 		   var list=document.getElementById("list4");
		 		   list.style.background="rgba(0,0,0,.2)";
		 		   var maincenter=document.getElementById("mainCenter");
		 		   maincenter.style.display="none";
		 	}
		 	}
		   
	// 肉类结束
		 
   //干货开始
		 document.getElementById('list5').onmouseover = function (e) {
			  	if (!e) e = window.event;
			  	var reltg = e.relatedTarget ? e.relatedTarget : e.fromElement;
			  	while (reltg && reltg != this) reltg = reltg.parentNode;
			  	if (reltg != this) {
			  	// 这里可以编写 onmouseenter 事件的处理代码
			  			  var list=document.getElementById("list5");
			  			  list.style.background="rgba(0,0,0,.2)"
			  			   var category=document.getElementById("dryCargo");
			  			   category.style.display="block";
			  			   var maincenter=document.getElementById("mainCenter");
			  			   maincenter.style.display="none";
			  	 
			  	}
			  	} 
			 document.getElementById('list5').onmouseout = function (e) {
			  	if (!e) e = window.event;
			  	var reltg = e.relatedTarget ? e.relatedTarget : e.fromElement;
			  	while (reltg && reltg != this) reltg = reltg.parentNode;
			  	if (reltg != this) {
			  	// 这里可以编写 onmouseenter 事件的处理代码
			  			  var list=document.getElementById("list5");
			  			  list.style.background=""
			  			   var category=document.getElementById("dryCargo");
			  			   category.style.display="none";
			  			   var maincenter=document.getElementById("mainCenter");
			  			   maincenter.style.display="block";
			  	 
			  	}
			  	}
			 document.getElementById('dryCargo').onmouseout = function (e) {
			  	if (!e) e = window.event;
			  	var reltg = e.relatedTarget ? e.relatedTarget : e.toElement;
			  	while (reltg && reltg != this) reltg = reltg.parentNode;
			  	if (reltg != this) {
			  	// 这里可以编写 onmouseleave 事件的处理代码
			  		var category=document.getElementById("dryCargo");
			  		   category.style.display="none";
			  		   var list=document.getElementById("list5");
			  		   list.style.background="";
			  		   var maincenter=document.getElementById("mainCenter");
			  		   maincenter.style.display="block";
			  	}
			  	}
			 document.getElementById('dryCargo').onmouseover = function (e) {
			 	if (!e) e = window.event;
			 	var reltg = e.relatedTarget ? e.relatedTarget : e.toElement;
			 	while (reltg && reltg != this) reltg = reltg.parentNode;
			 	if (reltg != this) {
			 	// 这里可以编写 onmouseleave 事件的处理代码
			 		var category=document.getElementById("dryCargo");
			 		   category.style.display="block";
			 		   var list=document.getElementById("list5");
			 		   list.style.background="rgba(0,0,0,.2)";
			 		   var maincenter=document.getElementById("mainCenter");
			 		   maincenter.style.display="none";
			 	}
			 	}
			   	 
   //干货结束
			 
  //其他开始
			 document.getElementById('list6').onmouseover = function (e) {
				  	if (!e) e = window.event;
				  	var reltg = e.relatedTarget ? e.relatedTarget : e.fromElement;
				  	while (reltg && reltg != this) reltg = reltg.parentNode;
				  	if (reltg != this) {
				  	// 这里可以编写 onmouseenter 事件的处理代码
				  			  var list=document.getElementById("list6");
				  			  list.style.background="rgba(0,0,0,.2)"
				  			   var category=document.getElementById("other");
				  			   category.style.display="block";
				  			   var maincenter=document.getElementById("mainCenter");
				  			   maincenter.style.display="none";
				  	 
				  	}
				  	} 
				 document.getElementById('list6').onmouseout = function (e) {
				  	if (!e) e = window.event;
				  	var reltg = e.relatedTarget ? e.relatedTarget : e.fromElement;
				  	while (reltg && reltg != this) reltg = reltg.parentNode;
				  	if (reltg != this) {
				  	// 这里可以编写 onmouseenter 事件的处理代码
				  			  var list=document.getElementById("list6");
				  			  list.style.background=""
				  			   var category=document.getElementById("other");
				  			   category.style.display="none";
				  			   var maincenter=document.getElementById("mainCenter");
				  			   maincenter.style.display="block";
				  	 
				  	}
				  	}
				 document.getElementById('other').onmouseout = function (e) {
				  	if (!e) e = window.event;
				  	var reltg = e.relatedTarget ? e.relatedTarget : e.toElement;
				  	while (reltg && reltg != this) reltg = reltg.parentNode;
				  	if (reltg != this) {
				  	// 这里可以编写 onmouseleave 事件的处理代码
				  		var category=document.getElementById("other");
				  		   category.style.display="none";
				  		   var list=document.getElementById("list6");
				  		   list.style.background="";
				  		   var maincenter=document.getElementById("mainCenter");
				  		   maincenter.style.display="block";
				  	}
				  	}
				 document.getElementById('other').onmouseover = function (e) {
				 	if (!e) e = window.event;
				 	var reltg = e.relatedTarget ? e.relatedTarget : e.toElement;
				 	while (reltg && reltg != this) reltg = reltg.parentNode;
				 	if (reltg != this) {
				 	// 这里可以编写 onmouseleave 事件的处理代码
				 		var category=document.getElementById("other");
				 		   category.style.display="block";
				 		   var list=document.getElementById("list6");
				 		   list.style.background="rgba(0,0,0,.2)";
				 		   var maincenter=document.getElementById("mainCenter");
				 		   maincenter.style.display="none";
				 	}
				 	}
				   	 
  //其他结束
function findGoodsById(id,state){
	location.href="./GoodsServlet?action=findGoodsById&id="+id+"&state="+state;
}	