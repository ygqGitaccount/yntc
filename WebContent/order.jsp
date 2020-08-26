<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/index.css" type="text/css" >
<title>提交订单</title>
</head>
<style>
*{
 margin:0;
 padding:0;
}
.th{
 width:200px;
 background-color:#c0dbbb;
}
.item  td{
  text-align: center;
}
</style>


<script type="text/javascript" src="js/jquery-3.3.1.js" charset="utf-8"></script>
<script type="text/javascript">
$(function(){
	function totalPrice(){
		var count=0;
		 for(var i=0;i<$(".count").length;i++){
			var counted=$(".count").eq(i).text();
			counted=Number(counted);
			count+=counted;
			
		}
		$(".totalPrice").text(count);
	}
	totalPrice();
	 $(".submit").click(function(){
		 var states="";
		 var cids="";
		 var goodsids="";
		 var numbers="";
		 $(".cids:checked").each(function(){
			 cids+=$(this).val()+",";
			 //alert(cids);
			 });
		 $(".state:checked").each(function(){
			 states+=$(this).val()+",";
			 });
		 $(".goodsid:checked").each(function(){
			 goodsids+=$(this).val()+",";
		 });
		 $(".number:checked").each(function(){
			 numbers+=$(this).val()+",";
		 });
		 //alert(numbers);
		    //alert(goodsids);
			//alert(states); 
		var remark=$(".remark").val();	 
		//alert(remark);
	    var totalprice=$(".totalPrice").text();
	       totalprice=Number(totalprice);
	        //alert(totalprice);
	         var balance=$(".balance").text();
             balance=Number(balance);
            //alert(balance);
            if(totalprice>balance){
            	alert("余额不足，请充值");
            	return;
            }else{
		     cids=cids.substring(0,cids.length-1);
		     states=states.substring(0,states.length-1);
		     goodsids=goodsids.substring(0,goodsids.length-1);
		     numbers=numbers.substring(0,numbers.length-1);
		     //alert(numbers);
		   // alert(cids);
           
		      if(cids!=""){
		    	 location.href="${pageContext.request.contextPath }/OrderServlet?action=createOrder&cids="+cids+"&remark="+remark+"&totalprice="+totalprice+"&states="+states+"&goodsids="+goodsids+"&numbers="+numbers;
		      }
            }
	   });
})
  




</script>
<body >
    <%@include file="head.jsp" %>
       <p style="font-size: 30px">提交订单</p>
       <hr>
      <div>
         <div>
           <form action="" method="post">
            <table>
              <tr>
               <td style="text-align: right">收件人姓名：</td>
               <td><input class="info" name="name" type="text" value="${user.name} " readonly="readonly"/></td>
              </tr>
              <tr>
               <td style="text-align: right">收件地址：</td>
               <td><input class="info" name="address" type="text" value="${user.region }${user.address}"  readonly="readonly"/></td>
              </tr>
              <tr>
               <td style="text-align: right">联系电话：</td>
               <td><input class="info" name="telphone" type="text" value="${user.telphone} "  readonly="readonly"/></td>
              </tr>
               <tr>
               <td style="text-align: right">备注：</td>
               <td><input class="remark" id="remark" name="remark" type="text" value=""/></td>
               <td style="display:none;" class="balance">${user.balance }</td>
              </tr>
            </table>
            <table >
               <tr>
                <th class="th" style="display:none">cid</th> 
                <th class="th" style="display:none">goods.state</th> 
                <th class="th"  style="display:none">cart.goodsid</th>
                <th class="th"  style="display:none">cart.number</th>
                 <th class="th">商品名称</th>
                 <th class="th">单价</th>
                 <th class="th">数量</th>
                 <th class="th">总计</th>
               </tr>
               <c:forEach items="${lc }" var="orderLc">
               <c:if test="${orderLc.state==1 }">
                <tr class="item"> 
                  <td style="display:none" ><input type="checkbox" checked="checked" class="cids" value="${orderLc.cid }" /></td> 
                  <td style="display:none" ><input type="checkbox" checked="checked" class="state" value="${orderLc.storeid }" /></td> 
                  <td style="display:none" ><input type="checkbox" checked="checked" class="goodsid" value="${orderLc.goodsid }" /></td>
                  <td style="display:none" ><input type="checkbox" checked="checked" class="number" value="${orderLc.number }" /></td>
                  <td>${orderLc.name }</td>
                  <td>${orderLc.price }元</td>
                  <td>${orderLc.number }</td>
                  <td class="count">${orderLc.price*orderLc.number }</td>
                </tr>
                </c:if>
               </c:forEach>
               <tr><td colspan="3" style="text-align: right;">订单总计：</td><td class="totalPrice"  style="text-align:left;"></td></tr>
            </table>
            <hr>
            <div>
            <a type="button" href="javascript:history.go(-1)" style="border-radius:2px;float:left;width:40px;height:20px;background:#e6e6e6;margin:3px 30px;line-height: 20px;text-align: center;">取消</a>
            <button type="button" class="submit" style="float:left" >提交订单</button>
            </div>
           </form>
         </div>
      </div>
    
</body>
</html>