package yntc.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import yntc.domain.Order;
import yntc.domain.PageBean;
import yntc.domain.User;
import yntc.service.UserService;
import yntc.service.impl.UserServiceImpl;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //设置请求响应编码为utf-8
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
	
	HttpSession session=request.getSession();
	String ids =request.getParameter("id"); 
	String name =request.getParameter("name");
	String email = request.getParameter("email");
	String username = request.getParameter("username");
	String qq = request.getParameter("qq");
	String telphone = request.getParameter("telphone");
	String action = (String)request.getParameter("action");
	Integer id=null;
	if(ids!=null&&!"".equals(ids)) {
		 id = Integer.parseInt(ids);
	}
	 //System.out.println("hhhhhhhhhhh");
	 //System.out.println(id);
	 //System.out.println(name);
	UserService us = new UserServiceImpl();
	
	if("updateUser".equals(action)) {
		//User user = packUser(request);
		int i= us.updateUser(name,email,username,qq,telphone,id);
		if(i>0) {
		response.getWriter().write("修改信息成功");
		response.setHeader("refresh", "1;url="+request.getContextPath()+"/UserServlet?action=findUserById&id="+id);
		return;
		}else {
			response.getWriter().write("修改信息失败");
			response.setHeader("refresh", "1;url="+request.getContextPath()+"/backstage/merchant.jsp");
		}
	}else if("updateUserInfo".equals(action)) {
		int i= us.updateUser(name,email,username,qq,telphone,id);
		if(i>0) {
		response.getWriter().write("修改信息成功");
		response.setHeader("refresh", "1;url="+request.getContextPath()+"/UserServlet?action=FindUserById&id="+id);
		return;
		}else {
			response.getWriter().write("修改信息失败");
			response.setHeader("refresh", "1;url="+request.getContextPath()+"personalCenter.jsp");
		}
	}else if("findUserById".equals(action)) {
		  User user=us.findUserById(id);
		  request.getSession().setAttribute("user", user);
		  request.getRequestDispatcher("/backstage/personalInfo.jsp").forward(request, response);
		  return;
	}else if("FindUserById".equals(action)) {
		  User user=us.findUserById(id);
		  request.getSession().setAttribute("user", user);
		  //request.getRequestDispatcher("/personalInfo.jsp").forward(request, response);
		  response.sendRedirect("./personalInfo.jsp");
		  return;
	}else if("updateUserBalanceReduce".equals(action)) {
		String Totalprice=request.getParameter("totalprice");
		Integer totalprice=null;
		if(Totalprice!=null && !"".equals(Totalprice)) {
			totalprice=Integer.parseInt(Totalprice);
		}
		//System.out.println(totalprice);
		us.updateUserBalanceReduce(session,totalprice);
		us.updateAdminBalanceAdd(totalprice);
		//System.out.println("ll");
		//System.out.println(i);
		request.getRequestDispatcher("/CartServlet?action=clickShopping").forward(request, response);
	 }else if("updateStoreBalanceAdd".equals(action)) {
		 String Storeid =request.getParameter("storeid");
		 String Count =request.getParameter("count");
		 String Oid =request.getParameter("oid");
		 Integer oid=null;
		 if(Oid!=null && !"".equals(Oid)) {
			 oid =Integer.parseInt(Oid);
		 }
		 Integer storeid=null;
		 Integer count=null;
		 if(Storeid!=null &&!"".equals(Storeid)) {
			 storeid=Integer.parseInt(Storeid);
		 }
		 if(Count!=null &&!"".equals(Count)) {
			 count=Integer.parseInt(Count);
		 }
		 int i=us.updateAdminBalanceReduce(count);
		 int j=us.updateStoreBalanceAdd(storeid, count);
		 if(i>0&&j>0) {
			 response.getWriter().write("收款成功，1秒后跳转 ");
			 response.setHeader("refresh", "1;url="+request.getContextPath()+"/OrderServlet?action=backstageUpdateOrderCount&oid="+oid);
		 }
	 }else if("findUserByRole".equals(action)) {
		 try {
   		  
   		  PageBean<User> pb= null;
				try {
					int pageSize=10;
					int currentPage=1;
					String currentPages = request.getParameter("currentPage");
					if(currentPages!=null) {
						currentPage =Integer.parseInt(currentPages);
					}
					pb = us.findUserByRole(currentPage,pageSize);
					//System.out.println(pb);
				} catch (Exception e) {
					e.printStackTrace();
				}
				 request.getSession().setAttribute("pb", pb);
				 int balance=us.adminBalance();
				 request.getSession().setAttribute("balance", balance);
				 //request.getRequestDispatcher("UserServlet?action=queryAdminBalance").forward(request, response);
				 response.sendRedirect("./backstage/admin/userManager.jsp");
				return;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }else if("updateUserState".equals(action)) {
		us.upodateUserState(id); 
		request.getRequestDispatcher("UserServlet?action=findUserByRole").forward(request, response);
	 }else if("findStoreName".equals(action)) {
		 List<User> lu=us.findStoreByRole();
		 request.getSession().setAttribute("lu", lu);
		 response.sendRedirect("./storeStreet.jsp");
	 }else if("Recharge".equals(action)) {
		 String Recharge = request.getParameter("recharge");
		 Integer recharge=null;
		 if(Recharge!=null&&!"".equals(Recharge)) {
				recharge = Integer.parseInt(Recharge);
		 }
		 int i=us.recharge(session, recharge);
		 if(i>0) {
			 response.getWriter().write("充值成功，1秒后跳转 ");
			 response.setHeader("refresh", "1;url="+request.getContextPath()+"/personalCenter.jsp");
		 }
	 }
 }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
