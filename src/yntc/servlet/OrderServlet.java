package yntc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.sun.jmx.snmp.Enumerated;

import net.sf.json.JSONArray;
import yntc.domain.Order;
import yntc.domain.PageBean;
import yntc.domain.Pie;
import yntc.domain.Bar;
import yntc.domain.User;
import yntc.service.GoodsService;
import yntc.service.OrderService;
import yntc.service.UserService;
import yntc.service.impl.GoodsServiceImpl;
import yntc.service.impl.OrderServiceImpl;
import yntc.service.impl.UserServiceImpl;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
		
		String action=request.getParameter("action");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String Oid =request.getParameter("oid");
		String Storeid =request.getParameter("storeid");
		String Count =request.getParameter("count");
		String Price  = request.getParameter("price");
		String Number = request.getParameter("number");
		String Goodsid = request.getParameter("gid");
		Integer goodsid =null;
		 Integer storeid=null;
		 Integer count=null;
		 Integer oid=null;
		 Integer price =null;
		 Integer number =null;
		 if(Storeid!=null && !"".equals(Storeid)) {
			 storeid=Integer.parseInt(Storeid);
		 }
		 if(Count!=null && !"".equals(Count)) {
			 count=Integer.parseInt(Count);
		 }
		 if(Oid!=null && !"".equals(Oid)) {
			 oid =Integer.parseInt(Oid);
		 }
		 if(Price!=null && !"".equals(Price)) {
			 price =Integer.parseInt(Price);
		 }
		 if(Number!=null && !"".equals(Number)) {
			 number =Integer.parseInt(Number);
		 }
		 if(Goodsid!=null && !"".equals(Goodsid)) {
			 goodsid =Integer.parseInt(Goodsid);
		 }
		 
		
		OrderService os = new OrderServiceImpl();
		GoodsService gs =new GoodsServiceImpl();
		UserService  us= new UserServiceImpl();
		if("createOrder".equals(action)) {
			String cids=request.getParameter("cids");
			//System.out.println(cids);
			String remark=request.getParameter("remark");
			//System.out.println(remark);
			String states=request.getParameter("states");
			String Totalprice=request.getParameter("totalprice");
			String goodsids=request.getParameter("goodsids");
			String numbers=request.getParameter("numbers");
			//System.out.println("00");
			//System.out.println(numbers);
			Integer totalprice=null;
			if(Totalprice!=null && !"".equals(Totalprice)) {
				totalprice=Integer.parseInt(Totalprice);
			}
			int i=os.addOrders(session,cids,remark,states);
			if(i>0) {
				gs.updateGoodsidsNum(goodsids, numbers);
				request.getRequestDispatcher("/CartServlet?action=updateCartGoods&cids="+cids+"&totalprice="+totalprice).forward(request,response);
				return;
			}else {
				response.getWriter().write("提交失败");
				response.setHeader("refresh", "1;url="+request.getContextPath()+"/order.jsp");
			}
			
		}else if("findOrderByState".equals(action)) {
			 try {
	    		  
	    		  PageBean<Order> pb= null;
					try {
						//meinvs = ms.findAll();
						int pageSize=10;
						int currentPage=1;
						String currentPages = request.getParameter("currentPage");
						if(currentPages!=null) {
							currentPage =Integer.parseInt(currentPages);
						}
						pb = os.findOrderByState(currentPage,pageSize,session);
						
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					request.getSession().setAttribute("pb", pb);
					//request.getRequestDispatcher("/orderManager.jsp").forward(request, response);
					response.sendRedirect("./orderManager.jsp");
					return;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }else if("updateOrdstateConfirmReceipt".equals(action)) {
			 
			 int i=os.updateOrderstateConfiemReceipt(oid);
			 us.updateAdminBalanceReduce(count);
			 int j=us.updateStoreBalanceAdd(storeid, count);
			 if(i>0&&j>0) {
				 request.getRequestDispatcher("/OrderServlet?action=findOrderByState").forward(request, response);
				//response.sendRedirect("/orderManager.jsp");
				 return;
			 }
		 }else if("updateOrderstateAppraise".equals(action)) {
			int i= os.updateOrderstateAppraise(oid);
			 if(i>0) {
				 request.getRequestDispatcher("/OrderServlet?action=findOrderByState").forward(request, response);
				//response.sendRedirect("/orderManager.jsp");
					 return;
				}
			 
		 }else if("backstageFindOrderByState".equals(action)) {
			 try {
	    		  
	    		  PageBean<Order> pb= null;
					try {
						//meinvs = ms.findAll();
						int pageSize=10;
						int currentPage=1;
						String currentPages = request.getParameter("currentPage");
						if(currentPages!=null) {
							currentPage =Integer.parseInt(currentPages);
						}
						pb = os.backstageFindOrderByState(currentPage,pageSize,session);
						//System.out.println(pb);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					request.getSession().setAttribute("pb", pb);
					//request.getRequestDispatcher("/orderManager.jsp").forward(request, response);
					response.sendRedirect("./backstage/orderManager.jsp");
					return;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		 }else if("findOrderByOid".equals(action)){
			 Order order=os.findOrderByOid(oid);
			 if(order!=null) {
				 request.getSession().setAttribute("order", order);
				 //request.getRequestDispatcher("/orderDetails.jsp").forward(request, response);
				 response.sendRedirect("./orderDetails.jsp");
			 }else {
				 response.getWriter().write("商品已过期，1秒后跳转");
			     response.setHeader("refresh", "1:url="+request.getContextPath()+"/OrderServlet?action=findOrderByState");
			 }
		 }else if("delOrderByOid".equals(action)){
			 os.delOrderByOid(oid);
			 request.getRequestDispatcher("/OrderServlet?action=findOrderByState").forward(request, response);
		 }else if("updateOrder".equals(action)) {
			 Order order=os.findOrderByOid(oid);
			 request.getSession().setAttribute("order", order);
			 response.sendRedirect("./backstage/updateOrder.jsp");
		 }else if("backstageUpdateOrder".equals(action)) {
			 String uname=request.getParameter("uname");
			 String address=request.getParameter("address");
			 String telephone=request.getParameter("telephone");
			 String remark=request.getParameter("remark");
			 os.updateOrder(oid, uname, address, telephone,remark);
			 request.getRequestDispatcher("/OrderServlet?action=backstageFindOrderByState").forward(request, response);
		 }else if("backstageUpdateOrderCount".equals(action)) {
			 os.backstageUpdateOrderCount(oid);
			 request.getRequestDispatcher("/OrderServlet?action=backstageFindOrderByState").forward(request, response);
		 }else if("orderChart".equals(action)) {
			 String goodsname=request.getParameter("goodsname");
			 String year=request.getParameter("year");
			 List<Bar> lb=os.orderChart(goodsname, year, session);
			 //request.getSession().setAttribute("lb", lb);
			 // response.sendRedirect("./backstage/analyse2.jsp");
			 JSONArray json=JSONArray.fromObject(lb);
			 //System.out.println(json.toString());
		        //返回给前段页面
		       PrintWriter out = response.getWriter();  
		        out.println(json);  
		        out.flush();  
		        out.close(); 
			 //response.getWriter().write(json);
		 }else if("chartPie".equals(action)) {
			 String year = request.getParameter("yyy");
			//System.out.println(year);
			 List<Pie> lp = os.chartPie(year, session);
			 JSONArray json=JSONArray.fromObject(lp);
			 System.out.println(json.toString());
			 PrintWriter out = response.getWriter();  
		        out.println(json);  
		        out.flush();  
		        out.close(); 
		 }else if("updateOrderTh".equals(action)) {
			 us.thUpdatePtBalanceReduce(count);
			 us.thUpdateUserBalanceAdd(session, count);
			 gs.updateGoodsNumberAdd(number, goodsid);
			 os.thUpdateOrderOrderstate(oid);
			 request.getRequestDispatcher("/OrderServlet?action=findOrderByState").forward(request, response);
		 }
			 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
