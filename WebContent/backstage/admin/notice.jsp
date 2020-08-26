<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/backstage/css/main.css" type="text/css" />
<title>公告管理</title>
<style type="text/css">
*{margin:0;padding:0}
table{width:900px;table-layout:fixed}
.th th{border:1px solid #e6e6e6;text-align:center;}
td{text-align:center;}
.td td{border:1px solid #f0f0f0;height:38px;}
.td:nth-child(odd){background-color:#e6e6e6;border:0px;height:30px;}
.td:nth-child(even){background-color:#eee9e9;border:0px;height:30px;}
.th th:nth-child(1) {width:198px;}
.th th:nth-child(2) {width:428px;}
.th th:nth-child(3) {width:148px}
.th th:nth-child(4) {width:58px}
.th th:nth-child(5) {width:58px} 
</style>
</head>
<body>
      <!--   云特产商家后台head start -->
  <%@include file="head.jsp" %>
  
  <div class="main" >
     <div class="left">
       <!--   云特产商家后台left start -->
       <%@include file="left.jsp" %>
     </div>
     
     <div class="right" style="background:#f0f0f0">
         <p style="text-align: center;margin-top:10px;font-size: 20px">公告管理</p><hr>
         
         <!-- 公告列表开始 -->
         <div id="notice" style="width:900px;height:430px;margin: 10px auto;display:block">
           <table  cellpadding="0" cellspacing="0" >
             <tr class="th" style="background-color:#c0dbbb;height:30px">
              <th>标题</th>
              <th>内容</th>
              <th>发布时间</th>
              <th>操作</th>
              <th>删除</th>
             </tr>
            <c:if test="${empty ln }">
              <p style="color:#a6a6a6;margin:5px auto;width:300px;float:center;text-align: center">还没有发布过公告</p>
            </c:if>
          
            <c:if test="${not empty ln }">      
             <c:forEach items="${ln }" var="ln" begin="0" end="9">
              <tr class="td"  style="border:0px ">
              <td>${ln.title }</td>
              <td style="overflow: hidden;text-overflow: ellipsis;white-space: nowrap;">${ln.content }</td>
              <td>${ln.time }</td>
              <td><a onclick="findNoticeById(${ln.id})" style="cursor: pointer;text-decoration: underline;color:blue">编辑</a></td>
              <td><a onclick="delNotice(${ln.id})" style="color:red;cursor: pointer">X</a></td>
              </tr>
              </c:forEach>
            </c:if>   
            <tr >
              <td colspan="5" ><a onclick="addNotice()" style="border-radius:5px;background:#c0dbbb;display:block;width:70px;height:32px;float:right;line-height: 32px;cursor: pointer">发布公告</a></td>
            </tr>
           </table>
            </div>
         
         <!-- 公告列表结束 -->
         <!-- 编辑公告开始 -->
         <div id="edit" style="display:none">
            <form action="${pageContext.request.contextPath }/NoticeServlet?action=addNotice" method="post">
                                   请输入公告标题：<br><input type="text" name="title" style="width:310px;height:25px" ><br>
                                   公告内容：<br><textarea  name="content" rows="5" cols="35" wrap="physical"></textarea><br>
             <input type="submit"  value="提交" />
            </form>
         </div>
         <!-- 编辑公告结束 -->
     </div>
  </div>
  
  <!--   云特产商家后台bottom start -->
 <%@include file="bottom.jsp" %> 
 
 <script type="text/javascript" src="js/jquery-3.3.1.js" charset="utf-8"></script>
 <script type="text/javascript">
   function addNotice(){
	   var notice=document.getElementById("notice");
	   var edit=document.getElementById("edit");
	   notice.style.display="none";
	   edit.style.display="block"
   }
   function findNoticeById(id){
	   //alert(id);
	  location.href="${pageContext.request.contextPath }/NoticeServlet?action=findNoticeById&id="+id;
   }
   function delNotice(id){
	   if(confirm("确认删除吗？")){
	   location.href="${pageContext.request.contextPath }/NoticeServlet?action=delNoticeById&id="+id;
   }
   }
 </script>
</body>
</html>