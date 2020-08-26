package yntc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

import yntc.domain.User;
import yntc.service.UserService;
import yntc.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         request.setCharacterEncoding("utf-8");
         response.setContentType("text/html;charset=utf-8");
         //获取表单连接
         String username = request.getParameter("username");
         String password = request.getParameter("password");
         String checkCode = request.getParameter("checkcode");
         String code = (String) request.getSession().getAttribute("code");
         String CheckBox = request.getParameter("checkbox");
	    
         if(!checkCode.equals(code)) {
        	 request.setAttribute("msg", "验证码有误");
        	 request.getRequestDispatcher("login.jsp").forward(request, response);
        	 return;
         }
         
         //调用业务逻辑
         UserService us = new UserServiceImpl();
         try {
			User user =us.loginUser(username, password);
			/*if(user==null) {
				request.setAttribute("login_message", "登录失败，用户名或密码错误");
				request.getRequestDispatcher("login.jsp").forward(request, response);
	        	return;
			}*/
	        //登录成功，将用户存储到session中
			request.getSession().setAttribute("user", user);
			//获取用户角色 
			String role = user.getRole();
			//如果是管理员，就进入管理员界面，如果是商家就进入商家后台，否则进入用户界面
			if("0".equals(role)) {
				response.sendRedirect(request.getContextPath()+"/backstage/admin/merchant.jsp");
				return;
			}else if("1".equals(role)){
				//request.getSession().setAttribute("user", user);
				response.sendRedirect(request.getContextPath()+"/backstage/merchant.jsp");
				return;
			}else {
				response.sendRedirect(request.getContextPath()+"/GoodsServlet?action=findAll");
			}
			 if(user!=null) {
				  if(CheckBox!=null) {
					  Cookie cookie = new Cookie("user",username+"-"+password);
					  cookie.setPath("/");
					  cookie.setMaxAge(6000);
					  response.addCookie(cookie);
				  }
				  else {
					  Cookie cookie = new Cookie("user","");
					  cookie.setPath("/");
					  cookie.setMaxAge(0);
					  response.addCookie(cookie);
				  }
			 }
			request.getSession().setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("login_message", e.getMessage());
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
