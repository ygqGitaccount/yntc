<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/backstage/css/main.css" type="text/css" />
<title>销售分析</title>
<style type="text/css">
.item{text-align: center}
.goodsname{width:80px;}
.year{width:60px}
.button{width:40px;}
.button2{width:70px;margin-left:150px}
.statisticalChart{width:95%;height:506px;}
.pie{width:95%;height:490px;}
</style>

<script type="text/javascript" src="js/jquery-3.3.1.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/echarts-all.js" ></script>
<script type="text/javascript">
function show(){
	 var myChartPie = echarts.init(document.getElementById('pie'));
	var message=prompt("请输入年份"); 
	if(message==""){
		alert("年份不能为空");
		return;
	}else if(message==null){
		return;
	}else{
		 var pie=document.getElementById("pie");
		 var bar=document.getElementById("statisticalChart");
		 pie.style.display="block";
		 bar.style.display="none";
		
	//option开始	 
	  var option ={
	     title : {
	    	text:"按类型销量统计图",
	    	x:"center"
	     },
	     tooltip : {
	         trigger: 'item',
	         formatter: "{a} <br/>{b} : {c} ({d}%)"
	     },
	     legend: {
	         orient : 'vertical',
	         x : 'left',
	        data:[]
	     },
	     toolbox : {
	    	 show:true,
	    	 dataView : {show: true, readOnly: true},

	     },
	     series : []
	  }
	//option结束
	}
	
	myChartPie.showLoading();//数据加载完之前显示一段简单的loading动画；
	
	var datas=new Array();
	var type=[];
	var value=[];
	
	//post开始
    $.post(
    	  "${pageContext.request.contextPath }/OrderServlet",
          {"action":"chartPie","yyy":message},
          function(data){
        	  console.log(data);
        	 if(data != null && data.length > 0){
        		 for(var i=0;i<data.length;i++){
        			value.push(data[i].sum);
        			type.push(data[i].type);
        		 }
        	 //alert(value);
        	 //alert(type);
        	 for(var j=0;j<value.length;j++){
        		  var str = new Object();
        		  str.name=type[j];
        		  str.value=value[j]; 
        		  datas.push(str);
        	 }
        	//console.log(datas);
        	myChartPie.hideLoading();	//隐藏加载动画 
        	 
        	myChartPie.setOption({
        		title : {
        	    	text:"按类型销量统计图",
        	    	x:"center"          //x代表水平安放位置，值可以为left center right或者{坐标单位px}
        	     },
        	     tooltip : {
        	         trigger: 'item',  //触发类型 可选item axis
        	         formatter: "{a} <br/>{b} : {c} ({d}%)"  //内容格式器
        	     },
        	     legend: {
        	         orient : 'vertical',//布局方式，默认水平，可选为 horizontal vertical
        	         x : 'left',
        	        data : type
        	     },
        	     toolbox : {
        	    	 show:true,
        	    	 feature : {
   	                  dataView : {show: true, readOnly: true},
   	                }

        	     },
        	     calculable : true,//拖拽重计算
        	     series : [
        	    	  {   
        	    		  name:'销售统计',
        	              type:'pie',
        	              radius : '50%', //半径
        	              center: ['50%', '50%'],  //圆心坐标
        	              data:datas
        	              
        	          }
        	     ]
        	});
          }else{
  			//返回数据为空时显示提示信息
  			alert("没有数据");
  			myChartPie.hideLoading();
  		}
        },
        "json"
    );
 //post结束  
}

 function query(){
	var myChart = echarts.init(document.getElementById('statisticalChart')); 
	var goodsname=$("#goodsname").val();
	//alert(goodsname);
	var year=$("#year").val();
	//alert(year);
	if(goodsname=="" || year==""){
		 alert("请输入信息");
		 return;
	}else{
	  var option = {
			title:{
				text:'销售统计'
			},
			tooltip: {
                show: true,
                //trigger:'axis'
            },
            legend: {
                data:[]
            },
            toolbox: {
                show : true,
                feature : {
                    magicType : {show: true, type: ['line', 'bar']},
                }
            },
            xAxis : [
                {
                    type : 'category',
                    data : []
                }
            ],
            yAxis : [
                {
                    type : 'value'
                }
            ],
            series : []
	 }
  }
	myChart.showLoading();//数据加载完之前显示一段简单的loading动画；
	
	var years=[];
	var months=[];
	var Numbers=[];
	var series=[];
	var locations=[];
	
	//post开始
	$.post(
      "${pageContext.request.contextPath }/OrderServlet",
		{"action":"orderChart","goodsname":goodsname,"year":year},
	  function(data){
			console.log(data);
		 //请求成功时执行该函数，data即为服务器返回的json对象
		if(data != null && data.length > 0 ){
		     for(var i=0;i<data.length;i++){
		    	if(locations.indexOf(data[i].location)<0){
		    	  locations.push(data[i].location);
			    }	
			 }
		     //alert(months);
		     for(var n=0;n<locations.length;n++){
		    	// var a="";
		    	 var a=[];
		    	 var b=[];
		    	 for(var k=0;k<data.length;k++){
		    		if(data[k].location == locations[n]){
		    		 if(b.indexOf(data[k].month)<0){
		    		  b.push(data[k].month);
		  		     }
		    		  a.push(data[k].countNumber);
		    	    }
		    	 }
		    	 //alert(b);
		    	 //alert(a);
		    	 var c=[0,0,0,0,0,0,0,0,0,0,0,0];
		    	  for(var d=0;d<b.length;d++){
		    		//c[b[d]-1]=a[d]; 
		    		c.splice(b[d]-1,1,a[d]);
		    	  }
		    	  //alert(c);
		    	 var item={
			    	 name:locations[n],
			    	 type:'bar',
			    	 itemStyle : { 
			    		  normal: {
			    		   label : {show: true},
			    		  /*  textStyle : {
	                            fontSize : '20',
	                            fontFamily : '微软雅黑',
	                            fontWeight : 'bold'
	                        } */
			    		 }
		    	     },
			    	 data:c
			    }
		    	 series.push(item); 
	    	  }
		    // console.log(series);
		   myChart.hideLoading();	//隐藏加载动画
		   
		   //set option开始
		   myChart.setOption({
			   title:{
					text:'销售数量统计'
				},
				tooltip: {
	                show: true,
	                //trigger:'axis'
	                //borderRadius : 2
	            },
	            legend: {
	                data:locations
	            },
	           toolbox: {
	                show : true,
	                feature : {
	                  dataView : {show: true, readOnly: true},
	                  magicType : {show: true, type: ['line', 'bar']},
	                }
	            }, 
			   xAxis : [
	                {
	                    type : 'category',
	                     data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
	                    //data : months
	                }
	            ],
	            yAxis : [
	                {
	                    type : 'value',
	                    boundaryGap:[0,0.1]
	                }
	            ], 
	            series : series
		   });
		   //set option结束
		   
		}else{
			//返回数据为空时显示提示信息
			alert("没有数据");
			myChart.hideLoading();
		}
	  },
	  "json"
	);
	//post结束
 };

</script>


</head>
<body>
   <%@include file="head.jsp" %>
  
  <div class="main" >
     <div class="left">
       <!--   云特产商家后台left start -->
       <%@include file="left.jsp" %>
     </div>
     <!-- 统计分析开始 -->
     <div class="right" style="overflow:hidden">
     
       <!-- 条件 -->
       <div class="item" id="condition">
         <form action="">
                        请输入商品名称：<input type="text" id="goodsname" class="goodsname" name="goodsname" />
                        请输入年份：<input type="text" id="year" class="year" name="year" required="required" />
         <button type="button" class="button" onclick="query()">查&nbsp;询</button>
         <button type="button" class="button2" onclick="show()">按类别</button>
         </form>
       </div>
        <hr>
        <!--条件 -->

       <div class="statisticalChart" id="statisticalChart"></div>
       <div class="pie" id="pie"></div>
     </div>
     <!-- 统计分析结束 -->
  </div>
     <%@include file="bottom.jsp" %> 
</body>
</html>